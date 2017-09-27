package com.unionpay.withhold.trade.pay.dao;

import com.unionpay.withhold.trade.pay.pojo.OrderCollectBatchPayDO;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectBatchPayDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCollectBatchPayDAO {
    long countByExample(OrderCollectBatchPayDOExample example);

    int deleteByExample(OrderCollectBatchPayDOExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(OrderCollectBatchPayDO record);

    int insertSelective(OrderCollectBatchPayDO record);

    List<OrderCollectBatchPayDO> selectByExample(OrderCollectBatchPayDOExample example);

    OrderCollectBatchPayDO selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") OrderCollectBatchPayDO record, @Param("example") OrderCollectBatchPayDOExample example);

    int updateByExample(@Param("record") OrderCollectBatchPayDO record, @Param("example") OrderCollectBatchPayDOExample example);

    int updateByPrimaryKeySelective(OrderCollectBatchPayDO record);

    int updateByPrimaryKey(OrderCollectBatchPayDO record);
}