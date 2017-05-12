package com.yks.bi.service.report;

import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.Dailysalesskureports;
import com.yks.bi.dao.TargetCompletionRateMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface IEbayDomesticService {
	
	 /**
     *  销售业绩整体报表 
     */
	List<Dailysalescategoryreports> selectcategoryAll(String business);
	
	List<Dailysalesskureports> selectskuAll(String business);

}
