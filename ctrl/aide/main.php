<?php
namespace ctrl\aide;

class main extends \L {
    /**
     * 描述 : 显示主界面
     * 作者 : Edgar.lee
     */
    public function index() {
        $this->display('/index.html');
    }

    /**
     * 描述 : 显示登录界面
     * 作者 : Edgar.lee
     */
    public function door() {
        $msg = '';
        if(false===strpos($_SERVER['HTTP_USER_AGENT'],'Firefox') &&
            false===strpos($_SERVER['HTTP_USER_AGENT'],'Chrome')){
            $msg = '亲爱的用户~ 我们建议您改用"火狐"或者"谷歌"浏览器，否则出现的bug我们不做受理，谢谢合作!' ;
        }
//        var_dump($msg);exit;
        $this->view->msg = $msg;
        $this->display('/login.html');
    }

    /**
     * 描述 : 登录帐号
     * 作者 : Edgar.lee
     */
    public function login() {
        if (isset($_POST['user']) && isset($_POST['pwd']) && isset($_POST['captcha'])) {
            //验证通过
            if (\of_base_com_com::captcha($_POST['captcha'])) {
                //校验用户名和密码
                $state = \of_base_sso_tool::login(array(
                    'user' => &$_POST['user'],
                    'pwd'  => &$_POST['pwd']
                ));

                //登录成功
                if ($state === true) {
                    echo 'done';
                //登录出错
                } else if ($state) {
                    echo $state['msg'];
                //登录失败
                } else {
                    echo '帐号密码错误';
                }
            //验证失败
            } else {
                echo '验证码错误';
            }
        }
    }

    /**
     * 描述 : 退出帐号
     * 作者 : Edgar.lee
     */
    public function logout() {
        \of_base_sso_tool::logout();
        \L::header(ROOT_URL . '/index.php');
    }

    /**
     * 描述 : 无权访问界面
     * 作者 : Edgar.lee
     */
    public function unRole() {
        $this->view->title = '无权访问';
        $this->view->info = '您无权访问当前页面, 请联系管理员开通';
        $this->display('/error.html');
    }

    /**
     * 描述:加载首页流程图标页面
     * 作者:huangliheng
    */
    public function loadIndexV2() {
        $this->display('/index_v2.html');
    }
}
return true;