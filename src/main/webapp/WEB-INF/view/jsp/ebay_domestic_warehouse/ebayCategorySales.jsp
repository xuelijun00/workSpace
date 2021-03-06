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
    <form class="form-inline">
        <div class="form-group">
        	<label>开始时间</label>
        	<input type="text" id="start_date" class="form-control" placeholder="" readonly="readonly">
        </div>
        <div class="form-group">
        	<label>结束时间</label>
        	<input type="text" id="end_date" class="form-control" placeholder="" readonly="readonly">
        </div>
         <div class="form-group">
         	<label>分类</label>
            <input type="text" class="form-control" placeholder="请输入内容" id="category" name="category"
            	_value=""/>
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
	var category = $('#category').val().trim();
	var url="";
	if(type === 1){
		url = contextPath + '/report/ebay_domestic/category/grid?business=ebay&startDate=' + startDate + "&endDate=" + endDate;
	}else{
		url = contextPath + '/report/ebay_domestic/category/chart?business=ebay&startDate=' + startDate + "&endDate=" + endDate;
	}
	if(category != null){
		url += "&category=" + category;
	}
	return url;
}

function queryData(){
	var operation = getChartData(getUrl());
	common.refreshData1(getUrl(1),chart,operation);
}

function getChartData(chartUrl){
	var categories = [];
	var salesAmount = [];
	var orders = [];

	$.ajax({
		url : chartUrl,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				for(var i=0;i<data.length;i++){
				  categories.push(data[i].category);
            	  salesAmount.push(data[i].sales);
            	  orders.push(data[i].orders);
	            }
			}
		}
	});

	var y = [{
        type: 'value',
        name: '销售额_美元',
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
		title:{text:"Ebay业务线每日销售数据"}
		,y:y
		,categories:categories
		,series:[{name:'销售额_美元',type: 'bar',data:salesAmount,tooltip: {valueSuffix: '' }, customColors: 1},
		         {name: '订单数',type: 'line',yAxisIndex: 1,data:orders,tooltip: {valueSuffix: '' }},]
	};
}

function exportData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "Ebay业务线每日品类销售数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '分类', '日期（day）', '订单数' ,'数量' ,'订单金额_美元'];
	var column = ['category','reportDate','orders','quantity','sales'];

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
		title:"Ebay业务线每日品类销售数据"
		,url:getUrl(1)
		,colNames:[ '分类', '日期（day）', '订单数' ,'数量' ,'订单金额_美元']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
			{name : 'category',index : 'category',width : 255}, 
            {name : 'reportDate',index : 'reportDate',align : "right",width : 205}, 
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
