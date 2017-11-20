package com.unionpay.withhold.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TCoopAgencyApply;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApplyExample;

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
    
    List<TCoopAgencyApply> selectWithCondition(@Param("coopAgencyApply")TCoopAgencyApply coopAgencyApply, @Param("statuses")List<String> statuses, @Param("beginRow")Integer beginRow, @Param("pageSize")Integer pageSize);
    int selectCountWithCondition(@Param("coopAgencyApply")TCoopAgencyApply coopAgencyApply, @Param("statuses")List<String> statuses);
    
    TCoopAgencyApply selectCoopAgencyDetailById(Long selfId);
    
    Integer getCacode();
    
    List<TCoopAgencyApply> selectAllWithCondition(@Param("coopAgencyApply")TCoopAgencyApply coopAgencyApply, @Param("beginRow")Integer beginRow, @Param("pageSize")Integer pageSize);
    int selectAllCountWithCondition(@Param("coopAgencyApply")TCoopAgencyApply coopAgencyApply);
}