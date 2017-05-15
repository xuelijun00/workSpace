package com.yks.bi.service.report.impl;

import com.yks.bi.dao.DailysalescategoryreportsMapper;
import com.yks.bi.dao.DailysalesskureportsMapper;
import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.Dailysalesskureports;
import com.yks.bi.service.report.IEbayDomesticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
@Service
public class IEbayDomesticServiceImpl implements IEbayDomesticService {

    @Autowired
    private DailysalescategoryreportsMapper isalescategory;
    
    @Autowired
    private DailysalesskureportsMapper isalessku;
    /**
     *  ebay国内仓每日销售额  表格数据, 柱状图
     */
    @Override
    public List<Dailysalescategoryreports> selectcategoryAll(String business,Date st,Date et,String oldsku,String category) {
    	if(st == null){
      		 Calendar c = Calendar.getInstance();
               //过去15天
               c.setTime(new Date());
               c.add(Calendar.DATE, - 3);
               Date st1= c.getTime();
               return isalescategory.selectAll(business, st1, et, oldsku, category);
      	}
      	 
           return isalescategory.selectAll(business, st, et, oldsku, category);
        }
    
   
    @Override
    public List<Dailysalesskureports> selectskuAll(String business,Date st,Date et,String sku,String oldsku) {
    	
    	if(st == null){
   		 Calendar c = Calendar.getInstance();
            //过去15天
            c.setTime(new Date());
            c.add(Calendar.DATE, - 3);
            Date st1= c.getTime();
            return isalessku.selectAll(business, st1, et, sku, oldsku);
   	}
   	 
        return isalessku.selectAll(business, st, et, sku, oldsku);
    }

}
