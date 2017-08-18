package com.yks.bi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.DailyOutAccountReprots;
import com.yks.bi.dto.report.DailyOutAccountReprotsKey;

public interface DailyOutAccountReprotsMapper {
	
	/**
	 * 查询dailyoutaccountreprots表中所有的平台
	 * @param platform
	 * @return
	 */
	List<String> selectPlatforms();
	
	/**
	 * 查询dailyoutaccountreprots表中所有的账号
	 * @param salesAccounts
	 * @return
	 */
	List<String> selectSalesAccounts(@Param("platform")String platform);
	
	/**
	 * 查询dailyoutaccountreprots表中所有的分类
	 * @param category
	 * @return
	 */
	List<String> selectCategorys();
	
	/**
	 * 查询dailyoutaccountreprots表中所有的数据
	 * @param key
	 * @return
	 */
	List<DailyOutAccountReprots> selectAllByPrimaryKey(DailyOutAccountReprotsKey key);

	/**
	 * 查询dailyoutaccountreprots表中新平台的平台
	 * @param platform
	 * @return
	 */
	List<String> selectNewPlatforms();
	
	/**
	 * 查询dailyoutaccountreprots表中新平台的账号
	 * @param salesAccounts 
	 * @return
	 */
	List<String> selectNewPlatformSalesAccounts(@Param("platform")String platform);
	
	/**
	 * 查询dailyoutaccountreprots表中的新平台所有数据
	 * @param key
	 * @return
	 */
	List<DailyOutAccountReprots> selectNewPlatformAllByPrimaryKey(DailyOutAccountReprotsKey key);
	
	/**
	 * 查询dailyoutaccountreprots表中新蛋的账号
	 * @param salesAccounts 
	 * @return
	 */
	List<String> selectNewEggSalesAccounts(@Param("platform")String platform);
	
	/**
	 * 查询dailyoutaccountreprots表中的新蛋所有数据
	 * @param key
	 * @return
	 */
	List<DailyOutAccountReprots> selectNewEggAllByPrimaryKey(DailyOutAccountReprotsKey key);
}
