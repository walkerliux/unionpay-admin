package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TRateAccumDeta;
import com.unionpay.withhold.admin.pojo.TRateAccumDetaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRateAccumDetaMapper {
    int countByExample(TRateAccumDetaExample example);

    int deleteByExample(TRateAccumDetaExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(TRateAccumDeta record);

    int insertSelective(TRateAccumDeta record);

    List<TRateAccumDeta> selectByExample(TRateAccumDetaExample example);

    TRateAccumDeta selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") TRateAccumDeta record, @Param("example") TRateAccumDetaExample example);

    int updateByExample(@Param("record") TRateAccumDeta record, @Param("example") TRateAccumDetaExample example);

    int updateByPrimaryKeySelective(TRateAccumDeta record);

    int updateByPrimaryKey(TRateAccumDeta record);
}