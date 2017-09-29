package com.unionpay.withhold.trade.pay.dao;

import com.unionpay.withhold.trade.pay.pojo.MerchCheckFileDO;
import com.unionpay.withhold.trade.pay.pojo.MerchCheckFileDOExample;
import java.util.List;

public interface MerchCheckFileDAO {
    int deleteByPrimaryKey(Integer tid);

    int insert(MerchCheckFileDO record);

    int insertSelective(MerchCheckFileDO record);

    List<MerchCheckFileDO> selectByExample(MerchCheckFileDOExample example);

    MerchCheckFileDO selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(MerchCheckFileDO record);

    int updateByPrimaryKey(MerchCheckFileDO record);
}