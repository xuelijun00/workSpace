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
    <div class="ibox-title"><h5>各平台每日销售报表</h5></div>
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
                <label>平台：</label>
                <select class="form-control w120" id="platform" >
                </select>
            </div>
            <div class="form-group">
                <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
            </div>
            <div class="form-group">
                <button type="button" onclick="exportData()" class="btn btn-primary">导出</button>
            </div>
        </form>
        <div class="hr-line-dashed"></div>
        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
        <div class="ibox-title">
			<h5>表格</h5>
		</div>
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
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var platform = $("#platform").val();
	var url = "";
	if(type === 1){
		url = contextPath + '/report/dailysales/grid?st=' + startDate + "&et=" + endDate;
	}else{
		url = contextPath + '/report/dailysales/chart?st=' + startDate + "&et=" + endDate;
	}
	if(platform !== 'all'){
		url += "&business=" + platform;
	}
	return url;
}
function queryData(){
	var operation = getChartData(getUrl());
	common.refreshData(getUrl(1),chart,operation);
}
function exportData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "各平台每日销售报表" + startDate +"-"+ endDate + ".csv";
	var title = [ '报表时间', '平台名称', '销售额', '订单数'];
	var column = ['reportDate1','business','sales','orders'];
	exportDataToCSV('#list2',title,domesticData,fileName,column);
}
function getChartData(chartUrl){
	var reportDate = [];
	var salesAmount = [];
	var orders = [];
	$.ajax({
		url : chartUrl,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				domesticData = data;
				for(var i=0;i<data.length;i++){
				  reportDate.push(data[i].reportDate1 + "<br/>" + data[i].business);
            	  salesAmount.push(data[i].sales);
            	  orders.push(data[i].orders);
	            }
			}
		}
	});
	var y = [{labels: {format: '{value}',style: { color: Highcharts.getOptions().colors[0]}},title: {text: '销售额',style: {color: Highcharts.getOptions().colors[0]}}}
	,{labels: {format: '{value}',style: { color: Highcharts.getOptions().colors[1]}},title: {text: '订单数',style: {color: Highcharts.getOptions().colors[1]}},opposite: true}];
	return {
		title:{text:"各平台每日销售报表"}
		,categories:reportDate
		,y:y
		,series:[{name:'销售额',type: 'column',data:salesAmount,tooltip: {valueSuffix: '' }},
		         {name: '订单数',type: 'spline',yAxis: 1,data:orders,tooltip: {valueSuffix: '' }},]
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
	$.ajax({
		url : contextPath + "/report/dailysales/platforms",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#platform").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#platform").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	chart = common.chart(getChartData(getUrl()));//chart
	common.grid({
		title:"各平台每日销售报表"
		,url:getUrl(1)
		,colNames:[ '报表时间', '平台名称', '销售额', '订单数']
		,colModel:[ {name : 'reportDate1',index : 'reportDate1',width : 255}, 
		             {name : 'business',index : 'business',width : 205}, 
		             {name : 'sales',index : 'sales',width : 205}, 
		             {name : 'orders',index : 'orders',sortable : "true",width : 205}]
		,sortname:"reportDate1"
		,sortorder:"asc"
	});
})();
</script>
</body>
</html>
