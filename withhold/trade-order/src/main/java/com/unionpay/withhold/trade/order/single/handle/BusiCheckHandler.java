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
		try {
			if(!singleCollectBean.getFinalResult().isResultBool()) {
				resultBean = singleCollectBean.getFinalResult();
				return;
			}
			TxncodeDefDO txncodeDef = new TxncodeDefDO();
			txncodeDef.setTxntype(singleCollectBean.getTransType());
			txncodeDef.setTxnsubtype(singleCollectBean.getTxnSubType());
			txncodeDef.setBiztype(singleCollectBean.getBizType());
			txncodeDef = txncodeDefService.getBusiCode(txncodeDef);
			if(txncodeDef==null){
				resultBean = new ResultBean("OD050", "交易类型不存在");
				resultBean.setResultBool(false);
			}else {
				BusiTypeEnum busiTypeEnum = BusiTypeEnum.fromValue(txncodeDef.getBusitype());
				if(busiTypeEnum!=BusiTypeEnum.CONSUME){//消费
					resultBean = new ResultBean("OD045", "交易类型错误");
					resultBean.setResultBool(false);
			    }
				if(resultBean==null) {
					resultBean = new ResultBean("0000", "成功");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("OD046", "系统内部错误");
			resultBean.setResultBool(false);
		}finally {
			singleCollectBean.setBusiCheck(resultBean);
		}
		
	}

}
