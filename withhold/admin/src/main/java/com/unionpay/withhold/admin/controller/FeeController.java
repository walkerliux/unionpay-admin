package com.unionpay.withhold.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.tools.framedump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.AccumRateBean;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.FeeService;
import com.unionpay.withhold.admin.service.OperationLogService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.AmtParseUtil;
import com.unionpay.withhold.admin.utils.MyCookieUtils;


@Controller
@RequestMapping("/fee")
public class FeeController {
	@Autowired
	private UserService userService;
	@Autowired
	private FeeService feeService;
	@Autowired
	private OperationLogService operationLogService;
	/**
	 * 交易金额分段扣率页面
	 * 
	 * @return
	 */
	@RequestMapping("/showRateAmt")
	public ModelAndView showRateAmt() {
		ModelAndView result=new ModelAndView("/fee/_rate_amt_accum_manager");
        return result;
	}
	/**
	 * 特殊公式扣率页面
	 * 
	 * @return
	 */
	@RequestMapping("/showSpecialFormula")
	public ModelAndView showSpecialFormula() {
		ModelAndView result=new ModelAndView("/fee/special_formula_accum_manager");
        return result;
	}
	/**
	 * 交易金额分段扣率查询 
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/queryAmtAccumRate")
	@ResponseBody
	public PageBean queryAmtAccumRate(String rateId,String rateDesc,int page,int rows) {
		PageBean resultBean =feeService.queryAmtAccumRate(rateId,rateDesc,page,rows);
	    return resultBean;
	}
	//
	
	/**
	 * 新增交易金额分段扣率
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/saveAmtAccumRate")
	@ResponseBody
	public Map<String, Object> saveAmtAccumRate(AccumRateBean accumRateBean,HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		accumRateBean.setInuser(infoByToken.getUserId().toString());
		Map<String, Object> map = new HashMap<String, Object>();
		int length = accumRateBean.getArdList().size();
		
		accumRateBean.getArdList().get(0).setStartRange("0");;
		for (int i = 0; i < length; i++) {
			if (i>=1&&accumRateBean.getArdList().get(i).getStartRange()!=null&&!"".equals(accumRateBean.getArdList().get(i).getStartRange())) {
				 Long amtfen = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getStartRange());
				//分界线金额 上一段的end
				accumRateBean.getArdList().get(i-1).setEndrange(amtfen.toString());
				//本段的Start
				accumRateBean.getArdList().get(i).setStartRange(amtfen.toString());
			}
			if (accumRateBean.getArdList().get(i).getMinFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getMinFee())) {
				 Long minFeefen = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getMinFee());
				accumRateBean.getArdList().get(i).setMinFee(minFeefen.toString());
			}
			if (accumRateBean.getArdList().get(i).getMaxFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getMaxFee())) {
				Long maxFeefen = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getMaxFee());
				accumRateBean.getArdList().get(i).setMaxFee(maxFeefen.toString());
			}
			//费率小数转整数
			if (accumRateBean.getArdList().get(i).getFeeRate()!=null&&!"".equals(accumRateBean.getArdList().get(i).getFeeRate())) {
				Long feeRatefee = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getFeeRate());
				accumRateBean.getArdList().get(i).setFeeRate(feeRatefee.toString());
			}
		}
		try {
			feeService.addAmtAccumRate(accumRateBean);
			operationLogService.addOperationLog(request, "新增交易金额分段扣率");
			map.put("RET", "succ");
			map.put("INFO", "添加成功");
			return map;
		} catch (Exception e) {
			map.put("RET", "error");
			map.put("INFO", e.getMessage());
			return map;
		}
	}
	/**
	 * 查询交易金额或交易笔数累计分段扣率详情
	 * 
	 * @author: liuxin
	 * @param rateId
	 * @return Map<String,Object>
	 * @date: 2017年10月30日
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryAccumRateDeta")
	public PageBean queryAccumRateDeta(String rateId) {
		
		PageBean resultList = feeService.queryAccumRateDeta(rateId);
		return resultList;
	}
	/**
	 * 修改交易金额分段扣率
	 * @author:LIUXIN
	 * @return map
	 * 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("updateAmtAccumRate")
	public Map<String, Object> updateAmtAccumRate(AccumRateBean accumRateBean, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		accumRateBean.setInuser(infoByToken.getUserId().toString());
		Map<String, Object> map = new HashMap<String, Object>();
		int length = accumRateBean.getArdList().size();
		
		accumRateBean.getArdList().get(0).setStartRange("0");;
		for (int i = 0; i < length; i++) {
			if (i>=1&&accumRateBean.getArdList().get(i).getStartRange()!=null&&!"".equals(accumRateBean.getArdList().get(i).getStartRange())) {
				Long endRange = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getStartRange());
				
				//分界线金额 上一段的end
				accumRateBean.getArdList().get(i-1).setEndrange(endRange.toString());
				//本段的Start
				accumRateBean.getArdList().get(i).setStartRange(endRange.toString());
			}
			if (accumRateBean.getArdList().get(i).getMinFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getMinFee())) {
				Long minFee = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getMinFee());
				accumRateBean.getArdList().get(i).setMinFee(minFee.toString());
			}
			if (accumRateBean.getArdList().get(i).getMaxFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getMaxFee())) {
				Long maxFee = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getMaxFee());
				accumRateBean.getArdList().get(i).setMaxFee(maxFee.toString());
			}
			//费率小数转整数
			if (accumRateBean.getArdList().get(i).getFeeRate()!=null&&!"".equals(accumRateBean.getArdList().get(i).getFeeRate())) {
				Long feeRate = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getFeeRate());
				accumRateBean.getArdList().get(i).setFeeRate(feeRate.toString());
			}
		}
		try {
			feeService.updateAccumRate(accumRateBean);
			operationLogService.addOperationLog(request, "修改交易金额分段扣率");
			map.put("RET", "succ");
			map.put("INFO", "修改成功");
			return map;
		} catch (Exception e) {
			map.put("RET", "error");
			map.put("INFO", e.getMessage());
			return map;
		}
	}
	//
	/**
	 * 特殊公式计费列表查询 
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/querySpecialfee")
	@ResponseBody
	public PageBean querySpecialfee(String rateId,String rateDesc,int page,int rows) {
		PageBean resultBean =feeService.querySpecialfee(rateId,rateDesc,page,rows);
	    return resultBean;
	}
	//
	/**
	 * 新增特殊公式
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/savespefee")
	@ResponseBody
	public Map<String, Object> savespefee(AccumRateBean accumRateBean,HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		accumRateBean.setInuser(infoByToken.getUserId().toString());
		Map<String, Object> map = new HashMap<String, Object>();
		int length = accumRateBean.getArdList().size();
		
		//将元转分
		for (int i = 0; i < length; i++) {
			if (accumRateBean.getArdList().get(i).getMinFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getMinFee())) {
				Long minFee = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getMinFee());
				accumRateBean.getArdList().get(i).setMinFee(minFee.toString());
			}
			if (accumRateBean.getArdList().get(i).getMaxFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getMaxFee())) {
				Long maxFee = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getMaxFee());
				accumRateBean.getArdList().get(i).setMaxFee(maxFee.toString());
			}
			if (accumRateBean.getArdList().get(i).getFixFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getFixFee())) {
				Long fixFee = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getFixFee());
				accumRateBean.getArdList().get(i).setFixFee(fixFee.toString());
			}
			if (accumRateBean.getArdList().get(i).getFeeRate()!=null&&!"".equals(accumRateBean.getArdList().get(i).getFeeRate())) {
				Long feeRate = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getFeeRate());
				accumRateBean.getArdList().get(i).setFeeRate(feeRate.toString());
			}
		}
		try {
			feeService.savespefee(accumRateBean);
			operationLogService.addOperationLog(request, "新增特殊公式扣率");
			map.put("RET", "succ");
			map.put("INFO", "添加成功");
			return map;
		} catch (Exception e) {
			map.put("RET", "error");
			map.put("INFO", e.getMessage());
			return map;
		}
	}
	//querySpecialFeeDeta
	/**
	 * 特殊公式详情
	 * @author: liuxin
	 * @param rateId
	 * @return pagebean
	 * @date: 2017年10月30日
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("querySpecialFeeDeta")
	public PageBean querySpecialFeeDeta(String rateId) {
		PageBean resultList = feeService.querySpecialFeeDeta(rateId);
		return resultList;
	}
	/**
	 * 修改交易金额分段扣率
	 * @author:LIUXIN
	 * @return map
	 * 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("updateSpecialFeeRate")
	public Map<String, Object> updateSpecialFeeRate(AccumRateBean accumRateBean, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		accumRateBean.setInuser(infoByToken.getUserId().toString());
		Map<String, Object> map = new HashMap<String, Object>();
		int length = accumRateBean.getArdList().size();
		
		accumRateBean.getArdList().get(0).setStartRange("0");;
		for (int i = 0; i < length; i++) {
		
			if (accumRateBean.getArdList().get(i).getMinFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getMinFee())) {
				Long minFee = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getMinFee());
				accumRateBean.getArdList().get(i).setMinFee(minFee.toString());
			}
			if (accumRateBean.getArdList().get(i).getMaxFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getMaxFee())) {
				Long maxFee = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getMaxFee());
				accumRateBean.getArdList().get(i).setMaxFee(maxFee.toString());
			}
			if (accumRateBean.getArdList().get(i).getFixFee()!=null&&!"".equals(accumRateBean.getArdList().get(i).getFixFee())) {
				Long fixFee = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getFixFee());
				accumRateBean.getArdList().get(i).setFixFee(fixFee.toString());
			}
			if (accumRateBean.getArdList().get(i).getFeeRate()!=null&&!"".equals(accumRateBean.getArdList().get(i).getFeeRate())) {
				Long feeRate = AmtParseUtil.strToLongAmt(accumRateBean.getArdList().get(i).getFeeRate());
				accumRateBean.getArdList().get(i).setFeeRate(feeRate.toString());
			}
		}
		try {
			feeService.updateSpecialFeeRate(accumRateBean);
			operationLogService.addOperationLog(request, "修改特殊公式扣率");
			map.put("RET", "succ");
			map.put("INFO", "修改成功");
			return map;
		} catch (Exception e) {
			map.put("RET", "error");
			map.put("INFO", e.getMessage());
			return map;
		}
	}
}
