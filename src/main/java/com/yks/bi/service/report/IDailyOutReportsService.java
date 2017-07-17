package com.yks.bi.service.report;

import java.util.Date;
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
	List<DailyOutReports> selectSumDomesticWarehouseShipment(String startDate,String endDate);
	/**
	 * 国内仓各平台发货汇总
	 * @param key
	 * @return
	 */
	List<DailyOutReports> selectPlatformDomesticWarehouseShipment(DailyOutReportsKey key);

	/**
	 * 各平台发货汇总数据
	 * @param startDate
	 * @param endDate
	 * @param platform
	 * @return
	 */
	List<DailyOutReports> selectPlatformWarehouseShipmentCount(Date startDate, Date endDate, String platform);

	/**
	 * 查询平台
	 * @param platforms
	 * @return
	 */
	List<String> selectPlatforms(String platforms);
	
}
