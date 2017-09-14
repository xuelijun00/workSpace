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
                <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
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
function getUrl(type){//拼接url
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	if(type === 1){
		return contextPath + '/report/sales_performance/grid?business=Ebay_US&startDate=' + startDate + "&endDate=" + endDate;
	}else{
		return contextPath + '/report/sales_performance/chart?business=Ebay_US&startDate=' + startDate + "&endDate=" + endDate;
	}
}
function queryData(){
	var operation = getChartData(getUrl());
	common.refreshData1(getUrl(1),chart,operation);
}
function exportData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "Ebay海外仓美仓业绩数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '报表时间', '平台名称', '销售额_美元', '订单数'];
	var column = ['reportDate','business','sales','orders'];
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
	var reportDate = [];
	var salesAmount = [];
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
				  reportDate.push(data[i].reportDate);
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
		title:{text:"Ebay海外仓美仓业绩数据"}
		,categories:reportDate
		,y:y
		,series:[{name:'销售额_美元',type: 'bar',data:salesAmount,tooltip: {valueSuffix: '' }, customColors: 1},
		         {name: '订单数',type: 'line',yAxisIndex: 1,data:orders,tooltip: {valueSuffix: '' }},]
	};
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
	chart = common.echarts(getChartData(getUrl()));//chart
	common.grid({
		title:"Ebay海外仓美仓业绩数据"
		,url:getUrl(1)
		,colNames:[ '报表时间', '平台名称', '销售额_美元', '订单数']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
		             {name : 'reportDate',index : 'reportDate',width : 255}, 
		             {name : 'business',index : 'business',width : 205}, 
		             {name : 'sales',index : 'sales',width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}, 
		             {name : 'orders',index : 'orders',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"}
		           ]
		,sortname:"reportDate"
		,sortorder:"desc"
		,footerrow:true
		,userDataOnFooter:true
	});
})();
</script>
</body>
</html>
