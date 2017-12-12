package com.unionpay.withhold.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.PortalService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.AmtParseUtil;
import com.unionpay.withhold.admin.utils.MyCookieUtils;
import com.unionpay.withhold.admin.utils.ReadExcel;
import com.unionpay.withhold.trade.api.FEAPI;
import com.unionpay.withhold.trade.api.bean.BatchCollectBean;
import com.unionpay.withhold.trade.api.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.api.bean.ResultBean;
import com.unionpay.withhold.trade.api.bean.SingleCollectBean;
import com.unionpay.withhold.utils.DateUtil;
//merchant_portal/showDetails
@Controller
@RequestMapping("/portalManager")
public class MerchantPortalController {
	@Value("${VERSION}")
	private String VERSION;// 版本号
	@Value("${ENCODING}")
	private String ENCODING;//编码格式
	@Value("${TXNTYPE_SINGLE}")
	private String TXNTYPE_SINGLE;//实时交易类型
	@Value("${TXNTYPE_BATCH}")
	private String TXNTYPE_BATCH;//批量交易类型
	@Value("${TXNSUBTYPE}")
	private String TXNSUBTYPE;//交易子类
	@Value("${BIZTYPE_SINGLE}")
	private String BIZTYPE_SINGLE;//实时产品类型
	@Value("${BIZTYPE_BATCH}")
	private String BIZTYPE_BATCH;//批量产品类型
	@Value("${BACkURL}")
	private String BACkURL;// 通知地址
	@Value("${DkType}")
	private String DkType;//扣款类型
	@Value("${SignMethod}")
	private String SignMethod;// 签名方式
	@Value("${EncryptCertId}")
	private String EncryptCertId;// 加密证书ID
	@Value("${Reserved}")
	private String Reserved;//保留域
	@Value("${AtType}")
	private String AtType;//交易币种
	@Value("${EXCELPATH}")
	private String EXCELPATH;
	@Autowired
	private FEAPI feapi;
	@Autowired
	private UserService userService;
	@Autowired
	private PortalService portalService;
	/**
	 * 发起批量交易页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/startbatchtrade")
	public ModelAndView showStartBatchTrade() {
		 ModelAndView result=new ModelAndView("/merchant_portal/merch_batch_trade_manager");
	     return result;
	}
	/**
	 * 发起实时交易页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	/*@RequestMapping("/startRealTimetrade")
	public ModelAndView startRealTimetrade() {
		 ModelAndView result=new ModelAndView("/merchant_portal/merch_realtime_trade_manager");
	     return result;
	}*/
	
	/**
	 * @return
	 * @author Administrator
	 * @param date
	 * 发起实时交易
	*/
	@RequestMapping(value="/startRealTimeTrade", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean launchRealTimeTrade(SingleCollectBean bean,HttpServletRequest request){
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		String loginName =infoByToken.getLoginName();//商户登录 则loginName为商户号
		bean.setEncoding(ENCODING);// 编码方式
		bean.setVersion(VERSION);//版本
		bean.setBackUrl(BACkURL);// 后台通知地址
		bean.setBizType(BIZTYPE_SINGLE);//产品类型
		bean.setTransType(TXNTYPE_SINGLE);// 实时交易类型
		bean.setTxnSubType(TXNSUBTYPE);//交易子类
		bean.setTransTm(DateUtil.getCurrentDateTime());// 订单发送时间
		bean.setAtType(AtType);// 交易币种
		// 交易金额(元转分)
		String transAt = bean.getTransAt();
		Long amt = AmtParseUtil.strToLongAmt(transAt);
		bean.setTransAt(amt+"");
		// 扣款类型
		bean.setDkType(DkType);
		// 系统商户号
		bean.setMchntCd(loginName);
		// 证书ID
		//TMerchMk mk= portalService.getCertId(loginName);
		bean.setCertId("0000");
		// 签名方式
		bean.setSignMethod(SignMethod);
		bean.setAccessType(1);//接入类型 商户门户发起默认为1
		// 加密证书ID
		bean.setEncryptCertId(EncryptCertId);
		ResultBean resultBean = feapi.realTimeCollect(JSON.toJSONString(bean));
		return resultBean;
	}
	/**
	 * @return
	 * @author Administrator
	 * @param date
	 * 解析excel
	*/
	@RequestMapping(value="/showDetails", method = RequestMethod.POST)
	@ResponseBody
	public List<BatchCollectDetaBean> showDetails(@RequestParam("excelFile") MultipartFile excelFile, HttpServletRequest request,HttpServletResponse response){
		
		//判断文件是否为空
        if(excelFile==null){ return null;}
        //获取文件名
        String name=excelFile.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=excelFile.getSize();
        if(name==null || ("").equals(name) && size==0){ return null;}
        
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取客户信息集合。
        List<BatchCollectDetaBean> dateList = readExcel.getExcelInfo(name ,excelFile,EXCELPATH);
        //批量导入。参数：文件名，文件。
        
       return dateList;
	}
	/**
	 * @return
	 * @author Administrator
	 * @param date
	 * 发起批量交易
	*/
	@RequestMapping(value="/startBatchTrade",method=RequestMethod.POST)
	@ResponseBody
	public ResultBean launchBatchTrade(String jsonStr,String transfactors,String batchNo,HttpServletRequest request){
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		String loginName =infoByToken.getLoginName();//商户登录 则loginName为商户号
		 //将json字符串数组转换为list
		JSONObject jo=new JSONObject();  
		List<BatchCollectDetaBean> detaList = jo.parseArray(jsonStr, BatchCollectDetaBean.class);
		//将金额由元转分
		int totalAmt=0;
		for (BatchCollectDetaBean batchCollectDetaBean : detaList) {
			String amtyuan = batchCollectDetaBean.getAmt();
			 Long amtfen = AmtParseUtil.strToLongAmt(amtyuan);
			
			batchCollectDetaBean.setAmt(amtfen+"");
			totalAmt+=amtfen;
			//卡类型转换
			if (batchCollectDetaBean.getCardType().equals("借记卡")) {
				batchCollectDetaBean.setCardType("1");
			}
			if (batchCollectDetaBean.getCardType().equals("信用卡")) {
				batchCollectDetaBean.setCardType("2");
			}
		}
		BatchCollectBean batchCollectBean = new BatchCollectBean();
		batchCollectBean.setDetaList(detaList);//批次明细
		batchCollectBean.setBatchNo(batchNo);//批次号
		batchCollectBean.setFactorId(transfactors);//交易要素id
		batchCollectBean.setVersion(VERSION);// 版本
		batchCollectBean.setEncoding(ENCODING);// 编码方式
		/**交易类型*/
		batchCollectBean.setTxnType(TXNTYPE_BATCH);
		/**交易子类*/
		batchCollectBean.setTxnSubType(TXNSUBTYPE);
		batchCollectBean.setBizType(BIZTYPE_BATCH);
		batchCollectBean.setBackUrl(BACkURL);// 通知地址
		batchCollectBean.setReserved(Reserved);// 保留域
		batchCollectBean.setTxnTime(DateUtil.getCurrentDateTime());// 订单发送时间
		batchCollectBean.setMerId(loginName);//商户号
		batchCollectBean.setTotalQty(detaList.size()+"");//总笔数
		
		batchCollectBean.setTotalAmt(totalAmt+"");//交易总金额
		batchCollectBean.setAccessType(1);//接入类型 商户门户发起默认为1
		/**certid*/
		//TMerchMk certId = portalService.getCertId(loginName);
		batchCollectBean.setCertId("0000");
		
		ResultBean resultBean = feapi.batchCollect(JSON.toJSONString(batchCollectBean));
		return resultBean;
	}
}
