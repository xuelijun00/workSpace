package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasCountryRate;

public interface OverseasCountryRateMapper {
    int deleteByPrimaryKey(String countryAbbreviation);

    int insert(OverseasCountryRate record);

    int insertSelective(OverseasCountryRate record);
    
    void insertBatch(List<OverseasCountryRate> record);

    OverseasCountryRate selectByPrimaryKey(String countryAbbreviation);

    int updateByPrimaryKeySelective(OverseasCountryRate record);

    int updateByPrimaryKey(OverseasCountryRate record);
}