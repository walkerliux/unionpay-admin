package com.unionpay.withhold.trade.order.batch.handle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.order.dao.TxncodeDefDAO;
import com.unionpay.withhold.trade.order.enums.TradeStatFlagEnum;
import com.unionpay.withhold.trade.order.pojo.MerchDetaDO;
import com.unionpay.withhold.trade.order.pojo.TxnLogDO;
import com.unionpay.withhold.trade.order.pojo.TxncodeDefDO;
import com.unionpay.withhold.trade.order.service.MerchDetaService;
import com.unionpay.withhold.trade.order.service.TxnLogService;
import com.unionpay.withhold.utils.DateUtil;
@Component("saveDetaTxnlogHandler")
public class SaveDetaTxnlogHandler implements EventHandler<BatchCollectBean>{

	@Autowired
	private TxnLogService txnLogService;
	@Autowired
	private MerchDetaService merchDetaService;
	@Autowired
	private TxncodeDefDAO txncodeDefDAO;
	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			TxncodeDefDO txncodeDef = new TxncodeDefDO();
			txncodeDef.setTxntype(batchCollectBean.getTxnType());
			txncodeDef.setTxnsubtype(batchCollectBean.getTxnSubType());
			txncodeDef.setBiztype(batchCollectBean.getBizType());
			txncodeDef = txncodeDefDAO.getBusiCode(txncodeDef);
			if(txncodeDef==null){
				resultBean = new ResultBean("OD050", "交易类型不存在");
	        }else {
	        	List<BatchCollectDetaBean> detaList = batchCollectBean.getDetaList();
				for(BatchCollectDetaBean detaBean : detaList) {
		        	TxnLogDO txnsLog = new TxnLogDO();
					txnsLog.setTxnseqno(detaBean.getTxnseqno());
					MerchDetaDO member = merchDetaService.getMerchByMemberId(batchCollectBean.getMerId());
					txnsLog.setRiskver(member.getRiskVer());
					txnsLog.setRoutver(member.getRoutVer());
					txnsLog.setAccsettledate(DateUtil.getSettleDate(1));
					txnsLog.setTxndate(DateUtil.getCurrentDate());
					txnsLog.setTxntime(DateUtil.getCurrentTime());
					txnsLog.setBusicode(txncodeDef.getBusicode());
					txnsLog.setBusitype(txncodeDef.getBusitype());
					txnsLog.setTradcomm(0L);
					txnsLog.setAmount(Long.valueOf(detaBean.getAmt()));
					txnsLog.setAccordno(detaBean.getOrderId());
					txnsLog.setAccsecmerno(batchCollectBean.getMerId());
					txnsLog.setAccfirmerno(member.getCacode());
					txnsLog.setAccordcommitime(DateUtil.getCurrentDateTime());
					txnsLog.setTradestatflag(TradeStatFlagEnum.INITIAL.getStatus());// 交易初始状态
					txnsLog.setAccmemberid("999999999999999");
					txnLogService.saveTxnLog(txnsLog );
				}
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
			resultBean = new ResultBean("OD062", "保存交易流水失败");
			batchCollectBean.setSaveDetaTxnlog(resultBean);
			return ;
		}
		resultBean = new ResultBean("0000", "成功");
		batchCollectBean.setSaveDetaTxnlog(resultBean);
	}
}
