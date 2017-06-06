package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprots;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprotsKey;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprots;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprotsKey;
import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprots;
import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprotsKey;
import com.yks.bi.service.report.IDailyOutEbayGroupLeaderReprotsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

/**
 * 各平台各账号管理员业绩
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/report")
public class DailyOutEbayGroupLeaderReprotsController {
	
	@Autowired
	private IDailyOutEbayGroupLeaderReprotsService service;
	
	/**
	 * 查询站点
	 * @return
	 */
	@RequestMapping(value="/daily_out_ebay_group_leader_reprots/sites",method=RequestMethod.GET)
	public List<String> selectSite() {
		return service.selectSite();
	}
	/**
	 * 查询账号管理员
	 * @return
	 */
	@RequestMapping(value="/daily_out_ebay_group_leader_reprots/leaders",method=RequestMethod.GET)
	public List<String> selectLeader() {
		return service.selectLeader();
	}
	
	/**
	 * Ebay组长站点发货业绩
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping(value="/daily_out_ebay_group_leader_reprots/grid",method=RequestMethod.GET)
	public GridModel selectByCondition(DailyOutEbayGroupLeaderReprotsKey key,FilterDto filter) {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutEbayGroupLeaderReprots> list = service.selectByCondition(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	/**
	 * Ebay组长站点发货业绩
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping(value="/daily_out_ebay_group_leader_reprots/weekgrid",method=RequestMethod.GET)
	public GridModel selectLeaderDailyOutByWeek(DailyOutEbayGroupLeaderReprotsKey key,FilterDto filter) {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutEbayGroupLeaderReprots> list = service.selectLeaderDailyOutByWeek(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	
	/**
	 * ebay站点发货专线
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping("/green_line/grid")
	public GridModel greenLineGrid(EbayDailyOutZhuanXianReprotsKey key, FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<EbayDailyOutZhuanXianReprots> list = service.selectGreenLine(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
    	return new GridModel(pageInfo);
	}
	/**
	 * ebay站点发货专线 通道
	 * @return
	 */
	@RequestMapping("/green_line/channel")
	public List<String> selectChannel() {
		return service.selectChannel();
	}
	
	/**
	 * ebay站点发货直邮
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping("/direct_mail/grid")
	public GridModel directMail(EbayDailyOutZhiYouReprotsKey key, FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<EbayDailyOutZhiYouReprots> list = service.selectDirectMail(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
    	return new GridModel(pageInfo);
	}
	/**
	 * ebay直邮发货站点
	 * @return
	 */
	@RequestMapping("/direct_mail/site")
	public List<String> selectDirectMailSite() {
		return service.selectDirectMailSite();
	}
	
}
