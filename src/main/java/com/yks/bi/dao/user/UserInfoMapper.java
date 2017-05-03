package com.yks.bi.dao.user;

import java.util.List;

import com.yks.bi.dto.user.UserInfo;

public interface UserInfoMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    List<UserInfo> selectByAll();
    
    UserInfo selectByPrimaryKey(Integer id);
}