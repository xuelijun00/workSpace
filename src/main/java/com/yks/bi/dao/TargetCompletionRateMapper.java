package com.yks.bi.dao;

import com.yks.bi.dto.report.TargetCompletionRate;
import com.yks.bi.dto.report.TargetCompletionRateVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TargetCompletionRateMapper {

    int deleteByPrimaryKey(String platform);

    int insert(TargetCompletionRate record);

    int insertSelective(TargetCompletionRate record);

    List<TargetCompletionRate> selectByPrimaryKey(@Param("platform")String platform);

    /**
     * 查询所有数据
     * @return
     */
    List<TargetCompletionRateVo> selectAll(@Param("month") String month,@Param("platform") String platform);

    int updateByPrimaryKeySelective(TargetCompletionRate record);

    int updateByPrimaryKey(TargetCompletionRate record);
}