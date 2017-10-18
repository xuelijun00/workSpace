package com.yks.bi.service.report;

import java.util.List;

import com.yks.bi.dto.report.DailyOutLogisticReprots;
import com.yks.bi.dto.report.DailyOutLogisticReprotsKey;

public interface IDailyOutLogisticReprotsService {

	List<DailyOutLogisticReprots> selectAll(DailyOutLogisticReprotsKey key);

	List<String> selectPlatforms();

	List<Integer> selectWarehouseIds();

	List<String> selectChannelNames(String platform);
}
