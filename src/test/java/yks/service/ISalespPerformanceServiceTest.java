package yks.service;

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

import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.dto.report.TargetCompletionRateVo;
import com.yks.bi.service.report.ISalespPerformanceService;
import com.yks.bi.service.report.ITargetCompletionRateService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(value = "classpath*:config/spring-mvc.xml")
public class ISalespPerformanceServiceTest {

	@Autowired
	ISalespPerformanceService salespPerformanceService;
	
	@Test
	public void selectAll() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去15天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 14);
        Date d = c.getTime();
        String day = format.format(d);
        /*List<SalesPerformance> list = salespPerformanceService.selectAll(d);
        Assert.assertEquals(15, list.size());*/
	}

}
