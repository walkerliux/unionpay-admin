package com.unionpay.withhold.trade.order.batch.handle;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.enums.MerchStatusEnum;
import com.unionpay.withhold.trade.order.pojo.MerchDetaDO;
import com.unionpay.withhold.trade.order.service.MerchDetaService;

@Component("batchMerchCheckHandler")
public class BatchMerchCheckHandler implements EventHandler<BatchCollectBean> {
	@Autowired
	private MerchDetaService merchDetaService;

	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		if (StringUtils.isEmpty(batchCollectBean.getMerId())) {
			resultBean = new ResultBean("OD004", "商户号为空");
		} else {
			MerchDetaDO member = merchDetaService.getMerchByMemberId(batchCollectBean.getMerId());
			if (member == null) {
				resultBean = new ResultBean("OD009", "商户不存在");
			} else {
				MerchStatusEnum merchStatus = MerchStatusEnum.fromValue(member.getStatus());
				if (merchStatus != MerchStatusEnum.NORMAL) {
					resultBean = new ResultBean("OD051", "商户状态异常");
				}
			}
		}
		if (resultBean == null) {
			resultBean = new ResultBean("0000", "成功");
		}
		batchCollectBean.setMerchCheck(resultBean);
	}

}
