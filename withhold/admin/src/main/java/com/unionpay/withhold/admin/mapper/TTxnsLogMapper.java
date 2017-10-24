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
	
	//按商户号统计总记录数  不加分页
	List<TTxnsLog> countByMerchIdExample(TTxnsLogExample tTxnsLogExample);
	//按通道号统计总记录数  不加分页
	List<TTxnsLog> countByChnlIdExample(TTxnsLogExample tTxnsLogExample);
	//按渠道号统计总记录数  不加分页
	List<TTxnsLog> countByCoopIdExample(TTxnsLogExample tTxnsLogExample);
	//根据商户号查询统计后的详情
	List<TTxnsLog> selectInfoByMernoId(TTxnsLogExample tTxnsLogExample);
	//根据渠道号查询统计后的详情
	List<TTxnsLog> selectInfoByCoopId(TTxnsLogExample tTxnsLogExample);
	//根据通道号查询统计后的详情
	List<TTxnsLog> selectInfoByChnlId(TTxnsLogExample tTxnsLogExample);
}