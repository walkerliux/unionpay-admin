package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TChnlCpdkBatchDeta;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatchDetaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChnlCpdkBatchDetaMapper {
    int countByExample(TChnlCpdkBatchDetaExample example);

    int deleteByExample(TChnlCpdkBatchDetaExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TChnlCpdkBatchDeta record);

    int insertSelective(TChnlCpdkBatchDeta record);

    List<TChnlCpdkBatchDeta> selectByExample(TChnlCpdkBatchDetaExample example);

    TChnlCpdkBatchDeta selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TChnlCpdkBatchDeta record, @Param("example") TChnlCpdkBatchDetaExample example);

    int updateByExample(@Param("record") TChnlCpdkBatchDeta record, @Param("example") TChnlCpdkBatchDetaExample example);

    int updateByPrimaryKeySelective(TChnlCpdkBatchDeta record);

    int updateByPrimaryKey(TChnlCpdkBatchDeta record);
}