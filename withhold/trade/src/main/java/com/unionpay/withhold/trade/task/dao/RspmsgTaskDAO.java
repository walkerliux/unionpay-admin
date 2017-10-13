package com.unionpay.withhold.trade.task.dao;

import com.unionpay.withhold.trade.task.pojo.RspmsgTaskDO;
import com.unionpay.withhold.trade.task.pojo.RspmsgTaskDOExample;
import java.util.List;

public interface RspmsgTaskDAO {
    int deleteByPrimaryKey(Integer rspid);

    int insert(RspmsgTaskDO record);

    int insertSelective(RspmsgTaskDO record);

    List<RspmsgTaskDO> selectByExample(RspmsgTaskDOExample example);

    RspmsgTaskDO selectByPrimaryKey(Integer rspid);

    int updateByPrimaryKeySelective(RspmsgTaskDO record);

    int updateByPrimaryKey(RspmsgTaskDO record);
    
    RspmsgTaskDO queryRspmsg(RspmsgTaskDO record);
}