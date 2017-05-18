package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DailySalesAccountReports extends DailySalesAccountReportsKey {
	
	private Date reportDate1;
    
    public String getReportDate1() {
        return DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
    }
	
    private Integer orders;

    private Float sales;
    
    public DailySalesAccountReports(){}

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