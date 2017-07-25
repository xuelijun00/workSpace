package com.yks.bi.service.report.impl;

import com.yks.bi.dao.DailysalescategoryreportsMapper;
import com.yks.bi.dao.DailysalesskureportsMapper;
import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.DailysalescategoryreportsKey;
import com.yks.bi.dto.report.Dailysalesskureports;
import com.yks.bi.service.report.IEbayDomesticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Dailysalescategoryreports> selectcategoryAll(DailysalescategoryreportsKey key) {
       	 
           return isalescategory.selectAll(key);
        }
    
    @Override
    public List<Dailysalescategoryreports> selectcategorynewAll(DailysalescategoryreportsKey key) {
    	
           return isalescategory.selectnewAll(key);
        }  
    
    //查询ebaydailysalesskureports表中的所有信息
    @Override
    public List<Dailysalesskureports> selectEbay(Dailysalesskureports record) {
    
        return isalessku.selectEbay(record);
        
    }
    
    @Override
	public List<Dailysalesskureports> selectSmtSku(Dailysalesskureports record) {
	
    	return isalessku.selectSmtSku(record);
	}
    
    @Override
   	public List<Dailysalesskureports> selectWishSku(Dailysalesskureports record) {
   	
       	return isalessku.selectWishSku(record);
   	}
    
    @Override
    public List<Dailysalesskureports> selectskuAll(Dailysalesskureports record) {
    
        return isalessku.selectAll(record);
    }
    
    @Override
    public List<Dailysalesskureports> selectskunewAll(Dailysalesskureports record) {
    
        return isalessku.selectskuAll(record);
    }
    
	@Override
	public List<String> selectnewPlatforms() {
		return isalescategory.selectnewPlatforms();
	}

	  
	@Override
	public List<String> selectskuPlatforms() {
		return isalessku.selectskuPlatforms();
	}

	@Override
	public List<Dailysalesskureports> selectskuAllSum(Dailysalesskureports record) {
		return isalessku.selectskuAllSum(record);
	}

	@Override
	public List<Dailysalesskureports> selectWishSkuSum(Dailysalesskureports record) {
		return isalessku.selectWishSkuSum(record);
	}

	@Override
	public List<Dailysalesskureports> selectSmtSkuSum(Dailysalesskureports record) {
		return isalessku.selectSmtSkuSum(record);
	}

	@Override
	public List<Dailysalesskureports> selectAllSum(Dailysalesskureports record) {
		
		return isalessku.selectAllSum(record);
	}

	@Override
	public List<Dailysalesskureports> selectEbaySum(Dailysalesskureports record) {
		
		return isalessku.selectEbaySum(record);
	}
	
}
