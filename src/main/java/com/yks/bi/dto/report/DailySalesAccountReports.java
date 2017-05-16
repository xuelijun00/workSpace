package com.yks.bi.dto.report;

public class DailySalesAccountReports extends DailySalesAccountReportsKey {
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