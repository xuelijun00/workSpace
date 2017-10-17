package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.DailysalescategoryreportsKey;

public interface DailysalescategoryreportsMapper {
    int deleteByPrimaryKey(DailysalescategoryreportsKey key);

    int insert(Dailysalescategoryreports record);

    int insertSelective(Dailysalescategoryreports record);

    Dailysalescategoryreports selectByPrimaryKey(DailysalescategoryreportsKey key);
    
    List<Dailysalescategoryreports> selectAll(DailysalescategoryreportsKey key);

    List<Dailysalescategoryreports> selectAllChart(DailysalescategoryreportsKey key);

    List<Dailysalescategoryreports> selectnewAll(DailysalescategoryreportsKey key);
    
    List<String> selectBusiness();   
    
    List<String> selectnewPlatforms();
    
    int updateByPrimaryKeySelective(Dailysalescategoryreports record);

    int updateByPrimaryKey(Dailysalescategoryreports record);
}