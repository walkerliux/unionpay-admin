package com.unionpay.withhold.trade.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.order.dao.OrderCollectDetaDAO;
import com.unionpay.withhold.trade.order.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.order.enums.TableEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDO;
import com.unionpay.withhold.trade.order.service.OrderCollectDetaService;
import com.unionpay.withhold.trade.order.service.SerialNumberService;


@Service//("orderCollectDetaService")
public class OrderCollectDetaServiceImpl implements OrderCollectDetaService{

	@Autowired
	private OrderCollectDetaDAO orderCollectDetaDAO;
	@Autowired
	private SerialNumberService serialNumberService;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void saveOrderCollectDeta(OrderCollectDetaDO orderCollectDeta) {
		orderCollectDeta.setTid(serialNumberService.generateTID(TableEnum.BATCHCOLLECTIONORDERDETA));
		orderCollectDetaDAO.insert(orderCollectDeta);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void batchSaveOrderCollectDeta(String batchNo,List<BatchCollectDetaBean> detaList) {
		for(BatchCollectDetaBean detaBean : detaList) {
			OrderCollectDetaDO orderCollectDeta = new OrderCollectDetaDO();
			orderCollectDeta.setTid(serialNumberService.generateTID(TableEnum.BATCHCOLLECTIONORDERDETA));
			orderCollectDeta.setBatchtid(detaBean.getBatchId());
		    orderCollectDeta.setBatchno(batchNo);
		    orderCollectDeta.setOrderid(detaBean.getOrderId());
		    orderCollectDeta.setCurrencycode(detaBean.getCurrencyCode());
		    orderCollectDeta.setAmt(detaBean.getAmt());
		    orderCollectDeta.setCardno(detaBean.getCardNo());
		    orderCollectDeta.setCustomernm(detaBean.getCustomerNm());
		    orderCollectDeta.setRelatetradetxn(detaBean.getTxnseqno());
		    orderCollectDeta.setStatus(OrderStatusEnum.INITIAL.getCode());
		    orderCollectDeta.setCardtype(detaBean.getCardType());
		    orderCollectDeta.setCertiftp(detaBean.getCertifTp());
		    orderCollectDeta.setCertifid(detaBean.getCertifId());
		    orderCollectDeta.setPhoneno(detaBean.getPhoneNo());
		    orderCollectDeta.setCvn2(detaBean.getCvn2());
		    orderCollectDeta.setExpired(detaBean.getExpired());
		    orderCollectDeta.setRelatetradetxn(detaBean.getTxnseqno());
			orderCollectDetaDAO.insert(orderCollectDeta);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<OrderCollectDetaDO> queryCollectOrderDeta(Long batchId){
		return orderCollectDetaDAO.queryCollectOrderDeta(batchId);
	}

	

	
}
