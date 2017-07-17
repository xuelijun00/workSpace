package com.yks.bi.web.report;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutReports;
import com.yks.bi.dto.report.DailyOutReportsKey;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprots;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprotsKey;
import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.IDailyOutReportsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

/**
 * 各平台
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value="/report")
public class DailyOutReportsController {
	
	@Autowired
	IDailyOutReportsService dailyOutReportsService;
	private static final String YYYYMMDD = "yyyy-MM-dd";
	
	@RequestMapping(value="/daily_out_report/domesticsum/grid",method=RequestMethod.GET)
	public GridModel selectSumDomesticWarehouseShipment(String startDate,String endDate,FilterDto filter){
		if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
    		filter.setSidx("report_date");
    	}
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutReports> list = dailyOutReportsService.selectSumDomesticWarehouseShipment(startDate, endDate);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	@RequestMapping(value="/daily_out_report/domesticsum/chart",method=RequestMethod.GET)
	public List<DailyOutReports> selectSumDomesticWarehouseShipmentChart(String startDate,String endDate){
		return dailyOutReportsService.selectSumDomesticWarehouseShipment(startDate, endDate);
	}
	
	@RequestMapping(value="/daily_out_report/platformsum/grid",method=RequestMethod.GET)
	public GridModel selectPlatformDomesticWarehouseShipment(String date,FilterDto filter){
		DailyOutReportsKey key = new DailyOutReportsKey();
		if(StringUtils.isNotEmpty(date)){
			try {
				key.setReportDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
    		filter.setSidx("report_date");
    	}
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutReports> list = dailyOutReportsService.selectPlatformDomesticWarehouseShipment(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	@RequestMapping(value="/daily_out_report/platformsum/chart",method=RequestMethod.GET)
	public List<DailyOutReports> selectPlatformDomesticWarehouseShipmentChart(String date){
		DailyOutReportsKey key = new DailyOutReportsKey();
		if(StringUtils.isNotEmpty(date)){
			try {
				key.setReportDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		PageHelper.orderBy("net_profit desc");
		return dailyOutReportsService.selectPlatformDomesticWarehouseShipment(key);
	}
	
	 /**
     * 表格数据 
     * 各平台发货汇总数据报表
     * @param reportDate
     * @param platform
     * @return
     * @throws Exception 
     */   
	 @RequestMapping(value = "/daily_out_report/platformCount/grid" ,method = RequestMethod.GET)
	    public GridModel selectPlatformWarehouseShipmentCountGrid(String st,String et,String platform,FilterDto filter) throws Exception{
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
	    	List<DailyOutReports> list = dailyOutReportsService.selectPlatformWarehouseShipmentCount(starttime, endtime, platform);
	    	PageInfo<?> pageInfo = new PageInfo<>(list);
	    	
	        return new GridModel(pageInfo);
	    }
	
	/**
	 * 柱状图
	 * 各平台发货汇总数据报表
	 * @param reportDate
	 * @param platform
	 * @return
	 * @throws Exception 
	 */   
	 @RequestMapping(value = "/daily_out_report/platformCount/chart" ,method = RequestMethod.GET)
	    public List<DailyOutReports> selectPlatformWarehouseShipmentCountChart(String st,String et,String platform) throws Exception{
	    	Date starttime = null;
	    	if(StringUtils.isNotEmpty(st)){
	    		starttime = DateUtils.parseDate(st, YYYYMMDD);
	    	}
	    	Date endtime = null;
	    	if(StringUtils.isNotEmpty(et)){
	    		endtime = DateUtils.parseDate(et, YYYYMMDD);
	    	}
	    	PageHelper.orderBy("report_date desc");
	        return dailyOutReportsService.selectPlatformWarehouseShipmentCount(starttime, endtime, platform);
	    }
	 
 	/**
     * 查询平台
     * @return
     */
    @RequestMapping(value = "/daily_out_report/platforms" ,method = RequestMethod.GET)
    public List<String> platforms(String platforms){
        return dailyOutReportsService.selectPlatforms(platforms);
    }
	 
	@RequestMapping("/daily_out_report/each_platform/grid")
	public GridModel directMail(DailyOutReportsKey key, FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutReports> list = dailyOutReportsService.selectByTimesAndPlatform(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
    	return new GridModel(pageInfo);
	}
	
}
