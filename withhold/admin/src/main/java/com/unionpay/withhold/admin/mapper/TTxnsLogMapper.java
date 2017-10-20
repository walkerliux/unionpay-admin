package com.unionpay.withhold.admin.mapper;

import com.unionpay.withhold.admin.pojo.TTxnsLog;
import com.unionpay.withhold.admin.pojo.TTxnsLogExample;
import java.util.List;


public interface TTxnsLogMapper {
    int countByExample(TTxnsLogExample example);
    List<TTxnsLog> selectByExample(TTxnsLogExample example);
    TTxnsLog selectByPrimaryKey(String txnseqno);
    TTxnsLog selectHistoryByPrimaryKey(String txnseqno);
 
    List<TTxnsLog> selectByPageExample(TTxnsLogExample tTxnsLogExample);
	int countByMyExample(TTxnsLogExample tTxnsLogExample);
	int countHistoryByMyExample(TTxnsLogExample tTxnsLogExample);
	List<TTxnsLog> selectHistoryByPageExample(TTxnsLogExample tTxnsLogExample);
	
	//按商户号统计
	List<TTxnsLog> selectByMerchId(TTxnsLogExample tTxnsLogExample);
	//按渠道号统计
	List<TTxnsLog> selectByCoopId(TTxnsLogExample tTxnsLogExample);
	//按通道统计
	List<TTxnsLog> selectByChnlId(TTxnsLogExample tTxnsLogExample);
	
	//countByMerchIdExample按商户号统计总记录数  不加分页
	List<TTxnsLog> countByMerchIdExample(TTxnsLogExample tTxnsLogExample);
	//countByMerchIdExample按通道号统计总记录数  不加分页
	List<TTxnsLog> countByChnlIdExample(TTxnsLogExample tTxnsLogExample);
	//countByMerchIdExample按渠道号统计总记录数  不加分页
	List<TTxnsLog> countByCoopIdExample(TTxnsLogExample tTxnsLogExample);

	
}