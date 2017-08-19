package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasUsFreight {
    private String a_orderNumber;

    private String b_recipient;

    private String c_recipientCountry;

    private String d_recipientAddress;

    private String e_recipientCity;

    private String f_recipientState;

    private Double g_orderWeight;

    private String h_shippingMethod;

    private String i_trackingNumber;

    private String j_zipcode;

    private String k_deliveryTime;

    private Double o_freight;

    private Double m_theoryWeight;

	public String getA_orderNumber() {
		return a_orderNumber;
	}

	public void setA_orderNumber(String a_orderNumber) {
		this.a_orderNumber = a_orderNumber;
	}

	public String getB_recipient() {
		return b_recipient;
	}

	public void setB_recipient(String b_recipient) {
		this.b_recipient = b_recipient;
	}

	public String getC_recipientCountry() {
		return c_recipientCountry;
	}

	public void setC_recipientCountry(String c_recipientCountry) {
		this.c_recipientCountry = c_recipientCountry;
	}

	public String getD_recipientAddress() {
		return d_recipientAddress;
	}

	public void setD_recipientAddress(String d_recipientAddress) {
		this.d_recipientAddress = d_recipientAddress;
	}

	public String getE_recipientCity() {
		return e_recipientCity;
	}

	public void setE_recipientCity(String e_recipientCity) {
		this.e_recipientCity = e_recipientCity;
	}

	public String getF_recipientState() {
		return f_recipientState;
	}

	public void setF_recipientState(String f_recipientState) {
		this.f_recipientState = f_recipientState;
	}

	public Double getG_orderWeight() {
		return g_orderWeight;
	}

	public void setG_orderWeight(Double g_orderWeight) {
		this.g_orderWeight = g_orderWeight;
	}

	public String getH_shippingMethod() {
		return h_shippingMethod;
	}

	public void setH_shippingMethod(String h_shippingMethod) {
		this.h_shippingMethod = h_shippingMethod;
	}

	public String getI_trackingNumber() {
		return i_trackingNumber;
	}

	public void setI_trackingNumber(String i_trackingNumber) {
		this.i_trackingNumber = i_trackingNumber;
	}

	public String getJ_zipcode() {
		return j_zipcode;
	}

	public void setJ_zipcode(String j_zipcode) {
		this.j_zipcode = j_zipcode;
	}

	public String getK_deliveryTime() {
		return k_deliveryTime;
	}

	public void setK_deliveryTime(String k_deliveryTime) {
		this.k_deliveryTime = k_deliveryTime;
	}

	public Double getO_freight() {
		return o_freight;
	}

	public void setO_freight(Double o_freight) {
		this.o_freight = o_freight;
	}

	public Double getM_theoryWeight() {
		return m_theoryWeight;
	}

	public void setM_theoryWeight(Double m_theoryWeight) {
		this.m_theoryWeight = m_theoryWeight;
	}

	public static List<OverseasUsFreight> objToDto(List<Object> record) {
		List<OverseasUsFreight> list = new ArrayList<>();
		for (Object object : record) {
			list.add((OverseasUsFreight)object);
		}
		return list;
	}

   
}