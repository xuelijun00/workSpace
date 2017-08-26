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
            <label>*SKU：</label>
               <input type="text" class="form-control" placeholder="不填这里不给图" id="sku2" name="sku"
               	_value=""/>
           </div>
           <!-- <div class="form-group">
           <label>原始SKU：</label>
               <input type="text" class="form-control" placeholder="请输入内容" id="oldsku2" name="oldsku"
               	_value=""/>
           </div> -->
           <div class="form-group">
              <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
           </div>
        </form>	
        <hr style="border-top:1px dashed #E7EAEC;"/>
        <h2 class="text-center">Amazon业务线sku环比增长数据折线图</h2>
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
              <div class="form-group">
             <label>SKU：</label>
                <input type="text" class="form-control" placeholder="请输入内容" id="sku1" name="sku"
                	_value=""/>
            </div>
            <div class="form-group">
            <label>原始SKU：</label>
                <input type="text" class="form-control" placeholder="请输入内容" id="oldsku1" name="oldsku"
                	_value=""/>
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
	var oldsku = encodeURIComponent($('#oldsku' + type).val());
	var startDate = $("#start_date" + type).val();
	var endDate = $("#end_date" + type).val();
	if(type === 1){ 	
		return contextPath + '/report/sku_recycle/amazon/grid?&startDate=' + startDate + "&endDate=" + endDate+ "&skuOld=" + oldsku+ "&sku=" + sku;
	}else{
		return contextPath + '/report/sku_recycle/amazon/chart?&startDate=' + startDate + "&endDate=" + endDate+ "&sku=" + sku;
	}
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
/* 	var operation = getChartData(getUrl());
	common.refreshData1(getUrl(1),chart,operation); */
}

function exportData(){
	var domesticData = [];
	var startDate = $("#start_date1").val();
	var endDate = $("#end_date1").val();
	var fileName = "Amazon业务线sku环比增长数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '平台/业务线', 'sku', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元'];
	var column = [ 'business', 'sku','skuOld','reportDate','orders','quantity','sales'];
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
	var sales = [];
	var orders = [];
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
				  sales.push(data[i].sales);
            	  orders.push(data[i].orders);
	            }
			}
		}
	});
	var y = [{
        type: 'value',
        name: '订单金额_美元',
        position: 'left',
        axisLabel: {
            formatter: '{value} '
        }
    }, {
        type: 'value',
        name: '订单数',       
        position: 'right',
        axisLabel: {
            formatter: '{value} '
        }
    }];
	return {
		title:{text:'Amazon业务线sku环比增长数据'}
		,categories:categories
		,y:y
		,series:[{name:'订单金额_美元',type: 'line',data:sales,tooltip: {valueSuffix: '' }},
			{name: '订单数',type: 'line',yAxisIndex: 1,data:orders,tooltip: {valueSuffix: '' }}]
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
	
/* 	chart = common.echarts(getChartData(getUrl()));//chart */
	common.grid({
		title:"Amazon业务线sku环比增长数据"
		,url:getUrl(1)
		,colNames:[ '平台/业务线', 'sku', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
			{name : 'business',index : 'business',width : 135},
			{name : 'sku',index : 'sku',width : 255}, 
            {name : 'skuOld',index : 'skuOld',width : 205}, 
            {name : 'reportDate',index : 'reportDate',align : "right",width : 275}, 
            {name : 'orders',index : 'orders',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
            {name : 'quantity',index : 'quantity',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
            {name : 'sales',index : 'sales',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}
		           ]
		,sortname:"reportDate"
		,sortorder:"desc"
	});
})();
</script>
</body>
</html>