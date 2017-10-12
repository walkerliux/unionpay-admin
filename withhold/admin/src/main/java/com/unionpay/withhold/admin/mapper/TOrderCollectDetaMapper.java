package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TOrderCollectDeta;
import com.unionpay.withhold.admin.pojo.TOrderCollectDetaExample;
import java.util.List;


public interface TOrderCollectDetaMapper {
    int countByExample(TOrderCollectDetaExample example);

    List<TOrderCollectDeta> selectByExample(TOrderCollectDetaExample example);

    TOrderCollectDeta selectByPrimaryKey(Long tid);

   
}