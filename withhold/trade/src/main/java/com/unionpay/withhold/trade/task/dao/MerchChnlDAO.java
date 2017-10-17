package com.unionpay.withhold.trade.task.dao;

import java.util.List;

import com.unionpay.withhold.trade.task.pojo.MerchChnlDO;
import com.unionpay.withhold.trade.task.pojo.MerchChnlDOExample;

public interface MerchChnlDAO {
    int deleteByPrimaryKey(Integer tid);

    int insert(MerchChnlDO record);

    int insertSelective(MerchChnlDO record);

    List<MerchChnlDO> selectByExampleWithBLOBs(MerchChnlDOExample example);

    List<MerchChnlDO> selectByExample(MerchChnlDOExample example);

    MerchChnlDO selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(MerchChnlDO record);

    int updateByPrimaryKeyWithBLOBs(MerchChnlDO record);

    int updateByPrimaryKey(MerchChnlDO record);
    
    List<MerchChnlDO> queryMerchChnl(MerchChnlDO record);
}