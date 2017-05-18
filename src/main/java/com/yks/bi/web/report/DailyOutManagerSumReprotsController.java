package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutManagerSumReprots;
import com.yks.bi.dto.report.DailyOutManagerSumReprotsKey;
import com.yks.bi.service.report.IDailyOutManagerSumReprotsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@Controller
@ResponseBody
@RequestMapping("/report")
public class DailyOutManagerSumReprotsController {
	
	@Autowired
	private IDailyOutManagerSumReprotsService dailyOutManagerSumReprotsService;
	
	/**
	 * 查询所有账号管理者
	 * @return
	 */
	@RequestMapping(value="/daily_out_manager_sum/managers")
	public List<String> selectManagers(){
		return dailyOutManagerSumReprotsService.selectManagers();
	}
	/**
	 * 平台
	 * @return
	 */
	@RequestMapping(value="/daily_out_manager_sum/platforms")
	public List<String> selectPlatform(){
		return dailyOutManagerSumReprotsService.selectPlatform();
	}
	
	@RequestMapping(value="/daily_out_manager_sum/grid")
	public GridModel selectByCondition(DailyOutManagerSumReprotsKey key,FilterDto filter){
		if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
    		filter.setSidx("report_date");
    	}
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutManagerSumReprots> list = dailyOutManagerSumReprotsService.selectByCondition(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/daily_out_manager_sum/weekgrid")
	public GridModel selectManagerAchievementByWeek(DailyOutManagerSumReprotsKey key,FilterDto filter){
		if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("start_date")){
			filter.setSidx("startDate");
		}
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutManagerSumReprots> list = dailyOutManagerSumReprotsService.selectManagerAchievementByWeek(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

}
