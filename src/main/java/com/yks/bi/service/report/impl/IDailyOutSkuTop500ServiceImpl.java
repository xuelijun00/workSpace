package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutSkuTop500Mapper;
import com.yks.bi.dto.report.DailyOutSkuTop500;
import com.yks.bi.dto.report.DailyOutSkuTop500Key;
import com.yks.bi.service.report.IDailyOutSkuTop500Service;

@Service
public class IDailyOutSkuTop500ServiceImpl implements IDailyOutSkuTop500Service {

	@Autowired
	private DailyOutSkuTop500Mapper dostm;
	
	@Override
	public List<DailyOutSkuTop500> selectAll(DailyOutSkuTop500Key key) {
		return dostm.selectAll(key);
	}

	@Override
	public List<String> selectPlatform() {
		return dostm.selectPlatform();
	}

	@Override
	public List<String> selectBuyerCountry(String platform) {
		return dostm.selectBuyerCountry(platform);
	}

}
