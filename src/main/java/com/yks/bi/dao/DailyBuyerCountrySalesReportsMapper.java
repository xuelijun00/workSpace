package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.DailyBuyerCountrySalesReports;
import com.yks.bi.dto.report.DailyBuyerCountrySalesReportsKey;

public interface DailyBuyerCountrySalesReportsMapper {

	List<DailyBuyerCountrySalesReports> selectByPrimaryKey(DailyBuyerCountrySalesReportsKey key);
	
	List<DailyBuyerCountrySalesReports> selectNewPlatformAll(DailyBuyerCountrySalesReportsKey key);
	
	List<String> selectNewPlatforms();
	
	List<String> selectBuyerCountry(DailyBuyerCountrySalesReportsKey key);
	
	List<String> selectNewPlatformBuyerCountry(DailyBuyerCountrySalesReportsKey key);
	
	List<DailyBuyerCountrySalesReports> selectSalesGroupcountry();
	
}
