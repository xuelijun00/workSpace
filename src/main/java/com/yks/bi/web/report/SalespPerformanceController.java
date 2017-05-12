package com.yks.bi.web.report;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.ISalespPerformanceService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    ISalespPerformanceService isale;
    /**
     * 表格数据  柱状图
     * @param month
     * @param platform
     * @return
     */
    @RequestMapping(value = "/salespoerformance/grid" ,method = RequestMethod.GET)
    public List<SalesPerformance> salesMethod(String month,Date platform){
      
        return isale.selectAll("a_ll");
    }
    
    @RequestMapping(value = "/ebaydomestic/grid" ,method = RequestMethod.GET)
    public List<SalesPerformance> ebayMethod(String month,Date platform){
     
        return isale.selectAll("ebay");
    }
    
    @RequestMapping(value = "/deebay/grid" ,method = RequestMethod.GET)
    public List<SalesPerformance> deebayMethod(String month,Date platform){
     
        return isale.selectAll("Ebay_PO");
    }
    
    @RequestMapping(value = "/ukebay/grid" ,method = RequestMethod.GET)
    public List<SalesPerformance> ukebayMethod(String month,Date platform){
     
        return isale.selectAll("Ebay_UK");
    }
    
    @RequestMapping(value = "/usebay/grid" ,method = RequestMethod.GET)
    public List<SalesPerformance> usebayMethod(String month,Date platform){
     
        return isale.selectAll("Ebay_US");
    }
  

}
