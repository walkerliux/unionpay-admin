package com.unionpay.withhold.trade.order.dao;

import com.unionpay.withhold.trade.order.pojo.RspmsgDO;
import com.unionpay.withhold.trade.order.pojo.RspmsgDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RspmsgDAO {
    long countByExample(RspmsgDOExample example);

    int deleteByExample(RspmsgDOExample example);

    int deleteByPrimaryKey(String rspid);

    int insert(RspmsgDO record);

    int insertSelective(RspmsgDO record);

    List<RspmsgDO> selectByExample(RspmsgDOExample example);

    RspmsgDO selectByPrimaryKey(String rspid);

    int updateByExampleSelective(@Param("record") RspmsgDO record, @Param("example") RspmsgDOExample example);

    int updateByExample(@Param("record") RspmsgDO record, @Param("example") RspmsgDOExample example);

    int updateByPrimaryKeySelective(RspmsgDO record);

    int updateByPrimaryKey(RspmsgDO record);
    
    RspmsgDO getTradeRsp(RspmsgDO record);
}