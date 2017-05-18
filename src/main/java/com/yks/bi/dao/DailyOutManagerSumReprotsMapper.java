package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.DailyOutManagerSumReprots;
import com.yks.bi.dto.report.DailyOutManagerSumReprotsKey;

public interface DailyOutManagerSumReprotsMapper {
    int deleteByPrimaryKey(DailyOutManagerSumReprotsKey key);

    int insert(DailyOutManagerSumReprots record);

    int insertSelective(DailyOutManagerSumReprots record);

    DailyOutManagerSumReprots selectByPrimaryKey(DailyOutManagerSumReprotsKey key);
    
    /**
     * 账号管理人员业绩
     * @param key
     * @return
     */
    List<DailyOutManagerSumReprots> selectManagerAchievementByWeek(DailyOutManagerSumReprotsKey key);
    /**
     * 根据条件查询
     * @param key
     * @return
     */
    List<DailyOutManagerSumReprots> selectByCondition(DailyOutManagerSumReprotsKey key);
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

    int updateByPrimaryKeySelective(DailyOutManagerSumReprots record);

    int updateByPrimaryKey(DailyOutManagerSumReprots record);
}