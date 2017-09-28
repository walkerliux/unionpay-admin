package com.unionpay.withhold.trade.pay.dao;

import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TxnLogPayDAO {
    long countByExample(TxnLogPayDOExample example);

    int deleteByExample(TxnLogPayDOExample example);

    int deleteByPrimaryKey(String txnseqno);

    int insert(TxnLogPayDO record);

    int insertSelective(TxnLogPayDO record);

    List<TxnLogPayDO> selectByExample(TxnLogPayDOExample example);

    TxnLogPayDO selectByPrimaryKey(String txnseqno);

    int updateByExampleSelective(@Param("record") TxnLogPayDO record, @Param("example") TxnLogPayDOExample example);

    int updateByExample(@Param("record") TxnLogPayDO record, @Param("example") TxnLogPayDOExample example);

    int updateByPrimaryKeySelective(TxnLogPayDO record);

    int updateByPrimaryKey(TxnLogPayDO record);
}