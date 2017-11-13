package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TRiskTradeLog;
import com.unionpay.withhold.admin.pojo.TRiskTradeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRiskTradeLogMapper {
    int countByExample(TRiskTradeLogExample example);

    int deleteByExample(TRiskTradeLogExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TRiskTradeLog record);

    int insertSelective(TRiskTradeLog record);

    List<TRiskTradeLog> selectByExample(TRiskTradeLogExample example);

    TRiskTradeLog selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TRiskTradeLog record, @Param("example") TRiskTradeLogExample example);

    int updateByExample(@Param("record") TRiskTradeLog record, @Param("example") TRiskTradeLogExample example);

    int updateByPrimaryKeySelective(TRiskTradeLog record);

    int updateByPrimaryKey(TRiskTradeLog record);
}