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
    <div class="ibox-title"><h5>各平台物流每日发货数据(注意：本页面货币的单位，均为人民币（元），重量单位为（克）)</h5></div>
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
                <label>平台：</label>
                <select class="form-control w120" id="platform" onchange="palChangeCha()">
                </select>
            </div>
            <div class="form-group">
                <label>物流渠道：</label>
                <input id="channelName_input" list="channelName" />
				<datalist id="channelName"></datalist>
            </div>
            <br/>
            <div class="form-group">
                <label>仓库编码：</label>
                <select class="form-control w120" id="warehouseid">
                </select>
            </div>
            <div class="form-group">
            	<label>内单号</label>
                <input type="text" class="form-control" placeholder="请输入内容" id="erpOrdersId" name="erpOrdersId" value=""/>
            </div>
            <div class="form-group">
            	<label>追踪码1 or 2</label>
                <input type="text" class="form-control" placeholder="请输入内容" id="ordersCode" name="ordersCode" value=""/>
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
	var platform = $("#platform").val();
	var channelName = $("#channelName_input").val();
	var warehouseid = $("#warehouseid").val();
	var erpOrdersId = $("#erpOrdersId").val();
	var ordersCode = $("#ordersCode").val();
	var url = "";

		url = contextPath + '/report/daily_out_logistic/grid?startDate=' + startDate + "&endDate=" + endDate;

	if(platform !== 'all'){
		url += "&platform=" + platform;
	}

	if(channelName !== ''){
		url += "&channelName=" + channelName;
	}

	if(warehouseid != 0 && warehouseid != null){
		url += "&warehouseid=" + warehouseid;
	}

	if(erpOrdersId !== ''){
		url += "&erpOrdersId=" + erpOrdersId;
	}

	if(ordersCode !== ''){
		url += "&ordersCode=" + ordersCode;
	}

	return url;
}
function palChangeCha(){
	var platform = $("#platform").val();
	if(platform == 'all'){
		platform = '';
	}
	$.ajax({
		url : contextPath + "/report/daily_out_logistic/channelName?platform=" + platform,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#channelName").empty();
				for(var i=0;i<data.length;i++){
					$("#channelName").append("<option value='"+ data[i] +"'> </option>");
				}
			}
		}
	});
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
	var	platform = $("#platform").val();
	var fileName = "各平台物流每日发货数据" + startDate +"-"+ endDate +"-"+ platform + ".csv";
	var title = [ '内单号', '平台', '仓库编码', '渠道名称', '日期', '追踪码1', '追踪码2', '渠道编码', '发货收入',
		'税后综合净利', '运费', '实际运费', 'sku重量', '订单重量', '实际发货重量', '订单类型', 'sku', 'sku中文名', 
		'物流属性（数字）', '买家国家', '买家地址1', '买家地址2', '国家编码', '账号', '中文国家'];
	var column = [ 'erpOrdersId', 'platform', 'warehouseid','channelName','reportDate','ordersShippingCode','ordersMailCode','freightcode','productTotalCny',
			'netProfit','productShipping','fee','skuWeight','orderWeight','heavi','ordersType','sku','skuCnname',
			'logicAttr','buyerCountry','buyerAddress1','buyerAddress2','ebayCounycode','salesAccount','countryCn'];
	exportDataToCSV('#list2',title,domesticData,fileName,column);
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
		url : contextPath + "/report/daily_out_logistic/platforms",
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

	$.ajax({
		url : contextPath + "/report/daily_out_logistic/channelNames",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#channelName").empty();
				for(var i=0;i<data.length;i++){
					$("#channelName").append("<option value='"+ data[i] +"'> </option>");
				}
			}
		}
	});

	$.ajax({
		url : contextPath + "/report/daily_out_logistic/warehouseIds",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#warehouseid").append("<option value='0'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#warehouseid").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});

	common.grid({
		title:"各平台物流每日发货数据"
		,url:getUrl()
		,colNames:[ '内单号', '平台', '仓库编码', '渠道名称', '日期', '追踪码1', '追踪码2', '渠道编码', '发货收入',
			'税后综合净利', '运费', '实际运费', 'sku重量', '订单重量', '实际发货重量', '订单类型', 'sku', 'sku中文名', 
			'物流属性（数字）', '买家国家', '买家地址1', '买家地址2', '国家编码', '账号', '中文国家']
		,colModel:[ {name : 'erpOrdersId',index : 'erpOrdersId',sortable : "true",width : 130,formatter:'long'},
					{name : 'platform',index : 'platform',sortable : "true",width : 120}, 
					{name : 'warehouseid',index : 'warehouseid',sortable : "true",width : 100,formatter:'integer'},
		            {name : 'channelName',index : 'channelName',sortable : "true",width : 160},
		            {name : 'reportDate',index : 'reportDate',width : 110},
		            {name : 'ordersShippingCode',index : 'ordersShippingCode',sortable : "true",width : 210},
		            {name : 'ordersMailCode',index : 'ordersMailCode',sortable : "true",width : 200},
		            {name : 'freightcode',index : 'freightcode',sortable : "true",width : 100},
		            {name : 'productTotalCny',index : 'productTotalCny',sortable : "true",width : 125,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'netProfit',index : 'netProfit',sortable : "true",width : 130,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:4},align:"right"},
		            {name : 'productShipping',index : 'productShipping',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'fee',index : 'fee',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'skuWeight',index : 'skuWeight',sortable : "true",width : 110,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'orderWeight',index : 'orderWeight',sortable : "true",width : 110,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'heavi',index : 'heavi',sortable : "true",width : 125,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'ordersType',index : 'ordersType',sortable : "true",width : 100},
		            {name : 'sku',index : 'sku',sortable : "true",width : 105},
		            {name : 'skuCnname',index : 'skuCnname',sortable : "true",width : 170},
		            {name : 'logicAttr',index : 'logicAttr',sortable : "true",width : 150,formatter:'integer'},
		            {name : 'buyerCountry',index : 'buyerCountry',sortable : "true",width : 170},
		            {name : 'buyerAddress1',index : 'buyerAddress_1',width : 200},
		            {name : 'buyerAddress2',index : 'buyerAddress_2',width : 200},
		            {name : 'ebayCounycode',index : 'ebayCounycode',width : 110},
		            {name : 'salesAccount',index : 'salesAccount',width : 170},
		            {name : 'countryCn',index : 'countryCn',width : 110},
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
