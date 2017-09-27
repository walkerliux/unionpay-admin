package com.unionpay.withhold.trade.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDOExample;

public interface OrderCollectSingleDAO {
    long countByExample(OrderCollectSingleDOExample example);

    int deleteByExample(OrderCollectSingleDOExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(OrderCollectSingleDO record);

    int insertSelective(OrderCollectSingleDO record);

    List<OrderCollectSingleDO> selectByExample(OrderCollectSingleDOExample example);

    OrderCollectSingleDO selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") OrderCollectSingleDO record, @Param("example") OrderCollectSingleDOExample example);

    int updateByExample(@Param("record") OrderCollectSingleDO record, @Param("example") OrderCollectSingleDOExample example);

    int updateByPrimaryKeySelective(OrderCollectSingleDO record);

    int updateByPrimaryKey(OrderCollectSingleDO record);
    
    OrderCollectSingleDO getCollctSingleOrder(OrderCollectSingleDO record);
    
    OrderCollectSingleDO queryCollctSingleOrder(OrderCollectSingleDO record);
    
    void updateBySelective(OrderCollectSingleDO record);
}