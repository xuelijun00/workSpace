package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprots;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprotsKey;

public interface IDailyOutEbayGroupLeaderReprotsService {
	
	List<String> selectSite();//站点
    
    List<String> selectLeader();//组长
    
    List<DailyOutEbayGroupLeaderReprots> selectByCondition(DailyOutEbayGroupLeaderReprotsKey key);
    /**
     * 组长每周成绩
     * @param key
     * @return
     */
    List<DailyOutEbayGroupLeaderReprots> selectLeaderDailyOutByWeek(DailyOutEbayGroupLeaderReprotsKey key);

}
