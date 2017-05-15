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

import com.yks.bi.dto.report.DailyOutReports;
import com.yks.bi.dto.report.DailyOutReportsKey;
import com.yks.bi.service.report.IDailyOutReportsService;

@Controller
@ResponseBody
@RequestMapping(value="/report")
public class DailyOutReportsController {
	
	@Autowired
	IDailyOutReportsService dailyOutReportsService;
	
	@RequestMapping(value="/warehouse_shipment/domesticsum",method=RequestMethod.GET)
	public List<DailyOutReports> selectSumDomesticWarehouseShipment(String startDate,String endDate){
		return dailyOutReportsService.selectSumDomesticWarehouseShipment(startDate, endDate);
	}
	
	@RequestMapping(value="/warehouse_shipment/platformsum",method=RequestMethod.GET)
	public List<DailyOutReports> selectPlatformDomesticWarehouseShipment(String date){
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
