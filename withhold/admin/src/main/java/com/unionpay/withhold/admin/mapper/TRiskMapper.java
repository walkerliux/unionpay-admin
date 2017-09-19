package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TRisk;
import com.unionpay.withhold.admin.pojo.TRiskExample;

public interface TRiskMapper {
    int countByExample(TRiskExample example);

    int deleteByExample(TRiskExample example);

    int deleteByPrimaryKey(Long riskid);

    int insert(TRisk record);

    int insertSelective(TRisk record);

    List<TRisk> selectByExample(TRiskExample example);

    TRisk selectByPrimaryKey(Long riskid);

    int updateByExampleSelective(@Param("record") TRisk record, @Param("example") TRiskExample example);

    int updateByExample(@Param("record") TRisk record, @Param("example") TRiskExample example);

    int updateByPrimaryKeySelective(TRisk record);

    int updateByPrimaryKey(TRisk record);
}