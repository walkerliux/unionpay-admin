package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TChnlBank;
import com.unionpay.withhold.admin.pojo.TChnlBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChnlBankMapper {
    int countByExample(TChnlBankExample example);

    int deleteByExample(TChnlBankExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TChnlBank record);

    int insertSelective(TChnlBank record);

    List<TChnlBank> selectByExample(TChnlBankExample example);

    TChnlBank selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TChnlBank record, @Param("example") TChnlBankExample example);

    int updateByExample(@Param("record") TChnlBank record, @Param("example") TChnlBankExample example);

    int updateByPrimaryKeySelective(TChnlBank record);

    int updateByPrimaryKey(TChnlBank record);
}