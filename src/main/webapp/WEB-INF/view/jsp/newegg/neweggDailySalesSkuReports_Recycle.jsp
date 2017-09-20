<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/8
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<title>YKSUI框架 - 需求管理</title>
</head>
<body class="gray-bg">

<div class="wrapper wrapper-content">
    <div class="ibox-content">
    	<!-- 折线图的查询条件 --> 	
    	<form class="form-inline">
           <div class="form-group">
             <label>开始时间</label>
             <input type="text" id="start_date2" class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
             <label>结束时间</label>
             <input type="text" id="end_date2" class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
	           <label class="control-label">*SKU：</label>
	           	<textarea class="form-control" rows="3" cols="40" id="sku2" name="sku"  
	           	placeholder="查询多个sku时，请用逗号或者空格或者换行符（回车）分隔开，支持excel多行粘贴" onblur="common.addComma1(2)" ></textarea>
           </div>
           <div class="form-group">
              <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
           </div>
        </form>	
        <hr style="border-top:1px dashed #E7EAEC;"/>
        <h2 class="text-center">新蛋业务线sku环比增长数据折线图</h2>
		<div class="hr-line-dashed"></div>
        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

       <!--  表格的查询条件 -->
       <form class="form-inline">
        <div class="form-group">
              <label>开始时间</label>
              <input type="text" id="start_date1" class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date1" class="form-control" placeholder="" readonly="readonly">
            </div>
             <br/><br/>
             <div class="form-group">
                <label>平台：</label>
                <select class="form-control w120" id="platform1" >
                </select>
            </div>
            <div class="form-group">
	           <label class="control-label">SKU：</label>
	           <textarea class="form-control" rows="3" cols="40" id="sku1" name="sku"  
	           placeholder="查询多个sku时，请用逗号或者空格或者换行符（回车）分隔开，支持excel多行粘贴" onblur="common.addComma1(1)" ></textarea>
            </div>
        	<div class="form-group">
              <button type="button" onclick="queryData(1)" class="btn btn-primary">查询</button>
           </div>
           <div class="form-group">
               <button type="button" id="export" onclick="exportData()" class="btn btn-primary">导出</button>
           </div>
       </form>	
		<div class="ibox-ccontent">
			<table id="list2" class="tablegrid"></table>
			<div id="pager2"></div>
		</div>
	</div> 
</div>
<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>
<!--加本页面 的js文件与js代码-->
<script type="text/javascript">
var chart;
var operation;
var domesticData = [];

function getUrl(type){//拼接url
	var sku = encodeURIComponent($('#sku' + type).val());
	var business = $("#platform" + type).val();
	var startDate = $("#start_date" + type).val();
	var endDate = $("#end_date" + type).val();
	var url = "";
	if(type === 1){ 	
		url = contextPath + '/report/sku_recycle/newEgg/grid?&startDate=' + startDate + "&endDate=" + endDate;
		if(business !== 'all' && business != null){
			url += "&business=" + business;
		}
	}else{
		url = contextPath + '/report/sku_recycle/newEgg/chart?&startDate=' + startDate + "&endDate=" + endDate;
	}

	if(sku !== 'all'  && sku != null){
		url += "&sku=" + sku;
	}
	return url;
}

function checkSkuIsNull(){
	var sku = $('#sku2').val();
	if(sku == ''){
		return true;
	}else{
		return false;
	}
}

function queryData(type){
	if(type === 1){
		common.refreshData(getUrl(1),chart,operation);
	}else if(checkSkuIsNull()){
		alert("折线图的sku为必填项，请填写sku");
		$('#sku2').focus();
	}else {
		common.echarts(getChartData(getUrl(2)));
	}
}

function exportData(){
	var domesticData = [];
	var startDate = $("#start_date1").val();
	var endDate = $("#end_date1").val();
	var business = $("#platform1").val();
	var fileName = "新蛋业务线sku环比增长数据" + startDate +"-"+ endDate +"-"+ business + ".csv";
	var title = [ '平台/业务线', 'sku', '日期', '订单数' , '数量' , '订单金额_美元', '环比增长单数', '环比增长个数', '环比增长销售额_美元', '	环比增长率（美元）'];
	var column = [ 'business', 'sku', 'reportDate', 'orders', 'quantity', 'sales', 'recycleOrders', 'recycleQuantity', 'recycleSales', 'recycleRate'];
	$.ajax({
		url : getUrl(1),
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.rows.length > 0){
				domesticData = data.rows;
			}
		}
	});
	exportDataToCSV('#list2',title,domesticData,fileName,column);
}

function getChartData(chartUrl){
	var recycleSales = [];
	var recycleRate = [];
	var categories = [];
	$.ajax({
		url : chartUrl,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				domesticData = data;
				for(var i=0;i<data.length;i++){
				  categories.push(data[i].reportDate + '\n' +data[i].sku);
				  recycleSales.push(data[i].recycleSales);
				  recycleRate.push(data[i].recycleRate * 100);
	            }
			}
		}
	});
	var y = [{
        type: 'value',
        name: '环比增长销售额（美元）',
        position: 'left',
        axisLabel: {
            formatter: '{value} '
        }
    }, {
        type: 'value',
        name: '环比增长率（美元）',       
        position: 'right',
        axisLabel: {
            formatter: '{value} '
        }
    }];
	return {
		title:{text:'新蛋业务线sku环比增长数据'}
		,categories:categories
		,y:y
		,series:[{name:'环比增长销售额（美元）',type: 'bar',data:recycleSales,tooltip: {valueSuffix: '' }, customColors : 1, customOnZero : 1},
			 {name: '环比增长率（美元）',type: 'line',yAxisIndex: 1,data:recycleRate,tooltip: {valueSuffix: '' }}]
	};
}

(function(){	
	$("#start_date2").jeDate({
        isinitVal: true,
        initAddVal:{DD:"-1"},
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });
	$("#end_date2").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });
	
	$("#start_date1").jeDate({
        isinitVal: true,
        initAddVal:{DD:"-1"},
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });
	$("#end_date1").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });
	
	$.ajax({
		url : contextPath + '/report/sku_recycle/newEgg/business',
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#platform1").append("<option value='all'>全部</option>");
				$("#platform2").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#platform1").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
					$("#platform2").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	
/* 	chart = common.echarts(getChartData(getUrl()));//chart */
	common.grid({
		title:"新蛋业务线sku环比增长数据"
		,url:getUrl(1)
		,colNames:[ '平台/业务线', 'sku', '日期', '订单数' , '数量' , '订单金额_美元', '环比增长单数', '环比增长个数', '环比增长销售额_美元', '	环比增长率（美元）']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
			{name : 'business',index : 'business',width : 115},
			{name : 'sku',index : 'sku',width : 155}, 
	        {name : 'reportDate',index : 'reportDate',width : 125}, 
	        {name : 'orders',index : 'orders',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
	        {name : 'quantity',index : 'quantity',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
	        {name : 'sales',index : 'sales',sortable : "true",width : 150,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
	        {name : 'recycleOrders',index : 'recycleOrders',sortable : "true",width : 150,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
	        {name : 'recycleQuantity',index : 'recycleQuantity',sortable : "true",width : 150,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
	        {name : 'recycleSales',index : 'recycleSales',sortable : "true",width : 195,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
	        {name : 'recycleRate',index : 'recycleRate',sortable : "true",width : 185,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:6},align:"right"},
	        ]
		,sortname:"reportDate"
		,sortorder:"desc"
		,shrinkToFit:true
		,autoScroll:true
	});
})();
</script>
</body>
</html>