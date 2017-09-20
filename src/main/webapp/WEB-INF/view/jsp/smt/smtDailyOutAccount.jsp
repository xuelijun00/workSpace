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
    <div class="ibox-title"><h5>SMT账号维度每日发货数据(注意：本页面只有饼图的“税后综合净利”的货币的单位为（美元），其他均为人民币（元）)</h5></div>
    	<div class="ibox-content">
    	<form class="form-inline">
           <div class="form-group">
             <label>开始时间</label>
             <input type="text" id="start_date2" class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
             <label>结束时间</label>
             <input type="text" id="end_date2" class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
           	<label>分类:</label>
              	<select class="form-control w120" id="category2" name="category">
               </select>
           </div>
           <div class="form-group">
              <button type="button" onclick="queryData(2)" class="btn btn-primary">查询</button>
           </div>
       </form>
	</div>
	<div class="hr-line-dashed"></div>
    <div id="container" style="min-width: 310px; height: 500px; margin: 0 auto"></div>
    
    <div class="ibox-content">
    <form class="form-inline">
            <div class="form-group">
              <label>开始时间</label>
              <input type="text" id="start_date1"class="form-control" placeholder=""  readonly="readonly">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date1" class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
                <label>分类：</label>
                <select class="form-control w120" id="category1">
                </select>
            </div>
            <div class="form-group">
                <label>账号：</label>
                <input id="account_input" list="account" />
				<datalist id="account"></datalist>
            </div>       
            <div class="form-group">
                <button type="button" onclick="queryData(1)" class="btn btn-primary">查询</button>
            </div>
            <div class="form-group">
                <button type="button" onclick="exportData()" class="btn btn-primary">导出</button>
            </div>
        </form> 
		</div>
		<div class="ibox-content">
			<table id="list2" class="tablegrid"></table>
			<div id="pager2"></div>
		</div>
</div>
<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>
<!--加本页面 的js文件与js代码-->
<script type="text/javascript">
var chart;
var operation;
var domesticData = [];
function getUrl(type){
	var startDate = $("#start_date" + type).val();
	var endDate = $("#end_date" + type).val();
	var categoryType = $('#category' +type).val();
	var category = encodeURIComponent(categoryType);
	var account = $("#account_input").val();
	var url = "";

	if(type === 1){
		url = contextPath + '/report/daily_out_account/grid?platform=smt&startDate=' + startDate + "&endDate=" + endDate;
		if(account !== ''){
			url += "&salesAccount=" + account;
		}
	}else{
		url = contextPath + '/report/daily_out_account/chart?platform=smt&startDate=' + startDate + "&endDate=" + endDate;
	}

	if(category !== 'all' && category !== null){
		url+= '&category=' + category
	}

	return url;
}

function queryData(type){
	if(type === 1){
		common.refreshData(getUrl(1),chart,operation);
	}else{
		common.echartsPie(getChartData(getUrl(2)));
	}
}

function exportData(){
	chartUrl = getUrl(1); 
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
	var startDate = $("#start_date1").val();
	var endDate = $("#end_date1").val();
	var category = encodeURIComponent($('#category1').val());
	var fileName = "SMT账号维度每日发货数据" + startDate +"-"+ endDate + "-" + category +".csv";
	var title = [ '平台名称', '账号', '管理员', '报表时间', '发货数量', '客单价', '发货收入（元）', '退款', '成本', '毛利',
			'运费', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税前综合净利', '税后综合净利（元）', '分类'];
	var column = [ 'platform', 'salesAccount', 'manager', 'reportDate','orderNum','unitPrice','productTotalCny','productRefund','orderPrice','grossProfit',
			'productShipping','platformCost','materialCost','orderExecutionFee','operatingCost','profitMargin','netProfit','profit','category'];
	exportDataToCSV('#list2',title,domesticData,fileName,column);
}

function getChartData(chartUrl){
	var profitSum = new Array();
	var categoryData = [];
	$.ajax({
		url : chartUrl,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				domesticData = data;
				for(var i=0;i<data.length;i++){
					categoryData.push(data[i].category);
					profitSum.push({'value': data[i].profit.toFixed(2), 'name': data[i].category});
	            }
			}
		}
	});

	var series = [
		{
			name: '品类',
			type: 'pie',
			radius:'60%',
			center:['50%', '45%'],
			data: profitSum,
		}
	];
	return {
		legend: {
			orient: 'vertical',
			left: 'left',
			data: categoryData,
		}
		,label: {
	        normal: {
	      		formatter: "{b}({d}%)"
	        }
	    }
		,title: {text: 'SMT净利（美元）汇总（按时间段和品类汇总）', x: 'center'}  
		,series: series
		,tooltipFormatter: "{a} <br/> {b} <br/> 税后综合净利（美元） : {c} ({d}%)"
		,
};
}

(function(){
	$("#start_date1").jeDate({
        isinitVal: true,
        initAddVal:{DD:"-7"},
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });
	$("#end_date1").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });
	
	$("#start_date2").jeDate({
        isinitVal: true,
        initAddVal:{DD:"-7"},
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });
	$("#end_date2").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM-DD",
        zIndex:3000
    });

	$.ajax({
		url : contextPath + "/report/daily_out_account/categorys?platform=smt",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#category1").append("<option value='all'>全部</option>");
				$("#category2").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#category1").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
					$("#category2").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	
	$.ajax({
		url : contextPath + "/report/daily_out_account/accounts?platform=smt",
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

	chart = common.echartsPie(getChartData(getUrl(2)));
	
	common.grid({
		title:"SMT账号维度每日发货数据"
		,url:getUrl(1)
		,colNames:[ '平台名称', '账号', '管理员', '报表时间', '发货数量', '客单价', '发货收入（元）', '退款', '成本', '毛利',
			'运费', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税前综合净利', '税后综合净利（元）', '分类']
		,colModel:[ {name : 'platform',index : 'platform',width : 100}, 
					{name : 'salesAccount',index : 'sales_account',width : 145}, 
					{name : 'manager',index : 'manager',sortable : "true",width : 100},
					{name : 'reportDate',index : 'reportDate',width : 110},
		            {name : 'orderNum',index : 'orderNum',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
		            {name : 'unitPrice',index : 'unitPrice',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productTotalCny',index : 'productTotalCny',sortable : "true",width : 130,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productRefund',index : 'productRefund',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'orderPrice',index : 'orderPrice',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'grossProfit',index : 'grossProfit',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productShipping',index : 'productShipping',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'platformCost',index : 'platformCost',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'materialCost',index : 'materialCost',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'orderExecutionFee',index : 'orderExecutionFee',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'operatingCost',index : 'operatingCost',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'profitMargin',index : 'profitMargin',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'netProfit',index : 'netProfit',sortable : "true",width : 150,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'profit',index : 'profit',sortable : "true",width : 150,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'category',index : 'category',width : 100}
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
