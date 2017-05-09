package com.yks.bi.service.report;

import com.yks.bi.dto.report.TargetCompletionRate;
import com.yks.bi.dto.report.TargetCompletionRateVo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface ITargetCompletionRateService {
    List<TargetCompletionRateVo> selectAll(String month, String platform);

    List<TargetCompletionRate> selectByPrimaryKey(String platform);
}
