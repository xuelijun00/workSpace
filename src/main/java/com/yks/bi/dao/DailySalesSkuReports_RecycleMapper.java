package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.DailySalesSkuReports_Recycle;
import com.yks.bi.dto.report.DailySalesSkuReports_RecycleKey;

public interface DailySalesSkuReports_RecycleMapper {
	
	List<DailySalesSkuReports_Recycle> selectAmazonAll(DailySalesSkuReports_RecycleKey key);
	
	List<DailySalesSkuReports_Recycle> selectEbayAll(DailySalesSkuReports_RecycleKey key);
	
	List<DailySalesSkuReports_Recycle> selectLazadaAll(DailySalesSkuReports_RecycleKey key);
	
	List<DailySalesSkuReports_Recycle> selectSmtAll(DailySalesSkuReports_RecycleKey key);
	
	List<DailySalesSkuReports_Recycle> selectWalmartAll(DailySalesSkuReports_RecycleKey key);
	
	List<DailySalesSkuReports_Recycle> selectWishAll(DailySalesSkuReports_RecycleKey key);
	
/*	List<String> selectBusiness();*/
	
	List<DailySalesSkuReports_Recycle> selectNewPlatformAll(DailySalesSkuReports_RecycleKey key);
	
	List<String> selectNewPlatformBusiness();
	
	List<DailySalesSkuReports_Recycle> selectNewEggAll(DailySalesSkuReports_RecycleKey key);
	
	List<String> selectNewEggBusiness();
	
}
