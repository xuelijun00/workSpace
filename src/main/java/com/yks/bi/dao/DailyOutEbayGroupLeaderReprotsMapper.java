package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprots;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprotsKey;

public interface DailyOutEbayGroupLeaderReprotsMapper {
	
    int deleteByPrimaryKey(DailyOutEbayGroupLeaderReprotsKey key);

    int insert(DailyOutEbayGroupLeaderReprots record);

    int insertSelective(DailyOutEbayGroupLeaderReprots record);

    DailyOutEbayGroupLeaderReprots selectByPrimaryKey(DailyOutEbayGroupLeaderReprotsKey key);
    
    List<String> selectSite();//站点
    
    List<String> selectLeader();//组长
    
    List<DailyOutEbayGroupLeaderReprots> selectByCondition(DailyOutEbayGroupLeaderReprotsKey key);
    /**
     * 组长每周成绩
     * @param key
     * @return
     */
    List<DailyOutEbayGroupLeaderReprots> selectLeaderDailyOutByWeek(DailyOutEbayGroupLeaderReprotsKey key);

    int updateByPrimaryKeySelective(DailyOutEbayGroupLeaderReprots record);

    int updateByPrimaryKey(DailyOutEbayGroupLeaderReprots record);
}