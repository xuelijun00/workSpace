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
@ResponseBody
@RequestMapping("/report")
public class TargetCompletionRateController {

    @Autowired
    ITargetCompletionRateService targetCompletionRateService;
    /**
     * 表格数据
     * @param month
     * @param platform
     * @return
     */
    @RequestMapping(value = "/targetcompletioncrate/grid" ,method = RequestMethod.GET)
    public List<TargetCompletionRateVo> targetCompletionRate(String month,String platform){
        return targetCompletionRateService.selectAll(month,platform);
    }
    /**
     * 柱状图
     * @param month
     * @param platform
     * @return
     */
    @RequestMapping(value = "/targetcompletioncrate/histogram" ,method = RequestMethod.GET)
    public List<TargetCompletionRate> targetCompletionRate1(String platform){
        return targetCompletionRateService.selectByPrimaryKey(platform);
    }

}
