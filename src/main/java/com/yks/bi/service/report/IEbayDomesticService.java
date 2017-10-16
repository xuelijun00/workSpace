package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.DailysalescategoryreportsKey;
import com.yks.bi.dto.report.Dailysalesskureports;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface IEbayDomesticService {
	
	 /**
     *  品类
     */
	List<Dailysalescategoryreports> selectcategoryAll(DailysalescategoryreportsKey key);

	List<Dailysalescategoryreports> selectcategoryAllChart(DailysalescategoryreportsKey key);

	List<Dailysalescategoryreports> selectcategorynewAll(DailysalescategoryreportsKey key);

    List<String> selectBusiness(); 	

	List<String> selectnewPlatforms();
	
	/**
	 * sku
	 */
	List<Dailysalesskureports> selectskuAll(Dailysalesskureports record);
	
	//查询ebaydailysalesskureports表中的所有信息
	List<Dailysalesskureports> selectEbay(Dailysalesskureports record);
	
	List<Dailysalesskureports> selectSmtSku(Dailysalesskureports record);

	List<Dailysalesskureports> selectWishSku(Dailysalesskureports record);
	
	List<Dailysalesskureports> selectskunewAll(Dailysalesskureports record);

	List<String> selectskuPlatforms();

	List<Dailysalesskureports> selectskuNewAllSum(Dailysalesskureports record);
	
	List<Dailysalesskureports> selectWishSkuSum(Dailysalesskureports record);

	List<Dailysalesskureports> selectSmtSkuSum(Dailysalesskureports record);

	List<Dailysalesskureports> selectAllSum(Dailysalesskureports record);

	List<Dailysalesskureports> selectEbaySum(Dailysalesskureports record);

}
