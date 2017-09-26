package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailyOutSkuTop500;
import com.yks.bi.dto.report.DailyOutSkuTop500Key;

public interface IDailyOutSkuTop500Service {

	List<DailyOutSkuTop500> selectAll(DailyOutSkuTop500Key key);
	  
    List<String> selectPlatform();
    
    List<String> selectBuyerCountry(String platform);
}
