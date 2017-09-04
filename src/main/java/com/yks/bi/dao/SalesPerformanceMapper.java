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
	 * 用于业绩汇总的“各平台销售业绩报表”查询平台
	 * @return
	 */
	List<String> selectPlatforms(SalesPerformanceKey key);
	
	/**
	 * 用于业绩汇总的“各平台销售业绩报表”的柱状及曲线图的查询
	 * @param key
	 * @return
	 */
	List<SalesPerformance> selectAllChartSum(SalesPerformanceKey key);
	
	/**
	 * 用于业绩汇总的各平台销售业绩报表查询和导出
	 * @param key
	 * @return
	 */
	List<SalesPerformance> selectAllGridAndExport(SalesPerformanceKey key);
     
    List<String> selectnewPlatforms();
    
    /**
     * 国内仓平台
     * @return
     */
    List<String> selectDomesticPlatforms();
    
    int updateByPrimaryKeySelective(SalesPerformance record);

    int updateByPrimaryKey(SalesPerformance record);

}