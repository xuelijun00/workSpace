package com.yks.bi.dto.report;

public class EbayDailyOutZhuanXianReprots extends EbayDailyOutZhuanXianReprotsKey {
    private Integer ordersType;

    private Integer orderNum;

    private Float unitPrice;

    private Float productTotalCny;

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

    private Float netProfitMargin;

    public Integer getOrdersType() {
        return ordersType;
    }

    public void setOrdersType(Integer ordersType) {
        this.ordersType = ordersType;
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

    public Float getProductTotalCny() {
        return productTotalCny;
    }

    public void setProductTotalCny(Float productTotalCny) {
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

    public Float getNetProfitMargin() {
        return netProfitMargin;
    }

    public void setNetProfitMargin(Float netProfitMargin) {
        this.netProfitMargin = netProfitMargin;
    }
}