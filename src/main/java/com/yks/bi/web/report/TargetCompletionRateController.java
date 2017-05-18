package com.yks.bi.web.report;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.TargetCompletionRate;
import com.yks.bi.dto.report.TargetCompletionRateVo;
import com.yks.bi.service.report.ITargetCompletionRateService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;

import org.apache.commons.lang3.StringUtils;
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
    public GridModel targetCompletionRate(String month,String platform,FilterDto filter){
    	if(StringUtils.isNotEmpty(filter.getSidx()) && filter.getSidx().equals("report_date1")){
			filter.setSidx("report_date");
		}
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<TargetCompletionRateVo> list = targetCompletionRateService.selectAll(month,platform);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
    }
    /**
     * 柱状图
     * @param month
     * @param platform
     * @return
     */
    @RequestMapping(value = "/targetcompletioncrate/histogram" ,method = RequestMethod.GET)
    public List<TargetCompletionRate> targetCompletionRate1(String platform,FilterDto filter){
        return targetCompletionRateService.selectByPrimaryKey(platform);
    }

}
