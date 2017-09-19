package com.unionpay.withhold.admin.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TRoleFunct;
import com.unionpay.withhold.admin.pojo.TRoleFunctExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleFunctMapper {
    int countByExample(TRoleFunctExample example);

    int deleteByExample(TRoleFunctExample example);

    int deleteByPrimaryKey(Long roleFunctId);

    int insert(TRoleFunct record);

    int insertSelective(TRoleFunct record);

    List<TRoleFunct> selectByExample(TRoleFunctExample example);

    TRoleFunct selectByPrimaryKey(Long roleFunctId);

    int updateByExampleSelective(@Param("record") TRoleFunct record, @Param("example") TRoleFunctExample example);

    int updateByExample(@Param("record") TRoleFunct record, @Param("example") TRoleFunctExample example);

    int updateByPrimaryKeySelective(TRoleFunct record);

    int updateByPrimaryKey(TRoleFunct record);
}
