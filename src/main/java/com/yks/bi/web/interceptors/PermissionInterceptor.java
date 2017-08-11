package com.yks.bi.web.interceptors;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yks.bi.dto.system.ReportPermission;
import com.yks.bi.dto.system.SystemUser;
import com.yks.bi.web.exception.ForbiddenException;

/**
 * 权限拦截器
 * @author liuxing
 *
 */
public class PermissionInterceptor implements HandlerInterceptor {
	
	@Autowired
	ReportPermission permission;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		SystemUser curuser = (SystemUser)session.getAttribute("systemUser");
		String servletPath = request.getServletPath();
		if(curuser != null && servletPath.equals("/index")){
			if(curuser.getRole().contains("admin") || curuser.getCompetence().contains("all")){
				curuser.setUrls(permission.getPermission());
				return true;
			}
			Map<String,String> map = new HashMap<String,String>();
			map.putAll(permission.getPermission());
			
			for (Entry<String, String> entry : map.entrySet()) {
				if(!curuser.getCompetence().contains(entry.getKey())){
					map.put(entry.getKey(), "/common?path=error/403");
				}
			}
			curuser.setUrls(map);
		}
		if(curuser != null && servletPath.equals("/common")){
			String path = "/common?path=" + request.getParameter("path");
			if(!curuser.getUrls().containsValue(path)){
				throw new ForbiddenException("权限不足");
			}
		}
		return true;
	}

}
