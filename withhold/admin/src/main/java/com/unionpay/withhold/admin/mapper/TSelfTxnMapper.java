package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TSelfTxn;
import com.unionpay.withhold.admin.pojo.TSelfTxnExample;

public interface TSelfTxnMapper {
    int countByExample(TSelfTxnExample example);

    int deleteByExample(TSelfTxnExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(TSelfTxn record);

    int insertSelective(TSelfTxn record);

    List<TSelfTxn> selectByExample(TSelfTxnExample example);

    TSelfTxn selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") TSelfTxn record, @Param("example") TSelfTxnExample example);

    int updateByExample(@Param("record") TSelfTxn record, @Param("example") TSelfTxnExample example);

    int updateByPrimaryKeySelective(TSelfTxn record);

    int updateByPrimaryKey(TSelfTxn record);
}