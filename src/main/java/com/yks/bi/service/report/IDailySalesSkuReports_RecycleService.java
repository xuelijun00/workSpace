package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailySalesSkuReports_Recycle;
import com.yks.bi.dto.report.DailySalesSkuReports_RecycleKey;

public interface IDailySalesSkuReports_RecycleService {
	
	List<DailySalesSkuReports_Recycle> selectSmtAll(DailySalesSkuReports_RecycleKey key);
	
	List<DailySalesSkuReports_Recycle> selectWalmartAll(DailySalesSkuReports_RecycleKey key);

	List<DailySalesSkuReports_Recycle> selectWishAll(DailySalesSkuReports_RecycleKey key);
	
	List<String> selectBusiness();
	
	List<DailySalesSkuReports_Recycle> selectNewPlatformAll(DailySalesSkuReports_RecycleKey key);
	
	List<String> selectNewPlatformBusiness();
	
	List<DailySalesSkuReports_Recycle> selectNewEggAll(DailySalesSkuReports_RecycleKey key);
}
