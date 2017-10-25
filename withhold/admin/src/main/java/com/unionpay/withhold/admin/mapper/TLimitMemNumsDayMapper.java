package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TLimitMemNumsDay;
import com.unionpay.withhold.admin.pojo.TLimitMemNumsDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLimitMemNumsDayMapper {
    int countByExample(TLimitMemNumsDayExample example);

    int deleteByExample(TLimitMemNumsDayExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TLimitMemNumsDay record);

    int insertSelective(TLimitMemNumsDay record);

    List<TLimitMemNumsDay> selectByExample(TLimitMemNumsDayExample example);

    TLimitMemNumsDay selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TLimitMemNumsDay record, @Param("example") TLimitMemNumsDayExample example);

    int updateByExample(@Param("record") TLimitMemNumsDay record, @Param("example") TLimitMemNumsDayExample example);

    int updateByPrimaryKeySelective(TLimitMemNumsDay record);

    int updateByPrimaryKey(TLimitMemNumsDay record);
}