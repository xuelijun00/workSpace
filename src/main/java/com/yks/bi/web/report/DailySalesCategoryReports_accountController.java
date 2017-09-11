package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailySalesCategoryReports_account;
import com.yks.bi.dto.report.DailySalesCategoryReports_accountKey;
import com.yks.bi.service.report.IDailySalesCategoryReports_accountService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@RestController
@RequestMapping(value="/report")
public class DailySalesCategoryReports_accountController {

	@Autowired
	private IDailySalesCategoryReports_accountService idscras;
	
	@RequestMapping(value="/daily_sales_category_account/smt/category", method=RequestMethod.GET)
	public List<String> smtCategory(){
		return idscras.selectSmtCategory();
	}

	@RequestMapping(value="/daily_sales_category_account/smt/categorySupervisor", method=RequestMethod.GET)
	public List<String> smtCategorySupervisor(){
		return idscras.selectSmtCategorySupervisor();
	}
	
	@RequestMapping(value="/daily_sales_category_account/smt/account", method=RequestMethod.GET)
	public List<String> smtAccount(){
		return idscras.selectSmtAccount();
	}
	
	@RequestMapping(value="/daily_sales_category_account/smt/grid", method=RequestMethod.GET)
	public GridModel smtGrid(DailySalesCategoryReports_accountKey key, FilterDto filter){
		
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx()) ? filter.getSidx() + " " + filter.getSord() : "");
		
		List<DailySalesCategoryReports_account> list = idscras.selectSmtAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}
}
