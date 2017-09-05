package com.yks.bi.dto.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DailySalesSkuReports_RecycleKey {

    private String recycleDate;      //环比增长日期

    private String business;         //业务线

    private String sku;              //sku
    
    private String skuOld;           //原始sku
    
    private String startDate;        //开始时间
    
    private String endDate;          //结束时间
    
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date reportDate;         //日期

	public String getRecycleDate() {
		return recycleDate;
	}

	public void setRecycleDate(String recycleDate) {
		this.recycleDate = recycleDate;
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

	public String getSkuOld() {
		return skuOld;
	}

	public void setSkuOld(String skuOld) {
		this.skuOld = skuOld == null ? null : skuOld.trim();
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

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

}
