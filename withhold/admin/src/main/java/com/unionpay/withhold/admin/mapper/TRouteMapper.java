package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TRoute;
import com.unionpay.withhold.admin.pojo.TRouteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRouteMapper {
    int countByExample(TRouteExample example);

    int deleteByExample(TRouteExample example);

    int deleteByPrimaryKey(Integer routid);

    int insert(TRoute record);

    int insertSelective(TRoute record);

    List<TRoute> selectByExample(TRouteExample example);

    TRoute selectByPrimaryKey(Integer routid);

    int updateByExampleSelective(@Param("record") TRoute record, @Param("example") TRouteExample example);

    int updateByExample(@Param("record") TRoute record, @Param("example") TRouteExample example);

    int updateByPrimaryKeySelective(TRoute record);

    int updateByPrimaryKey(TRoute record);
}