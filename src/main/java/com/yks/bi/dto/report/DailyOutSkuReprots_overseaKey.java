package com.yks.bi.dto.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DailyOutSkuReprots_overseaKey {

	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date reportDate;           //日期

	private String startDate;          //开始时间

	private String endDate;            //结束时间

	private String platform;           //平台

	private String salesAccount;       //账号

	private String warehouseName;      //原仓库类型

	private String warehouseType;      //仓库类型

	private String sku;                //SKU

	private Long erpOrdersId;          //内订单号

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

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName == null ? null : warehouseName.trim();
	}

	public String getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(String warehouseType) {
		this.warehouseType = warehouseType == null ? null : warehouseType.trim();
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku == null ? null : sku.trim();
	}

	public Long getErpOrdersId() {
		return erpOrdersId;
	}

	public void setErpOrdersId(Long erpOrdersId) {
		this.erpOrdersId = erpOrdersId;
	}

}
