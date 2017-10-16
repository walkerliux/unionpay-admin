package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TMccList;
import com.unionpay.withhold.admin.pojo.TMccListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMccListMapper {
    int countByExample(TMccListExample example);

    int deleteByExample(TMccListExample example);

    int insert(TMccList record);

    int insertSelective(TMccList record);

    List<TMccList> selectByExample(TMccListExample example);

    int updateByExampleSelective(@Param("record") TMccList record, @Param("example") TMccListExample example);

    int updateByExample(@Param("record") TMccList record, @Param("example") TMccListExample example);
}