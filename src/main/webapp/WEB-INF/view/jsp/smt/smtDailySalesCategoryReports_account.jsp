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
            	<label>分类:</label>
               	<select class="form-control w120" id="category" name="category">
                </select>
            </div>
            <div class="form-group">
            	<label>品类主管:</label>
               <select class="form-control w120" id="categorySupervisor" name="categorySupervisor">
                </select>
            </div>
            <div class="form-group">
                <label>账号：</label>
                <input id="account_input" list="account" />
				<datalist id="account"></datalist>
            </div> 
            <div class="form-group">
               <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
            </div>
             <div class="form-group">
                <button type="button" id="export" onclick="exportData()" class="btn btn-primary">导出</button>
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
	var category = encodeURIComponent($('#category').val());
	var categorySupervisor = $('#categorySupervisor').val();
	var account = $("#account_input").val();
	var url = contextPath + '/report/daily_sales_category_account/smt/grid?startDate=' + startDate + "&endDate=" + endDate;

	if(category !== 'all' && category !== null){
		url+= "&category=" + category
	}

	if(categorySupervisor !== 'all' && categorySupervisor !== null){
		url+= "&categorySupervisor=" + categorySupervisor
	}

	if(account !== null){
		url+= "&account=" + account
	}

	return url;
}

function queryData(){
	common.refreshData(getUrl(),chart,operation);
}
function exportData(){
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "smt业务线账号品类销售数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '分类', '日期（day）', '品类主管', '账号', '订单数' , '订单金额_美元'];
	var column = ['category','reportDate','categorySupervisor','account','orders','sales'];

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
	
	$.ajax({
		url : contextPath + "/report/daily_sales_category_account/smt/category",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#category").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#category").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	
	$.ajax({
		url : contextPath + "/report/daily_sales_category_account/smt/categorySupervisor",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#categorySupervisor").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#categorySupervisor").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	
	$.ajax({
		url : contextPath + "/report/daily_sales_category_account/smt/account",
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
	/* var series = []; */
	
	common.grid({
		title:"smt业务线账号品类销售数据"
		,url:getUrl()
		,colNames:[ '分类', '日期（day）', '品类主管', '账号', '订单数' , '订单金额_美元']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
			{name : 'category',index : 'category',width : 215}, 
            {name : 'reportDate',index : 'reportDate',width : 155}, 
            {name : 'categorySupervisor',index : 'categorysupervisor',width : 125},
            {name : 'account',index : 'account',width : 205},
            {name : 'orders',index : 'orders',sortable : "true",width : 105,formatter:'integer', formatoptions:{thousandsSeparator: ','},align:"right"},
            {name : 'sales',index : 'sales',sortable : "true",width : 155,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}
		           ]
		,sortname:"reportDate"
		,sortorder:"desc"
	});
})();
</script>
</body>
</html>
