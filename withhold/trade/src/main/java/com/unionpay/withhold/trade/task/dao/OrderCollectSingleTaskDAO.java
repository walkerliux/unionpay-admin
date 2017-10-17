package com.unionpay.withhold.trade.task.dao;

import com.unionpay.withhold.trade.task.pojo.OrderCollectSingleTaskDO;
import com.unionpay.withhold.trade.task.pojo.OrderCollectSingleTaskDOExample;
import java.util.List;

public interface OrderCollectSingleTaskDAO {
    int deleteByPrimaryKey(Long tid);

    int insert(OrderCollectSingleTaskDO record);

    int insertSelective(OrderCollectSingleTaskDO record);

    List<OrderCollectSingleTaskDO> selectByExample(OrderCollectSingleTaskDOExample example);

    OrderCollectSingleTaskDO selectByPrimaryKey(Long tid);

    int updateByPrimaryKeySelective(OrderCollectSingleTaskDO record);

    int updateByPrimaryKey(OrderCollectSingleTaskDO record);
    
    OrderCollectSingleTaskDO queryByTxnseqno(String relatetradetxn);
}