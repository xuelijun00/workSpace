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
	 	<div class="ibox-title"><h5>新平台二部各月业绩完成率（注意：本页面的货币单位，均是（美元））</h5></div>
		<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		<form class="form-inline" id="form">
           <div class="form-group">
              <label>开始月份：</label>
              <input type="text" id="startMonth" class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
              <label>结束月份：</label>
              <input type="text" id="endMonth" class="form-control" placeholder="" readonly="readonly">
            </div>
            <div class="form-group">
                <button type="button" id="platform_query" onclick="targetCompletionRateCommon.refreshData(test.getUrl(1),test.getUrl())" class="btn btn-primary">查询</button>
            </div>
            <div class="form-group">
                <button type="button" id="export" onclick="targetCompletionRateCommon.exportData(test.getUrl(1),test.BUSINESS)" class="btn btn-primary">导出</button>
            </div>
        </form>
		<div class="ibox-content">
			<table id="list2" class="tablegrid"></table>
			<div id="pager2"></div>
		</div>
	</div>
	<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>
	<!--加本页面 的js文件与js代码-->
	<script type="text/javascript">
	var test = {
			getUrl:function(type){
			var startMonth = $("#startMonth").val();
			var endMonth = $("#endMonth").val();
			var url = '';
			if(type === 1){
				url = contextPath + '/report/targetcompletioncrate/branch/grid?name=新平台二部&startMonth=' + startMonth + '&endMonth=' + endMonth;
			}else{
				url = contextPath + '/report/targetcompletioncrate/branch/histogram?name=新平台二部&startMonth=' + startMonth + '&endMonth=' + endMonth;
			}
			return url;
		},
			BUSINESS : '新平台二部'
	}
	</script>
	<script type="text/javascript" src="js/report/target_completion_rate_common.js" ></script>
</body>
</html>
