package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class SalesPerformanceKey {
    private Date reportDate;
    private String reportDate1;

    public String getReportDate1() {
    	return this.getReportDate() == null?null:DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
	}

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
}