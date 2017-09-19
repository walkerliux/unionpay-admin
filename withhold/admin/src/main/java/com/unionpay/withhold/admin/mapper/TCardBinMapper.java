package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TCardBin;
import com.unionpay.withhold.admin.pojo.TCardBinExample;
import com.unionpay.withhold.admin.pojo.TCardBinKey;

public interface TCardBinMapper {
    int countByExample(TCardBinExample example);

    int deleteByExample(TCardBinExample example);

    int deleteByPrimaryKey(TCardBinKey key);

    int insert(TCardBin record);

    int insertSelective(TCardBin record);

    List<TCardBin> selectByExample(TCardBinExample example);

    TCardBin selectByPrimaryKey(TCardBinKey key);

    int updateByExampleSelective(@Param("record") TCardBin record, @Param("example") TCardBinExample example);

    int updateByExample(@Param("record") TCardBin record, @Param("example") TCardBinExample example);

    int updateByPrimaryKeySelective(TCardBin record);

    int updateByPrimaryKey(TCardBin record);
}