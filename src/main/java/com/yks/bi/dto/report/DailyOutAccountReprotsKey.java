package com.yks.bi.dto.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DailyOutAccountReprotsKey {
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date reportDate;           //日期
	
	private String startDate;          //开始时间
	
	private String endDate;            //结束时间
	
	private String platform;           //平台
	
	private String salesAccount;       //账号
	
	private String manager;            //管理员
	
	private String category;           //暂时只用smt有分类

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

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform == null ? null : platform.trim();
	}

	public String getSalesAccount() {
		return salesAccount;
	}

	public void setSalesAccount(String salesAccount) {
		this.salesAccount = salesAccount == null ? null : salesAccount.trim();
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager == null ? null : manager.trim();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category == null ? null : category.trim();
	}
	
	
}
