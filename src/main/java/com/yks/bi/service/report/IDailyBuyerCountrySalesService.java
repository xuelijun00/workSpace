package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailyBuyerCountrySalesReports;
import com.yks.bi.dto.report.DailyBuyerCountrySalesReportsKey;

public interface IDailyBuyerCountrySalesService {
	
	List<DailyBuyerCountrySalesReports> selectByPrimaryKey(DailyBuyerCountrySalesReportsKey key);

	List<DailyBuyerCountrySalesReports> selectNewPlatformAll(DailyBuyerCountrySalesReportsKey key);
	
	List<String> selectNewPlatforms();
}
