package com.unionpay.withhold.api.dao;

import com.unionpay.withhold.api.model.MerchMk;

public interface MerchMkMapper {
    int deleteByPrimaryKey(String memberid);

    int insert(MerchMk record);

    int insertSelective(MerchMk record);

    MerchMk selectByPrimaryKey(String memberid);

    int updateByPrimaryKeySelective(MerchMk record);

    int updateByPrimaryKey(MerchMk record);
}