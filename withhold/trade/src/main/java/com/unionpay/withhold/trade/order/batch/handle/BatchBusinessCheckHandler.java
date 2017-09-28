package com.unionpay.withhold.trade.order.batch.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.dao.TxncodeDefDAO;
import com.unionpay.withhold.trade.order.enums.BusiTypeEnum;
import com.unionpay.withhold.trade.order.pojo.TxncodeDefDO;
@Component("batchBusinessCheckHandler")
public class BatchBusinessCheckHandler implements EventHandler<BatchCollectBean>{
	
	@Autowired
	private TxncodeDefDAO txncodeDefDAO;
	
	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		TxncodeDefDO txncodeDef = new TxncodeDefDO();
		txncodeDef.setTxntype(batchCollectBean.getTxnType());
		txncodeDef.setTxnsubtype(batchCollectBean.getTxnSubType());
		txncodeDef.setBiztype(batchCollectBean.getBizType());
		txncodeDef = txncodeDefDAO.getBusiCode(txncodeDef);
		if(txncodeDef==null){
			resultBean = new ResultBean("OD050", "交易类型不存在");
        }else {
        	BusiTypeEnum busiTypeEnum = BusiTypeEnum.fromValue(txncodeDef.getBusitype());
    		if(busiTypeEnum!=BusiTypeEnum.CONSUME){//消费
    			resultBean = new ResultBean("OD045", "交易类型错误");
            }
    		if(resultBean==null) {
    			resultBean = new ResultBean("0000", "成功");
    		}
        }
		batchCollectBean.setBusinessCheck(resultBean);
	}

}
