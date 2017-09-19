package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TCoopAgency;
import com.unionpay.withhold.admin.pojo.TCoopAgencyExample;

public interface TCoopAgencyMapper {
    int countByExample(TCoopAgencyExample example);

    int deleteByExample(TCoopAgencyExample example);

    int deleteByPrimaryKey(Long caid);

    int insert(TCoopAgency record);

    int insertSelective(TCoopAgency record);

    List<TCoopAgency> selectByExample(TCoopAgencyExample example);

    TCoopAgency selectByPrimaryKey(Long caid);

    int updateByExampleSelective(@Param("record") TCoopAgency record, @Param("example") TCoopAgencyExample example);

    int updateByExample(@Param("record") TCoopAgency record, @Param("example") TCoopAgencyExample example);

    int updateByPrimaryKeySelective(TCoopAgency record);

    int updateByPrimaryKey(TCoopAgency record);
}