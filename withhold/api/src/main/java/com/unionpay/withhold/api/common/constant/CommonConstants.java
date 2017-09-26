package com.unionpay.withhold.api.common.constant;

public class CommonConstants {

	/**
	 * 交易来源：前端页面
	 */
	public static final String TRANS_SOURCE_FRONT = "1";
	/**
	 * 交易来源：后台接口
	 */
	public static final String TRANS_SOURCE_BKE = "2";

	/**
	 * 扣款类型：单笔扣款
	 */
	public static final String DAIKOU_TYPE_SINGLE = "1";
	/**
	 * 扣款类型：批量扣款
	 */
	public static final String DAIKOU_TYPE_BATCH = "2";

	/**
	 * 订单号递增序号值，4位，0000-9999，过了9999重新从0000开始
	 */
	public static final String ORDER_ID_SEQUENCE_KEY = "order_id_sequence";

	/**
	 * 前台url关键字
	 */
	public static final String FRONT_URL_KEY = "frontUrl";

	/**
	 * 后台url关键字
	 */
	public static final String BACK_URL_KEY = "backUrl";

	/**
	 * excel存放位置关键字
	 */
	public static final String EXCEL_PATH_KEY = "excel_path";

	/**
	 * 代付划付文件序列号关键字
	 */
	public static final String PAY_SEQUENCE_KEY = "pay_sequence";

	/**
	 * 代收交易类型
	 */
	public static final String TRANS_TP_SINGLE = "11";
	/**
	 * 查询交易类型
	 */
	public static final String TRANS_TP_QUERY = "00";
	/**
	 * 批量交易
	 */
	public static final String TRANS_TP_BATCH = "21";

	/**
	 * 交易开始上送
	 */
	public static final String TRANS_STATUS_BEGIN = "1";
	/**
	 * 交易处理中
	 */
	public static final String TRANS_STATUS_PROCESSING = "2";
	/**
	 * 交易处理成功
	 */
	public static final String TRANS_STATUS_SUCCESS = "3";
	/**
	 * 交易处理失败
	 */
	public static final String TRANS_STATUS_FAIL = "4";
	/**
	 * 交易条件校验失败
	 */
	public static final String TRANS_STATUS_CHECK_FAIL = "5";
	/**
	 * 交易处理结果待查证
	 */
	public static final String TRANS_STATUS_PENDING = "6";
	/**
	 * 交易处理结果同步结果
	 */
	public static final String TRANS_STATUS_SYNC = "7";

	/**
	 * 费用类型：固定额度
	 */
	public static final String FEE_TYPE_FIXED = "1";
	/**
	 * 费用类型：百分比
	 */
	public static final String FEE_TYPE_PERCENT = "2";

	/**
	 * 未审核
	 */
	public static final String REVIEW_NOT = "0";
	/**
	 * 审核通过
	 */
	public static final String REVIEW_PASS = "1";
	/**
	 * 审核未通过
	 */
	public static final String REVIEW_UNPASS = "2";

	/**
	 * 未生效
	 */
	public static final String IF_VALID_NO = "0";
	/**
	 * 已生效
	 */
	public static final String IF_VALID_YES = "1";

	/**
	 * 上传中
	 */
	public static final String BATCH_STATUS_UPLOADING = "1";
	/**
	 * 处理中
	 */
	public static final String BATCH_STATUS_PROCESSING = "2";
	/**
	 * 未复核
	 */
	public static final String BATCH_STATUS_UNREVIEW = "3";
	/**
	 * 复核成功
	 */
	public static final String BATCH_STATUS_REVIEW_SUCC = "4";
	/**
	 * 复核失败
	 */
	public static final String BATCH_STATUS_REVIEW_FAIL = "5";
	/**
	 * 处理成功
	 */
	public static final String BATCH_STATUS_PROCESS_SUCC = "6";
	/**
	 * 处理失败
	 */
	public static final String BATCH_STATUS_PROCESS_FAIL = "7";

	// 日志操作类型
	/**
	 * 登录
	 */
	public static final String OPERATE_TYPE_LOG_IN = "0";
	/**
	 * 查询
	 */
	public static final String OPERATE_TYPE_TRANS_SEARCH = "1";
	/**
	 * 扣款
	 */
	public static final String OPERATE_TYPE_TRANS_CUT = "2";
	/**
	 * 增加
	 */
	public static final String OPERATE_TYPE_ADD = "3";
	/**
	 * 删除
	 */
	public static final String OPERATE_TYPE_DELETE = "4";
	/**
	 * 修改
	 */
	public static final String OPERATE_TYPE_MODIFY = "5";

	/**
	 * 接口后台通知状态：已通知
	 */
	public static final String INTERFACE_NOTIFY_STATE_YES = "1";
	/**
	 * 接口后台通知状态：未通知
	 */
	public static final String INTERFACE_NOTIFY_STATE_NO = "0";
}
