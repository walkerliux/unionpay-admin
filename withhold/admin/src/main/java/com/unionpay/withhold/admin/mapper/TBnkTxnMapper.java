package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TBnkTxn;
import com.unionpay.withhold.admin.pojo.TBnkTxnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBnkTxnMapper {
    int countByExample(TBnkTxnExample example);

    int deleteByExample(TBnkTxnExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TBnkTxn record);

    int insertSelective(TBnkTxn record);

    List<TBnkTxn> selectByExample(TBnkTxnExample example);

    TBnkTxn selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TBnkTxn record, @Param("example") TBnkTxnExample example);

    int updateByExample(@Param("record") TBnkTxn record, @Param("example") TBnkTxnExample example);

    int updateByPrimaryKeySelective(TBnkTxn record);

    int updateByPrimaryKey(TBnkTxn record);
}