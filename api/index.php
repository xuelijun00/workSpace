<?php

/**
 * 描述:控制层共享文件, 控制层文件与类名相同, 已$_GET['a']作为方法名(默认index)
 * 作者:Edgar.lee
 */
require dirname(dirname(__FILE__)) . '/include/of/of.php';

$_GET += array('a' => '', 'c' => '');

$result = of::dispatch('api\\' . strtr($_GET['c'], '_', '\\'), $_GET['a'], true);
if (is_array($result)) echo json_encode($result);
