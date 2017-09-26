package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TProvince;
import com.unionpay.withhold.admin.pojo.TProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProvinceMapper {
    int countByExample(TProvinceExample example);

    int deleteByExample(TProvinceExample example);

    int deleteByPrimaryKey(Long pId);

    int insert(TProvince record);

    int insertSelective(TProvince record);

    List<TProvince> selectByExample(TProvinceExample example);

    TProvince selectByPrimaryKey(Long pId);

    int updateByExampleSelective(@Param("record") TProvince record, @Param("example") TProvinceExample example);

    int updateByExample(@Param("record") TProvince record, @Param("example") TProvinceExample example);

    int updateByPrimaryKeySelective(TProvince record);

    int updateByPrimaryKey(TProvince record);
}