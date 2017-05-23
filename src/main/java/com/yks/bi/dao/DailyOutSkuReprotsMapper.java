package com.yks.bi.dao;

import com.yks.bi.dto.report.DailyOutSkuReprots;

public interface DailyOutSkuReprotsMapper {
    int insert(DailyOutSkuReprots record);

    int insertSelective(DailyOutSkuReprots record);
}