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

}
