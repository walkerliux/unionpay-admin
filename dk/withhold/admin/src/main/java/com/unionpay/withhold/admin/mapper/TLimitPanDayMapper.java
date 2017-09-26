package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TLimitPanDay;
import com.unionpay.withhold.admin.pojo.TLimitPanDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLimitPanDayMapper {
    int countByExample(TLimitPanDayExample example);

    int deleteByExample(TLimitPanDayExample example);

    int deleteByPrimaryKey(Long tId);

    int insert(TLimitPanDay record);

    int insertSelective(TLimitPanDay record);

    List<TLimitPanDay> selectByExample(TLimitPanDayExample example);

    TLimitPanDay selectByPrimaryKey(Long tId);

    int updateByExampleSelective(@Param("record") TLimitPanDay record, @Param("example") TLimitPanDayExample example);

    int updateByExample(@Param("record") TLimitPanDay record, @Param("example") TLimitPanDayExample example);

    int updateByPrimaryKeySelective(TLimitPanDay record);

    int updateByPrimaryKey(TLimitPanDay record);
}