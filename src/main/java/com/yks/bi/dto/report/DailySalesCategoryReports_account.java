package com.yks.bi.dto.report;

public class DailySalesCategoryReports_account extends DailySalesCategoryReports_accountKey {

	private Integer orders;
	private Double 	sales;
	public Integer getOrders() {
		return orders;
	}
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	public Double getSales() {
		return sales;
	}
	public void setSales(Double sales) {
		this.sales = sales;
	}
	
	
}
