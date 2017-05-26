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
    <div class="ibox-title"><h5>Ebay组长站点发货业绩 </h5></div>
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
           <div class="form-group">
               <label>站点：</label>
               <select class="form-control w120" id="site1" >
               </select>
           </div>
           <div class="form-group">
               <label>管理员：</label>
               <input id="groupleader_input1" list="groupleader1" />
			<datalist id="groupleader1"></datalist>
           </div>
           <div class="form-group">
               <button type="button" id="query1"  class="btn btn-primary" onclick="query(1)">查询</button>
           </div>
           <div class="form-group">
               <button type="button"  id="export1" class="btn btn-primary" onclick="exportGridData(1)">导出</button>
           </div>
       </form>
	   <div class="ibox-content">
			<table id="list1" class="tablegrid"></table>
			<div id="pager1"></div>
	   </div>
	</div>
	<div class="ibox-title"><h5>各业务线各销售员每周业绩数据(注：周一到周日为一个周)</h5></div>
	<div class="ibox-content">
    	<form class="form-inline">
           <div class="form-group">
             <label>开始时间</label>
             <input type="text" id="start_date2"class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
             <label>结束时间</label>
             <input type="text" id="end_date2" class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
               <label>平台：</label>
               <select class="form-control w120" id="site2" >
               </select>
           </div>
           <div class="form-group">
               <label>管理员：</label>
               <input id="groupleader_input2" list="groupleader2" />
			<datalist id="groupleader2"></datalist>
           </div>
           <div class="form-group">
               <button type="button" id="query2"  class="btn btn-primary" onclick="query(2)">查询</button>
           </div>
           <div class="form-group">
               <button type="button"  id="export2" class="btn btn-primary" onclick="exportGridData(2)">导出</button>
           </div>
       </form>
	   <div class="ibox-content">
			<table id="list2" class="tablegrid"></table>
			<div id="pager2"></div>
	   </div>
	</div>
</div>
<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>
<!--加本页面 的js文件与js代码-->
<script type="text/javascript">
function getUrl(type){
	var startDate = $("#start_date" + type).val();
	var endDate = $("#end_date" + type).val();
	var site = $("#site" + type).val();
	var groupleader = $("#groupleader_input" + type).val();
	var url = "";
	if(type === 1){
		url = contextPath + '/report/daily_out_ebay_group_leader_reprots/grid?startDate=' + startDate + '&endDate=' + endDate;
	}else{
		url = contextPath + '/report/daily_out_ebay_group_leader_reprots/weekgrid?startDate=' + startDate + '&endDate=' + endDate;
	}
	if(site !== 'all'){url += "&zhandian=" + site;}
	if(groupleader !== 'all' && groupleader.length > 0){url += "&groupleader=" + groupleader;}
	return url;
}

function query(type){
	$('#list' + type).jqGrid('clearGridData');
	$('#list' + type).jqGrid('setGridParam', {url: getUrl(type)}).trigger('reloadGrid');
}
function exportGridData(type){
	var fileName = "Ebay组长站点发货业绩 " + new Date().getTime() + ".csv";
	var title = [ '日期','组长','站点','销售订单数量', '发货单数', '销售订单金额','发货收入','税前综合净利'];
	var column;
	if(type == 1){
		column = ['reportDate','groupleader','zhandian','salesorderNum','orderNum','salesorderTotal','productTotalCny','netProfit'];
	}else{
		column = ['startDate','groupleader','zhandian','salesorderNum','orderNum','salesorderTotal','productTotalCny','netProfit'];
	}
	var exportData = [];
	$.ajax({
		url : getUrl(type),
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.rows.length > 0){
				if(type == 1){
					for(var i=0;i<data.rows.length;i++){
						data.rows.reportDate = new Date(data.rows.reportDate).toLocaleDateString()
					}
				}
				exportData = data.rows;
			}
		}
	});
	exportDataToCSV('#list' + type,title,exportData,fileName,column,false);
}

(function(){
	$("#start_date1").jeDate({ isinitVal: true,initAddVal:{DD:"-15"},isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	$("#end_date1").jeDate({ isinitVal: true,isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	$("#start_date2").jeDate({ isinitVal: true,initAddVal:{DD:"-15"},isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	$("#end_date2").jeDate({ isinitVal: true,isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	$.ajax({
		url : contextPath + "/report/daily_out_ebay_group_leader_reprots/sites",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#site1").append("<option value='all'>全部</option>");
				$("#site2").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#site1").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
					$("#site2").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	$.ajax({
		url : contextPath + "/report/daily_out_ebay_group_leader_reprots/leaders",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#groupleader1").empty();
				$("#groupleader2").empty();
				for(var i=0;i<data.length;i++){
					$("#groupleader1").append("<option value='"+ data[i] +"'> </option>");
					$("#groupleader2").append("<option value='"+ data[i] +"'> </option>");
				}
			}
		}
	});
	
	common.grid({
		id:"#list1",
		title:"Ebay组长站点发货业绩 "
		,url:getUrl(1)
		,colNames:[ '日期','组长','站点','销售订单数量', '发货单数', '销售订单金额','发货收入','税前综合净利']
		,colModel:[ {name : 'reportDate',index : 'reportDate',width : 120,formatter:function(cellvalue, options, row){return new Date(cellvalue).toLocaleDateString()}}, 
		            {name : 'groupleader',index : 'groupleader',width : 100}, 
		            {name : 'zhandian',index : 'zhandian',width : 100},
		             {name : 'salesorderNum',index : 'salesorderNum',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}}, 
		             {name : 'orderNum',index : 'orderNum',sortable : "true",width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},
		             {name : 'salesorderTotal',index : 'salesorderTotal',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},
		             {name : 'productTotalCny',index : 'productTotalCny',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},
		             {name : 'netProfit',index : 'netProfit',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},]
		,sortname:"reportDate"
		,sortorder:"desc"
		,pager:"pager1"
		,height:"520px"
	});
	
	common.grid({
		id:"#list2",
		title:"Ebay业务线组长站点每周发货数据 "
		,url:getUrl(2)
		,colNames:[  '日期','组长','站点','销售订单数量', '发货单数', '销售订单金额','发货收入','税前综合净利']
		,colModel:[ {name : 'startDate',index : 'startDate',width : 120,}, 
		            {name : 'groupleader',index : 'groupleader',width : 100}, 
		            {name : 'zhandian',index : 'zhandian',width : 100}, 
		             {name : 'salesorderNum',index : 'salesorderNum',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"}, 
		             {name : 'orderNum',index : 'orderNum',sortable : "true",width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
		             {name : 'salesorderTotal',index : 'salesorderTotal',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
		             {name : 'productTotalCny',index : 'productTotalCny',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
		             {name : 'netProfit',index : 'netProfit',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},]
		,sortname:"reportDate"
		,sortorder:"desc"
		,pager:"pager2"
	});
})();
</script>
</body>
</html>
