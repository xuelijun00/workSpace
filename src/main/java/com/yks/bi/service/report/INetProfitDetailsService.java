package com.yks.bi.service.report;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailyOutSkuReprots;

public interface INetProfitDetailsService {
	
	List<DailyOutSkuReprots> selectAll(DailyOutSkuReprots key);
	
	/**
     * 查询平台
     * @return
     */
    List<String> selectPlatform();
    /**
     * 查询账号
     * @param platform
     * @return
     */
    List<String> selectAccount(String platform);
    
    List<String> selectZhuzhandian(String platform);
    
    List<DailyOutSkuReprots> selectNewPlatformAll(DailyOutSkuReprots key);
	
	/**
     * 查询新平台的平台
     * @return
     */
    List<String> selectNewPlatform();
    /**
     * 查询新平台账号
     * @param platform
     * @return
     */
    List<String> selectNewPlatformAccount(String platform);
    
    List<String> selectNewPlatformZhuzhandian(String platform);
    
    List<DailyOutSkuReprots> selectNewEggAll(DailyOutSkuReprots key);
    
    List<String> selectNewEggAccount(String platform);
    
    List<String> selectNewEggZhuzhandian(String platform);
    
    /**
     * 用于“walmart发货订单净利”页面
     * @param key
     * @return
     */
    List<DailyOutSkuReprots> selectWalmartAll(DailyOutSkuReprots key);
    
    /**
     * 用于“walmart发货订单净利”页面
     * 查询账号
     * @param business
     * @return
     */
    List<String> selectWalmartAccount();
    

}
