package com.yks.bi.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController implements HandlerExceptionResolver  {
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,Exception ex) {
		return new ModelAndView("error/500", "message", ex.getMessage());
	} 
}
