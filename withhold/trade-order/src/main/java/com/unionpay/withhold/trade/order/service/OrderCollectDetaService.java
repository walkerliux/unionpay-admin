package com.unionpay.withhold.trade.order.service;

import java.util.List;

import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDO;

public interface OrderCollectDetaService {

	/**
	 * 保存批次订单明细
	 * @param orderCollectDeta
	 */
	public void saveOrderCollectDeta(OrderCollectDetaDO orderCollectDeta);

	/**
	 * 查询批量代扣订单明细
	 * @param batchId
	 * @return
	 */
	public List<OrderCollectDetaDO> queryCollectOrderDeta(Long batchId);

	/**
	 * 批量保存代扣批次明细
	 * @param detaList
	 * @param batchNo
	 */
	public void batchSaveOrderCollectDeta(String batchNo,List<BatchCollectDetaBean> detaList);
	
	/**
	 * 更新批次明细状态
	 * @param tn
	 */
	public void updateCollectOrderDeta(String tn);
}
