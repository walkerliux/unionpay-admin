package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TOperationLog;
import com.unionpay.withhold.admin.pojo.TOperationLogExample;

public interface TOperationLogMapper {
    int countByExample(TOperationLogExample example);

    int deleteByExample(TOperationLogExample example);

    int deleteByPrimaryKey(Long logId);

    int insert(TOperationLog record);

    int insertSelective(TOperationLog record);

    List<TOperationLog> selectByExample(TOperationLogExample example);

    TOperationLog selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") TOperationLog record, @Param("example") TOperationLogExample example);

    int updateByExample(@Param("record") TOperationLog record, @Param("example") TOperationLogExample example);

    int updateByPrimaryKeySelective(TOperationLog record);

    int updateByPrimaryKey(TOperationLog record);
}