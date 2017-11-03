package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TOrderCollectBatch;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderCollectBatchMapper {
    int countByExample(TOrderCollectBatchExample example);
    List<TOrderCollectBatch> selectByExample(TOrderCollectBatchExample example);
    TOrderCollectBatch selectByPrimaryKey(Long tid);
	int countByMyExample(TOrderCollectBatchExample tOrderCollectBatchExample);
	List<TOrderCollectBatch> selectByPageExample(
			TOrderCollectBatchExample tOrderCollectBatchExample);
	int countByMyExample_bak(TOrderCollectBatchExample tOrderCollectBatchExample);
	List<TOrderCollectBatch> selectByPageExample_bak(
			TOrderCollectBatchExample tOrderCollectBatchExample);
}