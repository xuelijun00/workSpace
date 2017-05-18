package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DailySalesAccountReportsKey {
	
	private Date reportDate;

    private String business;

    private String account;
    
    private String startDate;
    private String endDate;
    
    public DailySalesAccountReportsKey(){}

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
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