package yks.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sun.tools.javac.util.Assert;
import com.yks.bi.service.report.IDailyOutAccountReprotsService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(value = "classpath*:config/spring-mvc.xml")
public class DailyOutAccountReprotsServiceTest {
	
	@Autowired
	IDailyOutAccountReprotsService idoars;
	
	@Test
	public void testSelectPlatforms() {
		List<String> list= idoars.selectPlatforms();
		assertNull(list);
		assertTrue(list.size() == 1);
	}

	@Test
	public void testSelectSalesAccounts() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAllByPrimaryKey() {
		fail("Not yet implemented");
	}

}
