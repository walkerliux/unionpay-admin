package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TBusiness;
import com.unionpay.withhold.admin.pojo.TBusinessExample;

public interface TBusinessMapper {
    int countByExample(TBusinessExample example);

    int deleteByExample(TBusinessExample example);

    int deleteByPrimaryKey(Integer busiid);

    int insert(TBusiness record);

    int insertSelective(TBusiness record);

    List<TBusiness> selectByExample(TBusinessExample example);

    TBusiness selectByPrimaryKey(Integer busiid);

    int updateByExampleSelective(@Param("record") TBusiness record, @Param("example") TBusinessExample example);

    int updateByExample(@Param("record") TBusiness record, @Param("example") TBusinessExample example);

    int updateByPrimaryKeySelective(TBusiness record);

    int updateByPrimaryKey(TBusiness record);
    
    List<TBusiness> selectBusinessCheckbox(String busicodes);
}