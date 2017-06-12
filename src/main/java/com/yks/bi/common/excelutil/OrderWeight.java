package com.yks.bi.common.excelutil;

import java.util.ArrayList;
import java.util.List;

public class OrderWeight {
	
    private String a_ordersNumber;

    private String b_logisticstype;

    private Float c_weight;

	public String getA_ordersNumber() {
		return a_ordersNumber;
	}

	public void setA_ordersNumber(String a_ordersNumber) {
		this.a_ordersNumber = a_ordersNumber;
	}

	public String getB_logisticstype() {
		return b_logisticstype;
	}

	public void setB_logisticstype(String b_logisticstype) {
		this.b_logisticstype = b_logisticstype;
	}

	public Float getC_weight() {
		return c_weight;
	}

	public void setC_weight(Float c_weight) {
		this.c_weight = c_weight;
	}

    public static List<OrderWeight> objToDto(List<Object> objs){
    	List<OrderWeight> list= new ArrayList<>();
    	for (Object obj : objs) {
    		list.add((OrderWeight)obj);
		}
    	return list;
    }
}