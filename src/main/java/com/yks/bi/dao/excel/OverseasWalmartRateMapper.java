package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasWalmartRate;

public interface OverseasWalmartRateMapper {
    int deleteByPrimaryKey(String sku);

    int insert(OverseasWalmartRate record);

    int insertSelective(OverseasWalmartRate record);

    OverseasWalmartRate selectByPrimaryKey(String sku);
    
    void insertBatch(List<OverseasWalmartRate> record);

    int updateByPrimaryKeySelective(OverseasWalmartRate record);

    int updateByPrimaryKey(OverseasWalmartRate record);
}