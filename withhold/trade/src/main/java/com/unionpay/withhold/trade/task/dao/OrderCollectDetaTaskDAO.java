package com.unionpay.withhold.trade.task.dao;

import com.unionpay.withhold.trade.task.pojo.OrderCollectDetaTaskDO;
import com.unionpay.withhold.trade.task.pojo.OrderCollectDetaTaskDOExample;
import java.util.List;

public interface OrderCollectDetaTaskDAO {
    int deleteByPrimaryKey(Long tid);

    int insert(OrderCollectDetaTaskDO record);

    int insertSelective(OrderCollectDetaTaskDO record);

    List<OrderCollectDetaTaskDO> selectByExample(OrderCollectDetaTaskDOExample example);

    OrderCollectDetaTaskDO selectByPrimaryKey(Long tid);

    int updateByPrimaryKeySelective(OrderCollectDetaTaskDO record);

    int updateByPrimaryKey(OrderCollectDetaTaskDO record);
}