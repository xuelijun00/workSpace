package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OverseasCost {
    private Integer id;

    private String a_sku;

    private Double b_price;

    private String c_warehouse;

    private Double d_firstPrice;

    private Double e_weight;

    private Date createAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static List<OverseasCost> objToDto(List<Object> objs){
    	List<OverseasCost> list = new ArrayList<OverseasCost>();
    	for (Object object : objs) {
    		list.add((OverseasCost)object);
		}
    	return list;
    }

	public String getA_sku() {
		return a_sku;
	}

	public void setA_sku(String a_sku) {
		this.a_sku = a_sku;
	}

	public Double getB_price() {
		return b_price;
	}

	public void setB_price(Double b_price) {
		this.b_price = b_price;
	}

	public String getC_warehouse() {
		return c_warehouse;
	}

	public void setC_warehouse(String c_warehouse) {
		this.c_warehouse = c_warehouse;
	}

	public Double getD_firstPrice() {
		return d_firstPrice;
	}

	public void setD_firstPrice(Double d_firstPrice) {
		this.d_firstPrice = d_firstPrice;
	}

	public Double getE_weight() {
		return e_weight;
	}

	public void setE_weight(Double e_weight) {
		this.e_weight = e_weight;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date f_createAt) {
		this.createAt = f_createAt;
	}
    
}