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
    <div class="ibox-title"><h5>Ebay业务线每日销售数据</h5></div>
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
                <button type="button" onclick="refreshGridData()" class="btn btn-primary">查询</button>
            </div>
             <div class="form-group">
                <button type="button" id="export" onclick="exportData()" class="btn btn-primary">导出</button>
            </div>
        </form>
        <div class="hr-line-dashed"></div>
        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
        <div class="ibox-title">
			<h5>表格</h5>
		</div>
		<div class="ibox-content">
			<table id="list2" class="tablegrid"></table>
			<div id="pager2"></div>
		</div>
        
</div>

</div>
<!-- <script src="../jsLoad/code/load.js?20170503" include="../jsh.html"></script> -->

<!--加本页面 的js文件与js代码-->
	<script type="text/javascript" src="js/jquery.min.js?v=2.1.4"></script>
	<script type="text/javascript" src="js/bootstrap.min.js?v=3.3.6"></script>
	<script type="text/javascript" src="js/plugins/jqGrid521/js/jquery.jqGrid.min.js"></script>
	<script type="text/javascript" src="js/plugins/jqGrid521/js/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="js/plugins/highcharts/highcharts.js"></script>
	<script type="text/javascript" src="js/plugins/highcharts/exporting.js"></script>
	<script type="text/javascript" src="js/plugins/date/jedate.min.js"></script>
	<script type="text/javascript" src="js/self.js"></script>
	<script type="text/javascript" src="js/plugins/jqGrid521/js/jqgrid.export.js"></script>
	<script type="text/javascript" src="js/report/walMart/walmartdomerstic.js" ></script>
	<!--加本页面 的js文件与js代码-->
</body>
</html>
