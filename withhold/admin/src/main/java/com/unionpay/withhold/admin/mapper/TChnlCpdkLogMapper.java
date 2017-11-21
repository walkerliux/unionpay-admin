package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TChnlCpdkLog;
import com.unionpay.withhold.admin.pojo.TChnlCpdkLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChnlCpdkLogMapper {
    int countByExample(TChnlCpdkLogExample example);

    int deleteByExample(TChnlCpdkLogExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TChnlCpdkLog record);

    int insertSelective(TChnlCpdkLog record);

    List<TChnlCpdkLog> selectByExample(TChnlCpdkLogExample example);

    TChnlCpdkLog selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TChnlCpdkLog record, @Param("example") TChnlCpdkLogExample example);

    int updateByExample(@Param("record") TChnlCpdkLog record, @Param("example") TChnlCpdkLogExample example);

    int updateByPrimaryKeySelective(TChnlCpdkLog record);

    int updateByPrimaryKey(TChnlCpdkLog record);

	int countByExample_bak(TChnlCpdkLogExample tChnlCpdkLogExample);

	List<TChnlCpdkLog> selectByExample_bak(
			TChnlCpdkLogExample tChnlCpdkLogExample);

	List<TChnlCpdkLog> getCPtradeStatus();

	List<TChnlCpdkLog> getCPbaktradeStatus();
}