package com.unionpay.withhold.admin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.LoginUser;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TFunction;
import com.unionpay.withhold.admin.pojo.TRole;
import com.unionpay.withhold.admin.pojo.TRoleFunct;


import com.unionpay.withhold.admin.service.FunctionService;
import com.unionpay.withhold.admin.service.OperationLogService;
import com.unionpay.withhold.admin.service.RoleFunctService;
import com.unionpay.withhold.admin.service.RoleService;


@Controller
@RequestMapping("/role")
public class RoleController {

	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private FunctionService functionService;

	@Autowired
	private RoleFunctService roleFunctService;
	@Autowired
	private OperationLogService operationLogService;
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/role/role_manager");
        return result;
    }
	/**
	 * 查询
	 * s
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public PageBean query(TRole role,int page,int rows){
		
		PageBean resultBean = roleService.findRoleByPage(role,page, rows);
		
		return resultBean;
		
	}
	
	/**
	 * 通过Id获取角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public TRole getSingleById(Long roleId){
		TRole role = roleService.getSingleById(roleId);
		return role;
	}
	
	@ResponseBody
    @RequestMapping("/authority")
    public ModelAndView authority(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/role/role_authority");
        return result;
    }
	/**
	 * 新增角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public List<?> save(HttpServletRequest request,TRole role){
		ArrayList<String> returnList = new ArrayList<String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		role.setCreator(loginUser.getUser().getLoginName());
		role.setCreatDate(new Date());
		role.setStatus("00");
		try {
			roleService.saveRole(role);
			operationLogService.addOperationLog(request,"新增角色"+role.getRoleName());
			returnList.add("保存成功");
		} catch (Exception e) {
			returnList.add("保存失败");
			e.printStackTrace();
		}
		
		return returnList;
	}
	/**
	 * 更新角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/update")
	public List<?> update(HttpServletRequest request,TRole role){
		ArrayList<String> returnList = new ArrayList<String>();
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		role.setCreator(loginUser.getUser().getLoginName());
		
		try {
			roleService.updateRole(role);
			operationLogService.addOperationLog(request, "更新角色"+role.getRoleName());
			returnList.add("更新成功");
		} catch (Exception e) {
			returnList.add("更新失败");
			e.printStackTrace();
		}
		
		return returnList;
	}
	/**
	 * 注销角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public List<?> delete(HttpServletRequest request,TRole role){
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		TRole role2 = roleService.getSingleById(role.getRoleId());
			role.setStatus("01");
		    try {
		    	roleService.updateRole(role);
		    	operationLogService.addOperationLog(request, "注销角色"+role2.getRoleName());
				list.add("注销成功");
		    } catch (Exception e) {
		    	list.add("注销失败");
				e.printStackTrace();
			}
		    
		    
		   
			return list;
	}
	
	/**
	 * 点击某一角色后 查出对应角色权限
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
    @RequestMapping("/queryFunction")
    public Map<String, Object> queryFunction(HttpServletRequest request,Long roleId) throws Exception {
		

            List<TFunction> findFunction = (List<TFunction>) functionService.findFunction();
			List<TRoleFunct> roleList =  (List<TRoleFunct>)roleFunctService.findByProperty(roleId);
			List<TFunction> removeList = new ArrayList<TFunction>(); 
			List<TFunction> children = new ArrayList<TFunction>();
			
			for(TFunction function : findFunction){
				if("0".equals(function.getParentId())){//根节点
					if(children != null){
						children=null;
					}
					function.setChildren(new ArrayList<TFunction>());
					children = function.getChildren();
					function.setState("closed");
				}else{//子节点
					
					for(TRoleFunct roleFunct : roleList){
						
						if(roleFunct.getFunctId().equals(function.getFunctId()) ){
							function.setChecked("true");
							function.setText(function.getFunctName());//没有蓝色  设置成可选
						}
						
					}
					children.add(function);//function.getChildren().add(function);
					removeList.add(function);
					
				}
				function.setId(function.getFunctId().toString());
				
				if(function.getText() == null || function.getText().toString().equals("")){
					function.setText(function.getFunctName());
				}
			}
			findFunction.removeAll(removeList);//移除全部的子节点数据
			
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("result",findFunction);
			result.put("roleFunction",roleList);
		
		return result;
    }
    
	/**
     * 修改角色权限（先删除，再重新保存）
     * @return
     */
	@ResponseBody
    @RequestMapping("/saveFunction")
    public String saveFunction(HttpServletRequest request,Long roleId,String userFunc){
    	if(roleId!=null&&!roleId.equals("")){
    		TRole role = roleService.getSingleById(roleId);
			roleFunctService.deleteRoleFunction(roleId);
			String[] funcId = userFunc.split(",");
			if(userFunc == null || userFunc.equals("")){
				return "true";
			}
			List<TRoleFunct> functList = new ArrayList<TRoleFunct>();
			Long num = 1L;
			for(int i = 0;i<funcId.length;i++){
				TRoleFunct model = new TRoleFunct();
				//model.setRoleFunctId(num);
				model.setRoleId(roleId);
				model.setFunctId(Long.valueOf(funcId[i]));
				functList.add(model);
				num++;
			}
			roleFunctService.save(functList);
			operationLogService.addOperationLog(request, "修改角色"+role.getRoleName()+"权限");
			return "true";
    	}
		return "flase";
	}

}
