package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutAccountReprots;
import com.yks.bi.dto.report.DailyOutAccountReprotsKey;
import com.yks.bi.dto.report.DailyOutCategoryReports;
import com.yks.bi.dto.report.DailyOutCategoryReportsKey;
import com.yks.bi.service.report.IDailyOutCategoryReportsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@RestController
@RequestMapping(value="/report")
public class DailyOutCategoryReportsController {

	@Autowired
	private IDailyOutCategoryReportsService idocrs;
	
	@RequestMapping(value="/category_profit/grid")
	public GridModel Grid(DailyOutCategoryReportsKey key,FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailyOutCategoryReports> list = idocrs.selectAllGrid(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	@RequestMapping(value="/category_profit/chart")
	public List<DailyOutCategoryReports> Chart(DailyOutCategoryReportsKey key){

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

        return idocrs.selectAllChart(key);
	}
}
