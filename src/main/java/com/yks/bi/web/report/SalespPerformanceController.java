package com.yks.bi.web.report;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.ISalespPerformanceService;

import java.text.ParseException;
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
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
    /**
     * 表格数据  柱状图
     * @param month
     * @param platform
     * @return
     * @throws ParseException 
     */                          
    @RequestMapping(value = "/dailysales/grid" ,method = RequestMethod.GET)
    public List<SalesPerformance> dailysalesMethod(String business,String st,String et) throws ParseException{
     
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
        return isale.selectAll(business,starttime,endtime);
    }

}
