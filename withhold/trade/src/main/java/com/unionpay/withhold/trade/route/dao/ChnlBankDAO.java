package com.unionpay.withhold.trade.route.dao;

import com.unionpay.withhold.trade.route.pojo.ChnlBankDO;
import com.unionpay.withhold.trade.route.pojo.ChnlBankDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChnlBankDAO {
    long countByExample(ChnlBankDOExample example);

    int deleteByExample(ChnlBankDOExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(ChnlBankDO record);

    int insertSelective(ChnlBankDO record);

    List<ChnlBankDO> selectByExample(ChnlBankDOExample example);

    ChnlBankDO selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") ChnlBankDO record, @Param("example") ChnlBankDOExample example);

    int updateByExample(@Param("record") ChnlBankDO record, @Param("example") ChnlBankDOExample example);

    int updateByPrimaryKeySelective(ChnlBankDO record);

    int updateByPrimaryKey(ChnlBankDO record);
}