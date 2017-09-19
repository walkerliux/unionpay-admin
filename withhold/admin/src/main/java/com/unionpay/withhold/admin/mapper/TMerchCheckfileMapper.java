package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TMerchCheckfile;
import com.unionpay.withhold.admin.pojo.TMerchCheckfileExample;

public interface TMerchCheckfileMapper {
    int countByExample(TMerchCheckfileExample example);

    int deleteByExample(TMerchCheckfileExample example);

    int insert(TMerchCheckfile record);

    int insertSelective(TMerchCheckfile record);

    List<TMerchCheckfile> selectByExample(TMerchCheckfileExample example);

    int updateByExampleSelective(@Param("record") TMerchCheckfile record, @Param("example") TMerchCheckfileExample example);

    int updateByExample(@Param("record") TMerchCheckfile record, @Param("example") TMerchCheckfileExample example);
}