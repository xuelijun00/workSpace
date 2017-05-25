package com.yks.bi.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailyOutSkuReprots;
import com.yks.bi.dto.report.DailySalesAccountReportsKey;
import com.yks.bi.dto.report.SalesPerformance;

public interface DailyOutSkuReprotsMapper {
    int insert(DailyOutSkuReprots record);

    int insertSelective(DailyOutSkuReprots record);
    
    
    List<DailyOutSkuReprots> selectAll(DailyOutSkuReprots key);
  
    List<String> selectPlatform();
    
    List<String> selectAccount();
    
    List<String> selectSku();


    
    
}