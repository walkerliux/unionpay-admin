package com.unionpay.withhold.trade.task.dao;

import com.unionpay.withhold.trade.task.pojo.TxnsNotifyTaskDO;
import com.unionpay.withhold.trade.task.pojo.TxnsNotifyTaskDOExample;
import java.util.List;

public interface TxnsNotifyTaskDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(TxnsNotifyTaskDO record);

    int insertSelective(TxnsNotifyTaskDO record);

    List<TxnsNotifyTaskDO> selectByExample(TxnsNotifyTaskDOExample example);

    TxnsNotifyTaskDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TxnsNotifyTaskDO record);

    int updateByPrimaryKey(TxnsNotifyTaskDO record);
    
    TxnsNotifyTaskDO queryByTxnseqno(String txnseqno);
}