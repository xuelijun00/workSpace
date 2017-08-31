package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.DailyOutSkuTop500;
import com.yks.bi.dto.report.DailyOutSkuTop500Key;

public interface DailyOutSkuTop500Mapper {

	List<DailyOutSkuTop500> selectAll(DailyOutSkuTop500Key key);
	  
    List<String> selectPlatform();
}
