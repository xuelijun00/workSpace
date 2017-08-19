package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasUsFreight;

public interface OverseasUsFreightMapper {
    int deleteByPrimaryKey(String orderNumber);

    int insert(OverseasUsFreight record);

    int insertSelective(OverseasUsFreight record);
    
    void insertBatch(List<OverseasUsFreight> record);

    OverseasUsFreight selectByPrimaryKey(String orderNumber);

    int updateByPrimaryKeySelective(OverseasUsFreight record);

    int updateByPrimaryKey(OverseasUsFreight record);
}