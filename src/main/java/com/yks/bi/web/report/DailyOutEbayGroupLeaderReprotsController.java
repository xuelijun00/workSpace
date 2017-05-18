package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprots;
import com.yks.bi.dto.report.DailyOutEbayGroupLeaderReprotsKey;
import com.yks.bi.service.report.IDailyOutEbayGroupLeaderReprotsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@Controller
@ResponseBody
@RequestMapping("/report")
public class DailyOutEbayGroupLeaderReprotsController {
	
	@Autowired
	private IDailyOutEbayGroupLeaderReprotsService service;
	
	@RequestMapping(value="/daily_out_ebay_group_leader_reprots/sites",method=RequestMethod.GET)
	public List<String> selectSite() {
		return service.selectSite();
	}
	@RequestMapping(value="/daily_out_ebay_group_leader_reprots/leaders",method=RequestMethod.GET)
	public List<String> selectLeader() {
		return service.selectLeader();
	}
	
	@RequestMapping(value="/daily_out_ebay_group_leader_reprots/grid",method=RequestMethod.GET)
	public GridModel selectByCondition(DailyOutEbayGroupLeaderReprotsKey key,FilterDto filter) {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutEbayGroupLeaderReprots> list = service.selectByCondition(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/daily_out_ebay_group_leader_reprots/weekgrid",method=RequestMethod.GET)
	public GridModel selectLeaderDailyOutByWeek(DailyOutEbayGroupLeaderReprotsKey key,FilterDto filter) {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutEbayGroupLeaderReprots> list = service.selectLeaderDailyOutByWeek(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	
}
