package com.yks.bi.web.interceptors;



import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
	/**
	 * 请求在调用collector前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("systemUser");
		if(obj == null){
			//使用这个是因为，页面用的是iframe，超时有个页面显示的问题
			PrintWriter out = response.getWriter();    
            StringBuilder builder = new StringBuilder();    
            builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");    
            builder.append("window.top.location.href='"+request.getContextPath()+"/'");    
            builder.append("</script>");    
            out.print(builder.toString());    
            out.close();
			//request.getRequestDispatcher("/WEB-INF/view/jsp/login.jsp").forward(request, response); 
			return false;
		}
		return true;
	}

}
