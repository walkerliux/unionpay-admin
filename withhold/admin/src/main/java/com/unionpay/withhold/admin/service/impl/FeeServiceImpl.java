package com.unionpay.withhold.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;












import com.unionpay.withhold.admin.Bean.AccRateBean;
import com.unionpay.withhold.admin.Bean.AccumRateBean;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.dao.JedisClient;
import com.unionpay.withhold.admin.mapper.TRateAccumDetaMapper;
import com.unionpay.withhold.admin.mapper.TRateAccumMapper;
import com.unionpay.withhold.admin.mapper.TSpeFeeDetaMapper;
import com.unionpay.withhold.admin.mapper.TSpeFeeMapper;
import com.unionpay.withhold.admin.pojo.TRateAccum;
import com.unionpay.withhold.admin.pojo.TRateAccumDeta;
import com.unionpay.withhold.admin.pojo.TRateAccumDetaExample;
import com.unionpay.withhold.admin.pojo.TRateAccumDetaExample.Criteria;
import com.unionpay.withhold.admin.pojo.TRateAccumExample;
import com.unionpay.withhold.admin.pojo.TSpeFee;
import com.unionpay.withhold.admin.pojo.TSpeFeeDeta;
import com.unionpay.withhold.admin.pojo.TSpeFeeDetaExample;
import com.unionpay.withhold.admin.pojo.TSpeFeeExample;
import com.unionpay.withhold.admin.service.FeeService;

@Service
@Transactional
public class FeeServiceImpl implements FeeService {
	@Autowired
	JedisClient jedisClient;
	@Value("${REDIS_USER_KEY}")
	private String REDIS_USER_KEY;
	@Autowired
	private TRateAccumDetaMapper tRateAccumDetaMapper;
	@Autowired
	private TRateAccumMapper tRateAccumMapper;
	@Autowired
	private TSpeFeeDetaMapper tSpeFeeDetaMapper;
	
	
	/**交易金额分段扣率**/
	@Override
	public PageBean queryAmtAccumRate(String rateId, String rateDesc, int page,
			int rows) {
		//queryAmtAccumRate
		TRateAccumExample tRateAccumExample = new TRateAccumExample();
		if (rateId!=null&&!"".equals(rateId)) {
			tRateAccumExample.setRateId(rateId);
		}
		if (rateDesc!=null&&!"".equals(rateDesc)) { 
			tRateAccumExample.setRateDesc(rateDesc);
		}
		tRateAccumExample.setRateMethod("1");
		int total = tRateAccumMapper.queryAmtAccumRate(tRateAccumExample).size();
		tRateAccumExample.setPageNum(page);
		tRateAccumExample.setPageSize(rows);
		List<TRateAccum> result = tRateAccumMapper.queryAmtAccumRate(tRateAccumExample);
		return new PageBean(total, result);
	}
	@Override
	public void addAmtAccumRate(AccumRateBean accumRateBean) {
		TRateAccum tRateAccum = new TRateAccum();
		//tRateAccum.setRateId(Integer.parseInt(rateId));
		tRateAccum.setRateDesc(accumRateBean.getRateDesc());
		tRateAccum.setNotes(accumRateBean.getNotes());
		tRateAccum.setRateMethod("1");
		tRateAccumMapper.insert(tRateAccum);
		for (AccRateBean acc : accumRateBean.getArdList()) {
			TRateAccumDeta tRateAccumDeta = new TRateAccumDeta();
			tRateAccumDeta.setRateId(tRateAccum.getRateId().longValue());
			tRateAccumDeta.setStartrange(Long.parseLong(acc.getStartRange()));
			if (acc.getEndrange()!=null&&!"".equals(acc.getEndrange())) {
				tRateAccumDeta.setEndrange(Long.parseLong(acc.getEndrange()));
			}
			tRateAccumDeta.setRateType(acc.getRateType());
			if (acc.getFeeRate()!=null&&!"".equals(acc.getFeeRate())) {
				tRateAccumDeta.setFeeRate(Short.parseShort(acc.getFeeRate()));
			}
			if (acc.getMinFee()!=null&&!"".equals(acc.getMinFee())) {
				tRateAccumDeta.setMinFee(Long.parseLong(acc.getMinFee()));
			}
			if (acc.getMaxFee()!=null&&!"".equals(acc.getMaxFee())) {
				tRateAccumDeta.setMaxFee(Long.parseLong(acc.getMaxFee()));
			}
			tRateAccumDeta.setIntime(new Date());
			tRateAccumDeta.setInuser(Long.parseLong(accumRateBean.getInuser()));
			tRateAccumDeta.setNotes(accumRateBean.getNotes());
			tRateAccumDetaMapper.insert(tRateAccumDeta);
		}
	}
	public String simpleFormat(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		String str=sdf.format(date);  
		return str;
	}
	@Override
	public PageBean queryAccumRateDeta(String rateId) {
		TRateAccumDetaExample tRateAccumDetaExample = new TRateAccumDetaExample();
		if (rateId!=null&&!"".equals(rateId)) {
			tRateAccumDetaExample.setRateId(rateId);
		}
		List<TRateAccumDeta> list = tRateAccumDetaMapper.selectRateAccDateInfo(tRateAccumDetaExample);
		
		return new PageBean(list.size(), list);
	}
	@Override
	public void updateAccumRate(AccumRateBean accumRateBean) {
		TRateAccum tRateAccum = new TRateAccum();
		tRateAccum.setRateDesc(accumRateBean.getRateDesc());
		tRateAccum.setNotes(accumRateBean.getNotes());
		tRateAccum.setRateId(Integer.parseInt(accumRateBean.getRateId()));
		//更新trateacc
		tRateAccumMapper.updateByPrimaryKeySelective(tRateAccum);
		//删除旧的关联表
		TRateAccumDetaExample tRateAccumDetaExample = new TRateAccumDetaExample();
		Criteria createCriteria = tRateAccumDetaExample.createCriteria();
		createCriteria.andRateIdEqualTo(Long.parseLong(accumRateBean.getRateId()));
		tRateAccumDetaMapper.deleteByExample(tRateAccumDetaExample);
		//新增
		for (AccRateBean acc : accumRateBean.getArdList()) {
			TRateAccumDeta tRateAccumDeta = new TRateAccumDeta();
			tRateAccumDeta.setRateId(Long.parseLong(accumRateBean.getRateId()));
			tRateAccumDeta.setStartrange(Long.parseLong(acc.getStartRange()));
			if (acc.getEndrange()!=null&&!"".equals(acc.getEndrange())) {
				tRateAccumDeta.setEndrange(Long.parseLong(acc.getEndrange()));
			}
			tRateAccumDeta.setRateType(acc.getRateType());
			if (acc.getFeeRate()!=null&&!"".equals(acc.getFeeRate())) {
				tRateAccumDeta.setFeeRate(Short.parseShort(acc.getFeeRate()));
			}
			if (acc.getMinFee()!=null&&!"".equals(acc.getMinFee())) {
				tRateAccumDeta.setMinFee(Long.parseLong(acc.getMinFee()));
			}
			if (acc.getMaxFee()!=null&&!"".equals(acc.getMaxFee())) {
				tRateAccumDeta.setMaxFee(Long.parseLong(acc.getMaxFee()));
			}
			tRateAccumDeta.setIntime(new Date());
			tRateAccumDeta.setInuser(Long.parseLong(accumRateBean.getInuser()));
			tRateAccumDeta.setNotes(accumRateBean.getNotes());
			tRateAccumDetaMapper.insert(tRateAccumDeta);
		}
	}
	
	
	/**特殊公式计费**/
	@Override
	public PageBean querySpecialfee(String rateId, String rateDesc, int page,
			int rows) {
		TRateAccumExample tRateAccumExample = new TRateAccumExample();
		if (rateId!=null&&!"".equals(rateId)) {
			tRateAccumExample.setRateId(rateId);
		}
		if (rateDesc!=null&&!"".equals(rateDesc)) { 
			tRateAccumExample.setRateDesc(rateDesc);
		}
		tRateAccumExample.setRateMethod("2");
		int total = tRateAccumMapper.queryAmtAccumRate(tRateAccumExample).size();
		tRateAccumExample.setPageNum(page);
		tRateAccumExample.setPageSize(rows);
		List<TRateAccum> result = tRateAccumMapper.queryAmtAccumRate(tRateAccumExample);
		return new PageBean(total, result);
	}
	@Override
	public void savespefee(AccumRateBean accumRateBean) {
		TRateAccum tRateAccum = new TRateAccum();
		//tRateAccum.setRateId(Integer.parseInt(rateId));
		tRateAccum.setRateDesc(accumRateBean.getRateDesc());
		tRateAccum.setNotes(accumRateBean.getNotes());
		tRateAccum.setRateMethod("2");
		tRateAccumMapper.insert(tRateAccum);
		for (AccRateBean acc : accumRateBean.getArdList()) {
			TSpeFeeDeta speDeta= new TSpeFeeDeta();
			speDeta.setFunction(acc.getFunction());
			if (acc.getFeeRate()!=null&&!"".equals(acc.getFeeRate())) {
				speDeta.setFeerate(Long.parseLong(acc.getFeeRate()));
			}
			if (acc.getFixFee()!=null&&!"".equals(acc.getFixFee())) {
				speDeta.setFixfee(Long.parseLong(acc.getFixFee()));
			}
			if (acc.getMaxFee()!=null&&!"".equals(acc.getMaxFee())) {
				speDeta.setMaxfee(Long.parseLong(acc.getMaxFee()));
			}
			if (acc.getMinFee()!=null&&!"".equals(acc.getMinFee())) {
				speDeta.setMinfee(Long.parseLong(acc.getMinFee()));
			}
			speDeta.setNotes(accumRateBean.getNotes());
			speDeta.setRateId(tRateAccum.getRateId().longValue());
			tSpeFeeDetaMapper.insert(speDeta);
		}
	}
	@Override
	public PageBean querySpecialFeeDeta(String rateId) {
		TSpeFeeDetaExample tSpeFeeDetaExample = new TSpeFeeDetaExample();
		if (rateId!=null&&!"".equals(rateId)) {
			tSpeFeeDetaExample.setRateId(rateId);
		}
		//selectSpeFeeDateInfo
		List<TSpeFeeDeta> list = tSpeFeeDetaMapper.selectSpeFeeDateInfo(tSpeFeeDetaExample);
		return new PageBean(list.size(), list);
	}
	@Override
	public void updateSpecialFeeRate(AccumRateBean accumRateBean) {
		TRateAccum tRateAccum = new TRateAccum();
		tRateAccum.setRateDesc(accumRateBean.getRateDesc());
		tRateAccum.setNotes(accumRateBean.getNotes());
		tRateAccum.setRateId(Integer.parseInt(accumRateBean.getRateId()));
		//更新trateacc
		tRateAccumMapper.updateByPrimaryKeySelective(tRateAccum);
		//删除旧的关联表
		TSpeFeeDetaExample tSpeFeeDetaExample = new TSpeFeeDetaExample();
		com.unionpay.withhold.admin.pojo.TSpeFeeDetaExample.Criteria createCriteria = tSpeFeeDetaExample.createCriteria();
		createCriteria.andRateIdEqualTo(Long.parseLong(accumRateBean.getRateId()));
		tSpeFeeDetaMapper.deleteByExample(tSpeFeeDetaExample);
		//新增
		for (AccRateBean acc : accumRateBean.getArdList()) {
			TSpeFeeDeta speDeta = new TSpeFeeDeta();
			speDeta.setFunction(acc.getFunction());
			if (acc.getFeeRate()!=null&&!"".equals(acc.getFeeRate())) {
				speDeta.setFeerate(Long.parseLong(acc.getFeeRate()));
			}
			if (acc.getFixFee()!=null&&!"".equals(acc.getFixFee())) {
				speDeta.setFixfee(Long.parseLong(acc.getFixFee()));
			}
			if (acc.getMaxFee()!=null&&!"".equals(acc.getMaxFee())) {
				speDeta.setMaxfee(Long.parseLong(acc.getMaxFee()));
			}
			if (acc.getMinFee()!=null&&!"".equals(acc.getMinFee())) {
				speDeta.setMinfee(Long.parseLong(acc.getMinFee()));
			}
			speDeta.setNotes(accumRateBean.getNotes());
			speDeta.setRateId(Long.parseLong(accumRateBean.getRateId()));
			tSpeFeeDetaMapper.insert(speDeta);
		}
	}
	
}
