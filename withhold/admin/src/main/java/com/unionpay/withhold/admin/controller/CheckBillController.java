package com.unionpay.withhold.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TCheckfileMistake;
import com.unionpay.withhold.admin.pojo.TSelfTxn;
import com.unionpay.withhold.admin.pojo.TSettProcess;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.CheckBillService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MyCookieUtils;
import com.unionpay.withhold.utils.DateUtil;

@Controller
@RequestMapping("/checkbill/")
public class CheckBillController {
	
	@Autowired
	private CheckBillService checkBillService;
	@Autowired
	private UserService userService;
    @RequestMapping("toResult")
    public String index() {
        return "/checkinfo/file_start";
    }
    @RequestMapping("toResultSum")
    public String toResultSum() {
        return "/checkinfo/file_start_sum";
    }
    /**
	 * 查询机构
	 * 
	 * @author: zhangshd
	 * @return List<ChannelFileBean>
	 * @date: 2017年3月1日 下午3:31:05
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryChannel")
	public List<?> queryChannel() {
		List<?> list = checkBillService.getAllChannel();
		return list;
	}
	
	/**
	 * 任务分页查询（新增任务，开始对账）
	 * 
	 * @author: zhangshd
	 * @return Map<String, Object>
	 * @date: 2017年3月1日 下午4:22:35
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryProcess")
	public PageBean queryProcess(String instiid,String startDate, String endDate, String page, String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		if (!StringUtils.isBlank(startDate)) {
			variables.put("startDate", startDate.replace("-", ""));
		}
		if (!StringUtils.isBlank(endDate)) {
			variables.put("endDate", endDate.replace("-", ""));
		}
		if (!StringUtils.isBlank(instiid)) {
			variables.put("instiid", instiid);
		}
		PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
		List<TSettProcess> processList = checkBillService.queryPorcess(variables);
		PageInfo<TSettProcess> pageInfo=new PageInfo<>(processList);
		PageBean pageBean=new PageBean(new Long(pageInfo.getTotal()).intValue(), processList);
		return pageBean;
	}
	
	/**
	 * 生成任务
	 * @param instiid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveProcess")
	public Map<String, Object> saveProcess(String instiid) {
		Map<String, Object> map = checkBillService.saveProcess(instiid);
		return map;
	}
	
	
	/**
	 * 查询对账差错的记录
	 * 
	 * @author: zhangshd
	 * @param filestartid
	 * @return List<?>
	 * @date: 2017年3月1日 下午5:04:13
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryFail")
	public PageBean queryFail(HttpServletRequest request, String page, String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("proid", request.getParameter("proid"));
		PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
		List<TCheckfileMistake> failList = checkBillService.queryFail(variables);
		PageInfo<TCheckfileMistake> pageInfo=new PageInfo<>(failList);
		PageBean pageBean=new PageBean(new Long(pageInfo.getTotal()).intValue(), failList);
		return pageBean;
	}

	/**
	 * 查询对账成功的记录
	 * 
	 * @author: zhangshd
	 * @param filestartid
	 * @return List<?>
	 * @date: 2017年3月1日 下午5:04:13
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("querySuccess")
	public PageBean querySuccess(HttpServletRequest request, String page, String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("proid", request.getParameter("proid"));
		PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
		List<TSelfTxn> failList = checkBillService.querySuccess(variables);
		PageInfo<TSelfTxn> pageInfo=new PageInfo<>(failList);
		PageBean pageBean=new PageBean(new Long(pageInfo.getTotal()).intValue(), failList);
		return pageBean;
	}
	
	
	@ResponseBody
	@RequestMapping("querySuccessBymerch")
	public PageBean querySuccessBymerch(HttpServletRequest request,String date,String page, String rows) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		String merchno=infoByToken.getUserId().toString();
		if (!StringUtils.isBlank(date)) {
			date=date.replace("-", "");
		}else {
			date=DateUtil.getCurrentDate();
		}
		PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
		List<TSelfTxn> failList = checkBillService.queryCheckFileInfo(merchno,date);
		PageInfo<TSelfTxn> pageInfo=new PageInfo<>(failList);
		PageBean pageBean=new PageBean(new Long(pageInfo.getTotal()).intValue(), failList);
		return pageBean;
	}
	
	
	/**
	 * 开始执行核对
	 * 
	 * @author: zhangshd
	 * @param filestartid
	 * @return Object
	 * @date: 2017年3月1日 下午4:56:23
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("startCheckFile")
	public ResultBean startCheckFile(String filestartid) {
		return checkBillService.checkBill(filestartid);
	}
	
	
	
	/**
	 * 拒绝处理意见
	 * @author: zhangshd
	 * @param filestartid
	 * @return Object
	 * @date: 2017年3月1日 下午4:56:23
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("dealmistake")
	public ResultBean dealmistake(String result,String status,String iid,HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		return checkBillService.dealmistake(result,status,iid,infoByToken.getUserId().longValue());
	}
	
	
	@ResponseBody
	@RequestMapping("dealReasult")
	public PageBean dealReasult(String proid) {
		List<Map<String, Object>> list =new ArrayList<>();
		list.add(checkBillService.dealReasult(proid));
		PageBean pageBean=new PageBean(0, list);
		return pageBean;
	}
	
}
