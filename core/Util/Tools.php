<?php
namespace core\Util;
class Tools
{
  /**
   * 检测字符串是否出现在另一个字符串的开头
   * @param string $str1 参照的字符串
   * @param string $str2 出现的字符串
   * @return boolean 返回布尔值
   */
  public static function startWith($str1, $str2)
  {
    return strpos($str1, $str2) === 0;
  }

  /**
   * 检测字符串是否出现在另一个字符串的结尾
   * @param string $str1 参照的字符串
   * @param string $str2 出现的字符串
   * @return boolean 返回布尔值
   */
  public static function endWith($str1, $str2)
  {
    return strrpos($str1, $str2) === strlen($str1) - strlen($str2);
  }

  /**
   * 下划线转驼峰命名
   * @param string $str 要转换的字符串
   * @return string 返回转换后的字符串
   */
  public static function toCamelCase($str = "")
  {
    return preg_replace_callback('/_([a-z])/i', function($item)
    {
      return mb_strtoupper($item[1]);
    }, $str);
  }

  /**
   * 驼峰命名转下划线
   * @param string $str 要转换的字符串
   * @return string 返回转换后的字符串
   */
  public static function toUnderScore($str = "")
  {
    return preg_replace_callback('/[A-Z]/', function($item)
    {
      return "_" . mb_strtolower($item[0]);
    }, $str);
  }

  /**
   * 无限极分类生成树
   * @param array $items 二维数组
   * @param string $pid 父级下标的，默认为pid
   * @param string $id 主键下标id
   * @return array 返回排序好的二维数组
   */
  public static function generateTree(array $items, $id = 'id', $pid = 'pid')
  {
    $items = self::arraySetKey($items, $id);
    $tree = [];
    foreach($items as $item)
    {
      if(isset($items[$item[$pid]]))
        $items[$item[$pid]]['son'][] = &$items[$item[$id]];
      else
        $tree[] = &$items[$item[$id]];
    }
    return $tree;
  }

  /**
   * 生成无限分类的层次
   * @param array $array 已经排好的无限分类
   * @param string $son 字类的名称
   * @param int $level 当前的层次，默认为第一层
   * @return array 返回二维数组
   */
  public static function levelArray(array $array, $son = 'son', $level = 0)
  {
    $ret = [];
    foreach($array as $key => $value)
    {
      $keys = array_flip(array_diff(array_keys($value), [$son]));
      $ret[] = array_merge(array_intersect_key($value, $keys), compact('level'));
      if(isset($value[$son]))
      {
        $t = self::levelArray($value[$son], $son, $level + 1);
        $ret = array_merge($ret, $t);
      }
    }
    return $ret;
  }

  /**
   * 获取随机字符串
   * @param int $len 要获取的长度，默认为6
   * @param int $index 获取哪种类型，0字母数字混合，1数字，2字母，默认为0
   * @return string 返回生成的字符串
   */
  public static function getRandStr($len = 6, $index = 0)
  {
    $list = [
      0 => 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz',
      1 => '0123456789',
      2 => 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz',
    ];
    if(!in_array($index, [1, 2]))
      $index = 0;
    $str = $list[$index];
    $max = strlen($str) - 1;
    $ret = '';
    for($i = 0; $i < $len; $i++)
    {
      $ret .= $str[mt_rand(0, $max)];
    }
    return $ret;
  }

  /**
   * 二维数组排序
   * @param array $arr 要排序的二维数组
   * @param string $k 用哪个字段来排序
   * @param string $order 倒排还是正排，默认为正排（asc, desc）
   * @param boolean $falg 是否保留原来的键的顺序，默认为不保留
   * @return array 返回排序后的二维数组
   */
  public static function sortArray($arr, $k, $order = 'asc', $falg = false)
  {
    $temp = $ret = [];
    foreach($arr as $key => $value)
    {
      $temp[$key] = $value[$k];
    }

    mb_strtolower($order) == "desc" ? arsort($temp) : asort($temp);

    foreach(array_keys($temp) as $tk => $key)
    {
      $ret[$falg ? $key : $tk] = $arr[$key];
    }
    return $ret;
  }

  /**
   * 检测是否使用手机访问
   * @return bool
   */
  public static function isMobile()
  {
    return (isset($_SERVER['HTTP_VIA']) && stristr($_SERVER['HTTP_VIA'], "wap"))
      ||
      (isset($_SERVER['HTTP_ACCEPT']) && strpos(strtoupper($_SERVER['HTTP_ACCEPT']), "VND.WAP.WML"))
      ||
      (isset($_SERVER['HTTP_X_WAP_PROFILE']) || isset($_SERVER['HTTP_PROFILE']))
      ||
      (isset($_SERVER['HTTP_USER_AGENT']) && preg_match('/(blackberry|configuration\/cldc|hp |hp-|htc |htc_|htc-|iemobile|kindle|midp|mmp|motorola|mobile|nokia|opera mini|opera |Googlebot-Mobile|YahooSeeker\/M1A1-R2D2|android|iphone|ipod|mobi|palm|palmos|pocket|portalmmm|ppc;|smartphone|sonyericsson|sqh|spv|symbian|treo|up.browser|up.link|vodafone|windows ce|xda |xda_)/i', $_SERVER['HTTP_USER_AGENT']));
  }

  /**
   * 检查是不是一个合法的手机号码
   * @param $phone
   * @return bool
   */
  public static function isPhone($phone)
  {
    return !!preg_match("/^1[34578]{1}\d{9}$/", $phone);
  }

  /**
   * 检测是不是一个合法的邮箱
   * @param string $email 邮箱号码
   * @return bool
   */
  public static function isEmail($email)
  {
    $regex = '/^([0-9A-Za-z\\-_\\.]+)@([0-9a-z]+\\.[a-z]{2,3}(\\.[a-z]{2})?)$/i';
    return !!preg_match($regex, $email);
  }

  /**
   * 重新为二维数组生成下标
   * @param $arr 二维数组
   * @param string|array|callable $callback 可传字符串，数组，回调函数，
   * 说明，字符串：在二维中的下标。数组：多个在二维数组中的下标，数组的最后一个为分隔符
   * 回调函数：通过传一个数组和一个下标，来重新生成一个key
   * @return array 返回整理好下标的数组
   */
  public static function arraySetKey(array $arr, $callback = '')
  {
    $ret = [];
    if(is_array($callback))
      $end = count($callback) > 1 ? array_pop($callback) : '_';
    foreach($arr as $key => $value)
    {
      if(is_object($callback))
      {
        $newKey = $callback($value, $key);
      }
      elseif(is_array($callback))
      {
        $s = '';
        foreach($callback as $v)
          if(isset($value[$v]))
            $s .= $value[$v] . $end;
        $newKey = rtrim($s, $end);
      }
      else
      {
        $newKey = isset($value[$callback]) ? $value[$callback] : current($value);
      }
      $ret[$newKey] = $value;
    }
    return $ret;
  }

  /**
   * 替换数组下标
   * @param array $replace 要替换的下标关联数组
   * @param array $array 被替换的数组
   * @return array 替换结果
   */
  public static function replaceArrayKey(array $replace, array $array)
  {
    $ret = [];
    foreach($array as $key => $value)
    {
      if(is_array($value))
        $ret[$key] = self::replaceArrayKey($replace, $value);
      else
        $ret[array_key_exists($key, $replace) ? $replace[$key] : $key] = $value;
    }
    return $ret;
  }

  /**
   * 显示或者隐藏数组
   * @param array $stack 指定要显示或者隐藏的下标
   * @param array $array 关联数组
   * @param bool $isVisble 指定为显示还是隐藏，默认为显示
   * @return array 处理后的结果
   */
  public static function visibleArray(array $stack = [], array $array = [], $isVisble = true)
  {
    $ret = [];
    foreach($array as $key => $value)
    {
      if(is_array($value))
      {
        $t = self::visibleArray($stack, $value, $isVisble);
        if(!empty($t))
          $ret[$key] = $t;
      }
      else
      {
        if($isVisble ? in_array($key, $stack, true) : !in_array($key, $stack, true))
          $ret[$key] = $value;
      }
    }
    /*if(count($array) == count($array, COUNT_RECURSIVE))
    {
      $stack = array_flip($stack);
      $ret = $isVisble ? array_intersect_key($array, $stack) : array_diff_key($array, $stack);
    }
    else
    {
      foreach($array as $key => $value)
      {
        if(is_array($value))
        {
          $t = self::visibleArray($stack, $value, $isVisble);
          if(!empty($t))
            $ret[$key] = $t;
        }
      }
    }*/
    return $ret;
  }

  /**
   * 找出数组的区间值
   * @param array $array 二维数组
   * @param $search 要找的区间值
   * @param $key 用哪个下标来做搜索条件
   * @return array 返回找到的数组，找不到返回最后一条
   */
  public static function searchArrayInterval(array $array, $search, $key)
  {
    $array = self::sortArray($array, $key);
    $ret = end($array);
    foreach($array as $key => $value)
    {
      if($value[$key] >= $search)
      {
        $ret = $value;
        break;
      }
    }
    return $ret;
  }

  /**
   * 检测是否为https请求
   * @param string $url 要检测的url
   * @return bool 返回检测结果
   */
  public static function isHttps($url)
  {
    return self::startWith($url, 'https://');
  }

  /**
   * 通过curl发送get请求
   * @param string $url 请求的url
   * @param array $data 请求的参数
   * @param array $header 设置请求头
   * @param int $timeOut 设置过期时间，默认为30秒
   * @return bool|mixed 返回请求结果，失败返回false，成功返回请求数据
   */
  public static function curlGet($url, array $data = [], array $header = [], $timeOut = 30)
  {
    $data = array_map(function($item)
    {
      return urlencode($item);
    }, $data);
    $queryString = strpos($url, '?') !== false ? '&' : '?';
    $queryString .= http_build_query($data);
    $ch = curl_init();
    $setopt = [
      CURLOPT_URL => $url . $queryString,
      CURLOPT_TIMEOUT => $timeOut,
      CURLOPT_RETURNTRANSFER => true
    ];
    if(self::isHttps($url))
    {
      $setopt[CURLOPT_SSL_VERIFYPEER] = false;
      $setopt[CURLOPT_SSL_VERIFYHOST] = false;
    }
    curl_setopt_array($ch, $setopt + $header);
    $output = curl_exec($ch);
    $info = curl_getinfo($ch);
    curl_close($ch);
    return $info['http_code'] == 200 ? ["data" => $output, "info" => $info] : false;
  }

  /**
   * 通过curl发送post请求
   * @param string $url 请求的url
   * @param string|array $data 如果为如果数组，则为普通的post请求，如果要发送json或者字符串请先转换格式
   * @param array $header 设置请求头
   * @param int $timeOut 设置过期时间，默认为30秒
   * @return bool|mixed 返回请求结果，失败返回false，成功返回请求数据
   */
  public static function curlPost($url, $data, array $header = [], $timeOut = 30)
  {
    if(is_array($data))
      $data = http_build_query($data);
    $ch = curl_init();
    $setopt = [
      CURLOPT_URL => $url,
      CURLOPT_RETURNTRANSFER => true,
      CURLOPT_TIMEOUT => $timeOut,
      CURLOPT_POST => 1,
      CURLOPT_POSTFIELDS => $data
    ];
    if(self::isHttps($url))
    {
      $setopt[CURLOPT_SSL_VERIFYPEER] = false;
      $setopt[CURLOPT_SSL_VERIFYHOST] = false;
    }
    curl_setopt_array($ch, $setopt + $header);
    $output = curl_exec($ch);
    $info = curl_getinfo($ch);
    curl_close($ch);
    return $info['http_code'] == 200 ? ["data" => $output, "info" => $info] : false;
  }

  /**
   * xml 转数组
   * @param string $xml 需要转换的xml格式或文件
   * @return mixed 返回转换结果
   * @author longli
   * @date 2017-03-14
   */
  public static function xmlToArray($xml)
  {
    if(is_file($xml))
      $xml = file_get_contents($xml);
    $xmlstring = simplexml_load_string($xml, 'SimpleXMLElement', LIBXML_NOCDATA);
    return json_decode(json_encode($xmlstring), true);
  }

  /**
   * 数组转xml
   * @param array $array 需要转换的数组
   * @param string|array $root 根节点的名称，默认为 root, 数组格式['name'=>'root', 'attribute'=>['k'=>'v']]
   * @param \DOMDocument $dom DOM文档，无需传值，默认为null
   * @param \DOMElement $item 节点，无需传值，默认为null
   * @param string $charset xml编码，默认为utf-8
   * @return string 转换后的xml格式
   * @author longli
   * @date 2017-03-14
   */
  public static function arrayToXml(array $array, $root = 'root', $dom = null, $item = null, $charset = 'utf-8')
  {
    if(!($dom instanceof \DOMDocument))
    {
      $dom = new \DOMDocument("1.0", $charset);
    }
    if(!($item instanceof \DOMElement))
    {
      if(is_array($root) && !empty($root['name']))
      {
        $item = $dom->createElement($root['name']);
        if(isset($root['attribute']))
        {
          foreach($root['attribute'] as $key => $val)
          {
            $item->setAttribute($key, $val);
          }
        }
      }
      else
      {
        if(empty($root))
          $root = 'root';
        $item = $dom->createElement($root);
      }
      $dom->appendChild($item);
    }
    foreach($array as $key => & $val)
    {
      if((!is_string($key) && empty($item)) || self::startWith($key, 'attr@') || (empty($val) && !is_numeric($val)))
        continue;
      if(is_numeric($key) && !empty($item))
      {
        self::arrayToXml($val, $root, $dom, $item);
      }
      else
      {
        $itemx = $dom->createElement($key);
        if(isset($array["attr@$key"]))
        {
          $attrKey = "attr@$key";
          $attrs = $array[$attrKey];
          unset($array[$attrKey]);
          foreach($attrs as $atk => $attr)
          {
            $itemx->setAttribute($atk, $attr);
          }
        }
        $item->appendChild($itemx);
        if(!is_array($val))
        {
          $text = is_numeric($val) ? $dom->createTextNode($val) : $dom->createCDATASection($val);
          $itemx->appendChild($text);
        }
        else
        {
          self::arrayToXml($val, $root, $dom, $itemx);
        }
      }
    }
    return $dom->saveXML();
  }

  /**
   * 检查是不是一维数据
   * @param array $arr 要检测的数组
   * @return integer 返回检测结果
   */
  public static function arrayGetMaxdim(array $arr = [])
  {
    $ret = count($arr) == count($arr, 1);
    return (int) $ret;
  }
}
?>
