package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TChnlCpqryLog;
import com.unionpay.withhold.admin.pojo.TChnlCpqryLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChnlCpqryLogMapper {
    int countByExample(TChnlCpqryLogExample example);

    int deleteByExample(TChnlCpqryLogExample example);

    int insert(TChnlCpqryLog record);

    int insertSelective(TChnlCpqryLog record);

    List<TChnlCpqryLog> selectByExample(TChnlCpqryLogExample example);

    int updateByExampleSelective(@Param("record") TChnlCpqryLog record, @Param("example") TChnlCpqryLogExample example);

    int updateByExample(@Param("record") TChnlCpqryLog record, @Param("example") TChnlCpqryLogExample example);
}