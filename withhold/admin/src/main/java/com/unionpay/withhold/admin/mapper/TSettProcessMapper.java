package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TSettProcess;
import com.unionpay.withhold.admin.pojo.TSettProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSettProcessMapper {
    int countByExample(TSettProcessExample example);

    int deleteByExample(TSettProcessExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TSettProcess record);

    int insertSelective(TSettProcess record);

    List<TSettProcess> selectByExample(TSettProcessExample example);

    TSettProcess selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TSettProcess record, @Param("example") TSettProcessExample example);

    int updateByExample(@Param("record") TSettProcess record, @Param("example") TSettProcessExample example);

    int updateByPrimaryKeySelective(TSettProcess record);

    int updateByPrimaryKey(TSettProcess record);
}