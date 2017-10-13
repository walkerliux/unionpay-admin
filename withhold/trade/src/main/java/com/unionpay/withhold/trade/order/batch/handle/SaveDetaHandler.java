package com.unionpay.withhold.trade.order.batch.handle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.order.service.OrderCollectDetaService;

@Component("saveDetaHandler")
public class SaveDetaHandler implements EventHandler<BatchCollectBean> {

	@Autowired
	private OrderCollectDetaService orderCollectDetaService;
	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			if(!batchCollectBean.getRepeatSubmitCheck().isResultBool()) {
				
			}else {
				List<BatchCollectDetaBean> detaList = batchCollectBean.getDetaList();
				orderCollectDetaService.batchSaveOrderCollectDeta(batchCollectBean.getBatchNo(), detaList);
				resultBean = new ResultBean("0000", "成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean =  new ResultBean("OD057", "保存批次明细异常");
			resultBean.setResultBool(false);
		}
		batchCollectBean.setSaveDeta(resultBean);
	}

}
