package com.yks.bi.service.report.impl;

import com.yks.bi.dao.SalesPerformanceMapper;
import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.ISalespPerformanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<SalesPerformance> selectAll(Date platform) {
        return isales.selectAll(platform,"a_ll");
    }
   

}
