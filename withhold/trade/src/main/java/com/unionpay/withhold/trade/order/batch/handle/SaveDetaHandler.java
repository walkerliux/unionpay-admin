package com.unionpay.withhold.trade.order.batch.handle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.order.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDO;
import com.unionpay.withhold.trade.order.service.OrderCollectDetaService;

@Component("saveDetaHandler")
public class SaveDetaHandler implements EventHandler<BatchCollectBean> {

	@Autowired
	private OrderCollectDetaService orderCollectDetaService;
	//@Autowired
	//private SerialNumberService serialNumberService;
	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			List<BatchCollectDetaBean> detaList = batchCollectBean.getDetaList();
			for(BatchCollectDetaBean detaBean : detaList) {
				OrderCollectDetaDO orderCollectDeta = new OrderCollectDetaDO();
				orderCollectDeta.setBatchtid(detaBean.getBatchId());;
			    orderCollectDeta.setBatchno(batchCollectBean.getBatchNo());;
			    orderCollectDeta.setOrderid(detaBean.getOrderId());;
			    orderCollectDeta.setCurrencycode(detaBean.getCurrencyCode());;
			    orderCollectDeta.setAmt(detaBean.getAmt());;
			    //orderCollectDeta.setBankcode("");;
			    orderCollectDeta.setCardno(detaBean.getCardNo());;
			    orderCollectDeta.setCustomernm(detaBean.getCustomerNm());;
			    orderCollectDeta.setRelatetradetxn(detaBean.getTxnseqno());;
			    orderCollectDeta.setStatus(OrderStatusEnum.INITIAL.getCode());;
			    orderCollectDeta.setCardtype(detaBean.getCardType());;
			    orderCollectDeta.setCertiftp(detaBean.getCertifTp());;
			    orderCollectDeta.setCertifid(detaBean.getCertifId());;
			    orderCollectDeta.setPhoneno(detaBean.getPhoneNo());;
			    orderCollectDeta.setCvn2(detaBean.getCvn2());;
			    orderCollectDeta.setExpired(detaBean.getExpired());;
			    orderCollectDeta.setRelatetradetxn(detaBean.getTxnseqno());
				orderCollectDetaService.saveOrderCollectDeta(orderCollectDeta);
			}
			resultBean =  new ResultBean("0000", "成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean =  new ResultBean("OD057", "保存批次明细异常");
			resultBean.setResultBool(false);
		}
		batchCollectBean.setSaveDeta(resultBean);
	}

}
