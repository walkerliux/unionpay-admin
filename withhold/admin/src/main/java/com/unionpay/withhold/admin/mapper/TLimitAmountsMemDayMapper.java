package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TLimitAmountsMemDay;
import com.unionpay.withhold.admin.pojo.TLimitAmountsMemDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLimitAmountsMemDayMapper {
    int countByExample(TLimitAmountsMemDayExample example);

    int deleteByExample(TLimitAmountsMemDayExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TLimitAmountsMemDay record);

    int insertSelective(TLimitAmountsMemDay record);

    List<TLimitAmountsMemDay> selectByExample(TLimitAmountsMemDayExample example);

    TLimitAmountsMemDay selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TLimitAmountsMemDay record, @Param("example") TLimitAmountsMemDayExample example);

    int updateByExample(@Param("record") TLimitAmountsMemDay record, @Param("example") TLimitAmountsMemDayExample example);

    int updateByPrimaryKeySelective(TLimitAmountsMemDay record);

    int updateByPrimaryKey(TLimitAmountsMemDay record);
}