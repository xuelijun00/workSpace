package com.yks.bi.web.report;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.ISalespPerformanceService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/8.
 * 销售业绩整体报表
 */
@RestController
@RequestMapping("/report")
public class SalesPerformanceController {

    @Autowired
    private ISalespPerformanceService isale;
    private static final String YYYYMMDD = "yyyy-MM-dd";
    /**
     * 表格数据  柱状图
     * 销售业绩整体报表
     * @param month
     * @param platform
     * @return
     * @throws ParseException 
     * @throws UnsupportedEncodingException 
     * @throws JsonProcessingException 
     */                          
    @RequestMapping(value = "/sales_performance/grid" ,method = RequestMethod.GET)
    public GridModel dailysalesMethod(String business,String st,String et,FilterDto filter) throws Exception{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
    		filter.setSidx("report_date");
    	}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<SalesPerformance> list = isale.selectAll(business,starttime,endtime);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
    	Map<String,Object> userdata = new HashMap<String,Object>();
    	int sumOrders = 0;
    	double sumSales = 0;
    	for (SalesPerformance salesPerformance : list) {
    		sumOrders += salesPerformance.getOrders();
    		sumSales += salesPerformance.getSales();
		}
    	userdata.put("business", "合计：");
    	userdata.put("orders", sumOrders);
    	userdata.put("sales", sumSales);
        return new GridModel(pageInfo,userdata);
    }
    
    /**
     * 销售业绩整体报表
     * @param business
     * @param st
     * @param et
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sales_performance/chart" ,method = RequestMethod.GET)
    public List<SalesPerformance> chart(String business,String st,String et) throws Exception{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	return isale.selectAll(business,starttime,endtime);
    }
    
    /**
     * 表格数据  汇总
     * 销售业绩整体报表
     * @param month
     * @param platform
     * @return
     * @throws ParseException 
     * @throws UnsupportedEncodingException 
     * @throws JsonProcessingException 
     */                          
    @RequestMapping(value = "/sales_performance/gridCount" ,method = RequestMethod.GET)
    public GridModel dailysalesMethodCount(String business,String st,String et,FilterDto filter) throws Exception{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
    		filter.setSidx("report_date");
    	}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<SalesPerformance> list = isale.selectAllCount(business,starttime,endtime);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
    	Map<String,Object> userdata = new HashMap<String,Object>();
    	int sumOrders = 0;
    	double sumSales = 0;
    	for (SalesPerformance salesPerformance : list) {
    		sumOrders += salesPerformance.getOrders();
    		sumSales += salesPerformance.getSales();
		}
    	userdata.put("business", "合计：");
    	userdata.put("orders", sumOrders);
    	userdata.put("sales", sumSales);
        return new GridModel(pageInfo,userdata);
    }
    
    /**
     * 销售业绩整体报表
     * 柱状图汇总
     * @param business
     * @param st
     * @param et
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sales_performance/chartCount" ,method = RequestMethod.GET)
    public List<SalesPerformance> chartCount(String business,String st,String et) throws Exception{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	return isale.selectAllCount(business,starttime,endtime);
    }
    
    /**
     * 查询平台
     * @return
     */
    @RequestMapping(value = "/sales_performance/platforms" ,method = RequestMethod.GET)
    public List<String> platforms(String business){
        return isale.selectPlatforms(business);
    }
    
    /**
     * 查询国内仓平台
     * @return
     */
    @RequestMapping(value = "/sales_performance/domestic/platforms" ,method = RequestMethod.GET)
    public List<String> domesticPlatforms(){
        return isale.selectDomesticPlatforms();
    }
    /**
     * 新平台销售业绩
     * @param business
     * @param st
     * @param et
     * @param filter
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sales_performance/new/grid" ,method = RequestMethod.GET)
    public GridModel dailysalesnewMethod(String business,String st,String et,FilterDto filter) throws Exception{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
    		filter.setSidx("report_date");
    	}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<SalesPerformance> list = isale.selectnewAll(business,starttime,endtime);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
    }
    /**
     *  新平台销售业绩
     * @param business
     * @param st
     * @param et
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sales_performance/new/chart" ,method = RequestMethod.GET)
    public List<SalesPerformance> newchart(String business,String st,String et) throws Exception{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	return isale.selectnewAll(business,starttime,endtime);
    }
    /**
     * 新平台
     * @return
     */
    @RequestMapping(value = "/sales_performance/new/platformnew" ,method = RequestMethod.GET)
    public List<String> newplatforms(){
        return isale.selectnewPlatforms();
    }

}
