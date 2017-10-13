package com.unionpay.withhold.trade.pay.handle.single;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.service.path.cp.app.CPRealtimeWithhold;
import com.unionpay.withhold.service.path.cp.dto.req.RTWithholdAppReqDto;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.ChnlTypeEnum;
import com.unionpay.withhold.trade.pay.enums.TradeChannelEnum;
import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDO;
import com.unionpay.withhold.trade.pay.service.RspmsgPayService;
import com.unionpay.withhold.utils.BeanCopyUtil;
@Component("tradeChannelHandler")
public class TradeChannelHandler implements EventHandler<TradeBean>{
	
	
	@Autowired
	private RspmsgPayService rspmsgPayService;
	@Autowired
	private CPRealtimeWithhold cpRealtimeWithhold;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			TradeChannelEnum tradeChannel = TradeChannelEnum.fromValue(tradeBean.getChnlCode());
			
			//实例化交易渠道
			switch (tradeChannel) {
				case CHINAPAY_SINGLE:
					RTWithholdAppReqDto rtWithholdAppReqDto = new RTWithholdAppReqDto(tradeBean.getTxnseqno());
					com.unionpay.withhold.common.bean.ResultBean cpResultBean = cpRealtimeWithhold.applyRealtimeWithhold(rtWithholdAppReqDto);
					resultBean = BeanCopyUtil.copyBean(ResultBean.class, cpResultBean);
					RspmsgPayDO rspmsgPay = new RspmsgPayDO();
					rspmsgPay.setChnltype(ChnlTypeEnum.CHINAPAY.getCode());
					rspmsgPay.setChnlrspcode(cpResultBean.getErrCode());
					rspmsgPay = rspmsgPayService.getRspmsgPay(rspmsgPay);
					resultBean = new ResultBean(rspmsgPay.getApicode(), rspmsgPay.getApiinfo());
					break;
				case EUNIONPAY_SINGLE:
					
					break;
				case CHANPAY_SINGLE:

					break;
				default:
					resultBean = new ResultBean("PC010", "交易失败，无可用交易渠道");
					resultBean.setResultBool(false);
					break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resultBean = new ResultBean("PC035", "交易失败，系统异常");
			resultBean.setResultBool(false);
		}finally {
			tradeBean.setFinalTrade(resultBean);
		}
	}

}
