package yks.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.pagehelper.PageHelper;
import com.yks.bi.dto.report.DailyOutManagerSumReprots;
import com.yks.bi.dto.report.DailyOutManagerSumReprotsKey;
import com.yks.bi.service.report.IDailyOutManagerSumReprotsService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(value = "classpath*:config/spring-mvc.xml")
public class DailyOutManagerSumReprotsServiceTest {
	
	@Autowired
	private IDailyOutManagerSumReprotsService service;
	
	@Test
	public void selectByCondition() {
		DailyOutManagerSumReprotsKey key = new DailyOutManagerSumReprotsKey();
		key.setStartDate("2017-05-09");
		key.setEndDate("2017-05-17");
		key.setManager("丁壮壮");
		List<DailyOutManagerSumReprots>  list = service.selectByCondition(key);
		Assert.assertTrue(list.size() == 9);
	}
	@Test
	public void selectManagers() {
		List<String> list = service.selectManagers();
		Assert.assertTrue(list.size() > 0);
	}
	@Test
	public void selectManagerAchievementByWeek() {
		DailyOutManagerSumReprotsKey key = new DailyOutManagerSumReprotsKey();
		key.setStartDate("2017-05-09");
		key.setEndDate("2017-05-17");
		key.setManager("丁壮壮");
		List<DailyOutManagerSumReprots> list = service.selectManagerAchievementByWeek(key);
		Assert.assertTrue(list.size() == 2);
	}

}
