package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.MerchDetaStatusEnums;
import com.unionpay.withhold.admin.mapper.TMerchDetaApplyMapper;
import com.unionpay.withhold.admin.mapper.TMerchDetaMapper;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TMerchDetaApply;
import com.unionpay.withhold.admin.pojo.TMerchDetaApplyExample;
import com.unionpay.withhold.admin.service.MerchDetaService;
import com.unionpay.withhold.utils.BeanCopyUtil;

@Service
@Transactional
public class MerchDetaServiceImpl implements MerchDetaService {
	@Autowired
	private TMerchDetaMapper merchDetaMapper;
	@Autowired
	private TMerchDetaApplyMapper merchDetaApplyMapper;
	
	
	@Override
	public PageBean selectInUseWithCondition(TMerchDeta merchDeta, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<String> statuses = new ArrayList<>();
		if (StringUtils.isBlank(merchDeta.getStatus())) {
			statuses.add(MerchDetaStatusEnums.NORMAL.getCode());// 在用的状态
		} else {
			statuses.add(merchDeta.getStatus());
		}

		List<TMerchDeta> list = merchDetaMapper.selectWithCondition(merchDeta, statuses, beginRow, rows);
		int count = merchDetaMapper.selectCountWithCondition(merchDeta, statuses);

		return new PageBean(count, list);
	}

	@Override
	public TMerchDeta queryMerchDetaModifyById(Integer merchId) {
		return merchDetaMapper.selectByPrimaryKey(merchId);
	}

	@Override
	public ResultBean updateMerchDetaInUse(TMerchDeta merchDeta) {
		// 判断状态，如果是非在用，禁止操作
		TMerchDeta merchDetaBack = this.merchDetaMapper.selectByPrimaryKey(merchDeta.getMerchId());
		if (merchDetaBack == null) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!merchDetaBack.getStatus().equals(MerchDetaStatusEnums.NORMAL.getCode())
				|| !merchDetaBack.getStatus().equals(merchDeta.getStatus())) {
			return new ResultBean("", "状态信息有误，请确保是否有其他人在操作，或刷新一下数据再试试！");
		} else {
			// 判断是否已经提交了，如果是，则驳回
			TMerchDetaApplyExample merchDetaApplyExample = new TMerchDetaApplyExample();
			TMerchDetaApplyExample.Criteria criteria = merchDetaApplyExample.createCriteria();
			criteria.andMerchIdEqualTo(merchDeta.getMerchId());
			criteria.andStatusIn(Arrays.asList(MerchDetaStatusEnums.UPDATEAFTERCHECKED.getCode(),
					MerchDetaStatusEnums.UPDATEAFTERCHECKEDREFUSED.getCode(),
					MerchDetaStatusEnums.LOGOUTCHECKING.getCode()
					//,MerchDetaStatusEnums.LOGOUTCHECKREFUSED.getCode()--注销被拒的，不再做业务处理
					));
			if (this.merchDetaApplyMapper.countByExample(merchDetaApplyExample)> 0) {
				return new ResultBean("", "已提交过注销或变更申请，不允许再次提交！");
			}

			// 把信息添加到申请表吧
			TMerchDetaApply merchDetaApply = BeanCopyUtil.copyBean(TMerchDetaApply.class, merchDeta);
			merchDetaApply.setInTime(merchDetaBack.getInTime());
			merchDetaApply.setInUser(merchDetaBack.getInUser());
			merchDetaApply.setRiskVer(merchDetaBack.getRiskVer());
			merchDetaApply.setRoutVer(merchDetaBack.getRoutVer());
			merchDetaApply.setStexaOpt(null);
			merchDetaApply.setStexaTime(null);
			merchDetaApply.setStexaUser(null);
			merchDetaApply.setStatus(MerchDetaStatusEnums.UPDATEAFTERCHECKED.getCode());
			int count = merchDetaApplyMapper.insertSelective(merchDetaApply);
			return count == 0 ? new ResultBean("", "信息变更提交失败，请稍后再试 ！") : new ResultBean("信息变更已提交成功 ！");
		}
	}

	@Override
	public ResultBean commitLogout(TMerchDeta merchDeta) {
		// 判断状态，如果是非在用，禁止操作
		TMerchDeta merchDetaBack = this.merchDetaMapper.selectByPrimaryKey(merchDeta.getMerchId());
		if (merchDetaBack == null) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!merchDetaBack.getStatus().equals(MerchDetaStatusEnums.NORMAL.getCode())
				|| !merchDetaBack.getStatus().equals(merchDeta.getStatus())) {
			return new ResultBean("", "状态信息有误，请确保是否有其他人在操作，或刷新一下数据再试试！");
		} else {
			// 判断是否已经提交了，如果是，则驳回
			TMerchDetaApplyExample merchDetaApplyExample = new TMerchDetaApplyExample();
			TMerchDetaApplyExample.Criteria criteria = merchDetaApplyExample.createCriteria();
			criteria.andMerchIdEqualTo(merchDeta.getMerchId());
			criteria.andStatusIn(Arrays.asList(MerchDetaStatusEnums.UPDATEAFTERCHECKED.getCode(),
					MerchDetaStatusEnums.UPDATEAFTERCHECKEDREFUSED.getCode(),
					MerchDetaStatusEnums.LOGOUTCHECKING.getCode()
					//,MerchDetaStatusEnums.LOGOUTCHECKREFUSED.getCode()--注销被拒的，不再做业务处理
					));
			if (this.merchDetaApplyMapper.countByExample(merchDetaApplyExample) > 0) {
				return new ResultBean("", "已提交过注销或变更申请，不允许再次提交！");
			}

			// 把信息添加到申请表吧
			TMerchDetaApply merchDetaApply = BeanCopyUtil.copyBean(TMerchDetaApply.class, merchDetaBack);
			merchDetaApply.setInTime(merchDetaBack.getInTime());
			merchDetaApply.setInUser(merchDetaBack.getInUser());
			merchDetaApply.setRiskVer(merchDetaBack.getRiskVer());
			merchDetaApply.setRoutVer(merchDetaBack.getRoutVer());
			merchDetaApply.setStexaOpt(null);
			merchDetaApply.setStexaTime(null);
			merchDetaApply.setStexaUser(null);
			merchDetaApply.setStatus(MerchDetaStatusEnums.LOGOUTCHECKING.getCode());
			int count = merchDetaApplyMapper.insertSelective(merchDetaApply);
			return count == 0 ? new ResultBean("", "注销申请提交失败，请稍后再试 ！") : new ResultBean("注销申请已提交成功 ！");
		}
	}

	

}
