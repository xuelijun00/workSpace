package com.yks.bi.dto.report;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EbayDailyOutZhiYouReprotsKey {
	
    private String platform;
    
    /*@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")*/
    private Date reportDate;

    private String zhuzhandian;
    
    private String startDate;
    private String endDate;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getZhuzhandian() {
        return zhuzhandian;
    }

    public void setZhuzhandian(String zhuzhandian) {
        this.zhuzhandian = zhuzhandian == null ? null : zhuzhandian.trim();
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
}