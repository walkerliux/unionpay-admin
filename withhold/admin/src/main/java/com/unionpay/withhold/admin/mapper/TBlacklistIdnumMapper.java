package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TBlacklistIdnum;
import com.unionpay.withhold.admin.pojo.TBlacklistIdnumExample;

public interface TBlacklistIdnumMapper {
    int countByExample(TBlacklistIdnumExample example);

    int deleteByExample(TBlacklistIdnumExample example);

    int deleteByPrimaryKey(Long tId);

    int insert(TBlacklistIdnum record);

    int insertSelective(TBlacklistIdnum record);

    List<TBlacklistIdnum> selectByExample(TBlacklistIdnumExample example);

    TBlacklistIdnum selectByPrimaryKey(Long tId);

    int updateByExampleSelective(@Param("record") TBlacklistIdnum record, @Param("example") TBlacklistIdnumExample example);

    int updateByExample(@Param("record") TBlacklistIdnum record, @Param("example") TBlacklistIdnumExample example);

    int updateByPrimaryKeySelective(TBlacklistIdnum record);

    int updateByPrimaryKey(TBlacklistIdnum record);
}