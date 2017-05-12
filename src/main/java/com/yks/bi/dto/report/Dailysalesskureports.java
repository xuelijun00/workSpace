package com.yks.bi.dto.report;

public class Dailysalesskureports extends DailysalesskureportsKey {
    private String skuOld;

    private Integer orders;

    private Integer quantity;

    private Float sales;

    public String getSkuOld() {
        return skuOld;
    }

    public void setSkuOld(String skuOld) {
        this.skuOld = skuOld == null ? null : skuOld.trim();
    }

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