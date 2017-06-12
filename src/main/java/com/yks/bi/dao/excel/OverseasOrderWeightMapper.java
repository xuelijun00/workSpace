package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasOrderWeight;

public interface OverseasOrderWeightMapper {
    int deleteByPrimaryKey(String orderNumber);

    int insert(OverseasOrderWeight record);

    int insertSelective(OverseasOrderWeight record);
    
    void insertBatch(List<OverseasOrderWeight> record);

    OverseasOrderWeight selectByPrimaryKey(String orderNumber);

    int updateByPrimaryKeySelective(OverseasOrderWeight record);

    int updateByPrimaryKey(OverseasOrderWeight record);
}