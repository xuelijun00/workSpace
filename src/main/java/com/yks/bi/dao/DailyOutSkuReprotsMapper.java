package com.yks.bi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailyOutSkuReprots;

public interface DailyOutSkuReprotsMapper {
    int insert(DailyOutSkuReprots record);

    int insertSelective(DailyOutSkuReprots record);
    
    
    List<DailyOutSkuReprots> selectAll(DailyOutSkuReprots key);
  
    List<String> selectPlatform();
    
    List<String> selectAccount(@Param("platform")String platform);
    
    List<String> selectZhuzhandian(@Param("platform")String platform);

    /**
     * 用于sku净利明细页面的柱状及曲线图的查询
     * @param key
     * @return
     */
    List<DailyOutSkuReprots> selectProfit(DailyOutSkuReprots key);
    
    List<DailyOutSkuReprots> selectNewPlatformAll(DailyOutSkuReprots key);
    
    List<DailyOutSkuReprots> selectNewPlatformProfit(DailyOutSkuReprots key);
    
    List<String> selectNewPlatform();
    
    List<String> selectNewPlatformAccount(@Param("platform")String platform);
    
    List<String> selectNewPlatformZhuzhandian(@Param("platform")String platform);
 
    List<DailyOutSkuReprots> selectNewEggAll(DailyOutSkuReprots key);
    
    List<DailyOutSkuReprots> selectNewEggProfit(DailyOutSkuReprots key);

    List<String> selectNewEggAccount(@Param("platform")String platform);
    
    List<String> selectNewEggZhuzhandian(@Param("platform")String platform);
    
    /**
     * 用于“walmart发货订单净利”页面
     * @param key
     * @return
     */
    List<DailyOutSkuReprots> selectWalmartAll(DailyOutSkuReprots key);
    
    List<DailyOutSkuReprots> selectWalmartProfit(DailyOutSkuReprots key);
    
    /**
     * 用于“walmart发货订单净利”页面
     * 查询账号
     * @param business
     * @return
     */
    List<String> selectWalmartAccount();
    
     
}