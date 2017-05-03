<?php /*line : 1*/
of_view::head(array(
    'title' => /*line : 5*/ '',
    'head'  => array(
        '_' . L::getHtmlTpl('/jsLoad/top.html')
    ),
    'css'   => array(
        '_' . ( OF_URL . '/addin/oFileManager/style/oDialogDiv.css' )
    ),
    'body'  => array(
        'class="fixed-sidebar full-height-layout gray-bg"',
        'style="overflow:hidden"'
    ),
));
?>

<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <div class="logo-element nav-header"><img src="<?php /*line : 21*/ echo ROOT_URL; ?>/view/img/logo.png"><span class="logotitle"><?php /*line : 22*/ echo of::config('_of.view.title'); ?></span></div>
            <ul class="nav" id="side-menu">
                <li>
                    <a href="<?php /*line : 25*/ echo ROOT_URL; ?>/">
                        <i class="fa fa-home"></i>
                        <span class="nav-label"><?php /*line : 27*/ echo L::getText('主页'); ?>
</span>
                    </a>
                </li>
                <li>
                    <a href="<?php /*line : 31*/ echo ROOT_URL; ?>/view/#"><i class="fa fa-flask"></i> <span class="nav-label"><?php /*line : 31*/ echo L::getText('UI元素'); ?>
</span><span class="fa
                        arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="<?php /*line : 34*/ echo ROOT_URL; ?>/view/typography.html" class="J_menuItem"><?php /*line : 34*/ echo L::getText('排版'); ?>
</a>
                        </li>
                        <li>
                            <a href="<?php /*line : 37*/ echo ROOT_URL; ?>/view/#"><?php /*line : 37*/ echo L::getText('字体图标'); ?>
 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a href="<?php /*line : 40*/ echo ROOT_URL; ?>/view/iconfont.html" class="J_menuItem"><?php /*line : 40*/ echo L::getText('阿里巴巴矢量图标库'); ?>
</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="<?php /*line : 45*/ echo ROOT_URL; ?>/view/#"><?php /*line : 45*/ echo L::getText('拖动排序'); ?>
 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a href="<?php /*line : 47*/ echo ROOT_URL; ?>/view/draggable_panels.html" class="J_menuItem"><?php /*line : 47*/ echo L::getText('拖动面板'); ?>
</a>
                                </li>
                                <li><a href="<?php /*line : 49*/ echo ROOT_URL; ?>/view/agile_board.html" class="J_menuItem"><?php /*line : 49*/ echo L::getText('任务清单'); ?>
</a>
                                </li>
                            </ul>
                        </li>
                        <li><a href="<?php /*line : 53*/ echo ROOT_URL; ?>/view/buttons.html" class="J_menuItem"><?php /*line : 53*/ echo L::getText('按钮'); ?>
</a>
                        </li>
                        <li><a href="<?php /*line : 55*/ echo ROOT_URL; ?>/view/tabs_panels.html" class="J_menuItem"><?php /*line : 55*/ echo L::getText('选项卡 &amp; 面板'); ?>
</a>
                        </li>
                        <li><a href="<?php /*line : 57*/ echo ROOT_URL; ?>/view/notifications.html" class="J_menuItem"><?php /*line : 57*/ echo L::getText('通知 &amp; 提示'); ?>
</a>
                        </li>
                        <li><a href="<?php /*line : 59*/ echo ROOT_URL; ?>/view/badges_labels.html" class="J_menuItem"><?php /*line : 59*/ echo L::getText('徽章，标签，进度条'); ?>
</a>
                        </li>
                        <li>
                            <a href="<?php /*line : 62*/ echo ROOT_URL; ?>/view/grid_options.html" class="J_menuItem"><?php /*line : 62*/ echo L::getText('栅格'); ?>
</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="<?php /*line : 67*/ echo ROOT_URL; ?>/view/#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label"><?php /*line : 67*/ echo L::getText('BI图表实例'); ?>
 </span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="<?php /*line : 70*/ echo ROOT_URL; ?>/view/echarts/highcharts.html" class="J_menuItem"><?php /*line : 70*/ echo L::getText('echarts 百度'); ?>
</a>
                        </li>
                        <li><a href="<?php /*line : 72*/ echo ROOT_URL; ?>/view/echarts/jqgirddemo.html" class="J_menuItem"><?php /*line : 72*/ echo L::getText('jqGird表格'); ?>
</a>
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
                <div class="navbar-header"><a href="<?php /*line : 87*/ echo ROOT_URL; ?>/view/#" class="navbar-minimalize minimalize-styl-2 btn btn-primary " onclick="return false;"><i class="fa fa-bars"></i> </a>
                    <!-- <form role="search" class="navbar-form-custom">
                         <div class="form-group">
                             <input type="text" placeholder="请输入您需要查找的内容" class="form-control" name="top-search"
                                    id="top-search">
                         </div>
                     </form>-->
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li><span class="block m-t-xs"><b class="font-bold"><?php /*line : 98*/ echo of_base_sso_tool::user('nike'); ?></b><?php /*line : 98*/ echo L::getText('欢迎你登录系统'); ?>

                                                      </span>
                    </li>
                    <li class="dropdown hidden-xs">
                        <a class="right-sidebar-toggle" aria-expanded="false">
                            <i class="fa fa-tasks"></i> <?php /*line : 103*/ echo L::getText('主题'); ?>

                        </a>
                    </li>
                    <li><a href="<?php /*line : 106*/ echo ROOT_URL; ?>/?c=aide_main&amp;a=logout"><i class="glyphicon glyphicon-log-out"></i> <?php /*line : 106*/ echo L::getText('退出'); ?>
</a>
                </ul>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html"><?php /*line : 115*/ echo L::getText('首页'); ?>
</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown"><?php /*line : 121*/ echo L::getText('关闭操作'); ?>
<span class="caret"></span>
                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a><?php /*line : 124*/ echo L::getText('定位当前选项卡'); ?>
</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a><?php /*line : 127*/ echo L::getText('关闭全部选项卡'); ?>
</a>
                    </li>
                    <li class="J_tabCloseOther"><a><?php /*line : 129*/ echo L::getText('关闭其他选项卡'); ?>
</a>
                    </li>
                </ul>
            </div>
            <a href="<?php /*line : 133*/ echo ROOT_URL; ?>/?c=ctrl_main&amp;a=logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> <?php /*line : 134*/ echo L::getText('退出'); ?>
</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe src="<?php /*line : 137*/ echo ROOT_URL; ?>/view/index_v2.html" class="J_iframe" name="iframe0" width="100%" height="100%" frameborder="0" data-id="index_v2.html" seamless=""></iframe>
        </div>
        <div class="footer">
            <div class="pull-right"><?php /*line : 141*/ echo L::getText('&copy; 2014-2017'); ?>

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
                        <h3><i class="fa fa-comments-o"></i> <?php /*line : 152*/ echo L::getText('主题设置'); ?>
</h3>
                        <small><i class="fa fa-tim"></i> <?php /*line : 153*/ echo L::getText('你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。'); ?>
</small>
                    </div>
                    <div class="skin-setttings">
                        <div class="title"><?php /*line : 156*/ echo L::getText('主题设置'); ?>
</div>
                        <div class="setings-item">
                            <span><?php /*line : 158*/ echo L::getText('收起左侧菜单'); ?>
</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                    <label class="onoffswitch-label" for="collapsemenu">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span><?php /*line : 172*/ echo L::getText('固定顶部'); ?>
</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                    <label class="onoffswitch-label" for="fixednavbar">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span><?php /*line : 186*/ echo L::getText('固定宽度'); ?>
</span>

                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                    <label class="onoffswitch-label" for="boxedlayout">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="title"><?php /*line : 199*/ echo L::getText('皮肤选择'); ?>
</div>
                        <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="<?php /*line : 202*/ echo ROOT_URL; ?>/view/#" class="s-skin-0"><?php /*line : 202*/ echo L::getText('默认皮肤'); ?>
</a>
                             </span>
                        </div>
                        <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="<?php /*line : 207*/ echo ROOT_URL; ?>/view/#" class="s-skin-1">
                            <?php /*line : 207*/ echo L::getText('蓝色主题'); ?>

                        </a>
                    </span>
                        </div>
                        <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="<?php /*line : 214*/ echo ROOT_URL; ?>/view/#" class="s-skin-3">
                            <?php /*line : 214*/ echo L::getText('黄色/紫色主题'); ?>

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
<script src="<?php /*line : 228*/ echo ROOT_URL; ?>/view/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<?php /*line : 229*/ echo ROOT_URL; ?>/view/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<?php /*line : 230*/ echo ROOT_URL; ?>/view/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<?php /*line : 231*/ echo ROOT_URL; ?>/view/js/plugins/layer/layer.min.js"></script>
<script src="<?php /*line : 232*/ echo ROOT_URL; ?>/view/js/hplus.min.js?v=4.1.0"></script>
<script src="<?php /*line : 233*/ echo ROOT_URL; ?>/view/js/contabs.min.js" type="text/javascript"></script>
<!-- tplDir : /view/index.html -->