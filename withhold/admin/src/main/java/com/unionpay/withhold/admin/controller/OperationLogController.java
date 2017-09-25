package com.unionpay.withhold.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;

import com.unionpay.withhold.admin.service.OperationLogService;

@Controller
@RequestMapping("/log")
public class OperationLogController {
	@Autowired
	private OperationLogService operationLogService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 小写的mm表示的是分钟
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/log/log_manager");
        return result;
    }
	/**
	 * 查询
	 * s
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
    @RequestMapping("/query")
	public PageBean query(String userId,String userName,String beginTime,String endTime,int page,int rows) throws ParseException{
		
		if (beginTime!=null&&!"".equals(beginTime)&&endTime!=null&&!"".equals(endTime)) {
			Date beginDate = sdf.parse(beginTime);
			Date endDate = sdf.parse(endTime);
			PageBean resultBean = operationLogService.findLogByPage( userId, userName, beginDate,endDate,page, rows);
			return resultBean;
		}
		
			
		
		
		PageBean resultBean = operationLogService.findLogByPage( userId, userName, null,null,page, rows);
		
		return resultBean;
		
	}
	
}
