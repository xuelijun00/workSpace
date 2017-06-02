package yks.service;

import com.yks.bi.dto.report.ConfigPlatformGoalNew;
import com.yks.bi.service.report.ITargetCompletionRateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(value = "classpath*:config/spring-mvc.xml")
public class TargetCompletionRateServiceImplTest {

    @Autowired
    ITargetCompletionRateService targetCompletionRateService;

    @Test
    public void selectAll() {
        String month = "2017-01";
        List<ConfigPlatformGoalNew> targetCompletionRates = targetCompletionRateService.selectAll(month, null);
        System.out.println(targetCompletionRates.size());
    }

}