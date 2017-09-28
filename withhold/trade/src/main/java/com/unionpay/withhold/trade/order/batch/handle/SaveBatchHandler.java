package com.unionpay.withhold.trade.order.batch.handle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.order.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.order.enums.TableEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectBatchDO;
import com.unionpay.withhold.trade.order.service.BatchOrderServcie;
import com.unionpay.withhold.trade.order.service.SerialNumberService;
import com.unionpay.withhold.utils.DateUtil;

@Component("saveBatchHandler")
public class SaveBatchHandler implements EventHandler<BatchCollectBean>{

	@Autowired
	private BatchOrderServcie batchOrderServcie;
	@Autowired
	private SerialNumberService serialNumberService;
	
	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			if(!batchCollectBean.getRepeatSubmitCheck().isResultBool()) {
				
			}else {
				String tn = serialNumberService.generateTN(batchCollectBean.getMerId());
				OrderCollectBatchDO orderCollectBatch = new OrderCollectBatchDO();
				orderCollectBatch.setTid(serialNumberService.generateTID(TableEnum.BATCHCOLLECTIONORDER));
				orderCollectBatch.setMerid(batchCollectBean.getMerId());
				orderCollectBatch.setVersion(batchCollectBean.getVersion());
				orderCollectBatch.setEncoding(batchCollectBean.getEncoding());
				orderCollectBatch.setCertid(batchCollectBean.getCertId());
				orderCollectBatch.setTxntype(batchCollectBean.getTxnType());
				orderCollectBatch.setTxnsubtype(batchCollectBean.getTxnSubType());
				orderCollectBatch.setBiztype(batchCollectBean.getBizType());
				orderCollectBatch.setBackurl(batchCollectBean.getBackUrl());
				orderCollectBatch.setBatchno(batchCollectBean.getBatchNo());
				orderCollectBatch.setFactorid(batchCollectBean.getFactorId());
				orderCollectBatch.setTxntime(batchCollectBean.getTxnTime().substring(8));
				orderCollectBatch.setTxndate(batchCollectBean.getTxnTime().substring(0,8));
				orderCollectBatch.setTotalqty(Long.valueOf(batchCollectBean.getTotalQty()));
				orderCollectBatch.setTotalamt(Long.valueOf(batchCollectBean.getTotalAmt()));
				orderCollectBatch.setReserved(batchCollectBean.getReserved());
				orderCollectBatch.setStatus(OrderStatusEnum.INITIAL.getCode());
				orderCollectBatch.setOrdercommitime(DateUtil.getCurrentDateTime());
				orderCollectBatch.setTn(tn);
				batchOrderServcie.saveBatchOrder(orderCollectBatch);
				List<BatchCollectDetaBean> detaList = batchCollectBean.getDetaList();
				for(BatchCollectDetaBean detaBean : detaList) {
					detaBean.setTxnseqno(serialNumberService.generateTxnseqno());
					detaBean.setBatchId(orderCollectBatch.getTid());
				}
				batchCollectBean.setTn(tn);
				resultBean =  new ResultBean("0000", "成功");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean =  new ResultBean("OD061", "保存批信息细异常");
			resultBean.setResultBool(false);
		}
		batchCollectBean.setSaveBatch(resultBean);
		
	}

}
