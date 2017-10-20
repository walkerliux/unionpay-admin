package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.CardTypeEnums;
import com.unionpay.withhold.admin.enums.ChannelStatusEnums;
import com.unionpay.withhold.admin.enums.MerchSetlFlgEnums;
import com.unionpay.withhold.admin.enums.MerchTargetTypeEnums;
import com.unionpay.withhold.admin.mapper.TChnlBankMapper;
import com.unionpay.withhold.admin.mapper.TChnlDetaMapper;
import com.unionpay.withhold.admin.mapper.TChnlFlowControlMapper;
import com.unionpay.withhold.admin.mapper.TMerchRateConfigMapper;
import com.unionpay.withhold.admin.mapper.TRateAccumMapper;
import com.unionpay.withhold.admin.pojo.TChnlBank;
import com.unionpay.withhold.admin.pojo.TChnlBankExample;
import com.unionpay.withhold.admin.pojo.TChnlDeta;
import com.unionpay.withhold.admin.pojo.TChnlDetaExample;
import com.unionpay.withhold.admin.pojo.TChnlFlowControl;
import com.unionpay.withhold.admin.pojo.TChnlFlowControlExample;
import com.unionpay.withhold.admin.pojo.TMerchRateConfig;
import com.unionpay.withhold.admin.pojo.TRateAccum;
import com.unionpay.withhold.admin.service.ChannelService;
import com.unionpay.withhold.admin.utils.StringUtil;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private TChnlDetaMapper chnlDetaMapper;

	@Autowired
	private TRateAccumMapper rateAccumMapper;

	@Autowired
	private TMerchRateConfigMapper merchRateConfigMapper;
	
	@Autowired
	private TChnlBankMapper chnlBankMapper ;
	
	@Autowired
	private TChnlFlowControlMapper chnlFlowControlMapper;

	@Override
	public List<TChnlDeta> selectByCondition(TChnlDeta chnlDeta) {
		// 查分页数据
		TChnlDetaExample chnlDetaExample = new TChnlDetaExample();
		TChnlDetaExample.Criteria criteria = chnlDetaExample.createCriteria();
		if (StringUtil.isNotEmpty(chnlDeta.getChnlname())) {
			criteria.andChnlnameLike("%" + chnlDeta.getChnlname() + "%");
		}
		if (StringUtil.isNotEmpty(chnlDeta.getChnlcode())) {
			criteria.andChnlcodeLike("%" + chnlDeta.getChnlcode() + "%");
		}
		if (StringUtil.isNotEmpty(chnlDeta.getStatus())) {
			if ("00".equals(chnlDeta.getStatus())) {
				criteria.andStatusEqualTo("00");
			} else {
				criteria.andStatusNotEqualTo("00");
			}
		}
		List<TChnlDeta> list = chnlDetaMapper.selectByExample(chnlDetaExample);
		return list;
	}

	@Override
	public ResultBean addChannel(TChnlDeta chnlDeta, String rates) {
		// 查询重复
		TChnlDetaExample chnlDetaExample = new TChnlDetaExample();
		TChnlDetaExample.Criteria criteria = chnlDetaExample.createCriteria();
		criteria.andChnlcodeEqualTo(chnlDeta.getChnlcode());
		List<TChnlDeta> list = chnlDetaMapper.selectByExample(chnlDetaExample);
		if (CollectionUtils.isNotEmpty(list)) {
			return new ResultBean("", "此通道代码被注册过！");
		}
		TRateAccum tRateAccum = rateAccumMapper.selectByPrimaryKey(Integer.valueOf(rates));

		TMerchRateConfig merchRateConfig = new TMerchRateConfig();
		merchRateConfig.setIntime(new Date());
		merchRateConfig.setInuser(chnlDeta.getInuser());
		merchRateConfig.setTarget(MerchTargetTypeEnums.CHANNEL.getCode());
		merchRateConfig.setMemberId(chnlDeta.getChnlcode());
		merchRateConfig.setRateId((long) tRateAccum.getRateId());
		merchRateConfig.setSetlflg(Short.valueOf(MerchSetlFlgEnums.join.getCode()));
		merchRateConfig.setRateMethod(Short.valueOf(tRateAccum.getRateMethod()));
		int configflag = merchRateConfigMapper.insertSelective(merchRateConfig);
		chnlDeta.setIntime(new Date());
		chnlDeta.setStatus(ChannelStatusEnums.NORMAL.getCode());
		int flag = chnlDetaMapper.insertSelective(chnlDeta);
		if (flag > 0 && configflag > 0) {
			return new ResultBean("操作成功 ！");
		} else {
			return new ResultBean("", "添加失败！");
		}
	}

	@Override
	public TChnlDeta queryChannelById(int selfId) {
		return chnlDetaMapper.selectByPrimaryKey(selfId);
	}

	@Override
	public ResultBean updateChannel(TChnlDeta chnlDeta) {
		int flag = chnlDetaMapper.updateByPrimaryKey(chnlDeta);
		if (flag > 0) {
			return new ResultBean("操作成功 ！");
		} else {
			return new ResultBean("", "修改失败！");
		}
	}
	
	
	@Override
	public Map<String, Object> queryChannelBankByChnlcode(String chnlcode) {
		List<Map<String, Object>> debitlist =chnlBankMapper.selectByChnlCode(chnlcode,"1");
		List<Map<String, Object>> creditlist =chnlBankMapper.selectByChnlCode(chnlcode,"2");
		Map<String, Object> returnmap =new HashMap<>();
		returnmap.put("debit", debitlist);
		returnmap.put("credit", creditlist);
		return returnmap;
	}

	@Override
	public ResultBean changeChannlBank(List<String> debitoldlist, List<String> debitnewlist,
			List<String> creditdataoldlist, List<String> creditdatanewlist,String chnlcode,long userid) {
		Map<String, Object> paramobj=new HashMap<>();
		if (CollectionUtils.isNotEmpty(debitoldlist)) {
			paramobj.put("list", debitoldlist);
			paramobj.put("chnlcode", chnlcode);
			paramobj.put("cardtype", CardTypeEnums.debit.getCode());
			chnlBankMapper.deleteWithIn(paramobj);
		}
		if (CollectionUtils.isNotEmpty(creditdataoldlist)) {
			paramobj.put("list", creditdataoldlist);
			paramobj.put("chnlcode", chnlcode);
			paramobj.put("cardtype", CardTypeEnums.credit.getCode());
			chnlBankMapper.deleteWithIn(paramobj);
		}
		
		for (String string : debitnewlist) {
			TChnlBank tChnlBank=new TChnlBank();
			tChnlBank.setBankcode(string);
			tChnlBank.setCardtype(CardTypeEnums.debit.getCode());
			tChnlBank.setStatus("00");
			tChnlBank.setChnlcode(chnlcode);
			tChnlBank.setIntime(new Date());
			tChnlBank.setInuser(userid);
			chnlBankMapper.insertSelective(tChnlBank);
		}
		for (String string : creditdatanewlist) {
			TChnlBank tChnlBank=new TChnlBank();
			tChnlBank.setBankcode(string);
			tChnlBank.setCardtype(CardTypeEnums.credit.getCode());
			tChnlBank.setStatus("00");
			tChnlBank.setChnlcode(chnlcode);
			tChnlBank.setIntime(new Date());
			tChnlBank.setInuser(userid);
			chnlBankMapper.insertSelective(tChnlBank);
		}
		return new ResultBean("操作成功 ！");
	}

	@Override
	public List<TChnlFlowControl> selectChannlFlowByCondition(TChnlFlowControl chnlFlowControl) {
		TChnlFlowControlExample chnlDetaExample = new TChnlFlowControlExample();
		TChnlFlowControlExample.Criteria criteria = chnlDetaExample.createCriteria();
		if (StringUtil.isNotEmpty(chnlFlowControl.getTarget())) {
			criteria.andTargetEqualTo(chnlFlowControl.getTarget());
		}
		if (StringUtil.isNotEmpty(chnlFlowControl.getChnlcode())) {
			criteria.andChnlcodeEqualTo((chnlFlowControl.getChnlcode()));
		}
		if (StringUtil.isNotEmpty(chnlFlowControl.getMerchno())) {
			criteria.andMerchnoLike("%"+chnlFlowControl.getMerchno()+"%");
		}
		List<TChnlFlowControl> list = chnlFlowControlMapper.selectByExample(chnlDetaExample);
		return list;
	}
}
