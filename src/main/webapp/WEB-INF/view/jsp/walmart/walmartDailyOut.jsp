<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/8
  Time: 12:04
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
    <div class="ibox-title"><h5>沃尔玛每日发货数据（注意：本页面的货币单位，均为人民币（元））  </h5></div>
    <div class="ibox-content">
    	<form class="form-inline">
           <div class="form-group">
             <label>开始时间</label> 
             <input type="text" id="start_date1"class="form-control" placeholder=""  readonly="readonly">
           </div>
           <div class="form-group">
             <label>结束时间</label>
             <input type="text" id="end_date1" class="form-control" placeholder=""  readonly="readonly">
           </div>
           <!-- <div class="form-group">
               <label>站点：</label>
               <select class="form-control w120" id="site1" >
               </select>
           </div> -->
            <div class="form-group">
               <button type="button" id="query1"  class="btn btn-primary" onclick="query()">查询</button>
           </div>
           <div class="form-group">
               <button type="button"  id="export1" class="btn btn-primary" onclick="exportGridData()">导出</button>
           </div>
       </form>
	   <div class="ibox-content">
			<table id="list1" class="tablegrid"></table>
			<div id="pager1"></div>
	   </div>
	</div>
	
</div>
<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>
<!--加本页面 的js文件与js代码-->
<script type="text/javascript">
function getUrl(){
	var url = contextPath + "/report/daily_out_report/each_platform/grid?platform=walmart";
	url += "&startDate=" + $("#start_date1").val();
	url += "&endDate=" + $("#end_date1").val();
	return url;
}
function query(){
	$('#list1').jqGrid('clearGridData');
	$('#list1').jqGrid('setGridParam', {url: getUrl()}).trigger('reloadGrid');
}
function exportGridData(){
	var startDate = $("#start_date1").val();
	var endDate = $("#end_date1").val();
	var fileName = "沃尔玛每日发货数据 " + startDate +"-"+ endDate + ".csv";
	var title = [ '日期','平台', '发货单数', '客单价', '发货收入（元）', '退款', '成本', '毛利', '运费', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税后综合净利', '税后综合利润率'];
	var column = ['reportDate','platform','orderNum','unitPrice','productTotalCny','productRefund','orderPrice','grossProfit','productShipping'
	              ,'platformCost','materialCost','orderExecutionFee','operatingCost','profitMargin','profit','netProfitMargin'];
	var exportData = [];
	$.ajax({
		url : getUrl(),
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.rows.length > 0){
				for(var i=0;i<data.rows.length;i++){
					data.rows[i].reportDate = new Date(data.rows[i].reportDate).toLocaleDateString()
				}
				exportData = data.rows;
			}
		}
	});
	exportDataToCSV('#list1',title,exportData,fileName,column);
}


 (function(){
	$("#start_date1").jeDate({ isinitVal: true,initAddVal:{DD:"-15"},isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	$("#end_date1").jeDate({ isinitVal: true,isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	//查询站点
	/*$.ajax({
		url : contextPath + "/report/daily_out_ebay_group_leader_reprots/direct_mail/site",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#site1").append("<option value=''>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#site1").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	 */
	common.grid({
		id:"#list1",
		title:"沃尔玛每日发货数据 "
		,url:getUrl()
		,colNames:[ '日期','平台', '发货单数', '客单价', '发货收入（元）', '退款', '成本', '毛利', '运费', '平台费用', '包材费', '订单执行费', '运营费', '边际利润', '税后综合净利', '税后综合利润率']
		,colModel:[ {name : 'reportDate',index : 'reportDate',width : 120,formatter:function(cellvalue, options, row){return new Date(cellvalue).toLocaleDateString()}}, 
		            {name : 'platform',index : 'platform',width : 100},
		             {name : 'orderNum',index : 'orderNum',width : 100,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ','}}, 
		             {name : 'unitPrice',index : 'unitPrice',sortable : "true",width : 100,align:"right",formatter:'float', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'productTotalCny',index : 'productTotalCny',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'productRefund',index : 'productRefund',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'orderPrice',index : 'orderPrice',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'grossProfit',index : 'grossProfit',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             {name : 'productShipping',index : 'productShipping',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'platformCost',index : 'platformCost',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'materialCost',index : 'materialCost',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'orderExecutionFee',index : 'orderExecutionFee',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'operatingCost',index : 'operatingCost',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'profitMargin',index : 'profitMargin',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'profit',index : 'profit',width : 120,align:"right",formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
					{name : 'netProfitMargin',index : 'netProfitMargin',width : 120,align:"right",formatter:'float', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2}},
		             ]
		,sortname:"reportDate"
		,sortorder:"desc"
		,pager:"pager1"
		,height:"430px"
		,shrinkToFit:true
		,autoScroll:true
	});
	
})();
</script>
</body>
</html>
