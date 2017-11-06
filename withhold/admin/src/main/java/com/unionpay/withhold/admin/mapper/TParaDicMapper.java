package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.pojo.TParaDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TParaDicMapper {
    int countByExample(TParaDicExample example);

    int deleteByExample(TParaDicExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(TParaDic record);

    int insertSelective(TParaDic record);

    List<TParaDic> selectByExample(TParaDicExample example);

    TParaDic selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") TParaDic record, @Param("example") TParaDicExample example);

    int updateByExample(@Param("record") TParaDic record, @Param("example") TParaDicExample example);

    int updateByPrimaryKeySelective(TParaDic record);

    int updateByPrimaryKey(TParaDic record);

	List<TParaDic> selectByParentIdExample(TParaDicExample tParaDicExample);

	List<TParaDic> selectByLeftJoinExample(TParaDicExample tParaDicExample);

	List<TParaDic> selectParaDicByParentCode(@Param("paraCode") String paraCode);
	
	TParaDic selectParaDicByParaCode(@Param("paraCode") String paraCode);

}