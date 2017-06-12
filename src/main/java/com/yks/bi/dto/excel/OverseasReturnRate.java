package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasReturnRate {
    private String a_sku;

    private String b_returnRate;

    private String c_warehouse;
    
    private Float returnRate;


	public static List<OverseasReturnRate> objToDto(List<Object> record1) {
		List<OverseasReturnRate> list = new ArrayList<>();
		for (Object obj : record1) {
			OverseasReturnRate or = (OverseasReturnRate)obj;
			or.setReturnRate(Float.parseFloat(or.getB_returnRate().replace("%", "")) / 100);
			list.add(or);
		}
		return list;
	}


	public String getA_sku() {
		return a_sku;
	}


	public void setA_sku(String a_sku) {
		this.a_sku = a_sku;
	}


	public String getB_returnRate() {
		return b_returnRate;
	}


	public void setB_returnRate(String b_returnRate) {
		this.b_returnRate = b_returnRate;
	}


	public String getC_warehouse() {
		return c_warehouse;
	}


	public void setC_warehouse(String c_warehouse) {
		this.c_warehouse = c_warehouse;
	}


	public Float getReturnRate() {
		return returnRate;
	}


	public void setReturnRate(Float returnRate) {
		this.returnRate = returnRate;
	}
}