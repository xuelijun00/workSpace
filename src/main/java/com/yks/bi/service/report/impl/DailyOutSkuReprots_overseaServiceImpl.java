package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutSkuReprots_overseaMapper;
import com.yks.bi.dto.report.DailyOutSkuReprots_oversea;
import com.yks.bi.dto.report.DailyOutSkuReprots_overseaKey;
import com.yks.bi.service.report.IDailyOutSkuReprots_overseaService;

@Service
public class DailyOutSkuReprots_overseaServiceImpl implements IDailyOutSkuReprots_overseaService{

	@Autowired
	private DailyOutSkuReprots_overseaMapper dosrom;

	@Override
	public List<DailyOutSkuReprots_oversea> selectAll(DailyOutSkuReprots_overseaKey key) {
		return dosrom.selectAll(key);
	}

	@Override
	public List<String> selectPlatforms() {
		return dosrom.selectPlatforms();
	}

	@Override
	public List<String> selectSalesAccounts(String platform) {
		return dosrom.selectSalesAccounts(platform);
	}

	@Override
	public List<String> selectWarehouseTypes(String platform) {
		return dosrom.selectWarehouseTypes(platform);
	}

	@Override
	public List<String> selectWarehouseNames(DailyOutSkuReprots_overseaKey key) {
		return dosrom.selectWarehouseNames(key);
	}

}
