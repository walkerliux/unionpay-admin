package com.unionpay.withhold.trade.task.dao;

import com.unionpay.withhold.trade.task.pojo.OrderCollectBatchTaskDO;
import com.unionpay.withhold.trade.task.pojo.OrderCollectBatchTaskDOExample;
import java.util.List;

public interface OrderCollectBatchTaskDAO {
    int deleteByPrimaryKey(Long tid);

    int insert(OrderCollectBatchTaskDO record);

    int insertSelective(OrderCollectBatchTaskDO record);

    List<OrderCollectBatchTaskDO> selectByExample(OrderCollectBatchTaskDOExample example);

    OrderCollectBatchTaskDO selectByPrimaryKey(Long tid);

    int updateByPrimaryKeySelective(OrderCollectBatchTaskDO record);

    int updateByPrimaryKey(OrderCollectBatchTaskDO record);
}