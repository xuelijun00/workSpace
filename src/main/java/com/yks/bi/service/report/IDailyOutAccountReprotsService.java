package com.yks.bi.service.report;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailyOutAccountReprots;
import com.yks.bi.dto.report.DailyOutAccountReprotsKey;

public interface IDailyOutAccountReprotsService {

	List<String> selectPlatforms();
	
	List<String> selectSalesAccounts(String platform);
	
	List<String> selectCategorys();
	
	List<DailyOutAccountReprots> selectAllByPrimaryKey(DailyOutAccountReprotsKey key);
	
	List<String> selectNewPlatforms();
	
	List<String> selectNewPlatformSalesAccounts(String platform);
	
	List<DailyOutAccountReprots> selectNewPlatformAllByPrimaryKey(DailyOutAccountReprotsKey key);
	
	List<String> selectNewEggSalesAccounts(String platform);
	
	List<DailyOutAccountReprots> selectNewEggAllByPrimaryKey(DailyOutAccountReprotsKey key);
}
