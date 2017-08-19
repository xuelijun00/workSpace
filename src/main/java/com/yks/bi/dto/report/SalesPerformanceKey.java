package com.yks.bi.dto.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SalesPerformanceKey {
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date reportDate;
    
    private String startDate;
    
    private String endDate;
    
    /*private String reportDate1;

    public String getReportDate1() {
    	return this.getReportDate() == null?null:DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
	}*/

	private String business;

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}