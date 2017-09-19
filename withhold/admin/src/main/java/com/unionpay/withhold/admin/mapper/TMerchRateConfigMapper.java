package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TMerchRateConfig;
import com.unionpay.withhold.admin.pojo.TMerchRateConfigExample;

public interface TMerchRateConfigMapper {
    int countByExample(TMerchRateConfigExample example);

    int deleteByExample(TMerchRateConfigExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(TMerchRateConfig record);

    int insertSelective(TMerchRateConfig record);

    List<TMerchRateConfig> selectByExample(TMerchRateConfigExample example);

    TMerchRateConfig selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") TMerchRateConfig record, @Param("example") TMerchRateConfigExample example);

    int updateByExample(@Param("record") TMerchRateConfig record, @Param("example") TMerchRateConfigExample example);

    int updateByPrimaryKeySelective(TMerchRateConfig record);

    int updateByPrimaryKey(TMerchRateConfig record);
}