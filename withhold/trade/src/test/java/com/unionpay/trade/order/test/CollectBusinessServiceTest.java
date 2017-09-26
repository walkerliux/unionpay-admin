package com.unionpay.trade.order.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.unionpay.trade.test.BaseTest;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectQueryBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectQueryBean;
import com.unionpay.withhold.trade.order.service.CollectBusinessService;
import com.unionpay.withhold.utils.DateUtil;

public class CollectBusinessServiceTest extends BaseTest{

	@Autowired
	private CollectBusinessService  collectBusinessService;
	@Test
	public void test() {
		/*实时代扣*/
		//test_realTimeCollect();
		/*批量代扣*/
		//test_batchCollect();
		/*实时代扣查询*/
		//test_query_single_collect();
		/*批量代扣查询*/
		//test_query_batch_collect();
	}
	
	public void test_realTimeCollect() {
		SingleCollectBean singleCollectBean = new SingleCollectBean();
		singleCollectBean.setVersion("1.0.0");
		// 编码方式
		singleCollectBean.setEncoding("UTF-8");
		// 证书ID
		singleCollectBean.setCertId("124");
		// 签名方式
		singleCollectBean.setSignMethod("01");
		// 加密证书ID
		singleCollectBean.setEncryptCertId("0123");
		// 交易类型
		singleCollectBean.setTransType("11");
		// 系统订单号
		singleCollectBean.setOrderId(System.currentTimeMillis()+"");
		// 系统商户号
		singleCollectBean.setMchntCd("200000000001588");
		// 交易要素id
		singleCollectBean.setFactorId("0107");
		// 卡号
		singleCollectBean.setPriAcctId("6228480018543668976");
		// 姓名
		singleCollectBean.setName("郭佳");
		// 手机号
		singleCollectBean.setPhone("18600806796");
		// 身份证号
		singleCollectBean.setIdCard("110105198610064118");
		// 扣款类型
		singleCollectBean.setDkType("1");
		// 交易金额
		singleCollectBean.setTransAt("100");
		// 交易币种
		singleCollectBean.setAtType("156");
		// 订单发送时间
		singleCollectBean.setTransTm(DateUtil.getCurrentDateTime());
		// 后台通知地址
		singleCollectBean.setBackUrl("http://192.168.2.17:8180/notify/NotifyServlet");
		//产品类型
		singleCollectBean.setBizType("000001");
		//交易子类
		singleCollectBean.setTxnSubType("00");
		ResultBean resultBean = collectBusinessService.createSingleCollectOrder(singleCollectBean);
		System.out.println(JSON.toJSONString(resultBean));
	}
	public void test_query_batch_collect() {
		BatchCollectQueryBean batchCollectQueryBean = new BatchCollectQueryBean();
		batchCollectQueryBean.setVersion("1.0.0");;//版本号
		batchCollectQueryBean.setEncoding("UTF-8");;//编码方式
		batchCollectQueryBean.setTxnType("02");;// 交易类型
		batchCollectQueryBean.setTxnSubType("00");;// 交易子类
		batchCollectQueryBean.setBizType("000002");;// 产品类型
		batchCollectQueryBean.setMerId("200000000001588");;// 商户代码
		batchCollectQueryBean.setBatchNo("1505978983775");;// 批次号
		batchCollectQueryBean.setTn("");;// 受理批次号
		batchCollectQueryBean.setTxnDate("20170921");;// 原批次交易日期
		batchCollectQueryBean.setTxnTime(DateUtil.getCurrentDateTime());;// 发送时间
		ResultBean resultBean = collectBusinessService.queryBatchCollectOrder(batchCollectQueryBean);
		System.out.println(JSON.toJSONString(resultBean));
	}
	
	public void test_query_single_collect() {
		SingleCollectQueryBean queryBean = new SingleCollectQueryBean();
		queryBean.setVersion("1.0.0");;//版本号
		queryBean.setEncoding("UTF-8");;//编码方式
		queryBean.setCertId("01234");;//证书ID
		queryBean.setSignature("xxxx");;//签名
		queryBean.setSignMethod("01");;//签名方法
		queryBean.setTransType("00");;//交易类型
		queryBean.setMchntCd("200000000001588");;// 系统商户号
		queryBean.setOrderId("");;// 商户订单号
		//queryBean.setTransTm(DateUtil.getCurrentDateTime());;// 订单发送时间
		queryBean.setTransQueryId("170920158800003600");;// 查询交易流水号
		ResultBean resultBean = collectBusinessService.querySingleCollectOrder(queryBean);
		System.out.println(JSON.toJSONString(resultBean));
	}
	
	public void test_batchCollect() {
		BatchCollectBean batchCollectBean = new BatchCollectBean();
		batchCollectBean.setVersion("1.0.0");// 版本
		batchCollectBean.setEncoding("UTF-8");// 编码方式
		/**交易类型*/
		batchCollectBean.setTxnType("01");
		/**交易子类*/
		batchCollectBean.setTxnSubType("00");
		/**产品类型*/
		batchCollectBean.setBizType("000002");
		batchCollectBean.setCertId("123456");
		batchCollectBean.setMerId("200000000001588");// 商户代码
		batchCollectBean.setBackUrl("http://192.168.2.17:8180/notify/NotifyServlet");// 通知地址
		batchCollectBean.setBatchNo(System.currentTimeMillis()+"");// 批次号
		// 交易要素id
		batchCollectBean.setFactorId("0107");
		batchCollectBean.setTxnTime(DateUtil.getCurrentDateTime());// 订单发送时间
		batchCollectBean.setTotalQty("5");// 总笔数
		batchCollectBean.setTotalAmt("500");// 总金额
		batchCollectBean.setReserved("");// 保留域
		
		List<BatchCollectDetaBean> detaList = new ArrayList<BatchCollectDetaBean>();
		for(int i = 0;i<5;i++) {
			BatchCollectDetaBean detaBean = new BatchCollectDetaBean();
			detaBean.setOrderId(System.currentTimeMillis()+""+random());
			detaBean.setCurrencyCode("156");
			detaBean.setAmt("100");
			detaBean.setCardNo("6228480018543668976");
			detaBean.setCardType("1");
			detaBean.setCustomerNm("测试账户");
			detaBean.setCertifTp("01");
			detaBean.setCertifId("110105198610064118");
			detaBean.setPhoneNo("18600806796");
			detaBean.setCvn2("");
			detaBean.setExpired("");
			detaList.add(detaBean);
		}
		batchCollectBean.setDetaList(detaList);
		
		ResultBean resultBean = collectBusinessService.createBatchCollectOrder(batchCollectBean);
		System.out.println(JSON.toJSONString(resultBean));
	}
	public int  random(){
		int max=999;
        int min=0;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
	}
}
