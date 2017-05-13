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
		<form class="form-inline" id="form">
            <div class="form-group">
                <label>平台：</label>
                <select class="form-control w120" name="platform" id="platform">
                    
                </select>
            </div>
            <div class="form-group">
                <label>月份：</label>
                <select class="form-control w120" name="month" id="month">
                    <option value='1'>一月</option>
                    <option value='2'>二月</option>
                    <option value='3'>三月</option>
                    <option value='4'>四月</option>
                    <option value='5'>五月</option>
                    <option value='6'>六月</option>
                    <option value='7'>七月</option>
                    <option value='8'>八月</option>
                    <option value='9'>九月</option>
                    <option value='10'>十月</option>
                    <option value='11'>十一月</option>
                    <option value='12'>十二月</option>
                </select>
            </div>
            <div class="form-group">
                <button type="button" id="platform_query" onclick="targetCompletionRate.refreshData('platform')" class="btn btn-primary">查询</button>
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
	<script type="text/javascript" src="js/jquery.min.js?v=2.1.4"></script>
	<script type="text/javascript" src="js/bootstrap.min.js?v=3.3.6"></script>
	<script type="text/javascript" src="js/plugins/jqGrid521/js/jquery.jqGrid.min.js"></script>
	<script type="text/javascript" src="js/plugins/jqGrid521/js/i18n/grid.locale-cn.js"></script>
	<script type="text/javascript" src="js/plugins/highcharts/highcharts.js"></script>
	<script type="text/javascript" src="js/plugins/highcharts/exporting.js"></script>
	<script type="text/javascript" src="js/self.js"></script>
	<script type="text/javascript" src="js/plugins/jqGrid521/js/jqgrid.export.js"></script>
	
	<script type="text/javascript" src="js/report/target_completion_rate.js" ></script>
	<!--加本页面 的js文件与js代码-->
</body>
</html>
