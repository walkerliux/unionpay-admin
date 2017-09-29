package com.unionpay.withhold.path.dao;

import com.unionpay.withhold.path.model.ChnlCpdkLog;

public interface ChnlCpdkLogMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(ChnlCpdkLog record);

    int insertSelective(ChnlCpdkLog record);

    ChnlCpdkLog selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(ChnlCpdkLog record);

    int updateByPrimaryKey(ChnlCpdkLog record);
}