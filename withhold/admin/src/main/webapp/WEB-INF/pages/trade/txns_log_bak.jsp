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
	<div style="margin: 5px;" >
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 150px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">商户号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="accsecmerno" id="accsecmerno" maxlength="32" /></td>
						<td align="right" width="10%">商户订单号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="accordno" id="accordno" maxlength="32" /></td>
						<td align="right" width="10%">支付订单号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="payordno" id="payordno" maxlength="32" /></td>
					</tr>
					<tr>
						<td align="right" width="10%">交易序列号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="txnseqno" id="txnseqno" maxlength="32" /></td>
						<td align="right" width="10%">交易卡号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="pan" id="pan" maxlength="32" /></td>
					</tr>
					<tr>
						<td align="right" width="10%">交易结果</td>
						<td style="padding-left: 5px"><select name="retcode"
							id="retcode" style="width: 150px">
							<option value="">--请选择交易结果--</option>
								<option value="0000">交易成功</option>
								<option value="0001">交易失败</option>
						</select></td>
						<td align="right" width="10%">交易渠道</td>
						<td colspan="1" style="padding-left: 5px"><select name="accfirmerno" id="accfirmerno" style="width:150px">
								 <option value="">--请选择交易渠道--</option>
								<%--<c:forEach items="${channel}" var="channel">
									<option value=${channel.CHNLCODE }>${channel.CHNLNAME}</option>
								</c:forEach> --%>
						</select></td>
					</tr>
					<tr>
						<td align="right" width="10%">起止时间</td>
						<td colspan="2" style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:true" name="stime"></input>
							至<input id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:true"
							name="etime"></input></td>
						<td></td>
						<td colspan="2" align="right"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a></td>
							</td>
					
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>

	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" id="continer"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo" border="1">
					<tr>
						<td colspan="4" class="head-title">基本信息</td>
					</tr>
					<tr>
						<td width="15%">交易序列号</td>
						<td width="35%"id="ttxnseqno"></td>
						<!-- <td>产品版本[委托机构角色]</td>
						<td id="tprdtver"></td> -->
						<td width="15%">交易类型</td>
						<td width="35%" id="tbusicode"></td>
					</tr>
					<tr>
						<td>交易日期</td>
						<td id="ttxndate"></td>
						<td>交易时间</td>
						<td id="ttxntime"></td>
					</tr>
					
					<tr>
						<td>交易金额[合计](元)</td>
						<td id="tamount"></td>
						<td>交易手续费</td>
						<td id="ttxnfee"></td>
						
					</tr>
					<tr>
						<td>渠道(代理商)手续费(元)</td>
						<td id="tcoopfee"></td>
						<td>通道成本(元)</td>
						<td id="tchnlfee"></td>
					</tr> 
					<!-- <tr>
						<td>分润版本</td>
						<td id="tsplitver"></td>
						<td>扣率版本</td>
						<td id="tfeever"></td>
					</tr> -->
					
					<tr>
						<td>交易卡号</td>
						<td id="tpan"></td>
						<td>交易卡号类型</td>
						<td id="tcardtype"></td>
					</tr>
					<tr>
						<td>交易卡号所属银行</td>
						<td id="tcardinstino"></td>
						<!-- <td>转入帐号</td>
						<td id="tinpan"></td> -->
						
					<!-- </tr>
					<tr>
						<td>转入帐号类型</td>
						<td id="tincardtype"></td>
						<td>转入帐号所属银行</td>
						<td id="tincardinstino"></td> -->
					</tr>
					<tr>
						<td colspan="4" class="head-title">受理方信息</td>
					</tr>
					<tr>
						<td>商户订单号</td>
						<td id="taccordno"></td>
						<td>商户号</td>
						<td id="taccsecmerno"></td>
					</tr>
					<tr>
						<td>受理清算日期</td>
						<td id="taccsettledate"></td>
						<td>商户名称</td>
						<td id="tmemberName"></td>
					</tr>
					<tr>
						<td>受理提交时间</td>
						<td id="taccordcommitime"></td>
						<td>受理完成时间</td>
						<td id="taccordfintime"></td>
					</tr>
					
					<tr>
						<td colspan="4" class="head-title">通道方信息</td>
					</tr>
					<tr>
						<td>支付订单号</td>
						<td id="tpayordno"></td>
						<td>发送方代码</td>
						<td id="tpayfirmerno"></td>
					</tr>
					<tr>
						<td>通道提交时间</td>
						<td id="tpayordcomtime"></td>
						<td>通道完成时间</td>
						<td id="tpayordfintime"></td>
					</tr>
					
					<tr>
						<td>应答码</td>
						<td id="tpayretcode"></td>
						<td>应答信息</td>
						<td id="tpayretinfo"></td>
					</tr>
					<tr>
						<td>通道名称</td>
						<td id="tpayinst"></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">中心信息</td>
					</tr>
					<tr>
						<td>中心应答码</td>
						<td id="tretcode"></td>
						<td>中心应答信息</td>
						<td id="tretinfo"></td>
					</tr>
					<tr>
						<td>中心应答时间</td>
						<td id="tretdatetime"></td>
						<td>原交易序列号</td>
						<td id="ttxnseqno_og"></td>
						<!-- <td>交易查询流水</td>
						<td id="ttradeseltxn"></td> -->
						
					</tr>
					<tr>
						<td>交易状态标志位</td>
						<td id="ttradestatflag"></td>
						<td>交易流水表标志位</td>
						<td id="ttradetxnflag"></td>
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
	
	function changeDate(value){
		var dateString = value;
		if(dateString==null || dateString== 0){
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
	function b_changeDate(value){
		var dateString = value;
		if(dateString==null || dateString== 0){
			return "";
		}else{
			year=dateString.substring(0,4);//0123
			month=dateString.substring(4,6);//45
			day=dateString.substring(6,8);//67
			return year+"-"+month+"-"+day;
		}
	}
	function c_changeDate(value){
		var dateString = value;
		if(dateString==null || dateString== 0){
			return "";
		}else{
			/* hour=dateString.substring(8,10);//89
			minte=dateString.substring(10,12);//10 11
			s=dateString.substring(12,14);// 11 12 */
			hour = dateString.substring(0, 2);
			minte = dateString.substring(2, 4);
			s = dateString.substring(4, 6);
			return hour +":"+minte+":"+s;
		}
	}
  	var width = $("#continer").width();
		$(function(){
			showCacode();
			$('#test').datagrid({
				title:'交易信息列表',
				iconCls:'icon-save',
				height:500,
				singleSelect:true,
				nowrap: false,
				striped: true,
				url:'trade/getTxnsLogBakByPage',
				remoteSort: false,
				idField:'ORGAN_ID',
				columns:[
				[
					{field:'txnseqno',title:'交易序列号',width:120,align:'center'},
					{field:'accfirmerno',title:'渠道号',width:150,align:'center'},
					{field:'accsecmerno',title:'商户号',width:150,align:'center'},
					{field:'memberName',title:'商户名称',width:120,align:'center'},
					{field:'pan',title:'交易卡号',width:160,align:'center'},
					{field:'panName',title:'姓名',width:150,align:'center'},
					{field:'amount',title:'交易金额(元)',width:120,align:'center',
						 formatter:function(value,rec){
							return fenToYuan(rec.amount);
						} 
					},
					{field:'time',title:'交易时间',width:150,align:'center',
						formatter : function(value, rec) {
							return changeDate(rec.txndate+rec.txntime);
						}
					},
					{field:'retinfo',title:'交易状态',width:120,align:'center'
						
					},
					{field:'TXNSEQNO_OG',title:'操作',width:100,align:'center',
					formatter:function(value,rec){
						if(rec.txnseqno!=null){
							return '<a href="javascript:queryTxnsLog(\''+rec.txnseqno+'\')" style="color:blue;margin-left:10px">详细信息</a>';
						}else {
							return '';
						}
					}
				    } 
					
				]],
				pagination:true,
				rownumbers:true
		
			});
	
		});
		function showCacode(){		
			$.ajax({
				type : "POST",
				url: "coopAgency/queryAllSuperCode",
				dataType: "json",
				success: function(json) {
					if(json!=null){
					var html = "<option value=''>--请选择渠道--</option>";
					$.each(json,function(key, value) {
						html += '<option value="' + value.cacode + '">' + value.caname + '</option>';
					});
					$("#accfirmerno").html(html);
				}}
			});
		}

	
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
		
		function search(){
			var data={
			"accfirmerno":$('#accfirmerno').val(),
			"pan":$('#pan').val(),
			"accsecmerno":$('#accsecmerno').val(),
 			"retcode":$('#retcode').val(),
			"stime":$('#stime').datebox('getValue'),
			"etime":$('#etime').datebox('getValue'), 
			"accordno":$('#accordno').val(),
			"payordno":$('#payordno').val(),
			"txnseqno":$('#txnseqno').val(),
		}
			$('#test').datagrid('load',data);
		}
		
		function resize(){
			$('#theForm :input').val('');
		}
		
		function queryTxnsLog(txnseqno){
		 $("#ttxnseqno").html("");
			   $("#ttxndate").html("");
			   $("#ttxntime").html("");
			   $("#tapptype").html("");
			   $("#tbusitype").html("");
			   $("#tbusicode").html("");
			   $("#tamount").html("");
			   $("#ttradcomm").html("");
			   $("#ttxnfee").html("");
			   $("#triskver").html("");
			   $("#tsplitver").html("");
			   $("#tfeever").html("");
			   $("#tprdtver").html("");
			   $("#tcheckstandver").html("");
			   $("#troutver").html("");
			   $("#tpan").html("");
			   $("#tcardtype").html("");
			   $("#tcardinstino").html("");
			   $("#tinpan").html("");
			   $("#tincardtype").html("");
			   $("#tincardinstino").html("");
			   $("#taccordno").html("");
			   $("#taccordinst").html("");
			   $("#taccsecmerno").html("");
			   $("#taccfirmerno").html("");
			   $("#taccsettledate").html("");
			   $("#taccordcommitime").html("");
			   $("#taccordfintime").html("");
			   $("#tpaytype").html("");
			   $("#tpayordno").html("");
			   $("#tpayinst").html("");
			   $("#tpayfirmerno").html("");
			   $("#tpaysecmerno").html("");
			   $("#tpayordcomtime").html("");
			   $("#tpayordfintime").html("");
			   $("#tpayrettsnseqno").html("");
			   $("#tpayretcode").html("");
			   $("#tpayretinfo").html("");
			   $("#tappordno").html("");
			   $("#tappinst").html("");
			   $("#tappordcommitime").html("");
			   $("#tappordfintime").html("");
			   $("#ttradeseltxn").html("");
			   $("#tretcode").html("");
			   $("#tretinfo").html("");
			   $("#ttradestatflag").html("");
			   $("#ttradetxnflag").html("");
			   $("#ttxncode").html("");
			   $("#tcashcode").html("");
			   $("#trelate").html("");
			   $("#tretdatetime").html("");
			   $("#ttxnseqno_og").html("");
			   $("#tnotes").html("");
			   $("#tremarks").html("");
			   $("#taccmemberid").html("");
			   $("#tapporderstatus").html("");
			   $("#tapporderinfo").html("");
			   $("#tchnlfee").html("");
			   $("#tcoopfee").html("");
			   $("#tmemberName").html("");
			$('#w').window({
				title: '交易流水详细信息',
				top:50,
				left:100,
				width:910,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 640
			});
		
	
			$.ajax({
				   type: "POST",
				   url: "trade/getTxnsLogBakByTxnseqno",
				   data: "txnseqno="+txnseqno,
				   dataType:"json",
				   success:function(json){
					   if(json!=null){
						   $("#tmemberName").html(json.memberName); 
					   $("#ttxnseqno").html(json.txnseqno);
					   $("#ttxndate").html(b_changeDate(json.txndate));
					   $("#ttxntime").html(c_changeDate(json.txntime));
					   $("#tapptype").html(json.apptype);
					   $("#tbusitype").html(json.busitype);
					   $("#tbusicode").html(json.busicode);
					   $("#tamount").html(fenToYuan(json.amount));
					   $("#ttradcomm").html(json.tradcomm);
					   $("#ttxnfee").html(fenToYuan(json.txnfee));
					   $("#tchnlfee").html(fenToYuan(json.chnlfee));
					   $("#tcoopfee").html(fenToYuan(json.coopfee));
					   $("#triskver").html(json.riskver);
					   $("#tsplitver").html(json.splitver);
					   $("#tfeever").html(json.feever);
					   $("#tprdtver").html(json.prdtver);
					   $("#tcheckstandver").html(json.CASHNAME);
					   $("#troutver").html(json.routver);
					   $("#tpan").html(json.pan);
					   if(json.cardtype=="1"){
						   $("#tcardtype").html("借记卡");
					   }
					   if(json.cardtype=="2"){
						   $("#tcardtype").html("信用卡");
					   }
					   $("#tcardinstino").html(json.cardinstino);
					  /*  $("#tinpan").html(json.INPAN);
					   if(json.INCARDTYPE=="1"){
						   $("#tincardtype").html("借记卡");
					   }
					   if(json.tincardtype=="2"){
						   $("#tincardtype").html("信用卡");
					   } 
					   $("#tincardinstino").html(json.INCARDINSTINO);*/
					   $("#taccordno").html(json.accordno);
					   $("#taccordinst").html(json.accordinst);
					   $("#taccsecmerno").html(json.accsecmerno);
					   $("#taccfirmerno").html(json.accfirmerno);
					   $("#taccsettledate").html(changeDate(json.accsettledate).substring(0,10));
					   $("#taccordcommitime").html(changeDate(json.accordcommitime));
					   $("#taccordfintime").html(json.accordfintime);
					   $("#tpaytype").html(json.paytype);
					   $("#tpayordno").html(json.payordno);
                       $("#tpayinst").html(json.chnlname);
					   $("#tpayfirmerno").html(json.payfirmerno);
					   $("#tpaysecmerno").html(json.paysecmerno);
					   $("#tpayordcomtime").html(changeDate(json.payordcomtime));
					   $("#tpayordfintime").html(changeDate(json.payordfintime));
					   $("#tpayrettsnseqno").html(json.payrettsnseqno);
					   $("#tpayretcode").html(json.payretcode);
					   $("#tpayretinfo").html(json.payretinfo);
					   $("#tappordno").html(json.appordno);
					   $("#tappinst").html(json.appinst);
					   $("#tappordcommitime").html(changeDate(json.appordcommitime));
					   $("#tappordfintime").html(changeDate(json.appordfintime));
					   $("#ttradeseltxn").html(json.tradeseltxn);
					   $("#tretcode").html(json.retcode);
					   $("#tretinfo").html(json.retinfo);
					   $("#ttradestatflag").html(json.tradestatflag);
					   $("#ttradetxnflag").html(json.tradetxnflag);
					   $("#ttxncode").html(json.txncode);
					   $("#tcashcode").html(json.cashcode);
					   $("#trelate").html(json.relate);
					   $("#tretdatetime").html(changeDate(json.retdatetime));
					   $("#ttxnseqno_og").html(json.txnseqno_og);
					   $("#tnotes").html(json.notes);
					   $("#tremarks").html(json.remarks);
					   $("#taccmemberid").html(json.accmemberid);
					   $("#tapporderstatus").html(getStatus(json.apporderstatus));
					   $("#tapporderinfo").html(json.apporderinfo);
					   }
					},
				 	error : function(){
						$.messager.alert('提示', '服务异常！');
					}
				});
		}
		
		function closeAdd(){
			$('#w').window('close');
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
