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
	<div class="ibox-title"><h5>Ebay业务线品类净利数据(注意：本页面货币的单位，均为美元)</h5></div>
    <div class="ibox-content">
    <form class="form-inline">
        <div class="form-group">
        	<label>开始时间</label>
        	<input type="text" id="start_date" class="form-control" placeholder="" readonly="readonly">
        </div>
        <div class="form-group">
        	<label>结束时间</label>
        	<input type="text" id="end_date" class="form-control" placeholder="" readonly="readonly">
        </div>
        <br/><br/>
        <div class="form-group">
         	<label>分类</label>
            <input type="text" class="form-control" placeholder="请输入内容" id="category" name="category"
            	_value=""/>
        </div>
        <div class="form-group">
        	<label class="control-label">SKU：</label>
      		<textarea class="form-control" rows="3" cols="40" id="sku" name="sku"  
      			placeholder="查询多个sku时，请用逗号或者空格或者换行符（回车）分隔开，支持excel多行粘贴" onblur="common.addComma()" ></textarea>
        </div>
        <div class="form-group">
           <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
        </div>
         <div class="form-group">
            <button type="button" id="export" onclick="exportData()" class="btn btn-primary">导出</button>
        </div>
    </form>
	</div>
	<div class="hr-line-dashed"></div>
	<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	<div class="ibox-content">
		<table id="list2" class="tablegrid"></table>
		<div id="pager2"></div>
	</div>
</div>

<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>
<!--加本页面 的js文件与js代码-->
<script type="text/javascript">
var chart;
var domesticData = [];
function getUrl(type){//拼接url
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var category = encodeURIComponent($('#category').val());
	var sku = encodeURIComponent($('#sku').val());
	var url="";
	if(type === 1){
		url = contextPath + '/report/category_profit/grid?business=ebay&startDate=' + startDate + "&endDate=" + endDate;
	}else{
		url = contextPath + '/report/category_profit/chart?business=ebay&startDate=' + startDate + "&endDate=" + endDate;
	}
	if(category != ''){
		url += "&category=" + category;
	}
	if(sku != ''){
		url += "&sku=" + sku;
	}
	return url;
}

function queryData(){
	var operation = getChartData(getUrl());
	common.refreshData1(getUrl(1),chart,operation);
}

function getChartData(chartUrl){
	var categories = [];
	var productTotalCnyAmount = [];
	var netProfitAmount = [];

	$.ajax({
		url : chartUrl,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				for(var i=0;i<data.length;i++){
				  categories.push(data[i].category);
				  productTotalCnyAmount.push(data[i].productTotalCny);
				  netProfitAmount.push(data[i].netProfit);
	            }
			}
		}
	});

	var y = [{
        type: 'value',
        name: '发货收入',
        position: 'left',
        axisLabel: {
            formatter: '{value} '
        }
    }, {
        type: 'value',
        name: '税后综合净利',       
        position: 'right',
        axisLabel: {
            formatter: '{value} '
        }
    }];

	return {
		title:{text:"Ebay业务线品类净利数据"}
		,y:y
		,categories:categories
		,series:[{name:'发货收入',type: 'bar',data:productTotalCnyAmount,tooltip: {valueSuffix: '' }},
		         {name: '税后综合净利',type: 'bar',yAxisIndex: 1,data:netProfitAmount,tooltip: {valueSuffix: '' }},]
	};
}

function exportData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "Ebay业务线品类净利数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '业务线', '分类', '日期（day）', 'sku', 'sku中文名', '发货数量' ,'发货收入_美元' ,'税后综合净利_美元'];
	var column = ['business','category','reportDate','sku','skuCnname','orderNum','productTotalCny','netProfit'];

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

(function(){
	$("#start_date").jeDate({
        isinitVal: true,
        initAddVal:{DD:"-14"},
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });
	$("#end_date").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });

/* 	var category = $('#category').val();
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var chartUrl =  contextPath + '/report/ebay_domestic/category/grid?business=ebay&startDate=' + startDate + "&endDate=" + endDate;
	var series = []; */

	chart = common.echarts(getChartData(getUrl()));//chart
	common.grid({
		title:"Ebay业务线品类净利数据"
		,url:getUrl(1)
		,colNames:[ '业务线', '分类', '日期（day）', 'sku', 'sku中文名', '发货数量' ,'发货收入_美元' ,'税后综合净利_美元']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
			{name : 'business',index : 'business',width : 80}, 
			{name : 'category',index : 'category',width : 120}, 
            {name : 'reportDate',index : 'reportDate',width : 110}, 
            {name : 'sku',index : 'sku',width : 100}, 
            {name : 'skuCnname',index : 'skuCnname',width : 200}, 
            {name : 'orderNum',index : 'orderNum',sortable : "true",width : 85,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
            {name : 'productTotalCny',index : 'productTotalCny',sortable : "true",width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"},
            {name : 'netProfit',index : 'netProfit',sortable : "true",width : 150,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}
		           ]
		,sortname:"reportDate"
		,sortorder:"desc"
	});
})();
</script>
</body>
</html>
