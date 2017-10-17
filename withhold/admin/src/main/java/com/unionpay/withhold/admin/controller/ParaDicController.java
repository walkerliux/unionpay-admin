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
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.pojo.TRspmsg;
import com.unionpay.withhold.admin.service.ParaDicService;
import com.unionpay.withhold.admin.utils.EnumUtils;


@Controller
@RequestMapping("/para")
public class ParaDicController {
	@Autowired
	private ParaDicService paraDicService;
	
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView result=new ModelAndView("/baseData/paraDic_manager");
        return result;
    }
	/**
	 * 查询
	 * s
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public PageBean query(TParaDic paraDic,int page,int rows){
		
		PageBean resultBean =paraDicService.findParaPage(paraDic,page, rows);
		
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
		List<?> list = new ArrayList<>();
		
		return list;
	}
	/**
	 * 显示所有父级
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/showParents")
	public List<?> showParents(){
		//List<?> list = new ArrayList<>();
		
		return paraDicService.getParents();
	}
	/**
	 * 通过Id获取paradic
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public TParaDic getSingleById(Long tid){
		TParaDic paraDic=paraDicService.getSingleById(tid);
		return paraDic;
	}
	/**
	 * 修改
	 * 
	 * @return
	 */
	@ResponseBody
   @RequestMapping("/update")
	public List<?> update(TParaDic paraDic) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			paraDic.setStatus(new Short("0"));
			paraDicService.updateTParaDic(paraDic);
			
			list.add("更新成功");
		} catch (Exception e) {
			list.add("更新失败");
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 新增paradic
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public List<?> save(TParaDic paraDic) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			paraDic.setStatus(new Short("0"));
			paraDicService.saveTParaDic(paraDic);
			list.add("保存成功");
		} catch (Exception e) {
			list.add("保存失败");
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 注销paradic
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/delete")
	public String delete(Long tid){
		TParaDic paraDic=paraDicService.getSingleById(tid);
		paraDic.setStatus(new Short("1"));
		
		try {
			paraDicService.updateTParaDic(paraDic);
			
			return "true";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "false";
	}

}
