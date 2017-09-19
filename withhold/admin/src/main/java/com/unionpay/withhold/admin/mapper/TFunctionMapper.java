package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TFunction;
import com.unionpay.withhold.admin.pojo.TFunctionExample;

public interface TFunctionMapper {
    int countByExample(TFunctionExample example);

    int deleteByExample(TFunctionExample example);

    int deleteByPrimaryKey(Long functId);

    int insert(TFunction record);

    int insertSelective(TFunction record);

    List<TFunction> selectByExample(TFunctionExample example);

    TFunction selectByPrimaryKey(Long functId);

    int updateByExampleSelective(@Param("record") TFunction record, @Param("example") TFunctionExample example);

    int updateByExample(@Param("record") TFunction record, @Param("example") TFunctionExample example);

    int updateByPrimaryKeySelective(TFunction record);

    int updateByPrimaryKey(TFunction record);
}