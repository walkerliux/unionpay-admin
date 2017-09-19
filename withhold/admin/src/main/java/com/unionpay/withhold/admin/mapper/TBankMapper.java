package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TBank;
import com.unionpay.withhold.admin.pojo.TBankExample;

public interface TBankMapper {
    int countByExample(TBankExample example);

    int deleteByExample(TBankExample example);

    int insert(TBank record);

    int insertSelective(TBank record);

    List<TBank> selectByExample(TBankExample example);

    int updateByExampleSelective(@Param("record") TBank record, @Param("example") TBankExample example);

    int updateByExample(@Param("record") TBank record, @Param("example") TBankExample example);
}