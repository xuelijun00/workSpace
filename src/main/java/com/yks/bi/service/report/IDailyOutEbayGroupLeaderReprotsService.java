package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprots;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprotsKey;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprots;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprotsKey;
import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprots;
import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprotsKey;

public interface IDailyOutEbayGroupLeaderReprotsService {
	
	List<String> selectSite();//站点
    
    List<String> selectLeader();//组长
    /**
     * eBay站点发货业绩
     * @param key
     * @return
     */
    List<DailyOutEbayGroupLeaderReprots> selectByCondition(DailyOutEbayGroupLeaderReprotsKey key);
    /**
     * 组长每周成绩
     * @param key
     * @return
     */
    List<DailyOutEbayGroupLeaderReprots> selectLeaderDailyOutByWeek(DailyOutEbayGroupLeaderReprotsKey key);
    /**
     * ebay站点发货专线
     * @param key
     * @return
     */
	List<EbayDailyOutZhuanXianReprots> selectGreenLine(EbayDailyOutZhuanXianReprotsKey key);
	/**
	 * ebay专线通道
	 * @return
	 */
	List<String> selectChannel();
	/**
	 * ebay直邮
	 * @param key
	 * @return
	 */
	List<EbayDailyOutZhiYouReprots> selectDirectMail(EbayDailyOutZhiYouReprotsKey key);
	/**
	 * ebay直邮站点
	 * @return
	 */
	List<String> selectDirectMailSite();

}
