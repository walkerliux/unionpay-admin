package com.unionpay.withhold.trade.order.dao;

import com.unionpay.withhold.trade.order.pojo.CardBinDO;
import com.unionpay.withhold.trade.order.pojo.CardBinDOExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CardBinDAO {
    long countByExample(CardBinDOExample example);

    int deleteByExample(CardBinDOExample example);

    int deleteByPrimaryKey(@Param("cardbin") String cardbin, @Param("cardlen") Short cardlen);

    int insert(CardBinDO record);

    int insertSelective(CardBinDO record);

    List<CardBinDO> selectByExample(CardBinDOExample example);

    CardBinDO selectByPrimaryKey(@Param("cardbin") String cardbin, @Param("cardlen") Short cardlen);

    int updateByExampleSelective(@Param("record") CardBinDO record, @Param("example") CardBinDOExample example);

    int updateByExample(@Param("record") CardBinDO record, @Param("example") CardBinDOExample example);

    int updateByPrimaryKeySelective(CardBinDO record);

    int updateByPrimaryKey(CardBinDO record);
    
    CardBinDO getCardInfo(Map<String, Object> record);
}