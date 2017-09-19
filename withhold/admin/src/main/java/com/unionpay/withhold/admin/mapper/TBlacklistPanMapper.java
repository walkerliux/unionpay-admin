package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TBlacklistPan;
import com.unionpay.withhold.admin.pojo.TBlacklistPanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBlacklistPanMapper {
    int countByExample(TBlacklistPanExample example);

    int deleteByExample(TBlacklistPanExample example);

    int deleteByPrimaryKey(Long tId);

    int insert(TBlacklistPan record);

    int insertSelective(TBlacklistPan record);

    List<TBlacklistPan> selectByExample(TBlacklistPanExample example);

    TBlacklistPan selectByPrimaryKey(Long tId);

    int updateByExampleSelective(@Param("record") TBlacklistPan record, @Param("example") TBlacklistPanExample example);

    int updateByExample(@Param("record") TBlacklistPan record, @Param("example") TBlacklistPanExample example);

    int updateByPrimaryKeySelective(TBlacklistPan record);

    int updateByPrimaryKey(TBlacklistPan record);
}