package com.yks.bi.dto.user;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String account;

    private String sales;

    private String salesAssistant;

    private String storeName;

    private Integer actStatus;

    private Date fetchTime;
    
    public UserInfo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales == null ? null : sales.trim();
    }

    public String getSalesAssistant() {
        return salesAssistant;
    }

    public void setSalesAssistant(String salesAssistant) {
        this.salesAssistant = salesAssistant == null ? null : salesAssistant.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Integer getActStatus() {
        return actStatus;
    }

    public void setActStatus(Integer actStatus) {
        this.actStatus = actStatus;
    }

    public Date getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }
}