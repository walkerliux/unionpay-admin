package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TCity;
import com.unionpay.withhold.admin.pojo.TCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCityMapper {
    int countByExample(TCityExample example);

    int deleteByExample(TCityExample example);

    int deleteByPrimaryKey(Long cId);

    int insert(TCity record);

    int insertSelective(TCity record);

    List<TCity> selectByExample(TCityExample example);

    TCity selectByPrimaryKey(Long cId);

    int updateByExampleSelective(@Param("record") TCity record, @Param("example") TCityExample example);

    int updateByExample(@Param("record") TCity record, @Param("example") TCityExample example);

    int updateByPrimaryKeySelective(TCity record);

    int updateByPrimaryKey(TCity record);
}