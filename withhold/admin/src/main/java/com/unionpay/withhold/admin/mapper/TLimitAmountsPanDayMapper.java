package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TLimitAmountsPanDayExample;
import com.unionpay.withhold.admin.pojo.TLimitAmountsPanDay;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TLimitAmountsPanDayMapper {
    int countByExample(TLimitAmountsPanDayExample example);

    int deleteByExample(TLimitAmountsPanDayExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TLimitAmountsPanDay record);

    int insertSelective(TLimitAmountsPanDay record);

    List<TLimitAmountsPanDay> selectByExample(TLimitAmountsPanDayExample example);

    TLimitAmountsPanDay selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TLimitAmountsPanDay record, @Param("example") TLimitAmountsPanDayExample example);

    int updateByExample(@Param("record") TLimitAmountsPanDay record, @Param("example") TLimitAmountsPanDayExample example);

    int updateByPrimaryKeySelective(TLimitAmountsPanDay record);

    int updateByPrimaryKey(TLimitAmountsPanDay record);
    
    List<TLimitAmountsPanDay> queryLimitMemNumsDay(@Param("caseid")Long caseid,
			@Param("beginRow")Integer beginRow, @Param("pageSize")Integer pageSize);

	int selectCountWithCondition(@Param("caseid")Long caseid);


	TLimitAmountsPanDay queryLimitMemNumsDaybytid(@Param("tid")Integer tid);

	List<TLimitAmountsPanDay> queryAllLimitMemNumsDay(@Param("caseid")Long caseid,@Param("cardtype")String cardtype);
	
}