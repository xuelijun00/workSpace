package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.DailyOutEbayGroupLeaderReprotsMapper;
import com.yks.bi.dao.EbayDailyOutZhiYouReprotsMapper;
import com.yks.bi.dao.EbayDailyOutZhuanXianReprotsMapper;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprots;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprotsKey;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprots;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprotsKey;
import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprots;
import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprotsKey;
import com.yks.bi.service.report.IDailyOutEbayGroupLeaderReprotsService;

@Service
public class DailyOutEbayGroupLeaderReprotsServiceImpl implements IDailyOutEbayGroupLeaderReprotsService {

	@Autowired
	private DailyOutEbayGroupLeaderReprotsMapper mapper;
	
	@Autowired
	private EbayDailyOutZhuanXianReprotsMapper greenLineMapper;
	
	@Autowired
	private EbayDailyOutZhiYouReprotsMapper directMailMapper;
	
	@Override
	public List<String> selectSite() {
		return mapper.selectSite();
	}

	@Override
	public List<String> selectLeader() {
		return mapper.selectLeader();
	}

	@Override
	public List<DailyOutEbayGroupLeaderReprots> selectByCondition(DailyOutEbayGroupLeaderReprotsKey key) {
		return mapper.selectByCondition(key);
	}

	@Override
	public List<DailyOutEbayGroupLeaderReprots> selectLeaderDailyOutByWeek(DailyOutEbayGroupLeaderReprotsKey key) {
		return mapper.selectLeaderDailyOutByWeek(key);
	}
	/**
	 * ebay站点发货专线
	 */
	@Override
	public List<EbayDailyOutZhuanXianReprots> selectGreenLine(EbayDailyOutZhuanXianReprotsKey key) {
		return greenLineMapper.selectByPrimaryKey(key);
	}
	/**
	 * ebay专线通道
	 */
	@Override
	public List<String> selectChannel() {
		return greenLineMapper.selectChannel();
	}
	/**
	 * ebay发货直邮
	 */
	@Override
	public List<EbayDailyOutZhiYouReprots> selectDirectMail(EbayDailyOutZhiYouReprotsKey key) {
		return directMailMapper.selectByPrimaryKey(key);
	}
	/**
	 * ebay直邮发货站点
	 */
	@Override
	public List<String> selectDirectMailSite() {
		return directMailMapper.selectDirectMailSite();
	}

}
