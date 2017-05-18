package com.yks.bi.web.interceptors;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;

import com.yks.bi.common.CamelToUnderlineUtil;

public class ModifyParamters extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	public ModifyParamters(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String sidx = request.getParameter("sidx");
		if(StringUtils.isNotEmpty(sidx)){
			return CamelToUnderlineUtil.camelToUnderline(sidx);
		}
		if(this.request.getParameter(name) != null){
			try {
				return new String(this.request.getParameter(name).getBytes("ISO8859-1"),Charset.forName("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
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
		if(str != null && str.length > 0){
			for (int i = 0; i < str.length; i++) {
				try {
					str[i] = new String(str[i].getBytes("ISO8859-1"),Charset.forName("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}

}
