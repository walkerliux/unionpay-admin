package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TMerchDetaApply;
import com.unionpay.withhold.admin.pojo.TMerchDetaApplyExample;

public interface TMerchDetaApplyMapper {
    int countByExample(TMerchDetaApplyExample example);

    int deleteByExample(TMerchDetaApplyExample example);

    int deleteByPrimaryKey(Long selfId);

    int insert(TMerchDetaApply record);

    int insertSelective(TMerchDetaApply record);

    List<TMerchDetaApply> selectByExample(TMerchDetaApplyExample example);

    TMerchDetaApply selectByPrimaryKey(Long selfId);

    int updateByExampleSelective(@Param("record") TMerchDetaApply record, @Param("example") TMerchDetaApplyExample example);

    int updateByExample(@Param("record") TMerchDetaApply record, @Param("example") TMerchDetaApplyExample example);

    int updateByPrimaryKeySelective(TMerchDetaApply record);

    int updateByPrimaryKey(TMerchDetaApply record);
}