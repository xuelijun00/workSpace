package com.yks.bi.web.interceptors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ParametersFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		arg0.setCharacterEncoding("UTF-8");
		arg1.setCharacterEncoding("UTF-8");
		arg2.doFilter(new ModifyParamters((HttpServletRequest)arg0), arg1);
	}

	@Override
	public void destroy() {
		
	}

}
