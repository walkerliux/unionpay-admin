package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TRspmsg;
import com.unionpay.withhold.admin.pojo.TRspmsgExample;

public interface TRspmsgMapper {
    int countByExample(TRspmsgExample example);

    int deleteByExample(TRspmsgExample example);

    int deleteByPrimaryKey(String rspid);

    int insert(TRspmsg record);

    int insertSelective(TRspmsg record);

    List<TRspmsg> selectByExample(TRspmsgExample example);

    TRspmsg selectByPrimaryKey(String rspid);

    int updateByExampleSelective(@Param("record") TRspmsg record, @Param("example") TRspmsgExample example);

    int updateByExample(@Param("record") TRspmsg record, @Param("example") TRspmsgExample example);

    int updateByPrimaryKeySelective(TRspmsg record);

    int updateByPrimaryKey(TRspmsg record);
}