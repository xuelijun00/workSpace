package com.yks.bi.service.report.impl;

import com.yks.bi.dao.ConfigPlatformGoalNewMapper;
import com.yks.bi.dto.report.ConfigPlatformGoalNew;
import com.yks.bi.service.report.ITargetCompletionRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
@Service
public class TargetCompletionRateServiceImpl implements ITargetCompletionRateService {

    @Autowired
    private ConfigPlatformGoalNewMapper configPlatformGoalNewMapper;
    /**
     * 表格数据
     */
    @Override
    public List<ConfigPlatformGoalNew> selectAll(String month, String name) {
        return configPlatformGoalNewMapper.selectByPrimaryKey(month,name);
    }
    
	@Override
	public List<String> selectPlatform() {
		return configPlatformGoalNewMapper.selectPlatform();
	}
	@Override
	public int updateSelective(ConfigPlatformGoalNew record) {
		return configPlatformGoalNewMapper.updateByPrimaryKeySelective(record);
	}
}
