package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyBuyerCountrySalesReportsMapper;
import com.yks.bi.dto.report.DailyBuyerCountrySalesReports;
import com.yks.bi.dto.report.DailyBuyerCountrySalesReportsKey;
import com.yks.bi.service.report.IDailyBuyerCountrySalesService;

@Service
public class DailyBuyerCountrySalesServiceImpl implements IDailyBuyerCountrySalesService {

	@Autowired
	private  DailyBuyerCountrySalesReportsMapper iBuyerCountry;
	
	@Override
	public List<DailyBuyerCountrySalesReports> selectByPrimaryKey(DailyBuyerCountrySalesReportsKey key) {
		
		return iBuyerCountry.selectByPrimaryKey(key);
	}

	@Override
	public List<DailyBuyerCountrySalesReports> selectNewPlatformAll(DailyBuyerCountrySalesReportsKey key) {
		
		return iBuyerCountry.selectNewPlatformAll(key);
	}
	
	@Override
	public List<String> selectNewPlatforms() {
		
		return iBuyerCountry.selectNewPlatforms();
	}
	
	@Override
	public List<String> selectBuyerCountry(DailyBuyerCountrySalesReportsKey key) {
		
		return iBuyerCountry.selectBuyerCountry(key);
	}
	
	@Override
	public List<String> selectNewPlatformBuyerCountry(DailyBuyerCountrySalesReportsKey key) {
		
		return iBuyerCountry.selectNewPlatformBuyerCountry(key);
	}

}
