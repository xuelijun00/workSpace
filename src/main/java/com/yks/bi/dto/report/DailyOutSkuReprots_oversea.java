package com.yks.bi.dto.report;

public class DailyOutSkuReprots_oversea extends DailyOutSkuReprots_overseaKey{

	private String skuCnname;

	private String 	manager;           //管理员

	private Integer orderNum;          //发货单数

	private Integer itemNum;           //数量汇总

	private Double 	productTotalCny;   //发货收入

	private Double productRefund;      //退款

	private Double orderPrice;         //成本

	private Double orderHeadfee;       //总头程

	private Double grossProfit;        //毛利

	private Double productShipping;    //运费

	private Double platformCost;       //平台费用

	private Double materialCost;       //包材费

	private Double orderExecutionFee;  //订单执行费

	private Double operatingCost;      //运营费

	private Double profitMargin;       //边际利润

	/**
	 * 注意：这里和项目中其他的netProfit、profit是反过来的，这里是纠正前面单词引用错误，
	 * 但是涉及到太多类，所以前面没有改过来，从这里开始引用正确的词义
	 * 词义profit:利润, netProfit:净利润
	 */
	private Double 	profit;            //税前综合净利

	private Double netProfit;          //税后综合净利

	private Double netProfitMargin;    //税后综合利润率

	private String 	buyerId;           //平台单号

	public String getSkuCnname() {
		return skuCnname;
	}

	public void setSkuCnname(String skuCnname) {
		this.skuCnname = skuCnname == null ? null : skuCnname.trim();
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

	public Integer getItemNum() {
		return itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public Double getProductTotalCny() {
		return productTotalCny;
	}

	public void setProductTotalCny(Double productTotalCny) {
		this.productTotalCny = productTotalCny;
	}

	public Double getProductRefund() {
		return productRefund;
	}

	public void setProductRefund(Double productRefund) {
		this.productRefund = productRefund;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Double getOrderHeadfee() {
		return orderHeadfee;
	}

	public void setOrderHeadfee(Double orderHeadfee) {
		this.orderHeadfee = orderHeadfee;
	}

	public Double getGrossProfit() {
		return grossProfit;
	}

	public void setGrossProfit(Double grossProfit) {
		this.grossProfit = grossProfit;
	}

	public Double getProductShipping() {
		return productShipping;
	}

	public void setProductShipping(Double productShipping) {
		this.productShipping = productShipping;
	}

	public Double getPlatformCost() {
		return platformCost;
	}

	public void setPlatformCost(Double platformCost) {
		this.platformCost = platformCost;
	}

	public Double getMaterialCost() {
		return materialCost;
	}

	public void setMaterialCost(Double materialCost) {
		this.materialCost = materialCost;
	}

	public Double getOrderExecutionFee() {
		return orderExecutionFee;
	}

	public void setOrderExecutionFee(Double orderExecutionFee) {
		this.orderExecutionFee = orderExecutionFee;
	}

	public Double getOperatingCost() {
		return operatingCost;
	}

	public void setOperatingCost(Double operatingCost) {
		this.operatingCost = operatingCost;
	}

	public Double getProfitMargin() {
		return profitMargin;
	}

	public void setProfitMargin(Double profitMargin) {
		this.profitMargin = profitMargin;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	public Double getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}

	public Double getNetProfitMargin() {
		return netProfitMargin;
	}

	public void setNetProfitMargin(Double netProfitMargin) {
		this.netProfitMargin = netProfitMargin;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId == null ? null : buyerId.trim();
	}

}
