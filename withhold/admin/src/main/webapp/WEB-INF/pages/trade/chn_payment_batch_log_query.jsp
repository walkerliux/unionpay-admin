<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="../../top.jsp"></jsp:include>
<body>
	<style type="text/css">
table tr td {
	height: 25px
}


table tr td select {
	height: 20px
}

#continer table tr td {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}

#continer table tr td input {
	width:250px;
}

#continer table tr td.head-title {
	background-color: #F0F8FF;
	font-weight: bold;
}

#continer table tr td.head-guide {
	background-color: #F0FFFF;
	font-weight: bold;
}

#continer table tr td font.current-step {
	color: #EE4000;
}
</style>
	<div style="margin: 5px; border:" >
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 100px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">批次号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="batchno" id="batchnos"  /></td>
						<td align="right" width="10%">发起方代码</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="transmitleg" id="transmitlegs"  /></td>
							
							<td align="right" width="10%"></td>
						<td align="left" style="padding-left: 5px" width="15%"></td>
						<!-- <td align="right" width="10%">接收方代码</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="receiver" id="receivers"  /></td> -->
					</tr>
					<tr>
						<td align="right" width="10%">起止时间</td>
						<td colspan="2" style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:true" name="stime"></input> 至<input
							id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:true"
							name="etime"></input></td>
						<td align="right" width="10%"></td>
						<td align="left" style="padding-left: 5px" width="15%"></td>	
						<td align="left" ><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a></td></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
		<div style="margin-top: 5px">
			<table id="detailInfo"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" id="continer"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo"
					border="1">
					<tr>
						<td colspan="4" class="head-title">报文头信息</td>
					</tr>
					<tr>
						<td width="15%">报文类型</td><td width="35%" id="msgtype"></td>					
						<td width="15%">服务类型</td><td width="35%" id="servicetype"></td>
					</tr>
					<tr>						
						<td>发起方代码</td><td id="transmitleg"></td>
						<td>接收方代码</td><td id="receiver"></td>
					</tr>
					<tr>
						<td>本地日期</td><td id="transdate"></td>
						<td>本地时间</td><td id="transtime"></td>
					</tr>
					<tr>						
						<td>操作员代码</td><td id="operatorcode"></td>
						<td>原始批次号</td><td id="origbatchno"></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">批次信息</td>
					</tr>
					<tr>
						<td>批次号</td><td id="batchno"></td>
						<td>总笔数</td><td id="totalqty"></td>
					</tr>
					<tr>						
						<td>总金额（元）</td><td id="totalamt"></td>
						<td>批次完成时间</td><td id="rspdate"></td>
						
					</tr>
					<tr>
						<td>应答码</td><td id="rspcode"></td>					
						<td>应答信息</td><td id="respmsg"></td>
					</tr>
					
				</table>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w2" class="easyui-window" closed="true" title="My Window"
		 style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" id="continer" id="continer"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="detailinfo"
					border="1">
					<tr>
						<td colspan="4" class="head-title">业务报文信息</td>
					</tr>
					<tr>
						<td width="15%">批次号</td><td width="35%"><span id="BATCHNO"></span></td>					
						<td width="15%">明细标识号</td><td width="35%"><span id="TXID"></span></td>
					</tr>
					<tr>						
						<td>收费单位代码</td><td><span id="CHARGINGUNIT"></span></td>
						<td>提交日期</td><td><span id="TRANSDATE"></span></td>
					</tr>
					<tr>						
						<td>收款账户名称</td><td><span id="CREDITORNAME"></span></td>
						<td>收款人账号</td><td><span id="CREDITORACCOUNTNO"></span></td>
					</tr>
					<tr>
						<td>付款人账号</td><td><span id="DEBTORACCOUNTNO"></span></td>
						<td>收款行行号</td><td><span id="CREDITORBRANCHCODE"></span></td>
						<!-- <td>付款行行号</td><td><span id="DEBTORBRANCHCODE"></span></td> -->
						<!-- <td>付款人名称</td><td><span id="DEBTORNAME"></span></td> -->
					</tr>
					
					<tr>
						<td>付费约定协议号</td><td><span id="PAYMENTNO"></span></td>
						<td>支付工具类型</td><td><span id="PAYMENTTOOLTYPE"></span></td>	
					</tr>
					<tr>
						<td>金额</td><td><span id="AMOUNT"></span></td>
						<td>货币</td><td><span id="CURRENCYSYMBOL"></span></td>
					</tr>
					<!-- <tr>						
						<td>计量对象号码</td><td><span id="METEROBJNUMBER"></span></td>
						<td>授权号</td><td><span id="AUTHNUMBER"></span></td>
					</tr> -->
					<tr>
						<td>附言</td><td colspan="3"><span id="POSTSCRIPT"></span></td>
					</tr>
					<tr>
						<td>凭证号码</td><td><span id="VOUCHERNUMBER"></span></td>				
						<td>附加域子类</td><td><span id="ADDITIONAL"></span></td>
					</tr>
					<tr>
						<td>附加域长度</td><td><span id="ADDITIONALLEN"></span></td>					
						<td>消息鉴别码</td><td><span id="MSGAUTHCODE"></span></td>
					</tr>
					<tr>
						<td>附加域内容</td><td colspan="3"><span id="ADDINFO"></span></td>					
						
					</tr>
					<tr>
						<td colspan="4" class="head-title">应答报文信息</td>
					</tr>
					<tr>
						<td>应答报文标识号</td><td><span id="RSPMSGID"></span></td>
						<td>应答码</td><td><span id="RSPSTATUS"></span></td>	
					</tr>
					<tr>
						<td>拒绝应答码</td><td><span id="RSPREJECTCODE"></span></td>
						<td>业务拒绝信息</td><td><span id="RSPREJECTINFORMATION"></span></td>
					</tr>
					<tr>
						<td>轧差日期</td><td><span id="NETTINGDATE"></span></td>		
						<td>业务应答时间</td><td><span id="RSPDATE"></span></td>
					</tr>
					<tr>
						<td>交易流水号</td><td><span id="TXNSEQNO"></span></td>
						<td></td><td></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
</body>

<script>
	var width = $("#continer").width();
	$(function() {
		$('#test')
				.datagrid(
						{
							title : '批量代付渠道批次列表',
							iconCls : 'icon-save',
							height : 400,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getChnPaymentBatchLogByPage',
							remoteSort : false,
							idField : 'MSGID',
							columns : [ [
								{field:'BATCHNO',title:'批次号',width:130,align:'center'},
								{field:'TRANSMITLEG',title:'发起方代码',width:90,align:'center'},
								{field:'MSGTYPE',title:'报文类型',width:90,align:'center'},
								{field:'SERVICETYPE',title:'服务类型',width:90,align:'center'},
								
								/* {field:'RECEIVER',title:'接收方代码',width:120,align:'center'}, */
								{
									field : 'TRANSDATE',
									title : '本地日期 ',
									width : 90,
									align : 'center',
									formatter : function(value, rec) {
										return changeDate(rec.TRANSDATE);
									}
								},
								{
									field : 'TRANSTIME',
									title : '本地时间',
									width : 90,
									align : 'center',
									formatter : function(value, rec) {
										return changeTime(rec.TRANSTIME);
									}
								},
								{field:'TOTALQTY',title:'总笔数',width:120,align:'center'},
								{field:'TOTALAMT',title:'总金额（元）',width:120,align:'center',
									formatter : function(value, rec) {
										return fenToYuan(rec.TOTALAMT);
									}
								},
								{field:'RSPDATE',title:'批次完成时间',width:120,align:'center',
									formatter : function(value, rec) {
										return changeDateTime(rec.RSPDATE);
									}
									
								},
								{field:'ID',title:'操作',width:120,align:'center',
									formatter:function(value,rec){
										return '<a href="javascript:queryDetail(\''+rec.BATCHNO+'\')" style="color:blue;margin-left:10px">详细信息</a>';
									}
								}
							] ],
							pagination : true,
							rownumbers : true,
							onClickRow: function (index, row) { 
								var batchNo= row["BATCHNO"];
								$('#detailInfo').datagrid({
									title:'批量代付渠道批次明细列表',
									iconCls:'icon-save',
									height:400,
									singleSelect:true,
									nowrap: false,
									striped: true,
									url:'trade/getChnPaymentDetaByBatchNo?batchno='+batchNo,	
									remoteSort: false,
									idField:'TID',
									columns:[
									[
										{field:'BATCHNO',title:'批次号',width:130,align:'center'},
										{field:'TXID',title:'明细标识号',width:120,align:'center'},
										{field:'CHARGINGUNIT',title:'收费单位代码',width:120,align:'center'},
										{field:'TRANSDATE',title:'提交日期',width:120,align:'center',
											formatter : function(value, rec) {
												return changeDate(rec.TRANSDATE);
											}	
										},
										{field:'DEBTORACCOUNTNO',title:'付款账号',width:140,align:'center'},
										//{field:'CREDITORBRANCHCODE',title:'收款银行行号',width:120,align:'center'},
										{field:'CREDITORNAME',title:'收款账户名称',width:120,align:'center'},
										{field:'CREDITORACCOUNTNO',title:'收款账号',width:140,align:'center'},
										/* {field:'CURRENCYSYMBOL',title:'货币类型',width:120,align:'center',
											formatter : function(value, rec) {
												if (rec.CURRENCYSYMBOL == "RMB") {
													return "人民币";
												} 
											}	
										}, */
										{field:'AMOUNT',title:'金额（元）',width:120,align:'center',
											formatter : function(value, rec) {
												return yuanToFen(rec.AMOUNT);
											}
										},
										/* {field:'PAYMENTTOOLTYPE',title:'支付工具类型',width:120,align:'center',
											formatter : function(value, rec) {
												if (rec.PAYMENTTOOLTYPE == "0") {
													return "未知";
												} 
												if (rec.PAYMENTTOOLTYPE == "1") {
													return "活期储蓄存折";
												} 
												if (rec.PAYMENTTOOLTYPE == "2") {
													return "对公账户";
												} 
												if (rec.PAYMENTTOOLTYPE == "3") {
													return "借记卡";
												} 
												if (rec.PAYMENTTOOLTYPE == "4") {
													return "信用卡（贷记卡）";
												} 
												if (rec.PAYMENTTOOLTYPE == "5") {
													return "活期存款账户";
												} 
											}	
										},
										{field:'POSTSCRIPT',title:'附言',width:120,align:'center'},
										{field:'RSPSTATUS',title:'应答状态',width:120,align:'center'},
										{field:'RSPREJECTCODE',title:'应答码',width:120,align:'center'},
										{field:'RSPREJECTINFORMATION',title:'业务拒绝信息',width:120,align:'center'},
										{field:'RSPDATE',title:'批次完成时间',width:120,align:'center',
											formatter : function(value, rec) {
												return changeDateTime(rec.RSPDATE);
											}
										},
										{field:'NETTINGDATE',title:'轧差日期',width:120,align:'center',
											formatter : function(value, rec) {
												return changeDate(rec.NETTINGDATE);
											}
										}, */
										{field:'RSPDATE',title:'批次完成时间',width:120,align:'center',
											formatter : function(value, rec) {
												return changeDateTime(rec.RSPDATE);
											}
										},
										{field:'NETTINGDATE',title:'轧差日期',width:120,align:'center',
											formatter : function(value, rec) {
												return changeDate(rec.NETTINGDATE);
											}
										}, 
										{field:'TXNSEQNO',title:'交易流水号',width:120,align:'center'},
										{field:'ID',title:'操作',width:120,align:'center',
											formatter:function(value,rec){
												return '<a href="javascript:showBatchDetail(\''+rec.BATCHNO+'\')" style="color:blue;margin-left:10px">详细信息</a>';
											}
										}
									]],
									pagination:true,
									rownumbers:true,
								})
							}

						});

	});

	function search() {
		var data = {
				"batchno" : $('#batchnos').val(),
				"transmitleg" : $('#transmitlegs').val(),
				"receiver" : $('#receivers').val(),
				"stime" : $('#stime').datebox('getValue'),
				"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}
	
	function resize(){
		$('#theForm :input').val('');
	}
	
	function queryDetail(batchNo){
		$("#batchno").html("");
		$("#msgtype").html("");
		$("#servicetype").html("");
		$("#transmitleg").html("");
		$("#receiver").html("");
		$("#transdate").html("");
		$("#transtime").html("");
		$("#totalqty").html("");
		$("#totalamt").html("");
		$("#rsprejectcode").html("");
		$("#respmsg").html("");
		$("#rspdate").html("");
		$("#operatorcode").html("");
		$("#origbatchno").html("");
		$("#notes").html("");
		$("#remarks").html("");
		   
		$('#w').window({
			title: '详细信息',
			top:90,
			left:100,
			width:900,
			modal: true,
			minimizable:false,
			collapsible:false,
			maximizable:false,
			shadow: false,
			closed: false,
			height: 350
		});
	
		var rows = $('#test').datagrid('getSelected');
		$("#batchno").html(rows["BATCHNO"]);
		$("#msgtype").html(rows["MSGTYPE"]);
		$("#servicetype").html(rows["SERVICETYPE"]);
		$("#transmitleg").html(rows["TRANSMITLEG"]);
		$("#receiver").html(rows["RECEIVER"]);
		$("#transdate").html(changeDate(rows["TRANSDATE"]));
		$("#transtime").html(changeTime(rows["TRANSTIME"]));
		$("#totalqty").html(rows["TOTALQTY"]);
		$("#totalamt").html(rows["TOTALAMT"]/100);
		$("#rsprejectcode").html(rows["RSPREJECTCODE"]);
		$("#respmsg").html(rows["RESPMSG"]);
		$("#rspdate").html(changeDateTime(rows["RSPDATE"]));
		$("#operatorcode").html(rows["OPERATORCODE"]);
		$("#origbatchno").html(rows["ORIGBATCHNO"]);
		$("#notes").html(rows["NOTES"]);
		$("#remarks").html(rows["REMARKS"]);
	}
	
	// 格式化日期时间
	function changeDateTime(value){
		var dateString = value;
		if(dateString==null){
			return "";
		}else{
			year=dateString.substring(0,4);//0123
			month=dateString.substring(4,6);//45
			day=dateString.substring(6,8);//67
			hour=dateString.substring(8,10);//89
			minte=dateString.substring(10,12);//10 11
			s=dateString.substring(12,14);// 11 12
			return year+"-"+month+"-"+day+" " + hour +":"+minte+":"+s;
		}
	}
	// 格式化日期
	function changeDate(value){
		var dateString = value;
		if(dateString==null){
			return "";
		}else{
			year=dateString.substring(0,4);//0123
			month=dateString.substring(4,6);//45
			day=dateString.substring(6,8);//67
			return year+"-"+month+"-"+day;
		}
	}
	// 格式化时间
	function changeTime(value){
		var dateString = value;
		if(dateString==null){
			return "";
		}else{
			hour=dateString.substring(0,2);
			minte=dateString.substring(2,4);
			s=dateString.substring(4,6);
			return hour +":"+minte+":"+s;
		}
	}
	// 解析状态
	function analysisStatus(value){
		if (value == "PR05") {
			return "已成功";
		} 
		if (value == "PR09") {
			return "已拒绝";
		} 
		if (value == "PR32") {
			return "逾期退回";
		} 
	}
	// 转换金额格式：分-->元
	function yuanToFen(value){
		return value/100;
	}
	function fenToYuan(value){
		var str = (value/100).toFixed(2) + '';
		var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
		var dot = str.substring(str.length,str.indexOf("."))
		var ret = intSum + dot;
		return ret;
	}
	function closeAdd(){
		$('#w').window('close');
		$('#w2').window('close');
	}
	
	function showBatchDetail(){
		$('#w2').window({
			title: '代收渠道交易详细信息',
			top:90,
			left:100,
			width:900,
			modal: true,
			minimizable:false,
			collapsible:false,
			maximizable:false,
			shadow: false,
			closed: false,
			height: 560
		});
		$("#detailinfo span").html("");
		var rows = $('#detailInfo').datagrid('getSelected');
		$("#BATCHNO").html(rows["BATCHNO"]);	
		$("#CHARGINGUNIT").html(rows["CHARGINGUNIT"]);	
		$("#TRANSDATE").html(changeDate(rows["TRANSDATE"]));	
		$("#TXID").html(rows["TXID"]);	
		$("#DEBTORNAME").html(rows["DEBTORNAME"]);	
		$("#DEBTORACCOUNTNO").html(rows["DEBTORACCOUNTNO"]);	
		$("#DEBTORBRANCHCODE").html(rows["DEBTORBRANCHCODE"]);	
		$("#CREDITORBRANCHCODE").html(rows["CREDITORBRANCHCODE"]);	
		$("#CREDITORACCOUNTNO").html(rows["CREDITORACCOUNTNO"]);	
		//$("#CURRENCYSYMBOL").html(rows["CURRENCYSYMBOL"]);	
		$("#CURRENCYSYMBOL").html("人民币");	
		$("#AMOUNT").html(fenToYuan(rows["AMOUNT"]));	
		$("#METEROBJNUMBER").html(rows["METEROBJNUMBER"]);	
		$("#AUTHNUMBER").html(rows["AUTHNUMBER"]);	
		//$("#PAYMENTTOOLTYPE").html(rows["PAYMENTTOOLTYPE"]);	
		$("#PAYMENTTOOLTYPE").html("借记卡");
		
		$("#VOUCHERNUMBER").html(rows["VOUCHERNUMBER"]);	
		$("#POSTSCRIPT").html(rows["POSTSCRIPT"]);	
		$("#ADDITIONAL").html(rows["ADDITIONAL"]);	
		$("#ADDITIONALLEN").html(rows["ADDITIONALLEN"]);	
		$("#MSGAUTHCODE").html(rows["MSGAUTHCODE"]);	
		$("#ADDINFO").html(rows["ADDINFO"]);	
		$("#RSPMSGID").html(rows["RSPMSGID"]);	
		$("#RSPSTATUS").html(rows["RSPSTATUS"]);	
		$("#RSPREJECTCODE").html(rows["RSPREJECTCODE"]);	
		$("#RSPREJECTINFORMATION").html(rows["RSPREJECTINFORMATION"]);	
		$("#RSPDATE").html(rows["RSPDATE"]);	
		$("#NETTINGDATE").html(rows["NETTINGDATE"]);	
		$("#TXNSEQNO").html(rows["TXNSEQNO"]);
		$("#CREDITORNAME").html(rows["CREDITORNAME"]);	
		$("#PAYMENTNO").html(rows["PAYMENTNO"]);	
		


	}
</script>
</html>
