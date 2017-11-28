package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TTxnsLogMapper;
import com.unionpay.withhold.admin.pojo.TTxnsLog;
import com.unionpay.withhold.admin.pojo.TTxnsLogExample;
import com.unionpay.withhold.admin.service.TTxnsLogService;
import com.unionpay.withhold.admin.utils.DateTimeReplaceUtil;
@Service
@Transactional
public class TTxnsLogServiceImpl implements TTxnsLogService {
	
	@Autowired
	private TTxnsLogMapper tTxnsLogMapper;

	@Override
	public PageBean findChannelByPage(String payinst, String retcode,
			String stime, String etime, int page, int rows) {
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (payinst!=null&&!"".equals(payinst)) {
			tTxnsLogExample.setPayinst(payinst);
		}
		if (retcode!=null&&!"".equals(retcode)) {
			tTxnsLogExample.setRetcode(retcode);
		}
		if (stime!=null&&etime!=null&&!"".equals(stime)&&!"".equals(etime)) {
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			tTxnsLogExample.setStarttime(startTime);
			tTxnsLogExample.setEndtime(endTime);
			
		}
		//查询当前条件下的总记录
		int total = tTxnsLogMapper.countByChnlIdExample(tTxnsLogExample).size();
		//查询当前条件下的分页显示
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		List<TTxnsLog> result = tTxnsLogMapper.selectByChnlId(tTxnsLogExample);
		
		return new PageBean(total, result);
	}

	@Override
	public PageBean findMerchantByPage(String accsecmerno,
			String retcode, String stime, String etime, int page,
			int rows) {
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (accsecmerno!=null&&!"".equals(accsecmerno)) {
			tTxnsLogExample.setAccsecmerno(accsecmerno);
		}
		if (retcode!=null&&!"".equals(retcode)) {
			tTxnsLogExample.setRetcode(retcode);
		}
		if (stime!=null&&etime!=null&&!"".equals(stime)&&!"".equals(etime)) {
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			tTxnsLogExample.setStarttime(startTime);
			tTxnsLogExample.setEndtime(endTime);
			
		}
		//查询当前条件下的总记录
		 int total = tTxnsLogMapper.countByMerchIdExample(tTxnsLogExample).size();
		
		//查询当前条件下的分页显示
		 tTxnsLogExample.setPageNum(page);
		 tTxnsLogExample.setPageSize(rows);
		 List<TTxnsLog> list = tTxnsLogMapper.selectByMerchId(tTxnsLogExample);
		
		return new PageBean(total, list);
	}

	@Override
	public PageBean findCoopByPage(String accfirmerno, String retcode,
			String stime, String etime, int page, int rows) {
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (accfirmerno!=null&&!"".equals(accfirmerno)) {
			tTxnsLogExample.setAccfirmerno(accfirmerno);
		}
		if (retcode!=null&&!"".equals(retcode)) {
			tTxnsLogExample.setRetcode(retcode);
		}
		if (stime!=null&&etime!=null&&!"".equals(stime)&&!"".equals(etime)) {
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			tTxnsLogExample.setStarttime(startTime);
			tTxnsLogExample.setEndtime(endTime);
			
		}
		//查询当前条件下的总记录
		int total = tTxnsLogMapper.countByCoopIdExample(tTxnsLogExample).size();
		//查询当前条件下的分页显示
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		List<TTxnsLog> result = tTxnsLogMapper.selectByCoopId(tTxnsLogExample);
		return new PageBean(total, result);
	}

	@Override
	public PageBean getTnxLogInfoByMerno(String accsecmerno,String retcode,String stime,String etime,int page,int rows) {
		//selectInfoByMernoId
		//tTxnsLogMapper.selectInfoByMernoId();
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (accsecmerno!=null&&!"".equals(accsecmerno)) {
			tTxnsLogExample.setAccsecmerno(accsecmerno);
		}
		if (retcode!=null&&!"".equals(retcode)) {
			tTxnsLogExample.setRetcode(retcode);
		}
		if (stime!=null&&etime!=null&&!"".equals(stime)&&!"".equals(etime)) {
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			tTxnsLogExample.setStarttime(startTime);
			tTxnsLogExample.setEndtime(endTime);
			
		}
		int total=tTxnsLogMapper.selectInfoByMernoId(tTxnsLogExample).size();
		//查询当前条件下的分页显示
		
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		List<TTxnsLog> result = tTxnsLogMapper.selectInfoByMernoId(tTxnsLogExample);
		
		return new PageBean(total, result);
	}

	@Override
	public PageBean getTnxLogInfoByCoopno(String accfirmerno, String retcode,
			String stime, String etime, int page, int rows) {
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (accfirmerno!=null&&!"".equals(accfirmerno)) {
			tTxnsLogExample.setAccfirmerno(accfirmerno);
		}
		if (retcode!=null&&!"".equals(retcode)) {
			tTxnsLogExample.setRetcode(retcode);
		}
		if (stime!=null&&etime!=null&&!"".equals(stime)&&!"".equals(etime)) {
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			tTxnsLogExample.setStarttime(startTime);
			tTxnsLogExample.setEndtime(endTime);
			
		}
		int total = tTxnsLogMapper.selectInfoByCoopId(tTxnsLogExample).size();
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		List<TTxnsLog> result = tTxnsLogMapper.selectInfoByCoopId(tTxnsLogExample);
		return new PageBean(total, result);
	}

	@Override
	public PageBean getTnxLogInfoByPayinst(String payinst, String retcode,
			String stime, String etime, int page, int rows) {
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (payinst!=null&&!"".equals(payinst)) {
			tTxnsLogExample.setPayinst(payinst);;
		}
		if (retcode!=null&&!"".equals(retcode)) {
			tTxnsLogExample.setRetcode(retcode);
		}
		if (stime!=null&&etime!=null&&!"".equals(stime)&&!"".equals(etime)) {
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			tTxnsLogExample.setStarttime(startTime);
			tTxnsLogExample.setEndtime(endTime);
			
		}
		int total = tTxnsLogMapper.selectInfoByChnlId(tTxnsLogExample).size();
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		List<TTxnsLog> result = tTxnsLogMapper.selectInfoByChnlId(tTxnsLogExample);
		return new PageBean(total, result);
	}

	@Override
	public PageBean getMerchDayCountByPage(String accsecmerno,
			String dayormonth, String stime, String etime, int page, int rows) {
		
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (accsecmerno!=null&&!"".equals(accsecmerno)) {
			tTxnsLogExample.setAccsecmerno(accsecmerno);
		}
		if (dayormonth!=null&&!"".equals(dayormonth)) {
			tTxnsLogExample.setDayormonth(dayormonth);
		}
		if (stime!=null&&etime!=null&&!"".equals(stime)&&!"".equals(etime)) {
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			tTxnsLogExample.setStarttime(startTime);
			tTxnsLogExample.setEndtime(endTime);
			
		}
		int total = tTxnsLogMapper.selectMerchDayCountBymerId(tTxnsLogExample).size();
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		List<TTxnsLog> result = tTxnsLogMapper.selectMerchDayCountBymerId(tTxnsLogExample);
		return new PageBean(total, result);
	}

	@Override
	public PageBean getMerDayCountInfo(String accsecmerno, String txndate,
			 int page, int rows) {
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (accsecmerno!=null&&!"".equals(accsecmerno)) {
			tTxnsLogExample.setAccsecmerno(accsecmerno);
		}
		if (txndate!=null&&!"".equals(txndate)) {
			String startTime = DateTimeReplaceUtil.replace(txndate);
			//String endTime = DateTimeReplaceUtil.replace(etime);
			tTxnsLogExample.setStarttime(startTime);
		}
		int total = tTxnsLogMapper.selectMerchDayCountInfo(tTxnsLogExample).size();
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		List<TTxnsLog> result = tTxnsLogMapper.selectMerchDayCountInfo(tTxnsLogExample);
		return new PageBean(total, result);
	}

	@Override
	public PageBean getCoopMonthCountByPage(String accfirmerno, String year,
			String month, int page, int rows) {
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (accfirmerno!=null&&!"".equals(accfirmerno)) {
			tTxnsLogExample.setAccsecmerno(accfirmerno);
		}
		if (year!=null&&!"".equals(year)&&month!=null&&!"".equals(month)) {
			
			tTxnsLogExample.setStarttime(year+month);
		}
		int total = tTxnsLogMapper.selectCoopMonthByPage(tTxnsLogExample).size();
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		List<TTxnsLog> result = tTxnsLogMapper.selectCoopMonthByPage(tTxnsLogExample);
		return new PageBean(total, result);
	}

	@Override
	public PageBean getCoopMonthCountInfo(String accfirmerno, String txndate,
			 int page, int rows) {
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		if (accfirmerno!=null&&!"".equals(accfirmerno)) {
			tTxnsLogExample.setAccsecmerno(accfirmerno);
		}
		if (txndate!=null&&!"".equals(txndate)) {
			
			tTxnsLogExample.setStarttime(txndate);
		}
		int total = tTxnsLogMapper.selectCoopMonthInfo(tTxnsLogExample).size();
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		List<TTxnsLog> result = tTxnsLogMapper.selectCoopMonthInfo(tTxnsLogExample);
		return new PageBean(total, result);
	}
	

}
