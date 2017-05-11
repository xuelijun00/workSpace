package com.yks.bi.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.dto.report.SalesPerformanceKey;

public interface SalesPerformanceMapper {
    int deleteByPrimaryKey(SalesPerformanceKey key);

    int insert(SalesPerformance record);

    int insertSelective(SalesPerformance record);

    SalesPerformance selectByPrimaryKey(SalesPerformanceKey key);

    List<SalesPerformance> selectAll(@Param("reportDate")Date platform2,@Param("business")String business);
    
    int updateByPrimaryKeySelective(SalesPerformance record);

    int updateByPrimaryKey(SalesPerformance record);
}