package com.unionpay.withhold.admin.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.unionpay.withhold.admin.pojo.TCphpNotice;
import com.unionpay.withhold.admin.pojo.TCphpNoticeExample;

public interface TCphpNoticeMapper {
    int countByExample(TCphpNoticeExample example);

    int deleteByExample(TCphpNoticeExample example);

    int insert(TCphpNotice record);

    int insertSelective(TCphpNotice record);

    List<TCphpNotice> selectByExample(TCphpNoticeExample example);

    int updateByExampleSelective(@Param("record") TCphpNotice record, @Param("example") TCphpNoticeExample example);

    int updateByExample(@Param("record") TCphpNotice record, @Param("example") TCphpNoticeExample example);
}