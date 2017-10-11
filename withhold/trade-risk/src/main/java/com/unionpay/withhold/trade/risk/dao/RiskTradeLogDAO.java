package com.unionpay.withhold.trade.risk.dao;

import com.unionpay.withhold.trade.risk.pojo.RiskTradeLogDO;
import com.unionpay.withhold.trade.risk.pojo.RiskTradeLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskTradeLogDAO {
    long countByExample(RiskTradeLogDOExample example);

    int deleteByExample(RiskTradeLogDOExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(RiskTradeLogDO record);

    int insertSelective(RiskTradeLogDO record);

    List<RiskTradeLogDO> selectByExample(RiskTradeLogDOExample example);

    RiskTradeLogDO selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") RiskTradeLogDO record, @Param("example") RiskTradeLogDOExample example);

    int updateByExample(@Param("record") RiskTradeLogDO record, @Param("example") RiskTradeLogDOExample example);

    int updateByPrimaryKeySelective(RiskTradeLogDO record);

    int updateByPrimaryKey(RiskTradeLogDO record);
}