package com.yks.bi.web.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutReports;
import com.yks.bi.dto.report.DailyOutReportsKey;
import com.yks.bi.service.report.IDailyOutReportsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@Controller
@ResponseBody
@RequestMapping(value="/report")
public class DailyOutReportsController {
	
	@Autowired
	IDailyOutReportsService dailyOutReportsService;
	
	@RequestMapping(value="/warehouse_shipment/domesticsum/grid",method=RequestMethod.GET)
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
	@RequestMapping(value="/warehouse_shipment/domesticsum/chart",method=RequestMethod.GET)
	public List<DailyOutReports> selectSumDomesticWarehouseShipmentChart(String startDate,String endDate){
		return dailyOutReportsService.selectSumDomesticWarehouseShipment(startDate, endDate);
	}
	
	@RequestMapping(value="/warehouse_shipment/platformsum/grid",method=RequestMethod.GET)
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
	@RequestMapping(value="/warehouse_shipment/platformsum/chart",method=RequestMethod.GET)
	public List<DailyOutReports> selectPlatformDomesticWarehouseShipmentChart(String date){
		DailyOutReportsKey key = new DailyOutReportsKey();
		if(StringUtils.isNotEmpty(date)){
			try {
				key.setReportDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dailyOutReportsService.selectPlatformDomesticWarehouseShipment(key);
	}

}
