package com.yks.bi.web.report;


import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.DailysalescategoryreportsKey;
import com.yks.bi.dto.report.Dailysalesskureports;
import com.yks.bi.service.report.IEbayDomesticService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

/**
 * Created by Administrator on 2017/5/8.
 */
@RestController
@RequestMapping("/report")
public class EbayDomesticController {

    @Autowired
    IEbayDomesticService isale;
    
    /**
     * 页面表格表脚的合计行
     * 用于计算页面该页面展示出的数据的合计
     * @param list
     * @return
     */
    public Map<String,Object> total(List<Dailysalesskureports> list){
    	Map<String,Object> userdata = new HashMap<String,Object>();
    	int sumOrders = 0;
    	int sumQuantity = 0;
    	double sumSales = 0;
    	for (Dailysalesskureports dailysalesskureports : list) {
    		sumOrders += dailysalesskureports.getOrders();
    		sumQuantity += dailysalesskureports.getQuantity();
    		sumSales += dailysalesskureports.getSales();
		}
    	userdata.put("reportDate", "合计：");
    	userdata.put("orders", sumOrders);
    	userdata.put("quantity", sumQuantity);
    	userdata.put("sales", sumSales);
    	return userdata;
    }

    /**
     * 表格数据  柱状图
     * @param month
     * @param platform
     * @return
     */
    @RequestMapping(value = "/ebay_domestic/sku/grid" ,method = RequestMethod.GET)
    public GridModel ebayoverseasMethodGrid(Dailysalesskureports record,FilterDto filter) throws ParseException{
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	List<Dailysalesskureports> list = isale.selectskuAll(record);
    	PageInfo<?> pageInfo = new PageInfo<>(list);

    	Map<String,Object> userdata = total(list);
        return new GridModel(pageInfo,userdata);
    }

    @RequestMapping(value = "/ebay_domestic/sku/chart" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> ebayoverseasMethodChart(Dailysalesskureports record) throws Exception{

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	PageHelper.orderBy("report_date");
    	return isale.selectAllSum(record);
    }

    @RequestMapping(value = "/ebay_domestic/smtSku/grid" ,method = RequestMethod.GET)
    public GridModel smtSkuMethodGrid(Dailysalesskureports record,FilterDto filter) throws ParseException{
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	List<Dailysalesskureports> list = isale.selectSmtSku(record);
    	PageInfo<?> pageInfo = new PageInfo<>(list);

    	Map<String,Object> userdata = total(list);
        return new GridModel(pageInfo,userdata);
    }

    @RequestMapping(value = "/ebay_domestic/smtSku/chart" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> smtSkuMethodChart(Dailysalesskureports record) throws Exception{

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	PageHelper.orderBy("report_date");
    	return isale.selectSmtSkuSum(record);
    }

    @RequestMapping(value = "/ebay_domestic/wishSku/grid" ,method = RequestMethod.GET)
    public GridModel WishSkuMethodGrid(Dailysalesskureports record,FilterDto filter) throws ParseException{
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	List<Dailysalesskureports> list = isale.selectWishSku(record);
    	PageInfo<?> pageInfo = new PageInfo<>(list);

    	Map<String,Object> userdata = total(list);
        return new GridModel(pageInfo,userdata);
    }

    @RequestMapping(value = "/ebay_domestic/wishSku/chart" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> WishSkuMethodChart(Dailysalesskureports record) throws Exception{

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	PageHelper.orderBy("report_date");
    	return isale.selectWishSkuSum(record);
    }

    //用于ebay的 sku销售报表
    @RequestMapping(value = "/ebay_domestic/sku/gridEbay" ,method = RequestMethod.GET)
    public GridModel ebayDomesticMethodGrid(Dailysalesskureports record,FilterDto filter) throws ParseException{
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	List<Dailysalesskureports> list = isale.selectEbay(record);
    	PageInfo<?> pageInfo = new PageInfo<>(list);

    	Map<String,Object> userdata = total(list);
        return new GridModel(pageInfo, userdata);
    }

    @RequestMapping(value = "/ebay_domestic/sku/chartEbay" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> ebayDomesticMethodChart(Dailysalesskureports record) throws Exception{

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	PageHelper.orderBy("report_date");
    	return isale.selectEbaySum(record);
    }

    @RequestMapping(value = "/ebay_domestic/category/grid" ,method = RequestMethod.GET)
    public GridModel ebayoverseascategoryMethod(DailysalescategoryreportsKey key,FilterDto filter) throws ParseException, UnsupportedEncodingException{
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailysalescategoryreports> list = isale.selectcategoryAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo); 
    }

    @RequestMapping(value = "/ebay_domestic/categorynew/grid" ,method = RequestMethod.GET)
    public GridModel ebayoverseascategoryMethodnew(DailysalescategoryreportsKey key,FilterDto filter) throws ParseException, UnsupportedEncodingException{
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailysalescategoryreports> list = isale.selectcategorynewAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
    }

    @RequestMapping(value = "/ebay_domestic/category/business" ,method = RequestMethod.GET)
    public List<String> selectCategoryBusiness(){
        return isale.selectBusiness();
    }

    @RequestMapping(value = "/ebay_domestic/platforms/platformnew" ,method = RequestMethod.GET)
    public List<String> selectCategoryNewPlatformBusiness(){
        return isale.selectnewPlatforms();
    }

    @RequestMapping(value = "/ebay_domestic/skunew/grid" ,method = RequestMethod.GET)
    public GridModel newPlatformSkuGrid(Dailysalesskureports record,FilterDto filter) throws ParseException{
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	List<Dailysalesskureports> list = isale.selectskunewAll(record);
    	PageInfo<?> pageInfo = new PageInfo<>(list);

    	Map<String,Object> userdata = total(list);
        return new GridModel(pageInfo,userdata);
    }

    @RequestMapping(value = "/ebay_domestic/skunew/chart" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> newPlatformSkuChart(Dailysalesskureports record) throws Exception{

    	if (record.getSku() != null && record.getSku().length() > 0) {
			String [] skuArray = record.getSku().split(",");
			record.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

    	PageHelper.orderBy("report_date");
    	return isale.selectskuNewAllSum(record);
    }

    @RequestMapping(value = "/ebay_domestic/skuplatforms/platformnew" ,method = RequestMethod.GET)
    public List<String> newskuplatforms(){
        return isale.selectskuPlatforms();
    }

}
