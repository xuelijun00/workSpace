package com.yks.bi.dto.report;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.apache.bcel.generic.NEW;

public class DailysalesskureportsKey {
	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private Date reportDate;

    private String business;

    private String sku;
    private String reportDate1;
    
    public String getReportDate1() {
    	reportDate1 = DATEFORMAT.format(reportDate);
    	return reportDate1;
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