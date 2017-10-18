package com.yks.bi.dto.report;

public class DailyOutLogisticReprots extends DailyOutLogisticReprotsKey{

	private String ordersShippingCode;      //追踪码1

	private String ordersMailCode;          //追踪码2

	private String freightcode;             //渠道编码

	private Float productTotalCny;          //发货收入

	private Float netProfit;                //税后综合净利

	private Float productShipping;          //运费

	private Float fee;                      //实际运费

	private Float skuWeight;                //sku重量

	private Float orderWeight;              //订单重量

	private Float heavi;                    //实际发货重量

	private String ordersType;              //订单类型

	private String sku;                     //sku

	private String skuCnname;               //sku中文名

	private Integer logicAttr;              //物流属性（数字）

	private String buyerCountry;            //买家国家

	private String buyerAddress1;           //买家地址1

	private String buyerAddress2;           //买家地址2

	private String ebayCounycode;           //国家编码

	private String countryCn;               //国家编码

	private String salesAccount;            //账号

	public String getOrdersShippingCode() {
		return ordersShippingCode;
	}

	public void setOrdersShippingCode(String ordersShippingCode) {
		this.ordersShippingCode = ordersShippingCode == null ? null : ordersShippingCode.trim();
	}

	public String getOrdersMailCode() {
		return ordersMailCode;
	}

	public void setOrdersMailCode(String ordersMailCode) {
		this.ordersMailCode = ordersMailCode == null ? null : ordersMailCode.trim();
	}

	public String getFreightcode() {
		return freightcode;
	}

	public void setFreightcode(String freightcode) {
		this.freightcode = freightcode == null ? null : freightcode.trim();
	}

	public Float getProductTotalCny() {
		return productTotalCny;
	}

	public void setProductTotalCny(Float productTotalCny) {
		this.productTotalCny = productTotalCny;
	}

	public Float getNetProfit() {
		return netProfit;
	}

	public void setNetProfit(Float netProfit) {
		this.netProfit = netProfit;
	}

	public Float getProductShipping() {
		return productShipping;
	}

	public void setProductShipping(Float productShipping) {
		this.productShipping = productShipping;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public Float getSkuWeight() {
		return skuWeight;
	}

	public void setSkuWeight(Float skuWeight) {
		this.skuWeight = skuWeight;
	}

	public Float getOrderWeight() {
		return orderWeight;
	}

	public void setOrderWeight(Float orderWeight) {
		this.orderWeight = orderWeight;
	}

	public Float getHeavi() {
		return heavi;
	}

	public void setHeavi(Float heavi) {
		this.heavi = heavi;
	}

	public String getOrdersType() {
		return ordersType;
	}

	public void setOrdersType(String ordersType) {
		this.ordersType = ordersType == null ? null : ordersType.trim();
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku == null ? null : sku.trim();
	}

	public String getSkuCnname() {
		return skuCnname;
	}

	public void setSkuCnname(String skuCnname) {
		this.skuCnname = skuCnname == null ? null : skuCnname.trim();
	}

	public Integer getLogicAttr() {
		return logicAttr;
	}

	public void setLogicAttr(Integer logicAttr) {
		this.logicAttr = logicAttr;
	}

	public String getBuyerCountry() {
		return buyerCountry;
	}

	public void setBuyerCountry(String buyerCountry) {
		this.buyerCountry = buyerCountry == null ? null : buyerCountry.trim();
	}

	public String getBuyerAddress1() {
		return buyerAddress1;
	}

	public void setBuyerAddress1(String buyerAddress1) {
		this.buyerAddress1 = buyerAddress1 == null ? null : buyerAddress1.trim();
	}

	public String getBuyerAddress2() {
		return buyerAddress2;
	}

	public void setBuyerAddress2(String buyerAddress2) {
		this.buyerAddress2 = buyerAddress2 == null ? null : buyerAddress2.trim();
	}

	public String getEbayCounycode() {
		return ebayCounycode;
	}

	public void setEbayCounycode(String ebayCounycode) {
		this.ebayCounycode = ebayCounycode == null ? null : ebayCounycode.trim();
	}

	public String getCountryCn() {
		return countryCn;
	}

	public void setCountryCn(String countryCn) {
		this.countryCn = countryCn;
	}

	public String getSalesAccount() {
		return salesAccount;
	}

	public void setSalesAccount(String salesAccount) {
		this.salesAccount = salesAccount == null ? null : salesAccount.trim();
	}

	
}
