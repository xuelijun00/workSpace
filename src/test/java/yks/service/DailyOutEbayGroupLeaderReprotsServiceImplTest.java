package yks.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yks.bi.dto.report.EbayDailyOutZhiYouReprots;
import com.yks.bi.dto.report.EbayDailyOutZhiYouReprotsKey;
import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprots;
import com.yks.bi.dto.report.EbayDailyOutZhuanXianReprotsKey;
import com.yks.bi.service.report.IDailyOutEbayGroupLeaderReprotsService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(value = "classpath*:config/spring-mvc.xml")
public class DailyOutEbayGroupLeaderReprotsServiceImplTest {
	
	@Autowired
	IDailyOutEbayGroupLeaderReprotsService service;

	@Test
	public void testSelectSite() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectLeader() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByCondition() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectLeaderDailyOutByWeek() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectGreenLine() {
		EbayDailyOutZhuanXianReprotsKey key = new EbayDailyOutZhuanXianReprotsKey();
		key.setStartDate("2017-05-016");
		key.setEndDate("2017-05-19");
		List<EbayDailyOutZhuanXianReprots>  list = service.selectGreenLine(key);
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testSelectChannel() {
		List<String> list = service.selectChannel();
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testSelectDirectMail() {
		EbayDailyOutZhiYouReprotsKey key = new EbayDailyOutZhiYouReprotsKey();
		key.setStartDate("2017-05-016");
		key.setEndDate("2017-05-19");
		List<EbayDailyOutZhiYouReprots> list = service.selectDirectMail(key);
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testSelectDirectMailSite() {
		List<String> list = service.selectDirectMailSite();
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

}
