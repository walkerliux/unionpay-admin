package com.unionpay.withhold.trade.pay.dao;

import com.unionpay.withhold.trade.pay.pojo.OrderDownloadCheckFileDO;
import com.unionpay.withhold.trade.pay.pojo.OrderDownloadCheckFileDOExample;
import java.util.List;

public interface OrderDownloadCheckFileDAO {
    int deleteByPrimaryKey(Integer tid);

    int insert(OrderDownloadCheckFileDO record);

    int insertSelective(OrderDownloadCheckFileDO record);

    List<OrderDownloadCheckFileDO> selectByExample(OrderDownloadCheckFileDOExample example);

    OrderDownloadCheckFileDO selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(OrderDownloadCheckFileDO record);

    int updateByPrimaryKey(OrderDownloadCheckFileDO record);
}