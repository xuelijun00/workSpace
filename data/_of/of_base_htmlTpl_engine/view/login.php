<?php /*line : 1*/
of_view::head(array(
    'title' => L::getText('YKSUI框架 - 登录'),
    'css'   => array(
        '_' . ( /*line : 8*/ ROOT_URL . '/view/css/greenlogin.css' )
    ),
));
?>

<script>if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>
<div class="logo-name"><?php /*line : 17*/ echo of::config('_of.view.title'); ?></div>
<div class="wrapper">
    <div class="container">
        <h1><?php /*line : 20*/ echo L::getText('Login'); ?>
</h1>

        <form class="form" onsubmit="return loginObj.login(this);">
            <input type="text" placeholder="用户名" class="login_input" name="user">
            <input type="password" placeholder="密码" class="login_input" name="pwd">

            <div>
                <input type="text" class="login_input captcha-input" placeholder="验证码" name="captcha">
                <img src="<?php /*line : 28*/ echo ROOT_URL; ?>/include/of/index.php?c=of_base_com_com&amp;a=captcha&amp;width=130&amp;height=45" id="captcha" title="点击刷新" style="cursor:pointer; float: right;background-color:#fff;" onclick="this.src = (this.backupSrc || (this.backupSrc = this.src)) + &#039;&amp;t=&#039; + new Date().getTime()">
            </div>
            <button type="submit" class="login_button btn"><?php /*line : 32*/ echo L::getText('登录'); ?>
</button>
            <!--<p __del class="text-muted text-center">
                <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
            </p>-->
        </form>
        <div class="modify_password">
            <a href="http://userinfo.youkeshu.com/Auser/forgot/password/" target="_blank"><?php /*line : 38*/ echo L::getText('忘记密码'); ?>
</a><?php /*line : 38*/ echo L::getText('|'); ?>

            <a href="http://userinfo.youkeshu.com/Auser/change/password/" target="_blank"><?php /*line : 39*/ echo L::getText('修改密码'); ?>
</a> <?php /*line : 39*/ echo L::getText('|'); ?>

            <a href="http://userinfo.youkeshu.com" target="_blank"><?php /*line : 40*/ echo L::getText('修改信息'); ?>
</a>
        </div>
    </div>
</div>
<script src="<?php /*line : 44*/ echo ROOT_URL; ?>/view/js/login.js"></script>
<!-- tplDir : /view/login.html -->