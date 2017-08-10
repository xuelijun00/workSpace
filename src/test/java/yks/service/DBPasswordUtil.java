package yks.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;

import com.alibaba.druid.filter.config.ConfigTools;
import com.yks.bi.common.CamelToUnderlineUtil;
import com.yks.bi.common.excelutil.ExcelUtil;
import com.yks.bi.common.excelutil.XLSX2CSV;
import com.yks.bi.dto.system.SystemUser;
import com.yks.bi.service.system.SystemUserService;

public class DBPasswordUtil {

	public static void main(String[] args) throws Exception {
		/*
		 * String password = "tSa6M4Qd"; String[] arr =
		 * ConfigTools.genKeyPair(1024); System.out.println("privateKey:" +
		 * arr[0]); System.out.println("publicKey:" + arr[1]);
		 * System.out.println("password:" + ConfigTools.encrypt(arr[0],
		 * password));
		 */
		
		/*System.out.println(CamelToUnderlineUtil.camelToUnderline("aDfdsjlDfdsalkf"));
		System.out.println(CamelToUnderlineUtil.underlineToCamel("a_dfdsjl_dfdsalkf"));
		System.out.println(CamelToUnderlineUtil.underlineToCamel2("a_dfdsjl_dfdsalkf"));*/
		
		/*SystemUserService service = new SystemUserService();
		SystemUser user = service.login("liuxing2", "xing1234");
		System.out.println(user.getId());*/
		//service.login("xuelijun", "xue123456");
		
		
		//File file = new File("f:\\xiekanglin\\bi\\海外仓基础数据SQL.xlsx");
		//ExcelUtil.parseOverseasWarehouseBaseData(new FileInputStream(file));
		//OPCPackage p = OPCPackage.open(file.getPath(), PackageAccess.READ);
		
		String key = "c7cdeb1d-7fa2-4fe2-97a6-73a7c64768a7";
		System.err.println(99/10);
		
	}

}
