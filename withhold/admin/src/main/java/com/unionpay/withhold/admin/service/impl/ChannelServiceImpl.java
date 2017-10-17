package com.unionpay.withhold.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.ChannelStatusEnums;
import com.unionpay.withhold.admin.mapper.TChnlDetaMapper;
import com.unionpay.withhold.admin.pojo.TChnlDeta;
import com.unionpay.withhold.admin.pojo.TChnlDetaExample;
import com.unionpay.withhold.admin.service.ChannelService;
import com.unionpay.withhold.admin.utils.StringUtil;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private TChnlDetaMapper chnlDetaMapper;

	@Override
	public List<TChnlDeta> selectByCondition(TChnlDeta chnlDeta) {
		// 查分页数据
		
		TChnlDetaExample chnlDetaExample=new TChnlDetaExample();
		TChnlDetaExample.Criteria criteria =  chnlDetaExample.createCriteria();
		if (StringUtil.isNotEmpty(chnlDeta.getChnlname())) {
			criteria.andChnlnameLike("%"+chnlDeta.getChnlname()+"%");
		}
		if (StringUtil.isNotEmpty(chnlDeta.getChnlcode())) {
			criteria.andChnlcodeLike("%"+chnlDeta.getChnlcode()+"%");
		}
		if (StringUtil.isNotEmpty(chnlDeta.getStatus())) {
			if ("00".equals(chnlDeta.getStatus())) {
				criteria.andStatusEqualTo("00");
			}else{
				criteria.andStatusNotEqualTo("00");
			}
		}
		List<TChnlDeta> list = chnlDetaMapper.selectByExample(chnlDetaExample);
		return list;
	}

	@Override
	public ResultBean addChannel(TChnlDeta chnlDeta) {
		
		//严重重复code
		TChnlDetaExample chnlDetaExample=new TChnlDetaExample();
		TChnlDetaExample.Criteria criteria =  chnlDetaExample.createCriteria();
		criteria.andChnlcodeEqualTo(chnlDeta.getChnlcode());
		List<TChnlDeta> list = chnlDetaMapper.selectByExample(chnlDetaExample);
		if (CollectionUtils.isNotEmpty(list)) {
			 return new ResultBean("", "此通道代码被注册过！");
		}
		chnlDeta.setIntime(new Date());
		chnlDeta.setStatus(ChannelStatusEnums.NORMAL.getCode());
		int flag =chnlDetaMapper.insert(chnlDeta);
		if (flag > 0) {
			return new ResultBean("操作成功 ！");
		} else {
			return new ResultBean("", "添加失败！");
		}
	}

}
