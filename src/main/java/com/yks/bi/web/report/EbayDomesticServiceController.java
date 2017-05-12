package com.yks.bi.web.report;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.Dailysalesskureports;
import com.yks.bi.service.report.IEbayDomesticService;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
@Controller
@ResponseBody
@RequestMapping("/report")
public class EbayDomesticServiceController {

    @Autowired
    IEbayDomesticService isale;
    /**
     * 表格数据  柱状图
     * @param month
     * @param platform
     * @return
     */
   
    @RequestMapping(value = "/ebaydomesticsku/grid" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> ebayskuMethod(String month,Date platform){
        return isale.selectskuAll("ebay");
    }
  
    
    @RequestMapping(value = "/ebaydomesticcategory/grid" ,method = RequestMethod.GET)
    public List<Dailysalescategoryreports> ebaycategoryMethod(String month,Date platform){
        return isale.selectcategoryAll("ebay");
    }
    
    @RequestMapping(value = "/deebaysku/grid" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> deebayskuMethod(String month,Date platform){
        return isale.selectskuAll("Ebay_PO");
    }
  
    
    @RequestMapping(value = "/deebaycategory/grid" ,method = RequestMethod.GET)
    public List<Dailysalescategoryreports> deebaycategoryMethod(String month,Date platform){
        return isale.selectcategoryAll("Ebay_PO");
    }
    
    @RequestMapping(value = "/ukebaysku/grid" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> ukebayskuMethod(String month,Date platform){
        return isale.selectskuAll("Ebay_UK");
    }
  
    
    @RequestMapping(value = "/ukebaycategory/grid" ,method = RequestMethod.GET)
    public List<Dailysalescategoryreports> ukebaycategoryMethod(String month,Date platform){
        return isale.selectcategoryAll("Ebay_UK");
    }
    
    @RequestMapping(value = "/usebaysku/grid" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> usebayskuMethod(String month,Date platform){
        return isale.selectskuAll("Ebay_US");
    }
  
    
    @RequestMapping(value = "/usebaycategory/grid" ,method = RequestMethod.GET)
    public List<Dailysalescategoryreports> usebaycategoryMethod(String month,Date platform){
        return isale.selectcategoryAll("Ebay_US");
    }
    

}
