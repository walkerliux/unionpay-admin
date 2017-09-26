package com.unionpay.withhold.util;

public class ErrCodeUtil {
	/**
	 * 获取错误信息
	 * 
	 * @param errorCode
	 * @param errMsgKey
	 * @return
	 */
	public static String[] getErrMsg(String errorCode, String... errMsgKey) {
		String[] errInfo = errorCode.split("\\|");
		for (int index = 0; index < errMsgKey.length; index++) {
			if (errInfo[1].indexOf("%s") != -1) {
				errInfo[1] = errInfo[1].replaceFirst("%s", errMsgKey[index]);
			}
		}
		return errInfo;
	}

	public static String getErrMsgStr(String errorCode, String... errMsgKey) {
		String[] errInfo = getErrMsg(errorCode, errMsgKey);
		return errInfo[0] + "|" + errInfo[1];
	}
}
