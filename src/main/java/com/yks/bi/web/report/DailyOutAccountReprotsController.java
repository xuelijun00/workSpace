package com.yks.bi.web.report;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutAccountReprots;
import com.yks.bi.dto.report.DailyOutAccountReprotsKey;
import com.yks.bi.service.report.IDailyOutAccountReprotsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@RestController
@RequestMapping(value="/report")
public class DailyOutAccountReprotsController {
	
	@Autowired
	private IDailyOutAccountReprotsService idoars;
	
	/**
	 * 查询dailyoutaccountreprots表中所有的平台
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/platforms",method=RequestMethod.GET)
	public List<String> selectPlatforms(){
        return idoars.selectPlatforms();
	}
	
	/**
	 * 查询dailyoutaccountreprots表中所有的账号
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/accounts",method=RequestMethod.GET)
	public List<String> selectSalesAccounts(String platform){
        return idoars.selectSalesAccounts(platform);
	}
	
	/**
	 * 查询dailyoutaccountreprots表中所有的分类
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/categorys",method=RequestMethod.GET)
	public List<String> selectCategorys(String platform){
        return idoars.selectCategorys(platform);
	}
	
	/**
	 * 页面表格的数据
	 * 按条件查询dailyoutaccountreprots表中所有的数据
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/grid",method=RequestMethod.GET)
	public GridModel selectAll(DailyOutAccountReprotsKey key,FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutAccountReprots> list = idoars.selectAllByPrimaryKey(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	/**
	 * 饼图数据
	 * 暂时用来查询smt的品类和按品类和时间段汇总的税后综合净利
	 * @param key
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/chart",method=RequestMethod.GET)
	public List<DailyOutAccountReprots> profitSumChart(DailyOutAccountReprotsKey key){
		return idoars.selectProfitSum(key);
	}

	/**
	 * 查询dailyoutaccountreprots表中新平台的平台
	 * @param platform
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/newPlatform/platforms",method=RequestMethod.GET)
	public List<String> selectNewPlatforms(){
        return idoars.selectNewPlatforms();
	}
	
	/**
	 * 查询dailyoutaccountreprots表中新平台的账号
	 * @param salesAccounts
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/newPlatform/accounts",method=RequestMethod.GET)
	public List<String> selectNewPlatformSalesAccounts(String platform){
        return idoars.selectNewPlatformSalesAccounts(platform);
	}
	
	/**
	 * 页面表格的数据
	 * 按条件查询dailyoutaccountreprots表中新平台所有的数据
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/newPlatform/grid",method=RequestMethod.GET)
	public GridModel selectNewPlatformAll(DailyOutAccountReprotsKey key,FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutAccountReprots> list = idoars.selectNewPlatformAllByPrimaryKey(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	
	/**
	 * 查询dailyoutaccountreprots表中新蛋的账号
	 * @param salesAccounts
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/newEgg/accounts",method=RequestMethod.GET)
	public List<String> selectNewEggSalesAccounts(String platform){
        return idoars.selectNewEggSalesAccounts(platform);
	}
	
	/**
	 * 页面表格的数据
	 * 按条件查询dailyoutaccountreprots表中新蛋所有的数据
	 * @param key
	 * @param filter
	 * @return
	 */
	@RequestMapping(value="/daily_out_account/newEgg/grid",method=RequestMethod.GET)
	public GridModel selectNewEggAll(DailyOutAccountReprotsKey key,FilterDto filter){
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<DailyOutAccountReprots> list = idoars.selectNewEggAllByPrimaryKey(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
}
