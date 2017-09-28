package com.unionpay.withhold.path.dao;

import com.unionpay.withhold.path.model.TxnsLog;

public interface TxnsLogMapper {
    int deleteByPrimaryKey(String txnseqno);

    int insert(TxnsLog record);

    int insertSelective(TxnsLog record);

    TxnsLog selectByPrimaryKey(String txnseqno);

    int updateByPrimaryKeySelective(TxnsLog record);

    int updateByPrimaryKey(TxnsLog record);
}