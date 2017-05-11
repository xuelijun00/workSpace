package com.yks.bi.dto.report;


/**
 *  销售业绩整体报表  
 */
public class SalesPerformance extends SalesPerformanceKey {
    private Integer orders;

    private Float sales;

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Float getSales() {
        return sales;
    }

    public void setSales(Float sales) {
        this.sales = sales;
    }
}