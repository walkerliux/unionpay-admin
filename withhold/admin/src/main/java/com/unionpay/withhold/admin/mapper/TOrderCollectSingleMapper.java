package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TOrderCollectSingle;
import com.unionpay.withhold.admin.pojo.TOrderCollectSingleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderCollectSingleMapper {
    int countByExample(TOrderCollectSingleExample example);

    int deleteByExample(TOrderCollectSingleExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(TOrderCollectSingle record);

    int insertSelective(TOrderCollectSingle record);

    List<TOrderCollectSingle> selectByExample(TOrderCollectSingleExample example);

    TOrderCollectSingle selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") TOrderCollectSingle record, @Param("example") TOrderCollectSingleExample example);

    int updateByExample(@Param("record") TOrderCollectSingle record, @Param("example") TOrderCollectSingleExample example);

    int updateByPrimaryKeySelective(TOrderCollectSingle record);

    int updateByPrimaryKey(TOrderCollectSingle record);

	int countByExample_bak(TOrderCollectSingleExample singleExample);

	List<TOrderCollectSingle> selectByExample_bak(
			TOrderCollectSingleExample singleExample);

	TOrderCollectSingle selectInfoByTid(Long tid);

	TOrderCollectSingle selectHisInfoByTid(long parseLong);

	List<TOrderCollectSingle> selectOrderInfo(
			TOrderCollectSingleExample singleExample);
}