package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasSkuPrice;

public interface OverseasSkuPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OverseasSkuPrice record);

    int insertSelective(OverseasSkuPrice record);
    
    void insertBatch(List<OverseasSkuPrice> record);

    OverseasSkuPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OverseasSkuPrice record);

    int updateByPrimaryKey(OverseasSkuPrice record);
}