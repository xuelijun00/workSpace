package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutCategoryReportsMapper;
import com.yks.bi.dto.report.DailyOutCategoryReports;
import com.yks.bi.dto.report.DailyOutCategoryReportsKey;
import com.yks.bi.service.report.IDailyOutCategoryReportsService;

@Service
public class DailyOutCategoryReportsServiceImpl implements IDailyOutCategoryReportsService{

	@Autowired 
	private DailyOutCategoryReportsMapper docrm;

	@Override
	public List<DailyOutCategoryReports> selectAllGrid(DailyOutCategoryReportsKey key) {
		return docrm.selectAll(key);
	}

	@Override
	public List<DailyOutCategoryReports> selectAllChart(DailyOutCategoryReportsKey key) {
		return docrm.selectAllCount(key);
	}

}
