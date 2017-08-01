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
	public List<String> selectAccount() {
		return dailyout.selectAccount();
	}
	
	@Override
	public List<String> selectSku() {
		return dailyout.selectSku();
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
