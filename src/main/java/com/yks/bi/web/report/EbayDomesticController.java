package com.yks.bi.web.report;


import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yks.bi.dto.report.Dailysalescategoryreports;
import com.yks.bi.dto.report.Dailysalesskureports;
import com.yks.bi.service.report.IEbayDomesticService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
@Controller
@ResponseBody
@RequestMapping("/report")
public class EbayDomesticController {

    @Autowired
    IEbayDomesticService isale;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
    /**
     * 表格数据  柱状图
     * @param month
     * @param platform
     * @return
     */
   
    @RequestMapping(value = "/ebayoverseassku/grid" ,method = RequestMethod.GET)
    public List<Dailysalesskureports> ebayoverseasMethod(String business,String st,String et,String sku,String oldsku) throws ParseException{
    	Date starttime = null;
    	if(st !=null&& st.trim().length()>0){
    		 String stt = st+" 00:00:00";
    		 starttime= sdf.parse(stt);
    	}
       
    	Date endtime = null;
    	if(et !=null&& et.trim().length()>0){
    		 String ett = et+" 00:00:00";
    		 endtime= sdf.parse(ett);
    	}
        return isale.selectskuAll(business, starttime, endtime, sku, oldsku);
    }
    
    
    @RequestMapping(value = "/ebayoverseascategory/grid" ,method = RequestMethod.GET)
    public List<Dailysalescategoryreports> ebayoverseascategoryMethod(String business,String st,String et,String oldsku,String category) throws ParseException{
    	Date starttime = null;
    	if(st !=null&& st.trim().length()>0){
    		 String stt = st+" 00:00:00";
    		 starttime= sdf.parse(stt);
    	}
       
    	Date endtime = null;
    	if(et !=null&& st.trim().length()>0){
    		 String ett = et+" 00:00:00";
    		 endtime= sdf.parse(ett);
    	}
        return isale.selectcategoryAll(business, starttime, endtime, oldsku, category);
    }
    
    

}
