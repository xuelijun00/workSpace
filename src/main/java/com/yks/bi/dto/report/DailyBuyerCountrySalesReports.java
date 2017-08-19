package com.yks.bi.dto.report;

public class DailyBuyerCountrySalesReports extends DailyBuyerCountrySalesReportsKey{
	
	
	private Integer orders;      //订单
	
	private Integer quantity;    //数量

	private Float sales;        //销售额

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getSales() {
		return sales;
	}

	public void setSales(Float sales) {
		this.sales = sales;
	} 
	
}
