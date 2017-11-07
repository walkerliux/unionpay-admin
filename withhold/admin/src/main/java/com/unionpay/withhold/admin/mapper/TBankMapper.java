package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TBank;
import com.unionpay.withhold.admin.pojo.TBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBankMapper {
    int countByExample(TBankExample example);

    int deleteByExample(TBankExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(TBank record);

    int insertSelective(TBank record);

    List<TBank> selectByExample(TBankExample example);

    TBank selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") TBank record, @Param("example") TBankExample example);

    int updateByExample(@Param("record") TBank record, @Param("example") TBankExample example);

    int updateByPrimaryKeySelective(TBank record);

    int updateByPrimaryKey(TBank record);
    int countByOldAndNewCode(TBank record);
    
    List<TBank> selectBankCheckbox(String bankcodes);
}