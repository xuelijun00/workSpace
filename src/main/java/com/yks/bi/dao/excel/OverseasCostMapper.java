package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasCost;

public interface OverseasCostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OverseasCost record);

    int insertSelective(OverseasCost record);
    
    void insertBatch(List<OverseasCost> record);

    OverseasCost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OverseasCost record);

    int updateByPrimaryKey(OverseasCost record);
}