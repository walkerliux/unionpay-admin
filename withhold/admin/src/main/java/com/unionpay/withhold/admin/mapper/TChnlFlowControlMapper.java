package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TChnlFlowControl;
import com.unionpay.withhold.admin.pojo.TChnlFlowControlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChnlFlowControlMapper {
    int countByExample(TChnlFlowControlExample example);

    int deleteByExample(TChnlFlowControlExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(TChnlFlowControl record);

    int insertSelective(TChnlFlowControl record);

    List<TChnlFlowControl> selectByExample(TChnlFlowControlExample example);

    TChnlFlowControl selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TChnlFlowControl record, @Param("example") TChnlFlowControlExample example);

    int updateByExample(@Param("record") TChnlFlowControl record, @Param("example") TChnlFlowControlExample example);

    int updateByPrimaryKeySelective(TChnlFlowControl record);

    int updateByPrimaryKey(TChnlFlowControl record);
}