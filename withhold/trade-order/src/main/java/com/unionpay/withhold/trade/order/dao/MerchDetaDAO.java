package com.unionpay.withhold.trade.order.dao;

import com.unionpay.withhold.trade.order.pojo.MerchDetaDO;
import com.unionpay.withhold.trade.order.pojo.MerchDetaDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchDetaDAO {
    long countByExample(MerchDetaDOExample example);

    int deleteByExample(MerchDetaDOExample example);

    int deleteByPrimaryKey(Long merchId);

    int insert(MerchDetaDO record);

    int insertSelective(MerchDetaDO record);

    List<MerchDetaDO> selectByExample(MerchDetaDOExample example);

    MerchDetaDO selectByPrimaryKey(Long merchId);

    int updateByExampleSelective(@Param("record") MerchDetaDO record, @Param("example") MerchDetaDOExample example);

    int updateByExample(@Param("record") MerchDetaDO record, @Param("example") MerchDetaDOExample example);

    int updateByPrimaryKeySelective(MerchDetaDO record);

    int updateByPrimaryKey(MerchDetaDO record);
    
    MerchDetaDO getByMerchNo(String memberId);
}