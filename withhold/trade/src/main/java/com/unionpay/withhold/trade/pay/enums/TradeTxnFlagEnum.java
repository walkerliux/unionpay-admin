package com.unionpay.withhold.trade.pay.enums;

/**
 * 交易所涉流水表标志位
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2017年3月29日 下午4:15:18
 * @since
 */
public enum TradeTxnFlagEnum {

	/**
	 * 1：有     0： 无
	 * 标志位定义
	 * 0位：t_txns_log
	 * 1位：t_order_collect_batch
	 * 2位：t_order_collect_deta
	 * 3位：t_order_collect_single
	 * 4位：t_chn_collect_batch
	 * 5位：t_chn_collect_deta
	 * 6位：t_chn_collect_single_log
	 * 7位：t_chn_payment_batch
	 * 8位：t_chn_payment_deta
	 * 9位：t_chn_payment_single_log
	 */
	
	REALTIME_COLLECT_ACCFAILED("1110000110000"),
	BATCH_COLLECT_ACCFAILED("1000110000110");
	String code;

	private TradeTxnFlagEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
}
