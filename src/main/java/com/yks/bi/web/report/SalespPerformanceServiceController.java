package com.yks.bi.web.report;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yks.bi.dto.report.SalesPerformance;
import com.yks.bi.service.report.ISalespPerformanceService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
@Controller
@ResponseBody
@RequestMapping("/report")
public class SalespPerformanceServiceController {

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
        Calendar c = Calendar.getInstance();
        //过去15天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 14);
        Date d = c.getTime();
        return isale.selectAll(d);
    }
  

}
