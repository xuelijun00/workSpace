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
<div class="ibox-title"><h5>Ebay业务线净利汇总数据(注意：本页面货币的单位均为（美元）)</h5></div>
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
                <select class="form-control w120" id="zhuzhandian" >
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
	var zhuzhandian = $("#zhuzhandian").val();
	var url = "";
	if(type === 1){
		url = contextPath + '/report/ebay_profit_sum/grid?startDate=' + startDate + "&endDate=" + endDate
	}else{
		url = contextPath + '/report/ebay_profit_sum/chart?startDate=' + startDate + "&endDate=" + endDate
	}

	if(zhuzhandian != "all"){
		url += "&zhuzhandian=" + zhuzhandian;
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
	var fileName = "Ebay业务线净利汇总数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '业务线', '发货数量', '客单价_美元', '发货收入_美元','税后综合净利_美元','税后综合利润率'];
	var column = [ 'zhuzhandian', 'orderNum',  'unitPrice', 'productTotalCny', 'profit', 'netProfitMargin'];
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
	var profitSum = new Array();
	var netProfitMarginSum = '';
	var zhuzhandianData = [];
	var zhuzhandianToString = '';
	var profitSumSum = 0;          //出去eBay的所有业务线的汇总
	var zhuanxianSum = 0;          //所有专线的汇总
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
					if(data[i].zhuzhandian !== 'ebay'){
						netProfitMarginSum = (data[i].netProfitMargin *100).toFixed(2) + '%';
						zhuzhandianToString = data[i].zhuzhandian + ':\n' + '净利率:' +netProfitMarginSum+ '\n' + '净利（美元）:' +data[i].profit.toFixed(2);
						zhuzhandianData.push(zhuzhandianToString);
						profitSum.push({'value': data[i].profit.toFixed(2), 'name': zhuzhandianToString});
						profitSumSum += data[i].profit;
						if(data[i].zhuzhandian.indexOf('专线') > 0){
							zhuanxianSum += data[i].profit;
						}
					}
	            }
			}
		}
	});

	zhuanxianzZhanbi = (zhuanxianSum/profitSumSum * 100).toFixed(2);
	zhiyouZhanbi = ((1 - zhuanxianSum/profitSumSum) * 100).toFixed(2);
	title = '专线占比为(' + zhuanxianzZhanbi + '%),' + '直邮占比为(' + zhiyouZhanbi + '%)';

	var series = [
		{
			name: '业务线',
			type: 'pie',
			radius:'60%',
			center:['50%', '45%'],
			data: profitSum,
			itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	               }
			}
		}
	];
	return {
		legend: {
			orient: 'vertical',
			left: 'left',
			data: zhuzhandianData,
			formatter: function (name) {
				name = name.substr(0,name.indexOf(':'));
			    return name;
			}
		}
		,label: {
	        normal: {
	    		formatter: function(params, ticket, callback) {
	    			var res = '';
		            var name = params.name;
		            	name = name.substr(0,name.indexOf(':'));
		                res = name + '(' + params.percent + '%)';
		            return res;
		        }
	        },
		        emphasis:{
		        	formatter: function(params, ticket, callback) {
		    			var res = '';
			            var name = params.name;
			            	name = name.substr(0,name.indexOf(':'));
			                res = name + '(' + params.percent + '%)';
			            return res;
			        }
		        }
	    }
	,title: {text: title, left: '32%', top: '85%'} 
	,series: series
	,tooltipFormatter: "{a} <br/> {b}({d}%)"
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
		url : contextPath + "/report/ebay_profit_sum/zhuzhandian",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#zhuzhandian").append("<option value='all'>"+ "全部" +"</option>");
				for(var i=0;i<data.length;i++){
					$("#zhuzhandian").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	chart = common.echartsPie(getChartData(getUrl()));//chart */
	common.grid({
		title:"Ebay业务线净利汇总数据"
		,url:getUrl(1)
		,colNames:[ '业务线', '发货数量', '客单价_美元', '发货收入_美元','税后综合净利_美元','税后综合利润率']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
		            {name : 'zhuzhandian',index : 'zhuzhandian',width : 205,sortable : "true"}, 
		            {name : 'orderNum',index : 'orderNum',width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:""},align:"right"}, 
		            {name : 'unitPrice',index : 'unitPrice',width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productTotalCny',index : 'productTotalCny',width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}, 
		            {name : 'profit',index : 'profit',width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}, 
		            {name : 'netProfitMargin',index : 'netProfitMargin',width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:6},align:"right"}, 
		           ]
		,sortname:"zhuzhandian"
		,sortorder:"asc"  //可选desc和asc
		,footerrow:true
		,userDataOnFooter:true
	});
})();
</script>
</body>
</html>