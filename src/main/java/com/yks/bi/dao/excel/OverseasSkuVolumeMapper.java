package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasSkuVolume;

public interface OverseasSkuVolumeMapper {
    int deleteByPrimaryKey(String sku);

    int insert(OverseasSkuVolume record);

    int insertSelective(OverseasSkuVolume record);
    
    void insertBatch(List<OverseasSkuVolume> record);

    OverseasSkuVolume selectByPrimaryKey(String sku);

    int updateByPrimaryKeySelective(OverseasSkuVolume record);

    int updateByPrimaryKey(OverseasSkuVolume record);
}