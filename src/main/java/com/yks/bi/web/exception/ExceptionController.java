package com.yks.bi.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController implements HandlerExceptionResolver{
	
	private static Logger log = Logger.getLogger(ExceptionController.class);
	/**
	 * SimpleMappingExceptionResolver
	 * 可以通过配置这个自定义异常 跳转
	 */
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,Exception ex) {
		log.error("异常", ex);
		return new ModelAndView("error/500", "message", ex.getLocalizedMessage());
	} 
}
