package com.yks.bi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailyOutReports;
import com.yks.bi.dto.report.DailyOutReportsKey;

public interface DailyOutReportsMapper {
    int deleteByPrimaryKey(DailyOutReportsKey key);

    int insert(DailyOutReports record);

    int insertSelective(DailyOutReports record);

    DailyOutReports selectByPrimaryKey(DailyOutReportsKey key);
    
    /**
     * 各平台发货数据
     * @param key
     * @return
     */
    List<DailyOutReports> selectByTimesAndPlatform(DailyOutReportsKey key);
    
    /**
     * 国内仓发货数据汇总
     * @param startDate
     * @param endDate
     * @return
     */
    List<DailyOutReports> selectSumDomesticWarehouseShipment(@Param("startDate")String startDate,@Param("endDate")String endDate);
    /**
     * 国内仓各平台发货汇总
     * @param key
     * @return
     */
    List<DailyOutReports> selectPlatformDomesticWarehouseShipment(DailyOutReportsKey key);
    
    int updateByPrimaryKeySelective(DailyOutReports record);

    int updateByPrimaryKey(DailyOutReports record);

    /**
     * 国内仓各平台发货汇总 表格
     * @param key
     * @return
     */
	List<DailyOutReports> selectPlatformWarehouseShipmentCount(DailyOutReportsKey key);
	
	/**
     * 国内仓各平台发货汇总 曲线图
     * @param key
     * @return
     */
	List<DailyOutReports> selectPlatformWarehouseShipmentCountChart(DailyOutReportsKey key);

	List<String> selectPlatforms(@Param("platform")String platforms);



}