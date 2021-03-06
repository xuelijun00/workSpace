package com.yks.bi.service.report;

import com.yks.bi.dto.report.ConfigPlatformGoalNew;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface ITargetCompletionRateService {
	
	List<ConfigPlatformGoalNew> selectAll(String month,String name);
	
	List<String> selectPlatform();
	
	int updateSelective(ConfigPlatformGoalNew record);
	
	List<ConfigPlatformGoalNew> selectBranchAll(String name, String startMonth,String endMonth);

}
