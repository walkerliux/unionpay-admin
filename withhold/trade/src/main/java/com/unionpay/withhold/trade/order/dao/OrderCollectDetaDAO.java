package com.unionpay.withhold.trade.order.dao;

import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDO;
import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCollectDetaDAO {
    long countByExample(OrderCollectDetaDOExample example);

    int deleteByExample(OrderCollectDetaDOExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(OrderCollectDetaDO record);

    int insertSelective(OrderCollectDetaDO record);

    List<OrderCollectDetaDO> selectByExample(OrderCollectDetaDOExample example);

    OrderCollectDetaDO selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") OrderCollectDetaDO record, @Param("example") OrderCollectDetaDOExample example);

    int updateByExample(@Param("record") OrderCollectDetaDO record, @Param("example") OrderCollectDetaDOExample example);

    int updateByPrimaryKeySelective(OrderCollectDetaDO record);

    int updateByPrimaryKey(OrderCollectDetaDO record);
}