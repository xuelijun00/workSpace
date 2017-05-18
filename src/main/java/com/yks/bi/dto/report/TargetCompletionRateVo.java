package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class TargetCompletionRateVo {

    private String platform;//平台

    private String name;//平台显示名称

    private Date reportDate;//报表时间
    
    private String reportDate1;//报表时间
    
    public String getReportDate1(){
    	return this.getReportDate() == null?null:DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
    }

    private Integer performanceTarget;//1月份业绩目标

    private Integer monthSales;//1月份销售额

    private Integer estimatedSales;//1月份预计销售额

    private Integer estimatedPercent;//预计百分比

    private Integer quarterlySalesTarget;//1季度业绩目标

    private Integer quarterlySales;//1季度销售额

    private Integer quarterlyEstimatedSales;//季度预计销售额

    private Integer quarterlyEstimatedPercent;//预计百分比
    
    private Integer targetprofit;//目标利润
    private Integer actualprofit;//实际利润
    private Integer month;//月份

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Integer getPerformanceTarget() {
        return performanceTarget;
    }

    public void setPerformanceTarget(Integer performanceTarget) {
        this.performanceTarget = performanceTarget;
    }

    public Integer getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(Integer monthSales) {
        this.monthSales = monthSales;
    }

    public Integer getEstimatedSales() {
        return estimatedSales;
    }

    public void setEstimatedSales(Integer estimatedSales) {
        this.estimatedSales = estimatedSales;
    }

    public Integer getEstimatedPercent() {
        return estimatedPercent;
    }

    public void setEstimatedPercent(Integer estimatedPercent) {
        this.estimatedPercent = estimatedPercent;
    }

    public Integer getQuarterlySalesTarget() {
        return quarterlySalesTarget;
    }

    public void setQuarterlySalesTarget(Integer quarterlySalesTarget) {
        this.quarterlySalesTarget = quarterlySalesTarget;
    }

    public Integer getQuarterlySales() {
        return quarterlySales;
    }

    public void setQuarterlySales(Integer quarterlySales) {
        this.quarterlySales = quarterlySales;
    }

    public Integer getQuarterlyEstimatedSales() {
        return quarterlyEstimatedSales;
    }

    public void setQuarterlyEstimatedSales(Integer quarterlyEstimatedSales) {
        this.quarterlyEstimatedSales = quarterlyEstimatedSales;
    }

    public Integer getQuarterlyEstimatedPercent() {
        return quarterlyEstimatedPercent;
    }

    public void setQuarterlyEstimatedPercent(Integer quarterlyEstimatedPercent) {
        this.quarterlyEstimatedPercent = quarterlyEstimatedPercent;
    }

	public Integer getTargetprofit() {
		return targetprofit;
	}

	public void setTargetprofit(Integer targetprofit) {
		this.targetprofit = targetprofit;
	}

	public Integer getActualprofit() {
		return actualprofit;
	}

	public void setActualprofit(Integer actualprofit) {
		this.actualprofit = actualprofit;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

}