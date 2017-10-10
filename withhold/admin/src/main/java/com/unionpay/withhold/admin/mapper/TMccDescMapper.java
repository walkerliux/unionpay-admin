package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TMccDesc;
import com.unionpay.withhold.admin.pojo.TMccDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMccDescMapper {
    int countByExample(TMccDescExample example);

    int deleteByExample(TMccDescExample example);

    int insert(TMccDesc record);

    int insertSelective(TMccDesc record);

    List<TMccDesc> selectByExample(TMccDescExample example);

    int updateByExampleSelective(@Param("record") TMccDesc record, @Param("example") TMccDescExample example);

    int updateByExample(@Param("record") TMccDesc record, @Param("example") TMccDescExample example);
}