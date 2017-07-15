package com.yks.bi.web.report;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.Dailysalesskureports;
import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.IEbayDomesticService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/8.
 */
@RestController
@RequestMapping("/report")
public class EbayDomesticController {

    @Autowired
    IEbayDomesticService isale;
    private static final String YYYYMMDD = "yyyy-MM-dd";
    /**
     * 表格数据  柱状图
     * @param month
     * @param platform
     * @return
     */
   
    @RequestMapping(value = "/ebay_domestic/sku/grid" ,method = RequestMethod.GET)
    public GridModel ebayoverseasMethod(String business,String st,String et,String sku,String oldsku,FilterDto filter) throws ParseException{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailysalesskureports> list = isale.selectskuAll(business, starttime, endtime, sku, oldsku);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
      
    }
    
    @RequestMapping(value = "/ebay_domestic/smtSku/grid" ,method = RequestMethod.GET)
    public GridModel smtSkuMethod(String st,String et,String sku,String oldsku,FilterDto filter) throws ParseException{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailysalesskureports> list = isale.selectSmtSku(starttime, endtime, sku, oldsku);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
    	Map<String,Object> userdata = new HashMap<String,Object>();
    	int sumOrders = 0;
    	int sumQuantity = 0;
    	double sumSales = 0;
    	for (Dailysalesskureports Dailysalesskureports : list) {
    		sumOrders += Dailysalesskureports.getOrders();
    		sumQuantity += Dailysalesskureports.getQuantity();
    		sumSales += Dailysalesskureports.getSales();
		}
    	userdata.put("reportDate1", "合计：");
    	userdata.put("orders", sumOrders);
    	userdata.put("quantity", sumQuantity);
    	userdata.put("sales", sumSales);
        return new GridModel(pageInfo,userdata);
      
    }
    
    @RequestMapping(value = "/ebay_domestic/wishSku/grid" ,method = RequestMethod.GET)
    public GridModel WishSkuMethod(String st,String et,String sku,String oldsku,FilterDto filter) throws ParseException{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailysalesskureports> list = isale.selectWishSku(starttime, endtime, sku, oldsku);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
    	Map<String,Object> userdata = new HashMap<String,Object>();
    	int sumOrders = 0;
    	int sumQuantity = 0;
    	double sumSales = 0;
    	for (Dailysalesskureports Dailysalesskureports : list) {
    		sumOrders += Dailysalesskureports.getOrders();
    		sumQuantity += Dailysalesskureports.getQuantity();
    		sumSales += Dailysalesskureports.getSales();
		}
    	userdata.put("reportDate1", "合计：");
    	userdata.put("orders", sumOrders);
    	userdata.put("quantity", sumQuantity);
    	userdata.put("sales", sumSales);
        return new GridModel(pageInfo,userdata);
      
    }
    
    //用于ebay的 sku销售报表
    @RequestMapping(value = "/ebay_domestic/sku/gridEbay" ,method = RequestMethod.GET)
    public GridModel ebayoverseasMethodEbay(String business,String st,String et,String sku,String oldsku,FilterDto filter) throws ParseException{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailysalesskureports> list = isale.selectEbay(business, starttime, endtime, sku, oldsku);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
      
    }
    
    
    @RequestMapping(value = "/ebay_domestic/category/grid" ,method = RequestMethod.GET)
    public GridModel ebayoverseascategoryMethod(String business,String st,String et,String oldsku,String category,FilterDto filter) throws ParseException, UnsupportedEncodingException{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailysalescategoryreports> list = isale.selectcategoryAll(business, starttime, endtime, category);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
      
    }
    
    
    @RequestMapping(value = "/ebay_domestic/categorynew/grid" ,method = RequestMethod.GET)
    public GridModel ebayoverseascategoryMethodnew(String business,String st,String et,String category,FilterDto filter) throws ParseException, UnsupportedEncodingException{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailysalescategoryreports> list = isale.selectcategorynewAll(business, starttime, endtime, category);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
      
    }
    
    
    @RequestMapping(value = "/ebay_domestic/platforms/platformnew" ,method = RequestMethod.GET)
    public List<String> newplatforms(){
        return isale.selectnewPlatforms();
    }
    

    @RequestMapping(value = "/ebay_domestic/skunew/grid" ,method = RequestMethod.GET)
    public GridModel skuMethodnew(String business,String st,String et,String sku,String oldsku,FilterDto filter) throws ParseException{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<Dailysalesskureports> list = isale.selectskunewAll(business, starttime, endtime, sku, oldsku);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
      
    }
    
    
    
    @RequestMapping(value = "/ebay_domestic/skuplatforms/platformnew" ,method = RequestMethod.GET)
    public List<String> newskuplatforms(){
        return isale.selectskuPlatforms();
    }
    
}
