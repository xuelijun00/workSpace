package com.yks.bi.service.report;

import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.Dailysalesskureports;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface IEbayDomesticService {
	
	 /**
     *  销售业绩整体报表 
     */
	List<Dailysalescategoryreports> selectcategoryAll(String business,Date st,Date et,String category);
	
	List<Dailysalesskureports> selectskuAll(String business,Date st,Date et,String sku,String oldsku);
	
	 //查询ebaydailysalesskureports表中的所有信息
	List<Dailysalesskureports> selectEbay(String business,Date st,Date et,String sku,String oldsku);
	
	List<Dailysalesskureports> selectSmtSku(Date st, Date et, String sku, String oldsku);

	List<Dailysalesskureports> selectWishSku(Date st, Date et, String sku, String oldsku);

	
	List<Dailysalescategoryreports> selectcategorynewAll(String business,Date st,Date et,String category);

	List<String> selectnewPlatforms();
	
	
	List<Dailysalesskureports> selectskunewAll(String business,Date st,Date et,String sku,String oldsku);

	List<String> selectskuPlatforms();

}
