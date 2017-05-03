package yks.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yks.bi.dto.user.UserInfo;
import com.yks.bi.service.user.IUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:springmvc.xml" })
public class TestUserInfoService extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private IUserInfoService userService;
	
	@Test
	public void testListUserInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		UserInfo user = userService.selectByPrimaryKey(1);
		System.out.println(user.getAccount());
	}

}
