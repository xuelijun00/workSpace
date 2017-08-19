package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailySalesAccountReportsMapper;
import com.yks.bi.dto.report.DailySalesAccountReports;
import com.yks.bi.dto.report.DailySalesAccountReportsKey;
import com.yks.bi.service.report.IAccountAchievementService;

@Service
public class AccountAchievementServiceImpl implements IAccountAchievementService {

	@Autowired
	private DailySalesAccountReportsMapper accountAchievement;
	
	@Override
	public List<DailySalesAccountReports> selectAccountAchievementService(DailySalesAccountReportsKey key) {
		return accountAchievement.selectByCondition(key);
	}

	@Override
	public List<String> selectPlatform() {
		return accountAchievement.selectPlatform();
	}

	@Override
	public List<String> selectAccount(String business) {
		return accountAchievement.selectAccount(business);
	}

	@Override
	public List<DailySalesAccountReports> selectAccountSum(DailySalesAccountReportsKey key) {
		return accountAchievement.selectAccountSum(key);
	}
	
	

}
