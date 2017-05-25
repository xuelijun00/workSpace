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
    <div class="ibox-title"><h5>各平台各账号管理员业绩</h5></div>
    <div class="ibox-content">
    	<form class="form-inline">
           <div class="form-group">
             <label>开始时间</label>
             <input type="text" id="start_date1"class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
             <label>结束时间</label>
             <input type="text" id="end_date1" class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
               <label>平台：</label>
               <select class="form-control w120" id="platform1" >
               </select>
           </div>
           <div class="form-group">
               <label>管理员：</label>
               <input id="manager_input1" list="manager1" />
			<datalist id="manager1"></datalist>
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
               <select class="form-control w120" id="platform2" >
               </select>
           </div>
           <div class="form-group">
               <label>管理员：</label>
               <input id="manager_input2" list="manager2" />
			<datalist id="manager2"></datalist>
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
	var platform = $("#platform" + type).val();
	var manager = $("#manager_input" + type).val();
	var url = "";
	if(type === 1){
		url = contextPath + '/report/daily_out_manager_sum/grid?startDate=' + startDate + '&endDate=' + endDate;
	}else{
		url = contextPath + '/report/daily_out_manager_sum/weekgrid?startDate=' + startDate + '&endDate=' + endDate;
	}
	if(platform !== 'all'){url += "&platform=" + platform;}
	if(manager !== 'all' && manager.length > 0){url += "&manager=" + manager;}
	return url;
}
function platform(type){
	var url = contextPath + "/report/daily_out_manager_sum/managers";
	var platform = $("#platform"+ type).val();
	if(platform !== 'all'){
		url += "?platform=" + platform;
	}
	$.ajax({
		url : url,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#manager" + type).empty();
				for(var i=0;i<data.length;i++){
					$("#manager" + type).append("<option value='"+ data[i] +"'> </option>");
				}
			}
		}
	});
}
$("#platform1").bind("change",platform(1));
$("#platform2").bind("change",platform(2));
function query(type){
	$('#list' + type).jqGrid('clearGridData');
	$('#list' + type).jqGrid('setGridParam', {url: getUrl(type)}).trigger('reloadGrid');
}
function exportGridData(type){
	//debugger;
	var fileName = "各平台各账号管理员业绩" + new Date().getTime() + ".csv";
	var title = [ '管理员', '日期','销售订单数量', '发货单数', '销售订单金额','发货收入','税前综合净利'];
	var column;
	if(type == 1){
		column = ['manager','reportDate1','salesorderNum','orderNum','salesorderTotal','productTotalCny','netProfit'];
	}else{
		column = ['manager','startDate','salesorderNum','orderNum','salesorderTotal','productTotalCny','netProfit'];
	}
	var exportData = [];
	$.ajax({
		url : getUrl(type),
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.rows.length > 0){
				exportData = data.rows;
			}
		}
	});
	exportDataToCSV('#list' + type,title,exportData,fileName,column);
}

(function(){
	$("#start_date1").jeDate({ isinitVal: true,initAddVal:{DD:"-15"},isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	$("#end_date1").jeDate({ isinitVal: true,isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	$("#start_date2").jeDate({ isinitVal: true,initAddVal:{DD:"-15"},isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	$("#end_date2").jeDate({ isinitVal: true,isTime:false,ishmsVal: false,format: "YYYY-MM-DD",zIndex:3000});
	$.ajax({
		url : contextPath + "/report/daily_out_manager_sum/platforms",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#platform1").append("<option value='all'>全部</option>");
				$("#platform2").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#platform1").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
					$("#platform2").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	
	common.grid({
		id:"#list1",
		title:"各平台各账号管理员业绩"
		,url:getUrl(1)
		,colNames:[ '管理员', '日期','销售订单数量', '发货单数', '销售订单金额','发货收入','税前综合净利']
		,colModel:[ {name : 'manager',index : 'manager',width : 100}, 
		             {name : 'reportDate1',index : 'reportDate1',width : 120}, 
		             {name : 'salesorderNum',index : 'salesorderNum',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}}, 
		             {name : 'orderNum',index : 'orderNum',sortable : "true",width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},
		             {name : 'salesorderTotal',index : 'salesorderTotal',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},
		             {name : 'productTotalCny',index : 'productTotalCny',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},
		             {name : 'netProfit',index : 'netProfit',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},]
		,sortname:"reportDate1"
		,sortorder:"asc"
		,pager:"pager1"
		,height:"520px"
	});
	
	common.grid({
		id:"#list2",
		title:"各平台各账号管理员业绩"
		,url:getUrl(2)
		,colNames:[ '管理员', '日期','销售订单数量', '发货单数', '销售订单金额','发货收入','税前综合净利']
		,colModel:[ {name : 'manager',index : 'manager',width : 100}, 
		             {name : 'startDate',index : 'startDate',width : 120}, 
		             {name : 'salesorderNum',index : 'salesorderNum',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}}, 
		             {name : 'orderNum',index : 'orderNum',sortable : "true",width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},
		             {name : 'salesorderTotal',index : 'salesorderTotal',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},
		             {name : 'productTotalCny',index : 'productTotalCny',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},
		             {name : 'netProfit',index : 'netProfit',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ','}},]
		,sortname:"startDate"
		,sortorder:"asc"
		,pager:"pager2"
		,height:"520px"
	});
})();
</script>
</body>
</html>
