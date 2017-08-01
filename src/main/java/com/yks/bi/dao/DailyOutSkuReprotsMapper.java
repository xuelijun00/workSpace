package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.DailyOutSkuReprots;

public interface DailyOutSkuReprotsMapper {
    int insert(DailyOutSkuReprots record);

    int insertSelective(DailyOutSkuReprots record);
    
    
    List<DailyOutSkuReprots> selectAll(DailyOutSkuReprots key);
  
    List<String> selectPlatform();
    
    List<String> selectAccount();
    
    List<String> selectSku();

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