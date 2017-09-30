package com.unionpay.withhold.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;







import com.unionpay.withhold.admin.Bean.ChnlType;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TRspmsg;
import com.unionpay.withhold.admin.service.RspMsgService;
import com.unionpay.withhold.admin.utils.EnumUtils;


@Controller
@RequestMapping("/rsp")
public class RspMsgController {
	@Autowired
	private RspMsgService rspMsgService;
	
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/baseData/rsp_manager");
        return result;
    }
	/**
	 * 查询
	 * s
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public PageBean query(TRspmsg rspmsg,int page,int rows){
		
		PageBean resultBean = rspMsgService.findRspByPage(rspmsg,page, rows);
		
		return resultBean;
		
	}
	
	/**
	 * 显示所有类型
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/showTypes")
	public List<?> showTypes(){
		
		List<ChnlType> list = EnumUtils.getType();
		return list;
	}
	
	/**
	 * 通过Id获取角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public TRspmsg getSingleById(Long rspid){
		TRspmsg rspmsg =rspMsgService.getSingleById(rspid);
		return rspmsg;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	@ResponseBody
   @RequestMapping("/update")
	public List<?> update(HttpServletRequest request,TRspmsg rspmsg) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			rspMsgService.updateTRspmsg(rspmsg);
			
			list.add("更新成功");
		} catch (Exception e) {
			list.add("更新失败");
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 新增用户信息
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public List<?> save(HttpServletRequest request,TRspmsg rspmsg) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			rspMsgService.saveTRspmsg(rspmsg);
			list.add("保存成功");
		} catch (Exception e) {
			list.add("保存失败");
			e.printStackTrace();
		}
		
		return list;
	}
}
