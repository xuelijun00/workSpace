package com.yks.bi.dto.report;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DailyOutReportsKey {
	
    private String platform;

    private Date reportDate;
    
    private Date reportDate1;
    
    public String getReportDate1() {
    	return this.getReportDate() == null?null:DateFormatUtils.format(this.getReportDate(), "yyyy-MM-dd");
    }
    
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