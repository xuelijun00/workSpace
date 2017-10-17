package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.Dailyoutaccountreprots_overseaMapper;
import com.yks.bi.dto.report.Dailyoutaccountreprots_oversea;
import com.yks.bi.dto.report.Dailyoutaccountreprots_overseaKey;
import com.yks.bi.service.report.IDailyoutaccountreprots_overseaService;

@Service
public class Dailyoutaccountreprots_overseaServiceImpl implements IDailyoutaccountreprots_overseaService{

	@Autowired
	private Dailyoutaccountreprots_overseaMapper doarom;

	@Override
	public List<Dailyoutaccountreprots_oversea> selectAll(Dailyoutaccountreprots_overseaKey key) {
		return doarom.selectAll(key);
	}

	@Override
	public List<String> selectSalesAccounts(String platform) {
		return doarom.selectSalesAccounts(platform);
	}

	@Override
	public List<String> selectWarehouseType(String platform) {
		return doarom.selectWarehouseType(platform);
	}

	@Override
	public List<String> selectWarehouseName(Dailyoutaccountreprots_overseaKey key) {
		return doarom.selectWarehouseName(key);
	}

	@Override
	public List<Dailyoutaccountreprots_oversea> selectNewPlatformAll(Dailyoutaccountreprots_overseaKey key) {
		return doarom.selectNewPlatformAll(key);
	}

	@Override
	public List<String> selectNewPlatforms() {
		return doarom.selectNewPlatforms();
	}

	@Override
	public List<String> selectNewPlatformSalesAccounts(String platform) {
		return doarom.selectNewPlatformSalesAccounts(platform);
	}

	@Override
	public List<String> selectNewPlatformWarehouseType(String platform) {
		return doarom.selectNewPlatformWarehouseType(platform);
	}

	@Override
	public List<String> selectNewPlatformWarehouseName(Dailyoutaccountreprots_overseaKey key) {
		return doarom.selectNewPlatformWarehouseName(key);
	}

}
