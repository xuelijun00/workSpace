package com.yks.bi.dto.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DailyOutLogisticReprotsKey {

	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date reportDate;           //日期

	private String startDate;

    private String endDate;
    
    private String platform;           //平台

    private Integer warehouseid;       //仓库编码

    private String channelName;        //渠道名称

    private Long erpOrdersId;          //内单号

    private String ordersCode;         //用于追踪码1和追踪码2的结合字段

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

	public Integer getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(Integer warehouseid) {
		this.warehouseid = warehouseid;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName == null ? null : channelName.trim();
	}

	public Long getErpOrdersId() {
		return erpOrdersId;
	}

	public void setErpOrdersId(Long erpOrdersId) {
		this.erpOrdersId = erpOrdersId;
	}

	public String getOrdersCode() {
		return ordersCode;
	}

	public void setOrdersCode(String ordersCode) {
		this.ordersCode = ordersCode == null ? null : ordersCode.trim();
	}

    
}
