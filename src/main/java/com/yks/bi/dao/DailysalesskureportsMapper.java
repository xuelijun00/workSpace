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

    List<Dailysalesskureports> selectAll(Dailysalesskureports record);
    
    
    //查询ebaydailysalesskureports表中的所有信息
    List<Dailysalesskureports> selectEbay(Dailysalesskureports record);
    
    List<Dailysalesskureports> selectSmtSku(Dailysalesskureports record);
    
    List<Dailysalesskureports> selectWishSku(Dailysalesskureports record);
    
    //查询新平台sku的所有数据
    List<Dailysalesskureports> selectskuAll(Dailysalesskureports record);
    
    //查询新平台的平台
    List<String> selectskuPlatforms();
    
    int updateByPrimaryKeySelective(Dailysalesskureports record);

    int updateByPrimaryKey(Dailysalesskureports record);

	List<Dailysalesskureports> selectskuNewAllSum(Dailysalesskureports record);

	List<Dailysalesskureports> selectWishSkuSum(Dailysalesskureports record);

	List<Dailysalesskureports> selectSmtSkuSum(Dailysalesskureports record);

	List<Dailysalesskureports> selectAllSum(Dailysalesskureports record);

	List<Dailysalesskureports> selectEbaySum(Dailysalesskureports record);
}