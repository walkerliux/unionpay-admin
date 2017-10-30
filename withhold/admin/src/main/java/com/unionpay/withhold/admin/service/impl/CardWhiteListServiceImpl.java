package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.constant.CommonConstants;
import com.unionpay.withhold.admin.mapper.TWhitelistPanMapper;
import com.unionpay.withhold.admin.pojo.TWhitelistPan;
import com.unionpay.withhold.admin.pojo.TWhitelistPanExample;
import com.unionpay.withhold.admin.service.CardWhiteListService;

@Service
@Transactional
public class CardWhiteListServiceImpl implements CardWhiteListService {
	@Autowired
	private TWhitelistPanMapper whitelistPanMapper;

	@Override
	public PageBean selectListWithCondition(TWhitelistPan whitelistPan, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<TWhitelistPan> cardWhiteList = whitelistPanMapper.selectWithCondition(whitelistPan, beginRow, rows);
		int count = whitelistPanMapper.selectCountWithCondition(whitelistPan);
		return new PageBean(count, cardWhiteList);
	}

	@Override
	public ResultBean addCardWhiteList(TWhitelistPan whitelistPan) {
		// 验重
		TWhitelistPanExample whitelistPanExample = new TWhitelistPanExample();
		TWhitelistPanExample.Criteria criteria = whitelistPanExample.createCriteria();
		criteria.andPanEqualTo(whitelistPan.getPan());
		int count = whitelistPanMapper.countByExample(whitelistPanExample);
		if (count > 0) {
			return new ResultBean("", "该银行卡已存在！");
		}
		
		whitelistPan.setStatus(CommonConstants.LIST_STATUS_UNNORMAL);
		
		count = whitelistPanMapper.insertSelective(whitelistPan);
		return count > 0 ? new ResultBean("新银行卡白名单添加成功！") : new ResultBean("", "新银行卡白名单添加失败！");
	}

	@Override
	public TWhitelistPan queryCardWhiteListByTid(Integer tid) {
		return whitelistPanMapper.selectByPrimaryKey(tid);
	}

	@Override
	public ResultBean updateCardWhiteList(TWhitelistPan whitelistPan) {
		TWhitelistPan whitelistPanBack = whitelistPanMapper.selectByPrimaryKey(whitelistPan.gettId());
		if (null == whitelistPanBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!whitelistPanBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该银行卡白名单未启用，不能修改！");
		}else {
			int count = whitelistPanMapper.updateByPrimaryKeySelective(whitelistPan);
			return count > 0 ? new ResultBean("修改成功！") : new ResultBean("", "修改失败！");
		}
	}

	@Override
	public ResultBean logoutCardWhiteList(TWhitelistPan whitelistPan) {
		TWhitelistPan whitelistPanBack = whitelistPanMapper.selectByPrimaryKey(whitelistPan.gettId());
		if (null == whitelistPanBack) {
			return new ResultBean("", "信息有误，注销失败！");
		} else if (!whitelistPanBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该银行卡白名单已被注销！");
		}else {
			whitelistPan.setStatus(CommonConstants.LIST_STATUS_UNNORMAL);
			int count = whitelistPanMapper.updateByPrimaryKeySelective(whitelistPan);
			return count > 0 ? new ResultBean("注销成功！") : new ResultBean("", "注销失败！");
		}
	}
	
	@Override
	public ResultBean startCardWhiteList(TWhitelistPan whitelistPan) {
		TWhitelistPan whitelistPanBack = whitelistPanMapper.selectByPrimaryKey(whitelistPan.gettId());
		if (null == whitelistPanBack) {
			return new ResultBean("", "信息有误，启用失败！");
		} else if (whitelistPanBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该银行卡白名单已启用！");
		}else {
			whitelistPan.setStatus(CommonConstants.LIST_STATUS_NORMAL);
			int count = whitelistPanMapper.updateByPrimaryKeySelective(whitelistPan);
			return count > 0 ? new ResultBean("启用成功！") : new ResultBean("", "启用失败！");
		}
	}

}
