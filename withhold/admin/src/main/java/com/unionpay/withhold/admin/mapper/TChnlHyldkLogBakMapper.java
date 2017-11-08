package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TChnlHyldkLogBak;
import com.unionpay.withhold.admin.pojo.TChnlHyldkLogBakExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChnlHyldkLogBakMapper {
    int countByExample(TChnlHyldkLogBakExample example);

    int deleteByExample(TChnlHyldkLogBakExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TChnlHyldkLogBak record);

    int insertSelective(TChnlHyldkLogBak record);

    List<TChnlHyldkLogBak> selectByExample(TChnlHyldkLogBakExample example);

    TChnlHyldkLogBak selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TChnlHyldkLogBak record, @Param("example") TChnlHyldkLogBakExample example);

    int updateByExample(@Param("record") TChnlHyldkLogBak record, @Param("example") TChnlHyldkLogBakExample example);

    int updateByPrimaryKeySelective(TChnlHyldkLogBak record);

    int updateByPrimaryKey(TChnlHyldkLogBak record);
}