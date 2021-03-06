package com.yks.bi.web.report;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.dto.report.ConfigPlatformGoalNew;
import com.yks.bi.service.report.ITargetCompletionRateService;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;
import com.yks.bi.web.vo.MessageVo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liuxing on 2017/5/8.
 * 各平台各月业绩完成率 
 */
@RestController
@RequestMapping("/report")
public class TargetCompletionRateController {

    @Autowired
    ITargetCompletionRateService targetCompletionRateService;
    /**
     * 表格数据
     * 各平台各月业绩完成率 （总）
     * @param month
     * @param platform
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/targetcompletioncrate/grid" ,method = RequestMethod.GET)
    public GridModel targetCompletionRate(String month,String name,FilterDto filter){
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<ConfigPlatformGoalNew> list = targetCompletionRateService.selectAll(month,name);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
    }
    /**
     * 柱状图
     * 各平台各月业绩完成率 （总）
     * @param month
     * @param platform
     * @return
     */
    @RequestMapping(value = "/targetcompletioncrate/histogram" ,method = RequestMethod.GET)
    public List<ConfigPlatformGoalNew> targetCompletionRate1(String month,String name){
        return targetCompletionRateService.selectAll(month,name);
    }
    
    /**
     * 查询平台
     * @return
     */
    @RequestMapping(value = "/targetcompletioncrate/platform" ,method = RequestMethod.GET)
    public List<String> selectPlatform(){
    	return targetCompletionRateService.selectPlatform();
    }
    
    /**
     * 新增业绩目标
     * @param record
     * @return
     */
    @RequestMapping(value = "/targetcompletioncrate/update" ,method = RequestMethod.POST)
    public MessageVo update(ConfigPlatformGoalNew record){
    	int i = targetCompletionRateService.updateSelective(record);
    	if(i > 0){
    		return new MessageVo(200, "新增成功");
    	}else{
    		return new MessageVo(500, "新增失败");
    	}
    }

    /**
     * 表格数据
     * 各平台各月业绩完成率 
     * @param month
     * @param platform
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/targetcompletioncrate/branch/grid" ,method = RequestMethod.GET)
    public GridModel grid(String name, String startMonth,String endMonth,FilterDto filter){
    	PageHelper.startPage(filter.getPage(), filter.getRows(), true);
    	PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");
    	List<ConfigPlatformGoalNew> list = targetCompletionRateService.selectBranchAll(name, startMonth, endMonth);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
    }
    /**
     * 柱状图
     * 各平台各月业绩完成率 
     * @param month
     * @param platform
     * @return
     */
    @RequestMapping(value = "/targetcompletioncrate/branch/histogram" ,method = RequestMethod.GET)
    public List<ConfigPlatformGoalNew> chart(String name, String startMonth, String endMonth){
    	PageHelper.orderBy("name");
    	return targetCompletionRateService.selectBranchAll(name, startMonth, endMonth);
    }
}
