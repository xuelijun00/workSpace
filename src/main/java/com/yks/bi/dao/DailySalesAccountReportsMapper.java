package com.yks.bi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailySalesAccountReports;
import com.yks.bi.dto.report.DailySalesAccountReportsKey;

public interface DailySalesAccountReportsMapper {
    int deleteByPrimaryKey(DailySalesAccountReportsKey key);

    int insert(DailySalesAccountReports record);

    int insertSelective(DailySalesAccountReports record);

    DailySalesAccountReports selectByPrimaryKey(DailySalesAccountReportsKey key);
    
    List<DailySalesAccountReports> selectByCondition(DailySalesAccountReportsKey key);
    /**
     * 查询平台
     * @return
     */
    List<String> selectPlatform();
    /**
     * 查询账号
     * @param business
     * @return
     */
    List<String> selectAccount(@Param("business") String business);

    int updateByPrimaryKeySelective(DailySalesAccountReports record);

    int updateByPrimaryKey(DailySalesAccountReports record);
    /**
     * 账号汇总
     * @param key
     * @return
     */
    List<DailySalesAccountReports> selectAccountSum(DailySalesAccountReportsKey key);
}