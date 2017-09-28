package com.unionpay.withhold.trade.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDOExample;

public interface OrderCollectDetaPayDAO {
    long countByExample(OrderCollectDetaPayDOExample example);

    int deleteByExample(OrderCollectDetaPayDOExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(OrderCollectDetaPayDO record);

    int insertSelective(OrderCollectDetaPayDO record);

    List<OrderCollectDetaPayDO> selectByExample(OrderCollectDetaPayDOExample example);

    OrderCollectDetaPayDO selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") OrderCollectDetaPayDO record, @Param("example") OrderCollectDetaPayDOExample example);

    int updateByExample(@Param("record") OrderCollectDetaPayDO record, @Param("example") OrderCollectDetaPayDOExample example);

    int updateByPrimaryKeySelective(OrderCollectDetaPayDO record);

    int updateByPrimaryKey(OrderCollectDetaPayDO record);
    
    List<OrderCollectDetaPayDO> queryCollectOrderDeta(Long batchId);
    
    int updateOrderStatus(OrderCollectDetaPayDO record);
}