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
    <div class="ibox-title"><h5>SMT账号维度每日发货数据(海外仓)(注意：本页面货币的单位，均为人民币（元）)</h5></div>
    <div class="ibox-content">
    <form class="form-inline">
            <div class="form-group">
              <label>开始时间</label>
              <input type="text" id="start_date"class="form-control" placeholder=""  readonly="readonly">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date" class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
                <label>账号：</label>
                <input id="account_input" list="account" />
				<datalist id="account"></datalist>
            </div>
            <br/>
            <div class="form-group">
                <label>仓库类型：</label>
                <select class="form-control w120" id="warehouseType" onchange="typeChangeName()">
                </select>
            </div>
            <div class="form-group">
                <label>原仓库类型：</label>
                <select class="form-control w120" id="warehouseName" >
                </select>
            </div>
            <div class="form-group">
                <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
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
function getUrl(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var account = $("#account_input").val();
	var warehouseType = $("#warehouseType").val();
	var warehouseName = $("#warehouseName").val();
	var url = "";
		url = contextPath + '/report/daily_out_account_oversea/grid?platform=smt&startDate=' + startDate + "&endDate=" + endDate;
	if(account !== ''){
		url += "&salesAccount=" + account;
	}
	if(warehouseType !== 'all'){
		url += "&warehouseType=" + warehouseType;
	}
	if(warehouseName !== 'all'){
		url += "&warehouseName=" + warehouseName;
	}
	return url;
}

function queryData(){
	common.refreshData(getUrl(),chart,operation);
}
function exportData(){
    
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
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "SMT账号维度每日发货数据(海外仓)" + startDate +"-"+ endDate + ".csv";
	var title = [ '平台名称', '账号', '管理员', '原仓库类型', '报表时间', '发货数量', '数量汇总', '发货收入（元）', '退款', '成本', '总头程',
			'运费', '毛利', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税前综合净利', '税后综合净利', '仓库类型'];
	var column = [ 'platform', 'salesAccount', 'manager', 'warehouseName', 'reportDate','orderNum','itemNum','productTotalCny','productRefund','orderPrice','orderHeadfee',
			'productShipping','grossProfit','platformCost','materialCost','orderExecutionFee','operatingCost','profitMargin','profit','netProfit','warehouseType'];
	exportDataToCSV('#list2',title,domesticData,fileName,column);
}

function typeChangeName(){
	var	warehouseType = $("#warehouseType").val();
	var url = contextPath + '/report/daily_out_account_oversea/warehouseName?platform=smt';
	if(warehouseType != 'all' && warehouseType != null){
		url += '&warehouseType=' + warehouseType;
	}
	$.ajax({
		url : url,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#warehouseName").empty();
				$("#warehouseName").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#warehouseName").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
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
		url : contextPath + "/report/daily_out_account_oversea/accounts?platform=smt",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#account").empty();
				for(var i=0;i<data.length;i++){
					$("#account").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});

	$.ajax({
		url : contextPath + "/report/daily_out_account_oversea/warehouseType?platform=smt",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#warehouseType").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#warehouseType").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});

	$.ajax({
		url : contextPath + "/report/daily_out_account_oversea/warehouseName?platform=smt",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#warehouseName").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#warehouseName").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});

	common.grid({
		title:"SMT账号维度每日发货数据(海外仓)"
		,url:getUrl()
		,colNames:[ '平台名称', '账号', '管理员', '原仓库类型', '报表时间', '发货数量', '数量汇总', '发货收入（元）', '退款', '成本', '总头程',
			'运费', '毛利', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税前综合净利', '税后综合净利', '仓库类型']
		,colModel:[ {name : 'platform',index : 'platform',width : 100}, 
					{name : 'salesAccount',index : 'sales_account',width : 145}, 
					{name : 'manager',index : 'manager',sortable : "true",width : 100},
					{name : 'warehouseName',index : 'warehousename',sortable : "true",width : 100},
					{name : 'reportDate',index : 'reportDate',width : 110},
		            {name : 'orderNum',index : 'orderNum',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
		            {name : 'itemNum',index : 'itemNum',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productTotalCny',index : 'productTotalCny',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productRefund',index : 'productRefund',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'orderPrice',index : 'orderPrice',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'orderHeadfee',index : 'orderHeadfee',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productShipping',index : 'productShipping',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'grossProfit',index : 'grossProfit',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'platformCost',index : 'platformCost',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'materialCost',index : 'materialCost',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'orderExecutionFee',index : 'orderExecutionFee',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'operatingCost',index : 'operatingCost',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'profitMargin',index : 'profitMargin',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            //这里与项目中其他的profit、netProfit是反过来的，因为netProfit是净利润profit是未处理的利润，以前数据库字段引用错了，但是涉及太多表所以没有改过来，现在纠正这里，但是以前的任然没改（2017-10-16）。
		            {name : 'profit',index : 'profit',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'netProfit',index : 'netProfit',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'warehouseType',index : 'warehousetype',sortable : "true",width : 100},
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
