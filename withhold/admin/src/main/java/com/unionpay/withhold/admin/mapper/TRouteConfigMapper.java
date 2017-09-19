package com.unionpay.withhold.admin.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TRouteConfig;
import com.unionpay.withhold.admin.pojo.TRouteConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRouteConfigMapper {
    int countByExample(TRouteConfigExample example);

    int deleteByExample(TRouteConfigExample example);

    int deleteByPrimaryKey(Long rid);

    int insert(TRouteConfig record);

    int insertSelective(TRouteConfig record);

    List<TRouteConfig> selectByExample(TRouteConfigExample example);

    TRouteConfig selectByPrimaryKey(Long rid);

    int updateByExampleSelective(@Param("record") TRouteConfig record, @Param("example") TRouteConfigExample example);

    int updateByExample(@Param("record") TRouteConfig record, @Param("example") TRouteConfigExample example);

    int updateByPrimaryKeySelective(TRouteConfig record);

    int updateByPrimaryKey(TRouteConfig record);
}
