package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TOrderCollectBatch;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatchExample;

public interface TOrderCollectBatchMapper {
    int countByExample(TOrderCollectBatchExample example);

    int deleteByExample(TOrderCollectBatchExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(TOrderCollectBatch record);

    int insertSelective(TOrderCollectBatch record);

    List<TOrderCollectBatch> selectByExample(TOrderCollectBatchExample example);

    TOrderCollectBatch selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") TOrderCollectBatch record, @Param("example") TOrderCollectBatchExample example);

    int updateByExample(@Param("record") TOrderCollectBatch record, @Param("example") TOrderCollectBatchExample example);

    int updateByPrimaryKeySelective(TOrderCollectBatch record);

    int updateByPrimaryKey(TOrderCollectBatch record);
}