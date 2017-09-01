package com.yks.bi.dto.report;

public class DailyOutSkuTop500 extends DailyOutSkuTop500Key {
	private String skuCnName;
	
	private Double orderNum;
	
	private Double	unitPrice;
	
	private Double	productTotalCny;
	
	private Double	netProfit;
	
	private Double	profit;
	
	private Double	netProfitMargin;

	public String getSkuCnName() {
		return skuCnName;
	}

	public void setSkuCnName(String skuCnName) {
		this.skuCnName = skuCnName == null ? null : skuCnName.trim();
	}

	public Double getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Double orderNum) {
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

	public Double getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	public Double getNetProfitMargin() {
		return netProfitMargin;
	}

	public void setNetProfitMargin(Double netProfitMargin) {
		this.netProfitMargin = netProfitMargin;
	}

	
}
