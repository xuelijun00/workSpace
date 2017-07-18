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
              <input type="text" id="start_date"class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date" class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
                <label>平台：</label>
                <select class="form-control w120" id="platform" name="platform">
                </select>
            </div>
             <div class="form-group">
            <label>SKU</label>
                        <input type="text" class="form-control" placeholder="请输入内容" id="sku" name="sku"
                               _value=""/>
            </div>
            <div class="form-group">
            <label>原始SKU</label>
                        <input type="text" class="form-control" placeholder="请输入内容" id="oldsku" name="oldsku"
                               _value=""/>
            </div>
           <!--  <div class="form-group">
                <label>账号：</label>
                <input id="account_input" list="account" />
				<datalist id="account"></datalist>
            </div> -->
            
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

function getUrl(type){	
	var sku = encodeURIComponent($("#sku").val());
	var oldsku = encodeURIComponent($("#oldsku").val());
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var platform = $("#platform").val();
	var chartUrl = "";
	if(type === 1){ 	
		chartUrl = contextPath + '/report/ebay_domestic/skunew/grid?st=' + startDate + '&et=' + endDate+ "&oldsku=" + oldsku+ "&sku=" + sku;
	}else{
		chartUrl = contextPath + '/report/ebay_domestic/skunew/chart?st=' + startDate + '&et=' + endDate+ "&oldsku=" + oldsku+ "&sku=" + sku;
	}
	if(platform !== 'all'){chartUrl += "&business=" + platform;}
	return chartUrl;
}

function exportData(){
	var sku = encodeURIComponent($('#sku').val());
	var oldsku = encodeURIComponent($('#oldsku').val());
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var business = $("#platform").val();
	var fileName = "newegg业务线每日sku销售数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '业务线', 'sku', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元'];
	var column = ['business', 'sku','skuOld','reportDate1','orders','quantity','sales'];
	$.ajax({
		url : getUrl(),
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.rows.length > 0){
				domesticData = data.rows;
			}
		}
	});
	//debugger;
	exportDataToCSV('#list2',title,domesticData,fileName,column);
}

function queryData(){
	var operation = getChartData(getUrl());
	common.refreshData(getUrl(1),chart,operation);
}

function getChartData(chartUrl){
	var reportDate = [];
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
				  reportDate.push(data[i].reportDate1+"<br/>"+ data[i].sku+"<br/>"+ data[i].business);
				  sales.push(data[i].sales);
            	  orders.push(data[i].orders);
	            }
			}
		}
	});
	var y = [{labels: {format: '{value}',style: { color: Highcharts.getOptions().colors[0]}},title: {text: '订单数',style: {color: Highcharts.getOptions().colors[0]}}}
	,{labels: {format: '{value}',style: { color: Highcharts.getOptions().colors[1]}},title: {text: '订单金额_美元',style: {color: Highcharts.getOptions().colors[1]}},opposite: true}];
	return {
		title:{text:"新平台业务线每日sku销售数据"}
		,categories:reportDate
		,y:y
		,series:[{name: '订单数',type: 'column',data:orders,tooltip: {valueSuffix: '' }},
			{name:'订单金额_美元',type: 'spline',yAxis: 1,data:sales,tooltip: {valueSuffix: '' }},]
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
	
	$.ajax({
		url : contextPath + "/report/ebay_domestic/skuplatforms/platformnew",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#platform").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#platform").append("<option value='"+ data[i].business +"'>"+ data[i].business +"</option>");
				}
			}
		}
	});
	
	/* $("#query").bind("click",function(){
		var operation = getChartData(getUrl());
		common.refreshData(getUrl(1),chart,operation);
	});
	
	$("#export").bind("click",function(){
		chartUrl = getUrl(); 
		$.ajax({
			url : chartUrl,
			cache : false,
			type:"get",
			async: false,
			success : function(data) {
				if(data != null && data.rows.length > 0){
					domesticData = data.rows;
				}
			}
		}); 
		
		var fileName = "新平台业务线每日sku销售数据.csv";
		var title = ['业务线', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元'];
		var column = ['business','skuOld','reportDate1','orders','quantity','sales'];
		
		exportDataToCSV('#list2',title,domesticData,fileName,column);
	});*/
	
	chart = common.chart(getChartData(getUrl()));//chart
	common.grid({
		title:"新平台业务线每日sku销售数据"
		,url:getUrl(1)
		,colNames:[ '业务线','sku', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
			{name : 'business',index : 'business',width : 175}, 
			{name : 'sku',index : 'sku',width : 215}, 
            {name : 'skuOld',index : 'skuOld',width : 175}, 
            {name : 'reportDate1',index : 'reportDate1',align : "right",width : 175}, 
            {name : 'orders',index : 'orders',sortable : "true",width : 145,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
            {name : 'quantity',index : 'quantity',sortable : "true",width : 145,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
            {name : 'sales',index : 'sales',sortable : "true",width : 155,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}
		           ]
		,sortname:"reportDate1"
		,sortorder:"desc"
	});
})();
</script>
</body>
</html>
