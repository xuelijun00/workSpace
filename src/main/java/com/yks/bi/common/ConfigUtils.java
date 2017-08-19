package com.yks.bi.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 配置文件
 * @author zh
 *
 */
public class ConfigUtils {
	
	static Properties pro;
	
	static{
		try {
			pro = new Properties();
			pro.load(new FileInputStream(new File("D:\\devel\\workspace\\20170202\\yksbi\\src\\main\\resources\\common.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取配置文件属性
	 * @param name
	 * @return
	 */
	public static String getPropertie(String name){
		return pro.getProperty(name);
	}
	
	public static void main(String[] args) {
		System.out.println(ConfigUtils.getPropertie("download.path"));
	}

}
