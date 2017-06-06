package com.yks.bi.dto.report;

import java.util.Date;

public class ConfigPlatformGoalNew {
    private Integer id;

    private String platform;

    private String name;

    private Date reportDate;

    private String reportMonth;

    private Integer performanceTargets;

    private Integer quarterlyPerformanceTargets;

    private Integer sales;

    private Integer quarterlySales;

    private Integer netProfitTarget;
   

	private Integer estimatedSales;

    private Integer quarterlyEstimatedSales;

    private Integer estimatedPercentage;

    private Integer quarterlyEstimatedPercentage;

    private Integer targetProfit;

    private Integer actualProfit;


    private Integer netProfitCompletionRate;

    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    
    public Integer getNetProfitTarget() {
		return netProfitTarget;
	}

	public void setNetProfitTarget(Integer netProfitTarget) {
		this.netProfitTarget = netProfitTarget;
	}
    
    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportMonth() {
        return reportMonth;
    }

    public void setReportMonth(String reportMonth) {
        this.reportMonth = reportMonth == null ? null : reportMonth.trim();
    }

    public Integer getPerformanceTargets() {
        return performanceTargets;
    }

    public void setPerformanceTargets(Integer performanceTargets) {
        this.performanceTargets = performanceTargets;
    }

    public Integer getQuarterlyPerformanceTargets() {
        return quarterlyPerformanceTargets;
    }

    public void setQuarterlyPerformanceTargets(Integer quarterlyPerformanceTargets) {
        this.quarterlyPerformanceTargets = quarterlyPerformanceTargets;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getQuarterlySales() {
        return quarterlySales;
    }

    public void setQuarterlySales(Integer quarterlySales) {
        this.quarterlySales = quarterlySales;
    }

    public Integer getEstimatedSales() {
        return estimatedSales;
    }

    public void setEstimatedSales(Integer estimatedSales) {
        this.estimatedSales = estimatedSales;
    }

    public Integer getQuarterlyEstimatedSales() {
        return quarterlyEstimatedSales;
    }

    public void setQuarterlyEstimatedSales(Integer quarterlyEstimatedSales) {
        this.quarterlyEstimatedSales = quarterlyEstimatedSales;
    }

    public Integer getEstimatedPercentage() {
        return estimatedPercentage;
    }

    public void setEstimatedPercentage(Integer estimatedPercentage) {
        this.estimatedPercentage = estimatedPercentage;
    }

    public Integer getQuarterlyEstimatedPercentage() {
        return quarterlyEstimatedPercentage;
    }

    public void setQuarterlyEstimatedPercentage(Integer quarterlyEstimatedPercentage) {
        this.quarterlyEstimatedPercentage = quarterlyEstimatedPercentage;
    }

    public Integer getTargetProfit() {
        return targetProfit;
    }

    public void setTargetProfit(Integer targetProfit) {
        this.targetProfit = targetProfit;
    }

    public Integer getActualProfit() {
        return actualProfit;
    }

    public void setActualProfit(Integer actualProfit) {
        this.actualProfit = actualProfit;
    }


    public Integer getNetProfitCompletionRate() {
        return netProfitCompletionRate;
    }

    public void setNetProfitCompletionRate(Integer netProfitCompletionRate) {
        this.netProfitCompletionRate = netProfitCompletionRate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}