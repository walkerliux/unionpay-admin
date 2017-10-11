package com.unionpay.withhold.trade.order.single.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.enums.TradeStatFlagEnum;
import com.unionpay.withhold.trade.order.pojo.CardBinDO;
import com.unionpay.withhold.trade.order.pojo.MerchDetaDO;
import com.unionpay.withhold.trade.order.pojo.TxnLogDO;
import com.unionpay.withhold.trade.order.pojo.TxncodeDefDO;
import com.unionpay.withhold.trade.order.service.CardBinService;
import com.unionpay.withhold.trade.order.service.MerchDetaService;
import com.unionpay.withhold.trade.order.service.TxnLogService;
import com.unionpay.withhold.trade.order.service.TxncodeDefService;
import com.unionpay.withhold.utils.DateUtil;
@Component("saveTxnlogHandler")
public class SaveTxnlogHandler implements EventHandler<SingleCollectBean>{

	@Autowired
	private TxnLogService txnLogService;
	@Autowired
	private MerchDetaService merchDetaService;
	@Autowired
	private TxncodeDefService txncodeDefService;
	@Autowired
	private CardBinService cardBinService;
	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			TxncodeDefDO txncodeDef = new TxncodeDefDO();
			txncodeDef.setTxntype(singleCollectBean.getTransType());
			txncodeDef.setTxnsubtype(singleCollectBean.getTxnSubType());
			txncodeDef.setBiztype(singleCollectBean.getBizType());
			txncodeDef = txncodeDefService.getBusiCode(txncodeDef);
			if(txncodeDef==null){
				resultBean = new ResultBean("OD050", "交易类型不存在");
				resultBean.setResultBool(false);
	        }else {
	        	TxnLogDO txnsLog = new TxnLogDO();
				txnsLog.setTxnseqno(singleCollectBean.getTxnseqno());
				txnsLog.setApptype(txncodeDef.getApptype());
				MerchDetaDO member = merchDetaService.getMerchByMemberId(singleCollectBean.getMchntCd());
				txnsLog.setRiskver(member.getRiskVer());
				txnsLog.setRoutver(member.getRoutVer());
				txnsLog.setAccsettledate(DateUtil.getSettleDate(1));
				txnsLog.setTxndate(DateUtil.getCurrentDate());
				txnsLog.setTxntime(DateUtil.getCurrentTime());
				txnsLog.setBusicode(txncodeDef.getBusicode());
				txnsLog.setBusitype(txncodeDef.getBusitype());
				txnsLog.setTradcomm(0L);
				txnsLog.setAmount(Long.valueOf(singleCollectBean.getTransAt()));
				txnsLog.setAccordno(singleCollectBean.getOrderId());
				txnsLog.setAccsecmerno(singleCollectBean.getMchntCd());
				txnsLog.setAccfirmerno(member.getCacode());
				txnsLog.setAccordcommitime(DateUtil.getCurrentDateTime());
				txnsLog.setTradestatflag(TradeStatFlagEnum.INITIAL.getStatus());// 交易初始状态
				txnsLog.setAccmemberid("999999999999999");
				//银行卡信息
				CardBinDO cardBin = cardBinService.getCardBin(singleCollectBean.getPriAcctId());
				if(cardBin==null) {
					resultBean = new ResultBean("OD050", "交易类型不存在");
					resultBean.setResultBool(false);
				}else {
					txnsLog.setPan(singleCollectBean.getPriAcctId());
					txnsLog.setCardtype(cardBin.getType().toString());
					txnsLog.setCardinstino(cardBin.getBankcode());
					txnsLog.setPanName(singleCollectBean.getName());
				}
				txnLogService.saveTxnLog(txnsLog);
				resultBean = new ResultBean("0000", "成功");
	        }
		} catch (Exception e) {
			e.printStackTrace();
			resultBean = new ResultBean("OD062", "保存交易流水失败");
			singleCollectBean.setSaveOrder(resultBean);
			return ;
		}finally {
			singleCollectBean.setSaveTxnLog(resultBean);
		}
	}

}
