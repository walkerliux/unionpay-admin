package com.unionpay.withhold.trade.order.dao;

import com.unionpay.withhold.trade.order.pojo.TxnLogDO;
import com.unionpay.withhold.trade.order.pojo.TxnLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TxnLogDAO {
    long countByExample(TxnLogDOExample example);

    int deleteByExample(TxnLogDOExample example);

    int deleteByPrimaryKey(String txnseqno);

    int insert(TxnLogDO record);

    int insertSelective(TxnLogDO record);

    List<TxnLogDO> selectByExample(TxnLogDOExample example);

    TxnLogDO selectByPrimaryKey(String txnseqno);

    int updateByExampleSelective(@Param("record") TxnLogDO record, @Param("example") TxnLogDOExample example);

    int updateByExample(@Param("record") TxnLogDO record, @Param("example") TxnLogDOExample example);

    int updateByPrimaryKeySelective(TxnLogDO record);

    int updateByPrimaryKey(TxnLogDO record);
}