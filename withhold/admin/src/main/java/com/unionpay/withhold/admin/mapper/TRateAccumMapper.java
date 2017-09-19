package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TRateAccum;
import com.unionpay.withhold.admin.pojo.TRateAccumExample;

public interface TRateAccumMapper {
    int countByExample(TRateAccumExample example);

    int deleteByExample(TRateAccumExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(TRateAccum record);

    int insertSelective(TRateAccum record);

    List<TRateAccum> selectByExample(TRateAccumExample example);

    TRateAccum selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") TRateAccum record, @Param("example") TRateAccumExample example);

    int updateByExample(@Param("record") TRateAccum record, @Param("example") TRateAccumExample example);

    int updateByPrimaryKeySelective(TRateAccum record);

    int updateByPrimaryKey(TRateAccum record);
}