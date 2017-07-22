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
<!--加css-->
</head>
<body class="gray-bg">

<div class="wrapper wrapper-content">
    <div class="ibox-title"><h5>国内仓各平台发货数据报表</h5></div>
    <div class="ibox-content">
    <form class="form-inline">
            <div class="form-group">
              <label>开始时间</label>
              <input type="text" id="start_date"class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date" class="form-control" placeholder="" readonly="readonly">
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
var platformData = [];
function getUrl(type){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var platform = $("#platform").val();
	if(type === 1){
		return contextPath + '/report/daily_out_report/platformCount/grid?startDate=' + startDate + "&startDate=" + endDate + "&platform=" + platform;
	}else{
		return contextPath + '/report/daily_out_report/platformCount/chart?startDate=' + startDate + "&startDate=" + endDate + "&platform=" + platform;
	}
}

function queryData(){
	var operation = getChartData(getUrl());
	common.refreshData(getUrl(1),chart,operation);
}

function exportData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "国内仓各平台发货数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '日期','平台', '发货单数', '客单价', '发货收入', '退款', '成本', '毛利', '运费', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税后综合净利', '税后综合利润率'];
	var column = ['reportDate','platform','orderNum','unitPrice','productTotalCny','productRefund','orderPrice','grossProfit','productShipping'
	              ,'platformCost','materialCost','orderExecutionFee','operatingCost','profitMargin','profit','netProfitMargin'];
	exportDataToCSV('#list2',title,platformData,fileName,column);
}
function getChartData(chartUrl){
	var profit=[];            //税后综合净利
	var netProfitMargin=[];   //税后综合利润率
	var orderNum=[];          //发货单数
	var productTotalCny=[];   //发货收入
	var unitPrice=[];         //客单价
	var grossProfit=[];       //毛利
	var categories = [];
	$.ajax({
		url : chartUrl,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				platformData = data;
				for(var i=0;i<data.length;i++){
					categories.push(data[i].platform);
					orderNum.push(data[i].orderNum);
					unitPrice.push(data[i].unitPrice);
					productTotalCny.push(data[i].productTotalCny);
					grossProfit.push(data[i].grossProfit);
					profit.push(data[i].profit);
					netProfitMargin.push(data[i].netProfitMargin);	
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
		title:{text:"国内仓各平台发货数据"}
		,categories:categories
		,y:y
		,series:[{name:'发货单数',type: 'column',data:orderNum,tooltip: {valueSuffix: '' }},
				 {name:'客单价',type: 'column',data:unitPrice,tooltip: {valueSuffix: '' }},
		         {name: '发货收入',type: 'column',data:productTotalCny,tooltip: {valueSuffix: '' }},
		         {name: '毛利',type: 'column',data:grossProfit,tooltip: {valueSuffix: '' }},
		         {name: '税后综合净利',type: 'column',data:profit,tooltip: {valueSuffix: '' }},
		         {name: '税后综合利润率',type: 'spline',yAxis: 1,data:netProfitMargin,tooltip: {valueSuffix: '' }},]
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
		url : contextPath + "/report/sales_performance/platforms",
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
		title:"国内仓各平台发货数据 "
		,url:getUrl(1)
		,colNames:[ '日期','平台', '发货单数', '客单价', '发货收入', '退款', '成本', '毛利', '运费', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税后综合净利', '税后综合利润率']
		,colModel:[ {name : 'reportDate',index : 'reportDate',width : 120}, 
		            {name : 'platform',index : 'platform',width : 100},
		             {name : 'orderNum',index : 'orderNum',width : 100,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ','}}, 
		             {name : 'unitPrice',index : 'unitPrice',sortable : "true",width : 100,align:"right",formatter:'float', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'productTotalCny',index : 'productTotalCny',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'productRefund',index : 'productRefund',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'orderPrice',index : 'orderPrice',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'grossProfit',index : 'grossProfit',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'productShipping',index : 'productShipping',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'platformCost',index : 'platformCost',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'materialCost',index : 'materialCost',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'orderExecutionFee',index : 'orderExecutionFee',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'operatingCost',index : 'operatingCost',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'profitMargin',index : 'profitMargin',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'profit',index : 'profit',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'netProfitMargin',index : 'netProfitMargin',width : 120,align:"right",formatter:'float', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
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
