package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TTxnsLogMapper;
import com.unionpay.withhold.admin.pojo.TTxnsLog;
import com.unionpay.withhold.admin.service.TTxnsLogService;
@Service
@Transactional
public class TTxnsLogServiceImpl implements TTxnsLogService {
	
	@Autowired
	private TTxnsLogMapper tTxnsLogMapper;

	@Override
	public PageBean findPassagewayByPage(String payinst, String apporderstatus,
			String stime, String etime, int page, int rows) {
		if (payinst!=null&&!"".equals(payinst)) {
			
		}
		if (apporderstatus!=null&&!"".equals(apporderstatus)) {
			
		}
		if (stime!=null&&etime!=null) {
			
		}
		//查询当前条件下的总记录
		
		//查询当前条件下的分页显示
		
		List<TTxnsLog> list = new ArrayList<TTxnsLog>();
		TTxnsLog tTxnsLog = new TTxnsLog();
		tTxnsLog.setPayinst("20171009");
		tTxnsLog.setAmount(30000l);
		list.add(tTxnsLog);
		return new PageBean(5, list);
	}

	@Override
	public PageBean findMerchantByPage(String accsecmerno,
			String apporderstatus, String stime, String etime, int page,
			int rows) {
		if (accsecmerno!=null&&!"".equals(accsecmerno)) {
			
		}
		if (apporderstatus!=null&&!"".equals(apporderstatus)) {
			
		}
		if (stime!=null&&etime!=null) {
			
		}
		//查询当前条件下的总记录
		
		//查询当前条件下的分页显示
		List<TTxnsLog> list = new ArrayList<TTxnsLog>();
		TTxnsLog tTxnsLog = new TTxnsLog();
		tTxnsLog.setAccsecmerno("20171009");
		tTxnsLog.setAmount(30000l);
		list.add(tTxnsLog);
		return new PageBean(5, list);
	}

	@Override
	public PageBean findChannelByPage(String pathcode, String apporderstatus,
			String stime, String etime, int page, int rows) {
		if (pathcode!=null&&!"".equals(pathcode)) {
			
		}
		if (apporderstatus!=null&&!"".equals(apporderstatus)) {
			
		}
		if (stime!=null&&etime!=null) {
			
		}
		//查询当前条件下的总记录
		
		//查询当前条件下的分页显示
		List<TTxnsLog> list = new ArrayList<TTxnsLog>();
		TTxnsLog tTxnsLog = new TTxnsLog();
		tTxnsLog.setPathcode("20171009");
		tTxnsLog.setAmount(30000l);
		list.add(tTxnsLog);
		return new PageBean(5, list);
	}

	@Override
	public TTxnsLog queryDetailsById(String txnseqno) {
		
		TTxnsLog tTxnsLog = new TTxnsLog();
		tTxnsLog.setAmount(3000l);
		return tTxnsLog;
	}
	

}
