package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutManagerSumReprotsMapper;
import com.yks.bi.dto.report.DailyOutManagerSumReprots;
import com.yks.bi.dto.report.DailyOutManagerSumReprotsKey;
import com.yks.bi.service.report.IDailyOutManagerSumReprotsService;

@Service
public class DailyOutManagerSumReprotsServiceImpl implements IDailyOutManagerSumReprotsService {
	
	@Autowired
	private DailyOutManagerSumReprotsMapper dailyOutManagerSumReprotsMapper;

	@Override
	public List<DailyOutManagerSumReprots> selectByCondition(DailyOutManagerSumReprotsKey key) {
		return dailyOutManagerSumReprotsMapper.selectByCondition(key);
	}

	@Override
	public List<String> selectManagers() {
		return dailyOutManagerSumReprotsMapper.selectManagers();
	}

	@Override
	public List<DailyOutManagerSumReprots> selectManagerAchievementByWeek(DailyOutManagerSumReprotsKey key) {
		return dailyOutManagerSumReprotsMapper.selectManagerAchievementByWeek(key);
	}

	@Override
	public List<String> selectPlatform() {
		return dailyOutManagerSumReprotsMapper.selectPlatform();
	}

}
