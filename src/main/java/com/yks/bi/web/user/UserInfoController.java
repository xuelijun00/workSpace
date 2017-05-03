package com.yks.bi.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yks.bi.dto.user.UserInfo;
import com.yks.bi.service.user.IUserInfoService;
import com.yks.bi.web.vo.GridModel;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private IUserInfoService userService;

	@RequestMapping(value = "/showView", method = RequestMethod.GET)
	public String showView(ModelMap modelMap) {
		List<UserInfo> list = userService.listUserInfo();
		modelMap.addAttribute("userInfos", list);
		return "userlist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/api/alluser", method = RequestMethod.GET,produces="application/json")
	public GridModel allUser(GridModel gm) {
		return new GridModel().getGridModel(userService.listUserInfo1(gm));
	}

	@RequestMapping("/showUserInfo")
	public String userInfo(ModelMap modelMap) {
		UserInfo user = userService.selectByPrimaryKey(1);
		modelMap.addAttribute("userInfo", user);
		return "userinfo";
	}

}
