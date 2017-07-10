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
	List<DailyOutReports> selectSumDomesticWarehouseShipment(String startDate,String endDate);
	/**
	 * 国内仓各平台发货汇总
	 * @param key
	 * @return
	 */
	List<DailyOutReports> selectPlatformDomesticWarehouseShipment(DailyOutReportsKey key);
	
}
