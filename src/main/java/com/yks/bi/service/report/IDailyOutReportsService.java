package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailyOutReports;
import com.yks.bi.dto.report.DailyOutReportsKey;

public interface IDailyOutReportsService {
	
	/**
	 * 各平台发货数据
	 * @param key
	 * @return
	 */
	List<DailyOutReports> selectByTimesAndPlatform(DailyOutReportsKey key);
	
	/**
	 * 国内仓发货汇总数据
	 * @return
	 */
	List<DailyOutReports> selectSumDomesticWarehouseShipment(DailyOutReportsKey key);
	
	/**
	 * 国内仓各平台发货汇总 旧
	 * @param key
	 * @return
	 */
	List<DailyOutReports> selectPlatformDomesticWarehouseShipment(DailyOutReportsKey key);

	/**
	 * 国内仓发货汇总数据 表格
	 * @param key
	 * @return
	 */
	List<DailyOutReports> selectPlatformWarehouseShipmentCount(DailyOutReportsKey key);
	
	
	/**
	 * 国内仓发货汇总数据 曲线图
	 * @param key
	 * @return
	 */
	List<DailyOutReports> selectPlatformWarehouseShipmentCountChart(DailyOutReportsKey key);

	/**
	 * 查询平台
	 * @param platforms
	 * @return
	 */
	List<String> selectPlatforms(String platforms);

	
	
}
