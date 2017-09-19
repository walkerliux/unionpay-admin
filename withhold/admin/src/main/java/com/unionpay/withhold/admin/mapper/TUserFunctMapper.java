package com.unionpay.withhold.admin.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TUserFunct;
import com.unionpay.withhold.admin.pojo.TUserFunctExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserFunctMapper {
    int countByExample(TUserFunctExample example);

    int deleteByExample(TUserFunctExample example);

    int deleteByPrimaryKey(Long userFunctId);

    int insert(TUserFunct record);

    int insertSelective(TUserFunct record);

    List<TUserFunct> selectByExample(TUserFunctExample example);

    TUserFunct selectByPrimaryKey(Long userFunctId);

    int updateByExampleSelective(@Param("record") TUserFunct record, @Param("example") TUserFunctExample example);

    int updateByExample(@Param("record") TUserFunct record, @Param("example") TUserFunctExample example);

    int updateByPrimaryKeySelective(TUserFunct record);

    int updateByPrimaryKey(TUserFunct record);
}
