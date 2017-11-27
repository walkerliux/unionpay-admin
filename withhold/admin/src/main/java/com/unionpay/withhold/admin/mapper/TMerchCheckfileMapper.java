package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TMerchCheckfile;
import com.unionpay.withhold.admin.pojo.TMerchCheckfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMerchCheckfileMapper {
    int countByExample(TMerchCheckfileExample example);

    int deleteByExample(TMerchCheckfileExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TMerchCheckfile record);

    int insertSelective(TMerchCheckfile record);

    List<TMerchCheckfile> selectByExample(TMerchCheckfileExample example);

    TMerchCheckfile selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TMerchCheckfile record, @Param("example") TMerchCheckfileExample example);

    int updateByExample(@Param("record") TMerchCheckfile record, @Param("example") TMerchCheckfileExample example);

    int updateByPrimaryKeySelective(TMerchCheckfile record);

    int updateByPrimaryKey(TMerchCheckfile record);
}