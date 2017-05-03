package com.yks.bi.web.system;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yks.bi.dto.system.SystemUser;

@Controller
@RequestMapping("/")
public class SystemController {
	
	@RequestMapping("/")
	public String index(ModelMap model){
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/login",method=RequestMethod.POST,produces="application/json")
	public Map<String,Object> login(SystemUser user){
		Map<String,Object> result = new HashMap<String,Object>();
		if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
			result.put("error", "请输入用户名或登入密码");
			return result;
		}
		
		try{
			result.put("success", "登入成功");
			return result;
		}catch(Exception auth){
			result.put("error", "用户名或密码错误");
			return result;
		}
	}
	
}
