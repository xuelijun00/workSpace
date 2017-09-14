package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.DailySalesCategoryReports_account;
import com.yks.bi.dto.report.DailySalesCategoryReports_accountKey;

public interface DailySalesCategoryReports_accountMapper {

	List<String> selectSmtCategory();
	
	List<String> selectSmtCategorySupervisor();
	
	List<String> selectSmtAccount();
	
	List<DailySalesCategoryReports_account> selectSmtAll(DailySalesCategoryReports_accountKey key);
	
	List<DailySalesCategoryReports_account> selectCategorySum(DailySalesCategoryReports_accountKey key);
}
