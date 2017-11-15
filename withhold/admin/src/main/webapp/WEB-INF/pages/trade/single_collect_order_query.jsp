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
			style="height: 125px; padding: 10px; background: #fafafa;"
			collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">商户号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="merid" id="merids"  /></td>
						<td align="right" width="10%">交易卡号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="cardno" id="cardnos"  /></td>
						
					</tr>
					<tr>
						<td align="right" width="10%">商户订单号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="orderid" id="orderids"  /></td>
						<td align="right" width="10%">受理订单号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="tn" id="tns"  /></td>	
						<!-- <td align="right" width="10%">付款人账号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="debtoraccount" id="debtoraccounts"  /></td>
							
						<td align="right" width="10%">收款人账号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="creditoraccount" id="creditoraccounts"  /></td> -->
					</tr>
					<tr>
						<td align="right" width="10%">订单状态</td>
						<td style="padding-left: 5px"><select name="status"
							id="statuss" style="width: 150px">
								<option value="">--请选择订单状态--</option>
								<option value="00">支付成功</option>
								<option value="01">订单提交成功,但未支付</option>
								<option value="02">支付中</option>
								<option value="03">支付失败</option>
								<option value="04">订单失效</option>
						</select></td>
						<td align="right" width="10%">起止时间</td>
						<td colspan="2" style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:true" name="stime"></input> 至<input
							id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:true"
							name="etime"></input></td>
						<td align="right" >
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		 style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" id="continer"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo"
					border="1">
					<!-- <tr>
						<td>标志</td><td id="tid"></td>
						<td>接入类型</td><td id="accesstype"></td>
					</tr> -->
					<tr>
						<td colspan="4" class="head-title">接口参数</td>
					</tr>
					<tr>
						<td>版本</td><td id="version"></td>
						<td>编码方式</td><td id="encoding"></td>
					</tr>
					<tr>
						<td>交易类型</td><td id="txntype"></td>
						<td>交易子类</td><td id="txnsubtype"></td>
					</tr>
					<tr>
						<td>产品类型</td><td id="biztype"></td>
						<td></td><td></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">基本信息</td>
					</tr>
					<tr>
						<td width="15%">订单号</td><td width="35%" id="orderid"></td>
						<td width="15%">订单交易时间</td><td width="35%" id="txntime"></td>
					</tr>
					<tr>
						<td>委托机构号</td><td id="merid"></td>
						<td>委托机构名称</td><td id="mername"></td>
					</tr>
					<tr>
						<td>商户简称</td><td id="merabbr"></td>
						<td>订单描述</td><td id="orderdesc"></td>
					</tr>
					<tr>
						<td>金额(元)</td><td id="txnamt"></td>
						<td>交易币种</td><td id="currencycode"></td>
					</tr>
					<tr>
						<td>状态</td><td id="status"></td>
						<td>通知地址</td><td id="backurl"></td>
					</tr>
					<tr>
						<td>接入类型</td><td id="accesstype"></td>
						<td>合作机构号</td><td id="coopinstiid"></td>
					</tr>
					
					
					<tr>
						<td colspan="4" class="head-title">付款方信息</td>
					</tr>
					<tr>
						<td>交易要素</td><td id="factorid" colspan="3"></td>
					</tr>
					<tr>
						<td>付款人银行号</td><td id="bankcode"></td>
						<td>银行卡号</td><td id="cardno"></td>
					</tr>
					<tr>
						
						<td>持卡人姓名</td><td id="customernm"></td>
						<td>手机号</td><td id="phone"></td>
					</tr>
					<tr>
						<td>身份证号</td><td id="idcard"></td>
						<td>扣款类型</td><td id="dktype"></td>
					</tr>
					<tr>
						<td>摘要</td><td id="summary" ></td>
						 <td>保留域</td><td id="reserved"></td> 
					</tr>
					<tr>
						<td colspan="4" class="head-title">订单处理信息</td>
					</tr>
					<tr>
						<td>响应码</td><td id="respcode"></td>
						<td>应答信息</td><td id="respmsg"></td>
					</tr>
					<tr>
						<td>受理订单号</td><td id="tn"></td>
						<td>交易序列号</td><td id="relatetradetxn"></td>
					</tr>
					<tr>
						<td>订单提交时间</td><td id="ordercommitime"></td>
						<td>异步通知结果</td><td id="syncnotify"></td>
					</tr>
					<tr>
						<td>备注</td><td id="notes"></td>
						<td>标记</td><td id="remarks"></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 15px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
</body>

<script>
	function changeDate(value){
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
	
	var width = $("#continer").width();
	$(function() {
		$('#test')
				.datagrid(
						{
							title : '实时代收订单信息列表',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getSingleOrderByPage',
							remoteSort : false,
							idField : 'tid',
							columns : [ [
									{field:'relatetradetxn',title:'交易序列号',width:123,align:'center'},
									{field:'merid',title:'商户号',width:150,align:'center'},
									{field:'txntime',title:'订单发送时间',width:130,align:'center',
										formatter : function(value, rec) {
											return changeDate(rec.txntime);
										}	
									},
									{field:'orderid',title:'商户订单号',width:150,align:'center'},
									{field:'cardno',title:'交易卡号',width:100,align:'center'},									
									{field:'customernm',title:'姓名',width:150,align:'center'},
									{field:'txnamt',title:'交易金额(元)',width:130,align:'center',
										formatter:function(value,rec){
											return fenToYuan(rec.txnamt);
										}
									},
									{field:'tn',title:'受理订单号',width:100,align:'center'},
									
									{field:'status',title:'交易状态',width:148,align:'center',
										formatter : function(value, rec) {
											if (rec.status == "00") {
												return "支付成功";
											} 
											if (rec.status == "01") {
												return "订单提交成功,但未支付";
											} 
											if (rec.status == "02") {
												return "支付中";
											} 
											if (rec.status == "03") {
												return "支付失败";
											} 
											if (rec.status == "04") {
												return "订单失效";
											} 
										}
									},
									{field : 'ID',title : '操作',width : 100,lign : 'center',
										formatter : function(value, rec) {
											if (rec.tid!= null) {
												return '<a href="javascript:queryOrderSingle(\''
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
			"merid" : $('#merids').val(),
			"cardno" : $('#cardnos').val(),
			"orderid" : $('#orderids').val(),
			"tn" : $('#tns').val(),
			"status" : $('#statuss').val(),
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}

	function resize(){
		$('#theForm :input').val('');
	}
	function closeAdd(){
		$('#w').window('close');
	}	
	function queryOrderSingle(tid) {
		/*  $("#tid").html("");
		$("#accesstype").html("");
		$("#coopinstiid").html("");
		$("#merid").html("");
		$("#version").html("");
		$("#encoding").html("");
		$("#txntype").html("");
		$("#txnsubtype").html("");
		$("#biztype").html("");
		$("#backurl").html("");
		$("#txntime").html("");
		$("#orderid").html("");
		
		$("#mername").html("");
		$("#merabbr").html("");
		$("#paytimeout").html("");
		
		$("#currencycode").html("");
		$("#txnamt").html("");
		$("#debtorbank").html("");
		$("#debtoraccount").html("");
		$("#debtorname").html("");
		$("#debtorconsign").html("");
		$("#creditorbank").html("");
		$("#creditoraccount").html("");
		$("#creditorname").html("");
		$("#proprietary").html("");
		$("#summary").html("");
		$("#reserved").html("");
		$("#respcode").html("");
		$("#respmsg").html("");
		$("#tn").html("");
		$("#relatetradetxn").html("");
		$("#status").html("");
		$("#ordercommitime").html("");
		$("#syncnotify").html("");  */
		$.ajax({
			   type: "POST",
			   url: "trade/getSingleById",
			   data: "tid="+tid,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   if(json!=null){
						$("#tid").html(json.tid);
						/* $("#user_code").attr('readonly','readonly');
						$("#user_code").css('background-color','#D2D2D2'); */
						$("#accesstype").html(json.accesstype);
						$("#coopinstiid").html(json.coopinstiid);
						$("#merid").html(json.merid);
						$("#version").html(json.version);
						$("#encoding").html(json.encoding);
						$("#certid").html(json.certid);
						$("#txntype").html(json.txntype);
						
						$("#txnsubtype").html(json.txnsubtype);
						$("#biztype").html(json.biztype);
						$("#backurl").html(json.backurl);
						$("#mername").html(json.mername);
						$("#merabbr").html(json.merabbr);
						$("#orderid").html(json.orderid);
						$("#certid").html(json.certid);
						$("#txntime").html(changeDate(json.txntime));
						$("#paytimeout").html(changeDate(json.paytimeout));
						$("#txnamt").html(fenToYuan(json.txnamt));
						if (json.currencycode == "156") {
							$("#currencycode").html("人民币");
						}
						
						$("#bankcode").html(json.bankcode);
						$("#cardno").html(json.cardno);
						$("#customernm").html(json.customernm);
						
						$("#factorid").html(json.factorid);
						$("#phone").html(json.phone);
						$("#idcard").html(json.idcard);
						$("#dktype").html(json.dktype);
						$("#orderdesc").html(json.orderdesc);
						$("#reserved").html(json.reserved);
						$("#respcode").html(json.respcode);
						$("#respmsg").html(json.respmsg);
						$("#tn").html(json.tn);
						$("#relatetradetxn").html(json.relatetradetxn);
						$("#status").html(getStatus(json.status));
						$("#ordercommitime").html(changeDate(json.ordercommitime));
						$("#syncnotify").html(json.syncnotify);
						$("#notes").html(json.notes);
						$("#remarks").html(json.remarks);
				   }
			   },
			   error : function(){
					$.messager.alert('提示', '服务异常！');
				}
			});
		
		$('#w').window({
			title : '实时代收订单详细信息',
			top : 30,
			left : 100,
			width : 900,
			modal : true,
			minimizable : false,
			collapsible : false,
			maximizable : false,
			shadow : false,
			closed : false,
			height : 650
		});
		
		function getStatus(value){
			if (value == "00") {
				return "支付成功";
			} 
			if (value == "01") {
				return "订单提交成功,但未支付";
			} 
			if (value == "02") {
				return "支付中";
			} 
			if (value == "03") {
				return "支付失败";
			} 
			if (value == "04") {
				return "订单失效";
			} 
		}
		
		/* var rows = $('#test').datagrid('getSelected');
		
		$("#tid").html(rows["TID"]);
		$("#accesstype").html(rows["ACCESSTYPE"]);
		$("#coopinstiid").html(rows["COOPINSTIID"]);
		$("#merid").html(rows["MERID"]);
		$("#version").html(rows["VERSION"]);
		if (rows["ENCODING"] == "1") {
			$("#encoding").html("UTF-8");
		}
		$("#txntype").html(rows["TXNTYPE"]);
		$("#txnsubtype").html(rows["TXNSUBTYPE"]);
		$("#biztype").html(rows["BIZTYPE"]);
		$("#backurl").html(rows["BACKURL"]);
		$("#txntime").html(changeDate(rows["TXNTIME"]));
		$("#orderid").html(rows["ORDERID"]);
		if (rows["CURRENCYCODE"] == "156") {
			$("#currencycode").html("人民币");
		}
		$("#txnamt").html(fenToYuan(rows["TXNAMT"]));
		$("#debtorbank").html(rows["DEBTORBANK"]);
		$("#debtoraccount").html(rows["DEBTORACCOUNT"]);
		$("#debtorname").html(rows["DEBTORNAME"]);
		$("#debtorconsign").html(rows["DEBTORCONSIGN"]);
		$("#creditorbank").html(rows["CREDITORBANK"]);
		$("#creditoraccount").html(rows["CREDITORACCOUNT"]);
		$("#creditorname").html(rows["CREDITORNAME"]);
		$("#proprietary").html(rows["PROPRIETARY"]);
		$("#summary").html(rows["SUMMARY"]);
		$("#reserved").html(rows["RESERVED"]);
		$("#respcode").html(rows["RESPCODE"]);
		$("#respmsg").html(rows["RESPMSG"]);
		$("#tn").html(rows["TN"]);
		$("#relatetradetxn").html(rows["RELATETRADETXN"]);
		$("#status").html(getStatus(rows["STATUS"]));
		$("#ordercommitime").html(changeDate(rows["ORDERCOMMITIME"]));
		$("#syncnotify").html(rows["SYNCNOTIFY"]);
		$("#mername").html(rows["MERNAME"]);
		$("#merabbr").html(rows["MERABBR"]);
		$("#paytimeout").html(rows["PAYTIMEOUT"]);
		if(rows["MERNAME"]==""||rows["MERNAME"]==null){
			$("#mername").html(rows["ENTERPRISE_NAME"]);
		}else{
			$("#mername").html(rows["MERNAME"]);
		}
		$("#orderdesc").html(rows["ORDERDESC"]) */
		
	}
	function fenToYuan(value){
		var str = (value/100).toFixed(2) + '';
		var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
		var dot = str.substring(str.length,str.indexOf("."))
		var ret = intSum + dot;
		return ret;
	}
</script>
</html>
