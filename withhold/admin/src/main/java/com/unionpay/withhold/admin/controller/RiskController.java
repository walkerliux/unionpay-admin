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
import com.unionpay.withhold.admin.pojo.TBlacklistIdnum;
import com.unionpay.withhold.admin.pojo.TBlacklistPan;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.pojo.TRisk;
import com.unionpay.withhold.admin.pojo.TRiskCase;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.pojo.TWhitelistPan;
import com.unionpay.withhold.admin.service.CardBlackListService;
import com.unionpay.withhold.admin.service.CardWhiteListService;
import com.unionpay.withhold.admin.service.CardholderBlackListService;
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
	private CardBlackListService cardBlackListService;
	@Autowired
	private CardholderBlackListService cardholderBlackListService;
	@Autowired
	private CardWhiteListService cardWhiteListService;
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
	
	
	/** start ********************* 银行卡黑名单  *********************/	
	/**
	 * 查询银行卡黑名单分页信息
	 * 
	 * @param blacklistPan
	 * @param page
	 * @param rows
	 * @return PageBean
	 */
	@ResponseBody
	@RequestMapping("/queryCardBlackList")
	public PageBean queryCardBlackList(TBlacklistPan blacklistPan, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return blacklistPan == null ? null : cardBlackListService.selectListWithCondition(blacklistPan, page, rows);
	}
	
	/**
	 * 查询银行卡黑名单信息详情
	 * 
	 * @param tid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCardBlackListByTid")
	public TBlacklistPan queryCardBlackListByTid(Integer tid) {
		return tid == null ? null : cardBlackListService.queryCardBlackListByTid(tid);
	}
	
	/**
	 * 新增银行卡黑名单
	 * 
	 * @param blacklistPan
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCardBlackList")
	public ResultBean addCardBlackList(TBlacklistPan blacklistPan, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		blacklistPan.setInuser(infoByToken.getUserId().longValue());
		try {
			return cardBlackListService.addCardBlackList(blacklistPan);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 修改银行卡黑名单
	 * 
	 * @param blacklistPan
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCardBlackList")
	public ResultBean updateCardBlackList(TBlacklistPan blacklistPan, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		blacklistPan.setUpuser(infoByToken.getUserId().longValue());
		try {
			return cardBlackListService.updateCardBlackList(blacklistPan);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 注销银行卡黑名单
	 * 
	 * @param blacklistPan
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logoutCardBlackList")
	public ResultBean logoutCardBlackList(TBlacklistPan blacklistPan, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		blacklistPan.setUpuser(infoByToken.getUserId().longValue());
		try {
			return cardBlackListService.logoutCardBlackList(blacklistPan);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 启用银行卡黑名单
	 * 
	 * @param blacklistPan
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startCardBlackList")
	public ResultBean startCardBlackList(TBlacklistPan blacklistPan, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		blacklistPan.setUpuser(infoByToken.getUserId().longValue());
		try {
			return cardBlackListService.startCardBlackList(blacklistPan);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/** end   ********************* 银行卡黑名单  *********************/
	
	
	
	/** start ********************* 持卡人黑名单  *********************/	
	/**
	 * 查询持卡人黑名单分页信息
	 * 
	 * @param blacklistIdnum
	 * @param page
	 * @param rows
	 * @return PageBean
	 */
	@ResponseBody
	@RequestMapping("/queryCardholderBlackList")
	public PageBean queryCardholderBlackList(TBlacklistIdnum blacklistIdnum, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return blacklistIdnum == null ? null : cardholderBlackListService.selectListWithCondition(blacklistIdnum, page, rows);
	}
	
	/**
	 * 查询持卡人黑名单信息详情
	 * 
	 * @param tid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCardholderBlackListByTid")
	public TBlacklistIdnum queryCardholderBlackListByTid(Integer tid) {
		return tid == null ? null : cardholderBlackListService.queryCardholderBlackListByTid(tid);
	}
	
	/**
	 * 新增持卡人黑名单
	 * 
	 * @param blacklistIdnum
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCardholderBlackList")
	public ResultBean addCardholderBlackList(TBlacklistIdnum blacklistIdnum, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		blacklistIdnum.setInuser(infoByToken.getUserId().longValue());
		try {
			return cardholderBlackListService.addCardholderBlackList(blacklistIdnum);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 修改持卡人黑名单
	 * 
	 * @param blacklistIdnum
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCardholderBlackList")
	public ResultBean updateCardholderBlackList(TBlacklistIdnum blacklistIdnum, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		blacklistIdnum.setUpuser(infoByToken.getUserId().longValue());
		try {
			return cardholderBlackListService.updateCardholderBlackList(blacklistIdnum);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 注销持卡人黑名单
	 * 
	 * @param blacklistIdnum
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logoutCardholderBlackList")
	public ResultBean logoutCardholderBlackList(TBlacklistIdnum blacklistIdnum, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		blacklistIdnum.setUpuser(infoByToken.getUserId().longValue());
		try {
			return cardholderBlackListService.logoutCardholderBlackList(blacklistIdnum);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 启用持卡人黑名单
	 * 
	 * @param blacklistIdnum
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startCardholderBlackList")
	public ResultBean startCardholderBlackList(TBlacklistIdnum blacklistIdnum, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		blacklistIdnum.setUpuser(infoByToken.getUserId().longValue());
		try {
			return cardholderBlackListService.startCardholderBlackList(blacklistIdnum);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/** end   ********************* 持卡人黑名单  *********************/
	
	
	/** start ********************* 银行卡白名单  *********************/	
	/**
	 * 查询银行卡白名单分页信息
	 * 
	 * @param whitelistPan
	 * @param page
	 * @param rows
	 * @return PageBean
	 */
	@ResponseBody
	@RequestMapping("/queryCardWhiteList")
	public PageBean queryCardWhiteList(TWhitelistPan whitelistPan, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return whitelistPan == null ? null : cardWhiteListService.selectListWithCondition(whitelistPan, page, rows);
	}
	
	/**
	 * 查询银行卡白名单信息详情
	 * 
	 * @param tid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCardWhiteListByTid")
	public TWhitelistPan queryCardWhiteListByTid(Integer tId) {
		return tId == null ? null : cardWhiteListService.queryCardWhiteListByTid(tId);
	}
	
	/**
	 * 新增银行卡白名单
	 * 
	 * @param whitelistPan
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCardWhiteList")
	public ResultBean addCardWhiteList(TWhitelistPan whitelistPan, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		whitelistPan.setInuser(infoByToken.getUserId().longValue());
		try {
			return cardWhiteListService.addCardWhiteList(whitelistPan);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 修改银行卡白名单
	 * 
	 * @param whitelistPan
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCardWhiteList")
	public ResultBean updateCardWhiteList(TWhitelistPan whitelistPan, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		whitelistPan.setUpuser(infoByToken.getUserId().longValue());
		try {
			return cardWhiteListService.updateCardWhiteList(whitelistPan);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 注销银行卡白名单
	 * 
	 * @param whitelistPan
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logoutCardWhiteList")
	public ResultBean logoutCardWhiteList(TWhitelistPan whitelistPan, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		whitelistPan.setUpuser(infoByToken.getUserId().longValue());
		try {
			return cardWhiteListService.logoutCardWhiteList(whitelistPan);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 启用银行卡白名单
	 * 
	 * @param whitelistPan
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startCardWhiteList")
	public ResultBean startCardWhiteList(TWhitelistPan whitelistPan, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		whitelistPan.setUpuser(infoByToken.getUserId().longValue());
		try {
			return cardWhiteListService.startCardWhiteList(whitelistPan);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/** end   ********************* 银行卡白名单  *********************/
}

