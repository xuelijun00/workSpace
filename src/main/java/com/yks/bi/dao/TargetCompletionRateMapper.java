package com.yks.bi.dao;

import com.yks.bi.dto.report.TargetCompletionRate;

public interface TargetCompletionRateMapper {

    int deleteByPrimaryKey(String platform);

    int insert(TargetCompletionRate record);

    int insertSelective(TargetCompletionRate record);

    TargetCompletionRate selectByPrimaryKey(String platform);

    int updateByPrimaryKeySelective(TargetCompletionRate record);

    int updateByPrimaryKey(TargetCompletionRate record);
}