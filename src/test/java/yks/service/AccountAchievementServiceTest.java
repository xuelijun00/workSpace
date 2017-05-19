package yks.service;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailySalesAccountReports;
import com.yks.bi.dto.report.DailySalesAccountReportsKey;
import com.yks.bi.service.report.IAccountAchievementService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(value = "classpath*:config/spring-mvc.xml")
public class AccountAchievementServiceTest {
	//AbstractTransactionalJUnit4SpringContextTests
	//AbstractTransactionalTestNGSpringContextTests
	@Autowired
	private IAccountAchievementService accountAchievementService;
	
	@Test
	public void selectAccountAchievementServiceChart() {
		DailySalesAccountReportsKey key = new DailySalesAccountReportsKey();
		key.setStartDate("2017-05-10");
		key.setEndDate("2017-05-17");
		PageHelper.startPage(1, 20, true);
		PageHelper.orderBy("");
    	List<DailySalesAccountReports> list = accountAchievementService.selectAccountAchievementService(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
    	Assert.assertTrue(pageInfo.getList().size() > 0);
	}

}
