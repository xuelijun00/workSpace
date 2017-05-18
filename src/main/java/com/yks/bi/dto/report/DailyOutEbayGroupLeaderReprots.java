package com.yks.bi.dto.report;

public class DailyOutEbayGroupLeaderReprots extends DailyOutEbayGroupLeaderReprotsKey {
    private String platform;

    private Integer salesorderNum;

    private Float salesorderTotal;

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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public Integer getSalesorderNum() {
        return salesorderNum;
    }

    public void setSalesorderNum(Integer salesorderNum) {
        this.salesorderNum = salesorderNum;
    }

    public Float getSalesorderTotal() {
        return salesorderTotal;
    }

    public void setSalesorderTotal(Float salesorderTotal) {
        this.salesorderTotal = salesorderTotal;
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
}