package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TChnlCpdkBatchDetaMapper;
import com.unionpay.withhold.admin.mapper.TChnlCpdkBatchMapper;
import com.unionpay.withhold.admin.mapper.TChnlCpdkLogMapper;
import com.unionpay.withhold.admin.mapper.TCoopAgencyMapper;
import com.unionpay.withhold.admin.mapper.TOrderCollectBatchMapper;
import com.unionpay.withhold.admin.mapper.TOrderCollectDetaMapper;
import com.unionpay.withhold.admin.mapper.TOrderCollectSingleMapper;
import com.unionpay.withhold.admin.mapper.TTxnsLogMapper;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatch;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatchDeta;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatchDetaExample;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatchExample;
import com.unionpay.withhold.admin.pojo.TChnlCpdkLog;
import com.unionpay.withhold.admin.pojo.TChnlCpdkLogExample;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatch;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatchExample;
import com.unionpay.withhold.admin.pojo.TOrderCollectDeta;
import com.unionpay.withhold.admin.pojo.TOrderCollectDetaExample;
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
	private TOrderCollectDetaMapper tOrderCollectDetaMapper;
	@Autowired
	private TChnlCpdkLogMapper tChnlCpdkLogMapper;
	@Autowired
	private TChnlCpdkBatchMapper tChnlCpdkBatchMapper;
	@Autowired
	private TChnlCpdkBatchDetaMapper tChnlCpdkBatchDetaMapper;
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
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			tTxnsLogExample.setStarttime(startTime);
			tTxnsLogExample.setEndtime(endTime);;
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
		TOrderCollectBatchExample tOrderCollectBatchExample = new TOrderCollectBatchExample();
		com.unionpay.withhold.admin.pojo.TOrderCollectBatchExample.Criteria criteria = tOrderCollectBatchExample.createCriteria();
		//商户号
		if (orderBatch.getMerid()!=null&&!"".equals(orderBatch.getMerid())) {
			tOrderCollectBatchExample.setMerid(orderBatch.getMerid());
		}
		//批次号
		if (orderBatch.getBatchno()!=null&&!"".equals(orderBatch.getBatchno())) {
			tOrderCollectBatchExample.setBatch(orderBatch.getBatchno());
		}
		//受理批次号
		if (orderBatch.getTn()!=null&&!"".equals(orderBatch.getTn())) {
			tOrderCollectBatchExample.setTn(orderBatch.getTn());
		}
		//起止时间
		if (stime!=null&&!"".equals(stime)&&etime!=null&&!"".equals(etime)) {
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			tOrderCollectBatchExample.setStarttime(startTime);
			tOrderCollectBatchExample.setEndtime(endTime);
			
		}
		int total = tOrderCollectBatchMapper.countByMyExample(tOrderCollectBatchExample);
		tOrderCollectBatchExample.setPageNum(page);
		tOrderCollectBatchExample.setPageSize(rows);
		tOrderCollectBatchExample.setOrderByClause("TID");
		List<TOrderCollectBatch> returnList = tOrderCollectBatchMapper.selectByPageExample(tOrderCollectBatchExample);
		return new PageBean(total, returnList);
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
			criteria.andTxntimeBetween(st, et);
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
		//tChnlCpdkBatchMapper
		TChnlCpdkBatchExample tChnlCpdkBatchExample = new TChnlCpdkBatchExample();
		com.unionpay.withhold.admin.pojo.TChnlCpdkBatchExample.Criteria createCriteria = tChnlCpdkBatchExample.createCriteria();
		//商户号
		if (tChnlCpdkBatch.getMerid()!=null&&!"".equals(tChnlCpdkBatch.getMerid())) {
			createCriteria.andMeridEqualTo(tChnlCpdkBatch.getMerid());
		}
		//批次号
		if (tChnlCpdkBatch.getBatchno()!=null&&!"".equals(tChnlCpdkBatch.getBatchno())) {
			createCriteria.andBatchnoEqualTo(tChnlCpdkBatch.getBatchno());
		}
		//受理批次号
		if (tChnlCpdkBatch.getTn()!=null&&!"".equals(tChnlCpdkBatch.getTn())) {
			createCriteria.andTnEqualTo(tChnlCpdkBatch.getTn());
		}
		//起止时间
		if (stime!=null&&!"".equals(stime)&&etime!=null&&!"".equals(etime)) {
			//String st = DateTimeReplaceUtil.replace(stime);
			//String et = DateTimeReplaceUtil.replace(etime);	
			createCriteria.andIntimeBetween(stime, etime);
			
		}
		int total = tChnlCpdkBatchMapper.countByExample(tChnlCpdkBatchExample);
		tChnlCpdkBatchExample.setPageNum(page);
		tChnlCpdkBatchExample.setPageSize(rows);
		tChnlCpdkBatchExample.setOrderByClause("TID");
		List<TChnlCpdkBatch> result = tChnlCpdkBatchMapper.selectByExample(tChnlCpdkBatchExample);
		return new PageBean(total, result);
	}

	@Override
	public PageBean getChnCollectSingleLogByPage(TChnlCpdkLog tChnlCpdkLog,
			String stime, String etime, int page, int rows) {
		TChnlCpdkLogExample tChnlCpdkLogExample = new TChnlCpdkLogExample();
		com.unionpay.withhold.admin.pojo.TChnlCpdkLogExample.Criteria criteria = tChnlCpdkLogExample.createCriteria();
		// 商户号
		if (tChnlCpdkLog.getMerid()!=null&&!"".equals(tChnlCpdkLog.getMerid())) {
			criteria.andMeridEqualTo(tChnlCpdkLog.getMerid());
		}
		//交易卡号
		if (tChnlCpdkLog.getCardno()!=null&&!"".equals(tChnlCpdkLog.getCardno())) {
			criteria.andCardnoEqualTo(tChnlCpdkLog.getCardno());
		}
		//交易状态
		if (tChnlCpdkLog.getTransstat()!=null&&!"".equals(tChnlCpdkLog.getTransstat())) {
			criteria.andTransstatEqualTo(tChnlCpdkLog.getTransstat());
		}
		//订单号
		if (tChnlCpdkLog.getOrderno()!=null&&!"".equals(tChnlCpdkLog.getOrderno())) {
			criteria.andOrdernoEqualTo(tChnlCpdkLog.getOrderno());
		}
		//起止时间
		if (stime!=null&&!"".equals(stime)&&etime!=null&&!"".equals(etime)) {
			//String st = DateTimeReplaceUtil.replace(stime);
			//String et = DateTimeReplaceUtil.replace(etime);	
			criteria.andIntimeBetween(stime, etime);
		}
		int total = tChnlCpdkLogMapper.countByExample(tChnlCpdkLogExample);
		tChnlCpdkLogExample.setPageNum(page);
		tChnlCpdkLogExample.setPageSize(rows);
		tChnlCpdkLogExample.setOrderByClause("TID");
		List<TChnlCpdkLog> result = tChnlCpdkLogMapper.selectByExample(tChnlCpdkLogExample);
		return new PageBean(total, result);
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
	public TTxnsLog getTxnsLogByTxnseqno(String txnseqno) {
		TTxnsLog tTxnsLog = tTxnsLogMapper.selectByPrimaryKey(txnseqno);
		return tTxnsLog;
	}

	@Override
	public PageBean getCollectOrderDetaByBatchNo(String batchno,
			int page, int rows) {
		//tOrderCollectDetaMapper
		TOrderCollectDetaExample tOrderCollectDetaExample = new TOrderCollectDetaExample();
		com.unionpay.withhold.admin.pojo.TOrderCollectDetaExample.Criteria criteria = tOrderCollectDetaExample.createCriteria();
		if (batchno!=null&& !"".equals(batchno)) {
			criteria.andBatchnoEqualTo(batchno);
		}
		int total = tOrderCollectDetaMapper.countByExample(tOrderCollectDetaExample);
		tOrderCollectDetaExample.setPageNum(page);
		tOrderCollectDetaExample.setPageSize(rows);
		tOrderCollectDetaExample.setOrderByClause("TID");
		List<TOrderCollectDeta> result = tOrderCollectDetaMapper.selectByExample(tOrderCollectDetaExample);
		return new PageBean(total, result);
	}

	@Override
	public PageBean getChnCollectDetaByBatchNo(String batchno, int page,
			int rows) {
		
		TChnlCpdkBatchDetaExample tChnlCpdkBatchDetaExample = new TChnlCpdkBatchDetaExample();
		com.unionpay.withhold.admin.pojo.TChnlCpdkBatchDetaExample.Criteria criteria = tChnlCpdkBatchDetaExample.createCriteria();
		if (batchno!=null&&!"".equals(batchno)) {
			criteria.andBatchnoEqualTo(batchno);
		}
		
		int total = tChnlCpdkBatchDetaMapper.countByExample(tChnlCpdkBatchDetaExample);
		tChnlCpdkBatchDetaExample.setPageNum(page);
		tChnlCpdkBatchDetaExample.setPageSize(rows);
		tChnlCpdkBatchDetaExample.setOrderByClause("TID");
		List<TChnlCpdkBatchDeta> result = tChnlCpdkBatchDetaMapper.selectByExample(tChnlCpdkBatchDetaExample);
		return new PageBean(total, result);
	}

	
	
	
}
