package com.yks.bi.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.bi.dao.SalesPerformanceMapper;
import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.dto.report.SalesPerformanceKey;
import com.yks.bi.service.report.ISalespPerformanceService;

/**
 * Created by Administrator on 2017/5/8.
 */
@Service
public class SalespPerformanceServiceImpl implements ISalespPerformanceService {

    @Autowired
    private SalesPerformanceMapper isales;
    /**
     *  销售业绩整体报表  表格数据, 柱状图
     */
    @Override
    public List<SalesPerformance> selectAll(SalesPerformanceKey key) {
    	return isales.selectAll(key);
    }
     
	 @Override
	 public List<SalesPerformance> selectnewAll(SalesPerformanceKey key) {
	 	return isales.selectnewAll(key);
	 }
	@Override
	public List<String> selectPlatforms(SalesPerformanceKey key) {
		return isales.selectPlatforms(key);
	}
	 
	@Override
	public List<String> selectnewPlatforms() {
		return isales.selectnewPlatforms();
	}

	@Override
	public List<String> selectDomesticPlatforms() {
		return isales.selectDomesticPlatforms();
	}

	@Override
	public List<SalesPerformance> selectAllCount(SalesPerformanceKey key) {
		return isales.selectAllCount(key);
	}

	@Override
	public List<SalesPerformance> selectnewAllSum(SalesPerformanceKey key) {
		return isales.selectnewAllSum(key);
	}
	

}
