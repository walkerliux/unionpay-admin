package com.unionpay.withhold.trade.pay.dao;

import java.util.List;

import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDO;
import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDOExample;

public interface RspmsgPayDAO {
    int deleteByPrimaryKey(Integer rspid);

    int insert(RspmsgPayDO record);

    int insertSelective(RspmsgPayDO record);

    List<RspmsgPayDO> selectByExample(RspmsgPayDOExample example);

    RspmsgPayDO selectByPrimaryKey(Integer rspid);

    int updateByPrimaryKeySelective(RspmsgPayDO record);

    int updateByPrimaryKey(RspmsgPayDO record);
    
    RspmsgPayDO getTradeRsp(RspmsgPayDO record);
}