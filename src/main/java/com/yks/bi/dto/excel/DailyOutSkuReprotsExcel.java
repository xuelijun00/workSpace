package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yks.bi.dto.report.DailyOutSkuReprots;

public class DailyOutSkuReprotsExcel {
	private Long a_erpOrdersId;        //内订单号
	
	private String b_platform;         //平台
	
	private String c_salesAccount;     //账号
	
    private String d_sku;              //sku
    
    private String e_skuCnName;        //sku中文名称
    
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date f_reportDate;         //日期
    
    private String g_zhuzhandian;      //主站点
    
    private String h_manager;          //管理员

    private Integer i_orderNum;        //发货单数

    private Float j_unitPrice;         //客单价

    private Double k_productTotalCny;  //发货收入 

    private Double l_productRefund;    //退款

    private Double m_orderPrice;       //成本

    private Double n_grossProfit;      //毛利

    private Double o_productShipping;  //运费

    private Double p_platformCost;     //平台费

    private Double q_materialCost;     //包材费

    private Double r_orderExecutionFee;//订单执行费

    private Double s_operatingCost;    //运营费

    private Double t_profitMargin;     //边际利润

    private Double u_netProfit;        //税前综合净利
    
    private Double v_profit;           //税后综合净利
    
    private Float w_netProfitMargin;   //税后综合利润率
    
    private String 	x_buyerId;         //（买家id）平台订单号

	public Long getA_erpOrdersId() {
		return a_erpOrdersId;
	}

	public void setA_erpOrdersId(Long a_erpOrdersId) {
		this.a_erpOrdersId = a_erpOrdersId;
	}

	public String getB_platform() {
		return b_platform;
	}

	public void setB_platform(String b_platform) {
		this.b_platform = b_platform;
	}

	public String getC_salesAccount() {
		return c_salesAccount;
	}

	public void setC_salesAccount(String c_salesAccount) {
		this.c_salesAccount = c_salesAccount;
	}

	public String getD_sku() {
		return d_sku;
	}

	public void setD_sku(String d_sku) {
		this.d_sku = d_sku;
	}

	public String getE_skuCnName() {
		return e_skuCnName;
	}

	public void setE_skuCnName(String e_skuCnName) {
		this.e_skuCnName = e_skuCnName;
	}

	public Date getF_reportDate() {
		return f_reportDate;
	}

	public void setF_reportDate(Date f_reportDate) {
		this.f_reportDate = f_reportDate;
	}

	public String getG_zhuzhandian() {
		return g_zhuzhandian;
	}

	public void setG_zhuzhandian(String g_zhuzhandian) {
		this.g_zhuzhandian = g_zhuzhandian;
	}

	public String getH_manager() {
		return h_manager;
	}

	public void setH_manager(String h_manager) {
		this.h_manager = h_manager;
	}

	public Integer getI_orderNum() {
		return i_orderNum;
	}

	public void setI_orderNum(Integer i_orderNum) {
		this.i_orderNum = i_orderNum;
	}

	public Float getJ_unitPrice() {
		return j_unitPrice;
	}

	public void setJ_unitPrice(Float j_unitPrice) {
		this.j_unitPrice = j_unitPrice;
	}

	public Double getK_productTotalCny() {
		return k_productTotalCny;
	}

	public void setK_productTotalCny(Double k_productTotalCny) {
		this.k_productTotalCny = k_productTotalCny;
	}

	public Double getL_productRefund() {
		return l_productRefund;
	}

	public void setL_productRefund(Double l_productRefund) {
		this.l_productRefund = l_productRefund;
	}

	public Double getM_orderPrice() {
		return m_orderPrice;
	}

	public void setM_orderPrice(Double m_orderPrice) {
		this.m_orderPrice = m_orderPrice;
	}

	public Double getN_grossProfit() {
		return n_grossProfit;
	}

	public void setN_grossProfit(Double n_grossProfit) {
		this.n_grossProfit = n_grossProfit;
	}

	public Double getO_productShipping() {
		return o_productShipping;
	}

	public void setO_productShipping(Double o_productShipping) {
		this.o_productShipping = o_productShipping;
	}

	public Double getP_platformCost() {
		return p_platformCost;
	}

	public void setP_platformCost(Double p_platformCost) {
		this.p_platformCost = p_platformCost;
	}

	public Double getQ_materialCost() {
		return q_materialCost;
	}

	public void setQ_materialCost(Double q_materialCost) {
		this.q_materialCost = q_materialCost;
	}

	public Double getR_orderExecutionFee() {
		return r_orderExecutionFee;
	}

	public void setR_orderExecutionFee(Double r_orderExecutionFee) {
		this.r_orderExecutionFee = r_orderExecutionFee;
	}

	public Double getS_operatingCost() {
		return s_operatingCost;
	}

	public void setS_operatingCost(Double s_operatingCost) {
		this.s_operatingCost = s_operatingCost;
	}

	public Double getT_profitMargin() {
		return t_profitMargin;
	}

	public void setT_profitMargin(Double t_profitMargin) {
		this.t_profitMargin = t_profitMargin;
	}

	public Double getU_netProfit() {
		return u_netProfit;
	}

	public void setU_netProfit(Double u_netProfit) {
		this.u_netProfit = u_netProfit;
	}

	public Double getV_profit() {
		return v_profit;
	}

	public void setV_profit(Double v_profit) {
		this.v_profit = v_profit;
	}

	public Float getW_netProfitMargin() {
		return w_netProfitMargin;
	}

	public void setW_netProfitMargin(Float w_netProfitMargin) {
		this.w_netProfitMargin = w_netProfitMargin;
	}

	public String getX_buyerId() {
		return x_buyerId;
	}

	public void setX_buyerId(String x_buyerId) {
		this.x_buyerId = x_buyerId;
	}
    
	//将DailyOutSkuReprotsExcel中的字段转换为实体类DailyOutSkuReprots
	public static List<DailyOutSkuReprots> objToDto(List<Object> objs){
    	List<DailyOutSkuReprots> list= new ArrayList<>();
    	
    	for (Object obj : objs) {
    		DailyOutSkuReprotsExcel dosrExcel = (DailyOutSkuReprotsExcel)obj;
    		DailyOutSkuReprots dosr = new DailyOutSkuReprots();
    		if(dosrExcel.getA_erpOrdersId() != null && dosrExcel.getA_erpOrdersId().toString().trim().length()>0){
    			dosr.setErpOrdersId(dosrExcel.getA_erpOrdersId());
    		}
    		if(dosrExcel.getB_platform() != null && dosrExcel.getB_platform().toString().trim().length()>0){
    			dosr.setPlatform(dosrExcel.getB_platform());
    		}
    		if(dosrExcel.getC_salesAccount() != null && dosrExcel.getC_salesAccount().toString().trim().length()>0){
    			dosr.setSalesAccount(dosrExcel.getC_salesAccount());
    		}
    		if( dosrExcel.getD_sku()!= null && dosrExcel.getD_sku().toString().trim().length()>0){
    			dosr.setSku(dosrExcel.getD_sku());
    		}
    		if(dosrExcel.getE_skuCnName() != null && dosrExcel.getE_skuCnName().toString().trim().length()>0){
    			dosr.setSkuCnName(dosrExcel.getE_skuCnName());
    		}
    		if(dosrExcel.getF_reportDate() != null && dosrExcel.getF_reportDate().toString().trim().length()>0){
    			dosr.setReportDate(dosrExcel.getF_reportDate());
    		}
    		if(dosrExcel.getG_zhuzhandian() != null && dosrExcel.getG_zhuzhandian().toString().trim().length()>0){
    			dosr.setZhuzhandian(dosrExcel.getG_zhuzhandian());
    		}
    		if(dosrExcel.getH_manager() != null && dosrExcel.getH_manager().toString().trim().length()>0){
    			dosr.setManager(dosrExcel.getH_manager());
    		}
    		if(dosrExcel.getI_orderNum() != null && dosrExcel.getI_orderNum().toString().trim().length()>0){
    			dosr.setOrderNum(dosrExcel.getI_orderNum());
    		}
    		if(dosrExcel.getJ_unitPrice() != null && dosrExcel.getJ_unitPrice().toString().trim().length()>0){
    			dosr.setUnitPrice(dosrExcel.getJ_unitPrice());
    		}
    		if(dosrExcel.getK_productTotalCny() != null && dosrExcel.getK_productTotalCny().toString().trim().length()>0){
    			dosr.setProductTotalCny(dosrExcel.getK_productTotalCny());
    		}
    		if(dosrExcel.getL_productRefund() != null && dosrExcel.getL_productRefund().toString().trim().length()>0){
    			dosr.setProductRefund(dosrExcel.getL_productRefund());
    		}
    		if(dosrExcel.getM_orderPrice() != null && dosrExcel.getM_orderPrice().toString().trim().length()>0){
    			dosr.setOrderPrice(dosrExcel.getM_orderPrice());
    		}
    		if(dosrExcel.getN_grossProfit() != null && dosrExcel.getN_grossProfit().toString().trim().length()>0){
    			dosr.setGrossProfit(dosrExcel.getN_grossProfit());
    		}
    		if(dosrExcel.getO_productShipping() != null && dosrExcel.getO_productShipping().toString().trim().length()>0){
    			dosr.setProductShipping(dosrExcel.getO_productShipping());
    		}
    		if(dosrExcel.getP_platformCost() != null && dosrExcel.getP_platformCost().toString().trim().length()>0){
    			dosr.setPlatformCost(dosrExcel.getP_platformCost());
    		}
    		if(dosrExcel.getQ_materialCost() != null && dosrExcel.getQ_materialCost().toString().trim().length()>0){
    			dosr.setMaterialCost(dosrExcel.getQ_materialCost());
    		}
    		if(dosrExcel.getR_orderExecutionFee() != null && dosrExcel.getR_orderExecutionFee().toString().trim().length()>0){
    			dosr.setOrderExecutionFee(dosrExcel.getR_orderExecutionFee());
    		}
    		if(dosrExcel.getS_operatingCost() != null && dosrExcel.getS_operatingCost().toString().trim().length()>0){
    			dosr.setOperatingCost(dosrExcel.getS_operatingCost());
    		}
    		if(dosrExcel.getT_profitMargin() != null && dosrExcel.getT_profitMargin().toString().trim().length()>0){
    			dosr.setProfitMargin(dosrExcel.getT_profitMargin());
    		}
    		if(dosrExcel.getU_netProfit() != null && dosrExcel.getU_netProfit().toString().trim().length()>0){
    			dosr.setNetProfit(dosrExcel.getU_netProfit());
    		}
    		if(dosrExcel.getV_profit() != null && dosrExcel.getV_profit().toString().trim().length()>0){
    			dosr.setProfit(dosrExcel.getV_profit());
    		}
    		if(dosrExcel.getW_netProfitMargin() != null && dosrExcel.getW_netProfitMargin().toString().trim().length()>0){
    			dosr.setNetProfitMargin(dosrExcel.getW_netProfitMargin());
    		}
    		if(dosrExcel.getX_buyerId() != null && dosrExcel.getX_buyerId().toString().trim().length()>0){
    			dosr.setBuyerId(dosrExcel.getX_buyerId());
    		}

    		list.add(dosr);
		}
    	return list;
    }
}
