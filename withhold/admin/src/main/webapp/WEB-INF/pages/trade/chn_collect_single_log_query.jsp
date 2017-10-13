<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
		<div id="p" class="easyui-panel" title="查询条件" style="height: 148px; padding: 10px; background: #fafafa;" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">商户号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input name="merid" id="merid" /></td>
						<td align="right" width="10%">交易卡号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input name="cardno" id="cardno" /></td>
					</tr>
					
					<tr>
						<td align="right" width="10%">定单号</td>
						<td align="left" style="padding-left: 5px" width="25%">
						<input name="orderno" id="orderno" /></td>
						<td align="right" width="10%">交易状态</td>
						<td style="padding-left: 5px">
						<select name="transstat" id="transstat" style="width: 150px">
								<option value="">--请选择应答状态--</option>
								<option value="PR05">已成功</option>
								<option value="PR09">已拒绝</option>
								<option value="PR32">逾期退回</option>
						</select></td> 
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
	<div id="w" class="easyui-window" closed="true" title="My Window"  style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center" id="continer">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo" border="1">
					
					<tr>
						<td colspan="4" class="head-title">接口参数</td>
					</tr>
					<tr>
						<td>版本</td><td id="version"></td>
						<td>网关号</td><td id="gateid"></td>
					</tr>
					<tr>
						<td>私有域</td><td id="priv1"></td>
						<td>交易手机串号IMEI</td><td id="imei"></td>
					</tr>
					<tr>
						<td>PC 硬盘序列号</td><td id="disksn"></td>
						<td>PC mac地址</td><td id="mac"></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">基本信息</td>
					</tr>
					 <tr>
						<td width="15%">订单号</td><td width="35%" id="orderno"></td>
						<td width="15%">交易序列号</td><td width="35%" id="txnseqno"></td>
					</tr> 
					<tr>
						<td>商户编号</td><td id="merid"></td>
						<td>商户日期</td><td id="transdate"></td>
					</tr>
					
					<tr>
						<td>金额(元)</td><td id="transamt"></td>
						<td>交易币种</td><td id="curyid"></td>
					</tr>
					<tr>
						<td>状态</td><td id="transstat"></td>
						<td>通道手续费</td><td id="chnlfee"></td>
					</tr>
					<tr>
						<td>订单描述</td><td id="orderdesc"></td>
						<td>交易模式</td><td id="paymode"></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">用户信息</td>
					</tr>
					
						<td>证件类型</td><td id="certtype"></td>
						<td>用户ID</td><td id="userid"></td>
					</tr>
					<tr>
						<td>用户注册邮箱</td><td id="usermail"></td>
						<td>用户注册时间</td><td id="userregistertime"></td>
					</tr>
					<tr>
						<td>用户注册手机号</td><td id="usermobile"></td>
						<td>用户IP地址</td><td id="ip"></td>
					</tr>
					
					<tr>
						<td>短信验证码输入操作特征</td><td id="codeinputtype"></td>
						<td>手机所在基站序列号</td><td id="basestationsn"></td>
					</tr>
					
					<tr>
						<td colspan="4" class="head-title">交易信息</td>
					</tr>
					<tr>
						<td>交易要素</td><td id="factorid" colspan="3"></td>
					</tr>
					<tr>
						<td>开户行号</td><td id="openbankid"></td>
						<td>卡号/折号</td><td id=tcardno></td>
					</tr>
					<tr>
						<td>持卡人姓名</td><td id="usrname"></td>
						<td>卡折标志</td><td id="cardtype"></td>
					</tr>
					
					<tr>
						
						<td>签名值</td><td id="chkvalue"></td>
						<td>预留手机号</td><td id="mobileforbank"></td>
					</tr>
					<tr>
						<td>证件号</td><td id=certid></td>
						
					</tr>
					
					<tr>
						<td colspan="4" class="head-title">订单处理信息</td>
					</tr>
					<tr>
						<td>描述</td><td id="message"></td>
						<td>应答信息</td><td id="responsecode"></td>
					</tr>
					<tr>
						<td>渠道类型</td><td id="termtype"></td>
						<td>渠道返回日期</td><td id="chnlretdate"></td>
					</tr>
					<tr>
						<td>受理订单号</td><td id="tn"></td>
					<td>用途</td><td id="purpose" ></td>
					</tr>
					
					<tr>
						<td>提交时间</td><td id="intime"></td>
						<td>更新时间</td><td id="uptime"></td>
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
							url : 'trade/getChnCollectSingleLogByPage',
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
										field : 'merid',
										title : '商户号',
										width : 150,
										align : 'center'
									},
									{
										field : 'transdate',
										title : '商户日期',
										width : 150,
										align : 'center'
									},
									{
										field : 'orderno',
										title : '订单号',
										width : 120,
										align : 'center'
									},
									{
										field : 'cardno',
										title : '交易卡号',
										width : 120,
										align : 'center'
									},
									{
										field : 'usrname',
										title : '姓名',
										width : 150,
										align : 'center'
									},
									{
										field : 'transamt',
										title : '交易金额(元)',
										width : 120,
										align : 'center',
									 formatter:function(value,rec){
										return fenToYuan(rec.transamt);
									} 
									},
									{
										field : 'intime',
										title : '交易时间',
										width : 150,
										align : 'center'
										/* formatter : function(value, rec) {
											return changeDate(rec.chnlretdate);
										} */
									},
									{
										field : 'transstat',
										title : '交易状态',
										width : 120,
										align : 'center',
										formatter : function(value, rec) {
											if (rec.transstat == "PR05") {
												return "已成功";
											}
											if (rec.transstat == "PR09") {
												return "已拒绝";
											}
											if (rec.transstat == "PR32") {
												return "逾期退回";
											}
											
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
			"merid" : $('#merid').val(),
			"cardno" : $('#cardno').val(),
			"orderno" : $('#orderno').val(),
			"transstat" : $('#transstat').val(),
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}

	function resize() {
		$('#theForm :input').val('');
	}

	function queryDetail(logseqno) {
		$("#merid").html("");
		$("#tid").html("");
		$("#txnseqno").html("");
		$("#transdate").html("");
		$("#orderno").html("");
		$("#transtype").html("");
		$("#openbankid").html("");
		$("#cardtype").html("");
		$("#cardno").html("");
		$("#usrname").html("");
		$("#certtype").html("");
		$("#certid").html("");
		$("#amount").html("");
		$("#curyid").html("");
		$("#transamt").html("");
		$("#purpose").html("");
		$("#priv1").html("");
		$("#version").html("");
		$("#gateid").html("");
		$("#termtype").html("");
		$("#paymode").html("");
		$("#userid").html("");
		$("#userregistertime").html("");
		$("#usermail").html("");
		$("#usermobile").html("");
		$("#disksn").html("");
		$("#mac").html("");
		$("#imei").html("");
		$("#ip").html("");
		$("#coordinates").html("");
		$("#basestationsn").html("");

		$("#codeinputtype").html("");
		$("#mobileforbank").html("");
		$("#responsecode").html("");
		$("#transstat").html("");
		$("#chnlretdate").html("");
		$("#message").html("");
		$("#intime").html("");
		$("#uptime").html("");
		$("#chnlfee").html("");
		
		
		$('#w').window({
			title : '实时代收渠道交易流水详细信息',
			top : 90,
			left : 100,
			width : 900,
			modal : true,
			minimizable : false,
			collapsible : false,
			maximizable : false,
			shadow : false,
			closed : false,
			height : 660
		});
		var rows = $('#test').datagrid('getSelected');
		$("#merid").html(rows["merid"]);
		$("#tid").html(rows["tid"]);
		$("#txnseqno").html(rows["txnseqno"]);
		$("#transdate").html(changeDate(rows["transdate"]));
		$("#orderno").html(rows["orderno"]);
		$("#transtype").html(rows["transtype"]);
		$("#openbankid").html(rows["openbankid"]);
		$("#cardtype").html(cardType(rows["cardtype"]));
		$("#tcardno").html(rows["cardno"]);
		$("#usrname").html(rows["usrname"]);
		$("#certtype").html(certType(rows["certtype"]));
		$("#certid").html(rows["certid"]);
		if (rows["curyid"] == "156") {
			$("#curyid").html("人民币");
		};
		/* $("#curyid").html(rows["curyid"]); */
		$("#transamt").html(fenToYuan(rows["transamt"]));
		$("#purpose").html(rows["purpose"]);
		$("#priv1").html(rows["priv1"]);
		$("#version").html(rows["version"]);
		$("#gateid").html(rows["gateid"]);
		$("#termtype").html(rows["termtype"]);
		$("#paymode").html(payMode(rows["paymode"]));
		$("#userid").html(rows["userid"]);
		$("#userregistertime").html(changeDateTime(rows["userregistertime"]));
		$("#usermail").html(rows["usermail"]);
		$("#usermobile").html(rows["usermobile"]);
		$("#disksn").html(rows["disksn"]);
		$("#mac").html(rows["mac"]);
		$("#imei").html(rows["imei"]);
		$("#ip").html(rows["ip"]);
		$("#coordinates").html(rows["coordinates"]);
		$("#basestationsn").html(rows["basestationsn"]);
		$("#codeinputtype").html(rows["codeinputtype"]);
		$("#mobileforbank").html(rows["mobileforbank"]);
		$("#orderdesc").html(rows["orderdesc"]);
		
		$("#chkvalue").html(rows["chkvalue"]);
		$("#responsecode").html(rows["responsecode"]);
		$("#message").html(rows["message"]);
		$("#transstat").html(analysisStatus(rows["transstat"]));
		$("#chnlretdate").html(changeDate(rows["chnlretdate"]));
		$("#intime").html(rows["intime"]);
		$("#uptime").html(rows["uptime"]);
		$("#chnlfee").html(fenToYuan(rows["chnlfee"]));
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
	// 解析交易模式
	function payMode(value) {
		if (value == "0") {
			return "被动发起代扣";
		}
		if (value == "1") {
			return "主动发起代扣";
		}
		
	}
	
	function closeAdd() {
		$('#w').window('close');
	}
</script>
</html>
