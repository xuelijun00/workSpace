package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasSkuPrice {
    private Integer a_id;

    private String b_sku;

    private String c_currency;

    private Double d_price;

	public Integer getA_id() {
		return a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public String getB_sku() {
		return b_sku;
	}

	public void setB_sku(String b_sku) {
		this.b_sku = b_sku;
	}

	public String getC_currency() {
		return c_currency;
	}

	public void setC_currency(String c_currency) {
		this.c_currency = c_currency;
	}

	public Double getD_price() {
		return d_price;
	}

	public void setD_price(Double d_price) {
		this.d_price = d_price;
	}

	public static List<OverseasSkuPrice> objToDto(List<Object> record1) {
		List<OverseasSkuPrice> list = new ArrayList<>();
		for (Object object : record1) {
			list.add((OverseasSkuPrice)object);
		}
		return list;
	}

    
}