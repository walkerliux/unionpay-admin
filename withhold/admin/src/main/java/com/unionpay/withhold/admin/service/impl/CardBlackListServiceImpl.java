package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.constant.CommonConstants;
import com.unionpay.withhold.admin.mapper.TBlacklistPanMapper;
import com.unionpay.withhold.admin.pojo.TBlacklistPan;
import com.unionpay.withhold.admin.pojo.TBlacklistPanExample;
import com.unionpay.withhold.admin.service.CardBlackListService;

@Service
@Transactional
public class CardBlackListServiceImpl implements CardBlackListService {
	@Autowired
	private TBlacklistPanMapper blacklistPanMapper;

	@Override
	public PageBean selectListWithCondition(TBlacklistPan blacklistPan, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<TBlacklistPan> cardBlackList = blacklistPanMapper.selectWithCondition(blacklistPan, beginRow, rows);
		int count = blacklistPanMapper.selectCountWithCondition(blacklistPan);
		return new PageBean(count, cardBlackList);
	}

	@Override
	public ResultBean addCardBlackList(TBlacklistPan blacklistPan) {
		// 验重
		TBlacklistPanExample blacklistPanExample = new TBlacklistPanExample();
		TBlacklistPanExample.Criteria criteria = blacklistPanExample.createCriteria();
		criteria.andPanEqualTo(blacklistPan.getPan());
		int count = blacklistPanMapper.countByExample(blacklistPanExample);
		if (count > 0) {
			return new ResultBean("", "该银行卡已存在！");
		}
		
		blacklistPan.setStatus(CommonConstants.LIST_STATUS_UNNORMAL);
		
		count = blacklistPanMapper.insertSelective(blacklistPan);
		return count > 0 ? new ResultBean("新银行卡黑名单添加成功！") : new ResultBean("", "新银行卡黑名单添加失败！");
	}

	@Override
	public TBlacklistPan queryCardBlackListByTid(Integer tid) {
		return blacklistPanMapper.selectByPrimaryKey(tid);
	}

	@Override
	public ResultBean updateCardBlackList(TBlacklistPan blacklistPan) {
		TBlacklistPan blacklistPanBack = blacklistPanMapper.selectByPrimaryKey(blacklistPan.getTid());
		if (null == blacklistPanBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!blacklistPanBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该银行卡黑名单未启用，不能修改！");
		}else {
			int count = blacklistPanMapper.updateByPrimaryKeySelective(blacklistPan);
			return count > 0 ? new ResultBean("修改成功！") : new ResultBean("", "修改失败！");
		}
	}

	@Override
	public ResultBean logoutCardBlackList(TBlacklistPan blacklistPan) {
		TBlacklistPan blacklistPanBack = blacklistPanMapper.selectByPrimaryKey(blacklistPan.getTid());
		if (null == blacklistPanBack) {
			return new ResultBean("", "信息有误，注销失败！");
		} else if (!blacklistPanBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该银行卡黑名单已被注销！");
		}else {
			blacklistPan.setStatus(CommonConstants.LIST_STATUS_UNNORMAL);
			int count = blacklistPanMapper.updateByPrimaryKeySelective(blacklistPan);
			return count > 0 ? new ResultBean("注销成功！") : new ResultBean("", "注销失败！");
		}
	}
	
	@Override
	public ResultBean startCardBlackList(TBlacklistPan blacklistPan) {
		TBlacklistPan blacklistPanBack = blacklistPanMapper.selectByPrimaryKey(blacklistPan.getTid());
		if (null == blacklistPanBack) {
			return new ResultBean("", "信息有误，启用失败！");
		} else if (blacklistPanBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该银行卡黑名单已启用！");
		}else {
			blacklistPan.setStatus(CommonConstants.LIST_STATUS_NORMAL);
			int count = blacklistPanMapper.updateByPrimaryKeySelective(blacklistPan);
			return count > 0 ? new ResultBean("启用成功！") : new ResultBean("", "启用失败！");
		}
	}

}
