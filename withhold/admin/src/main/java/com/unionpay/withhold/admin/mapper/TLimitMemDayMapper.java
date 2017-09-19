package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TLimitMemDay;
import com.unionpay.withhold.admin.pojo.TLimitMemDayExample;

public interface TLimitMemDayMapper {
    int countByExample(TLimitMemDayExample example);

    int deleteByExample(TLimitMemDayExample example);

    int deleteByPrimaryKey(Long tId);

    int insert(TLimitMemDay record);

    int insertSelective(TLimitMemDay record);

    List<TLimitMemDay> selectByExample(TLimitMemDayExample example);

    TLimitMemDay selectByPrimaryKey(Long tId);

    int updateByExampleSelective(@Param("record") TLimitMemDay record, @Param("example") TLimitMemDayExample example);

    int updateByExample(@Param("record") TLimitMemDay record, @Param("example") TLimitMemDayExample example);

    int updateByPrimaryKeySelective(TLimitMemDay record);

    int updateByPrimaryKey(TLimitMemDay record);
}