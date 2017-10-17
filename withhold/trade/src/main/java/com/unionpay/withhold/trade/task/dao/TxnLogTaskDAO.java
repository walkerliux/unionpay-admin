package com.unionpay.withhold.trade.task.dao;

import com.unionpay.withhold.trade.task.pojo.TxnLogTaskDO;
import com.unionpay.withhold.trade.task.pojo.TxnLogTaskDOExample;
import java.util.List;

public interface TxnLogTaskDAO {
    int deleteByPrimaryKey(String txnseqno);

    int insert(TxnLogTaskDO record);

    int insertSelective(TxnLogTaskDO record);

    List<TxnLogTaskDO> selectByExample(TxnLogTaskDOExample example);

    TxnLogTaskDO selectByPrimaryKey(String txnseqno);

    int updateByPrimaryKeySelective(TxnLogTaskDO record);

    int updateByPrimaryKey(TxnLogTaskDO record);
}