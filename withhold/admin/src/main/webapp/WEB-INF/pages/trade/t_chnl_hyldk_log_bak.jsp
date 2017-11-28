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
						<td align="left" style="padding-left: 5px" width="25%"><input name="merchantid" id="merchant_id" /></td>
						<td align="right" width="10%">交易卡号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input name="accountno" id="account_no" /></td>
					</tr>
					
					<tr>
						<td align="right" width="10%">定单号</td>
						<td align="left" style="padding-left: 5px" width="25%">
						<input name="reqsn" id="req_sn" /></td>
						<td align="right" width="10%">交易状态</td>
						<td style="padding-left: 5px">
						<!-- <select name="retcode" id="ret_code" style="width: 150px">
								<option value="">--请选择应答状态--</option>
								<option value="PR05">已成功</option>
								<option value="PR09">已拒绝</option>
								<option value="PR32">逾期退回</option>
						</select></td>  -->
						<select id="ret_code" name="retcode" style="width: 150px">
								<option value="0000"> 交易成功</option>
								<option value="0001">交易失败</option>
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
						<td>保留域1</td><td id="reserve1"></td>
						<td>保留域2</td><td id="reserve2"></td>
					</tr>
					<tr>
						<td>版本</td><td id="version"></td>
						<td>备注</td><td id="remark"></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">基本信息</td>
					</tr>
					 <tr>
						<td width="15%">业务代码</td><td width="35%" id="businesscode"></td>
						<td width="15%">交易序列号</td><td width="35%" id="txnseqno"></td>
					</tr> 
					<tr>
						<td>银联网络商户ID</td><td id="merchantid"></td>
						<td>银联网络用户编号</td><td id="eusercode"></td>
					</tr>
					 <tr>
						<td>处理级别 </td><td id="processlevel"></td>
						<td>记录序号</td><td id="sn"></td>
					</tr> 
					<!-- <tr>
						<td>订单描述</td><td id="orderdesc"></td>
						<td>交易模式</td><td id="paymode"></td>
					</tr> -->
					<tr>
						<td colspan="4" class="head-title">用户信息</td>
					</tr>
					
						<td>证件类型</td><td id="idtype"></td>
						<td>证件号</td><td id="id"></td>
						
					</tr>
					<tr>
						<td>用户ID</td><td id="protocol"></td>
						<td>电话</td><td id="tel"></td>
					</tr>
					<!-- <tr>
						<td>用户注册手机号</td><td id="tel"></td>
						<td>用户IP地址</td><td id="ip"></td>
					</tr> -->
					
					<!-- <tr>
						<td>短信验证码输入操作特征</td><td id="codeinputtype"></td>
						<td>手机所在基站序列号</td><td id="basestationsn"></td>
					</tr> -->
					
					<tr>
						<td colspan="4" class="head-title">交易信息</td>
					</tr>
					<tr>
						<td>交易代码</td><td id="trxcode" ></td>
						<td>交易流水号</td><td id="reqsn" ></td>
					</tr>
					<tr>
						<td>账号</td><td id="accountno"></td>
						<td>账号名</td><td id=accountname></td>
					</tr>
					<tr>
						<td>账号类型</td><td id="accounttype"></td>
						<td>银行代码</td><td id="bankcode"></td>
					</tr>
					<tr>
						<td>金额</td><td id="amount"></td>
						<td>货币类型</td><td id="currency"></td>
					</tr>
					<tr>
						
						<td>签名信息</td><td style="word-break:break-all" id="signedmsg"></td>
						<td>协议用户编号</td><td id=protocoluserid></td>
					</tr>
					<tr>
						
						<td>总记录数</td><td id="totalitem"></td>
						<td>总金额 </td><td id=totalsum></td>
					</tr>
					
					<tr>
						<td colspan="4" class="head-title">订单处理信息</td>
					</tr>
					<!-- <tr>
						<td>描述</td><td id="message"></td>
						<td>应答信息</td><td id="responsecode"></td>
					</tr> -->
					<!-- <tr>
						<td>渠道类型</td><td id="termtype"></td>
						<td>渠道返回日期</td><td id="remark"></td>
					</tr> -->
					<tr>
						<td>返回信息</td><td id="errmsg"></td>
						<td>返回状态</td><td id="retcode" ></td>
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
		//showStatus();
		$('#test')
				.datagrid(
						{
							title : '好易联实时流水信息列表',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getHYLCollectBakDeta',
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
										field : 'merchantid',
										title : '商户号',
										width : 150,
										align : 'center'
									},
									/* {
										field : 'transdate',
										title : '商户日期',
										width : 150,
										align : 'center'
									}, */
									{
										field : 'reqsn',
										title : '订单号',
										width : 120,
										align : 'center'
									},
									{
										field : 'accountno',
										title : '交易卡号',
										width : 120,
										align : 'center'
									},
									{
										field : 'accountname',
										title : '账号名',
										width : 150,
										align : 'center'
									},
									{
										field : 'amount',
										title : '交易金额(元)',
										width : 120,
										align : 'center',
									 formatter:function(value,rec){
										return fenToYuan(rec.amount);
									} 
									},
									{
										field : 'intime',
										title : '交易时间',
										width : 150,
										align : 'center',
										formatter:function(value, row) { 
											return formatTime(value);
										}
									},
									{
										field : 'errmsg',
										title : '交易状态',
										width : 120,
										align : 'center'
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
			"merchantid" : $('#merchant_id ').val(),
			"accountno" : $('#account_no').val(),
			"reqsn" : $('#re_qsn').val(),
			"retcode" : $('#ret_code').val(),
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}

	function resize() {
		$('#theForm :input').val('');
	}
	function showStatus(){		
		$.ajax({
		   type: "POST",
		   url: "trade/showHYLbakStatus",
		   dataType:"json",
		   success: function(json){
			   if(json!=null){
		   		var html ="<option value=''>--请选择交易状态--</option>";
		   		$.each(json, function(key,value){
		   			if(value!=null){
		   			html += '<option value="'+value.retcode+'">'+value.errmsg+'</option>';
		   			}
				})
				$("#ret_code").html(html);
		   }
		   }
		});
	} 
	function queryDetail(logseqno) {
		$("#merchantid").html("");
		$("#tid").html("");
		$("#txnseqno").html("");
		$("#trxcode").html("");
		$("#version").html("");
		$("#datatype").html("");
		$("#processlevel").html("");
		$("#reqsn").html("");
		$("#signedmsg").html("");
		$("#businesscode").html("");
		$("#totalitem").html("");
		$("#totalsum").html("");
		$("#sn").html("");
		$("#eusercode").html("");
		$("#bankcode").html("");
		$("#accounttype").html("");
		$("#accountno").html("");
		$("#accountname").html("");
		$("#amount").html("");
		$("#currency").html("");
		$("#protocol").html("");
		$("#protocoluserid").html("");
		$("#idtype").html("");
		$("#id").html("");
		$("#tel").html("");
		$("#remark").html("");
		$("#retcode").html("");
		$("#errmsg").html("");
		$("#reserve1").html("");
		$("#reserve2").html("");
		$("#intime").html("");

		$("#uptime").html("");
		/* $("#mobileforbank").html("");
		$("#responsecode").html("");
		$("#transstat").html("");
		$("#chnlretdate").html("");
		$("#message").html("");
		$("#intime").html("");
		$("#uptime").html("");
		$("#chnlfee").html(""); */
		
		
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
		$("#merchantid").html(rows["merchantid"]);
		$("#tid").html(rows["tid"]);
		$("#txnseqno").html(rows["txnseqno"]);
		$("#trxcode").html(rows["trxcode"]);
		$("#version").html(rows["version"]);
		$("#datatype").html(rows["datatype"]);
		$("#processlevel").html(rows["processlevel"]);
		if (rows["processlevel"] == "0") {
			$("#processlevel").html("实时处理");
		};
		$("#reqsn").html(rows["reqsn"]);
		$("#signedmsg").html(rows["signedmsg"]);
		$("#businesscode").html(rows["businesscode"]);
		$("#merchantid").html(rows["merchantid"]);
		$("#totalitem").html(rows["totalitem"]);
		
		/* $("#curyid").html(rows["curyid"]); */
		$("#totalsum").html(fenToYuan(rows["totalsum"]));
		$("#sn").html(rows["sn"]);
		$("#eusercode").html(rows["eusercode"]);
		$("#bankcode").html(rows["bankcode"]);
		$("#accounttype").html(cardType(rows["accounttype"]));
		$("#accountno").html(rows["accountno"]);
		$("#accountname").html(rows["accountname"]);
		$("#amount").html(fenToYuan(rows["amount"]));
		$("#currency").html(currencyType(rows["currency"]));
		$("#protocol").html(rows["protocol"]);
		$("#protocoluserid").html(rows["protocoluserid"]);
		$("#idtype").html(certType(rows["idtype"]));
		$("#id").html(rows["id"]);
		$("#tel").html(rows["tel"]);
		$("#remark").html(rows["remark"]);
		$("#retcode").html(rows["retcode"]);
		$("#errmsg").html(rows["errmsg"]);
		$("#reserve1").html(rows["reserve1"]);
		$("#reserve2").html(rows["reserve2"]);
		$("#intime").html(formatTime(rows["intime"]));
		$("#uptime").html(formatTime(rows["uptime"]));
		
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
	// 格式化时间
	function formatTime(value) {
		var dateString = value;
		if(dateString!=null){
			  var date = new Date(dateString); 
			  return formatDate(date,"yyyy-mm-dd hh:nn:ss");
			}else{ 
			  return ""; 
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
	//开户证件类型0：身份证,1: 户口簿，2：护照,3.军官证,4.士兵证，5. 港澳居民来往内地通行证,6. 台湾同胞来往内地通行证,7. 临时身份证,8. 外国人居留证,9. 警官证, X.其他证件
	function certType(value) {
		if (value == "0") {
			return "身份证";
		}
		if (value == "1") {
			return "户口簿";
		}
		if (value == "2") {
			return "护照";
		}
		if (value == "3") {
			return "军官证";
		}
		if (value == "4") {
			return "士兵证";
		}
		if (value == "5") {
			return "港澳居民来往内地通行证";
		}
		if (value == "6") {
			return "台湾同胞来往内地通行证";
		}
		if (value == "7") {
			return "临时身份证";
		}
		if (value == "8") {
			return "外国人居留证";
		}
		if (value == "9") {
			return "警官证";
		}
		if (value == "x") {
			return "其他证件";
		}
	}
	// 解析卡折标志
	function cardType(value) {
		if (value == "00") {
			return "卡";
		}
		if (value == "01") {
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
	////货币类型 人民币：CNY, 港元：HKD，美元：USD
	function currencyType(value) {
		if (value == "CNK") {
			return "人民币";
		}
		if (value == "HKD") {
			return "港元";
		}
		if (value == "USD") {
			return "美元";
		}
	}
	function closeAdd() {
		$('#w').window('close');
	}
</script>
</html>
