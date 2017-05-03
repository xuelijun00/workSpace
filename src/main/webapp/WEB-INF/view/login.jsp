<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@include file="../include/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script src="js/login.js" type="text/javascript"></script>
<title>一切从这里开始</title>
</head>
<body>
	<%-- ${pageContext.request.contextPath} --%>
	<!-- <audio autoplay="autoplay" loop="loop">
		<source src="images/Fade.mp3">
	</audio> -->
	<div class="wrapper">
		<div class="container">
			<h1>欢迎登陆</h1>
			<form class="form">
				<input type="text" name="username" placeholder="用户名" /> 
				<input type="password" name="password" placeholder="密码" />
				<button type="button" id="login-button">登陆</button>
			</form>
			<div id="error" style="color:red;"></div>
			<ul class="bg-bubbles">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
</body>
</html>