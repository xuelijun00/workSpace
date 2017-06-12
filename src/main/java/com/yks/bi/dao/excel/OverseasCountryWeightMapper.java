package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasCountryWeight;

public interface OverseasCountryWeightMapper {
    int deleteByPrimaryKey(String countryWeight);

    int insert(OverseasCountryWeight record);

    int insertSelective(OverseasCountryWeight record);
    
    void insertBatch(List<OverseasCountryWeight> record);

    OverseasCountryWeight selectByPrimaryKey(String countryWeight);

    int updateByPrimaryKeySelective(OverseasCountryWeight record);

    int updateByPrimaryKey(OverseasCountryWeight record);
}