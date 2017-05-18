package com.yks.bi.service.report;

import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.dao.TargetCompletionRateMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface ISalespPerformanceService {
	
	 /**
     *  销售业绩整体报表 
     */
	List<SalesPerformance> selectAll(String business,Date st,Date et);
	
	List<SalesPerformance> selectnewAll(String business,Date st,Date et);
	/**
	 * 查询平台
	 * @return
	 */
	List<String> selectPlatforms();
	
	List<String> selectnewPlatforms();

}
