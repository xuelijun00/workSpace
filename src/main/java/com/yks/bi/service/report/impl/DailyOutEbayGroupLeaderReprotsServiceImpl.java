package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutEbayGroupLeaderReprotsMapper;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprots;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprotsKey;
import com.yks.bi.service.report.IDailyOutEbayGroupLeaderReprotsService;

@Service
public class DailyOutEbayGroupLeaderReprotsServiceImpl implements IDailyOutEbayGroupLeaderReprotsService {

	@Autowired
	private DailyOutEbayGroupLeaderReprotsMapper mapper;
	
	@Override
	public List<String> selectSite() {
		return mapper.selectSite();
	}

	@Override
	public List<String> selectLeader() {
		return mapper.selectLeader();
	}

	@Override
	public List<DailyOutEbayGroupLeaderReprots> selectByCondition(DailyOutEbayGroupLeaderReprotsKey key) {
		return mapper.selectByCondition(key);
	}

	@Override
	public List<DailyOutEbayGroupLeaderReprots> selectLeaderDailyOutByWeek(DailyOutEbayGroupLeaderReprotsKey key) {
		return mapper.selectLeaderDailyOutByWeek(key);
	}

}
