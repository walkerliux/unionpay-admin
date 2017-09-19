package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TChnlBank;
import com.unionpay.withhold.admin.pojo.TChnlBankExample;

public interface TChnlBankMapper {
    int countByExample(TChnlBankExample example);

    int deleteByExample(TChnlBankExample example);

    int insert(TChnlBank record);

    int insertSelective(TChnlBank record);

    List<TChnlBank> selectByExample(TChnlBankExample example);

    int updateByExampleSelective(@Param("record") TChnlBank record, @Param("example") TChnlBankExample example);

    int updateByExample(@Param("record") TChnlBank record, @Param("example") TChnlBankExample example);
}