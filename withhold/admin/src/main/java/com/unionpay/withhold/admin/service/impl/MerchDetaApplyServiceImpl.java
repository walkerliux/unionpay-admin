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
import com.unionpay.withhold.admin.enums.MerchDetaStatusEnums;
import com.unionpay.withhold.admin.mapper.TMerchDetaApplyMapper;
import com.unionpay.withhold.admin.mapper.TMerchDetaMapper;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TMerchDetaApply;
import com.unionpay.withhold.admin.pojo.TMerchDetaApplyExample;
import com.unionpay.withhold.admin.service.MerchDetaApplyService;
import com.unionpay.withhold.utils.BeanCopyUtil;

@Service
@Transactional
public class MerchDetaApplyServiceImpl implements MerchDetaApplyService {
	@Autowired
	private TMerchDetaApplyMapper merchDetaApplyMapper;
	@Autowired
	private TMerchDetaMapper merchDetaMapper;

	@Override
	public PageBean selectApplyWithCondition(TMerchDetaApply merchDetaApply, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<String> statuses = new ArrayList<>();

		if (StringUtils.isBlank(merchDetaApply.getStatus())) {
			statuses.add(MerchDetaStatusEnums.REGISTERCHECKING.getCode());// 注册待审
			statuses.add(MerchDetaStatusEnums.REGISTERCHECKREFUSED.getCode());// 注册审核拒绝
			statuses.add(MerchDetaStatusEnums.UPDATEAFTERCHECKEDREFUSED.getCode());// 变更被拒
			statuses.add(MerchDetaStatusEnums.LOGOUTCHECKREFUSED.getCode());// 注销被拒
		} else {
			statuses.add(merchDetaApply.getStatus());
		}

		List<TMerchDetaApply> list = merchDetaApplyMapper.selectWithCondition(merchDetaApply, statuses, beginRow,
				rows);
		int count = merchDetaApplyMapper.selectCountWithCondition(merchDetaApply, statuses);

		return new PageBean(count, list);
	}

	@Override
	public ResultBean addMerchDetaApply(TMerchDetaApply merchDetaApply) {
		// 验重
		TMerchDetaApplyExample merchDetaApplyExample = new TMerchDetaApplyExample();
		TMerchDetaApplyExample.Criteria criteria = merchDetaApplyExample.createCriteria();
		criteria.andMemberIdEqualTo(merchDetaApply.getMemberId());
		int count = merchDetaApplyMapper.countByExample(merchDetaApplyExample);
		if (count > 0) {
			return new ResultBean("", "此商户号已被注册过！");
		}

		merchDetaApply.setStatus(MerchDetaStatusEnums.REGISTERCHECKING.getCode());
		merchDetaApply.setInTime(new Date());

		// 添加
		count = merchDetaApplyMapper.insertSelective(merchDetaApply);
		if (count > 0) {
			return new ResultBean("操作成功 ！");
		} else {
			return new ResultBean("", "新增商户失败！");
		}
	}

	@Override
	public TMerchDetaApply queryMerchDetaApplyById(Integer selfId) {
		return merchDetaApplyMapper.selectByPrimaryKey(selfId.intValue());
	}

	@Override
	public ResultBean updateMerchDetaApply(TMerchDetaApply merchDetaApply) {
		// 判断状态，非正常的禁止操作
		TMerchDetaApply merchDetaApplyBack = this.merchDetaApplyMapper.selectByPrimaryKey(merchDetaApply.getSelfId());
		if (merchDetaApplyBack == null) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!merchDetaApplyBack.getStatus().equals(merchDetaApply.getStatus())) {
			return new ResultBean("", "状态信息有误，请确保是否有其他人在操作，或刷新一下数据再试试！");
		} else {
			MerchDetaStatusEnums status = null;

			// 根据状态判断是哪种操作，再进行状态变更
			if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.REGISTERCHECKING.getCode())) {// 注册待审——不变
				status = MerchDetaStatusEnums.REGISTERCHECKING;
			} else if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.REGISTERCHECKREFUSED.getCode())) {// 注册被拒——待审
				status = MerchDetaStatusEnums.REGISTERCHECKING;
			} else if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.UPDATEAFTERCHECKEDREFUSED.getCode())) {// 变更被拒——待审
				status = MerchDetaStatusEnums.UPDATEAFTERCHECKED;
			} else if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.LOGOUTCHECKREFUSED.getCode())) {// 注销被拒——待审
				status = MerchDetaStatusEnums.LOGOUTCHECKING;
			} else {
				return new ResultBean("", "信息有误，操作失败！");
			}

			merchDetaApply.setStatus(status.getCode());
			int count = merchDetaApplyMapper.updateByPrimaryKeySelective(merchDetaApply);

			if (count > 0) {
				return new ResultBean("操作成功 ！");
			} else {
				return new ResultBean("", "变更商户信息失败！");
			}
		}
	}

	@Override
	public PageBean selectCheckWithCondition(TMerchDetaApply merchDetaApply, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<String> statuses = new ArrayList<>();
		if (StringUtils.isBlank(merchDetaApply.getStatus())) {
			statuses.add(MerchDetaStatusEnums.REGISTERCHECKING.getCode());// 注册待审
			statuses.add(MerchDetaStatusEnums.UPDATEAFTERCHECKED.getCode());// 变更待审
			statuses.add(MerchDetaStatusEnums.LOGOUTCHECKING.getCode());// 注销待审
		} else {
			statuses.add(merchDetaApply.getStatus());
		}

		List<TMerchDetaApply> list = merchDetaApplyMapper.selectWithCondition(merchDetaApply, statuses, beginRow,
				rows);
		int count = merchDetaApplyMapper.selectCountWithCondition(merchDetaApply, statuses);

		return new PageBean(count, list);
	}

	@Override
	public TMerchDetaApply queryMerchDetaCheckById(Integer selfId) {
		return this.merchDetaApplyMapper.selectMerchDetailById(selfId);
	}

	@Override
	public ResultBean refuseCheck(TMerchDetaApply merchDetaApply) {
		MerchDetaStatusEnums status = null;
		// 判断状态，非正常状态，禁止操作
		TMerchDetaApply merchDetaApplyBack = this.merchDetaApplyMapper.selectByPrimaryKey(merchDetaApply.getSelfId());
		if (merchDetaApplyBack == null) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!merchDetaApplyBack.getStatus().equals(merchDetaApply.getStatus())) {
			return new ResultBean("", "状态信息有误，请确保是有其他人在操作，或刷新一下数据再试试！");
		} else {
			// 根据状态判断是哪种操作，再进行状态变更
			if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.REGISTERCHECKING.getCode())) {// 注册待审
				status = MerchDetaStatusEnums.REGISTERCHECKREFUSED;
			} else if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.UPDATEAFTERCHECKED.getCode())) {// 变更待审
				status = MerchDetaStatusEnums.UPDATEAFTERCHECKEDREFUSED;
			} else if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.LOGOUTCHECKING.getCode())) {// 注销待审
				status = MerchDetaStatusEnums.LOGOUTCHECKREFUSED;
			} else {
				return new ResultBean("", "信息有误，操作失败！");
			}
		}
		merchDetaApply.setStatus(status.getCode());
		merchDetaApply.setStexaTime(new Date());

		long count = this.merchDetaApplyMapper.updateByPrimaryKeySelective(merchDetaApply);
		if (count > 0) {
			return new ResultBean("审核拒绝操作成功 ！");
		} else {
			return new ResultBean("", "审核拒绝操作失败！");
		}
	}

	@Override
	public ResultBean passCheck(TMerchDetaApply merchDetaApply) {
		// 判断状态，非正常状态，禁止操作
		TMerchDetaApply merchDetaApplyBack = this.merchDetaApplyMapper.selectByPrimaryKey(merchDetaApply.getSelfId());
		if (merchDetaApplyBack == null) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!merchDetaApplyBack.getStatus().equals(merchDetaApply.getStatus())) {
			return new ResultBean("", "状态信息有误，请确保是有其他人在操作，或刷新一下数据再试试！");
		} else {
			// 根据状态判断是哪种操作
			if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.REGISTERCHECKING.getCode())) {
				// 注册待审：修改申请表的状态为“在用”，并添加数据到在用的表中
				Date now = new Date();
				merchDetaApply.setStexaTime(now);
				merchDetaApply.setStatus(MerchDetaStatusEnums.NORMAL.getCode());
				this.merchDetaApplyMapper.updateByPrimaryKeySelective(merchDetaApply);
				
				TMerchDeta merchDeta = BeanCopyUtil.copyBean(TMerchDeta.class, merchDetaApplyBack);
				merchDeta.setStatus(MerchDetaStatusEnums.NORMAL.getCode());
				merchDeta.setStexaUser(merchDetaApply.getStexaUser());
				merchDeta.setStexaTime(merchDetaApply.getStexaTime());
				merchDeta.setMerchId(null);
				merchDetaMapper.insertSelective(merchDeta);
			} else if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.UPDATEAFTERCHECKED.getCode())) {
				// 变更待审：修改申请表的状态为“在用”，更新在用表中的信息
				Date now = new Date();
				/*TMerchDeta merchDeta = new TMerchDeta();
				merchDeta.setMerchId(merchDetaApplyBack.getMerchId());
				merchDeta.setStatus(MerchDetaStatusEnums.UNNORMAL.getCode());
				merchDeta.setStexaUser(merchDetaApply.getStexaUser());
				merchDeta.setStexaTime(now);
				merchDetaMapper.updateByPrimaryKeySelective(merchDeta);*/

				merchDetaApply.setStexaTime(now);
				merchDetaApply.setStatus(MerchDetaStatusEnums.NORMAL.getCode());
				this.merchDetaApplyMapper.updateByPrimaryKeySelective(merchDetaApply);

				TMerchDeta merchDeta = new TMerchDeta();
				merchDeta = BeanCopyUtil.copyBean(TMerchDeta.class, merchDetaApplyBack);
				merchDeta.setStatus(MerchDetaStatusEnums.NORMAL.getCode());
				merchDeta.setStexaUser(merchDetaApply.getStexaUser());
				merchDeta.setStexaTime(now);
				//merchDeta.setMerchId(null);
				merchDetaMapper.updateByPrimaryKeySelective(merchDeta);
			} else if (merchDetaApply.getStatus().equals(MerchDetaStatusEnums.LOGOUTCHECKING.getCode())) {// 注销待审
				// 注销待审：修改在用表中的状态为“不在用”，修改申请表的状态为“不在用”
				Date now = new Date();
				TMerchDeta merchDeta = new TMerchDeta();
				merchDeta.setMerchId(merchDetaApplyBack.getMerchId());
				merchDeta.setStatus(MerchDetaStatusEnums.UNNORMAL.getCode());
				merchDeta.setStexaUser(merchDetaApply.getStexaUser());
				merchDeta.setStexaTime(now);
				merchDetaMapper.updateByPrimaryKeySelective(merchDeta);
				
				merchDetaApply.setStexaTime(new Date());
				merchDetaApply.setStatus(MerchDetaStatusEnums.UNNORMAL.getCode());
				this.merchDetaApplyMapper.updateByPrimaryKeySelective(merchDetaApply);
			} else {
				return new ResultBean("", "信息有误，操作失败！");
			}
		}
		return new ResultBean("审核通过操作成功 ！");
	}

	@Override
	public PageBean selectAllWithCondition(TMerchDetaApply merchDetaApply, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;		
		List<TMerchDetaApply> list = merchDetaApplyMapper.selectAllWithCondition(merchDetaApply, beginRow, rows);
		int count = merchDetaApplyMapper.selectAllCountWithCondition(merchDetaApply);

		return new PageBean(count, list);
	}

	@Override
	public TMerchDetaApply queryMerchDetaById(Integer selfId) {
		return this.merchDetaApplyMapper.selectMerchDetailById(selfId);
	}

}
