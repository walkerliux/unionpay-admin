<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<jsp:include page="../../../top.jsp"></jsp:include>
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
		<div id="p" class="easyui-panel" title="查询条件" style="height: 148px; padding: 10px; background: #fafafa;" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">商户号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input name="merchno" id="merchno_" /></td>
						<td align="right" width="10%">交易卡号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input name="pan" id="pan_" /></td>
					</tr>
					
					<tr>
						<td align="right" width="10%">商户订单号</td>
						<td align="left" style="padding-left: 5px" width="25%">
						<input name="orderno" id="orderno_" /></td>
						<td align="right" width="10%">交易序列号</td>
						<td align="left" style="padding-left: 5px" width="25%">
						<input name="txnseqno" id="txnseqno_" /></td>
					</tr>
					<tr>
					
						<td align="right" width="10%">起止时间</td>
						<td colspan="2" style="padding-left: 5px">
						<input id="stime" type="text" style="width: 120PX" class="easyui-datetimebox" data-options="showSeconds:true" name="stime"></input> 
						至<input id=etime type="text" style="width: 120PX" class="easyui-datetimebox" data-options="showSeconds:true" name="etime"></input></td>
						<td align="right" width="10%"></td>
						<td align="left" style="padding-left: 5px" width="15%"></td>
						<td align="left"><a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"  style="width: 600px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center" id="continer">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo" border="1">
					
					<tr>
						<td colspan="4" class="head-title">基本信息</td>
					</tr>
					<tr>
						<td width="15%">渠道代码</td ><td width="35%" id="cacode"></td>
						<td width="15%">渠道名称</td><td width="35%" id="caname"></td>
					</tr>
					<tr>
						<td width="15%">通道代码</td><td width="35%" id="chnlcode"></td>
						<td width="15%">通道名称</td><td width="35%" id="chnlname"></td>
					</tr>
					<tr>
						<td width="15%">商户号</td><td width="35%" id="merchno"></td>
						<td width="15%">商户名称</td><td width="35%" id="merchname"></td>
					</tr>
					<tr>
						<td>卡组织代码</td><td id="cardIssuerCode"></td>
						<td>卡组织名称</td><td id="cardIssuerName"></td>
					</tr>
					
					<tr>
						<td>风控级别</td><td id="tradeRiskLevel"></td>
						<td>风控策略描述</td><td id="strategy"></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">交易信息</td>
					</tr>
					 <tr>
						<td width="15%">交易序列号</td><td width="35%" id="txnseqno"></td>
						<td width="15%">交易订单号</td><td width="35%" id="orderno"></td>
					</tr> 
					<tr>
						<td width="15%">交易金额（元）</td><td width="35%" id="amount"></td>
						<td width="15%">交易卡号</td><td width="35%" id="pan"></td>
					</tr>
					<tr>
						<td>应答信息</td><td id="resinfo"></td>
						<td>应答码</td><td id="rescode"></td>
					</tr>
					<tr>
						<td>受理时间</td><td id="acqdatetime"></td>
						
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
							title : '实时代收渠道流水信息列表',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'riskTrade/getRiskRradeLogByPage',
							remoteSort : false,
							idField : 'ORGAN_ID',
							columns : [ [

	  								{
										field : 'txnseqno',
										title : '交易序列号',
										width : 120,
										align : 'center'
									},
									{
										field : 'orderno',
										title : '商户订单号',
										width : 150,
										align : 'center'
									},
									{
										field : 'merchno',
										title : '商户号',
										width : 150,
										align : 'center'
									},
									{
										field : 'merchname',
										title : '商户名称',
										width : 120,
										align : 'center'
									},
									{
										field : 'amount',
										title : '交易金额',
										width : 120,
										align : 'center',
										formatter:function(value,rec){
											return fenToYuan(rec.amount);
										} 
									},
									{
										field : 'pan',
										title : '交易卡号',
										width : 150,
										align : 'center'
									},
									{
										field : 'acqdatetime',
										title : '受理时间',
										width : 120,
										align : 'center',
									 	formatter:function(value,rec){
										return changeDateTime(rec.acqdatetime);
									} 
									},
									{
										field : 'busitype',
										title : '业务类型',
										width : 150,
										align : 'center'
										/* formatter : function(value, rec) {
											return changeDate(rec.chnlretdate);
										} */
									},
									{
										field : 'strategy',
										title : '风控策略描述',
										width : 120,
										align : 'center'
									},
									{
										field : 'tradeRiskLevel',
										title : '风控级别',
										width : 120,
										align : 'center',
										formatter : function(value, rec) {
											return RiskLevel(rec.tradeRiskLevel);
										}
									},
									{
										field : 'ID',
										title : '操作',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {
											if (rec.tid!= null) {
												return '<a href="javascript:queryDetail(\''
														+ rec.tid
														+ '\')" style="color:blue;margin-left:10px">详细信息</a>';
											} else {
												return '';
											}
										}
									} ] ],
							pagination : true,
							rownumbers : true

						});

	});

	function search() {
		var data = {
			"merchno" : $('#merchno_').val(),
			"pan" : $('#pan_').val(),
			"orderno" : $('#orderno_').val(),
			"txnseqno" : $('#txnseqno_').val(),
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}

	function resize() {
		$('#theForm :input').val('');
	}

	function queryDetail(logseqno) {
		$("#riskTradeType").html("");
		$("#tid").html("");
		$("#txnseqno").html("");
		$("#merchno").html("");
		$("#orderno").html("");
		$("#merchname").html("");
		$("#cacode").html("");
		$("#caname").html("");
		$("#chnlcode").html("");
		$("#chnlname").html("");
		$("#amount").html("");
		$("#pan").html("");
		$("#tradeRiskLevel").html("");
		$("#cardIssuerCode").html("");
		$("#cardIssuerName").html("");
		$("#acqdatetime").html("");
		$("#busicode").html("");
		$("#busitype").html("");
		$("#resinfo").html("");
		$("#rescode").html("");
		$("#strategy").html("");
		
		
		$('#w').window({
			title : '实时代收渠道交易流水详细信息',
			top : 90,
			left : 100,
			width : 1000,
			modal : true,
			minimizable : false,
			collapsible : false,
			maximizable : false,
			shadow : false,
			closed : false,
			height : 380
		});
		var rows = $('#test').datagrid('getSelected');
		$("#riskTradeType").html(rows["riskTradeType"]);
		$("#tid").html(rows["tid"]);
		$("#txnseqno").html(rows["txnseqno"]);
		$("#orderno").html(rows["orderno"]);
		$("#merchno").html(rows["merchno"]);
		$("#merchname").html(rows["merchname"]);
		$("#cacode").html(rows["cacode"]);
		$("#caname").html(rows["caname"]);
		$("#chnlcode").html(rows["chnlcode"]);
		$("#chnlname").html(rows["chnlname"]);
		$("#amount").html(fenToYuan(rows["amount"]));
		$("#pan").html(rows["pan"]);
		/* $("#curyid").html(rows["curyid"]); */
		$("#tradeRiskLevel").html(RiskLevel(rows["tradeRiskLevel"]));
		$("#cardIssuerCode").html(rows["cardIssuerCode"]);
		$("#cardIssuerName").html(rows["cardIssuerName"]);
		$("#acqdatetime").html(changeDateTime(rows["acqdatetime"]));
		$("#busicode").html(rows["busicode"]);
		$("#busitype").html(rows["busitype"]);
		$("#resinfo").html(rows["resinfo"]);
		$("#rescode").html(rows["rescode"]);
		$("#strategy").html(rows["strategy"]);
		
	}

	// 格式化日期时间
	function changeDateTime(value) {
		var dateString = value;
		if (dateString == null) {
			return "";
		} else {
			year = dateString.substring(0, 4);//0123
			month = dateString.substring(4, 6);//45
			day = dateString.substring(6, 8);//67
			hour = dateString.substring(8, 10);//89
			minte = dateString.substring(10, 12);//10 11
			s = dateString.substring(12, 14);// 11 12
			return year + "-" + month + "-" + day + " " + hour + ":" + minte
					+ ":" + s;
		}
	}
	// 格式化日期
	function changeDate(value) {
		var dateString = value;
		if (dateString == null) {
			return "";
		} else {
			year = dateString.substring(0, 4);//0123
			month = dateString.substring(4, 6);//45
			day = dateString.substring(6, 8);//67
			return year + "-" + month + "-" + day;
		}
	}
	// 格式化时间
	function changeTime(value) {
		var dateString = value;
		if (dateString == null) {
			return "";
		} else {
			hour = dateString.substring(0, 2);
			minte = dateString.substring(2, 4);
			s = dateString.substring(4, 6);
			return hour + ":" + minte + ":" + s;
		}
	}
	// 解析状态
	function analysisStatus(value) {
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
	function fenToYuan(value) {
		var str = (value / 100).toFixed(2) + '';
		var intSum = str.substring(0, str.indexOf(".")).replace(
				/\B(?=(?:\d{3})+$)/g, ',');
		var dot = str.substring(str.length, str.indexOf("."))
		var ret = intSum + dot;
		return ret;
	}
	// 解析证件类型
	function certType(value) {
		if (value == "01") {
			return "身份证";
		}
		if (value == "02") {
			return "军官证";
		}
		if (value == "03") {
			return "护照";
		}
		if (value == "04") {
			return "户口簿";
		}
		if (value == "05") {
			return "回乡证";
		}
		if (value == "06") {
			return "其他";
		}
	}
	// 解析卡折标志
	function cardType(value) {
		if (value == "0") {
			return "卡";
		}
		if (value == "1") {
			return "折";
		}
		
	}
	// 解析风控级别
	function RiskLevel(value) {
		if (value == "1") {
			return "提示";
		}
		if (value == "2") {
			return "关注";
		}
		if (value == "3") {
			return "预警";
		}
		if (value == "4") {
			return "警告";
		}
		if (value == "5") {
			return "拒绝";
		}
	}
	
	function closeAdd() {
		$('#w').window('close');
	}
</script>
</html>
