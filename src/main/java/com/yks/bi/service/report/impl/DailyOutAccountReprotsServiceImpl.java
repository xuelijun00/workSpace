package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutAccountReprotsMapper;
import com.yks.bi.dto.report.DailyOutAccountReprots;
import com.yks.bi.dto.report.DailyOutAccountReprotsKey;
import com.yks.bi.service.report.IDailyOutAccountReprotsService;

@Service
public class DailyOutAccountReprotsServiceImpl implements IDailyOutAccountReprotsService{
	
	@Autowired
	private DailyOutAccountReprotsMapper doarm;
	
	@Override
	public List<String> selectPlatforms() {
		return doarm.selectPlatforms();
	}

	@Override
	public List<String> selectSalesAccounts(String platform) {
		return doarm.selectSalesAccounts(platform);
	}

	@Override
	public List<String> selectCategorys(String platform) {
		
		return doarm.selectCategorys(platform);
	}

	@Override
	public List<DailyOutAccountReprots> selectAllByPrimaryKey(DailyOutAccountReprotsKey key) {
		return doarm.selectAllByPrimaryKey(key);
	}

	@Override
	public List<DailyOutAccountReprots> selectProfitSum(DailyOutAccountReprotsKey key) {
		return doarm.selectProfitSum(key);
	}

	@Override
	public List<String> selectNewPlatforms() {
		return doarm.selectNewPlatforms();
	}

	@Override
	public List<String> selectNewPlatformSalesAccounts(String platform) {
		return doarm.selectNewPlatformSalesAccounts(platform);
	}

	@Override
	public List<DailyOutAccountReprots> selectNewPlatformAllByPrimaryKey(DailyOutAccountReprotsKey key) {
		return doarm.selectNewPlatformAllByPrimaryKey(key);
	}

	@Override
	public List<String> selectNewEggSalesAccounts(String platform) {
		return doarm.selectNewEggSalesAccounts(platform);
	}

	@Override
	public List<DailyOutAccountReprots> selectNewEggAllByPrimaryKey(DailyOutAccountReprotsKey key) {
		return doarm.selectNewEggAllByPrimaryKey(key);
	}

}
