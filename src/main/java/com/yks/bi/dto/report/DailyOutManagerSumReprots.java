package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DailyOutManagerSumReprots extends DailyOutManagerSumReprotsKey {
	
	private Date reportDate1;
    public String getReportDate1() {
    	return this.getReportDate() == null?null:DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
    }
	
    private Integer salesorderNum;//销售订单数量

    private Float salesorderTotal;//销售订单金额

    private Integer orderNum;//发货单数

    private Float unitPrice;//客单价

    private Integer productTotalCny;//发货收入

    private Integer productRefund;//退款

    private Integer orderPrice;//成本

    private Integer grossProfit;//毛利

    private Integer productShipping;//运费

    private Integer platformCost;//平台费用

    private Integer materialCost;//包材费

    private Integer orderExecutionFee;//订单执行费

    private Integer operatingCost;//运营费

    private Integer profitMargin;//边际利润

    private Integer netProfit;//税前综合净利

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