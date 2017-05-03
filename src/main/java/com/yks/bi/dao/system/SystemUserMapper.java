package com.yks.bi.dao.system;

import java.util.List;

import com.yks.bi.dto.system.SystemUser;

public interface SystemUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

	List<SystemUser> selectSystemUser(SystemUser record);
}