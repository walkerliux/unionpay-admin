package com.unionpay.withhold.trade.order.dao;

import com.unionpay.withhold.trade.order.pojo.TxncodeDefDO;
import com.unionpay.withhold.trade.order.pojo.TxncodeDefDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TxncodeDefDAO {
    long countByExample(TxncodeDefDOExample example);

    int deleteByExample(TxncodeDefDOExample example);

    int deleteByPrimaryKey(Integer txnid);

    int insert(TxncodeDefDO record);

    int insertSelective(TxncodeDefDO record);

    List<TxncodeDefDO> selectByExample(TxncodeDefDOExample example);

    TxncodeDefDO selectByPrimaryKey(Integer txnid);

    int updateByExampleSelective(@Param("record") TxncodeDefDO record, @Param("example") TxncodeDefDOExample example);

    int updateByExample(@Param("record") TxncodeDefDO record, @Param("example") TxncodeDefDOExample example);

    int updateByPrimaryKeySelective(TxncodeDefDO record);

    int updateByPrimaryKey(TxncodeDefDO record);
    
    TxncodeDefDO getBusiCode(TxncodeDefDO record);
}