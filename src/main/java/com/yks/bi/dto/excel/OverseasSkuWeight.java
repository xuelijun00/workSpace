package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasSkuWeight {
    private String a_sku;

    private Float b_weight;

	public String getA_sku() {
		return a_sku;
	}

	public void setA_sku(String a_sku) {
		this.a_sku = a_sku;
	}

	public Float getB_weight() {
		return b_weight;
	}

	public void setB_weight(Float b_weight) {
		this.b_weight = b_weight;
	}

	public static List<OverseasSkuWeight> objToDto(List<Object> record1) {
		List<OverseasSkuWeight> list = new ArrayList<>();
		for (Object object : record1) {
			list.add((OverseasSkuWeight)object);
		}
		return list;
	}

}