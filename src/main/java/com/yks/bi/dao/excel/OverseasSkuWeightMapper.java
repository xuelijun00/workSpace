package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasSkuWeight;

public interface OverseasSkuWeightMapper {
    int deleteByPrimaryKey(String sku);

    int insert(OverseasSkuWeight record);

    int insertSelective(OverseasSkuWeight record);
    
    void insertBatch(List<OverseasSkuWeight> record);

    OverseasSkuWeight selectByPrimaryKey(String sku);

    int updateByPrimaryKeySelective(OverseasSkuWeight record);

    int updateByPrimaryKey(OverseasSkuWeight record);
}