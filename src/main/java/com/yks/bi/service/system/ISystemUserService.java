package com.yks.bi.service.system;

import java.util.List;

import com.yks.bi.dto.system.SystemUser;

public interface ISystemUserService {
	
	List<SystemUser> getSystemUser(SystemUser record);
	
}
