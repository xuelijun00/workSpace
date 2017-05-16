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
    <div class="ibox-title"><h5>美仓sku销售报表</h5></div>
    <div class="ibox-content">
    <form class="form-inline">
            <div class="form-group">
              <label>开始时间</label>
              <input type="text" id="start_date" class="form-control" placeholder="">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date" class="form-control" placeholder="">
            </div>
            <div class="form-group">
             <label>SKU</label>
                        <input type="text" class="form-control" placeholder="请输入内容" id="sku" name="sku"
                               _value=""/>
            </div>
            <div class="form-group">
            <label>原始SKU</label>
                        <input type="text" class="form-control" placeholder="请输入内容" id="oldsku" name="oldsku"
                               _value=""/>
            </div>
            <div class="form-group">
               <button type="button" onclick="queryData()" class="btn btn-primary">查询</button>
            </div>
             <div class="form-group">
                <button type="button" id="export" onclick="exportData()" class="btn btn-primary">导出</button>
            </div>
        </form>
       
			<h5>表格</h5>
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
function queryData(){
	var sku = $('#sku').val().trim();
	var oldsku = $('#oldsku').val().trim();
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var chartUrl =  contextPath + '/report/ebayoverseassku/grid?business=Ebay_US&st=' + startDate + "&et=" + endDate+ "&oldsku=" + oldsku+ "&sku=" + sku;	
	common.refreshData(chartUrl,chart,operation);
}
function exportData(){
	var sku = $('#sku').val();
	var oldsku = $('#oldsku').val();
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var fileName = "Ebay业务线美仓每日sku销售数据" + startDate +"-"+ endDate + ".csv";
	var title = [ 'sku', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元'];
	var column = ['sku','skuOld','reportDate1','orders','quantity','sales'];
	
	var chartUrl =  contextPath + '/report/ebayoverseassku/grid?business=Ebay_US&st=' + startDate + "&et=" + endDate+ "&oldsku=" + oldsku+ "&sku=" + sku;	

	$.ajax({
		url : chartUrl,
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				domesticData = data;
			}
		}
	});
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
	
	var sku = $('#sku').val();
	var oldsku = $('#oldsku').val();
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var chartUrl =  contextPath + '/report/ebayoverseassku/grid?business=Ebay_US&st=' + startDate + "&et=" + endDate;
	var series = [];
	
	common.grid({
		title:"Ebay业务线美仓每日sku销售数据"
		,url:chartUrl
		,colNames:[ 'sku', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
			{name : 'sku',index : 'sku',width : 255}, 
            {name : 'skuOld',index : 'skuOld',width : 205}, 
            {name : 'reportDate1',index : 'reportDate1',align : "right",width : 205}, 
            {name : 'orders',index : 'orders',sortable : "true",width : 205},
            {name : 'quantity',index : 'quantity',sortable : "true",width : 205},
            {name : 'sales',index : 'sales',sortable : "true",width : 205}
		           ]
		,sortname:"reportDate1"
		,sortorder:"asc"
		,height  : "400"
	});
})();
</script>
</body>
</html>
