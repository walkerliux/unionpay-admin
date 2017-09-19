package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TCheckfileMistake;
import com.unionpay.withhold.admin.pojo.TCheckfileMistakeExample;

public interface TCheckfileMistakeMapper {
    int countByExample(TCheckfileMistakeExample example);

    int deleteByExample(TCheckfileMistakeExample example);

    int deleteByPrimaryKey(Long iid);

    int insert(TCheckfileMistake record);

    int insertSelective(TCheckfileMistake record);

    List<TCheckfileMistake> selectByExample(TCheckfileMistakeExample example);

    TCheckfileMistake selectByPrimaryKey(Long iid);

    int updateByExampleSelective(@Param("record") TCheckfileMistake record, @Param("example") TCheckfileMistakeExample example);

    int updateByExample(@Param("record") TCheckfileMistake record, @Param("example") TCheckfileMistakeExample example);

    int updateByPrimaryKeySelective(TCheckfileMistake record);

    int updateByPrimaryKey(TCheckfileMistake record);
}