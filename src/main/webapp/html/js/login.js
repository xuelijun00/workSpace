var loginObj = {
    /**
     * 描述 : 请求登录
     * 作者 : Edgar.lee
     */
    'login' : function (thisObj) {
        var post = {};
        L.open('tip')('正在登录...', false);

        $('input', thisObj).each(function () {
            post[$(this).attr('name')] = this.value;
        });
        $.post(ROOT_URL + '/index.php?c=aide_main&a=login', post, function (data) {
            if (data === 'done') {
                window.location.reload(true);
            } else {
                $('#captcha').click();
                L.open('tip')(data);
            }
        });
        return false;
    }
}