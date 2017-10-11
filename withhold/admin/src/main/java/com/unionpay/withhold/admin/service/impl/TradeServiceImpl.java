package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TCoopAgencyMapper;
import com.unionpay.withhold.admin.mapper.TOrderCollectBatchMapper;
import com.unionpay.withhold.admin.mapper.TOrderCollectSingleMapper;
import com.unionpay.withhold.admin.mapper.TTxnsLogMapper;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatch;
import com.unionpay.withhold.admin.pojo.TChnlCpdkLog;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatch;
import com.unionpay.withhold.admin.pojo.TOrderCollectSingle;
import com.unionpay.withhold.admin.pojo.TOrderCollectSingleExample;
import com.unionpay.withhold.admin.pojo.TOrderCollectSingleExample.Criteria;
import com.unionpay.withhold.admin.pojo.TTxnsLog;
import com.unionpay.withhold.admin.pojo.TTxnsLogExample;
import com.unionpay.withhold.admin.service.TradeService;
import com.unionpay.withhold.admin.utils.DateTimeReplaceUtil;
@Service
@Transactional
public class TradeServiceImpl implements TradeService {
	@Autowired
	private TCoopAgencyMapper tCoopAgencyMapper;
	@Autowired
	private TTxnsLogMapper tTxnsLogMapper;
	@Autowired
	private TOrderCollectBatchMapper tOrderCollectBatchMapper;
	@Autowired
	private TOrderCollectSingleMapper tOrderCollectSingleMapper;
	@Override
	public PageBean getTxnsLogByPage(TTxnsLog tTxnsLog, String stime,
			String etime, int page, int rows) {
		TTxnsLogExample tTxnsLogExample = new TTxnsLogExample();
		
		if (tTxnsLog.getAccsecmerno()!=null&&!"".equals(tTxnsLog.getAccsecmerno())) {
			
			tTxnsLogExample.setAccsecmerno(tTxnsLog.getAccsecmerno());
		}
		if (tTxnsLog.getApporderstatus()!=null&&!"".equals(tTxnsLog.getApporderstatus())) {
			
			tTxnsLogExample.setApporderstatus(tTxnsLog.getApporderstatus());
		}
		if (tTxnsLog.getPan()!=null&&!"".equals(tTxnsLog.getPan())) {
			
			tTxnsLogExample.setPan(tTxnsLog.getPan());
		}
		if (tTxnsLog.getPathcode()!=null&&!"".equals(tTxnsLog.getPathcode())) {
			
			tTxnsLogExample.setPathcode(tTxnsLog.getPathcode());
		}
		if (stime!=null&&!"".equals(stime)&&etime!=null&&!"".equals(etime)) {
			String[] start = stime.split(" ");
			String[] end = etime.split(" ");
			String sDate = DateTimeReplaceUtil.replace(start[0]);
			String sTime = DateTimeReplaceUtil.replace(start[1]);
			String eDate = DateTimeReplaceUtil.replace(end[0]);
			String eTime = DateTimeReplaceUtil.replace(end[1]);
			
			
			tTxnsLogExample.setStartdate(sDate);
			tTxnsLogExample.setEnddate(eDate);
			tTxnsLogExample.setStarttime(sTime);
			tTxnsLogExample.setEndtime(eTime);;
		}
		int total = tTxnsLogMapper.countByMyExample(tTxnsLogExample);
		tTxnsLogExample.setPageNum(page);
		tTxnsLogExample.setPageSize(rows);
		tTxnsLogExample.setOrderByClause("TXNSEQNO");
		List<TTxnsLog> retureList = tTxnsLogMapper.selectByPageExample(tTxnsLogExample);
		return new PageBean(total, retureList);
	}

	@Override
	public PageBean getBatchOrderByPage(TOrderCollectBatch orderBatch,
			String stime, String etime, int page, int rows) {
		//商户号
		if (orderBatch.getMerid()!=null&&!"".equals(orderBatch.getMerid())) {
			
		}
		//批次号
		if (orderBatch.getBatchno()!=null&&!"".equals(orderBatch.getBatchno())) {
			
		}
		//受理批次号
		if (orderBatch.getTn()!=null&&!"".equals(orderBatch.getTn())) {
			
		}
		//起止时间
		if (stime!=null&&!"".equals(stime)&&etime!=null&&!"".equals(etime)) {
			
		}
		
		return null;
	}

	@Override
	public PageBean getSingleOrderByPage(TOrderCollectSingle orderSingle,
			String stime, String etime, int page, int rows) {
		
		TOrderCollectSingleExample singleExample = new TOrderCollectSingleExample();
		Criteria criteria = singleExample.createCriteria();
		//商户号
		if (orderSingle.getMerid()!=null&&!"".equals(orderSingle.getMerid())) {
			criteria.andMeridEqualTo(orderSingle.getMerid());
		}
		//交易卡号
		if (orderSingle.getCardno()!=null&&!"".equals(orderSingle.getCardno())) {
			criteria.andCardnoEqualTo(orderSingle.getCardno());
		}
		//受理订单号
		if (orderSingle.getTn()!=null&&!"".equals(orderSingle.getTn())) {
			criteria.andTnEqualTo(orderSingle.getTn());
		}
		//交易状态
		if (orderSingle.getStatus()!=null&&!"".equals(orderSingle.getStatus())) {
			criteria.andStatusEqualTo(orderSingle.getStatus());
		}
		//商户订单号
		if (orderSingle.getOrderid()!=null&&!"".equals(orderSingle.getOrderid())) {
			criteria.andOrderidEqualTo(orderSingle.getOrderid());
		}
		
		//起止时间
		if (stime!=null&&!"".equals(stime)&&etime!=null&&!"".equals(etime)) {
			String st = DateTimeReplaceUtil.replace(stime);
			String et = DateTimeReplaceUtil.replace(etime);
			criteria.andOrdercommitimeBetween(st, et);	
		}
		int tatol = tOrderCollectSingleMapper.countByExample(singleExample);
		singleExample.setPageNum(page);
		singleExample.setPageSize(rows);
		singleExample.setOrderByClause("TID");
		List<TOrderCollectSingle> selectByExample = tOrderCollectSingleMapper.selectByExample(singleExample);
		
		return new PageBean(tatol, selectByExample);
	}

	@Override
	public PageBean getChnCollectBatchLogByPage(TChnlCpdkBatch tChnlCpdkBatch,
			String stime, String etime, int page, int rows) {
		//商户号
		if (tChnlCpdkBatch.getMerid()!=null&&!"".equals(tChnlCpdkBatch.getMerid())) {
			
		}
		//批次号
		if (tChnlCpdkBatch.getBatchno()!=null&&!"".equals(tChnlCpdkBatch.getBatchno())) {
			
		}
		//受理批次号
		if (tChnlCpdkBatch.getTn()!=null&&!"".equals(tChnlCpdkBatch.getTn())) {
			
		}
		//起止时间
		if (stime!=null&&etime!=null) {
			String st = DateTimeReplaceUtil.replace(stime);
			String et = DateTimeReplaceUtil.replace(etime);			
		}
		return null;
	}

	@Override
	public PageBean getChnCollectSingleLogByPage(TChnlCpdkLog tChnlCpdkLog,
			String stime, String etime, int page, int rows) {
		// 商户号
		if (tChnlCpdkLog.getMerid()!=null&&!"".equals(tChnlCpdkLog.getMerid())) {
			
		}
		//交易卡号
		if (tChnlCpdkLog.getCardno()!=null&&!"".equals(tChnlCpdkLog.getCardno())) {
			
		}
		//交易状态
		if (tChnlCpdkLog.getResponsecode()!=null&&!"".equals(tChnlCpdkLog.getResponsecode())) {
			
		}
		//订单号
		if (tChnlCpdkLog.getOrderno()!=null&&!"".equals(tChnlCpdkLog.getOrderno())) {
			
		}
		//起止时间
		if (stime!=null&&etime!=null) {
			String st = DateTimeReplaceUtil.replace(stime);
			String et = DateTimeReplaceUtil.replace(etime);					
		}
		return null;
	}

	@Override
	public PageBean getMerchantDaySettlement(TTxnsLog tTxnsLog, String stime,
			String etime, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TOrderCollectSingle getSingleById(String tid) {
		TOrderCollectSingleExample singleExample = new TOrderCollectSingleExample();
		Criteria criteria = singleExample.createCriteria();
		criteria.andTidEqualTo(Long.parseLong(tid));
		singleExample.setPageNum(1);
		singleExample.setPageSize(1);
		List<TOrderCollectSingle> list= tOrderCollectSingleMapper.selectByExample(singleExample);
		if (list!=null&&list.size()>0) {
			TOrderCollectSingle tOrderCollectSingle = list.get(0);
			return tOrderCollectSingle;
		}
		
		return null;
	}

	@Override
	public Object getshowCoop() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public TTxnsLog getTxnsLogByTxnseqno(String txnseqno) {
		TTxnsLog tTxnsLog = tTxnsLogMapper.selectByPrimaryKey(txnseqno);
		return tTxnsLog;
	}

	
	
	
}
