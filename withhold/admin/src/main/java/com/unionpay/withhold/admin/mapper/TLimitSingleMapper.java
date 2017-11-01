package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TLimitSingle;
import com.unionpay.withhold.admin.pojo.TLimitSingleExample;

public interface TLimitSingleMapper {
    int countByExample(TLimitSingleExample example);

    int deleteByExample(TLimitSingleExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TLimitSingle record);

    int insertSelective(TLimitSingle record);

    List<TLimitSingle> selectByExample(TLimitSingleExample example);

    TLimitSingle selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TLimitSingle record, @Param("example") TLimitSingleExample example);

    int updateByExample(@Param("record") TLimitSingle record, @Param("example") TLimitSingleExample example);

    int updateByPrimaryKeySelective(TLimitSingle record);

    int updateByPrimaryKey(TLimitSingle record);
    
	List<TLimitSingle> selectWithCondition(@Param("limitSingle")TLimitSingle limitSingle, @Param("beginRow")Integer beginRow, @Param("pageSize")Integer pageSize);

	int selectCountWithCondition(@Param("limitSingle")TLimitSingle limitSingle);

	int selectIntersectionCount(TLimitSingle limitSingle);
	int selectRiskConflictCount(TLimitSingle limitSingle);
}