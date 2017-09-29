package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.unionpay.withhold.admin.service.CoopAgencyService;
import com.unionpay.withhold.utils.BeanCopyUtil;

@Service
@Transactional
public class CoopAgencyServiceImpl implements CoopAgencyService {
	@Autowired
	private TCoopAgencyMapper coopAgencyMapper;
	@Autowired
	private TCoopAgencyApplyMapper coopAgencyApplyMapper;

	@Override
	public List<TCoopAgency> queryAllSuperCode(String supercode) {
		return coopAgencyMapper.selectAllSuperCode(supercode);
	}

	@Override
	public PageBean selectInUseWithCondition(TCoopAgency coopAgency, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<String> statuses = new ArrayList<>();
		if (StringUtils.isBlank(coopAgency.getStatus())) {
			statuses.add(CoopAgencyStatusEnums.NORMAL.getCode());// 在用的状态
		} else {
			statuses.add(coopAgency.getStatus());
		}

		List<TCoopAgency> list = coopAgencyMapper.selectWithCondition(coopAgency, statuses, beginRow, rows);
		int count = coopAgencyMapper.selectCountWithCondition(coopAgency, statuses);

		return new PageBean(count, list);
	}

	@Override
	public TCoopAgency queryCoopAgencyModifyById(Long caid) {
		return coopAgencyMapper.selectCoopAgencyDetailById(caid);
	}

	@Override
	public ResultBean updateCoopAgencyInUse(TCoopAgency coopAgency) {
		// 判断状态，如果是非在用，禁止操作
		TCoopAgency agencyBack = this.coopAgencyMapper.selectByPrimaryKey(coopAgency.getCaid());
		if (agencyBack == null) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!agencyBack.getStatus().equals(CoopAgencyStatusEnums.NORMAL.getCode())
				|| !agencyBack.getStatus().equals(coopAgency.getStatus())) {
			return new ResultBean("", "状态信息有误，请确保是否有其他人在操作，或刷新一下数据再试试！");
		} else if (agencyBack.getCacode().equals(coopAgency.getSupercode())) {
			// 上级渠道不能为自己
			return new ResultBean("", "上级渠道不能选择自己！");
		} else {
			// 判断是否已经提交了，如果是，则驳回
			TCoopAgencyApplyExample coopAgencyApplyExample = new TCoopAgencyApplyExample();
			TCoopAgencyApplyExample.Criteria criteria = coopAgencyApplyExample.createCriteria();
			criteria.andCaidEqualTo(coopAgency.getCaid());
			criteria.andStatusIn(Arrays.asList(CoopAgencyStatusEnums.UPDATEAFTERCHECKED.getCode(),
					CoopAgencyStatusEnums.UPDATEAFTERCHECKEDREFUSED.getCode(),
					CoopAgencyStatusEnums.LOGOUTCHECKING.getCode(),
					CoopAgencyStatusEnums.LOGOUTCHECKREFUSED.getCode()));
			if (this.coopAgencyApplyMapper.countByExample(coopAgencyApplyExample) > 0) {
				return new ResultBean("", "已提交过注销或变更申请，不允许再次提交！");
			}

			// 把信息添加到申请表吧
			TCoopAgencyApply coopAgencyApply = BeanCopyUtil.copyBean(TCoopAgencyApply.class, coopAgency);
			coopAgencyApply.setIntime(new Date());
			coopAgencyApply.setInuser(coopAgency.getInuser());
			if (coopAgency.getSupercode().equals("0")) {
				coopAgencyApply.setCalevel((short) 1);
			}
			coopAgencyApply.setStatus(CoopAgencyStatusEnums.UPDATEAFTERCHECKED.getCode());
			int count = coopAgencyApplyMapper.insertSelective(coopAgencyApply);
			return count == 0 ? new ResultBean("", "信息变更提交失败，请稍后再试 ！") : new ResultBean("信息变更已提交成功 ！");
		}
	}

	@Override
	public ResultBean commitLogout(TCoopAgency coopAgency) {
		// 判断状态，如果是非在用，禁止操作
		TCoopAgency agencyBack = this.coopAgencyMapper.selectByPrimaryKey(coopAgency.getCaid());
		if (agencyBack == null) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!agencyBack.getStatus().equals(CoopAgencyStatusEnums.NORMAL.getCode())
				|| !agencyBack.getStatus().equals(coopAgency.getStatus())) {
			return new ResultBean("", "状态信息有误，请确保是否有其他人在操作，或刷新一下数据再试试！");
		} else {
			// 判断是否已经提交了，如果是，则驳回
			TCoopAgencyApplyExample coopAgencyApplyExample = new TCoopAgencyApplyExample();
			TCoopAgencyApplyExample.Criteria criteria = coopAgencyApplyExample.createCriteria();
			criteria.andCaidEqualTo(coopAgency.getCaid());
			criteria.andStatusIn(Arrays.asList(CoopAgencyStatusEnums.UPDATEAFTERCHECKED.getCode(),
					CoopAgencyStatusEnums.UPDATEAFTERCHECKEDREFUSED.getCode(),
					CoopAgencyStatusEnums.LOGOUTCHECKING.getCode(),
					CoopAgencyStatusEnums.LOGOUTCHECKREFUSED.getCode()));
			if (this.coopAgencyApplyMapper.countByExample(coopAgencyApplyExample) > 0) {
				return new ResultBean("", "已提交过注销或变更申请，不允许再次提交！");
			}

			// 把信息添加到申请表吧
			TCoopAgencyApply coopAgencyApply = BeanCopyUtil.copyBean(TCoopAgencyApply.class, agencyBack);
			coopAgencyApply.setIntime(new Date());
			coopAgencyApply.setInuser(coopAgency.getInuser());
			coopAgencyApply.setStexaOpt(null);
			coopAgencyApply.setStexaTime(null);
			coopAgencyApply.setStexaUser(null);
			coopAgencyApply.setStatus(CoopAgencyStatusEnums.LOGOUTCHECKING.getCode());
			int count = coopAgencyApplyMapper.insertSelective(coopAgencyApply);
			return count == 0 ? new ResultBean("", "注销申请提交失败，请稍后再试 ！") : new ResultBean("注销申请已提交成功 ！");
		}
	}

}
