package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TChnlHyldkLog;
import com.unionpay.withhold.admin.pojo.TChnlHyldkLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChnlHyldkLogMapper {
    int countByExample(TChnlHyldkLogExample example);

    int deleteByExample(TChnlHyldkLogExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TChnlHyldkLog record);

    int insertSelective(TChnlHyldkLog record);

    List<TChnlHyldkLog> selectByExample(TChnlHyldkLogExample example);

    TChnlHyldkLog selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TChnlHyldkLog record, @Param("example") TChnlHyldkLogExample example);

    int updateByExample(@Param("record") TChnlHyldkLog record, @Param("example") TChnlHyldkLogExample example);

    int updateByPrimaryKeySelective(TChnlHyldkLog record);

    int updateByPrimaryKey(TChnlHyldkLog record);

	List<TChnlHyldkLog> getHYLTtradeStatus();

	List<TChnlHyldkLog> selectByMyExample(
			TChnlHyldkLogExample tChnlHyldkLogExample);

	List<TChnlHyldkLog> selectHYLBakByMyExample(
			TChnlHyldkLogExample tChnlHyldkLogExample);
}