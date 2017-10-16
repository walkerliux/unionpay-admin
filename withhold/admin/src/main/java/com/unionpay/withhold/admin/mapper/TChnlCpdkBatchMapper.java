package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TChnlCpdkBatch;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChnlCpdkBatchMapper {
    int countByExample(TChnlCpdkBatchExample example);

    int deleteByExample(TChnlCpdkBatchExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TChnlCpdkBatch record);

    int insertSelective(TChnlCpdkBatch record);

    List<TChnlCpdkBatch> selectByExample(TChnlCpdkBatchExample example);

    TChnlCpdkBatch selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TChnlCpdkBatch record, @Param("example") TChnlCpdkBatchExample example);

    int updateByExample(@Param("record") TChnlCpdkBatch record, @Param("example") TChnlCpdkBatchExample example);

    int updateByPrimaryKeySelective(TChnlCpdkBatch record);

    int updateByPrimaryKey(TChnlCpdkBatch record);
}