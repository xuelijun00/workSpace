package com.yks.bi.dto.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DailyOutCategoryReportsKey {
	 	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	    private Date reportDate;      //日期

	    private String startDate;

	    private String endDate;

	    private String business;      //业务线

	    private String category;      //品类

	    private String sku;           //sku

		public Date getReportDate() {
			return reportDate;
		}

		public void setReportDate(Date reportDate) {
			this.reportDate = reportDate;
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

		public String getSku() {
			return sku;
		}

		public void setSku(String sku) {
			this.sku = sku == null ? null : sku.trim();
		}

}
