package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TRspmsg;
import com.unionpay.withhold.admin.pojo.TRspmsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRspmsgMapper {
    int countByExample(TRspmsgExample example);

    int deleteByExample(TRspmsgExample example);

    int deleteByPrimaryKey(Integer rspid);

    int insert(TRspmsg record);

    int insertSelective(TRspmsg record);

    List<TRspmsg> selectByExample(TRspmsgExample example);

    TRspmsg selectByPrimaryKey(Integer rspid);

    int updateByExampleSelective(@Param("record") TRspmsg record, @Param("example") TRspmsgExample example);

    int updateByExample(@Param("record") TRspmsg record, @Param("example") TRspmsgExample example);

    int updateByPrimaryKeySelective(TRspmsg record);

    int updateByPrimaryKey(TRspmsg record);
}