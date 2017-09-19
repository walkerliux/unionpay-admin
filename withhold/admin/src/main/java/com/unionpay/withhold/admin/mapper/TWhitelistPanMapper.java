package com.unionpay.withhold.admin.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TWhitelistPan;
import com.unionpay.withhold.admin.pojo.TWhitelistPanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWhitelistPanMapper {
    int countByExample(TWhitelistPanExample example);

    int deleteByExample(TWhitelistPanExample example);

    int deleteByPrimaryKey(Long tId);

    int insert(TWhitelistPan record);

    int insertSelective(TWhitelistPan record);

    List<TWhitelistPan> selectByExample(TWhitelistPanExample example);

    TWhitelistPan selectByPrimaryKey(Long tId);

    int updateByExampleSelective(@Param("record") TWhitelistPan record, @Param("example") TWhitelistPanExample example);

    int updateByExample(@Param("record") TWhitelistPan record, @Param("example") TWhitelistPanExample example);

    int updateByPrimaryKeySelective(TWhitelistPan record);

    int updateByPrimaryKey(TWhitelistPan record);
}
