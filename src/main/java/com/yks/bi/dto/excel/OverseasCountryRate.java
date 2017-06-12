package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasCountryRate {
    private String a_countryAbbreviation;

    private Double b_rate;

	public String getA_countryAbbreviation() {
		return a_countryAbbreviation;
	}

	public void setA_countryAbbreviation(String a_countryAbbreviation) {
		this.a_countryAbbreviation = a_countryAbbreviation;
	}

	public Double getB_rate() {
		return b_rate;
	}

	public void setB_rate(Double b_rate) {
		this.b_rate = b_rate;
	}

	public static List<OverseasCountryRate> objToDto(List<Object> record) {
		List<OverseasCountryRate> list = new ArrayList<>();
		for (Object object : record) {
			list.add((OverseasCountryRate)object);
		}
		return list;
	}

   
}