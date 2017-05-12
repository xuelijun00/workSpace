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
    public List<Dailysalescategoryreports> selectcategoryAll(String business) {
    	 Calendar c = Calendar.getInstance();
         //过去15天
         c.setTime(new Date());
         c.add(Calendar.DATE, - 14);
         Date d = c.getTime();
    	
        return isalescategory.selectAll(business, null, null, d, null);
    }
   
    @Override
    public List<Dailysalesskureports> selectskuAll(String business) {
    	
    	 Calendar c = Calendar.getInstance();
         //过去1天
         c.setTime(new Date());
         c.add(Calendar.DATE, - 1);
         Date d = c.getTime();
        return isalessku.selectAll(business, null, null, d, null);
    }

}
