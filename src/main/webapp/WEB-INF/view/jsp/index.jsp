<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>YKSBI系统 - 主页</title>
    <script src="jsLoad/code/load.js" include="../top.html"></script>
    <!--加css-->
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <!-- <script type="text/javascript">
    debugger;
	    var user = "${sessionScore.systemUser.id }";
	    if(!user || user.length <=0 ){
	    	window.location.href="${pageContext.request.contextPath}/";
	    }
    </script> -->
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <div class="logo-element nav-header">
            <span class="logotitle" ><i class="glyphicon glyphicon-tree-conifer"></i>YKSBI系统</span></div>
            <ul class="nav" id="side-menu">
                <li>
                    <a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=target_completion_rate/1month" >
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                    </a>
                </li>
              <!--   <li>
                    <a href="#"><i class="fa fa-flask"></i> <span class="nav-label">UI元素</span><span class="fa
                        arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="typography.html">排版</a>
                        </li>
                        <li>
                            <a href="#">字体图标 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a class="J_menuItem" href="iconfont.html">阿里巴巴矢量图标库</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">拖动排序 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="draggable_panels.html">拖动面板</a>
                                </li>
                                <li><a class="J_menuItem" href="agile_board.html">任务清单</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="J_menuItem" href="buttons.html">按钮</a>
                        </li>
                        <li><a class="J_menuItem" href="tabs_panels.html">选项卡 &amp; 面板</a>
                        </li>
                        <li><a class="J_menuItem" href="notifications.html">通知 &amp; 提示</a>
                        </li>
                        <li><a class="J_menuItem" href="badges_labels.html">徽章，标签，进度条</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="grid_options.html">栅格</a>
                        </li>
                    </ul>
                </li> -->
                <!-- <li>
                    <a href="#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">BI图表实例 </span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="echarts/highcharts.html">echarts 百度</a>
                        </li>
                        <li><a class="J_menuItem" href="echarts/jqgirddemo.html">jqGird表格</a>
                        </li>
                        <li><a class="J_menuItem" href="echarts/data.html">从HTML表格中提取数据并生成图表</a>
                        </li>
                        
                    </ul>
                </li> -->
                <li>
                    <a href="#"><i class="fa fa-pie-chart"></i> <span class="nav-label">业绩汇总</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=performance_summary/salespPerformance">销售业绩整体报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=performance_summary/platform_salesp_performance">各平台销售业绩报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=performance_summary/domestic_warehouse_hipment">国内仓发货汇总数据</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=performance_summary/platform_warehouse_hipment">国内仓各平台发货数据</a>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=net_profit_details/netProfitDetails">净利导出明细</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-industry"></i> <span class="nav-label">目标完成率</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=target_completion_rate/1month">各平台各月业绩完成率 </a>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=target_completion_rate/target_managerment">各平台目标管理</a></li>
                    </ul>
                </li>
                 <li>
                    <a href="#"><i class="fa fa-line-chart"></i> <span class="nav-label">eBay国内仓</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_domestic_warehouse/ebayDailySales">eBay每日销售额</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_domestic_warehouse/leader_daily_out_report">eBay站点发货业绩</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_domestic_warehouse/ebaySkuSales">SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_domestic_warehouse/ebayCategorySales">品类销售报表</a>
                        </li>
                    </ul>
                </li>
                <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=account_achievement/account_achievement"><i class="fa fa-pie-chart"></i>各平台各账号业绩</a>
                <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=account_achievement/manager_account_achievement"><i class="fa fa-bar-chart"></i>各平台各账号管理员业绩</a>
                <li>
                    <a href="#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">eBay海外仓</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_overseas_warehouse/usebayDailySales">美仓销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_overseas_warehouse/usebaySkuSales">美仓SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_overseas_warehouse/usebayCategorySales">美仓品类销售报表</a>
                        
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_overseas_warehouse/ukebayDailySales">英仓销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_overseas_warehouse/ukebaySkuSales">英仓SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_overseas_warehouse/ukebayCategorySales">英仓品类销售报表</a>
                        
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_overseas_warehouse/deebayDailySales">德仓销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_overseas_warehouse/deebaySkuSales">德仓SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=ebay_overseas_warehouse/deebayCategorySales">德仓品类销售报表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-amazon"></i> <span class="nav-label">Amazon业务线</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=amazon/amazonDailySales">Amazon销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=amazon/amazonSkuSales">Amazon SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=amazon/amazonCategorySales">Amazon品类销售报表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">SMT业务线</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=smt/smtDailySales">SMT销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=smt/smtSkuSales">SMT SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=smt/smtCategorySales">SMT品类销售报表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">Wish业务线</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=wish/wishDailySales">Wish销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=wish/wishSkuSales">Wish SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=wish/wishCategorySales">Wish品类销售报表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">Lazada业务线</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=lazada/lazadaDailySales">Lazada销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=lazada/lazadaSkuSales">Lazada SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=lazada/lazadaCategorySales">Lazada品类销售报表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">新平台业务线</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=newplatform/newplatformDailySales">新平台销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=newplatform/newplatformSkuSales">新平台 SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=newplatform/newplatformCategorySales">新平台品类销售报表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">沃尔玛业务线</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=walmart/walmartDailySales">沃尔玛销售报表</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">新蛋业务线</span><span
                            class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=newegg/neweggDailySales">新蛋销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=newegg/neweggSkuSales">新蛋 SKU销售报表</a>
                        </li>
                        <li><a class="J_menuItem" href="${pageContext.request.contextPath }/common?path=newegg/neweggCategorySales">新蛋品类销售报表</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->


    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
                                              onClick="return false;" href="#"><i
                        class="fa fa-bars"></i> </a>
                    <!-- <form role="search" class="navbar-form-custom">
                         <div class="form-group">
                             <input type="text" placeholder="请输入您需要查找的内容" class="form-control" name="top-search"
                                    id="top-search">
                         </div>
                     </form>-->
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li><span class="block m-t-xs"><b class="font-bold">${sessionScope.systemUser.username }</b>欢迎你登录系统
                                                      </span>
                    </li>
                    <li class="dropdown hidden-xs">
                        <a class="right-sidebar-toggle" aria-expanded="false" data-id="1month">
                            <i class="fa fa-tasks"></i> 主题
                        </a>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/logout?userId=${sessionScope.systemUser.id }"><i class="glyphicon glyphicon-log-out"></i> 退出</a>
                </ul>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:void(0);" class="active J_menuTab" data-id="1month">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>
                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="/?c=ctrl_main&a=logout" href="login.html" class="roll-nav roll-right J_tabExit"><i
                    class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${pageContext.request.contextPath }/common?path=target_completion_rate/1month" frameborder="0"
                    data-id="1month" seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">&copy; 2017-05
            </div>
        </div>
    </div>
    <!--右侧部分结束-->
    <!--右侧边栏开始-->
    <div id="right-sidebar">
        <div class="sidebar-container">
            <div class="tab-content">
                <div id="tab-1" class="tab-pane active">
                    <div class="sidebar-title">
                        <h3><i class="fa fa-comments-o"></i> 主题设置</h3>
                        <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                    </div>
                    <div class="skin-setttings">
                        <div class="title">主题设置</div>
                        <div class="setings-item">
                            <span>收起左侧菜单</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox"
                                           id="collapsemenu">
                                    <label class="onoffswitch-label" for="collapsemenu">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>固定顶部</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox"
                                           id="fixednavbar">
                                    <label class="onoffswitch-label" for="fixednavbar">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>固定宽度</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox"
                                           id="boxedlayout">
                                    <label class="onoffswitch-label" for="boxedlayout">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="title">皮肤选择</div>
                        <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">默认皮肤</a>
                             </span>
                        </div>
                        <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                        </div>
                        <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!--右侧边栏结束-->
</div>
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="js/plugins/layer/layer.min.js"></script>
<script src="js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="js/contabs.min.js"></script>
</body>
</html>
