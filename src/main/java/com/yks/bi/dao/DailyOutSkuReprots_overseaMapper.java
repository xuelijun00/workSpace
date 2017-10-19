package com.yks.bi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailyOutSkuReprots_oversea;
import com.yks.bi.dto.report.DailyOutSkuReprots_overseaKey;

public interface DailyOutSkuReprots_overseaMapper {

	/**
	 * 查询dailyoutaccountreprots_oversea表中所有的数据
	 * @param key
	 * @return
	 */
	List<DailyOutSkuReprots_oversea> selectAll(DailyOutSkuReprots_overseaKey key);

	/**
	 * 查询dailyoutaccountreprots_oversea表中所有的平台
	 * @param platform
	 * @return
	 */
	List<String> selectPlatforms();

	/**
	 * 查询dailyoutaccountreprots_oversea表中所有的账号
	 * @param platform
	 * @return
	 */
	List<String> selectSalesAccounts(@Param("platform")String platform);

	/**
	 * 查询dailyoutaccountreprots_oversea表中各平台的仓库类型
	 * @param platform
	 * @return
	 */
	List<String> selectWarehouseTypes(@Param("platform")String platform);

	/**
	 * 查询dailyoutaccountreprots_oversea表中各平台的原仓库类型可与仓库类型级联
	 * @param key
	 * @return
	 */
	List<String> selectWarehouseNames(DailyOutSkuReprots_overseaKey key);
}
