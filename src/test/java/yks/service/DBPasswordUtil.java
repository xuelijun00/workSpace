package yks.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.druid.filter.config.ConfigTools;
import com.yks.bi.common.CamelToUnderlineUtil;

public class DBPasswordUtil {

	public static void main(String[] args) throws Exception {
		/*
		 * String password = "tSa6M4Qd"; String[] arr =
		 * ConfigTools.genKeyPair(1024); System.out.println("privateKey:" +
		 * arr[0]); System.out.println("publicKey:" + arr[1]);
		 * System.out.println("password:" + ConfigTools.encrypt(arr[0],
		 * password));
		 */
		
		System.out.println(CamelToUnderlineUtil.camelToUnderline("aDfdsjlDfdsalkf"));
		System.out.println(CamelToUnderlineUtil.underlineToCamel("a_dfdsjl_dfdsalkf"));
		System.out.println(CamelToUnderlineUtil.underlineToCamel2("a_dfdsjl_dfdsalkf"));
	}

}
