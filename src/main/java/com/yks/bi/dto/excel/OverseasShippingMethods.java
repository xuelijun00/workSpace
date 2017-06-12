package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasShippingMethods {
    private String a_countryEnglish;

    private String b_countryChinese;

    private String c_partition;

    private Double d_freight;

    private Double e_perKgPrice;

	public String getA_countryEnglish() {
		return a_countryEnglish;
	}

	public void setA_countryEnglish(String a_countryEnglish) {
		this.a_countryEnglish = a_countryEnglish;
	}

	public String getB_countryChinese() {
		return b_countryChinese;
	}

	public void setB_countryChinese(String b_countryChinese) {
		this.b_countryChinese = b_countryChinese;
	}

	public String getC_partition() {
		return c_partition;
	}

	public void setC_partition(String c_partition) {
		this.c_partition = c_partition;
	}

	public Double getD_freight() {
		return d_freight;
	}

	public void setD_freight(Double d_freight) {
		this.d_freight = d_freight;
	}

	public Double getE_perKgPrice() {
		return e_perKgPrice;
	}

	public void setE_perKgPrice(Double e_perKgPrice) {
		this.e_perKgPrice = e_perKgPrice;
	}

	public static List<OverseasShippingMethods> objToDto(List<Object> record) {
		List<OverseasShippingMethods> list = new ArrayList<OverseasShippingMethods>();
		for (Object obj : record) {
			list.add((OverseasShippingMethods)obj);
		}
		return list;
	}

    
}