package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TTxnsLog;
import com.unionpay.withhold.admin.pojo.TTxnsLogExample;

public interface TTxnsLogMapper {
    int countByExample(TTxnsLogExample example);

    int deleteByExample(TTxnsLogExample example);

    int deleteByPrimaryKey(String txnseqno);

    int insert(TTxnsLog record);

    int insertSelective(TTxnsLog record);

    List<TTxnsLog> selectByExample(TTxnsLogExample example);

    TTxnsLog selectByPrimaryKey(String txnseqno);

    int updateByExampleSelective(@Param("record") TTxnsLog record, @Param("example") TTxnsLogExample example);

    int updateByExample(@Param("record") TTxnsLog record, @Param("example") TTxnsLogExample example);

    int updateByPrimaryKeySelective(TTxnsLog record);

    int updateByPrimaryKey(TTxnsLog record);
}