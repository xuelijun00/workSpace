package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasSkuVolume {
    private String a_sku;

    private Integer b_volume;

	public static List<OverseasSkuVolume> objToDto(List<Object> record1) {
		List<OverseasSkuVolume> list = new ArrayList<>();
		for (Object object : record1) {
			list.add((OverseasSkuVolume)object);
		}
		return list;
	}

	public String getA_sku() {
		return a_sku;
	}

	public void setA_sku(String a_sku) {
		this.a_sku = a_sku;
	}

	public Integer getB_volume() {
		return b_volume;
	}

	public void setB_volume(Integer b_volume) {
		this.b_volume = b_volume;
	}
}