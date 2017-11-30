package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TParaDic;

public interface ParaDicService {

	PageBean findParaPage(TParaDic paraDic, int page, int rows);

	void saveTParaDic(TParaDic paraDic);

	void updateTParaDic(TParaDic paraDic);

	TParaDic getSingleById(Long tid);

	List<TParaDic> getParents();

	
	/**
	 * 根据父节点的paraCode查询子类的列表信息
	 * @param paraCode
	 * @return
	 * @author lianhai
	 * @date 2017年10月16日 15:54:45
	 */
	List<TParaDic> selectParaDicByParentCode(String paraCode);

	TParaDic selectByTid(Long parentId);

	List<TParaDic> selectByTypeAndStatus(String type,Short Status);
}
