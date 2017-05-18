package yks.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.pagehelper.PageHelper;
import com.yks.bi.dto.report.DailyOutReports;
import com.yks.bi.dto.report.DailyOutReportsKey;
import com.yks.bi.service.report.IDailyOutReportsService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(value = "classpath*:config/spring-mvc.xml")
public class DailyOutReportsServiceTest {
	
	@Autowired
	private IDailyOutReportsService report;
	
	@Test
	public void selectSumDomesticWarehouseShipmentTest(){
		String startDate = "2017-05-01";
		String endDate = "2017-05-11";
		PageHelper.startPage(1, 20, true);
		PageHelper.orderBy("");
		List<DailyOutReports> list = report.selectSumDomesticWarehouseShipment(startDate, endDate);
		Assert.assertEquals(11, list.size());
	}
	
	@Test
	public void selectPlatformDomesticWarehouseShipmentTest() throws ParseException{
		DailyOutReportsKey key = new DailyOutReportsKey();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = "2017-05-01";
		key.setReportDate(format.parse(date));
		List<DailyOutReports> list = report.selectPlatformDomesticWarehouseShipment(key);
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() > 0);
		Assert.assertEquals(format.format(list.get(0).getReportDate()), date);
	}
	
}
