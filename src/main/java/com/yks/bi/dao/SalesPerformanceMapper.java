package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.dto.report.SalesPerformanceKey;

public interface SalesPerformanceMapper {
	
    int deleteByPrimaryKey(SalesPerformanceKey key);

    int insert(SalesPerformance record);

    int insertSelective(SalesPerformance record);

    SalesPerformance selectByPrimaryKey(SalesPerformanceKey key);

    List<SalesPerformance> selectnewAll(SalesPerformanceKey key);
    
    List<SalesPerformance> selectAll(SalesPerformanceKey key);
    
    List<SalesPerformance> selectnewAllSum(SalesPerformanceKey key);
    
    /**
     * 查询数据并汇总
     * @return
     */
    List<SalesPerformance> selectAllCount(SalesPerformanceKey key);
   
    /**
     * 查询所有平台
     * @return
     */
    List<String> selectPlatforms(SalesPerformanceKey key);
     
    List<String> selectnewPlatforms();
    
    /**
     * 国内仓平台
     * @return
     */
    List<String> selectDomesticPlatforms();
    
    int updateByPrimaryKeySelective(SalesPerformance record);

    int updateByPrimaryKey(SalesPerformance record);

}