package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.dto.report.SalesPerformanceKey;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface ISalespPerformanceService {
	
	 /**
     *  销售业绩整体报表 
     */
	List<SalesPerformance> selectAll(SalesPerformanceKey key);
	
	List<SalesPerformance> selectnewAll(SalesPerformanceKey key);
	
	//查询数据并汇总
	List<SalesPerformance> selectAllCount(SalesPerformanceKey key);
	/**
	 * 查询平台
	 * @return
	 */
	List<String> selectPlatforms(SalesPerformanceKey key);
	
	List<String> selectnewPlatforms();
	
	/**
     * 国内仓平台
     * @return
     */
    List<String> selectDomesticPlatforms();

}
