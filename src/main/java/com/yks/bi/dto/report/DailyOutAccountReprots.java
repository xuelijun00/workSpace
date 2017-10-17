package com.yks.bi.dto.report;
/**
 * 用于每日发货账号维度报表的实体类
 * @author 62399
 *
 */
public class DailyOutAccountReprots extends DailyOutAccountReprotsKey{

	private Integer orderNum;          //发货单数
	
	private Double 	unitPrice;         //客单价
	
	private Double 	productTotalCny;   //发货收入
	
	private Integer productRefund;     //退款
	
	private Integer orderPrice;        //成本
	
	private Integer grossProfit;       //毛利
	
	private Integer productShipping;   //运费
	
	private Integer platformCost;      //平台费用
	
	private Integer materialCost;      //包材费
	
	private Integer orderExecutionFee; //订单执行费
	
	private Integer operatingCost;     //运营费
	
	private Integer profitMargin;      //边际利润
	
	private Integer netProfit;         //税前综合净利
	
	private Double 	profit;            //净利

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getProductTotalCny() {
		return productTotalCny;
	}

	public void setProductTotalCny(Double productTotalCny) {
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

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}
	
	
}
