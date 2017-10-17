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
import com.yks.bi.dto.report.Dailyoutaccountreprots_oversea;
import com.yks.bi.dto.report.Dailyoutaccountreprots_overseaKey;
import com.yks.bi.service.report.IDailyoutaccountreprots_overseaService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@RestController
@RequestMapping(value="/report")
public class Dailyoutaccountreprots_overseaController {

	@Autowired
	private IDailyoutaccountreprots_overseaService idoaros;

	/**
	 * 页面表格的数据
	 * 按条件查询dailyoutaccountreprots_oversea表中所有的数据
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping(value="/daily_out_account_oversea/grid",method=RequestMethod.GET)
	public GridModel AllGrid(Dailyoutaccountreprots_overseaKey key,FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailyoutaccountreprots_oversea> list = idoaros.selectAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	/**
	 * 查询dailyoutaccountreprots_oversea表中各平台的账号
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_account_oversea/accounts",method=RequestMethod.GET)
	public List<String> salesAccounts(String platform){
        return idoaros.selectSalesAccounts(platform);
	}

	/**
	 * 查询dailyoutaccountreprots_oversea表中各平台的仓库类型
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_account_oversea/warehouseType",method=RequestMethod.GET)
	public List<String> warehouseType(String platform){
        return idoaros.selectWarehouseType(platform);
	}

	/**
	 * 查询dailyoutaccountreprots_oversea表中各平台的原仓库类型可与仓库类型级联
	 * @param key
	 * @return
	 */
	@RequestMapping(value="/daily_out_account_oversea/warehouseName",method=RequestMethod.GET)
	public List<String> warehouseName(Dailyoutaccountreprots_overseaKey key){
        return idoaros.selectWarehouseName(key);
	}

	//新平台
	/**
	 * 页面表格的数据
	 * 按条件查询dailyoutaccountreprots_oversea表中新平台所有的数据
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping(value="/daily_out_account_oversea/newPlatform/grid",method=RequestMethod.GET)
	public GridModel newPlatformAllGrid(Dailyoutaccountreprots_overseaKey key,FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailyoutaccountreprots_oversea> list = idoaros.selectNewPlatformAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	/**
	 * 查询dailyoutaccountreprots_oversea表中新平台的账号
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_account_oversea/newPlatform/accounts",method=RequestMethod.GET)
	public List<String> newPlatformSalesAccounts(@RequestParam(value="platform", required=false)String platform){
        return idoaros.selectNewPlatformSalesAccounts(platform);
	}

	/**
	 * 查询dailyoutaccountreprots_oversea表中新平台的平台
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_account_oversea/newPlatform/platform",method=RequestMethod.GET)
	public List<String> newPlatforms(){
        return idoaros.selectNewPlatforms();
	}

	/**
	 * 查询dailyoutaccountreprots_oversea表中新平台的仓库类型
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_account_oversea/newPlatform/warehouseType",method=RequestMethod.GET)
	public List<String> newPlatformWarehouseType(@RequestParam(value="platform", required=false)String platform){
        return idoaros.selectNewPlatformWarehouseType(platform);
	}

	/**
	 * 查询dailyoutaccountreprots_oversea表中新平台的原仓库类型可与平台、仓库类型级联
	 * @param key
	 * @return
	 */
	@RequestMapping(value="/daily_out_account_oversea/newPlatform/warehouseName",method=RequestMethod.GET)
	public List<String> newPlatformWarehouseName(Dailyoutaccountreprots_overseaKey key){
        return idoaros.selectNewPlatformWarehouseName(key);
	}
}
