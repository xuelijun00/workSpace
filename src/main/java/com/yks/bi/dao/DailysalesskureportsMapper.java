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

    List<Dailysalesskureports> selectAll(@Param("business")String business,@Param("start_date")Date start_date,@Param("end_date")Date end_date,@Param("sku")String sku,@Param("sku_old")String sku_old);
    
    
    //查询ebaydailysalesskureports表中的所有信息
    List<Dailysalesskureports> selectEbay(@Param("business")String business,@Param("start_date")Date start_date,@Param("end_date")Date end_date,@Param("sku")String sku,@Param("sku_old")String sku_old);
    
    List<Dailysalesskureports> selectskuAll(@Param("business")String business,@Param("start_date")Date start_date,@Param("end_date")Date end_date,@Param("sku")String sku,@Param("sku_old")String sku_old);
    
    List<String> selectskuPlatforms();
    
    int updateByPrimaryKeySelective(Dailysalesskureports record);

    int updateByPrimaryKey(Dailysalesskureports record);
}