package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TMerchChnl;
import com.unionpay.withhold.admin.pojo.TMerchChnlExample;
import com.unionpay.withhold.admin.pojo.TMerchChnlWithBLOBs;
import com.unionpay.withhold.admin.pojo.TMerchDeta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TMerchChnlMapper {
    int countByExample(TMerchChnlExample example);

    int deleteByExample(TMerchChnlExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TMerchChnlWithBLOBs record);

    int insertSelective(TMerchChnlWithBLOBs record);

    List<TMerchChnlWithBLOBs> selectByExampleWithBLOBs(TMerchChnlExample example);

    List<TMerchChnl> selectByExample(TMerchChnlExample example);

    TMerchChnlWithBLOBs selectByPrimaryKey(Integer tid);
    
    TMerchChnlWithBLOBs selectChnlByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TMerchChnlWithBLOBs record);

    int updateByExampleWithBLOBs(@Param("record") TMerchChnlWithBLOBs record, @Param("example") TMerchChnlExample example);

    int updateByExample(@Param("record") TMerchChnl record, @Param("example") TMerchChnlExample example);

    int updateByPrimaryKeySelective(TMerchChnlWithBLOBs  record);

    int updateByPrimaryKeyWithBLOBs(TMerchChnlWithBLOBs record);

    int updateByPrimaryKey(TMerchChnl record);

	int selectCountWithCondition(@Param("merchDeta")TMerchDeta merchDeta, @Param("chnlcode")String chnlcode);
	
	List<TMerchChnlWithBLOBs> selectChnlWithCondition(@Param("merchDeta")TMerchDeta merchDeta, @Param("chnlcode")String chnlcode,@Param("beginRow")Integer beginRow, @Param("pageSize")Integer pageSize);

	int selectaddCountWithCondition(@Param("merchno")String merchno);
	
	int selectaddCount(@Param("merchDeta")TMerchDeta merchDeta, @Param("chnlcode")String chnlcode);
	
	List<TMerchChnlWithBLOBs> selectaddChnl(@Param("merchDeta")TMerchDeta merchDeta, @Param("chnlcode")String chnlcode,@Param("beginRow")Integer beginRow, @Param("pageSize")Integer pageSize);
	
	 List<TMerchChnl> selectByMerchno( @Param("merchno")String merchno);
	
}