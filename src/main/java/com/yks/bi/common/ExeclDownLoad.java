package com.yks.bi.common;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.cglib.core.ReflectUtils;

import com.yks.bi.utils.HttpRequestUtils;
import com.yks.bi.web.vo.MessageVo;


/**
 * bi报表中excel下载
 * 默认是csv文件 
 * 	可以选择为tsv文件
 * 输入是 list<T>
 * 输出是 文件路径
 * @author zh
 *
 */
public class ExeclDownLoad {
	
	 private static Logger log = Logger.getLogger(HttpRequestUtils.class);

	/**
	 * 默认的格式
	 */
	private String formatted="csv";
	
	private String delimiter=",";
	
	private PropertyDescriptor[] beanGetters;
	
	/**
	 * 主入口
	 * @param list list+bean形式
	 * @return 返回csv路径
	 * @throws Exception
	 */
	public String createExcel(List<?> list)throws Exception{
		
		if(list== null || list.size()==0)
			return null;
		
		String resultStr = createDataStr(list);
		String path = ConfigUtils.getPropertie("download.path")+File.separator+UUID.randomUUID().toString()+"."+formatted;
		File file = new File(path);
		if(!file.exists()){
			file.createNewFile();
		}
		
		IOUtils.write(resultStr, new FileOutputStream(file), "utf-8");
		
		
		return path;
	}
	
	/**
	 * 生成结果字符串
	 * @param list
	 * @return
	 * @throws Exception
	 */
	private String createDataStr(List<?> list)throws Exception{
		List<String> titleList = getAccectColumn(list);
		StringBuffer sb = new StringBuffer();
		createTitleStr(titleList, sb);
		
		Iterator<?> it = list.iterator();
		while (it.hasNext()) {
			Object bean = it.next();
			for(int i=0;i<titleList.size();i++){
				Object value = getMethodByName(titleList.get(i))
						.invoke(bean, null);
				if(i!=(titleList.size()-1)){
					sb.append(value.toString());
					sb.append(delimiter);
				}else{
					sb.append(value);
					sb.append("\n");
				}
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 获取 csv文件的title
	 * @param list
	 * @param sb
	 */
	private void createTitleStr(List<?> list,StringBuffer sb){
		for(int i=0;i<list.size();i++){
			if(i!= (list.size()-1)){
				sb.append(list.get(i).toString());
				sb.append(delimiter);
			}else{
				sb.append(list.get(i).toString());
				sb.append("\n");
			}
			
		}
		
	}
	
	/**
	 * 获取有效的列
	 * 	因为有些bean中值为null.这些字段不需要进行生成
	 * @param list
	 * @return
	 * @throws Exception
	 */
	private List<String> getAccectColumn(List<?> list)throws Exception{
		List<String> titleList = new ArrayList<String>();
		Object bean = list.get(0);
		Class cls = bean.getClass();
		beanGetters = ReflectUtils.getBeanGetters(cls);
		for(PropertyDescriptor desc:beanGetters){
			Method m = desc.getReadMethod();
			Object o = m.invoke(bean, null);
			if(o != null){
				titleList.add(desc.getName());
			}
		}
		return titleList;
	}
	
	/**
	 * 获取method
	 * @param name 属性名称
	 * @return
	 */
	private Method getMethodByName(String name){
		for(PropertyDescriptor desc:beanGetters){
			if(desc.getName().equals(name))
				return desc.getReadMethod();
		}
		return null;
	}
	
	
	
	
	public void setFormatted(String formatted) {
		this.formatted = formatted;
	}


	public static void main(String[] args)throws Exception {
		ExeclDownLoad down = new ExeclDownLoad();
		ArrayList<MessageVo> list = new ArrayList<MessageVo>();
		MessageVo vo = new MessageVo(1,"erro");
		MessageVo vo2 = new MessageVo(2,"erro");
		list.add(vo);
		list.add(vo2);
		down.createExcel(list);
		
	}
	
	
	
	
}
