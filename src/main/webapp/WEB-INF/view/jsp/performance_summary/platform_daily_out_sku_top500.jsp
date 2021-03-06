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
    <div class="ibox-title"><h5>各平台每日发货SKU_TOP500(注意：本页面货币的单位，均为人民币（元）)</h5></div>
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
            <br/>
            <br/>
            <div class="form-group">
                <label>平台：</label>
                <select class="form-control w120" id="platform" onchange="palChangeCou()">
                </select>
            </div>
            <div class="form-group">
               <label>国家：</label>
               <input id="buyerCountry_input" list="buyerCountry" />
			   <datalist id="buyerCountry"></datalist>
           </div>
            <div class="form-group">
	           <label class="control-label">SKU：</label>
	           	<textarea class="form-control" rows="3" cols="40" id="sku" name="sku"  
	           	placeholder="查询多个sku时，请用逗号或者空格或者换行符（回车）分隔开，支持excel多行粘贴" onblur="common.addComma()" ></textarea>
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
	var buyerCountry = $("#buyerCountry_input").val();
	var sku = $("#sku").val();
	var url = "";
		url = contextPath + '/report/sku_top/grid?startDate=' + startDate + "&endDate=" + endDate;

	if(platform !== 'all'){
		url += "&platform=" + platform;
	}

	if(sku !== ''){
		url += "&sku=" + sku;
	}

	if(buyerCountry !== ''){
		url += "&buyerCountry=" + buyerCountry;
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
	var	platform = $("#platform").val();
	var fileName = "各平台每日发货SKU_TOP500" + "-" + startDate +"-"+ endDate +"-"+ platform + ".csv";
	var title = [ '平台名称', 'sku', 'sku中文名', '发货数量', '平均价', '发货收入（元）', '税后综合净利', '报表时间', '税后综合利润率', '买家国家'];
	var column = [ 'platform', 'sku', 'skuCnName', 'orderNum', 'unitPrice', 'productTotalCny', 'profit', 'reportDate','netProfitMargin', 'buyerCountry'];
	exportDataToCSV('#list2',title,domesticData,fileName,column);
}

function palChangeCou(){
	var platform = $("#platform").val();
	if(platform == 'all'){
		platform = '';
	}
	$.ajax({
		url : contextPath + "/report/sku_top/buyerCountry?platform=" + platform,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#buyerCountry").empty();
				for(var i=0;i<data.length;i++){
					$("#buyerCountry").append("<option value='"+ data[i] +"'> </option>");
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
		url : contextPath + "/report/sku_top/platform",
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
		url : contextPath + "/report/sku_top/buyerCountry",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#buyerCountry").empty();
				for(var i=0;i<data.length;i++){
					$("#buyerCountry").append("<option value='"+ data[i] +"'> </option>");
				}
			}
		}
	});

	common.grid({
		title:"各平台每日发货SKU_TOP500"
		,url:getUrl()
		,colNames:[ '平台名称', 'sku', 'sku中文名', '发货数量', '平均价', '发货收入（元）', '税后综合净利', '报表时间', '税后综合利润率', '买家国家']
		,colModel:[ {name : 'platform',index : 'platform',width : 100}, 
		            {name : 'sku',index : 'sku',sortable : "true",width : 135},
		            {name : 'skuCnName',index : 'skuCnname',width : 210},
		            {name : 'orderNum',index : 'orderNum',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
		            {name : 'unitPrice',index : 'unitPrice',sortable : "true",width : 100,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'productTotalCny',index : 'productTotalCny',sortable : "true",width : 130,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'profit',index : 'profit',sortable : "true",width : 130,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		            {name : 'reportDate',index : 'reportDate',width : 110},
		            {name : 'netProfitMargin',index : 'netProfitMargin',sortable : "true",width : 130,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:6},align:"right"},
		            {name : 'buyerCountry',index : 'buyerCountry',width : 120}, 
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
