package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TOrderCollectDeta;
import com.unionpay.withhold.admin.pojo.TOrderCollectDetaExample;

public interface TOrderCollectDetaMapper {
    int countByExample(TOrderCollectDetaExample example);

    int deleteByExample(TOrderCollectDetaExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(TOrderCollectDeta record);

    int insertSelective(TOrderCollectDeta record);

    List<TOrderCollectDeta> selectByExample(TOrderCollectDetaExample example);

    TOrderCollectDeta selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") TOrderCollectDeta record, @Param("example") TOrderCollectDetaExample example);

    int updateByExample(@Param("record") TOrderCollectDeta record, @Param("example") TOrderCollectDetaExample example);

    int updateByPrimaryKeySelective(TOrderCollectDeta record);

    int updateByPrimaryKey(TOrderCollectDeta record);
}