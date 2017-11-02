package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TMerchDetaExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TMerchDetaMapper {
    int countByExample(TMerchDetaExample example);

    int deleteByExample(TMerchDetaExample example);

    int deleteByPrimaryKey(Integer merchId);

    int insert(TMerchDeta record);

    int insertSelective(TMerchDeta record);

    List<TMerchDeta> selectByExample(TMerchDetaExample example);

    TMerchDeta selectByPrimaryKey(Integer merchId);

    int updateByExampleSelective(@Param("record") TMerchDeta record, @Param("example") TMerchDetaExample example);

    int updateByExample(@Param("record") TMerchDeta record, @Param("example") TMerchDetaExample example);

    int updateByPrimaryKeySelective(TMerchDeta record);

    int updateByPrimaryKey(TMerchDeta record);

	List<TMerchDeta> selectWithCondition(@Param("merchDeta")TMerchDeta merchDeta, @Param("statuses")List<String> statuses, @Param("beginRow")Integer beginRow, @Param("pageSize")Integer pageSize);

	int selectCountWithCondition(@Param("merchDeta")TMerchDeta merchDeta, @Param("statuses")List<String> statuses);
	
	List<TMerchDeta> selectByMemberId(@Param("memberId")String memberId);
}