package com.yks.bi.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.system.SystemUserMapper;
import com.yks.bi.dto.system.SystemUser;
import com.yks.bi.service.system.ISystemUserService;

@Service
public class SystemUserServiceImpl implements ISystemUserService {
	
	@Autowired
	private SystemUserMapper systemUser;
	
	public List<SystemUser> getSystemUser(SystemUser record) {
		return systemUser.selectSystemUser(record);
	}

}
