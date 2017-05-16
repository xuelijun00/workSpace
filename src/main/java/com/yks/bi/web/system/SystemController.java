package com.yks.bi.web.system;

import com.yks.bi.dto.system.SystemUser;
import com.yks.bi.service.system.SystemUserService;
import com.yks.bi.web.vo.MessageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/7.
 */
@Controller
@RequestMapping("/")
public class SystemController {

    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping("/")
    public String root(){
        return "login";
    }
    
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/common")
    public String index(String path){
        return path;
    }

    @ResponseBody
    @RequestMapping(value = "/login",method= RequestMethod.POST,produces="application/json")
    public MessageVo login(SystemUser user, HttpServletRequest request) throws IOException {
        if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            return new MessageVo(400,"请输入用户名或登入密码");
        }
        SystemUser loginuser = systemUserService.login(user.getUsername(),user.getPassword());
        if(loginuser == null){
            return new MessageVo(400,"用户名或密码错误");
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("systemUser",loginuser);
            return new MessageVo(200,"登入成功");
        }
    }
    /**
     * 登出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(String userId ,HttpServletRequest request){
    	HttpSession session = request.getSession();
    	session.removeAttribute("systemUser");
    	return "redirect:/";
    }
    
}
