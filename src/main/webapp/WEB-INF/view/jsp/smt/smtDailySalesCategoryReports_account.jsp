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
             <input type="text" id="start_date2" class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
             <label>结束时间</label>
             <input type="text" id="end_date2" class="form-control" placeholder="" readonly="readonly">
           </div>
           <div class="form-group">
           	<label>分类:</label>
              	<select class="form-control w120" id="category2" name="category">
               </select>
           </div>
           <div class="form-group">
              <button type="button" onclick="queryData(2)" class="btn btn-primary">查询</button>
           </div>
       </form>
	</div>
	<div class="hr-line-dashed"></div>
    <div id="container" style="min-width: 310px; height: 500px; margin: 0 auto"></div>

    <div class="ibox-content">
    <form class="form-inline">
            <div class="form-group">
              <label>开始时间</label>
              <input type="text" id="start_date1" class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date1" class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
            	<label>分类:</label>
               	<select class="form-control w120" id="category1" name="category">
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
               <button type="button" onclick="queryData(1)" class="btn btn-primary">查询</button>
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

function getUrl(type){
	var startDate = $('#start_date' + type).val();
	var endDate = $('#end_date' + type).val();
	var category = encodeURIComponent($('#category' +type).val());
	var categorySupervisor = $('#categorySupervisor').val();
	var account = $('#account_input').val();
	url = '';
	if(type === 1){
		url = contextPath + '/report/daily_sales_category_account/smt/grid?startDate=' + startDate + "&endDate=" + endDate;
		if(categorySupervisor !== 'all' && categorySupervisor !== null){
			url+= '&categorySupervisor=' + categorySupervisor
		}

		if(account !== null){
			url+= '&account=' + account
		}
	}else{
		url = contextPath + '/report/daily_sales_category_account/smt/chart?startDate=' + startDate + "&endDate=" + endDate;
	}

	if(category !== 'all' && category !== null){
		url+= '&category=' + category
	}
	
	return url;
}

function queryData(type){
	if(type === 1){
		common.refreshData(getUrl(1),chart,operation);
	}else{
		common.echartsPie(getChartData(getUrl(2)));
	}
}
function exportData(){
	var startDate = $("#start_date1").val();
	var endDate = $("#end_date1").val();
	var fileName = "smt业务线账号品类销售数据" + startDate +"-"+ endDate + ".csv";
	var title = [ '分类', '日期（day）', '品类主管', '账号', '订单数' , '订单金额_美元'];
	var column = ['category','reportDate','categorySupervisor','account','orders','sales'];

	$.ajax({
		url : getUrl(1),
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

function getChartData(chartUrl){
	var salesSum = new Array();
	var categoryData = [];
	$.ajax({
		url : chartUrl,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				domesticData = data;
				for(var i=0;i<data.length;i++){
					categoryData.push(data[i].category);
	            	salesSum.push({'value': data[i].sales.toFixed(2), 'name': data[i].category});
	            }
			}
		}
	});

	var series = [
		{
			name: '品类',
			type: 'pie',
			radius:'60%',
			center:['50%', '45%'],
			data: salesSum,
		}
	];
	return {
		legend: {
			orient: 'vertical',
			left: 'left',
			data: categoryData,
		}
		,label: {
	        normal: {
	      		formatter: "{b}({d}%)"
	        }
	    }
		,title: {text: 'SMT订单金额汇总（按时间段和品类汇总）', x: 'center'}  
		,series: series
		,tooltipFormatter: "{a} <br/> {b} <br/> 订单金额 （美元）: {c} ({d}%)"
		,
};
}

(function(){
	$("#start_date1").jeDate({
        isinitVal: true,
        initAddVal:{DD:"-14"},
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
        initAddVal:{DD:"-14"},
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
		url : contextPath + "/report/daily_sales_category_account/smt/category",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#category1").append("<option value='all'>全部</option>");
				$("#category2").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#category1").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
					$("#category2").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
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
	chart = common.echartsPie(getChartData(getUrl(2)));
	
	common.grid({
		title:"smt业务线账号品类销售数据"
		,url:getUrl(1)
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
