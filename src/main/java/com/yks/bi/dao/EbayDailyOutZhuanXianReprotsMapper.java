package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprots;
import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprotsKey;

public interface EbayDailyOutZhuanXianReprotsMapper {
    int deleteByPrimaryKey(EbayDailyOutZhuanXianReprotsKey key);

    int insert(EbayDailyOutZhuanXianReprots record);

    int insertSelective(EbayDailyOutZhuanXianReprots record);
    /**
     * 查询ebay专线发货报表数据
     * @param key
     * @return
     */
    List<EbayDailyOutZhuanXianReprots> selectByPrimaryKey(EbayDailyOutZhuanXianReprotsKey key);

    int updateByPrimaryKeySelective(EbayDailyOutZhuanXianReprots record);

    int updateByPrimaryKey(EbayDailyOutZhuanXianReprots record);
    /**
     * 查询物流通道
     * @return
     */
    List<String> selectChannel();
}