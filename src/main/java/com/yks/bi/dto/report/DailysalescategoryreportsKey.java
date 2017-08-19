package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DailysalescategoryreportsKey {
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date reportDate;

    private String business;

    private String category;

    private String startDate;
    
    private String endDate;
    
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
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