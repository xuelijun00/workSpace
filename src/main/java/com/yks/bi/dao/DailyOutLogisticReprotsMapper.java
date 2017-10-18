package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.dto.report.DailyOutLogisticReprots;
import com.yks.bi.dto.report.DailyOutLogisticReprotsKey;

public interface DailyOutLogisticReprotsMapper {

	/**
	 * 查询dailyoutlogisticreprots表中的所有数据
	 * @param key
	 * @return
	 */
	List<DailyOutLogisticReprots> selectAll(DailyOutLogisticReprotsKey key);

	/**
	 * 查询dailyoutlogisticreprots表中的所有平台
	 * @return
	 */
	List<String> selectPlatforms();

	/**
	 * 查询dailyoutlogisticreprots表中的所有的仓库编码
	 * @return
	 */
	List<Integer> selectWarehouseIds();

	/**
	 * 查询dailyoutlogisticreprots表中的所有的渠道名称
	 * @return
	 */
	List<String> selectChannelNames(String platform);
}
