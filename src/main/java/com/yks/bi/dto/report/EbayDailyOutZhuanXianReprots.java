package com.yks.bi.dto.report;

public class EbayDailyOutZhuanXianReprots extends EbayDailyOutZhuanXianReprotsKey {
    private Integer ordersType;         //订单类型

    private Integer orderNum;           //发货单数

    private Float unitPrice;            //客单价

    private Double productTotalCny;     //发货收入

    private Double productRefund;       //退款

    private Double orderPrice;          //成本

    private Double grossProfit;         //毛利

    private Double productShipping;     //运费

    private Double platformCost;        //平台费用

    private Double materialCost;        //包材费

    private Double orderExecutionFee;   //订单执行费

    private Double operatingCost;       //运营费

    private Double profitMargin;        //边际利润

    private Double netProfit;           //税前综合净利

    private Float netProfitMargin;      //税后综合利润率

    private Double profit;              //税后综合净利

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

	public Double getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}

	public Float getNetProfitMargin() {
		return netProfitMargin;
	}

	public void setNetProfitMargin(Float netProfitMargin) {
		this.netProfitMargin = netProfitMargin;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

    
}