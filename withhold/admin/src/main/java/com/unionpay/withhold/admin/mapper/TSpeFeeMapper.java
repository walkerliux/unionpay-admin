package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TSpeFee;
import com.unionpay.withhold.admin.pojo.TSpeFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpeFeeMapper {
    int countByExample(TSpeFeeExample example);

    int deleteByExample(TSpeFeeExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TSpeFee record);

    int insertSelective(TSpeFee record);

    List<TSpeFee> selectByExample(TSpeFeeExample example);

    TSpeFee selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TSpeFee record, @Param("example") TSpeFeeExample example);

    int updateByExample(@Param("record") TSpeFee record, @Param("example") TSpeFeeExample example);

    int updateByPrimaryKeySelective(TSpeFee record);

    int updateByPrimaryKey(TSpeFee record);
    //selectspecialfee
    List<TSpeFee> selectspecialfee(TSpeFeeExample example);
}