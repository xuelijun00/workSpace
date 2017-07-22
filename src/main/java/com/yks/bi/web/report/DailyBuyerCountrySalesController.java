package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyBuyerCountrySalesReports;
import com.yks.bi.dto.report.DailyBuyerCountrySalesReportsKey;
import com.yks.bi.service.report.IDailyBuyerCountrySalesService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@RestController
@RequestMapping("/report")
public class DailyBuyerCountrySalesController {

	@Autowired
	private IDailyBuyerCountrySalesService idbcss;
	
	/**
     * 表格数据
     * 各国买家国家数据报表
     * @param key
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/dailyBuyerCountrySales/grid" ,method = RequestMethod.GET)
    public GridModel dailyBuyerCountrySalesMethod(DailyBuyerCountrySalesReportsKey key, FilterDto filter) throws Exception{
    	/*if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
    		filter.setSidx("report_date");
    	}*/
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyBuyerCountrySalesReports> list = idbcss.selectByPrimaryKey(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
    }
    
    @RequestMapping(value = "/dailyBuyerCountrySales/newPlatform/grid" ,method = RequestMethod.GET)
    public GridModel dailyBuyerCountrySalesNewPlatformMethod(DailyBuyerCountrySalesReportsKey key, FilterDto filter) throws Exception{
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyBuyerCountrySalesReports> list = idbcss.selectNewPlatformAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
    }
    
    /**
     * 新平台
     * @return
     */
    @RequestMapping(value = "/dailyBuyerCountrySales/newPlatform" ,method = RequestMethod.GET)
    public List<String> newplatforms(){
        return idbcss.selectNewPlatforms();
    }
    
    /**
     * 查询买家国家
     * @return
     */
    @RequestMapping(value = "/dailyBuyerCountrySales/buyerCountry" ,method = RequestMethod.GET)
    public List<String> buyerCountry(DailyBuyerCountrySalesReportsKey key){
        return idbcss.selectBuyerCountry(key);    
    }
    
    /**
     * 查询新平台买家国家
     * @return
     */
    @RequestMapping(value = "/dailyBuyerCountrySales/newPlatform/buyerCountry" ,method = RequestMethod.GET)
    public List<String> newPlamformbuyerCountry(DailyBuyerCountrySalesReportsKey key){
        return idbcss.selectNewPlatformBuyerCountry(key);
    }
}
