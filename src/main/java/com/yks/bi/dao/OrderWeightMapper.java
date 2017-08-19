package com.yks.bi.dao;

import java.util.List;

import com.yks.bi.common.excelutil.OrderWeight;

public interface OrderWeightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderWeight record);

    int insertSelective(OrderWeight record);
    
    void insertBatch(List<OrderWeight> record);

    OrderWeight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderWeight record);

    int updateByPrimaryKey(OrderWeight record);
}