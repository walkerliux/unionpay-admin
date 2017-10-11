package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TMerchChnl;
import com.unionpay.withhold.admin.pojo.TMerchChnlExample;
import com.unionpay.withhold.admin.pojo.TMerchChnlWithBLOBs;
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

    int updateByExampleSelective(@Param("record") TMerchChnlWithBLOBs record, @Param("example") TMerchChnlExample example);

    int updateByExampleWithBLOBs(@Param("record") TMerchChnlWithBLOBs record, @Param("example") TMerchChnlExample example);

    int updateByExample(@Param("record") TMerchChnl record, @Param("example") TMerchChnlExample example);

    int updateByPrimaryKeySelective(TMerchChnlWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TMerchChnlWithBLOBs record);

    int updateByPrimaryKey(TMerchChnl record);
}