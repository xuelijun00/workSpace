package com.yks.bi.service.report;

import java.util.List;


import com.yks.bi.dto.report.DailyOutSkuReprots;

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
