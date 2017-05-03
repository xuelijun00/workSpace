package yks.service;

import com.alibaba.druid.filter.config.ConfigTools;

public class Test {
	
	public static void main(String[] args) throws Exception {
		String password = "root";
		String[] arr = ConfigTools.genKeyPair(1024);
		System.out.println("privateKey:" + arr[0]);
		System.out.println("publicKey:" + arr[1]);
		System.out.println("password:" + ConfigTools.encrypt(arr[0], password));
		
		
		
	}

}
