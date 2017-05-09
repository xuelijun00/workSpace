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
<link rel="shortcut icon" href="./favicon.ico">
<link href="css/bootstrap.min14ed.css?20170108" rel="stylesheet">
<link href="css/font-awesome.min93e3.css?20170108" rel="stylesheet">
<link href="css/style.min862f.css?20170108" rel="stylesheet">
<link href="css/self.css?20170302" rel="stylesheet">
<!-- jqGrid组件基础样式包-必要 -->
<link rel="stylesheet" href="js/plugins/jqGrid521/css/ui.jqgrid.css" />
<link rel="stylesheet" href="js/plugins/jqGrid521/css/jquery-ui-1.8.16.custom.css" />
<script type="text/javascript">
	var contextPath = '${pageContext.request.contextPath}';
</script>
<!--加css-->
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		
		<div class="ibox-title">
			<h5>表格</h5>
		</div>
		<div class="ibox-content">
			<table id="list2" class="tablegrid"></table>
			<div id="pager2"></div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.min.js?v=2.1.4"></script>
	<script type="text/javascript" src="js/bootstrap.min.js?v=3.3.6"></script>
	<script type="text/javascript" src="js/plugins/jqGrid521/js/jquery.jqGrid.min.js"></script>
	<script type="text/javascript" src="js/plugins/jqGrid521/js/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="js/plugins/highcharts/highcharts.js"></script>
	<script type="text/javascript" src="js/plugins/highcharts/exporting.js"></script>
	<script type="text/javascript" src="js/plugins/date/jedate.min.js"></script>
	<script type="text/javascript" src="js/self.js"></script>
	
	<script type="text/javascript" src="js/report/target_completion_rate.js" ></script>
	<!--加本页面 的js文件与js代码-->
</body>
</html>
