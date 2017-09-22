package com.unionpay.withhold.trade.risk.dao;

import java.util.List;

import com.unionpay.withhold.trade.risk.pojo.RiskListDO;
import com.unionpay.withhold.trade.risk.pojo.RiskListDOExample;

public interface RiskListDAO {
    int deleteByPrimaryKey(Integer rid);

    int insert(RiskListDO record);

    int insertSelective(RiskListDO record);

    List<RiskListDO> selectByExample(RiskListDOExample example);

    RiskListDO selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(RiskListDO record);

    int updateByPrimaryKey(RiskListDO record);
    
    RiskListDO getRiskStrategy(short orders);
}