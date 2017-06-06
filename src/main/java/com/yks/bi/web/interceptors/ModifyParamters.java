package com.yks.bi.web.interceptors;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.yks.bi.common.CamelToUnderlineUtil;
import com.yks.bi.common.ChineseGarbled;

/**
 * 拦截器修改参数
 * @author Administrator
 */
public class ModifyParamters extends HttpServletRequestWrapper {
	
	private static Logger log = Logger.getLogger(ModifyParamters.class);
	
	private HttpServletRequest request;
	public ModifyParamters(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String sidx = request.getParameter("sidx");
		if(StringUtils.isNotEmpty(sidx)){
			return CamelToUnderlineUtil.camelToUnderline(sidx);//驼峰命名法转 _ 命名
		}
		String value = ChineseGarbled.chineseGarbled(this.request.getParameter(name));//编码转换
		log.info(String.format("参数-name:%s,value:%s",name,value));
		return value;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return this.request.getParameterMap();
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return this.request.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		if(name.equals("sidx")){
			return new String[]{CamelToUnderlineUtil.camelToUnderline(this.request.getParameter(name))};
		}
		String[] str = this.request.getParameterValues(name);
		for (int i = 0; str != null && i < str.length; i++) {
			str[i] = ChineseGarbled.chineseGarbled(str[i]);
		}
		if(!"password".equals(name))
			log.info(String.format("参数-name:%s,value:%s",name,str!=null?str[0]:"null"));
		return str;
	}

}
