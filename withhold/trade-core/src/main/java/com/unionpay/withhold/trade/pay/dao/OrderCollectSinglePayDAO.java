package com.unionpay.withhold.trade.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.trade.pay.pojo.OrderCollectSinglePayDO;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectSinglePayDOExample;

public interface OrderCollectSinglePayDAO {
    long countByExample(OrderCollectSinglePayDOExample example);

    int deleteByExample(OrderCollectSinglePayDOExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(OrderCollectSinglePayDO record);

    int insertSelective(OrderCollectSinglePayDO record);

    List<OrderCollectSinglePayDO> selectByExample(OrderCollectSinglePayDOExample example);

    OrderCollectSinglePayDO selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") OrderCollectSinglePayDO record, @Param("example") OrderCollectSinglePayDOExample example);

    int updateByExample(@Param("record") OrderCollectSinglePayDO record, @Param("example") OrderCollectSinglePayDOExample example);

    int updateByPrimaryKeySelective(OrderCollectSinglePayDO record);

    int updateByPrimaryKey(OrderCollectSinglePayDO record);
    
    OrderCollectSinglePayDO querySingleOrder(OrderCollectSinglePayDO record);
}