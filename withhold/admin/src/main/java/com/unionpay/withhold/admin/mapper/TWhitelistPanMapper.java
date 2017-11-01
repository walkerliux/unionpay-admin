package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TWhitelistPan;
import com.unionpay.withhold.admin.pojo.TWhitelistPanExample;

public interface TWhitelistPanMapper {
    int countByExample(TWhitelistPanExample example);

    int deleteByExample(TWhitelistPanExample example);

    int deleteByPrimaryKey(Integer tId);

    int insert(TWhitelistPan record);

    int insertSelective(TWhitelistPan record);

    List<TWhitelistPan> selectByExample(TWhitelistPanExample example);

    TWhitelistPan selectByPrimaryKey(Integer tId);

    int updateByExampleSelective(@Param("record") TWhitelistPan record, @Param("example") TWhitelistPanExample example);

    int updateByExample(@Param("record") TWhitelistPan record, @Param("example") TWhitelistPanExample example);

    int updateByPrimaryKeySelective(TWhitelistPan record);

    int updateByPrimaryKey(TWhitelistPan record);
    
	List<TWhitelistPan> selectWithCondition(@Param("whitelistPan")TWhitelistPan WhitelistPan, @Param("beginRow")Integer beginRow, @Param("pageSize")Integer pageSize);

	int selectCountWithCondition(@Param("whitelistPan")TWhitelistPan WhitelistPan);

}