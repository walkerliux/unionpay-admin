package com.unionpay.withhold.admin.service.impl;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.mapper.TMerchChnlMapper;
import com.unionpay.withhold.admin.mapper.TMerchDetaMapper;
import com.unionpay.withhold.admin.pojo.TMerchChnl;
import com.unionpay.withhold.admin.pojo.TMerchChnlWithBLOBs;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.service.MerchChnlService;

@Service
@Transactional
public class MwechChnlServiceImpl implements MerchChnlService {
	@Autowired
	private TMerchChnlMapper merchChnlMapper;
	@Autowired
	private TMerchDetaMapper merchDetaMapper ;

	@Override
	public PageBean queryMerchChnl(TMerchDeta merchDeta,String chnlcode, Integer page, Integer rows) {
		// 查分页数据
				Integer beginRow = (page - 1) * rows;

				List<TMerchChnlWithBLOBs> list = merchChnlMapper.selectChnlWithCondition(merchDeta,chnlcode, beginRow, rows);
				int count = merchChnlMapper.selectCountWithCondition(merchDeta,chnlcode);

				return new PageBean(count, list);
	}
	@Override
	public ResultBean updateMerchDChnl(TMerchChnlWithBLOBs merchChnl) {
		
		//判断商户通道是否已存在
		List<TMerchChnl> chnlcodeList =  merchChnlMapper.selectupdateByMerchno(merchChnl.getMerchno(),merchChnl.getTid());
		for (TMerchChnl tMerchChnl : chnlcodeList) {
			if(tMerchChnl.getChnlcode().equals(merchChnl.getChnlcode())){
				return new ResultBean("", "通道配置重复！");	
			}
		}
		
		//判断商户通道，通道商户号唯一性
		int num = merchChnlMapper.selectCountWithCHO(merchChnl);
		if(num>0){
			return new ResultBean("", "通道的商户通道号重复！");	
		}
		
		int flag = merchChnlMapper.updateByPrimaryKeySelective( merchChnl);
		if (flag > 0) {
			return new ResultBean("操作成功 ！");
		} else {
			return new ResultBean("", "修改失败！");
		}
	}
	@Override
	public TMerchChnlWithBLOBs querydateMerchDChnlById(Integer tid) {
		
		return  merchChnlMapper.selectChnlByPrimaryKey(tid);
	}
	@Override
	public ResultBean addMerchChnl(TMerchChnlWithBLOBs merchChnl) {
		Date now = new Date();
		TMerchChnlWithBLOBs merch =new TMerchChnlWithBLOBs();
//		merch.setMerchno(merchChnl.getMerchno());
//		merch.setMemberName(merchChnl.getMemberName());
		int length = merchChnl.getArdList().size();
		
		int count = merchChnlMapper.selectaddCountWithCondition(merchChnl.getMerchno());
		
		int flag = 0;
		for (int i = count; i <length; i++) {
			merch=merchChnl.getArdList().get(i);
			
			//判断商户通道是否已存在
			List<TMerchChnl> chnlcodeList =  merchChnlMapper.selectByMerchno(merchChnl.getMerchno());
			for (TMerchChnl tMerchChnl : chnlcodeList) {
				if(tMerchChnl.getChnlcode().equals(merch.getChnlcode())){
					return new ResultBean("", "通道配置重复！");	
				}
			}
			//判断商户通道，通道商户号唯一性
			int num = merchChnlMapper.selectCountWithCHO(merch);
			if(num>0){
				return new ResultBean("", "通道的商户通道号重复！");	
			}
			merch.setMerchno(merchChnl.getMerchno());
			merch.setStatus("00");
			merch.setIntime(now);
			merch.setInuser(merchChnl.getInuser());
			 flag = merchChnlMapper.insertSelective(merch);
		}
		
		if (flag > 0) {
			return new ResultBean("操作成功 ！");
		} else {
			return new ResultBean("", "添加失败！");
		}
	}
	@Override
	public PageBean queryaddMerchChnl(TMerchDeta merchDeta, String chnlcode,
			Integer page, Integer rows) {
		
		Integer beginRow = (page - 1) * rows;

		List<TMerchChnlWithBLOBs> list = merchChnlMapper.selectChnlWithCondition(merchDeta,chnlcode, beginRow, rows);
		int count = merchChnlMapper.selectCountWithCondition(merchDeta,chnlcode);
		
		if(list.size()==0){
			List<TMerchDeta> lists = merchDetaMapper.selectByMemberId(merchDeta.getMemberId());
			return new PageBean(count, lists);
		}
		

		return new PageBean(count, list);
		
	}
	
	
}
