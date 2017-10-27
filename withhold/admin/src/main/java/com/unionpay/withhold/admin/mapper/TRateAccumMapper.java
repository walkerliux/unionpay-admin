package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TRateAccum;
import com.unionpay.withhold.admin.pojo.TRateAccumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRateAccumMapper {
    int countByExample(TRateAccumExample example);

    int deleteByExample(TRateAccumExample example);

    int deleteByPrimaryKey(Integer rateId);

    int insert(TRateAccum record);

    int insertSelective(TRateAccum record);

    List<TRateAccum> selectByExample(TRateAccumExample example);

    TRateAccum selectByPrimaryKey(Integer rateId);

    int updateByExampleSelective(@Param("record") TRateAccum record, @Param("example") TRateAccumExample example);

    int updateByExample(@Param("record") TRateAccum record, @Param("example") TRateAccumExample example);

    int updateByPrimaryKeySelective(TRateAccum record);

    int updateByPrimaryKey(TRateAccum record);

	List<TRateAccum> getAllRateList();
	
	List<TRateAccum> queryAmtAccumRate(TRateAccumExample example);
}