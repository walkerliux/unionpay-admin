package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.CoopAgencyStatusEnums;
import com.unionpay.withhold.admin.mapper.TCoopAgencyApplyMapper;
import com.unionpay.withhold.admin.mapper.TCoopAgencyMapper;
import com.unionpay.withhold.admin.pojo.TCoopAgency;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApply;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApplyExample;
import com.unionpay.withhold.admin.pojo.TCoopAgencyExample;
import com.unionpay.withhold.admin.service.CoopAgencyApplyService;
import com.unionpay.withhold.utils.BeanCopyUtil;

@Service
@Transactional
public class CoopAgencyApplyServiceImpl implements CoopAgencyApplyService {
	@Autowired
	private TCoopAgencyApplyMapper coopAgencyApplyMapper;
	@Autowired
	private TCoopAgencyMapper coopAgencyMapper;

	@Override
	public PageBean queryByPage(TCoopAgencyApplyExample coopAgencyApplyExample) {
		int count = coopAgencyApplyMapper.countByExample(coopAgencyApplyExample);
		List<TCoopAgencyApply> list = coopAgencyApplyMapper.selectByExample(coopAgencyApplyExample);
		return new PageBean(count, list);
	}

	@Override
	public ResultBean addCoopAgencyApply(TCoopAgencyApply coopAgencyApply) {
		if (coopAgencyApply.getCacode().equals("0")) {
			return new ResultBean("", "渠道代码不能为0！");
		}
		int count;
		// 验重
		TCoopAgencyApplyExample coopAgencyApplyExample = new TCoopAgencyApplyExample();
		TCoopAgencyApplyExample.Criteria criteria = coopAgencyApplyExample.createCriteria();
		criteria.andCacodeEqualTo(coopAgencyApply.getCacode());
		criteria.andStatusNotEqualTo(CoopAgencyStatusEnums.REGISTERCHECKREFUSED.getCode());

		try {
			count = coopAgencyApplyMapper.countByExample(coopAgencyApplyExample);
			if (count > 0) {
				return new ResultBean("", "渠道代码重复！");
			}

			count = coopAgencyApplyMapper.insertSelective(coopAgencyApply);
			if (count > 0) {
				return new ResultBean("操作成功 ！");
			} else {
				return new ResultBean("", "添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultBean("", "服务异常，无法添加！");
		}

	}

	@Override
	public TCoopAgencyApply queryCoopAgencyApplyById(Long selfId) {
		return this.coopAgencyApplyMapper.selectByPrimaryKey(selfId);
	}

	@Override
	public ResultBean updateCoopAgencyApply(TCoopAgencyApply coopAgencyApply) {
		try {
			int count = coopAgencyApplyMapper.updateByPrimaryKeySelective(coopAgencyApply);
			if (count > 0) {
				return new ResultBean("操作成功 ！");
			} else {
				return new ResultBean("", "修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultBean("", "服务异常，无法修改！");
		}
	}

	@Override
	public PageBean selectWithCondition(TCoopAgencyApply coopAgencyApply, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page -1) * rows; 
		List<String> statuses = new ArrayList<>();
		if (StringUtils.isBlank(coopAgencyApply.getStatus())) {
			statuses.add(CoopAgencyStatusEnums.REGISTERCHECKING.getCode());// 注册待审
			statuses.add(CoopAgencyStatusEnums.UPDATEAFTERCHECKED.getCode());// 变更待审
			statuses.add(CoopAgencyStatusEnums.LOGOUTCHECKING.getCode());// 注销待审		
		} else {
			statuses.add(coopAgencyApply.getStatus());
		}
		
		List<TCoopAgencyApply> list = coopAgencyApplyMapper.selectWithCondition(coopAgencyApply, statuses, beginRow, rows);
		int count = coopAgencyApplyMapper.selectCountWithCondition(coopAgencyApply, statuses);
		
		return new PageBean(count, list);
	}

	@Override
	public TCoopAgencyApply queryCoopAgencyCheckById(Long selfId) {
		return coopAgencyApplyMapper.selectCoopAgencyDetailById(selfId);
	}

	@Override
	public ResultBean refuseCheck(TCoopAgencyApply coopAgencyApply) {
		CoopAgencyStatusEnums status = null;
		// 判断状态，如果是已经非待审，禁止操作
		TCoopAgencyApply agencyApplyBack = this.coopAgencyApplyMapper.selectByPrimaryKey(coopAgencyApply.getSelfId());
		if (agencyApplyBack == null) {
			return new ResultBean("", "信息有误，操作失败！");
		}else if (!agencyApplyBack.getStatus().equals(coopAgencyApply.getStatus())) {
			return new ResultBean("", "状态信息有误，请确保是有其他人在操作！");
		}else {
			// 根据状态判断是哪种操作，再进行状态变更
			if (coopAgencyApply.getStatus().equals(CoopAgencyStatusEnums.REGISTERCHECKING.getCode())) {// 注册待审
				status = CoopAgencyStatusEnums.REGISTERCHECKREFUSED;
			} else if (coopAgencyApply.getStatus().equals(CoopAgencyStatusEnums.UPDATEAFTERCHECKED.getCode())) {// 变更待审
				status = CoopAgencyStatusEnums.UPDATEAFTERCHECKEDREFUSED;
			} else if (coopAgencyApply.getStatus().equals(CoopAgencyStatusEnums.LOGOUTCHECKING.getCode())) {// 注销待审
				status = CoopAgencyStatusEnums.LOGOUTCHECKREFUSED;
			}
		}
		coopAgencyApply.setStatus(status.getCode());
		coopAgencyApply.setStexaTime(new Date());
		
		long count = this.coopAgencyApplyMapper.updateByPrimaryKeySelective(coopAgencyApply);		
		if (count > 0) {
			return new ResultBean("审核拒绝操作成功 ！");
		} else {
			return new ResultBean("", "审核拒绝操作失败！");
		}
	}

	@Override
	public ResultBean passCheck(TCoopAgencyApply coopAgencyApply) {
		// 判断状态，如果是已经非待审，禁止操作
		TCoopAgencyApply agencyApplyBack = this.coopAgencyApplyMapper.selectByPrimaryKey(coopAgencyApply.getSelfId());
		if (agencyApplyBack == null) {
			return new ResultBean("", "信息有误，操作失败！");
		}else if (!agencyApplyBack.getStatus().equals(coopAgencyApply.getStatus())) {
			return new ResultBean("", "状态信息有误，请确保是有其他人在操作！");
		}else {
			// 根据状态判断是哪种操作
			if (coopAgencyApply.getStatus().equals(CoopAgencyStatusEnums.REGISTERCHECKING.getCode())) {
				// 注册待审：修改申请表的状态为“不在用”，并添加数据到在用的表中
				coopAgencyApply.setStexaTime(new Date());
				coopAgencyApply.setStatus(CoopAgencyStatusEnums.UNNORMAL.getCode());
				this.coopAgencyApplyMapper.updateByPrimaryKeySelective(coopAgencyApply);
				
				TCoopAgency coopAgency = BeanCopyUtil.copyBean(TCoopAgency.class, agencyApplyBack);
				coopAgency.setStatus(CoopAgencyStatusEnums.NORMAL.getCode());
				coopAgency.setStexaUser(coopAgencyApply.getStexaUser());
				coopAgency.setStexaTime(coopAgencyApply.getStexaTime());
				coopAgency.setCaid(null);
				coopAgencyMapper.insertSelective(coopAgency);
				
			} else if (coopAgencyApply.getStatus().equals(CoopAgencyStatusEnums.UPDATEAFTERCHECKED.getCode())) {
				// 变更待审：修改在用表中的状态为“不在用”，修改申请表的状态为“不在用”，并添加新数据到在用的表中
				TCoopAgency coopAgency = new TCoopAgency();
				coopAgency.setCaid(agencyApplyBack.getCaid());
				coopAgency.setStatus(CoopAgencyStatusEnums.UNNORMAL.getCode());
				coopAgency.setStexaUser(coopAgencyApply.getStexaUser());
				coopAgency.setStexaTime(new Date());
				coopAgencyMapper.updateByPrimaryKeySelective(coopAgency);
				
				coopAgencyApply.setStexaTime(coopAgency.getStexaTime());
				coopAgencyApply.setStatus(CoopAgencyStatusEnums.UNNORMAL.getCode());
				this.coopAgencyApplyMapper.updateByPrimaryKeySelective(coopAgencyApply);
				
				coopAgency = BeanCopyUtil.copyBean(TCoopAgency.class, agencyApplyBack);
				coopAgency.setStatus(CoopAgencyStatusEnums.NORMAL.getCode());
				coopAgency.setStexaUser(coopAgencyApply.getStexaUser());
				coopAgency.setStexaTime(coopAgencyApply.getStexaTime());
				coopAgency.setCaid(null);
				coopAgencyMapper.insertSelective(coopAgency);
			} else if (coopAgencyApply.getStatus().equals(CoopAgencyStatusEnums.LOGOUTCHECKING.getCode())) {
				// 注销待审：先判断是否有下级渠道
				TCoopAgencyExample coopAgencyExample = new TCoopAgencyExample();
				TCoopAgencyExample.Criteria criteria = coopAgencyExample.createCriteria();
				criteria.andSupercodeEqualTo(agencyApplyBack.getCacode());
				criteria.andStatusEqualTo(CoopAgencyStatusEnums.NORMAL.getCode());
				long count = coopAgencyMapper.countByExample(coopAgencyExample);
				if (count > 0) {
					return new ResultBean("", "还有在用的下级渠道，不能注销！");
				} else {
					// 修改在用表中的状态为“不在用”，修改申请表的状态为“不在用”
					TCoopAgency coopAgency = new TCoopAgency();
					coopAgency.setCaid(agencyApplyBack.getCaid());
					coopAgency.setStatus(CoopAgencyStatusEnums.UNNORMAL.getCode());
					coopAgency.setStexaUser(coopAgencyApply.getStexaUser());
					coopAgency.setStexaTime(coopAgency.getStexaTime());
					coopAgencyMapper.updateByPrimaryKeySelective(coopAgency);
					
					coopAgencyApply.setStexaTime(new Date());
					coopAgencyApply.setStatus(CoopAgencyStatusEnums.UNNORMAL.getCode());
					this.coopAgencyApplyMapper.updateByPrimaryKeySelective(coopAgencyApply);
				}
			}
		}
		
		return new ResultBean("审核拒绝操作成功 ！");
	}
}
