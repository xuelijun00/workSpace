package com.yks.bi.dto.report;

import java.util.Date;

public class DailyOutEbayGroupLeaderReprotsKey {
    private String zhandian;

    private Date reportDate;

    private String groupleader;

    public String getZhandian() {
        return zhandian;
    }

    public void setZhandian(String zhandian) {
        this.zhandian = zhandian == null ? null : zhandian.trim();
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getGroupleader() {
        return groupleader;
    }

    public void setGroupleader(String groupleader) {
        this.groupleader = groupleader == null ? null : groupleader.trim();
    }
}