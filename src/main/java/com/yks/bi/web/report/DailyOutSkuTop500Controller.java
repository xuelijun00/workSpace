package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutSkuTop500;
import com.yks.bi.dto.report.DailyOutSkuTop500Key;
import com.yks.bi.service.report.IDailyOutSkuTop500Service;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@RestController
@RequestMapping(value="/report")
public class DailyOutSkuTop500Controller {

	@Autowired
	private IDailyOutSkuTop500Service idosts;
	
	@RequestMapping(value="/sku_top/grid")
	public GridModel selectAllGrid(DailyOutSkuTop500Key key, FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNoneEmpty(filter.getSidx()) ? filter.getSidx() + " " +filter.getSord() : "");
		List<DailyOutSkuTop500> list = idosts.selectAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/sku_top/platform")
	public List<String> platform(){
		return idosts.selectPlatform();
	}
}
