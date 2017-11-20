package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TCheckfileMistake;
import com.unionpay.withhold.admin.pojo.TCheckfileMistakeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TCheckfileMistakeMapper {
    int countByExample(TCheckfileMistakeExample example);

    int deleteByExample(TCheckfileMistakeExample example);

    int deleteByPrimaryKey(Integer iid);

    int insert(TCheckfileMistake record);

    int insertSelective(TCheckfileMistake record);

    List<TCheckfileMistake> selectByExample(TCheckfileMistakeExample example);

    TCheckfileMistake selectByPrimaryKey(Integer iid);

    int updateByExampleSelective(@Param("record") TCheckfileMistake record, @Param("example") TCheckfileMistakeExample example);

    int updateByExample(@Param("record") TCheckfileMistake record, @Param("example") TCheckfileMistakeExample example);

    int updateByPrimaryKeySelective(TCheckfileMistake record);

    int updateByPrimaryKey(TCheckfileMistake record);
    
    Map<String, Object> localMistakeSum(Map<String, Object> map);
    Map<String, Object> merchMistakeSum(Map<String, Object> map);
}