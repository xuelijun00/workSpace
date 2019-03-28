<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>YKSUI框架 - 500错误</title>
    <script src="${pageContext.request.contextPath }/jsLoad/code/load.js" include="../top.html"></script>
    <!--加css-->
</head>

<body class="gray-bg">
    <div class="middle-box text-center animated fadeInDown">
        <h1>403</h1>
        <h3 class="font-bold">权限验证</h3>
        <div class="error-desc">
            您的权限不足以访问...
            <br/>您可以返回主页看看
            <br/><a href="###" onclick="tz()" class="btn btn-primary m-t">主页</a>
        </div>
    </div>
    <script src="${pageContext.request.contextPath }/jsLoad/code/load.js" include="../js.html"></script>
    <!--加本页面 的js文件与js代码-->
    <script type="text/javascript">
    function tz(){
		window.top.location.href="${pageContext.request.contextPath }/index"
	}
    </script>
</body>


</html>
