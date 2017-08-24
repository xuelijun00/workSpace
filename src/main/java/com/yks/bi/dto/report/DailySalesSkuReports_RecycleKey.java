package com.yks.bi.dto.report;

public class DailySalesSkuReports_RecycleKey {

    private String reportDate;

    private String business;

    private String sku;
    
    private String skuOld;
    
    private String startDate;
    
    private String endDate;

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
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
    
}
