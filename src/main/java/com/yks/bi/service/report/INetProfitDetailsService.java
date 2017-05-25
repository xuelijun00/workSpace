package com.yks.bi.service.report;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailyOutSkuReprots;
import com.yks.bi.dto.report.DailySalesAccountReports;
import com.yks.bi.dto.report.DailySalesAccountReportsKey;

public interface INetProfitDetailsService {
	
	List<DailyOutSkuReprots>selectAll(DailyOutSkuReprots key);
	
	/**
     * 查询平台
     * @return
     */
    List<String>selectPlatform();
    /**
     * 查询账号
     * @param business
     * @return
     */
    List<String>selectAccount();
    
    List<String>selectSku();

}
