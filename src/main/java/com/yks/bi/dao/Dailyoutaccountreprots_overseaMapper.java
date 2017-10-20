package com.yks.bi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.Dailyoutaccountreprots_oversea;
import com.yks.bi.dto.report.Dailyoutaccountreprots_overseaKey;

public interface Dailyoutaccountreprots_overseaMapper {

	/**
	 * 查询dailyoutaccountreprots_oversea表中所有的数据
	 * @param key
	 * @return
	 */
	List<Dailyoutaccountreprots_oversea> selectAll(Dailyoutaccountreprots_overseaKey key);

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
	List<String> selectWarehouseType(@Param("platform")String platform);
	
	/**
	 * 查询dailyoutaccountreprots_oversea表中各平台的原仓库类型可与仓库类型级联
	 * @param key
	 * @return
	 */
	List<String> selectWarehouseName(Dailyoutaccountreprots_overseaKey key);

	//新平台
	/**
	 * 查询dailyoutaccountreprots_oversea表新平台中所有的数据
	 * @param key
	 * @return
	 */
	List<Dailyoutaccountreprots_oversea> selectNewPlatformAll(Dailyoutaccountreprots_overseaKey key);

	/**
	 * 查询dailyoutaccountreprots_oversea表中新平台所有的平台
	 * @return
	 */
	List<String> selectNewPlatforms();

	/**
	 * 查询dailyoutaccountreprots_oversea表中新平台所有的账号
	 * @param platform
	 * @return
	 */
	List<String> selectNewPlatformSalesAccounts(@Param("platform")String platform);

	/**
	 * 查询dailyoutaccountreprots_oversea表中新平台的仓库类型
	 * @param platform
	 * @return
	 */
	List<String> selectNewPlatformWarehouseType(@Param("platform")String platform);
	
	/**
	 * 查询dailyoutaccountreprots_oversea表中新平台的原仓库类型可与平台、仓库类型级联
	 * @param key
	 * @return
	 */
	List<String> selectNewPlatformWarehouseName(Dailyoutaccountreprots_overseaKey key);
}
