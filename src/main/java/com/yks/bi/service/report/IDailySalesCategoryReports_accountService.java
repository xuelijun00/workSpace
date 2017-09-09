package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailySalesCategoryReports_account;
import com.yks.bi.dto.report.DailySalesCategoryReports_accountKey;

public interface IDailySalesCategoryReports_accountService {

	List<String> selectSmtCategory();
	
	List<String> selectSmtCategorySupervisor();
	
	List<String> selectSmtAccount();
	
	List<DailySalesCategoryReports_account> selectSmtAll(DailySalesCategoryReports_accountKey key);
}
