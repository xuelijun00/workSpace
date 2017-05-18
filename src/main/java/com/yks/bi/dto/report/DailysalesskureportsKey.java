package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DailysalesskureportsKey {
    private Date reportDate;

    private String business;

    private String sku;
    private String reportDate1;
    
    public String getReportDate1() {
    	return this.getReportDate() == null?null:DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
	}
    
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }
}