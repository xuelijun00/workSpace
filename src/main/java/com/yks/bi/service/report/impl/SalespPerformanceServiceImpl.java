package com.yks.bi.service.report.impl;

import com.yks.bi.dao.SalesPerformanceMapper;
import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.ISalespPerformanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    public List<SalesPerformance> selectAll(String business,Date st,Date et) {
    	
    	if(st == null){
    		 Calendar c = Calendar.getInstance();
             //过去15天
             c.setTime(new Date());
             c.add(Calendar.DATE, - 14);
             Date st1= c.getTime();
             /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
             Date date = sdf.parse(d);*/
             return isales.selectAll(business,st1,et);
    	}
    	 
    	return isales.selectAll(business,st,et);
    }

}
