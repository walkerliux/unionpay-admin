package com.unionpay.withhold.trade.order.dao;

import com.unionpay.withhold.trade.order.pojo.OrderCollectBatchDO;
import com.unionpay.withhold.trade.order.pojo.OrderCollectBatchDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCollectBatchDAO {
    long countByExample(OrderCollectBatchDOExample example);

    int deleteByExample(OrderCollectBatchDOExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(OrderCollectBatchDO record);

    int insertSelective(OrderCollectBatchDO record);

    List<OrderCollectBatchDO> selectByExample(OrderCollectBatchDOExample example);

    OrderCollectBatchDO selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") OrderCollectBatchDO record, @Param("example") OrderCollectBatchDOExample example);

    int updateByExample(@Param("record") OrderCollectBatchDO record, @Param("example") OrderCollectBatchDOExample example);

    int updateByPrimaryKeySelective(OrderCollectBatchDO record);

    int updateByPrimaryKey(OrderCollectBatchDO record);
}