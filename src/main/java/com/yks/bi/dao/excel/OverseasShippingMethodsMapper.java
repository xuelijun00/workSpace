package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasShippingMethods;

public interface OverseasShippingMethodsMapper {
    int deleteByPrimaryKey(String countryEnglish);

    int insert(OverseasShippingMethods record);

    int insertSelective(OverseasShippingMethods record);
    
    void insertBatch(List<OverseasShippingMethods> record);

    OverseasShippingMethods selectByPrimaryKey(String countryEnglish);

    int updateByPrimaryKeySelective(OverseasShippingMethods record);

    int updateByPrimaryKey(OverseasShippingMethods record);
}