package com.yks.bi.service.report.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yks.bi.common.excelutil.CSVParseUtil;
import com.yks.bi.common.excelutil.ExcelUtil;
import com.yks.bi.common.excelutil.OrderWeight;
import com.yks.bi.dao.OrderWeightMapper;
import com.yks.bi.dao.excel.OverseasAccountMapper;
import com.yks.bi.dao.excel.OverseasCostMapper;
import com.yks.bi.dao.excel.OverseasCountryRateMapper;
import com.yks.bi.dao.excel.OverseasCountryWeightMapper;
import com.yks.bi.dao.excel.OverseasOrderWeightMapper;
import com.yks.bi.dao.excel.OverseasReturnRateMapper;
import com.yks.bi.dao.excel.OverseasShippingMethodsMapper;
import com.yks.bi.dao.excel.OverseasSkuPriceMapper;
import com.yks.bi.dao.excel.OverseasSkuVolumeMapper;
import com.yks.bi.dao.excel.OverseasSkuWeightMapper;
import com.yks.bi.dao.excel.OverseasUsFreightMapper;
import com.yks.bi.dao.excel.OverseasWalmartRateMapper;
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
import com.yks.bi.service.report.IExcelImportService;

@Service
public class ExcelImportServiceImpl implements IExcelImportService {
	
	@Autowired
	private OrderWeightMapper orderWeightMapper;
	@Autowired
	private OverseasAccountMapper overseasAccountMapper;
	@Autowired
	private OverseasCountryRateMapper overseasCountryRateMapper;
	@Autowired
	private OverseasCountryWeightMapper overseasCountryWeightMapper;
	@Autowired
	private OverseasOrderWeightMapper overseasOrderWeightMapper;
	@Autowired
	private OverseasReturnRateMapper overseasReturnRateMapper;
	@Autowired
	private OverseasShippingMethodsMapper overseasShippingMethodsMapper;
	@Autowired
	private OverseasSkuPriceMapper overseasSkuPriceMapper;
	@Autowired
	private OverseasSkuVolumeMapper overseasSkuVolumeMapper;
	@Autowired
	private OverseasSkuWeightMapper overseasSkuWeightMapper;
	@Autowired
	private OverseasUsFreightMapper overseasUsFreightMapper;
	@Autowired
	private OverseasWalmartRateMapper overseasWalmartRateMapper;
	@Autowired
	private OverseasCostMapper overseasCostMapper;
	
	@Transactional
	@Override
	public void insertBatchByOrderWeight(List<OrderWeight> record) {
		orderWeightMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasAccount(List<OverseasAccount> record) {
		overseasAccountMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasCountryRate(List<OverseasCountryRate> record) {
		overseasCountryRateMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasCountryWeight(List<OverseasCountryWeight> record) {
		overseasCountryWeightMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasOrderWeight(List<OverseasOrderWeight> record) {
		overseasOrderWeightMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasReturnRate(List<OverseasReturnRate> record) {
		overseasReturnRateMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasShippingMethods(List<OverseasShippingMethods> record) {
		overseasShippingMethodsMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasSkuPrice(List<OverseasSkuPrice> record) {
		overseasSkuPriceMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasSkuVolume(List<OverseasSkuVolume> record) {
		overseasSkuVolumeMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasSkuWeight(List<OverseasSkuWeight> record) {
		overseasSkuWeightMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasUsFreight(List<OverseasUsFreight> record) {
		overseasUsFreightMapper.insertBatch(record);
	}

	@Transactional
	@Override
	public void insertBatchByOverseasWalmartRate(List<OverseasWalmartRate> record) {
		overseasWalmartRateMapper.insertBatch(record);
	}
	
	/**
	 * 解析海外仓基础数据
	 * @param is
	 * @throws Exception
	 */
	@Override
	public void parseOverseasWarehouseBaseData(String strSource) throws Exception{
		File[] files  = CSVParseUtil.parseOverseasWarehouseBaseData(strSource);
		//成本
		Map<Integer, String>  map0 = ExcelUtil.generateColumn(OverseasCost.class, "set");
		List<Object> record0 = CSVParseUtil.parseCSV(files[0], map0, OverseasCost.class);
		this.insertBatchByOverseasCost(OverseasCost.objToDto(record0));
		//DHL
		Map<Integer, String>  map1 = ExcelUtil.generateColumn(OverseasShippingMethods.class, "set");
		List<Object> record1 = CSVParseUtil.parseCSV(files[1], map1, OverseasShippingMethods.class);
		this.insertBatchByOverseasShippingMethods(OverseasShippingMethods.objToDto(record1));
		//GLS
		Map<Integer, String>  map5 = ExcelUtil.generateColumn(OverseasCountryWeight.class, "set");
		List<Object> record5 = CSVParseUtil.parseCSV(files[5], map5, OverseasCountryWeight.class);
		this.insertBatchByOverseasCountryWeight(OverseasCountryWeight.objToDto(record5));
		//huilv
		Map<Integer, String>  map6 = ExcelUtil.generateColumn(OverseasCountryRate.class, "set");
		List<Object> record6 = CSVParseUtil.parseCSV(files[6], map6, OverseasCountryRate.class);
		this.insertBatchByOverseasCountryRate(OverseasCountryRate.objToDto(record6));
		//MBB订单重量
		Map<Integer, String>  map7 = ExcelUtil.generateColumn(OverseasOrderWeight.class, "set");
		List<Object> record7 = CSVParseUtil.parseCSV(files[7], map7, OverseasOrderWeight.class);
		if(record7.size() >= 10000){
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < record7.size(); i++) {
				list.add(record7.get(i));
				if(i%2000 == 0 || i == record7.size() - 1){//数据量太大，会导致超时，分批插入
					this.insertBatchByOverseasOrderWeight(OverseasOrderWeight.objToDto(list));
					list.clear();
				}
			}
		}
		//meicangyunfei
		Map<Integer, String>  map8 = ExcelUtil.generateColumn(OverseasUsFreight.class, "set");
		List<Object> record8 = CSVParseUtil.parseCSV(files[8], map8, OverseasUsFreight.class);
		if(record8.size() >= 10000){
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < record8.size(); i++) {
				list.add(record8.get(i));
				if(i%2000 == 0 || i == record8.size() - 1){//数据量太大，会导致超时，分批插入
					this.insertBatchByOverseasUsFreight(OverseasUsFreight.objToDto(list));
					list.clear();
				}
			}
		}
		//tiji
		Map<Integer, String>  map9 = ExcelUtil.generateColumn(OverseasSkuVolume.class, "set");
		List<Object> record9 = CSVParseUtil.parseCSV(files[9], map9, OverseasSkuVolume.class);
		if(record9.size() >= 10000){
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < record9.size(); i++) {
				list.add(record9.get(i));
				if(i%2000 == 0 || i == record9.size() - 1){//数据量太大，会导致超时，分批插入
					this.insertBatchByOverseasSkuVolume(OverseasSkuVolume.objToDto(list));
					list.clear();
				}
			}
		}
		//tuikuanlv
		Map<Integer, String>  map10 = ExcelUtil.generateColumn(OverseasReturnRate.class, "set");
		List<Object> record10 = CSVParseUtil.parseCSV(files[10], map10, OverseasReturnRate.class);
		this.insertBatchByOverseasReturnRate(OverseasReturnRate.objToDto(record10));
		
		//zhongliang
		Map<Integer, String>  map11 = ExcelUtil.generateColumn(OverseasSkuWeight.class, "set");
		List<Object> record11 = CSVParseUtil.parseCSV(files[11], map11, OverseasSkuWeight.class);
		if(record11.size() >= 10000){
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < record11.size(); i++) {
				list.add(record11.get(i));
				if(i%2000 == 0 || i == record11.size() - 1){//数据量太大，会导致超时，分批插入一次两千
					this.insertBatchByOverseasSkuWeight(OverseasSkuWeight.objToDto(list));
					list.clear();
				}
			}
		}
		//zuixindanjia
		Map<Integer, String>  map12 = ExcelUtil.generateColumn(OverseasSkuPrice.class, "set");
		List<Object> record12 = CSVParseUtil.parseCSV(files[12], map12, OverseasSkuPrice.class);
		if(record12.size() >= 10000){
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < record12.size(); i++) {
				list.add(record12.get(i));
				if(i%2000 == 0 || i == record12.size() - 1){//数据量太大，会导致超时，分批插入一次两千
					this.insertBatchByOverseasSkuPrice(OverseasSkuPrice.objToDto(list));
					list.clear();
				}
			}
		}
		//account
		Map<Integer, String>  map2 = ExcelUtil.generateColumn(OverseasAccount.class, "set");
		List<Object> record2 = CSVParseUtil.parseCSV(files[2], map2, OverseasAccount.class);
		this.insertBatchByOverseasAccount(OverseasAccount.objToDto(record2));
		//沃尔玛
		Map<Integer, String>  map3 = ExcelUtil.generateColumn(OverseasWalmartRate.class, "set");
		List<Object> record3 = CSVParseUtil.parseCSV(files[3], map3, OverseasWalmartRate.class);
		this.insertBatchByOverseasWalmartRate(OverseasWalmartRate.objToDto(record3));
		
		
	}

	@Transactional
	@Override
	public void insertBatchByOverseasCost(List<OverseasCost> record) {
		overseasCostMapper.insertBatch(record);
	}

}
