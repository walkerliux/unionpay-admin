package com.unionpay.withhold.trade.route.dao;

import com.unionpay.withhold.trade.route.bean.TradeRouteBean;
import com.unionpay.withhold.trade.route.pojo.RouteConfigDO;
import com.unionpay.withhold.trade.route.pojo.RouteConfigDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RouteConfigDAO {
    long countByExample(RouteConfigDOExample example);

    int deleteByExample(RouteConfigDOExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(RouteConfigDO record);

    int insertSelective(RouteConfigDO record);

    List<RouteConfigDO> selectByExample(RouteConfigDOExample example);

    RouteConfigDO selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") RouteConfigDO record, @Param("example") RouteConfigDOExample example);

    int updateByExample(@Param("record") RouteConfigDO record, @Param("example") RouteConfigDOExample example);

    int updateByPrimaryKeySelective(RouteConfigDO record);

    int updateByPrimaryKey(RouteConfigDO record);
    
    List<RouteConfigDO> getTradeRoute(TradeRouteBean tradeRouteBean);
}