package com.yks.bi.dto.report;

public class DailySalesSkuReports_Recycle extends DailySalesSkuReports_RecycleKey{

    private Integer orders;              //订单数

    private Integer quantity;            //数量

    private Float sales;                 //订单金额（美元）
    
    private Integer recycleOrders;      //环比增长单数
    
    private Integer recycleQuantity;    //环比增长个数
    
    private Float recycleSales;         //环比增长销售额（美元）
    
    private Float recycleRate;          //环比增长率（美元）
    

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

	public Integer getRecycleOrders() {
		return recycleOrders;
	}

	public void setRecycleOrders(Integer recycleOrders) {
		this.recycleOrders = recycleOrders;
	}

	public Integer getRecycleQuantity() {
		return recycleQuantity;
	}

	public void setRecycleQuantity(Integer recycleQuantity) {
		this.recycleQuantity = recycleQuantity;
	}

	public Float getRecycleSales() {
		return recycleSales;
	}

	public void setRecycleSales(Float recycleSales) {
		this.recycleSales = recycleSales;
	}

	public Float getRecycleRate() {
		return recycleRate;
	}

	public void setRecycleRate(Float recycleRate) {
		this.recycleRate = recycleRate;
	}

}
