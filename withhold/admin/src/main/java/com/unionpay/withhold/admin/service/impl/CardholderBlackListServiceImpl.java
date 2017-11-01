package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.constant.CommonConstants;
import com.unionpay.withhold.admin.mapper.TBlacklistIdnumMapper;
import com.unionpay.withhold.admin.pojo.TBlacklistIdnum;
import com.unionpay.withhold.admin.pojo.TBlacklistIdnumExample;
import com.unionpay.withhold.admin.service.CardholderBlackListService;

@Service
@Transactional
public class CardholderBlackListServiceImpl implements CardholderBlackListService {
	@Autowired
	private TBlacklistIdnumMapper blacklistIdnumMapper;

	@Override
	public PageBean selectListWithCondition(TBlacklistIdnum blacklistIdnum, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<TBlacklistIdnum> cardholderBlackList = blacklistIdnumMapper.selectWithCondition(blacklistIdnum, beginRow, rows);
		int count = blacklistIdnumMapper.selectCountWithCondition(blacklistIdnum);
		return new PageBean(count, cardholderBlackList);
	}

	@Override
	public ResultBean addCardholderBlackList(TBlacklistIdnum blacklistIdnum) {
		// 验重
		TBlacklistIdnumExample blacklistIdnumExample = new TBlacklistIdnumExample();
		TBlacklistIdnumExample.Criteria criteria = blacklistIdnumExample.createCriteria();
		criteria.andIdnumEqualTo(blacklistIdnum.getIdnum());
		int count = blacklistIdnumMapper.countByExample(blacklistIdnumExample);
		if (count > 0) {
			return new ResultBean("", "该持卡人已存在！");
		}
		
		blacklistIdnum.setStatus(CommonConstants.LIST_STATUS_UNNORMAL);
		
		count = blacklistIdnumMapper.insertSelective(blacklistIdnum);
		return count > 0 ? new ResultBean("新持卡人黑名单添加成功！") : new ResultBean("", "新持卡人黑名单添加失败！");
	}

	@Override
	public TBlacklistIdnum queryCardholderBlackListByTid(Integer tid) {
		return blacklistIdnumMapper.selectByPrimaryKey(tid);
	}

	@Override
	public ResultBean updateCardholderBlackList(TBlacklistIdnum blacklistIdnum) {
		TBlacklistIdnum blacklistIdnumBack = blacklistIdnumMapper.selectByPrimaryKey(blacklistIdnum.getTid());
		if (null == blacklistIdnumBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!blacklistIdnumBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该持卡人黑名单未启用，不能修改！");
		}else {
			int count = blacklistIdnumMapper.updateByPrimaryKeySelective(blacklistIdnum);
			return count > 0 ? new ResultBean("修改成功！") : new ResultBean("", "修改失败！");
		}
	}

	@Override
	public ResultBean logoutCardholderBlackList(TBlacklistIdnum blacklistIdnum) {
		TBlacklistIdnum blacklistIdnumBack = blacklistIdnumMapper.selectByPrimaryKey(blacklistIdnum.getTid());
		if (null == blacklistIdnumBack) {
			return new ResultBean("", "信息有误，注销失败！");
		} else if (!blacklistIdnumBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该持卡人黑名单已被注销！");
		}else {
			blacklistIdnum.setStatus(CommonConstants.LIST_STATUS_UNNORMAL);
			int count = blacklistIdnumMapper.updateByPrimaryKeySelective(blacklistIdnum);
			return count > 0 ? new ResultBean("注销成功！") : new ResultBean("", "注销失败！");
		}
	}
	
	@Override
	public ResultBean startCardholderBlackList(TBlacklistIdnum blacklistIdnum) {
		TBlacklistIdnum blacklistIdnumBack = blacklistIdnumMapper.selectByPrimaryKey(blacklistIdnum.getTid());
		if (null == blacklistIdnumBack) {
			return new ResultBean("", "信息有误，启用失败！");
		} else if (blacklistIdnumBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该银行卡黑名单已启用！");
		}else {
			blacklistIdnum.setStatus(CommonConstants.LIST_STATUS_NORMAL);
			int count = blacklistIdnumMapper.updateByPrimaryKeySelective(blacklistIdnum);
			return count > 0 ? new ResultBean("启用成功！") : new ResultBean("", "启用失败！");
		}
	}

}
