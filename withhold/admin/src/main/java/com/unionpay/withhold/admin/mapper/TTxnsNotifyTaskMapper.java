package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TTxnsNotifyTask;
import com.unionpay.withhold.admin.pojo.TTxnsNotifyTaskExample;

public interface TTxnsNotifyTaskMapper {
    int countByExample(TTxnsNotifyTaskExample example);

    int deleteByExample(TTxnsNotifyTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TTxnsNotifyTask record);

    int insertSelective(TTxnsNotifyTask record);

    List<TTxnsNotifyTask> selectByExample(TTxnsNotifyTaskExample example);

    TTxnsNotifyTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TTxnsNotifyTask record, @Param("example") TTxnsNotifyTaskExample example);

    int updateByExample(@Param("record") TTxnsNotifyTask record, @Param("example") TTxnsNotifyTaskExample example);

    int updateByPrimaryKeySelective(TTxnsNotifyTask record);

    int updateByPrimaryKey(TTxnsNotifyTask record);
}