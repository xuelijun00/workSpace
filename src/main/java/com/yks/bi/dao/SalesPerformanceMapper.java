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

    List<SalesPerformance> selectAll(@Param("business")String business,@Param("start_date")Date start_date,@Param("end_date")Date end_date);
    /**
     * 查询所有平台
     * @return
     */
    List<String> selectPlatforms();
    
    int updateByPrimaryKeySelective(SalesPerformance record);

    int updateByPrimaryKey(SalesPerformance record);

	

	
}