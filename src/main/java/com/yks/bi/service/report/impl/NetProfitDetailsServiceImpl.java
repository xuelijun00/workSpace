package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutSkuReprotsMapper;
import com.yks.bi.dto.report.DailyOutSkuReprots;
import com.yks.bi.service.report.INetProfitDetailsService;

@Service
public class NetProfitDetailsServiceImpl implements INetProfitDetailsService {

	@Autowired
	private DailyOutSkuReprotsMapper dailyout;
	
	@Override
	public List<DailyOutSkuReprots> selectAll(DailyOutSkuReprots key) {
		return dailyout.selectAll(key);
	}

	@Override
	public List<String> selectPlatform() {
		return dailyout.selectPlatform();
	}

	@Override
	public List<String> selectAccount(String platform) {
		return dailyout.selectAccount(platform);
	}
	
	@Override
	public List<String> selectZhuzhandian(String platform) {
		return dailyout.selectZhuzhandian(platform);
	}

	@Override
	public List<DailyOutSkuReprots> selectNewPlatformAll(DailyOutSkuReprots key) {
		return dailyout.selectNewPlatformAll(key);
	}

	@Override
	public List<String> selectNewPlatform() {
		return dailyout.selectNewPlatform();
	}

	@Override
	public List<String> selectNewPlatformAccount(String platform) {
		return dailyout.selectNewPlatformAccount(platform);
	}

	@Override
	public List<DailyOutSkuReprots> selectNewEggAll(DailyOutSkuReprots key) {
		return dailyout.selectNewEggAll(key);
	}

	@Override
	public List<String> selectNewEggAccount(String platform) {
		return dailyout.selectNewEggAccount(platform);
	}
	
	@Override
	public List<DailyOutSkuReprots> selectWalmartAll(DailyOutSkuReprots key) {
		
		return dailyout.selectWalmartAll(key);
	}

	@Override
	public List<String> selectWalmartAccount() {
		return dailyout.selectWalmartAccount();
	}

}
