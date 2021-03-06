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
                <label>业务线：</label>
                <select class="form-control w120" id="business" >
                </select>
            </div>
            <div class="form-group">
                <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
            </div>
             <div class="form-group">
                <button type="button" id="export" onclick="exportData()" class="btn btn-primary">导出</button>
            </div>
        </form>
        <div class="hr-line-dashed"></div>
        <div id="container" style="min-width: 310px; height: 500px; margin: 0 auto"></div>
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
	var business = $("#business").val();
	var url = "";
	if(type === 1){
		url = contextPath + '/report/sales_performance/gridCount?startDate=' + startDate + "&endDate=" + endDate
	}else{
		url = contextPath + '/report/sales_performance/chartCount?startDate=' + startDate + "&endDate=" + endDate
	}

	if(business != "all"){
		url += "&business=" + business;
	}

	return url;
}
function queryData(){
	var operation = getChartData(getUrl());
	common.refreshData2(getUrl(1),chart,operation);
}
function exportData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "Ebay业务线销售汇总数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '平台名称', '销售额_美元', '订单数'];
	var column = ['business','sales','orders'];
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
	var salesSum = new Array();
	var businessData = [];
	var salesSumSum = 0;          //出去eBay的所有业务线的汇总
	var zhuanxianSum = 0;         //所有专线的汇总
	var zhuanxianzZhanbi = 0;     //专线占比
	var zhiyouZhanbi = 0;         //直邮占比
	var title = '';
	$.ajax({
		url : chartUrl,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				domesticData = data;
				for(var i=0;i<data.length;i++){
					if(data[i].business !== 'ebay'){
						businessData.push(data[i].business);
		            	salesSum.push({'value': data[i].sales, 'name': data[i].business});
		            	salesSumSum += data[i].sales;
					}
					if(data[i].business.indexOf('专线') > 0){
						zhuanxianSum += data[i].sales;
					}
	            }
			}
		}
	});

	zhuanxianzZhanbi = (zhuanxianSum/salesSumSum * 100).toFixed(2);
	zhiyouZhanbi = ((1 - zhuanxianSum/salesSumSum) * 100).toFixed(2);
	title = '专线占比为(' + zhuanxianzZhanbi + '%),' + '直邮占比为(' + zhiyouZhanbi + '%)';

	var series = [
		{
			name: '业务线',
			type: 'pie',
			radius:'60%',
			center:['50%', '45%'],
			data: salesSum,
		}
	];
	return {
		legend: {
			orient: 'vertical',
			left: 'left',
			data: businessData,
		}
		,label: {
	        normal: {
	      		formatter: "{b}({d}%)"
	        }
	    }
		,title: {text: title, left: '32%', top: '85%'}  
		,series: series
		,tooltipFormatter: "{a} <br/> {b} <br/> 销售额 : {c} ({d}%)"
		,
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
		url : contextPath + "/report/sales_performance/domestic/platforms",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#business").append("<option value='all'>"+ "全部" +"</option>");
				for(var i=0;i<data.length;i++){
					$("#business").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	chart = common.echartsPie(getChartData(getUrl()));//chart */
	common.grid({
		title:"Ebay业务线销售汇总数据"
		,url:getUrl(1)
		,colNames:[  '平台名称', '销售额_美元', '订单数']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
		             {name : 'business',index : 'business',width : 205}, 
		             {name : 'sales',index : 'sales',width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}, 
		             {name : 'orders',index : 'orders',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"}
		           ]
		,sortname:"business"
		,sortorder:"asc"  //可选desc和asc
		,footerrow:true
		,userDataOnFooter:true
	});
})();
</script>
</body>
</html>