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
               <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
            </div>
            <div class="form-group">
                <button type="button" id="export" onclick="exportData()" class="btn btn-primary">导出</button>
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
var chart;
var operation;
var domesticData = [];

function getUrl(type){//拼接url
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	/* if(type === 1){
		return contextPath + '/report/dailyBuyerCountrySales/grid?platform=ebay&st=' + startDate + "&et=" + endDate;
	}else{ */
	return contextPath + '/report/dailyBuyerCountrySales/grid?platform=wish&startDate=' + startDate + "&endDate=" + endDate;
	/* } */
}
function queryData(){	
	common.refreshData(getUrl(),chart,operation);
}
function exportData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "Wish买家国家交易数据" + startDate +"-"+ endDate + ".csv";
	var title = [  '平台', '买家国家', '日期（day）', '订单数' , '数量' , '销售额'];
	var column = ['platform','buyerCountry','reportDate','orders','quantity','sales'];
	$.ajax({
		url : getUrl(),
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
	
	var series = [];
	
	common.grid({
		title:"Wish买家国家交易数据"
		,url:getUrl()
		,colNames:[ '平台', '买家国家', '日期（day）', '订单数' ,'数量' ,'销售额']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
			{name : 'platform',index : 'platform',width : 255}, 
			{name : 'buyerCountry',index : 'buyerCountry',width : 255}, 
			{name : 'reportDate',index : 'reportDate',align : "right",width : 205}, 
            {name : 'orders',index : 'orders',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
            {name : 'quantity',index : 'quantity',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
            {name : 'sales',index : 'sales',sortable : "true",width : 205,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}
		           ]
		,sortname:"reportDate"
		,sortorder:"desc"
	});
})();
</script>
</body>
</html>