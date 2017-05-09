package com.yks.bi.service.report.impl;

import com.yks.bi.dao.TargetCompletionRateMapper;
import com.yks.bi.dto.report.TargetCompletionRate;
import com.yks.bi.dto.report.TargetCompletionRateVo;
import com.yks.bi.service.report.ITargetCompletionRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
@Service
public class TargetCompletionRateServiceImpl implements ITargetCompletionRateService {

    @Autowired
    private TargetCompletionRateMapper targetCompletionRateMapper;
    /**
     * 表格数据
     */
    @Override
    public List<TargetCompletionRateVo> selectAll(String month, String platform) {
        return targetCompletionRateMapper.selectAll(month,platform);
    }
    /**
     * 柱状图
     */
    @Override
    public List<TargetCompletionRate> selectByPrimaryKey(String platform) {
        return targetCompletionRateMapper.selectByPrimaryKey(platform);
    }
}
