package com.yks.bi.service.user;

import java.util.List;

import com.github.pagehelper.Page;
import com.yks.bi.dto.user.UserInfo;
import com.yks.bi.web.vo.GridModel;

public interface IUserInfoService {
	
	List<UserInfo> listUserInfo();
	
	Page<UserInfo> listUserInfo1(GridModel gm);
	
	UserInfo selectByPrimaryKey(Integer id);
	
}
