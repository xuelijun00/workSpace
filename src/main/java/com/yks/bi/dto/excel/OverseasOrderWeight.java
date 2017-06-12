package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasOrderWeight {
    private String a_orderNumber;

    private String b_shippingMethod;

    private Double c_weightKg;

    private Double d_weightG;

    private String e_subscriptionOrderNumber;

	public String getA_orderNumber() {
		return a_orderNumber;
	}

	public void setA_orderNumber(String a_orderNumber) {
		this.a_orderNumber = a_orderNumber;
	}

	public String getB_shippingMethod() {
		return b_shippingMethod;
	}

	public void setB_shippingMethod(String b_shippingMethod) {
		this.b_shippingMethod = b_shippingMethod;
	}

	public Double getC_weightKg() {
		return c_weightKg;
	}

	public void setC_weightKg(Double c_weightKg) {
		this.c_weightKg = c_weightKg;
	}

	public Double getD_weightG() {
		return d_weightG;
	}

	public void setD_weightG(Double d_weightG) {
		this.d_weightG = d_weightG;
	}

	public String getE_subscriptionOrderNumber() {
		return e_subscriptionOrderNumber;
	}

	public void setE_subscriptionOrderNumber(String e_subscriptionOrderNumber) {
		this.e_subscriptionOrderNumber = e_subscriptionOrderNumber;
	}

	public static List<OverseasOrderWeight> objToDto(List<Object> record) {
		List<OverseasOrderWeight> list = new ArrayList<>();
		for (Object object : record) {
			list.add((OverseasOrderWeight)object);
		}
		return list;
	}

    
}