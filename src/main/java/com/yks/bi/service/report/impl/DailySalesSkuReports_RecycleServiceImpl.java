package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailySalesSkuReports_RecycleMapper;
import com.yks.bi.dto.report.DailySalesSkuReports_Recycle;
import com.yks.bi.dto.report.DailySalesSkuReports_RecycleKey;
import com.yks.bi.service.report.IDailySalesSkuReports_RecycleService;

@Service
public class DailySalesSkuReports_RecycleServiceImpl implements IDailySalesSkuReports_RecycleService {

	@Autowired
	private DailySalesSkuReports_RecycleMapper dssrrm;

	@Override
	public List<DailySalesSkuReports_Recycle> selectAmazonAll(DailySalesSkuReports_RecycleKey key) {
		return dssrrm.selectAmazonAll(key);
	}

	@Override
	public List<DailySalesSkuReports_Recycle> selectEbayAll(DailySalesSkuReports_RecycleKey key) {
		return dssrrm.selectEbayAll(key);
	}

	@Override
	public List<DailySalesSkuReports_Recycle> selectLazadaAll(DailySalesSkuReports_RecycleKey key) {
		return dssrrm.selectLazadaAll(key);
	}
	
	@Override
	public List<DailySalesSkuReports_Recycle> selectSmtAll(DailySalesSkuReports_RecycleKey key) {
		return dssrrm.selectSmtAll(key);
	}

	@Override
	public List<DailySalesSkuReports_Recycle> selectWalmartAll(DailySalesSkuReports_RecycleKey key) {
		return dssrrm.selectWalmartAll(key);
	}
	
	@Override
	public List<DailySalesSkuReports_Recycle> selectWishAll(DailySalesSkuReports_RecycleKey key) {
		return dssrrm.selectWishAll(key);
	}

/*	@Override
	public List<String> selectBusiness() {
		return dssrrm.selectBusiness();
	}
*/
	@Override
	public List<DailySalesSkuReports_Recycle> selectNewPlatformAll(DailySalesSkuReports_RecycleKey key) {
		return dssrrm.selectNewPlatformAll(key);
	}

	@Override
	public List<String> selectNewPlatformBusiness() {
		return dssrrm.selectNewPlatformBusiness();
	}
	
	@Override
	public List<DailySalesSkuReports_Recycle> selectNewEggAll(DailySalesSkuReports_RecycleKey key) {
		return dssrrm.selectNewEggAll(key);
	}

	@Override
	public List<String> selectNewEggBusiness() {
		return dssrrm.selectNewEggBusiness();
	}

}
