package com.yks.bi.dto.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DailyBuyerCountrySalesReportsKey {
	
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //转换reportDate的格式，+8个时区为中国的时区
	private Date reportDate;

    private String platform; //平台
    
    private String startDate;
    
    private String endDate;
    
   /* private Date reportDate1;
    
    public String getReportDate1() {
    	return this.getReportDate() == null?null:DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
    }*/
    

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
   
}
