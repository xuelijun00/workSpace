package yks.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.Dailysalesskureports;
import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.IEbayDomesticService;
import com.yks.bi.service.report.ISalespPerformanceService;
import com.yks.bi.service.report.ITargetCompletionRateService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(value = "classpath*:config/spring-mvc.xml")
public class ISalespPerformanceServiceTest {

	@Autowired
	IEbayDomesticService test;
	
	@Test
	public void selectAll() throws ParseException {
		Dailysalesskureports dailysalesskureports = new Dailysalesskureports();
		String strDate = "2017-05-09 00:00:00";
		String etrDate = "2017-05-12 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(strDate);
		Date date1 = sdf.parse(etrDate);
		dailysalesskureports.setBusiness("Ebay_US");
		dailysalesskureports.setStartDate(strDate);
		dailysalesskureports.setEndDate(etrDate);
		
        List<Dailysalesskureports> list = test.selectskuAll(dailysalesskureports);
        for (int i = 0; i < list.size(); i++) {  
            System.out.println(list.get(i));  
        }  
	}

}
