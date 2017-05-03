<?php
return array(
    //用__FILE__表示的站点根目录,修改substr的第二参数即可
    'rootDir'     => strtr(substr(__FILE__, 0, -22), '\\', '/'),
    //域名到产品根目录地址,根路径为空字符串,null=自动计算
    'rootUrl'     => null,
    //站点配置文件路径及文件名
    //'config'      => '/demo/config.php',
    //统一调试模式, true=是, false=否
    'debug'       => true,
    //可写目录,上传,缓存等路径都将写入该文件夹
    'dataDir'     => '/data',
    //用户群体的系统字符集
    'charset'     => 'GB18030',
    //视图层文件夹结构 {'/img' : 图片, '/js' : 脚本, '/css' : 样式, '/tpl' : 模板}
    'view'        => array(
        //视图模板文件扩展名
        'tplExt'  => '.tpl.php',
        //默认视图模板模板路径
        'tplPath' => '/view',
        //全局标题
        'title'   => 'BI系统',
    ),
    //数据库连接池
    'db'          => array(
        /*'default'=>array(
            'adapter'        => 'mysqli',                                               //数据库连接方式(pdoMysql, mysql, mysqli)
            'params'         => array(                                                  //数据库连接参数
            'host'       => 'dev.publishdbdm.kokoerp.com',
            'port'       => 3306,
            'user'       => 'publish',
            'password'   => 'ZWno4jzEqQV2uekg',
            'database'   => 'ebay_publish',
            'charset'    => 'utf8',
            'persistent' => false                                                             //是否长连接
            )
        ),*/
    ),
    //预先装载类
    'preloaded'   => array(
        //快捷集成,语言包,扩展都依赖此包
        'of_base_link_setup',
        //错误日志,依赖快捷集成
        'of_base_error_writeLog',
        //session块
        'of_base_session_base',
        //语言包支持,依赖快捷集成
        //'of_base_language_packs',
        //xss 防御
        'of_base_xssFilter_main',
        //扩展支持,依赖语言包,快捷集成
        //'of_base_extension_match',
        //html模板引擎,实现UI,开发人员分离
        'of_base_htmlTpl_engine',
    ),

    'error'       => array(
        //日志有效时间(天),0=不清理
        'gcTime' => 30,
        //sql日志路径,false=关闭
        'sqlLog' => '/data/error/sqlLog',
        //php日志路径,false=关闭
        'phpLog' => '/data/error/phpLog',
        //js日志路径,false=关闭
        'jsLog'  => '/data/error/jsLog'
    ),
    'session'     => array(
        //存储方式
        'adapter'     => 'files',
        //正则匹配"调度类名::方法名"判断是否自动开启
        'autoStart'   => '@^(?!of_base_com_net:|of_base_sso_api:|api_)@',
        //最大生存时间(分钟)
        'maxLifeTime' => 60,
        //各调度参数
        'params'      => array(
            #files 模式, 文件存储方式
            //*
            //存储的文件路径
            'path'    => '/data/_of/of_accy_session_files'
            // */

            #mysql 模式, mysql存储表信息(推荐Innodb,MEM
            /*
            //数据库连接池
            'dbPool' => 'default',
            // */

            #k-v 模式
            /*
            //k-v 连接池
            'kvPool' => 'default',
            // */
        )
    ),
    'language'    => array(
        //语言包路径
        'path'    => '/data/language/Edgar',
        //默认语言
        'default' => 'base'
    ),
    'extension'   => array(
        //可写的扩展路径
        'path'      => '/data/extensions',
        //设置独享页的类名
        'exclusive' => 'of_ex'
    ),
    //html模板解析引擎
    'htmlTpl'     => array(
        //编译模版存储路径
        'path'    => '/data/_of/of_base_htmlTpl_engine',
        //注释脚本标识 <!--标识[0] php代码 标识[1]-->, [2]脚本匹配正则如'(?:\<\?|_)(.*?)(?:\?\>|)'
        'tagKey'  => array('<?', '?>'),
        //属性的前缀 _value 相当于 value
        'attrPre' => '_',
        //功能的前缀 __del 代表删除 当前标签
        'funcPre' => '__'
    ),
    //单点登录
    'sso'         => array(
        //单点登录所使用的数据库
        'dbPool'  => 'default',
        //帐号信息有效期(天), 0=不限制, 期满必须修改
        'expiry'  => 90,
        //开放注册,单点登录系统使用
        'openReg' => true,
        //对接网址,工具包使用,默认本机接口
        'url'     => 'http://sso.youkeshu.com/?c=of_base_sso_api',
        //对接帐号,工具包使用
        'name'    => 'smtnewp',
        //对接密码,工具包使用
        'key'     => 'smtnewp'
    ),
    'com'         => array(
        //组件分页设置
        'com::paging' => array(
            //默认展示数量
            'size'  => 10,
            //检查是否有权限调用分页, @开头的字符串=正则验证, 否则=遵循回调规则(返回true=通过)
            'check' => '@paging$@i'
        ),
        //网络请求
        'net' => array(
            //异步请求方案, ""=当前网址, url=指定网址
            'async'  => '',
            //k-v 池, 异步请求时用于安全校验
            'kvPool' => 'default'
        ),
        //计划任务
        'timer' => array(
            //存储的文件路径
            'path' => '/data/_of/of_base_com_timer',
            //动态任务
            'task' => array(
                //存储方式, files=文件模式, mysql=数据库模式
                'adapter' => 'files',
                'params'  => array(
                    #mysql 模式, mysql存储表信息(推荐Innodb)
                    /*
                    //数据库连接池
                    'dbPool' => 'default',
                    // */
                )
            ),
            //静态任务
            'cron' => array(
                //静态计划任务文件
                'path'   => '',
                //k-v 池, 分布式时防重复执行
                'kvPool' => 'default'
            )
        ),
        //key-value 数据存储 可分连接池
        'kv' => array(
            //适配文件 of_accy_com_kv_xxx
            'adapter' => 'files',
            //对应的配置
            'params'  => array(
                #files 模式
                //*
                //files 存储路径
                'path' => '/data/_of/of_accy_com_kv_files'
                // */

                #memcache 对应的配置, 可以使用二维数组连接集群
                /*
                //地址
                'host' => '127.0.0.1',
                'port' => 11211,
                // */

                #redis 对应的配置, 二维数组连接主从, 0键为主, 其它为从
                /*
                //地址
                'host' => '192.168.1.104',
                //端口
                'port' => 6379,
                //授权
                'auth' => '',
                //数据库
                'db'   => 0
                // */
            )
        )
    ),
    'addin'       => array(
        'oUpload' => array(
            //禁止上传的扩展文件
            'filtExt' => '@^(?:exe|php|html|htm|js|css)$@',
            //允许上传的文件夹(仅可匹配文件夹), 正则结果[1]可以指定根目录
            'folder'  => '@^(/data)/upload/@'
        )
    )
);
