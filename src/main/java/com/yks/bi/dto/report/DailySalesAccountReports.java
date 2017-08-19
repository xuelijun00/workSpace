package com.yks.bi.dto.report;


import org.apache.commons.lang3.time.DateFormatUtils;

public class DailySalesAccountReports extends DailySalesAccountReportsKey {
	
	private String reportDate1;
    public String getReportDate1() {
    	if(this.getReportDate() != null){
    		return DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
    	}
        return null;
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