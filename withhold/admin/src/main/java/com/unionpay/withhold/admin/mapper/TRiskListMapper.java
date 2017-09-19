package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TRiskList;
import com.unionpay.withhold.admin.pojo.TRiskListExample;

public interface TRiskListMapper {
    int countByExample(TRiskListExample example);

    int deleteByExample(TRiskListExample example);

    int deleteByPrimaryKey(Short orders);

    int insert(TRiskList record);

    int insertSelective(TRiskList record);

    List<TRiskList> selectByExample(TRiskListExample example);

    TRiskList selectByPrimaryKey(Short orders);

    int updateByExampleSelective(@Param("record") TRiskList record, @Param("example") TRiskListExample example);

    int updateByExample(@Param("record") TRiskList record, @Param("example") TRiskListExample example);

    int updateByPrimaryKeySelective(TRiskList record);

    int updateByPrimaryKey(TRiskList record);
}