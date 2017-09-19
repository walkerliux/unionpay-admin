package com.unionpay.withhold.admin.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TSpeFee;
import com.unionpay.withhold.admin.pojo.TSpeFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpeFeeMapper {
    int countByExample(TSpeFeeExample example);

    int deleteByExample(TSpeFeeExample example);

    int insert(TSpeFee record);

    int insertSelective(TSpeFee record);

    List<TSpeFee> selectByExample(TSpeFeeExample example);

    int updateByExampleSelective(@Param("record") TSpeFee record, @Param("example") TSpeFeeExample example);

    int updateByExample(@Param("record") TSpeFee record, @Param("example") TSpeFeeExample example);
}
