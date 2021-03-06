package com.yks.bi.web.report;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailySalesAccountReports;
import com.yks.bi.dto.report.DailySalesAccountReportsKey;
import com.yks.bi.service.report.IAccountAchievementService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;
import org.springframework.web.bind.annotation.RestController;

/**
 * 各平台各账号业绩 报表
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/report")
public class AccountAchievementController {
	
	@Autowired
	private IAccountAchievementService accountAchievementService;
	
	/**
	 * 各平台各账号业绩 表格
	 * @param key
	 * @param filter
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/account_achievement/grid")
	public GridModel selectAccountAchievementServiceGrid(DailySalesAccountReportsKey key,FilterDto filter) throws ParseException {
		if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailySalesAccountReports> list = accountAchievementService.selectAccountAchievementService(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	
	/**
	 * 各平台各账号业绩 曲线图
	 * @param key
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/account_achievement/chart")
	public List<DailySalesAccountReports> selectAccountAchievementServiceChart(DailySalesAccountReportsKey key) throws ParseException {
		return accountAchievementService.selectAccountSum(key);
	}
	/**
	 * 查询平台
	 * @return
	 */
	@RequestMapping("/account_achievement/platform")
	public List<String> selectPlatform() {
		return accountAchievementService.selectPlatform();
	}
	
	/**
	 * 查询账号
	 * @param business
	 * @return
	 */
	@RequestMapping("/account_achievement/account")
	public List<String> selectAccount(String business) {
		return accountAchievementService.selectAccount(business);
	}

}
