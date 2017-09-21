package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.admin.mapper.TFunctionMapper;
import com.unionpay.withhold.admin.mapper.TUserFunctMapper;
import com.unionpay.withhold.admin.pojo.TFunction;
import com.unionpay.withhold.admin.pojo.TFunctionExample;
import com.unionpay.withhold.admin.pojo.TFunctionExample.Criteria;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.pojo.TUserFunct;
import com.unionpay.withhold.admin.pojo.TUserFunctExample;
import com.unionpay.withhold.admin.service.FunctionService;
@Service
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private TFunctionMapper tFunctionMapper;
	@Autowired
	private TUserFunctMapper tUserFunctMapper;
	@Override
	public List<TFunction> findFunction() {
		List<TFunction> all = tFunctionMapper.selectAll();
		return all;
	}

	@Override
	public List<TFunction> findLoginFuntion(TUser loginUser) {
		//创建一个存放返回值得list
		List<TFunction> result = new ArrayList<TFunction>();
		//得到user-funct中间表
		Integer userId = loginUser.getUserId();
		TUserFunctExample exampleUF = new TUserFunctExample();
		com.unionpay.withhold.admin.pojo.TUserFunctExample.Criteria fuCriteria = exampleUF.createCriteria();
		fuCriteria.andUserIdEqualTo((long)userId);
		List<TUserFunct> list = tUserFunctMapper.selectByExample(exampleUF);
		
		if(list!=null&&list.size()>0){
			//中间表
			//定义一个临时变量存放前一次循环所得的ParentId
			String index=null;
			for (TUserFunct tUserFunct : list) {
				Long functId = tUserFunct.getFunctId();
				//得到父TFunction
				TFunction parent = tFunctionMapper.selectByPrimaryKey(functId);
				if(StringUtils.isEmpty(parent.getParentId())){
					result.add(parent);
					continue;
				}
				if(parent.getParentId().equals(index)){
					continue;
				}
			    //查子TFunction
			    TFunctionExample tFunctionExample = new TFunctionExample();
			    Criteria tFcriteria = tFunctionExample.createCriteria();
			    tFcriteria.andParentIdEqualTo(parent.getParentId());
			    //得到子TFunctions
			    List<TFunction> sons = tFunctionMapper.selectByExample(tFunctionExample);			
			    if(sons!=null&&sons.size()>0){
				   for (TFunction son : sons) {
					 result.add(son);
				 }
				   index=parent.getParentId();
			 }
		  }
		}
		return result;
	}

}
