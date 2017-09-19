package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TChnlCpdkBatch;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatchExample;

public interface TChnlCpdkBatchMapper {
    int countByExample(TChnlCpdkBatchExample example);

    int deleteByExample(TChnlCpdkBatchExample example);

    int insert(TChnlCpdkBatch record);

    int insertSelective(TChnlCpdkBatch record);

    List<TChnlCpdkBatch> selectByExample(TChnlCpdkBatchExample example);

    int updateByExampleSelective(@Param("record") TChnlCpdkBatch record, @Param("example") TChnlCpdkBatchExample example);

    int updateByExample(@Param("record") TChnlCpdkBatch record, @Param("example") TChnlCpdkBatchExample example);
}