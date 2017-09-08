package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.EbayDailyOutReprots;
import com.yks.bi.dto.report.EbayDailyOutReprotsKey;

public interface IEbayDailyOutReprotsService {

	List<EbayDailyOutReprots> selectProfit(EbayDailyOutReprotsKey key);
	
	List<String> selectZhuzhandian();
}
