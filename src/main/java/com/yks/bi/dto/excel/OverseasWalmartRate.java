package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasWalmartRate {
    private String a_sku;

    private String b_platformRate;
    
    private Float platformRate;

	public static List<OverseasWalmartRate> objToDto(List<Object> record5) {
		List<OverseasWalmartRate> list = new ArrayList<>();
		for (Object object : record5) {
			OverseasWalmartRate o = (OverseasWalmartRate)object;
			o.setPlatformRate(Float.parseFloat(o.getB_platformRate().replace("%", "")) / 100);
			list.add(o);
		}
		return list;
	}

	public String getA_sku() {
		return a_sku;
	}

	public void setA_sku(String a_sku) {
		this.a_sku = a_sku;
	}

	public String getB_platformRate() {
		return b_platformRate;
	}

	public void setB_platformRate(String b_platformRate) {
		this.b_platformRate = b_platformRate;
	}

	public Float getPlatformRate() {
		return platformRate;
	}

	public void setPlatformRate(Float platformRate) {
		this.platformRate = platformRate;
	}
}