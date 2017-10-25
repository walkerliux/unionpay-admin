package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TLimitNumsPanDay;
import com.unionpay.withhold.admin.pojo.TLimitNumsPanDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLimitNumsPanDayMapper {
    int countByExample(TLimitNumsPanDayExample example);

    int deleteByExample(TLimitNumsPanDayExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TLimitNumsPanDay record);

    int insertSelective(TLimitNumsPanDay record);

    List<TLimitNumsPanDay> selectByExample(TLimitNumsPanDayExample example);

    TLimitNumsPanDay selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TLimitNumsPanDay record, @Param("example") TLimitNumsPanDayExample example);

    int updateByExample(@Param("record") TLimitNumsPanDay record, @Param("example") TLimitNumsPanDayExample example);

    int updateByPrimaryKeySelective(TLimitNumsPanDay record);

    int updateByPrimaryKey(TLimitNumsPanDay record);
}