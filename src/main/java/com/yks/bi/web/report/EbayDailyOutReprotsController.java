package com.yks.bi.web.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.EbayDailyOutReprots;
import com.yks.bi.dto.report.EbayDailyOutReprotsKey;
import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.IEbayDailyOutReprotsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@RestController
@RequestMapping(value = "/report")
public class EbayDailyOutReprotsController {

	@Autowired
	private IEbayDailyOutReprotsService iedors;
	
	@RequestMapping(value="/ebay_profit_sum/grid",method=RequestMethod.GET)
	public GridModel profitSumGrid(EbayDailyOutReprotsKey key,FilterDto filter) throws Exception{

		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNoneEmpty(filter.getSidx()) ? filter.getSidx() + " " +filter.getSord() : "");
		
		List<EbayDailyOutReprots> list = iedors.selectProfit(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		Map<String,Object> userdata = new HashMap<String,Object>();
    	int orderNumSum = 0;
    	double productTotalCnySum = 0;
    	double profitSum = 0;
    	double netProfitMarginSum = 0;
    	for (EbayDailyOutReprots EbayDailyOutReprots : list) {
    		orderNumSum += EbayDailyOutReprots.getOrderNum();
    		productTotalCnySum += EbayDailyOutReprots.getProductTotalCny();
    		profitSum += EbayDailyOutReprots.getProfit();
		}
    	netProfitMarginSum = profitSum / productTotalCnySum;
    	userdata.put("zhuzhandian", "合计：");
    	userdata.put("orderNum", orderNumSum);
    	userdata.put("productTotalCny", productTotalCnySum);
    	userdata.put("profit", profitSum);
    	userdata.put("netProfitMargin", netProfitMarginSum);
        return new GridModel(pageInfo,userdata);
	}
	
	@RequestMapping(value="/ebay_profit_sum/chart",method=RequestMethod.GET)
	public List<EbayDailyOutReprots> profitSumChart(EbayDailyOutReprotsKey key) throws Exception{
		PageHelper.orderBy("(sum(profit) * sum(profit)) DESC");
		return iedors.selectProfit(key);
	}
	
	@RequestMapping(value="/ebay_profit_sum/zhuzhandian",method=RequestMethod.GET)
	public List<String> zhuzhandian(){
		return iedors.selectZhuzhandian();
	}
	
}
