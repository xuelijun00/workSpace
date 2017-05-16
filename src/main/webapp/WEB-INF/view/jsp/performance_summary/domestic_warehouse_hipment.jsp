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
    <div class="ibox-title"><h5>国内仓发货汇总数据</h5></div>
    <div class="ibox-content">
    <form class="form-inline">
            <div class="form-group">
              <label>开始时间</label>
              <input type="text" id="start_date"class="form-control" placeholder="">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date" class="form-control" placeholder="">
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary" onclick="queryData()">查询</button>
            </div>
            <div class="form-group">
                <button type="button" id="export" onclick="exportData()" class="btn btn-primary">导出</button>
            </div>
        </form>
        <div class="hr-line-dashed"></div>
        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		<div class="ibox-content">
			<table id="list2" class="tablegrid"></table>
			<div id="pager2"></div>
		</div>
</div>
</div>
<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>
<!--加本页面 的js文件与js代码-->
<script type="text/javascript">
var chart;
var domesticData = [];
function getUrl(type){
	if(type === 1){
		return chartUrl =  contextPath + '/report/warehouse_shipment/domesticsum/grid?startDate=' + $("#start_date").val() + "&endDate=" + $("#end_date").val();	
	}else{
		return chartUrl =  contextPath + '/report/warehouse_shipment/domesticsum/chart?startDate=' + $("#start_date").val() + "&endDate=" + $("#end_date").val();
	}
	
}
function queryData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var operation = getChartData(getUrl());
	common.refreshData(getUrl(1),chart,operation);
}
function exportData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "国内仓各平台每日发货汇总数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '平台名称', '日期(day)', '发货单数', '发货收入','税前综合净利', '税前综合利润率'];
	var column = ['netProfit','netProfitMargin','orderNum','platform','reportDate1','productTotalCny'];
	exportDataToCSV('#list2',title,domesticData,fileName,column);
}
function getChartData(chartUrl){
	var netProfit=[];//税前综合净利
	var netProfitMargin=[];//税前综合利润率
	var orderNum=[];//发货单数
	var productTotalCny=[];//发货收入
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
					categories.push(data[i].reportDate1);
					netProfit.push(data[i].netProfit);
					netProfitMargin.push(data[i].netProfitMargin);
					orderNum.push(data[i].orderNum);
					productTotalCny.push(data[i].productTotalCny);
				}
			}
		}
	});
	var y = [{
        labels: {format: '{value}',style: { color: Highcharts.getOptions().colors[0]}},
        title: {text: '刻度',style: {color: Highcharts.getOptions().colors[0]}}
    },{
        labels: {format: '{value}',style: { color: Highcharts.getOptions().colors[1]}},
        title: {text: '率',style: {color: Highcharts.getOptions().colors[1]}},
        opposite: true
    }];
	return {
		title:{text:"国内仓发货汇总数据"}
		,categories:categories
		,y:y
		,series:[{name:'发货单数',type: 'column',data:orderNum,tooltip: {valueSuffix: '' }},
		         {name: '发货收入',type: 'column',data:productTotalCny,tooltip: {valueSuffix: '' }},
		         {name: '税前综合净利',type: 'column',data:netProfit,tooltip: {valueSuffix: '' }},
		         {name: '税前综合利润率',type: 'spline',yAxis: 1,data:netProfitMargin,tooltip: {valueSuffix: '' }},]
	};
}
(function(){
	$("#start_date").jeDate({
        isinitVal: true,
        initAddVal:{DD:"-7"},
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
	
	chart = common.chart(getChartData(getUrl()));//chart
	common.grid({
		title:"国内仓发货汇总数据"
		,url:getUrl(1)
		,colNames:[ '平台名称', '日期(day)', '发货单数', '发货收入','税前综合净利', '税前综合利润率']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
		             {name : 'platform',index : 'platform',width : 80}, 
		             {name : 'reportDate1',index : 'reportDate1',width : 105}, 
		             {name : 'orderNum',index : 'orderNum',align : "right",width : 105}, 
		             {name : 'productTotalCny',index : 'productTotalCny',align : "right",width : 105}, 
		             {name : 'netProfit',index : 'netProfit',align : "right",width : 120}, 
		             {name : 'netProfitMargin',index : 'netProfitMargin',align : "right",width : 130}
		           ]
		,sortname:"reportDate1"
		,sortorder:"asc"
	});
})();
</script>
</body>
</html>
