package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TChnlDeta;
import com.unionpay.withhold.admin.pojo.TChnlDetaExample;

public interface TChnlDetaMapper {
    int countByExample(TChnlDetaExample example);

    int deleteByExample(TChnlDetaExample example);

    int deleteByPrimaryKey(String chnlid);

    int insert(TChnlDeta record);

    int insertSelective(TChnlDeta record);

    List<TChnlDeta> selectByExample(TChnlDetaExample example);

    TChnlDeta selectByPrimaryKey(String chnlid);

    int updateByExampleSelective(@Param("record") TChnlDeta record, @Param("example") TChnlDetaExample example);

    int updateByExample(@Param("record") TChnlDeta record, @Param("example") TChnlDetaExample example);

    int updateByPrimaryKeySelective(TChnlDeta record);

    int updateByPrimaryKey(TChnlDeta record);
}