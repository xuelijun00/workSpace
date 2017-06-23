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
    <div class="ibox-title"><h5>净利导出明细</h5></div>
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
            <div class="form-group">
                <label>平台：</label>
                <select class="form-control w120" id="platform" >
                </select>
            </div>
            <div class="form-group">
                <label>账号：</label>
                <input id="account" list="account" />
				<datalist id="account"></datalist>
            </div>
            
             <div class="form-group">
	            <label>SKU</label>
	            <input type="text" class="form-control" placeholder="请输入内容" id="sku" name="sku" value=""/>
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
	var account = $("#account").val();
	var sku = $("#sku").val();
	var url = "";
	
		url = contextPath + '/report/profit_details/grid?startDate=' + startDate + "&endDate=" + endDate;
	
	if(platform !== 'all'){
		url += "&platform=" + platform;
	}
	
	if(sku !== ''){
		url += "&sku=" + sku;
	}
	
	if(account !== ''){
		url += "&salesAccount=" + account;
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
	
	var fileName = "净利导出明细.csv";
	var title = [ '报表时间', '平台名称', '账号', 'sku','管理员','发货单数','客单价','发货收入','退款','成本','毛利','运费','平台费用','包材费','订单执行费','运营费','边际利润','税后综合净利'];
	var column = ['reportDate1','platform','salesAccount','sku','manager','orderNum','unitPrice','productTotalCny','productRefund','orderPrice','grossProfit','productShipping','platformCost','materialCost','orderExecutionFee','operatingCost','profitMargin','netProfit'];
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
		url : contextPath + "/report/profit_details/platform",
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
		url : contextPath + "/report/profit_details/account",
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
	
	
	common.grid({
		title:"净利导出明细"
		,url:getUrl()
		,colNames:[ '报表时间', '平台名称', '账号', 'sku','管理员','发货单数','客单价','发货收入','退款','成本','毛利','运费','平台费用','包材费','订单执行费','运营费','边际利润','税后综合净利']
		,colModel:[ {name : 'reportDate1',index : 'reportDate1',width : 255}, 
		             {name : 'platform',index : 'platform',width : 205}, 
		             {name : 'salesAccount',index : 'sales_account',width : 205}, 
		             {name : 'sku',index : 'sku',sortable : "true",width : 205},
		             {name : 'manager',index : 'manager',sortable : "true",width : 205},
		             {name : 'orderNum',index : 'orderNum',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
		             {name : 'unitPrice',index : 'unitPrice',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'productTotalCny',index : 'productTotalCny',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'productRefund',index : 'productRefund',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'orderPrice',index : 'orderPrice',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'grossProfit',index : 'grossProfit',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'productShipping',index : 'productShipping',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'platformCost',index : 'platformCost',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'materialCost',index : 'materialCost',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'orderExecutionFee',index : 'orderExecutionFee',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'operatingCost',index : 'operatingCost',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'profitMargin',index : 'profitMargin',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'netProfit',index : 'netProfit',sortable : "true",width : 300,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}
		         
		             ]	      
		,sortname:"reportDate1"
		,sortorder:"desc"
	});
})();
</script>
</body>
</html>
