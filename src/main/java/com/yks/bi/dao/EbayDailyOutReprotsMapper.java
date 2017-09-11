package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.EbayDailyOutReprots;
import com.yks.bi.dto.report.EbayDailyOutReprotsKey;

public interface EbayDailyOutReprotsMapper {

	List<EbayDailyOutReprots> selectProfit(EbayDailyOutReprotsKey key);
	
	List<String> selectZhuzhandian();
}
