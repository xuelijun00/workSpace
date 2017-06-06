package com.yks.bi.web.report;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.ISalespPerformanceService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 * 销售业绩整体报表
 */
@RestController
@RequestMapping("/report")
public class SalesPerformanceController {

    @Autowired
    private ISalespPerformanceService isale;
    private static final String YYYYMMDD = "yyyy-MM-dd";
    /**
     * 表格数据  柱状图
     * 销售业绩整体报表
     * @param month
     * @param platform
     * @return
     * @throws ParseException 
     * @throws UnsupportedEncodingException 
     * @throws JsonProcessingException 
     */                          
    @RequestMapping(value = "/dailysales/grid" ,method = RequestMethod.GET)
    public GridModel dailysalesMethod(String business,String st,String et,FilterDto filter) throws Exception{
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
    	List<SalesPerformance> list = isale.selectAll(business,starttime,endtime);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
    }
    
    /**
     * 销售业绩整体报表
     * @param business
     * @param st
     * @param et
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dailysales/chart" ,method = RequestMethod.GET)
    public List<SalesPerformance> chart(String business,String st,String et) throws Exception{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	return isale.selectAll(business,starttime,endtime);
    }
    /**
     * 查询平台
     * @return
     */
    @RequestMapping(value = "/dailysales/platforms" ,method = RequestMethod.GET)
    public List<String> platforms(){
        return isale.selectPlatforms();
    }
    /**
     * 新平台销售业绩
     * @param business
     * @param st
     * @param et
     * @param filter
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dailysalesnew/grid" ,method = RequestMethod.GET)
    public GridModel dailysalesnewMethod(String business,String st,String et,FilterDto filter) throws Exception{
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
    	List<SalesPerformance> list = isale.selectnewAll(business,starttime,endtime);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
    }
    /**
     *  新平台销售业绩
     * @param business
     * @param st
     * @param et
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dailysalesnew/chart" ,method = RequestMethod.GET)
    public List<SalesPerformance> newchart(String business,String st,String et) throws Exception{
    	Date starttime = null;
    	if(StringUtils.isNotEmpty(st)){
    		starttime = DateUtils.parseDate(st, YYYYMMDD);
    	}
    	Date endtime = null;
    	if(StringUtils.isNotEmpty(et)){
    		endtime = DateUtils.parseDate(et, YYYYMMDD);
    	}
    	return isale.selectnewAll(business,starttime,endtime);
    }
    /**
     * 新平台
     * @return
     */
    @RequestMapping(value = "/dailysalesnew/platformnew" ,method = RequestMethod.GET)
    public List<String> newplatforms(){
        return isale.selectnewPlatforms();
    }

}
