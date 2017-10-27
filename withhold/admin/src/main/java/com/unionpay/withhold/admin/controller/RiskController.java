package com.unionpay.withhold.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.ParaDicCodeEnums;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.pojo.TRisk;
import com.unionpay.withhold.admin.pojo.TRiskCase;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.ParaDicService;
import com.unionpay.withhold.admin.service.RiskCaseService;
import com.unionpay.withhold.admin.service.RiskService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MyCookieUtils;

@Controller
@RequestMapping("/risk")
public class RiskController {
	@Autowired
	private RiskService riskService;
	@Autowired
	private RiskCaseService riskCaseService;
	@Autowired
	private ParaDicService paraDicService;
	@Autowired
	private UserService userService;

	/**
	 * 风控版本管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toRiskManager", method = RequestMethod.GET)
	public String toRiskManager() {
		return "/risk/risk_manager";
	}

	/**
	 * 银行卡黑名单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardBlackList", method = RequestMethod.GET)
	public String toCardBlackList() {
		return "/risk/card_black_list";
	}

	/**
	 * 持卡人黑名单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardholderBlackList", method = RequestMethod.GET)
	public String toCardholderBlackList() {
		return "/risk/cardholder_black_list";
	}

	/**
	 * 银行卡白名单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardWhiteList", method = RequestMethod.GET)
	public String toCardWhiteList() {
		return "/risk/card_white_list";
	}

	/**
	 * 单笔限额
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toSingleLimit", method = RequestMethod.GET)
	public String toSingleLimit() {
		return "/risk/single_limit";
	}

	/**
	 * 商户日累计限次
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toMerchDayNumLimit", method = RequestMethod.GET)
	public String toMerchDayNumLimit() {
		return "/risk/merch_day_num_limit";
	}

	/**
	 * 商户日累计限额
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toMerchDayAmtLimit", method = RequestMethod.GET)
	public String toMerchDayAmtLimit() {
		return "/risk/merch_day_amt_limit";
	}

	/**
	 * 银行卡单日限次
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardDayNumLimit", method = RequestMethod.GET)
	public String toCardDayNumLimit() {
		return "/risk/card_day_num_limit";
	}

	/**
	 * 银行卡单日限额
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardDayAmtLimit", method = RequestMethod.GET)
	public String toCardDayAmtLimit() {
		return "/risk/card_day_amt_limit";
	}

	/**
	 * 查询风控版本列表
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllRiskList")
	public List<TRisk> getAllRiskList() {
		return riskService.getAllRiskList();
	}

	/**
	 * 查询所有的风险级别
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showAllRisklevel")
	public List<TParaDic> showAllRisklevel() {
		return paraDicService.selectParaDicByParentCode(ParaDicCodeEnums.RISKLEVEL.getCode());
	}

	/**
	 * 查询风控分页信息
	 * 
	 * @param risk
	 * @param page
	 * @param rows
	 * @return PageBean
	 */
	@ResponseBody
	@RequestMapping("/queryRisk")
	public PageBean queryRisk(TRisk risk, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		PageHelper.startPage(page, rows);
		List<TRisk> list = riskService.selectRiskByCondition(risk);
		PageInfo<TRisk> pageInfo = new PageInfo<>(list);
		PageBean pageBean = new PageBean(new Long(pageInfo.getTotal()).intValue(), list);
		return pageBean;
	}

	/**
	 * 查询风控版本信息详情
	 * 
	 * @param riskid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRiskByRiskid")
	public TRisk queryRiskByRiskid(Long riskid) {
		return riskid == null ? null : riskService.queryRiskByRiskid(riskid);
	}

	/**
	 * 新增风控版本信息
	 * 
	 * @param risk
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addRisk")
	public ResultBean addRisk(TRisk risk, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		risk.setInuser(infoByToken.getUserId().longValue());
		try {
			return riskService.addRisk(risk);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}

	/**
	 * 修改风控版本信息
	 * 
	 * @param risk
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateRisk")
	public ResultBean updateRisk(TRisk risk, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		risk.setUpuser(infoByToken.getUserId().longValue());
		try {
			return riskService.updateRisk(risk);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}

	/**
	 * 查询风控实例信息
	 * 
	 * @param riskver
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRiskCaseByRiskver")
	public TRiskCase queryRiskCaseByRiskver(String riskver) {
		return StringUtils.isBlank(riskver) ? null : riskCaseService.queryRiskCaseByRiskver(riskver);
	}

	/**
	 * 添加风控版本实例
	 * 
	 * @param riskCase
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addRiskCase")
	public ResultBean assRiskCase(TRiskCase riskCase, String[] checkboxList, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		riskCase.setInuser(infoByToken.getUserId().longValue());
		riskCase.setActiveflag(riskCaseService.changRiskStrategy(checkboxList));
		try {
			return riskCaseService.addRiskCase(riskCase);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}

	/**
	 * 修改风控版本实例
	 * 
	 * @param riskCase
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateRiskCase")
	public ResultBean updateRiskCase(TRiskCase riskCase, String[] checkboxList, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		riskCase.setUpuser(infoByToken.getUserId().longValue());
		riskCase.setActiveflag(riskCaseService.changRiskStrategy(checkboxList));
		try {
			return riskCaseService.updateRiskCase(riskCase);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
}
