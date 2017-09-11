package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailySalesCategoryReports_accountMapper;
import com.yks.bi.dto.report.DailySalesCategoryReports_account;
import com.yks.bi.dto.report.DailySalesCategoryReports_accountKey;
import com.yks.bi.service.report.IDailySalesCategoryReports_accountService;

@Service
public class DailySalesCategoryReports_accountServiceImpl implements IDailySalesCategoryReports_accountService{

	@Autowired
	private DailySalesCategoryReports_accountMapper dscram;
	
	@Override
	public List<String> selectSmtCategory() {
		return dscram.selectSmtCategory();
	}

	@Override
	public List<String> selectSmtCategorySupervisor() {
		return dscram.selectSmtCategorySupervisor();
	}

	@Override
	public List<String> selectSmtAccount() {
		return dscram.selectSmtAccount();
	}

	@Override
	public List<DailySalesCategoryReports_account> selectSmtAll(DailySalesCategoryReports_accountKey key) {
		return dscram.selectSmtAll(key);
	}

	
}
