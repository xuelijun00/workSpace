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
    <div class="ibox-title"><h5>各平台各账号业绩</h5></div>
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
                <label>账号：</label>
                <input id="account_input" list="account" />
				<datalist id="account"></datalist>
            </div>
            
            <div class="form-group">
                <button type="button" id="query"  class="btn btn-primary">查询</button>
            </div>
            <div class="form-group">
                <button type="button"  id="export" class="btn btn-primary">导出</button>
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
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var platform = $("#platform").val();
	var account = $("#account_input").val();
	var url = "";
	if(type === 1){
		url = contextPath + '/report/account_achievement/grid?startDate=' + startDate + '&endDate=' + endDate;
	}else{
		url = contextPath + '/report/account_achievement/chart?startDate=' + startDate + '&endDate=' + endDate;
	}
	if(platform !== 'all'){url += "&business=" + platform;}
	if(account !== 'all' && account.length > 0){url += "&account=" + account;}
	return url;
}

function getChartData(chartUrl){
	var account = [];
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
				  account.push(data[i].account);
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
	/* var y = [{labels: {format: '{value}',style: { color: Highcharts.getOptions().colors[0]}},title: {text: '销售额_美元',style: {color: Highcharts.getOptions().colors[0]}}}
	,{labels: {format: '{value}',style: { color: Highcharts.getOptions().colors[1]}},title: {text: '订单数',style: {color: Highcharts.getOptions().colors[1]}},opposite: true}]; */
	/* return {
		title:{text:"各平台各账号业绩"}
		,categories:reportDate
		,y:y
		,series:[{name:'销售额_美元',type: 'column',data:salesAmount,tooltip: {valueSuffix: '' }},
		         {name: '订单数',type: 'spline',yAxis: 1,data:orders,tooltip: {valueSuffix: '' }},]
	}; */
	return {
		title:{text:"各平台各账号业绩"}
		,categories:account
		,y:y
		,series:[{name:'销售额_美元',type: 'bar',data:salesAmount,tooltip: {valueSuffix: '' }, customColors: 1},
		         {name: '订单数',type: 'line',yAxisIndex: 1,data:orders,tooltip: {valueSuffix: '' }},]
	};
}
(function(){
	$("#start_date").jeDate({
        isinitVal: true,
        initAddVal:{DD:"-15"},
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
		url : contextPath + "/report/account_achievement/platform",
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
	$("#platform").bind("change",function(){
		var platform = $("#platform").val();
		if(platform == 'all'){
			platform = '';
		}
		$.ajax({
			url : contextPath + "/report/account_achievement/account?business=" + platform,
			cache : false,
			type:"get",
			async: false,
			success : function(data) {
				if(data != null && data.length > 0){
					$("#account").empty();
					for(var i=0;i<data.length;i++){
						$("#account").append("<option value='"+ data[i] +"'> </option>");
					}
				}
			}
		});
	});
	$("#query").bind("click",function(){
		var operation = getChartData(getUrl());
		common.refreshData1(getUrl(1),chart,operation);
	});
	$("#export").bind("click",function(){
		var startDate = $("#start_date").val();
		var endDate = $("#end_date").val();
		var platform = $("#platform").val();
		var fileName = "各平台各账号业绩" + startDate + "-" + endDate + "-" + platform + ".csv";
		var title = [ '报表时间', '平台名称','账号', '销售额_美元', '订单数'];
		var column = ['reportDate1','business','account','sales','orders'];
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
	});
	
	chart = common.echarts(getChartData(getUrl()));//chart
	common.grid({
		title:"各平台各账号业绩"
		,url:getUrl(1)
		,colNames:[ '报表时间', '平台名称','账号', '订单数', '销售额_美元']
		,colModel:[ {name : 'reportDate1',index : 'reportDate1',width : 255}, 
		             {name : 'business',index : 'business',width : 205}, 
		             {name : 'account',index : 'account',width : 205}, 
		             {name : 'orders',index : 'orders',width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
		             {name : 'sales',index : 'sales',width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}, ]
		,sortname:"reportDate1"
		,sortorder:"desc"
	});
})();
</script>
</body>
</html>
