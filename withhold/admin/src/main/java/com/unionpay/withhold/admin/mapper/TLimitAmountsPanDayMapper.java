package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TLimitAmountsPanDay;
import com.unionpay.withhold.admin.pojo.TLimitAmountsPanDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLimitAmountsPanDayMapper {
    int countByExample(TLimitAmountsPanDayExample example);

    int deleteByExample(TLimitAmountsPanDayExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TLimitAmountsPanDay record);

    int insertSelective(TLimitAmountsPanDay record);

    List<TLimitAmountsPanDay> selectByExample(TLimitAmountsPanDayExample example);

    TLimitAmountsPanDay selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TLimitAmountsPanDay record, @Param("example") TLimitAmountsPanDayExample example);

    int updateByExample(@Param("record") TLimitAmountsPanDay record, @Param("example") TLimitAmountsPanDayExample example);

    int updateByPrimaryKeySelective(TLimitAmountsPanDay record);

    int updateByPrimaryKey(TLimitAmountsPanDay record);
}