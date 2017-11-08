package com.unionpay.withhold.admin.controller;

import javax.servlet.http.HttpServletRequest;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatch;
import com.unionpay.withhold.admin.pojo.TOrderCollectSingle;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.PortalService;
import com.unionpay.withhold.admin.service.TradeService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MyCookieUtils;


/**
 * 门户管理
 * @author yinguanghui
 * @date	2017年10月11日 15:16:06
 */
@Controller
@RequestMapping("/portalManager")
public class PortalManagerController {
	@Autowired
	private TradeService tradeService;
	@Autowired
	private UserService userService;
	@Autowired
	private PortalService portalService;
	/**
	 * 门户订单实时查询页面
	 * @return ModelAndView
	 * @version v1.0
	 */
	@RequestMapping("/single_collect_order_query")
	public ModelAndView showSingle_collect_order_query() {
		 ModelAndView result=new ModelAndView("/portal/single_collect_order_query");
	     return result;
	}
	
	/**
	 * 门户订单批量查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/batch_collect_order_query")
	public ModelAndView showBatch_collect_order_query() {
		 ModelAndView result=new ModelAndView("/portal/batch_collect_order_query");
	     return result;
	}
	
	/**
	 * 门户订单批量查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/startRealTimetrade")
	public ModelAndView showsingle_withhold() {
		 ModelAndView result=new ModelAndView("/portal/single_withhold");
	     return result;
	}
	
	/**
	 * 订单实时条件分页查询 
	 * @author:yinguanghui
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getSingleOrderByPage")
	@ResponseBody
	public PageBean getSingleOrderByPage(TOrderCollectSingle orderSingle,String stime,String etime,int page,int rows, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		String merid =infoByToken.getUserName();
		orderSingle.setMerid(merid);
		PageBean resultBean =tradeService.getSingleOrderByPage(orderSingle,stime,etime,page,rows);
	    return resultBean;
	}
	/**
	 * 订单批量条件分页查询
	 * @author:yinguanghui
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getBatchOrderByPage")
	@ResponseBody
	public PageBean getBatchOrderByPage(TOrderCollectBatch orderBatch,String stime,String etime,int page,int rows,HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		String merid =infoByToken.getUserName();
		orderBatch.setMerid(merid);
		PageBean resultBean =tradeService.getBatchOrderByPage(orderBatch,stime,etime,page,rows);
	    return resultBean;
	}
	
	/**
	 * 获取当前用户的交易要素
	 * @param request
	 * @return
	 */
	@RequestMapping("/getTransfactors")
	@ResponseBody
	public TParaDic getTransfactors(HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		String loginName =infoByToken.getLoginName();
		TParaDic paraDic =portalService.getTransfactors(loginName);
		return paraDic;
	}
	
}
