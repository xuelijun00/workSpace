package com.yks.bi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.ConfigPlatformGoalNew;

public interface ConfigPlatformGoalNewMapper {
    /*int deleteByPrimaryKey(Integer id);

    int insert(ConfigPlatformGoalNew record);

    int insertSelective(ConfigPlatformGoalNew record);

    ConfigPlatformGoalNew selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ConfigPlatformGoalNew record);*/
    
    
    /**
     * 更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ConfigPlatformGoalNew record);
    
    List<ConfigPlatformGoalNew> selectByPrimaryKey(@Param("month") String month,@Param("name") String name);

	List<String> selectPlatform();
    
}