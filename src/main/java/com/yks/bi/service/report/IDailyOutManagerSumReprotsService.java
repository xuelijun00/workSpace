package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailyOutManagerSumReprots;
import com.yks.bi.dto.report.DailyOutManagerSumReprotsKey;

public interface IDailyOutManagerSumReprotsService {
	
	/**
     * 根据条件查询
     * @param key
     * @return
     */
    List<DailyOutManagerSumReprots> selectByCondition(DailyOutManagerSumReprotsKey key);
    /**
     * 查询账号管理员每周业绩
     * @param key
     * @return
     */
    List<DailyOutManagerSumReprots> selectManagerAchievementByWeek(DailyOutManagerSumReprotsKey key);
    /**
     * 查询账号管理员
     * @return
     */
    List<String> selectManagers();
    
    /**
     * 查询平台
     * @return
     */
    List<String> selectPlatform();

}
