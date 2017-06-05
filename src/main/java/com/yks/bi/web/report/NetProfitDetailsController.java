package com.yks.bi.web.report;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutSkuReprots;
import com.yks.bi.service.report.INetProfitDetailsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class NetProfitDetailsController {
	
	@Autowired
	private INetProfitDetailsService NetProfit;
	
	@RequestMapping(value="/profit_details/grid")
	public GridModel selectAccountAchievementServiceGrid(DailyOutSkuReprots key,FilterDto filter) throws ParseException {
		if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutSkuReprots> list = NetProfit.selectAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	
	@RequestMapping("/profit_details/platform")
	public List<String> selectPlatform() {
		return NetProfit.selectPlatform();
	}
	
	@RequestMapping("/profit_details/account")
	public List<String> selectAccount() {
		return NetProfit.selectAccount();
	}
	
	@RequestMapping("/profit_details/sku")
	public List<String> selectSku() {
		return NetProfit.selectSku();
	}
	

}
