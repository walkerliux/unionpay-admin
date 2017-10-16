package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TRiskCase;
import com.unionpay.withhold.admin.pojo.TRiskCaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRiskCaseMapper {
    int countByExample(TRiskCaseExample example);

    int deleteByExample(TRiskCaseExample example);

    int deleteByPrimaryKey(Long caseid);

    int insert(TRiskCase record);

    int insertSelective(TRiskCase record);

    List<TRiskCase> selectByExample(TRiskCaseExample example);

    TRiskCase selectByPrimaryKey(Long caseid);

    int updateByExampleSelective(@Param("record") TRiskCase record, @Param("example") TRiskCaseExample example);

    int updateByExample(@Param("record") TRiskCase record, @Param("example") TRiskCaseExample example);

    int updateByPrimaryKeySelective(TRiskCase record);

    int updateByPrimaryKey(TRiskCase record);
}