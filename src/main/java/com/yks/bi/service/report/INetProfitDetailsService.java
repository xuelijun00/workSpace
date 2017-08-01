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
    
    
    /**
     * 用于“walmart发货订单净利”页面
     * @param key
     * @return
     */
    List<DailyOutSkuReprots>selectWalmartAll(DailyOutSkuReprots key);
    
    /**
     * 用于“walmart发货订单净利”页面
     * 查询账号
     * @param business
     * @return
     */
    List<String>selectWalmartAccount();
    

}
