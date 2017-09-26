package com.yks.bi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailyOutSkuTop500;
import com.yks.bi.dto.report.DailyOutSkuTop500Key;

public interface DailyOutSkuTop500Mapper {

	List<DailyOutSkuTop500> selectAll(DailyOutSkuTop500Key key);
	  
    List<String> selectPlatform();
    
    List<String> selectBuyerCountry(@Param("platform")String platform);
}
