package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TChnlDeta;
import com.unionpay.withhold.admin.pojo.TChnlDetaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChnlDetaMapper {
    int countByExample(TChnlDetaExample example);

    int deleteByExample(TChnlDetaExample example);

    int deleteByPrimaryKey(Integer chnlid);

    int insert(TChnlDeta record);

    int insertSelective(TChnlDeta record);

    List<TChnlDeta> selectByExample(TChnlDetaExample example);

    TChnlDeta selectByPrimaryKey(Integer chnlid);

    int updateByExampleSelective(@Param("record") TChnlDeta record, @Param("example") TChnlDetaExample example);

    int updateByExample(@Param("record") TChnlDeta record, @Param("example") TChnlDetaExample example);

    int updateByPrimaryKeySelective(TChnlDeta record);

    int updateByPrimaryKey(TChnlDeta record);
}