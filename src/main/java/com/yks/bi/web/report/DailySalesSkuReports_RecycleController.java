package com.yks.bi.web.report;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.DailySalesSkuReports_Recycle;
import com.yks.bi.dto.report.DailySalesSkuReports_RecycleKey;
import com.yks.bi.service.report.IDailySalesSkuReports_RecycleService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

@RestController
@RequestMapping(value="/report")
public class DailySalesSkuReports_RecycleController {

	@Autowired
	private IDailySalesSkuReports_RecycleService idssrrs;
	
	/**
	 * 因为数据库里的report date是字符串类型，且格式是“yyyy-MM-dd_yyyy-MM-dd”，在sql查询时涉及到
	 * 结束时间（endDate）的临界值问题，所有这里的将结束时间（endDate）加了一天，以保证取到临界值
	 * @param key
	 * @throws Exception
	 */
	/*public void dateAddOne(DailySalesSkuReports_RecycleKey key) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = format.parse(key.getEndDate());
		long lon = endDate.getTime() + 24*60*60*1000;
		String endDate1 = format.format(new Date(lon));
		key.setEndDate(endDate1);
	}*/

	@RequestMapping(value="/sku_recycle/amazon/grid",method=RequestMethod.GET)
	public GridModel selectAmazonAllGrid(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{
		
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailySalesSkuReports_Recycle> list = idssrrs.selectAmazonAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/sku_recycle/amazon/chart",method=RequestMethod.GET)
	public List<DailySalesSkuReports_Recycle> selectAmazonAllChart(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("SKU ASC, report_date ASC");
		return idssrrs.selectAmazonAll(key);
	}
	
	@RequestMapping(value="/sku_recycle/ebay/grid",method=RequestMethod.GET)
	public GridModel selectEbayAllGrid(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailySalesSkuReports_Recycle> list = idssrrs.selectEbayAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/sku_recycle/ebay/chart",method=RequestMethod.GET)
	public List<DailySalesSkuReports_Recycle> selectEbayAllChart(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("SKU ASC, report_date ASC");
		return idssrrs.selectEbayAll(key);
	}
	
	@RequestMapping(value="/sku_recycle/lazada/grid",method=RequestMethod.GET)
	public GridModel selectLazadaAllGrid(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailySalesSkuReports_Recycle> list = idssrrs.selectLazadaAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/sku_recycle/lazada/chart",method=RequestMethod.GET)
	public List<DailySalesSkuReports_Recycle> selectLazadaAllChart(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("SKU ASC, report_date ASC");
		return idssrrs.selectLazadaAll(key);
	}
	
	
	
	@RequestMapping(value="/sku_recycle/smt/grid",method=RequestMethod.GET)
	public GridModel selectSmtAllGrid(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailySalesSkuReports_Recycle> list = idssrrs.selectSmtAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/sku_recycle/smt/chart",method=RequestMethod.GET)
	public List<DailySalesSkuReports_Recycle> selectSmtAllChart(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("SKU ASC, report_date ASC");
		return idssrrs.selectSmtAll(key);
	}
	
	@RequestMapping(value="/sku_recycle/walmart/grid",method=RequestMethod.GET)
	public GridModel selectWalmartAllGrid(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailySalesSkuReports_Recycle> list = idssrrs.selectWalmartAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/sku_recycle/walmart/chart",method=RequestMethod.GET)
	public List<DailySalesSkuReports_Recycle> selectWalmartAllChart(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("SKU ASC, report_date ASC");
		return idssrrs.selectWalmartAll(key);
	}
	
	
	@RequestMapping(value="/sku_recycle/wish/grid",method=RequestMethod.GET)
	public GridModel selectWishAllGrid(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailySalesSkuReports_Recycle> list = idssrrs.selectWishAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/sku_recycle/wish/chart",method=RequestMethod.GET)
	public List<DailySalesSkuReports_Recycle> selectWishAllChart(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("SKU ASC, report_date ASC");
		return idssrrs.selectWishAll(key);
	}

/*	@RequestMapping(value="/sku_recycle/business",method=RequestMethod.GET)
	public List<String> selectBusiness(){
		return idssrrs.selectBusiness();
	}*/

	@RequestMapping(value="/sku_recycle/newPlatform/grid",method=RequestMethod.GET)
	public GridModel selectNewPlatformAllGrid(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		PageHelper.startPage(filter.getPage(), filter.getRows(),true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx()) ? filter.getSidx() + " " + filter.getSord() : "");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailySalesSkuReports_Recycle> list = idssrrs.selectNewPlatformAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}

	@RequestMapping(value="/sku_recycle/newPlatform/chart",method=RequestMethod.GET)
	public List<DailySalesSkuReports_Recycle> selectNewPlatformAllChart(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("SKU ASC, report_date ASC");
		return idssrrs.selectNewPlatformAll(key);
	}

	@RequestMapping(value="/sku_recycle/newPlatform/business",method=RequestMethod.GET)
	public List<String> selectNewPlatformBusiness(){
		return idssrrs.selectNewPlatformBusiness();
	}

	@RequestMapping(value="/sku_recycle/newEgg/grid")
	public GridModel selectNewEggAllGrid(DailySalesSkuReports_RecycleKey key,FilterDto filter) throws Exception{

		PageHelper.startPage(filter.getPage(), filter.getRows(),true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx()) ? filter.getSidx() + " " + filter.getSord() : "");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailySalesSkuReports_Recycle> list = idssrrs.selectNewEggAll(key);
		PageInfo<?> pageInfo = new PageInfo<>(list);
		return new GridModel(pageInfo);
	}
	
	@RequestMapping(value="/sku_recycle/newEgg/chart")
	public List<DailySalesSkuReports_Recycle> selectNewEggAllChart(DailySalesSkuReports_RecycleKey key) throws Exception{		

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("SKU ASC, report_date ASC");
		return idssrrs.selectNewEggAll(key);
	}

	@RequestMapping(value="/sku_recycle/newEgg/business",method=RequestMethod.GET)
	public List<String> selectNewEggBusiness(){
		return idssrrs.selectNewEggBusiness();
	}
	
}
