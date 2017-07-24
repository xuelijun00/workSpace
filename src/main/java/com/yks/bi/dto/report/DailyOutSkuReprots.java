package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DailyOutSkuReprots {
    private String platform;

    private String salesAccount;

    private String sku;

    private Date reportDate;

    private String manager;

    private Integer orderNum;

    private Float unitPrice;

    private Integer productTotalCny;

    private Integer productRefund;

    private Integer orderPrice;

    private Integer grossProfit;

    private Integer productShipping;

    private Integer platformCost;

    private Integer materialCost;

    private Integer orderExecutionFee;

    private Integer operatingCost;

    private Integer profitMargin;

    private Integer netProfit;
    
    private Integer profit; //税后综合净利

    private String startDate;
    private String endDate;
    
	private String reportDate1;

	public String getReportDate1() {
		if(this.getReportDate() != null){
			return DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
		}
        return null;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getProductTotalCny() {
        return productTotalCny;
    }

    public void setProductTotalCny(Integer productTotalCny) {
        this.productTotalCny = productTotalCny;
    }

    public Integer getProductRefund() {
        return productRefund;
    }

    public void setProductRefund(Integer productRefund) {
        this.productRefund = productRefund;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(Integer grossProfit) {
        this.grossProfit = grossProfit;
    }

    public Integer getProductShipping() {
        return productShipping;
    }

    public void setProductShipping(Integer productShipping) {
        this.productShipping = productShipping;
    }

    public Integer getPlatformCost() {
        return platformCost;
    }

    public void setPlatformCost(Integer platformCost) {
        this.platformCost = platformCost;
    }

    public Integer getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(Integer materialCost) {
        this.materialCost = materialCost;
    }

    public Integer getOrderExecutionFee() {
        return orderExecutionFee;
    }

    public void setOrderExecutionFee(Integer orderExecutionFee) {
        this.orderExecutionFee = orderExecutionFee;
    }

    public Integer getOperatingCost() {
        return operatingCost;
    }

    public void setOperatingCost(Integer operatingCost) {
        this.operatingCost = operatingCost;
    }

    public Integer getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(Integer profitMargin) {
        this.profitMargin = profitMargin;
    }

    public Integer getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Integer netProfit) {
        this.netProfit = netProfit;
    }


	public Integer getProfit() {
		return profit;
	}


	public void setProfit(Integer profit) {
		this.profit = profit;
	}
}