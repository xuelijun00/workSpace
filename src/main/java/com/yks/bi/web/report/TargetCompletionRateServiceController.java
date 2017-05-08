package com.yks.bi.web.report;

import com.yks.bi.dto.report.TargetCompletionRate;
import com.yks.bi.dto.report.TargetCompletionRateVo;
import com.yks.bi.service.report.ITargetCompletionRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
@Controller
@RequestMapping("/report")
public class TargetCompletionRateServiceController {

    @Autowired
    ITargetCompletionRateService targetCompletionRateService;

    @ResponseBody
    @RequestMapping(value = "/targetcompletioncrate" ,method = RequestMethod.GET)
    public List<TargetCompletionRateVo> targetCompletionRate(String month,String platform){
        return targetCompletionRateService.selectAll(month,platform);
    }

}
