package com.yks.bi.dao;

import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprots;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprotsKey;

public interface DailyOutEbayGroupLeaderReprotsMapper {
	
    int deleteByPrimaryKey(DailyOutEbayGroupLeaderReprotsKey key);

    int insert(DailyOutEbayGroupLeaderReprots record);

    int insertSelective(DailyOutEbayGroupLeaderReprots record);

    DailyOutEbayGroupLeaderReprots selectByPrimaryKey(DailyOutEbayGroupLeaderReprotsKey key);

    int updateByPrimaryKeySelective(DailyOutEbayGroupLeaderReprots record);

    int updateByPrimaryKey(DailyOutEbayGroupLeaderReprots record);
}