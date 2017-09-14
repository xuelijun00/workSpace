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
	 	<div class="ibox-title"><h5>各平台各月业绩完成率（注意：本页面的货币单位，均是（美元））</h5></div>
		<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		<form class="form-inline" id="form">
            <div class="form-group">
                <label>平台：</label>
                <select class="form-control w120" name="name" id="name">
                    
                </select>
            </div>
            <div class="form-group">
              <label>月份：</label>
              <input type="text" id="month" class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
                <button type="button" id="platform_query" onclick="targetCompletionRate.refreshData()" class="btn btn-primary">查询</button>
            </div>
            <div class="form-group">
                <button type="button" id="export" onclick="targetCompletionRate.exportData()" class="btn btn-primary">导出</button>
            </div>
        </form>
		<div class="ibox-content">
			<table id="list2" class="tablegrid"></table>
			<div id="pager2"></div>
		</div>
	</div>
	<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>
	<script type="text/javascript" src="js/report/target_completion_rate.js" ></script>
	<!--加本页面 的js文件与js代码-->
</body>
</html>
