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
              <input type="text" id="start_date"class="form-control" placeholder="">
            </div>
            <div class="form-group">
              <label>结束时间</label>
              <input type="text" id="end_date" class="form-control" placeholder="">
            </div>
            <div class="form-group">
                <label>平台：</label>
                <select class="form-control w120" id="platform" name="platform">
                </select>
            </div>
             <div class="form-group">
            <label>分类</label>
                        <input type="text" class="form-control" placeholder="请输入内容" id="category" name="category"
                               _value=""/>
            </div>
             <div class="form-group">
            <label>原始SKU</label>
                        <input type="text" class="form-control" placeholder="请输入内容" id="oldsku" name="oldsku"
                               _value=""/>
            </div>
           <!--  <div class="form-group">
                <label>账号：</label>
                <input id="account_input" list="account" />
				<datalist id="account"></datalist>
            </div> -->
            
            <div class="form-group">
                <button type="button" id="query"  class="btn btn-primary">查询</button>
            </div>
            <div class="form-group">
                <button type="button"  id="export" class="btn btn-primary">导出</button>
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
var chartUrl;

function getUrl(){	
	var category = $("#category").val();
	var oldsku = $("#oldsku").val();
	var startDate = $("#start_date").val();
	var endDate = $("#end_date").val();
	var platform = $("#platform").val();
	var chartUrl = contextPath + '/report/ebayoverseascategorynew/grid?st=' + startDate + '&et=' + endDate+ "&oldsku=" + oldsku+ "&category=" + category;
	if(platform !== 'all'){chartUrl += "&business=" + platform;}
	return chartUrl;
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
		url : contextPath + "/report/xueplatforms/platformnew",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#platform").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#platform").append("<option value='"+ data[i].business +"'>"+ data[i].business +"</option>");
				}
			}
		}
	});
	
	$("#query").bind("click",function(){
		common.refreshData(getUrl(),chart,operation);
	});
	$("#export").bind("click",function(){
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
		
		var fileName = "新平台业务线每日分类销售数据.csv";
		var title = [ '分类','业务线', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元'];
		var column = ['category','business','skuOld','reportDate1','orders','quantity','sales'];
		
		exportDataToCSV('#list2',title,domesticData,fileName,column);
	});
	
	common.grid({
		title:"新平台业务线每日分类销售数据"
		,url:getUrl()
		,colNames:[ '分类','业务线', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元']
		,colModel:[ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
			{name : 'category',index : 'category',width : 215}, 
			{name : 'business',index : 'business',width : 175}, 
            {name : 'skuOld',index : 'skuOld',width : 175}, 
            {name : 'reportDate1',index : 'reportDate1',align : "right",width : 175}, 
            {name : 'orders',index : 'orders',sortable : "true",width : 145},
            {name : 'quantity',index : 'quantity',sortable : "true",width : 145},
            {name : 'sales',index : 'sales',sortable : "true",width : 155}
		           ]
		,sortname:"reportDate1"
		,sortorder:"asc"
		,height  : "400"
	});
})();
</script>
</body>
</html>
