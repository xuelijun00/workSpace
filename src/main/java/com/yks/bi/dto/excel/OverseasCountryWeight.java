package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasCountryWeight {
    private String a_countryWeight;

    private Double b_zeroToTwo;

    private Double c_oneToFive;

    private Double d_oneToTen;

    private Double e_oneToFifteen;

    private Double f_oneToTwentyFive;

    private Double g_oneToThirty;

    private Double h_oneToForty;

    private Double i_oneToFifty;

	public String getA_countryWeight() {
		return a_countryWeight;
	}

	public void setA_countryWeight(String a_countryWeight) {
		this.a_countryWeight = a_countryWeight;
	}

	public Double getB_zeroToTwo() {
		return b_zeroToTwo;
	}

	public void setB_zeroToTwo(Double b_zeroToTwo) {
		this.b_zeroToTwo = b_zeroToTwo;
	}

	public Double getC_oneToFive() {
		return c_oneToFive;
	}

	public void setC_oneToFive(Double c_oneToFive) {
		this.c_oneToFive = c_oneToFive;
	}

	public Double getD_oneToTen() {
		return d_oneToTen;
	}

	public void setD_oneToTen(Double d_oneToTen) {
		this.d_oneToTen = d_oneToTen;
	}

	public Double getE_oneToFifteen() {
		return e_oneToFifteen;
	}

	public void setE_oneToFifteen(Double e_oneToFifteen) {
		this.e_oneToFifteen = e_oneToFifteen;
	}

	public Double getF_oneToTwentyFive() {
		return f_oneToTwentyFive;
	}

	public void setF_oneToTwentyFive(Double f_oneToTwentyFive) {
		this.f_oneToTwentyFive = f_oneToTwentyFive;
	}

	public Double getG_oneToThirty() {
		return g_oneToThirty;
	}

	public void setG_oneToThirty(Double g_oneToThirty) {
		this.g_oneToThirty = g_oneToThirty;
	}

	public Double getH_oneToForty() {
		return h_oneToForty;
	}

	public void setH_oneToForty(Double h_oneToForty) {
		this.h_oneToForty = h_oneToForty;
	}

	public Double getI_oneToFifty() {
		return i_oneToFifty;
	}

	public void setI_oneToFifty(Double i_oneToFifty) {
		this.i_oneToFifty = i_oneToFifty;
	}

	public static List<OverseasCountryWeight> objToDto(List<Object> record) {
		List<OverseasCountryWeight> list = new ArrayList<OverseasCountryWeight>();
		for (Object obj : record) {
			list.add((OverseasCountryWeight)obj);
		}
		return list;
	}

}