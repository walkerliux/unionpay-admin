package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TSpeFeeDeta;
import com.unionpay.withhold.admin.pojo.TSpeFeeDetaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSpeFeeDetaMapper {
    int countByExample(TSpeFeeDetaExample example);

    int deleteByExample(TSpeFeeDetaExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TSpeFeeDeta record);

    int insertSelective(TSpeFeeDeta record);

    List<TSpeFeeDeta> selectByExample(TSpeFeeDetaExample example);

    TSpeFeeDeta selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TSpeFeeDeta record, @Param("example") TSpeFeeDetaExample example);

    int updateByExample(@Param("record") TSpeFeeDeta record, @Param("example") TSpeFeeDetaExample example);

    int updateByPrimaryKeySelective(TSpeFeeDeta record);

    int updateByPrimaryKey(TSpeFeeDeta record);
    
    List<TSpeFeeDeta> selectSpeFeeDateInfo(TSpeFeeDetaExample example);
}