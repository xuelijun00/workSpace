package com.yks.bi.dto.report;

import java.util.Date;

public class ConfigPlatformGoalNew {
    private Integer id;

    private String platform;

    private String name;

    private Date reportDate;

    private String reportMonth;

    private double performanceTargets;

    private double quarterlyPerformanceTargets;

    private double sales;

    private double quarterlySales;

    private float netProfitTarget;
   

	private double estimatedSales;

    private double quarterlyEstimatedSales;

    private float estimatedPercentage;

    private float quarterlyEstimatedPercentage;

    private double targetProfit;

    private double actualProfit;


    private float netProfitCompletionRate;

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

    
    public float getNetProfitTarget() {
		return netProfitTarget;
	}

	public void setNetProfitTarget(float netProfitTarget) {
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

    public double getPerformanceTargets() {
        return performanceTargets;
    }

    public void setPerformanceTargets(double performanceTargets) {
        this.performanceTargets = performanceTargets;
    }

    public double getQuarterlyPerformanceTargets() {
        return quarterlyPerformanceTargets;
    }

    public void setQuarterlyPerformanceTargets(double quarterlyPerformanceTargets) {
        this.quarterlyPerformanceTargets = quarterlyPerformanceTargets;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getQuarterlySales() {
        return quarterlySales;
    }

    public void setQuarterlySales(double quarterlySales) {
        this.quarterlySales = quarterlySales;
    }

    public double getEstimatedSales() {
        return estimatedSales;
    }

    public void setEstimatedSales(double estimatedSales) {
        this.estimatedSales = estimatedSales;
    }

    public double getQuarterlyEstimatedSales() {
        return quarterlyEstimatedSales;
    }

    public void setQuarterlyEstimatedSales(double quarterlyEstimatedSales) {
        this.quarterlyEstimatedSales = quarterlyEstimatedSales;
    }

    public float getEstimatedPercentage() {
        return estimatedPercentage;
    }

    public void setEstimatedPercentage(float estimatedPercentage) {
        this.estimatedPercentage = estimatedPercentage;
    }

    public float getQuarterlyEstimatedPercentage() {
        return quarterlyEstimatedPercentage;
    }

    public void setQuarterlyEstimatedPercentage(float quarterlyEstimatedPercentage) {
        this.quarterlyEstimatedPercentage = quarterlyEstimatedPercentage;
    }

    public double getTargetProfit() {
        return targetProfit;
    }

    public void setTargetProfit(double targetProfit) {
        this.targetProfit = targetProfit;
    }

    public double getActualProfit() {
        return actualProfit;
    }

    public void setActualProfit(double actualProfit) {
        this.actualProfit = actualProfit;
    }


    public float getNetProfitCompletionRate() {
        return netProfitCompletionRate;
    }

    public void setNetProfitCompletionRate(float netProfitCompletionRate) {
        this.netProfitCompletionRate = netProfitCompletionRate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}