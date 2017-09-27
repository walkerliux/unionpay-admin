package com.unionpay.withhold.trade.order.single.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.enums.BusiTypeEnum;
import com.unionpay.withhold.trade.order.pojo.TxncodeDefDO;
import com.unionpay.withhold.trade.order.service.TxncodeDefService;

@Component("busiCheckHandler")
public class BusiCheckHandler implements EventHandler<SingleCollectBean>{

	@Autowired
	private TxncodeDefService txncodeDefService;
	
	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		TxncodeDefDO txncodeDef = new TxncodeDefDO();
		txncodeDef.setTxntype(singleCollectBean.getTransType());
		txncodeDef.setTxnsubtype(singleCollectBean.getTxnSubType());
		txncodeDef.setBiztype(singleCollectBean.getBizType());
		txncodeDef = txncodeDefService.getBusiCode(txncodeDef);
		if(txncodeDef==null){
			resultBean = new ResultBean("OD050", "交易类型不存在");
        }
		BusiTypeEnum busiTypeEnum = BusiTypeEnum.fromValue(txncodeDef.getBusitype());
		if(busiTypeEnum!=BusiTypeEnum.CONSUME){//消费
			resultBean = new ResultBean("OD045", "交易类型错误");
        }
		if(resultBean==null) {
			resultBean = new ResultBean("0000", "成功");
		}
		singleCollectBean.setBusiCheck(resultBean);
	}

}
