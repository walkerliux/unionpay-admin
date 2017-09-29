package com.unionpay.withhold.trade.task.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.alibaba.dubbo.config.annotation.Reference;
import com.unionpay.withhold.service.path.cp.app.CPAccountCheck;
import com.unionpay.withhold.service.path.cp.dto.req.BTAccChkReqDto;
import com.unionpay.withhold.trade.task.pojo.MerchChnlDO;
import com.unionpay.withhold.trade.task.service.MerchChnlService;
import com.unionpay.withhold.utils.DateUtil;
//@Component
public class TradeChannelTask {

	@Autowired
	private MerchChnlService merchChnlService;
	@Reference(version="1.0")
	private CPAccountCheck cpAccountCheck;
	/**
	 * 实时异步结果通知 
	 * 批量异步结果通知
	 * 获取对账文件地址 
	 * 实时代扣同步状态查询 
	 * 自动下载对账文件
	 */
	@Scheduled(cron="")
	public void downloadCPCheckChnlFile() {
		List<MerchChnlDO> cpMerchList = merchChnlService.queryCPMerch();
		String txndate = DateUtil.getSettleDate(-1);
		for(MerchChnlDO merchChnl : cpMerchList) {
			BTAccChkReqDto btAccChkReqDto = new BTAccChkReqDto();
			btAccChkReqDto.setMerId(merchChnl.getChnlmercno());//外部商户号
			btAccChkReqDto.setTradeDate(txndate);//当前日期减1
			cpAccountCheck.downloadAccChkFile(btAccChkReqDto);
		}
	}
	
}
