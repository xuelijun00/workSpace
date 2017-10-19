package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutLogisticReprotsMapper;
import com.yks.bi.dto.report.DailyOutLogisticReprots;
import com.yks.bi.dto.report.DailyOutLogisticReprotsKey;
import com.yks.bi.service.report.IDailyOutLogisticReprotsService;

@Service
public class DailyOutLogisticReprotsServiceImpl implements IDailyOutLogisticReprotsService {

	@Autowired
	DailyOutLogisticReprotsMapper dolrm;

	@Override
	public List<DailyOutLogisticReprots> selectAll(DailyOutLogisticReprotsKey key) {
		return dolrm.selectAll(key);
	}

	@Override
	public List<String> selectPlatforms() {
		return dolrm.selectPlatforms();
	}

	@Override
	public List<Integer> selectWarehouseIds() {
		return dolrm.selectWarehouseIds();
	}

	@Override
	public List<String> selectChannelNames(String platform) {
		return dolrm.selectChannelNames(platform);
	}

}
