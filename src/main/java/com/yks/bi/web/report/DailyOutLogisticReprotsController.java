package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutLogisticReprots;
import com.yks.bi.dto.report.DailyOutLogisticReprotsKey;
import com.yks.bi.service.report.IDailyOutLogisticReprotsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

/**
 * 暂时用于业绩汇总的“物流发货汇总数据”页面
 * 查询的是`dailyoutlogisticreprots`表
 * @author 62399
 *
 */
@RestController
@RequestMapping(value="/report")
public class DailyOutLogisticReprotsController {

	@Autowired
	IDailyOutLogisticReprotsService idolrs;

	@RequestMapping(value="/daily_out_logistic/grid")
	public GridModel Grid(DailyOutLogisticReprotsKey key,FilterDto filter){

		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		List<DailyOutLogisticReprots> list = idolrs.selectAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	@RequestMapping(value="/daily_out_logistic/platforms")
	public List<String> platforms(){
        return idolrs.selectPlatforms();
	}

	@RequestMapping(value="/daily_out_logistic/warehouseIds")
	public List<Integer> warehouseIds(){
        return idolrs.selectWarehouseIds();
	}

	@RequestMapping(value="/daily_out_logistic/channelNames")
	public List<String> channelNames(@RequestParam(value="platform", required=false)String platform){
        return idolrs.selectChannelNames(platform);
	}
}
