package com.yks.bi.service.report;

import java.util.List;


import com.yks.bi.dto.report.Dailyoutaccountreprots_oversea;
import com.yks.bi.dto.report.Dailyoutaccountreprots_overseaKey;

public interface IDailyoutaccountreprots_overseaService {

	List<Dailyoutaccountreprots_oversea> selectAll(Dailyoutaccountreprots_overseaKey key);

	List<String> selectSalesAccounts(String platform);

	List<String> selectWarehouseType(String platform);

	List<String> selectWarehouseName(Dailyoutaccountreprots_overseaKey key);

	//新平台
	List<Dailyoutaccountreprots_oversea> selectNewPlatformAll(Dailyoutaccountreprots_overseaKey key);

	List<String> selectNewPlatforms();

	List<String> selectNewPlatformSalesAccounts(String platform);

	List<String> selectNewPlatformWarehouseType(String platform);

	List<String> selectNewPlatformWarehouseName(Dailyoutaccountreprots_overseaKey key);
}
