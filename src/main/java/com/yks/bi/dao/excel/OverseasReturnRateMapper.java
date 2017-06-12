package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasReturnRate;

public interface OverseasReturnRateMapper {
    int deleteByPrimaryKey(String sku);

    int insert(OverseasReturnRate record);

    int insertSelective(OverseasReturnRate record);
    
    void insertBatch(List<OverseasReturnRate> record);

    OverseasReturnRate selectByPrimaryKey(String sku);

    int updateByPrimaryKeySelective(OverseasReturnRate record);

    int updateByPrimaryKey(OverseasReturnRate record);
}