package com.unionpay.withhold.trade.task.dao;

import com.unionpay.withhold.trade.task.pojo.ParaDicDO;
import com.unionpay.withhold.trade.task.pojo.ParaDicDOExample;
import java.util.List;

public interface ParaDicDAO {
    int deleteByPrimaryKey(Integer tid);

    int insert(ParaDicDO record);

    int insertSelective(ParaDicDO record);

    List<ParaDicDO> selectByExample(ParaDicDOExample example);

    ParaDicDO selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(ParaDicDO record);

    int updateByPrimaryKey(ParaDicDO record);
}