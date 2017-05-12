package com.yks.bi.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yks.bi.dto.report.Dailysalesskureports;
import com.yks.bi.dto.report.DailysalesskureportsKey;

public interface DailysalesskureportsMapper {
    int deleteByPrimaryKey(DailysalesskureportsKey key);

    int insert(Dailysalesskureports record);

    int insertSelective(Dailysalesskureports record);

    Dailysalesskureports selectByPrimaryKey(DailysalesskureportsKey key);  

    List<Dailysalesskureports> selectAll(@Param("business")String business,@Param("sku")String sku,@Param("sku_old")String sku_old,@Param("start_date")Date start_date,@Param("end_date")Date end_date);
    
    int updateByPrimaryKeySelective(Dailysalesskureports record);

    int updateByPrimaryKey(Dailysalesskureports record);
}