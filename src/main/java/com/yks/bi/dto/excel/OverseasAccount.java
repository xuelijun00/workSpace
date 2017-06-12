package com.yks.bi.dto.excel;

import java.util.ArrayList;
import java.util.List;

public class OverseasAccount {
    private String a_account;

    private String b_platform;

	public String getA_account() {
		return a_account;
	}

	public void setA_account(String a_account) {
		this.a_account = a_account;
	}

	public String getB_platform() {
		return b_platform;
	}

	public void setB_platform(String b_platform) {
		this.b_platform = b_platform;
	}

	public static List<OverseasAccount> objToDto(List<Object> record4) {
		List<OverseasAccount> list = new ArrayList<>();
		for (Object object : record4) {
			list.add((OverseasAccount)object);
		}
		return list;
	}

}