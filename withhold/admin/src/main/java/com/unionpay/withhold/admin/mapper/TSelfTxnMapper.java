package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TSelfTxn;
import com.unionpay.withhold.admin.pojo.TSelfTxnExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TSelfTxnMapper {
    int countByExample(TSelfTxnExample example);

    int deleteByExample(TSelfTxnExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TSelfTxn record);

    int insertSelective(TSelfTxn record);

    List<TSelfTxn> selectByExample(TSelfTxnExample example);

    TSelfTxn selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TSelfTxn record, @Param("example") TSelfTxnExample example);

    int updateByExample(@Param("record") TSelfTxn record, @Param("example") TSelfTxnExample example);

    int updateByPrimaryKeySelective(TSelfTxn record);

    int updateByPrimaryKey(TSelfTxn record);
    
    int insertFromTxnLog(Map<String, Object> map);
    
    int updateByCheckBill(Map<String, Object> map);
    
    int insertMistake(Map<String, Object> map);
}