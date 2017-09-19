package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TLimitPerday;
import com.unionpay.withhold.admin.pojo.TLimitPerdayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLimitPerdayMapper {
    int countByExample(TLimitPerdayExample example);

    int deleteByExample(TLimitPerdayExample example);

    int deleteByPrimaryKey(Long tId);

    int insert(TLimitPerday record);

    int insertSelective(TLimitPerday record);

    List<TLimitPerday> selectByExample(TLimitPerdayExample example);

    TLimitPerday selectByPrimaryKey(Long tId);

    int updateByExampleSelective(@Param("record") TLimitPerday record, @Param("example") TLimitPerdayExample example);

    int updateByExample(@Param("record") TLimitPerday record, @Param("example") TLimitPerdayExample example);

    int updateByPrimaryKeySelective(TLimitPerday record);

    int updateByPrimaryKey(TLimitPerday record);
}