package com.yks.bi.dto.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConfigPlatformGoalNew {
    private Integer id;

    private String platform;

    private String name;

    private Date reportDate;

    @JsonFormat(pattern = "yyyy-MM")
    private String reportMonth;

    private Double performanceTargets;

    private Double quarterlyPerformanceTargets;

    private Double sales;

    private Double quarterlySales;

/*    private Float netProfitTarget;                 //无效字段 */  

	private Double estimatedSales;

    private Double quarterlyEstimatedSales;

    private Float salesPercentage;                   //业绩完成率

    private Float quarterlyEstimatedPercentage;
    
    private Float estimatedSalesPercentage;          //预计业绩完成率

    private Double targetProfit;                     //实际上是页面中的目标净利

    private Double actualProfit;                     //实际利润

    private Float netProfitCompletionRate;

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

    
   /* public Float getNetProfitTarget() {
		return netProfitTarget;
	}

	public void setNetProfitTarget(Float netProfitTarget) {
		this.netProfitTarget = netProfitTarget;
	}*/
    
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

    public Double getPerformanceTargets() {
        return performanceTargets;
    }

    public void setPerformanceTargets(Double performanceTargets) {
        this.performanceTargets = performanceTargets;
    }

    public Double getQuarterlyPerformanceTargets() {
        return quarterlyPerformanceTargets;
    }

    public void setQuarterlyPerformanceTargets(Double quarterlyPerformanceTargets) {
        this.quarterlyPerformanceTargets = quarterlyPerformanceTargets;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getQuarterlySales() {
        return quarterlySales;
    }

    public void setQuarterlySales(Double quarterlySales) {
        this.quarterlySales = quarterlySales;
    }

    public Double getEstimatedSales() {
        return estimatedSales;
    }

    public void setEstimatedSales(Double estimatedSales) {
        this.estimatedSales = estimatedSales;
    }

    public Double getQuarterlyEstimatedSales() {
        return quarterlyEstimatedSales;
    }

    public void setQuarterlyEstimatedSales(Double quarterlyEstimatedSales) {
        this.quarterlyEstimatedSales = quarterlyEstimatedSales;
    }

    public Float getSalesPercentage() {
        return salesPercentage;
    }

    public void setSalesPercentage(Float salesPercentage) {
        this.salesPercentage = salesPercentage;
    }

    public Float getQuarterlyEstimatedPercentage() {
        return quarterlyEstimatedPercentage;
    }

    public void setQuarterlyEstimatedPercentage(Float quarterlyEstimatedPercentage) {
        this.quarterlyEstimatedPercentage = quarterlyEstimatedPercentage;
    }

    public Double getTargetProfit() {
        return targetProfit;
    }

    public void setTargetProfit(Double targetProfit) {
        this.targetProfit = targetProfit;
    }

    public Double getActualProfit() {
        return actualProfit;
    }

    public void setActualProfit(Double actualProfit) {
        this.actualProfit = actualProfit;
    }


    public Float getNetProfitCompletionRate() {
        return netProfitCompletionRate;
    }

    public void setNetProfitCompletionRate(Float netProfitCompletionRate) {
        this.netProfitCompletionRate = netProfitCompletionRate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

	public Float getEstimatedSalesPercentage() {
		return estimatedSalesPercentage;
	}

	public void setEstimatedSalesPercentage(Float estimatedSalesPercentage) {
		this.estimatedSalesPercentage = estimatedSalesPercentage;
	}
}