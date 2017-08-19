package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.common.excelutil.OrderWeight;
import com.yks.bi.dto.excel.OverseasAccount;
import com.yks.bi.dto.excel.OverseasCost;
import com.yks.bi.dto.excel.OverseasCountryRate;
import com.yks.bi.dto.excel.OverseasCountryWeight;
import com.yks.bi.dto.excel.OverseasOrderWeight;
import com.yks.bi.dto.excel.OverseasReturnRate;
import com.yks.bi.dto.excel.OverseasShippingMethods;
import com.yks.bi.dto.excel.OverseasSkuPrice;
import com.yks.bi.dto.excel.OverseasSkuVolume;
import com.yks.bi.dto.excel.OverseasSkuWeight;
import com.yks.bi.dto.excel.OverseasUsFreight;
import com.yks.bi.dto.excel.OverseasWalmartRate;

public interface IExcelImportService {
	
	void insertBatchByOrderWeight(List<OrderWeight> record);
	/**
	 * 海外仓店铺表
	 * @param record
	 */
	void insertBatchByOverseasAccount(List<OverseasAccount> record);
	/**
	 * 国家汇率
	 * @param record
	 */
	void insertBatchByOverseasCountryRate(List<OverseasCountryRate> record);
	/**
	 * 海外仓国家 重量单价
	 * @param record
	 */
	void insertBatchByOverseasCountryWeight(List<OverseasCountryWeight> record);
	/**
	 * 海外仓订单重量
	 * @param record
	 */
	void insertBatchByOverseasOrderWeight(List<OverseasOrderWeight> record);
	/**
	 * 海外仓退款率
	 * @param record
	 */
	void insertBatchByOverseasReturnRate(List<OverseasReturnRate> record);
	/**
	 * 海外仓物流方式
	 * @param record
	 */
	void insertBatchByOverseasShippingMethods(List<OverseasShippingMethods> record);
	/**
	 * 海外仓sku单价
	 * @param record
	 */
	void insertBatchByOverseasSkuPrice(List<OverseasSkuPrice> record);
	/**
	 * 海外仓sku体积
	 * @param record
	 */
	void insertBatchByOverseasSkuVolume(List<OverseasSkuVolume> record);
	/**
	 * 海外仓sku重量
	 * @param record
	 */
	void insertBatchByOverseasSkuWeight(List<OverseasSkuWeight> record);
	/**
	 * 海外美仓运费
	 * @param record
	 */
	void insertBatchByOverseasUsFreight(List<OverseasUsFreight> record);
	/**
	 * 海外沃尔玛
	 * @param record
	 */
	void insertBatchByOverseasWalmartRate(List<OverseasWalmartRate> record);
	/**
	 * 海外仓成本
	 * @param record
	 */
	void insertBatchByOverseasCost(List<OverseasCost> record);
	/**
	 * 解析海外仓基础数据
	 * @param strSource
	 * @throws Exception
	 */
	void parseOverseasWarehouseBaseData(String strSource)  throws Exception;

}
