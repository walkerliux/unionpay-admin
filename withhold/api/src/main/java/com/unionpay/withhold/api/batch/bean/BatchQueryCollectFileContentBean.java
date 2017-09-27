package com.unionpay.withhold.api.batch.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 批量代收交易查询文件域
 * @author: 张世栋
 * @date: 2017年9月25日13:50:01
 * @version 1.0
 */
public class BatchQueryCollectFileContentBean extends BatchCollectFileContentBean{
	
	private static final long serialVersionUID = 8243013476723537559L;
	
	@Length(message="[订单状态]长度不符合规范", max = 2)
	@NotEmpty(message="[订单状态]不能为空")
	private String orderStatus;//响应码

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
