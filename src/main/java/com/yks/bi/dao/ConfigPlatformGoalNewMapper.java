package com.yks.bi.dao;

import com.yks.bi.dto.report.ConfigPlatformGoalNew;

public interface ConfigPlatformGoalNewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfigPlatformGoalNew record);

    int insertSelective(ConfigPlatformGoalNew record);

    ConfigPlatformGoalNew selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfigPlatformGoalNew record);

    int updateByPrimaryKey(ConfigPlatformGoalNew record);
}