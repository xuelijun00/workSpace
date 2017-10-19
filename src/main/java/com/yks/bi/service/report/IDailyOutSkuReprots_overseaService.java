package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailyOutSkuReprots_oversea;
import com.yks.bi.dto.report.DailyOutSkuReprots_overseaKey;

public interface IDailyOutSkuReprots_overseaService {

	List<DailyOutSkuReprots_oversea> selectAll(DailyOutSkuReprots_overseaKey key);

	List<String> selectPlatforms();

	List<String> selectSalesAccounts(String platform);

	List<String> selectWarehouseTypes(String platform);

	List<String> selectWarehouseNames(DailyOutSkuReprots_overseaKey key);
}
