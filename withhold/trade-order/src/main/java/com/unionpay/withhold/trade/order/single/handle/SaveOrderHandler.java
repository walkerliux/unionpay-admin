package com.unionpay.withhold.trade.order.single.handle;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.service.OrderCollectSingleService;
import com.unionpay.withhold.trade.order.service.SerialNumberService;
import com.unionpay.withhold.utils.DateUtil;

@Component("saveOrderHandler")
public class SaveOrderHandler implements EventHandler<SingleCollectBean>{

	@Autowired
	private SerialNumberService serialNumberService;
	@Autowired
	private OrderCollectSingleService orderCollectSingleService;
	
	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			String tn = serialNumberService.generateTN(singleCollectBean.getMchntCd());
			String txnseqno = serialNumberService.generateTxnseqno();
			singleCollectBean.setTn(tn);
			singleCollectBean.setTxnseqno(txnseqno);
			OrderCollectSingleDO orderCollectSingle = new OrderCollectSingleDO();
			orderCollectSingle.setVersion(singleCollectBean.getVersion());
			orderCollectSingle.setEncoding(singleCollectBean.getEncoding());
			orderCollectSingle.setCertid(singleCollectBean.getCertId());
			orderCollectSingle.setTxntype(singleCollectBean.getTransType());
			orderCollectSingle.setTxnsubtype("00");
			orderCollectSingle.setBiztype("000002");
			orderCollectSingle.setBackurl(singleCollectBean.getBackUrl());
			orderCollectSingle.setMerid(singleCollectBean.getMchntCd());
			//orderCollectSingle.setMerabbr("");
			orderCollectSingle.setOrderid(singleCollectBean.getOrderId());
			orderCollectSingle.setTxntime(singleCollectBean.getTransTm());
			orderCollectSingle.setPaytimeout(DateUtil.formatDateTime(DateUtil.DEFAULT_DATE_FROMAT, DateUtil.skipDateTime(new Date(), 1)));
			orderCollectSingle.setTxnamt(Long.valueOf(singleCollectBean.getTransAt()));
			orderCollectSingle.setCurrencycode(singleCollectBean.getAtType());
			//orderCollectSingle.setCreditorbank("203121000010");
			orderCollectSingle.setCardno(singleCollectBean.getPriAcctId());
			orderCollectSingle.setCustomernm(singleCollectBean.getName());
			orderCollectSingle.setIdcard(singleCollectBean.getIdCard());
			orderCollectSingle.setPhone(orderCollectSingle.getPhone());
			orderCollectSingle.setDktype(singleCollectBean.getDkType());
			orderCollectSingle.setFactorid(singleCollectBean.getFactorId());
			orderCollectSingle.setTn(tn);
			orderCollectSingle.setRelatetradetxn(txnseqno);
			orderCollectSingle.setStatus(OrderStatusEnum.INITIAL.getCode());
			orderCollectSingle.setOrdercommitime(DateUtil.getCurrentDateTime());
			orderCollectSingleService.saveOrderCollectSingle(orderCollectSingle);
			resultBean = new ResultBean("0000", "成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("OD064", "保存实时代扣订单失败");
			singleCollectBean.setSaveOrder(resultBean);
			return ;
		}finally {
			singleCollectBean.setSaveOrder(resultBean);
		}
		
		
		
	}

}
