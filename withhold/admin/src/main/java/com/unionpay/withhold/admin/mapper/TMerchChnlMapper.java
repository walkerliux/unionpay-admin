package com.unionpay.withhold.admin.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TMerchChnl;
import com.unionpay.withhold.admin.pojo.TMerchChnlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMerchChnlMapper {
    int countByExample(TMerchChnlExample example);

    int deleteByExample(TMerchChnlExample example);

    int deleteByPrimaryKey(String tid);

    int insert(TMerchChnl record);

    int insertSelective(TMerchChnl record);

    List<TMerchChnl> selectByExample(TMerchChnlExample example);

    TMerchChnl selectByPrimaryKey(String tid);

    int updateByExampleSelective(@Param("record") TMerchChnl record, @Param("example") TMerchChnlExample example);

    int updateByExample(@Param("record") TMerchChnl record, @Param("example") TMerchChnlExample example);

    int updateByPrimaryKeySelective(TMerchChnl record);

    int updateByPrimaryKey(TMerchChnl record);
}
