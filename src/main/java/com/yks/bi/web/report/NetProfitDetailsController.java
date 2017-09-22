package com.yks.bi.web.report;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailyOutSkuReprots;
import com.yks.bi.service.report.INetProfitDetailsService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;
import org.springframework.web.bind.annotation.RestController;

/**
 * 净利润详情
 * @author Administrator
 */
@RestController
@RequestMapping("/report")
public class NetProfitDetailsController {
	
	@Autowired
	private INetProfitDetailsService NetProfit;
	
	/**
	 * 净利润详情
	 * @param key
	 * @param filter
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/profit_details/grid")
	public GridModel selectAccountAchievementServiceGrid(DailyOutSkuReprots key,FilterDto filter) throws ParseException {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailyOutSkuReprots> list = NetProfit.selectAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	
	/**
	 * 查询平台
	 * @return
	 */
	@RequestMapping("/profit_details/platform")
	public List<String> selectPlatform() {
		return NetProfit.selectPlatform();
	}
	
	/**
	 * 查询账号
	 * @param platform
	 * @return
	 */
	@RequestMapping("/profit_details/account")
	public List<String> selectAccount(String platform) {
		return NetProfit.selectAccount(platform);
	}
	/**
	 * 查询主站点
	 * @param platform
	 * @return
	 */
	@RequestMapping("/profit_details/zhuzhandian")
	public List<String> selectZhuzhandian(String platform) {
		return NetProfit.selectZhuzhandian(platform);
	}
	
	@RequestMapping("/profit_details/chart")
	public List<DailyOutSkuReprots> selectProfitChart(DailyOutSkuReprots key) {

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("report_date");
		return NetProfit.selectProfit(key);
	}
	
	@RequestMapping(value="/profit_details/newPlatform/grid")
	public GridModel selectNewPlatformGrid(DailyOutSkuReprots key,FilterDto filter) throws ParseException {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailyOutSkuReprots> list = NetProfit.selectNewPlatformAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	@RequestMapping("/profit_details/newPlatform/chart")
	public List<DailyOutSkuReprots> selectNewPlatformProfitChart(DailyOutSkuReprots key) {

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("report_date");
		return NetProfit.selectNewPlatformProfit(key);
	}

	/**
	 * 查询新平台的平台
	 * @return
	 */
	@RequestMapping("/profit_details/newPlatform/platform")
	public List<String> selectNewPlatform() {
		return NetProfit.selectNewPlatform();
	}

	/**
	 * 查询新平台的账号
	 * @return
	 */
	@RequestMapping("/profit_details/newPlatform/account")
	public List<String> selectNewPlatformAccount(String platform) {
		return NetProfit.selectNewPlatformAccount(platform);
	}

	/**
	 * 查询新平台主站点
	 * @param platform
	 * @return
	 */
	@RequestMapping("/profit_details/newPlatform/zhuzhandian")
	public List<String> selectNewPlatformZhuzhandian(String platform) {
		return NetProfit.selectNewPlatformZhuzhandian(platform);
	}
	
	@RequestMapping(value="/profit_details/newEgg/grid")
	public GridModel selectNewEggformGrid(DailyOutSkuReprots key,FilterDto filter) throws ParseException {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailyOutSkuReprots> list = NetProfit.selectNewEggAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	@RequestMapping("/profit_details/newEgg/chart")
	public List<DailyOutSkuReprots> selectNewEggProfitChart(DailyOutSkuReprots key) {

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("report_date");
		return NetProfit.selectNewEggProfit(key);
	}

	/**
	 * 查询新蛋的账号
	 * @return
	 */
	@RequestMapping("/profit_details/newEgg/account")
	public List<String> selectNewEggAccount(String platform) {
		return NetProfit.selectNewEggAccount(platform);
	}
	
	/**
	 * 查询新蛋主站点
	 * @param platform
	 * @return
	 */
	@RequestMapping("/profit_details/newEgg/zhuzhandian")
	public List<String> selectNewEggZhuzhandian(String platform) {
		return NetProfit.selectNewEggZhuzhandian(platform);
	}
	
	/**
	 * 用于“walmart发货订单净利”页面
	 * 净利润详情
	 * @param key
	 * @param filter
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/profit_details/walmart/grid")
	public GridModel selectWalmartAllGrid(DailyOutSkuReprots key,FilterDto filter) throws ParseException {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}		

		List<DailyOutSkuReprots> list = NetProfit.selectWalmartAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	@RequestMapping("/profit_details/walmart/chart")
	public List<DailyOutSkuReprots> selectWalmartProfitChart(DailyOutSkuReprots key) {

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("report_date");
		return NetProfit.selectWalmartProfit(key);
	}

	/**
	 * 用于“walmart发货订单净利”页面
	 * 查询账号
	 * @return
	 */
	@RequestMapping("/profit_details/walmart/account")
	public List<String> selectWalmartAccount() {
		return NetProfit.selectWalmartAccount();
	}

}
