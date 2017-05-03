<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="../js/jqgrid/ui.jqgrid.css" />
<link rel="stylesheet" href="../js/jqgrid/jquery-ui-1.8.16.custom.css" />
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../js/jqgrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="../js/jqgrid/grid.locale-cn.js"></script>
<title>Insert title here</title>
</head>
<body>

<%-- <c:forEach items="${userInfos }" var="user" varStatus="u">
	<div>${user.account }</div>
</c:forEach> --%>

<table id="list"></table> 
<div id="pager"></div>
<script type="text/javascript">
$(function(){
	 jQuery("#list").jqGrid({
        url : '${pageContext.request.contextPath}' + '/user/api/alluser',
        datatype : "json",
        colNames : [ 'id' , 'account', 'sales', 'sales_assistant', 'store_name','act_status', 'fetch_time'],
        colModel : [ 
                     {name : 'id',index : 'id',width : 55}, 
                     {name : 'account',index : 'account',width : 90}, 
                     {name : 'sales',index : 'sales',width : 100}, 
                     {name : 'salesAssistant',index : 'sales_assistant',width : 80,align : "right"}, 
                     {name : 'storeName',index : 'store_name',width : 80,align : "right"}, 
                     {name : 'actStatus',index : 'act_status',width : 80,align : "right"}, 
                     {name : 'fetchTime',index : 'fetch_time',width : 150,sortable : false}
                   ],
        rowNum : 10,
        rowList : [ 10, 20, 30],
        pager : '#pager',
        sortname : 'id',
        sortorder:"asc",
        mtype : "get",
        viewrecords : true,
        multiselect : true,
        height:"auto",
        caption : "账号信息"
	});
	jQuery("#list").jqGrid('navGrid', '#pager', {edit : false,add : false,del : false});
})

</script>

</body>
</html>