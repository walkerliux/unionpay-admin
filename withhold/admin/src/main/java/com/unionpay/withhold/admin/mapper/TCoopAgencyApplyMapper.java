package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TCoopAgencyApply;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCoopAgencyApplyMapper {
    int countByExample(TCoopAgencyApplyExample example);

    int deleteByExample(TCoopAgencyApplyExample example);

    int deleteByPrimaryKey(Long selfId);

    int insert(TCoopAgencyApply record);

    int insertSelective(TCoopAgencyApply record);

    List<TCoopAgencyApply> selectByExample(TCoopAgencyApplyExample example);

    TCoopAgencyApply selectByPrimaryKey(Long selfId);

    int updateByExampleSelective(@Param("record") TCoopAgencyApply record, @Param("example") TCoopAgencyApplyExample example);

    int updateByExample(@Param("record") TCoopAgencyApply record, @Param("example") TCoopAgencyApplyExample example);

    int updateByPrimaryKeySelective(TCoopAgencyApply record);

    int updateByPrimaryKey(TCoopAgencyApply record);
}