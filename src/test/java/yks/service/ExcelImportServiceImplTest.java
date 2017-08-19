package yks.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yks.bi.common.excelutil.ExcelUtil;
import com.yks.bi.common.excelutil.OrderWeight;
import com.yks.bi.service.report.IExcelImportService;

import yks.dto.AmzAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(value = "classpath*:config/spring-mvc.xml")
public class ExcelImportServiceImplTest {
	
	@Autowired
	private IExcelImportService service;

	@Test
	public void testInsertBatch() throws Exception {
		File file = new File("f:\\test\\9002.xls");
		Map<Integer,String> column = ExcelUtil.generateColumn(OrderWeight.class,"set",0,3,9);//需要excel第039列
		List<Object> list = ExcelUtil.parseExcel(new FileInputStream(file), column, OrderWeight.class);
		System.out.println(list.size());
		//ExcelUtil.writeExcel("f:\\test\\test9002.xlsx", list);
		List<OrderWeight> ow = OrderWeight.objToDto(list);
		service.insertBatchByOrderWeight(ow);
	}
	
	@Test
	public void parseOverseasWarehouseBaseData() throws Exception {
		String strSource = "f:\\xiekanglin\\bi\\海外仓基础数据SQL.xlsx";
		service.parseOverseasWarehouseBaseData(strSource);
	}
	
	@Test
	public void test01() throws Exception {
		String file = "f:\\xiekanglin\\app\\亚马逊全部店铺子邮箱.xlsx";
		Map<Integer,String> column = ExcelUtil.generateColumn(AmzAccount.class,"set");
		List<Object> list = ExcelUtil.parseExcel(new FileInputStream(file), column, AmzAccount.class);
		for (Object object : list) {
			AmzAccount a = (AmzAccount)object;
			if(a.getC_account_mail().indexOf("账号死掉") > -1){
				continue;
			}
			if(a.getA_site().equals("US")){
				System.out.println(String.format("INSERT INTO `adv_account_crawler` ( `site`, `sales_site`, `account_name`, `account_mail`,account_password, `principal`, `ip`, `create_time`, `act_status`, `update_time`) VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', '%s', now(), '1', '2017-06-19 00:00:00');"
						, a.getA_site(),"www.amazon.com,www.amazon.ca,www.amazon.com.mx",a.getB_account_name(),a.getC_account_mail(),a.getF_account_password(),a.getE_principal(),a.getD_ip()));
			}else if(a.getA_site().equals("UK")){
				System.out.println(String.format("INSERT INTO `adv_account_crawler` ( `site`, `sales_site`, `account_name`, `account_mail`,account_password, `principal`, `ip`, `create_time`, `act_status`, `update_time`) VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', '%s', now(), '1', '2017-06-19 00:00:00');"
						, a.getA_site(),"www.amazon.co.uk,www.amazon.de,www.amazon.fr,www.amazon.it,www.amazon.es",a.getB_account_name(),a.getC_account_mail(),a.getF_account_password(),a.getE_principal(),a.getD_ip()));
			}else{
				System.out.println(String.format("INSERT INTO `adv_account_crawler` ( `site`, `sales_site`, `account_name`, `account_mail`,account_password, `principal`, `ip`, `create_time`, `act_status`, `update_time`) VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', '%s', now(), '1', '2017-06-19 00:00:00');"
						, a.getA_site(),"www.amazon.jp",a.getB_account_name(),a.getC_account_mail(),a.getF_account_password(),a.getE_principal(),a.getD_ip()));
			}
			
		}
	}

}
