package com.yks.bi.service.report.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutReportsMapper;
import com.yks.bi.dto.report.DailyOutReports;
import com.yks.bi.dto.report.DailyOutReportsKey;
import com.yks.bi.service.report.IDailyOutReportsService;

@Service
public class DailyOutReportsServiceImpl implements IDailyOutReportsService {
	
	@Autowired
	private DailyOutReportsMapper dailyOutReportsMapper;

	@Override
	public List<DailyOutReports> selectByTimesAndPlatform(DailyOutReportsKey key) {
		
		return dailyOutReportsMapper.selectByTimesAndPlatform(key);
	}
	
	@Override
	public List<DailyOutReports> selectSumDomesticWarehouseShipment(String startDate,String endDate) {
		return dailyOutReportsMapper.selectSumDomesticWarehouseShipment(startDate, endDate);
	}

	@Override
	public List<DailyOutReports> selectPlatformDomesticWarehouseShipment(DailyOutReportsKey key) {
		return dailyOutReportsMapper.selectPlatformDomesticWarehouseShipment(key);
	}

	@Override
	public List<DailyOutReports> selectPlatformWarehouseShipmentCount(Date startDate, Date endDate, String platform) {
		return dailyOutReportsMapper.selectPlatformWarehouseShipmentCount(startDate, endDate, platform);
	}

	@Override
	public List<String> selectPlatforms(String platforms) {
		return dailyOutReportsMapper.selectPlatforms(platforms);
	}
}
