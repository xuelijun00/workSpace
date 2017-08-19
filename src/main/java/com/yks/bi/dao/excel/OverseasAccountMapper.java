package com.yks.bi.dao.excel;

import java.util.List;

import com.yks.bi.dto.excel.OverseasAccount;

public interface OverseasAccountMapper {
    int deleteByPrimaryKey(String account);

    int insert(OverseasAccount record);

    int insertSelective(OverseasAccount record);
    
    void insertBatch(List<OverseasAccount> record);

    OverseasAccount selectByPrimaryKey(String account);

    int updateByPrimaryKeySelective(OverseasAccount record);

    int updateByPrimaryKey(OverseasAccount record);
}