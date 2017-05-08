<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
   <!--  <link rel="stylesheet" type="text/css" href="css/greenlogin.css"> -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="css/base.css" rel="stylesheet" type="text/css">
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
	    var contentPath = '${pageContext.request.contextPath}';
	</script>
</head>
<body>

<div >
    <div class="container">
        <div class="row">
            <div class="col-md-6"><img src="./img/yksbi.png" width="600" height="48"></div>
            <div class="col-md-6"><P class="t_data text-right">抓取账号：<span class="t_bluedata"> 3,638,934 </span>个；  抓取商品：<span class="t_bluedata"> 67,270,862</span> 个。</P></div>
        </div>
    </div>
    <div class="container-fluid loginbc">
        <div class="container loginbg">
            <div class="admin_login">
    <div class="login">
        <p class="b20">账户登录</p>
        <form class="form">
         <div >
                <div >
                    <ul  class="input-group">
                        <li class="row1">用户名：</li>
                        <li class="row2"><input class="input" name="username" size="30" type="text" checkfor="not_empty" alertfor="ä¸è½ä¸ºç©º"></li>
                    </ul>
                    <ul class="input-group">
                        <li class="row1">密码：</li>
                        <li class="row2"><input class="input" name="password" size="30" type="password" checkfor="not_empty" alertfor="ä¸è½ä¸ºç©º"></li>
                    </ul>
                </div>
             &nbsp;&nbsp;&nbsp;&nbsp;   <div class="operation">
                    <button class="btn btn-primary login-button"  id="login-button" type="button" >登入</button>
                </div>
            </div>
             <div id="error"  class="yanshi"></div>
        </form>
    </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row t80">
            <div class="col-xs-6 col-md-4 p40 boxright boxbottom">
                <p class="text-center"><img src="img/login_16.jpg" height="89"></p>
                <h2 class="text-center h2text">数据汇集</h2>
                <p class="ptext">通过最新的分布式scala网络爬虫，实时监控Ebay平台全网产品分类下的卖家信息，实时获取优质帐号的产品数据，去其糟粕，汇集优质产品。</p>
            </div>
            <div class="col-xs-6 col-md-4 p40 boxright boxbottom">
                <p class="text-center"><img src="img/login_13.jpg" height="89"></p>
                <h2 class="text-center h2text">数据存储</h2>
                <p class="ptext">强大的云存储，由阿里团队研发的海量存储中间件Cobar，进化为分布式数据存储方案Mycat，保障了数据的安全、稳定。</p>
            </div>
            <div class="col-xs-6 col-md-4 p40 boxbottom">
                <p class="text-center"><img src="img/login_10.jpg" height="89"></p>
                <h2 class="text-center h2text">数据处理</h2>
                <p class="ptext">数据处理采用行内先进的Spark分布式计算框架和分布式消息中间件。 处理方式采用工业化流水线方式对数据进行流程化加工。采用Spark Streaming和分布式消息队列进行实时并行过滤、分析进行数据上下文交换。</p>
            </div>
            <div class="col-xs-6 col-md-4 p60 boxright">
                <p class="text-center"><img src="img/login_28.jpg" width="99" height="90"></p>
                <h2 class="text-center h2text">数据服务</h2>
                <p class="ptext">服务于公司出口事业部国内仓、海外仓等新品情报挖掘的情报采集和情报分析工作，节约了市场产品研究的人力成本，提高了新品开发的工作产能。</p>
            </div>
            <div class="col-xs-6 col-md-4 p60 boxright">
                <p class="text-center"><img src="img/login_22.jpg" height="90"></p>
                <h2 class="text-center h2text">数据分析</h2>
                <p class="ptext">数据分析采用Spark计算框架进行对海量数据抽取特征数据进行适当的统计分析方法，提取有用的信息和形成结论而对数据加以详细的研究和概括。数据分析可以帮忙做出决策，以便采用适当行动。</p>
            </div>
            <div class="col-xs-6 col-md-4 p60">
                <p class="text-center"><img src="img/login_25.jpg" height="90"></p>
                <h2 class="text-center h2text">数据可视化</h2>
                <p class="ptext">卖家帐号监控实时监控可视化，产品分析数据可视化，新品开发工作流可视化，流程清晰，操作简洁。</p>
            </div>
        </div>
    </div>
    <div class="container-fluid footcopy t80">
        <p class="text-center">有棵树公司版权所有©2010-2017</p></div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</body>
</html>