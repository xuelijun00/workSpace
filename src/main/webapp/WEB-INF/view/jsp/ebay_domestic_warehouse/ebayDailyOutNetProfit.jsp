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
    <div class="ibox-title"><h5>eBay发货订单净利明细(注意：本页面货币的单位，均为人民币（元）)</h5></div>
    <div class="ibox-content">
    <form class="form-inline">
            <div class="form-group">
              <label>开始时间</label>
              <input type="text" id="start_date2"class="form-control" placeholder=""  readonly="readonly">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date2" class="form-control" placeholder="" readonly="readonly">
            </div>
            <br/>
            <div class="form-group">
                <label>主站点：</label>
                <select class="form-control w120" id="zhuzhandian2">
                </select>
            </div>
             <div class="form-group">
	            <label>SKU：</label>
	            <input type="text" class="form-control" placeholder="请输入内容" id="sku2" name="sku" value=""/> 
            </div>
            <div class="form-group">
                <label>账号：</label>
                <input id="account_input2" list="account2" />
				<datalist id="account2"></datalist>
            </div>
            <div class="form-group">
                <button type="button" onclick="queryData(2)" class="btn btn-primary">查询</button>
            </div>
<!--             <div class="form-group">
                <button type="button" onclick="exportData()" class="btn btn-primary">导出</button>
            </div> -->
        </form> 
		</div>
		<div class="hr-line-dashed"></div>  
        <h2 class="text-center">eBay发货收入和税后综合利润率（按日期汇总）</h2>
		<div class="hr-line-dashed"></div>
		<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		<!-- 表格 -->
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
            <br/>
            <div class="form-group">
                <label>主站点：</label>
                <select class="form-control w120" id="zhuzhandian1">
                </select>
            </div>
             <div class="form-group">
	            <label>SKU：</label>
	            <input type="text" class="form-control" placeholder="请输入内容" id="sku1" name="sku" value=""/> 
            </div>
            <div class="form-group">
                <label>账号：</label>
                <input id="account_input1" list="account1" />
				<datalist id="account1"></datalist>
            </div>       
            <div class="form-group">
                <button type="button" onclick="queryData(1)" class="btn btn-primary">查询</button>
            </div>
            <div class="form-group">
                <button type="button" onclick="exportData()" class="btn btn-primary">导出</button>
            </div>
        </form> 
		</div>
        <div class="hr-line-dashed"></div>  
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
	var zhuzhandian = $("#zhuzhandian" + type).val();
	var account = $("#account_input" + type).val();
	var sku = $("#sku" + type).val();
	var url = "";
	if(type === 1){
		url = contextPath + '/report/profit_details/grid?platform=ebay&startDate=' + startDate + "&endDate=" + endDate;
	}else{
		url = contextPath + '/report/profit_details/chart?platform=ebay&startDate=' + startDate + "&endDate=" + endDate;
	}
		
	
	if(zhuzhandian !== 'all'){
		url += "&zhuzhandian=" + zhuzhandian;
	}
		
	if(sku !== ''){
		url += "&sku=" + sku;
	}
	
	if(account !== ''){
		url += "&salesAccount=" + account;
	}
	return url;
}
function queryData(type){
	if(type === 1){
		common.refreshData(getUrl(1),chart,operation);
	}else{
		common.echarts(getChartData(getUrl(2)));
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
	var fileName = "eBay发货订单净利明细" + startDate +"-"+ endDate + ".csv";
	var title = [ '平台名称', '管理员', '账号', 'sku', 'sku中文名','发货数量', '平均价', '发货收入（元）', '退款', '成本', '毛利',
			'运费', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税前综合净利', '税后综合净利', '报表时间', '主站点'];
	var column = [ 'platform', 'manager', 'salesAccount', 'sku','skuCnName','orderNum','unitPrice','productTotalCny','productRefund','orderPrice','grossProfit',
			'productShipping','platformCost','materialCost','orderExecutionFee','operatingCost','profitMargin','netProfit','profit','reportDate','zhuzhandian'];
	exportDataToCSV('#list2',title,domesticData,fileName,column);
}

function getChartData(chartUrl){
	var netProfitMarginSum = [];
	var productTotalCnySum = [];
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
				  categories.push(data[i].reportDate);
				  netProfitMarginSum.push(data[i].netProfitMargin *100);
				  productTotalCnySum.push(data[i].productTotalCny);
	            }
			}
		}
	});
	var y = [{
        type: 'value',
        name: '发货收入',
        position: 'left',
        axisLabel: {
            formatter: '{value} '
        }
    } ,{
        type: 'value',
        name: '税后综合利润率(百分比)',       
        position: 'right',
        axisLabel: {
            formatter: '{value} '
        }
    }];
	return {
		title:{text:"eBay发货订单净利明细"}
		,categories:categories
		,y:y
		,series:[{name: '发货收入',type: 'bar',data:productTotalCnySum,tooltip: {valueSuffix: ''}},
			{name:'税后综合利润率(百分比)',type: 'line',yAxisIndex: 1,data:netProfitMarginSum,tooltip: {valueSuffix: '' }}]
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
		url : contextPath + "/report/profit_details/zhuzhandian?platform=ebay",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#zhuzhandian1").append("<option value='all'>全部</option>");
				$("#zhuzhandian2").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#zhuzhandian1").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
					$("#zhuzhandian2").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	
	$.ajax({
		url : contextPath + "/report/profit_details/account?platform=ebay",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#account1").empty();
				$("#account2").empty();
				for(var i=0;i<data.length;i++){
					$("#account1").append("<option value='"+ data[i] +"'> </option>");
					$("#account2").append("<option value='"+ data[i] +"'> </option>");
				}
			}
		}
	});
	
  	chart = common.echarts(getChartData(getUrl(2)));//chart 
	
	common.grid({
		title:"eBay发货订单净利明细"
		,url:getUrl(1)
		,colNames:[ '平台名称', '管理员', '账号', 'sku', 'sku中文名', '发货数量', '平均价', '发货收入（元）', '退款', '成本', '毛利','运费', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税前综合净利', '税后综合净利', '报表时间', '主站点']
		,colModel:[ {name : 'platform',index : 'platform',width : 100}, 
					{name : 'manager',index : 'manager',sortable : "true",width : 80},
		            {name : 'salesAccount',index : 'sales_account',width : 145}, 
		            {name : 'sku',index : 'sku',sortable : "true",width : 135},
		            {name : 'skuCnName',index : 'skuCnName',width : 210},
		            {name : 'orderNum',index : 'orderNum',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
		            {name : 'unitPrice',index : 'unitPrice',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productTotalCny',index : 'productTotalCny',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productRefund',index : 'productRefund',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'orderPrice',index : 'orderPrice',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'grossProfit',index : 'grossProfit',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productShipping',index : 'productShipping',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'platformCost',index : 'platformCost',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'materialCost',index : 'materialCost',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'orderExecutionFee',index : 'orderExecutionFee',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'operatingCost',index : 'operatingCost',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'profitMargin',index : 'profitMargin',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'netProfit',index : 'netProfit',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'profit',index : 'profit',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'reportDate',index : 'reportDate',width : 110},
		            {name : 'zhuzhandian',index : 'zhuzhandian',width : 100}
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
