package com.yks.bi.web.report;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.ISalespPerformanceService;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
@Controller
@ResponseBody
@RequestMapping("/report")
public class SalespPerformanceController {

    @Autowired
    private ISalespPerformanceService isale;
    private static final String YYYYMMDD = "yyyy-MM-dd";
    /**
     * 表格数据  柱状图
     * @param month
     * @param platform
     * @return
     * @throws ParseException 
     * @throws UnsupportedEncodingException 
     */                          
    @RequestMapping(value = "/dailysales/grid" ,method = RequestMethod.GET)
    public List<SalesPerformance> dailysalesMethod(String business,String st,String et) throws ParseException, UnsupportedEncodingException{
    	if(StringUtils.isNotEmpty(business)){
    		business = new String(business.getBytes("ISO-8859-1"),"UTF-8"); 
    	}
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
    
    @RequestMapping(value = "/dailysales/platforms" ,method = RequestMethod.GET)
    public List<String> platforms(){
        return isale.selectPlatforms();
    }

}
