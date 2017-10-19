package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailyOutCategoryReports;
import com.yks.bi.dto.report.DailyOutCategoryReportsKey;

public interface IDailyOutCategoryReportsService {

	List<DailyOutCategoryReports> selectAllGrid(DailyOutCategoryReportsKey key);
	
	List<DailyOutCategoryReports> selectAllChart(DailyOutCategoryReportsKey key);
}
