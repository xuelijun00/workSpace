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


    
    
}