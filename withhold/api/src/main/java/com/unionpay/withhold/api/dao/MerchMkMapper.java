package com.unionpay.withhold.api.dao;

import com.unionpay.withhold.api.model.MerchMk;

public interface MerchMkMapper {
    int deleteByPrimaryKey(Integer safeseq);

    int insert(MerchMk record);

    int insertSelective(MerchMk record);

    MerchMk selectByCertId(String certid);

    int updateByPrimaryKeySelective(MerchMk record);

    int updateByPrimaryKey(MerchMk record);
}