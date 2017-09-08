package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.EbayDailyOutReprotsMapper;
import com.yks.bi.dto.report.EbayDailyOutReprots;
import com.yks.bi.dto.report.EbayDailyOutReprotsKey;
import com.yks.bi.service.report.IEbayDailyOutReprotsService;

@Service
public class EbayDailyOutReprotsServiceImpl implements IEbayDailyOutReprotsService {

	@Autowired
	private EbayDailyOutReprotsMapper edorm;
	
	@Override
	public List<EbayDailyOutReprots> selectProfit(EbayDailyOutReprotsKey key) {
		return edorm.selectProfit(key);
	}

	@Override
	public List<String> selectZhuzhandian() {
		return edorm.selectZhuzhandian();
	}

}
