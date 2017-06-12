<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="js/plugins/jqGrid521/css/jquery-ui-1.8.16.custom.css" />
<link rel="shortcut icon" href="./favicon.ico">
<link href="css/bootstrap.min14ed.css?20170108" rel="stylesheet">
<link href="css/font-awesome.min93e3.css?20170108" rel="stylesheet">
<link href="css/style.min862f.css?20170108" rel="stylesheet">
<link href="css/self.css?20170302" rel="stylesheet">
<!-- jqGrid组件基础样式包-必要 -->
<link rel="stylesheet" href="js/plugins/jqGrid521/css/ui.jqgrid.css" />
<link rel="stylesheet" href="js/plugins/jqGrid521/css/ui.jqgrid-bootstrap.css" />
<link rel="stylesheet" href="js/plugins/jqGrid521/css/ui.jqgrid-bootstrap-ui.css" />
<link rel="stylesheet" href="js/plugins/jeDate/jedate/skin/jedate.css" />


<!--加本页面 的js文件与js代码-->
<script type="text/javascript" src="js/jquery.min.js?v=2.1.4"></script>
<script type="text/javascript" src="js/bootstrap.min.js?v=3.3.6"></script>
<script type="text/javascript" src="js/plugins/jqGrid521/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="js/plugins/jqGrid521/js/i18n/grid.locale-cn.js"></script>
<!-- <script type="text/javascript" src="js/plugins/highcharts/highcharts.js"></script> -->
<script type="text/javascript" src="js/plugins/highcharts/highstock.js"></script>
<script type="text/javascript" src="js/plugins/highcharts/exporting.js"></script>
<script type="text/javascript" src="js/plugins/highcharts/export-csv.js"></script>
<script type="text/javascript" src="js/plugins/jeDate/jedate/jquery.jedate.js"></script>
<script type="text/javascript" src="js/plugins/jqGrid521/js/jqgrid.export.js"></script>
<script type="text/javascript" src="js/common/common.js" ></script>
<script type="text/javascript">
	var contextPath = '${pageContext.request.contextPath}';
	$(document).ready(function() {
	    $(document).ajaxError(function(){window.top.location.href= contextPath+ "/";});
	});
</script>
