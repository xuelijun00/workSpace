package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutSkuReprots_oversea;
import com.yks.bi.dto.report.DailyOutSkuReprots_overseaKey;
import com.yks.bi.dto.report.Dailyoutaccountreprots_overseaKey;
import com.yks.bi.service.report.IDailyOutSkuReprots_overseaService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

/**
 * 用于海外仓sku维度的每日发货数据
 * 查询dailyoutskureprots_oversea表
 * @author 62399
 *
 */
@RestController
@RequestMapping(value="/report")
public class DailyOutSkuReprots_overseaController {

	@Autowired
	private IDailyOutSkuReprots_overseaService idosros;
	
	/**
	 * 页面表格的数据
	 * 按条件查询dailyoutskureprots_oversea表中所有的数据
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping(value="/daily_out_sku_oversea/grid",method=RequestMethod.GET)
	public GridModel Grid(DailyOutSkuReprots_overseaKey key,FilterDto filter){

		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailyOutSkuReprots_oversea> list = idosros.selectAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	/**
	 * 查询dailyoutskureprots_oversea表中各平台的平台
	 * @return
	 */
	@RequestMapping(value="/daily_out_sku_oversea/platforms",method=RequestMethod.GET)
	public List<String> platforms(){
        return idosros.selectPlatforms();
	}
	
	/**
	 * 查询dailyoutskureprots_oversea表中各平台的账号
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_sku_oversea/accounts",method=RequestMethod.GET)
	public List<String> salesAccounts(@RequestParam(value="platform", required=false)String platform){
        return idosros.selectSalesAccounts(platform);
	}

	/**
	 * 查询dailyoutskureprots_oversea表中各平台的仓库类型
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_sku_oversea/warehouseTypes",method=RequestMethod.GET)
	public List<String> warehouseTypes(@RequestParam(value="platform", required=false)String platform){
        return idosros.selectWarehouseTypes(platform);
	}

	/**
	 * 查询dailyoutskureprots_oversea表中各平台的原仓库类型可与仓库类型级联
	 * @param key
	 * @return
	 */
	@RequestMapping(value="/daily_out_sku_oversea/warehouseNames",method=RequestMethod.GET)
	public List<String> warehouseNames(DailyOutSkuReprots_overseaKey key){
        return idosros.selectWarehouseNames(key);
	}
}
