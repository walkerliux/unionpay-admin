package com.unionpay.withhold.admin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatch;
import com.unionpay.withhold.admin.pojo.TChnlCpdkLog;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatch;
import com.unionpay.withhold.admin.pojo.TOrderCollectSingle;
import com.unionpay.withhold.admin.pojo.TTxnsLog;
import com.unionpay.withhold.admin.service.TradeService;
@Service
@Transactional
public class TradeServiceImpl implements TradeService {
	
	@Override
	public PageBean getTxnsLogByPage(TTxnsLog tTxnsLog, String stime,
			String etime, int page, int rows) {
		if (tTxnsLog.getAccsecmerno()!=null&&!"".equals(tTxnsLog.getAccsecmerno())) {
			
		}
		if (tTxnsLog.getApporderstatus()!=null) {
			
		}
		
		if (stime!=null&&etime!=null) {
			
		}
		
		return null;
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
		if (stime!=null&&etime!=null) {
			
		}
		
		return null;
	}

	@Override
	public PageBean getSingleOrderByPage(TOrderCollectSingle orderSingle,
			String stime, String etime, int page, int rows) {
		//商户号
		if (orderSingle.getMerid()!=null&&!"".equals(orderSingle.getMerid())) {
			
		}
		//交易卡号
		if (orderSingle.getCardno()!=null&&!"".equals(orderSingle.getCardno())) {
			
		}
		//受理订单号
		if (orderSingle.getTn()!=null&&!"".equals(orderSingle.getTn())) {
			
		}
		//交易状态
		if (orderSingle.getStatus()!=null&&!"".equals(orderSingle.getStatus())) {
			
		}
		//商户订单号
		if (orderSingle.getOrderid()!=null&&!"".equals(orderSingle.getOrderid())) {
			
		}
		
		//起止时间
		if (stime!=null&&etime!=null) {
					
		}
		return null;
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
									
		}
		return null;
	}

	
	
	
}
