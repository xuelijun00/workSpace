package com.yks.bi.dto.report;

public class DailyOutCategoryReports extends DailyOutCategoryReportsKey{
	private String skuCnname;          //sku中文名

    private Integer orderNum;          //发货单数

    private Double productTotalCny;    //发货收入

    private Double 	netProfit;         //税后综合净利，注意：以其他地方的字段不一样

	public String getSkuCnname() {
		return skuCnname;
	}

	public void setSkuCnname(String skuCnname) {
		this.skuCnname = skuCnname == null ? null : skuCnname.trim();
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
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

}
