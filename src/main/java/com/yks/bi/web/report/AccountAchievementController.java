package com.yks.bi.web.report;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailySalesAccountReports;
import com.yks.bi.dto.report.DailySalesAccountReportsKey;
import com.yks.bi.service.report.IAccountAchievementService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@Controller
@ResponseBody
@RequestMapping("/report")
public class AccountAchievementController {
	
	@Autowired
	private IAccountAchievementService accountAchievementService;
	
	@RequestMapping(value="/account_achievement/grid")
	public GridModel selectAccountAchievementServiceGrid(DailySalesAccountReportsKey key,FilterDto filter) throws ParseException {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailySalesAccountReports> list = accountAchievementService.selectAccountAchievementService(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	@RequestMapping(value="/account_achievement/chart")
	public List<DailySalesAccountReports> selectAccountAchievementServiceChart(DailySalesAccountReportsKey key) throws ParseException {
		return accountAchievementService.selectAccountAchievementService(key);
	}
	
	@RequestMapping("/account_achievement/platform")
	public List<String> selectPlatform() {
		return accountAchievementService.selectPlatform();
	}
	
	@RequestMapping("/account_achievement/account")
	public List<String> selectAccount(String business) {
		return accountAchievementService.selectAccount(business);
	}

}
