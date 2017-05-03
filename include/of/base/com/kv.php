<?php
/**
 * 描述 : K-V存储基类
 * 注明 :
 *      连接池列表结构($instList) : {
 *          "default" : {
 *              "pool" : 格式化后的连接池结构为 {
 *                  'adapter' : 适配类型
 *                  'params'  : 适配参数
 *              },
 *              "inst" : 初始化的连接源对象
 *          }
 *      }
 * 作者 : Edgar.lee
 */
class of_base_com_kv {
    private static $config = null;
    private static $instList = null;

    /**
     * 描述 : 初始化方法,仅可通过self::inst()实例化
     * 作者 : Edgar.lee
     */
    final public function __construct(&$key = '', &$params = null) {
        //初始化连接实例
        if (isset(self::$instList[$key]['allowInst'])) {
            //移除允许实力标识
            unset(self::$instList[$key]['allowInst']);
            //连接参数
            $this->params = &$params;
            //初始化连接
            $this->_connect();
        //实例化不是自身类
        } else if (get_class($this) !== __CLASS__) {
            //防止通过 of_accy_com_kv_xxx 直接实例化
            trigger_error('The class can only be instantiate by of_base_com_kv::pool()');
            exit;
        }
    }

    /**
     * 描述 : 读取/设置连接池
     * 参数 :
     *      key  : 使用的连接池
     *      pool : 连接参数,初始化后便不再起作用
     * 返回 :
     *      连接池配置
     * 作者 : Edgar.lee
     */
    final public static function pool($key, $pool = null) {
        //引用实例列表
        $instList = &self::$instList;

        if (empty($instList[$key])) {
            if ($pool === null) {
                //引用数据库配置
                $config = &self::$config;
                //配置初始化
                if ($config === null) {
                    //读取连接池参数
                    $config = of::config('_of.com.kv', array('adapter' => 'files'));
                    //配置文件格式化
                    isset($config['adapter']) && $config = array('default' => $config);
                }

                //引用连接池
                if (!$pool = &$config[$key]) {
                    //指定的数据连接无效
                    trigger_error('Did not find the specified key-value connection : ' . $key);
                    exit;
                }
            }

            isset($pool['params']) || $pool['params'] = array();
            //存储配置
            $instList[$key] = array('pool' => &$pool);
            //实例类名
            $instList[$key]['allowInst'] = 'of_accy_com_kv_' . $pool['adapter'];
            //实例化类
            $instList[$key]['inst'] = new $instList[$key]['allowInst']($key, $pool['params']);
        }

        return $instList[$key]['pool'];
    }

    /**
     * 描述 : 添加数据
     * 参数 :
     *      name  : 指定操作的键名
     *      value : ('')添加的数据
     *      time  : (0) 过期时间
     *      pool  : ('default') 连接池
     *      retry : 尝试重试到成功, 0=不尝试, 正整数=尝试不超过秒数
     * 返回 :
     *      false=指定键名已存在, true=成功创建
     * 作者 : Edgar.lee
     */
    final public static function add($name, $value = '', $time = 0, $pool = 'default', $retry = 0) {
        self::pool($pool);
        $value = serialize($value);
        $index = &self::$instList[$pool]['inst'];
        $retry *= 5000;

        do {
            $result = $index->_add($name, $value, self::formatTime($time));
            if ($result || !$retry) {
                break ;
            } else {
                $retry -= 1;
                usleep(200);
            }
        } while (true);

        return $result;
    }

    /**
     * 描述 : 删除数据
     * 参数 :
     *      name  : 指定操作的键名
     *      pool  : ('default') 连接池
     * 返回 :
     *      false=删除失败, true=删除成功
     * 作者 : Edgar.lee
     */
    final public static function del($name, $pool = 'default') {
        self::pool($pool);
        return self::$instList[$pool]['inst']->_del($name);
    }

    /**
     * 描述 : 设置数据
     * 参数 :
     *      name  : 指定操作的键名
     *      value : ('')添加的数据
     *      time  : (0) 过期时间
     *      pool  : ('default') 连接池
     * 返回 :
     *      false=成功, true=失败
     * 作者 : Edgar.lee
     */
    final public static function set($name, $value = '', $time = 0, $pool = 'default') {
        self::pool($pool);
        $value = serialize($value);
        return self::$instList[$pool]['inst']->_set($name, $value, self::formatTime($time));
    }

    /**
     * 描述 : 读取数据
     * 参数 :
     *      name  : 指定操作的键名
     *      pool  : ('default') 连接池
     * 返回 :
     *      false=指定键名已存在, true=成功创建
     * 作者 : Edgar.lee
     */
    final public static function get($name, $default = false, $pool = 'default') {
        self::pool($pool);
        ($value = self::$instList[$pool]['inst']->_get($name)) === false ? $value = &$default : $value = unserialize($value);
        return $value;
    }

    /**
     * 描述 : 获取原始资源, 通过此函数做更多特性操作
     * 参数 :
     *      pool  : ('default') 连接池
     * 返回 :
     *      返回原始资源
     * 作者 : Edgar.lee
     */
    final public static function link($pool = 'default') {
        self::pool($pool);
        return self::$instList[$pool]['inst']->_link();
    }

    private static function &formatTime(&$time) {
        $time || $time = PHP_INT_MAX;
        $time < 63072000 && $time += time();
        return $time;
    }

    /* '/of/accy/kv/xx.php' 文件使用继承该类,并实现以下方法
    abstract protected function _connect();                         //连接到存储结构
    abstract protected function _add(&$name, &$value, &$time);      //添加数据
    abstract protected function _del(&$name);                       //删除数据
    abstract protected function _set(&$name, &$value, &$time);      //设置数据
    abstract protected function _get(&$name);                       //读取数据
    abstract protected function _close();                           //关闭连接源// */
}