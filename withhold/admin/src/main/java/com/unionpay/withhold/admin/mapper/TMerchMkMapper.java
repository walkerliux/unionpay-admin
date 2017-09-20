package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TMerchMk;
import com.unionpay.withhold.admin.pojo.TMerchMkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMerchMkMapper {
    int countByExample(TMerchMkExample example);

    int deleteByExample(TMerchMkExample example);

    int deleteByPrimaryKey(String memberid);

    int insert(TMerchMk record);

    int insertSelective(TMerchMk record);

    List<TMerchMk> selectByExample(TMerchMkExample example);

    TMerchMk selectByPrimaryKey(String memberid);

    int updateByExampleSelective(@Param("record") TMerchMk record, @Param("example") TMerchMkExample example);

    int updateByExample(@Param("record") TMerchMk record, @Param("example") TMerchMkExample example);

    int updateByPrimaryKeySelective(TMerchMk record);

    int updateByPrimaryKey(TMerchMk record);
}