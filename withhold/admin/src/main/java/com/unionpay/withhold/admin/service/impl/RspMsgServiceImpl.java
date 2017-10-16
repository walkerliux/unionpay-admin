package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.ChnlType;
import com.unionpay.withhold.admin.Bean.ChnlTypeEnum;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TRspmsgMapper;
import com.unionpay.withhold.admin.pojo.TRspmsg;
import com.unionpay.withhold.admin.pojo.TRspmsgExample;
import com.unionpay.withhold.admin.pojo.TRspmsgExample.Criteria;
import com.unionpay.withhold.admin.service.RspMsgService;
import com.unionpay.withhold.admin.utils.EnumUtils;
@Service
@Transactional
public class RspMsgServiceImpl implements RspMsgService {
	@Autowired
	private TRspmsgMapper tRspmsgMapper;
	@Override
	public PageBean findRspByPage(TRspmsg rspmsg, int page, int rows) {
		TRspmsgExample tRspmsgExample = new TRspmsgExample();
		Criteria criteria = tRspmsgExample.createCriteria();
		if (rspmsg.getApicode()!=null&&!"".equals(rspmsg.getApicode())) {
			criteria.andApicodeEqualTo(rspmsg.getApicode());
		}
		if(rspmsg.getRetcode()!=null&&!"".equals(rspmsg.getRetcode())){
			criteria.andRetcodeEqualTo(rspmsg.getRetcode());
		}
		if (rspmsg.getChnltype()!=null&&!"".equals(rspmsg.getChnltype())) {
			criteria.andChnltypeEqualTo(rspmsg.getChnltype());
		}
		if (rspmsg.getChnlrspcode()!=null&&!"".equals(rspmsg.getChnlrspcode())) {
			criteria.andChnlrspcodeEqualTo(rspmsg.getChnlrspcode());
		}
		int total = tRspmsgMapper.countByExample(tRspmsgExample);
		tRspmsgExample.setPageNum(page);
		tRspmsgExample.setPageSize(rows);
		List<TRspmsg> list = tRspmsgMapper.selectByExample(tRspmsgExample);
		return new PageBean(total, list);
	}
	@Override
	public TRspmsg getSingleById(Long rspid) {
		
		
		return tRspmsgMapper.selectByPrimaryKey(rspid.intValue());
	}
	
	@Override
	public void updateTRspmsg(TRspmsg rspmsg) {
		tRspmsgMapper.updateByPrimaryKeySelective(rspmsg);
		
	}
	@Override
	public void saveTRspmsg(TRspmsg rspmsg) {
		tRspmsgMapper.insert(rspmsg);
		
	}

}
