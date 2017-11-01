package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.constant.CommonConstants;
import com.unionpay.withhold.admin.mapper.TLimitSingleMapper;
import com.unionpay.withhold.admin.pojo.TLimitSingle;
import com.unionpay.withhold.admin.pojo.TLimitSingleExample;
import com.unionpay.withhold.admin.service.LimitSingleService;

@Service
@Transactional
public class LimitSingleServiceImpl implements LimitSingleService {

	@Autowired
	private TLimitSingleMapper limitSingleMapper;
	@Override
	public PageBean selectListWithCondition(TLimitSingle limitSingle, Integer page, Integer rows) {
		// 查分页数据
				Integer beginRow = (page - 1) * rows;
				List<TLimitSingle> limitSingleList = limitSingleMapper.selectWithCondition(limitSingle, beginRow, rows);
				int count = limitSingleMapper.selectCountWithCondition(limitSingle);
				return new PageBean(count, limitSingleList);
	}
	@Override
	public ResultBean addLimitSingle(TLimitSingle limitSingle) {
		// 判断参数
		if (limitSingle == null || limitSingle.getMaxAmount() == null || limitSingle.getMinAmount() == null || limitSingle.getCaseid() == null || limitSingle.getRisklevel() == null) {
			return new ResultBean("", "提交的单笔限额信息有误！");
		} else if (limitSingle.getMinAmount().compareTo(limitSingle.getMaxAmount()) >= 0) {
			return new ResultBean("", "最大限额应当大于最小限额！");
		}
		
		// 验重、范围是否冲突、风险等级是否冲突
		TLimitSingleExample limitSingleExample = new TLimitSingleExample();
		TLimitSingleExample.Criteria criteria = limitSingleExample.createCriteria();
		criteria.andCaseidEqualTo(limitSingle.getCaseid());
		int count = limitSingleMapper.countByExample(limitSingleExample);
		if (count > 0) { //已存在该风控实例的单笔限额
			// 金额范围是否有交集
			count = limitSingleMapper.selectIntersectionCount(limitSingle);
			if (count > 0) {
				return new ResultBean("", "您所填写的单笔限额范围与该风控版本已存在的单笔限额范围有冲突！");
			}else {
				// 验风险等级是否有冲突
				count = limitSingleMapper.selectRiskConflictCount(limitSingle);					
				if ( count > 0) return new ResultBean("", "您所填写的单笔限额范围的风险等级与该风控版本已存在的风险等级有冲突！");
			}
		}
		
		limitSingle.setStatus(CommonConstants.LIST_STATUS_UNNORMAL);
		count = limitSingleMapper.insertSelective(limitSingle);
		return count > 0 ? new ResultBean("新单笔限额添加成功！") : new ResultBean("", "新单笔限额添加失败！");
	}
	@Override
	public TLimitSingle queryLimitSingleById(Integer tid) {
		return this.limitSingleMapper.selectByPrimaryKey(tid);
	}
	@Override
	public ResultBean updateLimitSingle(TLimitSingle limitSingle) {
		// 判断参数
		if (limitSingle == null || limitSingle.getMaxAmount() == null || limitSingle.getMinAmount() == null || limitSingle.getRisklevel() == null) {
			return new ResultBean("", "提交的单笔限额信息有误！");
		} else if (limitSingle.getMinAmount().compareTo(limitSingle.getMaxAmount()) >= 0) {
			return new ResultBean("", "最大限额应当大于最小限额！");
		}
				
		TLimitSingle limitSingleBack = limitSingleMapper.selectByPrimaryKey(limitSingle.getTid());
		if (null == limitSingleBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!limitSingleBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该单笔限额规则未启用，不能修改！");
		}else {
			limitSingle.setCaseid(limitSingleBack.getCaseid());
			
			// 验重、范围是否冲突、风险等级是否冲突
			TLimitSingleExample limitSingleExample = new TLimitSingleExample();
			TLimitSingleExample.Criteria criteria = limitSingleExample.createCriteria();
			criteria.andCaseidEqualTo(limitSingle.getCaseid());
			int count = limitSingleMapper.countByExample(limitSingleExample);
			if (count > 0) { //已存在该风控实例的单笔限额
				// 金额范围是否有交集
				count = limitSingleMapper.selectIntersectionCount(limitSingle);
				if (count > 0) {
					return new ResultBean("", "您所填写的单笔限额范围与该风控版本已存在的单笔限额范围有冲突！");
				}else {
					// 验风险等级是否有冲突
					count = limitSingleMapper.selectRiskConflictCount(limitSingle);					
					if ( count > 0) return new ResultBean("", "您所填写的单笔限额范围的风险等级与该风控版本已存在的风险等级有冲突！");
				}
			}
			
			count = limitSingleMapper.updateByPrimaryKeySelective(limitSingle);
			return count > 0 ? new ResultBean("修改成功！") : new ResultBean("", "修改失败！");
		}
	}
	@Override
	public ResultBean logoutLimitSingle(TLimitSingle limitSingle) {
		TLimitSingle limitSingleBack = limitSingleMapper.selectByPrimaryKey(limitSingle.getTid());
		if (null == limitSingleBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!limitSingleBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该单笔限额规则已被注销！");
		}else {
			limitSingle.setStatus(CommonConstants.LIST_STATUS_UNNORMAL);
			int count = limitSingleMapper.updateByPrimaryKeySelective(limitSingle);
			return count > 0 ? new ResultBean("注销成功！") : new ResultBean("", "注销失败！");
		}
	}
	@Override
	public ResultBean startLimitSingle(TLimitSingle limitSingle) {
		TLimitSingle limitSingleBack = limitSingleMapper.selectByPrimaryKey(limitSingle.getTid());
		if (null == limitSingleBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (limitSingleBack.getStatus().equals(CommonConstants.LIST_STATUS_NORMAL)) {
			return new ResultBean("", "该单笔限额规则已启用！");
		}else {
			limitSingle.setStatus(CommonConstants.LIST_STATUS_NORMAL);
			int count = limitSingleMapper.updateByPrimaryKeySelective(limitSingle);
			return count > 0 ? new ResultBean("启用成功！") : new ResultBean("", "启用失败！");
		}
	}

}
