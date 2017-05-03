package com.yks.bi.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yks.bi.dao.user.UserInfoMapper;
import com.yks.bi.dto.user.UserInfo;
import com.yks.bi.service.user.IUserInfoService;
import com.yks.bi.web.vo.GridModel;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private UserInfoMapper userMapper;
	
	public List<UserInfo> listUserInfo() {
		return userMapper.selectByAll();
	}
	
	@SuppressWarnings("unchecked")
	public Page<UserInfo> listUserInfo1(GridModel gm) {
		Page<UserInfo> pageHelper = PageHelper.startPage(gm.getPage(), Integer.parseInt(gm.getRows().get(0).toString()));
		if(!StringUtils.isEmpty(gm.getSidx())){
			PageHelper.orderBy(gm.getSidx() + " " + gm.getSord());
		}
		userMapper.selectByAll();
		return pageHelper;
	}

	public UserInfo selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
