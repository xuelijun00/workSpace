package com.yks.bi.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.DailysalescategoryreportsKey;

public interface DailysalescategoryreportsMapper {
    int deleteByPrimaryKey(DailysalescategoryreportsKey key);

    int insert(Dailysalescategoryreports record);

    int insertSelective(Dailysalescategoryreports record);

    Dailysalescategoryreports selectByPrimaryKey(DailysalescategoryreportsKey key);
    
    List<Dailysalescategoryreports> selectAll(@Param("business")String business,@Param("start_date")Date start_date,@Param("end_date")Date end_date,@Param("category")String category);

    List<Dailysalescategoryreports> selectnewAll(@Param("business")String business,@Param("start_date")Date start_date,@Param("end_date")Date end_date,@Param("category")String category);
    
    
    
    List<String> selectnewPlatforms();
    
    int updateByPrimaryKeySelective(Dailysalescategoryreports record);

    int updateByPrimaryKey(Dailysalescategoryreports record);
}