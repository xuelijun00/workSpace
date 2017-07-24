package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DailyOutSkuReprots {
    private String platform;         //平台

    private String salesAccount;     //账号

    private String sku;              //sku

    private Date reportDate;         //日期

    private String manager;          //管理员

    private Integer orderNum;        //发货单数

    private Float unitPrice;         //客单价

    private Double productTotalCny;  //发货收入 

    private Double productRefund;    //退款

    private Double orderPrice;       //成本

    private Double grossProfit;      //毛利

    private Double productShipping;  //运费

    private Double platformCost;     //平台费

    private Double materialCost;     //包材费

    private Double orderExecutionFee;//订单执行费

    private Double operatingCost;    //运营费

    private Double profitMargin;     //边际利润

    private Double netProfit;        //税前综合净利
    
    private Double profit;           //税后综合净利

    private String startDate;
    
    private String endDate;
    
	private String reportDate1;

	public String getReportDate1() {
		if(this.getReportDate() != null){
			return DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
		}
        return null;
    }
    
    
    public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getSalesAccount() {
        return salesAccount;
    }

    public void setSalesAccount(String salesAccount) {
        this.salesAccount = salesAccount == null ? null : salesAccount.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }


	public Double getProductTotalCny() {
		return productTotalCny;
	}


	public void setProductTotalCny(Double productTotalCny) {
		this.productTotalCny = productTotalCny;
	}


	public Double getProductRefund() {
		return productRefund;
	}


	public void setProductRefund(Double productRefund) {
		this.productRefund = productRefund;
	}


	public Double getOrderPrice() {
		return orderPrice;
	}


	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}


	public Double getGrossProfit() {
		return grossProfit;
	}


	public void setGrossProfit(Double grossProfit) {
		this.grossProfit = grossProfit;
	}


	public Double getProductShipping() {
		return productShipping;
	}


	public void setProductShipping(Double productShipping) {
		this.productShipping = productShipping;
	}


	public Double getPlatformCost() {
		return platformCost;
	}


	public void setPlatformCost(Double platformCost) {
		this.platformCost = platformCost;
	}


	public Double getMaterialCost() {
		return materialCost;
	}


	public void setMaterialCost(Double materialCost) {
		this.materialCost = materialCost;
	}


	public Double getOrderExecutionFee() {
		return orderExecutionFee;
	}


	public void setOrderExecutionFee(Double orderExecutionFee) {
		this.orderExecutionFee = orderExecutionFee;
	}


	public Double getOperatingCost() {
		return operatingCost;
	}


	public void setOperatingCost(Double operatingCost) {
		this.operatingCost = operatingCost;
	}


	public Double getProfitMargin() {
		return profitMargin;
	}


	public void setProfitMargin(Double profitMargin) {
		this.profitMargin = profitMargin;
	}


	public Double getNetProfit() {
		return netProfit;
	}


	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}


	public Double getProfit() {
		return profit;
	}


	public void setProfit(Double profit) {
		this.profit = profit;
	}


	public void setReportDate1(String reportDate1) {
		this.reportDate1 = reportDate1;
	}

}