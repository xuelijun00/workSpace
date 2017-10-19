package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.DailyOutCategoryReports;
import com.yks.bi.dto.report.DailyOutCategoryReportsKey;

/**
 * 暂时用于ebay国内仓的品类净利报表页面
 * @author 62399
 *
 */
public interface DailyOutCategoryReportsMapper {

	/**
	 * 查询dailyoutcategoryreports表中所有的数据
	 * @param key
	 * @return
	 */
	List<DailyOutCategoryReports> selectAll(DailyOutCategoryReportsKey key);
	
	/**
	 * 查询dailyoutcategoryreports表中所有的数据
	 * 按日期、品类汇总的数据
	 * @param key
	 * @return
	 */
	List<DailyOutCategoryReports> selectAllCount(DailyOutCategoryReportsKey key);
}
