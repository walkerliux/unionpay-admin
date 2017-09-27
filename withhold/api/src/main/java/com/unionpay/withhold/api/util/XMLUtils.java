package com.unionpay.withhold.api.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.util.StringUtils;

import com.unionpay.withhold.api.bean.DownloadRequest;
import com.unionpay.withhold.api.bean.DownloadResponse;
import com.unionpay.withhold.api.bean.DwnRspRoot;
import com.unionpay.withhold.api.bean.MerchantRequest;
import com.unionpay.withhold.api.bean.MerchantResponse;
import com.unionpay.withhold.api.bean.QReqRoot;
import com.unionpay.withhold.api.bean.QRspRoot;
import com.unionpay.withhold.api.bean.QueryRequest;
import com.unionpay.withhold.api.bean.QueryResponse;
import com.unionpay.withhold.api.bean.ReqRoot;
import com.unionpay.withhold.api.bean.RspRoot;
import com.unionpay.withhold.api.common.constant.CommonConstants;



/**
 * 关于ws的工具类
 * 
 * @author xujie
 * @since 2016年8月23日
 **/
public class XMLUtils {
	public final static String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	/**
	 * 验证报文传输信息
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public static Boolean validateXml(MerchantRequest request, MerchantResponse response) {
		ReqRoot root = request.getRoot();
		String mchntCd = root.getMchntCd();
		String factorId = root.getFactorId();
		String priAcctNo = root.getPriAcctId();
		String name = root.getName();
		String phone = root.getPhone();
		String idCard = root.getIdCard();
		String transAt = root.getTransAt();
		String orderId = root.getOrderId();
		String dkType = root.getDkType();
		Pattern pattern;
		Matcher matcher;
		if (!"1.0.0".equals(root.getVersion())) {
			response.getRoot().setRespCod("0035");
			response.getRoot().setRespMsg("版本号有误");
			return false;
		}
		if (StringUtils.isEmpty(root.getEncoding())) {
			root.setEncoding("UTF-8");
		}
		if (!("UTF-8".equals(root.getEncoding()) || ("GBK".equals(root.getEncoding()))
				|| ("GB2312".equals(root.getEncoding())) || ("GB18030".equals(root.getEncoding())))) {
			response.getRoot().setRespCod("0036");
			response.getRoot().setRespMsg("编码方式有误");
			return false;
		}
		if (StringUtils.isEmpty(root.getCertId())) {
			response.getRoot().setRespCod("0037");
			response.getRoot().setRespMsg("证书ID为空");
			return false;
		}
		if (StringUtils.isEmpty(root.getSignMethod())) {
			response.getRoot().setRespCod("0039");
			response.getRoot().setRespMsg("签名方法为空");
			return false;
		}
		if (!"01".equals(root.getSignMethod())) {
			response.getRoot().setRespCod("0039");
			response.getRoot().setRespMsg("签名方法错误");
			return false;
		}
		if (StringUtils.isEmpty(root.getTransType())) {
			response.getRoot().setRespCod("0040");
			response.getRoot().setRespMsg("交易类型为空");
			return false;
		}
		if (!(CommonConstants.TRANS_TP_QUERY.equals(root.getTransType())
				|| CommonConstants.TRANS_TP_SINGLE.equals(root.getTransType()))) {
			// 00：查询交易 01：代扣交易 02：消费撤销交易 03：退货交易
			response.getRoot().setRespCod("0040");
			response.getRoot().setRespMsg("交易类型错误");
			return false;
		}
		if (StringUtils.isEmpty(orderId)) {
			response.getRoot().setRespCod("0005");
			response.getRoot().setRespMsg("订单号为空");
			return false;
		}
		pattern = Pattern.compile("^\\d{15}$");
		if (StringUtils.isEmpty(mchntCd)) {
			response.getRoot().setRespCod("0002");
			response.getRoot().setRespMsg("商户号为空");
			return false;
		}
		if (mchntCd.length() != 15) {
			response.getRoot().setRespCod("0041");
			response.getRoot().setRespMsg("商户号格式异常");
			return false;
		}
		if (!pattern.matcher(mchntCd).matches()) {
			response.getRoot().setRespCod("0041");
			response.getRoot().setRespMsg("商户号格式异常");
			return false;
		}
		if (StringUtils.isEmpty(factorId)) {
			response.getRoot().setRespCod("0002");
			response.getRoot().setRespMsg("交易要素id为空");
			return false;
		}
		pattern = Pattern.compile("^\\d*$");
		if (StringUtils.isEmpty(factorId)) {
			response.getRoot().setRespCod("0002");
			response.getRoot().setRespMsg("交易要素id为空");
			return false;
		}
		if (!pattern.matcher(factorId).matches()) {
			response.getRoot().setRespCod("0004");
			response.getRoot().setRespMsg("交易要素id结构异常");
			return false;
		}
		pattern = Pattern.compile("^(\\d{16}|\\d{19}|\\d{18})$");
		matcher = pattern.matcher(priAcctNo);
		if (!matcher.matches()) {
			response.getRoot().setRespCod("0004");
			response.getRoot().setRespMsg("银行卡号格式不正确");
			return false;
		}
		if (StringUtils.isEmpty(name)) {
			response.getRoot().setRespCod("0004");
			response.getRoot().setRespMsg("姓名为空");
			return false;
		}
		if (StringUtils.isEmpty(phone)) {
			response.getRoot().setRespCod("0004");
			response.getRoot().setRespMsg("手机号为空");
			return false;
		}
		pattern = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");
		matcher = pattern.matcher(phone);
		if (!matcher.matches()) {
			response.getRoot().setRespCod("0004");
			response.getRoot().setRespMsg("手机号格式不正确");
			return false;
		}
		if (StringUtils.isEmpty(idCard)) {
			response.getRoot().setRespCod("0004");
			response.getRoot().setRespMsg("身份证号id为空");
			return false;
		}
		pattern = Pattern.compile("(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)");
		matcher = pattern.matcher(idCard);
		if (!matcher.matches()) {
			response.getRoot().setRespCod("0004");
			response.getRoot().setRespMsg("身份证号格式不正确");
			return false;
		}
		if (StringUtils.isEmpty(dkType)) {
			response.getRoot().setRespCod("0001");
			response.getRoot().setRespMsg("扣款类型为空");
			return false;
		}
		// 00：单笔交易 01：批量扣款
		if (!(CommonConstants.DAIKOU_TYPE_SINGLE.equals(dkType) || CommonConstants.DAIKOU_TYPE_BATCH.equals(dkType))) {
			response.getRoot().setRespCod("0001");
			response.getRoot().setRespMsg("扣款类型异常");
			return false;
		}
		if (StringUtils.isEmpty(transAt)) {
			response.getRoot().setRespCod("0003");
			response.getRoot().setRespMsg("交易金额为空");
			return false;
		}
		pattern = Pattern.compile("^([1-9][\\d]{0,60}|0)(\\.[\\d]{1,2})?$");
		if (!pattern.matcher(root.getTransAt()).matches()) {
			response.getRoot().setRespCod("0003");
			response.getRoot().setRespMsg("交易金额格式错误");
			return false;
		}
		if (new BigDecimal(root.getTransAt()).compareTo(new BigDecimal("999999999")) == 1) {
			response.getRoot().setRespCod("0003");
			response.getRoot().setRespMsg("交易金额超长");
			return false;
		}
		if (StringUtils.isEmpty(root.getAtType())) {
			response.getRoot().setRespCod("0042");
			response.getRoot().setRespMsg("交易币种为空");
			return false;
		}
		pattern = Pattern.compile("^\\d{3}$");
		if (!pattern.matcher(root.getAtType()).matches()) {
			response.getRoot().setRespCod("0042");
			response.getRoot().setRespMsg("交易币种异常");
			return false;
		}
		if (StringUtils.isEmpty(root.getTransTm())) {
			response.getRoot().setRespCod("0043");
			response.getRoot().setRespMsg("订单发送时间为空");
			return false;
		}
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			formatter.parse(root.getTransTm());
		} catch (ParseException e) {
			response.getRoot().setRespCod("0043");
			response.getRoot().setRespMsg("订单发送时间格式异常");
			return false;
		}
		if (StringUtils.isEmpty(root.getBackUrl())) {
			response.getRoot().setRespCod("0044");
			response.getRoot().setRespMsg("后台通知地址为空");
			return false;
		}
		pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
				Pattern.CASE_INSENSITIVE);
		if (!pattern.matcher(root.getBackUrl()).matches()) {
			response.getRoot().setRespCod("0044");
			response.getRoot().setRespMsg("后台通知地址结构异常");
			return false;
		}
		return true;
	}

	/**
	 * 验证报文传输信息
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public static String validateXml(QueryRequest request, QueryResponse response) {
		QReqRoot root = request.getRoot();
		String mchntCd = root.getMchntCd();
		String orderId = root.getOrderId();
		String transTm = root.getTransTm();
		String transQueryId = root.getTransQueryId();
		if (!"1.0.0".equals(root.getVersion())) {
			response.getRoot().setRespCod("0035");
			response.getRoot().setRespMsg("版本号有误");
			return "版本号有误";
		}
		if (StringUtils.isEmpty(root.getEncoding())) {
			root.setEncoding("UTF-8");
		} else if (!("UTF-8".equals(root.getEncoding()) || ("GBK".equals(root.getEncoding()))
				|| ("GB2312".equals(root.getEncoding())) || ("GB18030".equals(root.getEncoding())))) {
			response.getRoot().setRespCod("0036");
			response.getRoot().setRespMsg("编码方式有误");
			return "编码方式有误";
		}
		if (StringUtils.isEmpty(root.getCertId())) {
			response.getRoot().setRespCod("0037");
			response.getRoot().setRespMsg("证书ID为空");
			return "证书ID为空";
		}
		// if (StringUtils.isEmpty(root.getEncryptCertId())) {
		// response.getRoot().setRespCod("0038");
		// response.getRoot().setRespMsg("加密证书ID为空");
		// return "加密证书ID为空";
		// }
		if (StringUtils.isEmpty(root.getSignMethod())) {
			response.getRoot().setRespCod("0039");
			response.getRoot().setRespMsg("签名方法为空");
			return "签名方法为空";
		}
		if (!"01".equals(root.getSignMethod())) {
			response.getRoot().setRespCod("0039");
			response.getRoot().setRespMsg("签名方法错误");
			return "签名方法错误";
		}
		if (StringUtils.isEmpty(root.getTransType())) {
			response.getRoot().setRespCod("0040");
			response.getRoot().setRespMsg("交易类型为空");
			return "交易类型为空";
		} else if (!("00".equals(root.getTransType()) || "01".equals(root.getTransType())
				|| "02".equals(root.getTransType()) || "03".equals(root.getTransType()))) {
			// 00：查询交易 01：代扣交易 02：消费撤销交易 03：退货交易
			response.getRoot().setRespCod("0040");
			response.getRoot().setRespMsg("交易类型错误");
			return "交易类型错误";
		}
		Pattern pattern = Pattern.compile("^\\d{15}$");
		if (StringUtils.isEmpty(mchntCd)) {
			response.getRoot().setRespCod("0002");
			response.getRoot().setRespMsg("商户号为空");
			return "商户号为空";
		} else if (mchntCd.length() != 15) {
			response.getRoot().setRespCod("0041");
			response.getRoot().setRespMsg("商户号格式异常");
			return "商户号格式异常";
		} else if (!pattern.matcher(mchntCd).matches()) {
			response.getRoot().setRespCod("0041");
			response.getRoot().setRespMsg("商户号格式异常");
			return "商户号格式异常";
		}
		if (StringUtils.isEmpty(transTm) || StringUtils.isEmpty(orderId)) {
			if (StringUtils.isEmpty(transQueryId)) {
				response.getRoot().setRespCod("0005");
				return "系统订单号不能为空";
			}
		} else {
			DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			try {
				formatter.parse(transTm);
			} catch (ParseException e) {
				response.getRoot().setRespCod("0043");
				response.getRoot().setRespMsg("订单发送时间格式异常");
				return "订单发送时间格式异常";
			}
		}
		/*
		 * if (StringUtils.isEmpty(orderId)) {
		 * response.getRoot().setRespCod("0005"); return "系统订单号不能为空"; } if
		 * (StringUtils.isEmpty(transTm)) { return "订单发送时间不能为空"; } if
		 * (StringUtils.isEmpty(transQueryId)) { return "查询交易流水号不能为空"; }
		 */
		return "";
	}

	/**
	 * 将传入实体的信息装载到交易的实体中
	 *
	 * @param rspData
	 * @return
	 * @throws Exception
	 */
	public static void convertToBatch(Map<String, String> rspData, BatchDetail batchDetail) {
		String mchntCd = rspData.get("mchntCd");
		String factorId = rspData.get("factorId");
		String priAcctNo = rspData.get("priAcctId");
		String name = rspData.get("name");
		String phone = rspData.get("phone");
		String idCard = rspData.get("idCard");
		String transTm = rspData.get("transTm");
		String orderId = rspData.get("orderId");
		String backUrl = rspData.get("backUrl");
		// Long transAt = null;
		// Double transAtDbl = Double.parseDouble(rspData.get("transAt"));
		// transAt = Math.round(transAtDbl * 100);
		Long transAt = new Long(rspData.get("transAt"));
		batchDetail.setPriAcctNo(priAcctNo);
		batchDetail.setIdCard(idCard);
		batchDetail.setName(name);
		batchDetail.setPhone(phone);
		batchDetail.setMchntCd(mchntCd);
		batchDetail.setTransAt(transAt);
		batchDetail.setTransFactorId(factorId);
		batchDetail.setTransTm(transTm);
		batchDetail.setMchntOrderId(orderId);
		batchDetail.setInterfaceBackUrl(backUrl);
	}

	/**
	 * 将传入实体的信息装载到传出实体
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static MerchantResponse convertToRes(MerchantRequest request) {
		MerchantResponse response = new MerchantResponse();
		RspRoot root = new RspRoot();
		response.setRoot(root);
		response.getRoot().setVersion(request.getRoot().getVersion());
		response.getRoot().setEncoding(request.getRoot().getEncoding());
		response.getRoot().setCertId(request.getRoot().getCertId());
		response.getRoot().setSignMethod(request.getRoot().getSignMethod());
		response.getRoot().setTransType(request.getRoot().getTransType());
		response.getRoot().setOrderId(request.getRoot().getOrderId());
		response.getRoot().setMchntCd(request.getRoot().getMchntCd());
		response.getRoot().setTransAt(request.getRoot().getTransAt());
		response.getRoot().setAtType(request.getRoot().getAtType());
		response.getRoot().setTransTm(request.getRoot().getTransTm());
		response.getRoot().setRespMsg("");
		response.getRoot().setRespCod("");
		response.getRoot().setQueryId("");
		return response;
	}

	/**
	 * 将传入查询实体的信息装载到传出查询实体
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static QueryResponse convertToRes(QueryRequest request) {
		QueryResponse response = new QueryResponse();
		QRspRoot root = new QRspRoot();
		response.setRoot(root);
		response.getRoot().setVersion(request.getRoot().getVersion());
		response.getRoot().setEncoding(request.getRoot().getEncoding());
		response.getRoot().setCertId(request.getRoot().getCertId());
		response.getRoot().setSignMethod(request.getRoot().getSignMethod());
		response.getRoot().setTransTm(request.getRoot().getTransTm());
		response.getRoot().setTransType(request.getRoot().getTransType());
		response.getRoot().setOrderId(request.getRoot().getOrderId());
		response.getRoot().setMchntCd(request.getRoot().getMchntCd());
		response.getRoot().setSettleAt("");
		response.getRoot().setSettleType("");
		response.getRoot().setSettleDate("");
		response.getRoot().setExchangeRate("");
		response.getRoot().setOrigRespCode("");
		response.getRoot().setOrigRespMsg("");
		response.getRoot().setRespMsg("");
		response.getRoot().setRespCod("");
		response.getRoot().setQueryId(request.getRoot().getTransQueryId());
		return response;
	}
	
	
	/**
	 * 将传入查询实体的信息装载到传出查询实体
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static DownloadResponse convertToRes(DownloadRequest request) {
		//TODO: 还需要对照
		DownloadResponse response = new DownloadResponse();
		DwnRspRoot root = new DwnRspRoot();
		response.setRoot(root);
		response.getRoot().setVersion(request.getRoot().getVersion());
		response.getRoot().setEncoding(request.getRoot().getEncoding());
		response.getRoot().setCertId(request.getRoot().getCertId());
		response.getRoot().setSignMethod(request.getRoot().getSignMethod());
		response.getRoot().setTransType(request.getRoot().getTransType());
		response.getRoot().setMchntCd(request.getRoot().getMchntCd());
		response.getRoot().setQueryId(request.getRoot().getQueryId());
		response.getRoot().setQueryDt((request.getRoot().getQueryDt()));
		response.getRoot().setTransDt((request.getRoot().getTransDt()));
		response.getRoot().setRespMsg("");
		response.getRoot().setRespCod("");
		return response;
	}

	/**
	 * JavaBean转换成xml 默认编码UTF-8
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String convertToXml(Object obj) throws Exception {
		return convertToXml(obj, "UTF-8", true);
	}

	/**
	 * 不含xml头
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String convertToXmlWithoutHead(Object obj) throws Exception {
		return convertToXml(obj, "UTF-8", false);
	}

	/**
	 * JavaBean转换成xml
	 * 
	 * @param obj
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public static String convertToXml(Object obj, String encoding, boolean hasHead) throws Exception {
		String result = null;
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		if (!hasHead) {
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		}

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		result = writer.toString();
		return result;
	}

	/**
	 * xml转换成JavaBean
	 * 
	 * @param xml
	 * @param c
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T converyToJavaBean(String xml, Class<T> c) throws Exception {
		T t = null;
		JAXBContext context = JAXBContext.newInstance(c);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		t = (T) unmarshaller.unmarshal(new StringReader(xml));
		return t;
	}

	/**
	 * 将bean转化为map
	 *
	 * @param javaBean
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> Bean2Map(Object javaBean) {
		Map<String, String> ret = new HashMap<String, String>();
		try {
			Method[] methods = javaBean.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get")) {
					String field = method.getName();
					field = field.substring(field.indexOf("get") + 3);
					field = field.toLowerCase().charAt(0) + field.substring(1);
					Object value = method.invoke(javaBean, (Object[]) null);
					ret.put(field, (null == value ? "" : value.toString()));
				}
			}
		} catch (Exception e) {
		}
		return ret;
	}

}
