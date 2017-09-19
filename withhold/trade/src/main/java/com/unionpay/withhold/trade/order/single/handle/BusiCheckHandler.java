package com.unionpay.withhold.trade.order.single.handle;

import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;

@Component("busiCheckHandler")
public class BusiCheckHandler implements EventHandler<SingleCollectBean>{

	
	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		// TODO Auto-generated method stub
		/*PojoTxncodeDef busiModel = txncodeDefDAO.getBusiCode(singleCollectBean.getTxnType(), orderBean.getTxnSubType(), orderBean.getBizType());
        if(busiModel==null){
        	//throw new OrderException("OD045");
        }
        BusiTypeEnum busiTypeEnum = BusiTypeEnum.fromValue(busiModel.getBusitype());
        if(busiTypeEnum==BusiTypeEnum.consumption){//消费
        	if(StringUtils.isEmpty(orderBean.getMerId())){
        		 throw new OrderException("OD004");
        	}
        	MerchantBean member = merchService.getMerchBymemberId(orderBean.getMerId());//memberService.getMemberByMemberId(order.getMerId());.java
        	if(member==null){
        		throw new OrderException("OD009");
        	}
        	PojoProdCase prodCase= prodCaseDAO.getMerchProd(member.getPrdtVer(),busiModel.getBusicode());
            if(prodCase==null){
                throw new OrderException("OD005");
            }
        }else{
            throw new OrderException("OD045");
        }*/
	}

}
