package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.EbayDailyOutZhiYouReprots;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprotsKey;

public interface EbayDailyOutZhiYouReprotsMapper {
    int deleteByPrimaryKey(EbayDailyOutZhiYouReprotsKey key);

    int insert(EbayDailyOutZhiYouReprots record);

    int insertSelective(EbayDailyOutZhiYouReprots record);
    /**
     * ebay发货直邮报表
     * @param key
     * @return
     */
    List<EbayDailyOutZhiYouReprots> selectByPrimaryKey(EbayDailyOutZhiYouReprotsKey key);

    int updateByPrimaryKeySelective(EbayDailyOutZhiYouReprots record);

    int updateByPrimaryKey(EbayDailyOutZhiYouReprots record);
	/**
	 * ebay发货直邮站点
	 * @return
	 */
	List<String> selectDirectMailSite();
}