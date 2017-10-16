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
			collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">商户号</td>
						<td align="left" style="padding-left: 5px"><input
							id="merids" /></td>
						<td align="right">批次号</td>
						<td align="left" style="padding-left: 5px"><input
							id="batchnos"  /></td>
					</tr>
					<tr>
						<td align="right">受理批次号</td>
						<td align="left" style="padding-left: 5px"><input
							id="tns" /></td>
						<td align="right" width="10%">起止时间</td>
						<td colspan = "2" style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox" data-options="showSeconds:true" name="stime"></input> 
							至<input id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:true"
							name="etime"></input></td>
						<td style="padding-left: 5px"></td>
						<td align="right"><a href="javascript:search()"
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
		 style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" id="continer"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo"
					border="1">
					<tr>
						<td colspan="4" class="head-title">接口参数</td>
					</tr>
					<tr>
						<td width="15%">版本</td><td width="35%" id="version"></td>
						<td width="15%">编码方式</td><td width="35%" id="encoding"></td>
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
						<td>批次号</td><td id="batchno"></td>
						<td>批次交易时间</td><td id="txntime"></td>
					</tr>
					<tr>
						<td>委托机构号</td><td id="merid"></td>
						<td>委托机构名称</td><td id="mername"></td>
					</tr>
					<tr>
						<td>总笔数</td><td id="totalqty"></td>
						<td>总金额 (元)</td><td id="totalamt"></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">批次处理信息</td>
					</tr>
					<tr>
						<td>响应码</td><td id="respcode"></td>
						<td>应答信息</td><td id="respmsg"></td>
					</tr>
					<tr>
						<td>订单提交时间</td><td id="ordercommitime"></td>
						<td>异步通知结果</td><td id="syncnotify"></td>
					</tr>
					<tr>
						<td>状态</td><td id="status"></td>
						<td>通知地址</td><td id="backurl"></td>
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
							title : '批量代收批次列表',
							
							height : 400,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getBatchOrderByPage',
							remoteSort : false,
							idField : 'MSGID',
							columns : [ [
								{field:'tn',title:'受理批次号',width:180,align:'center'},    
								{field:'merid',title:'商户号',width:123,align:'center'},
								{field:'batchno',title:'批次号',width:180,align:'center'},
								{field:'totalqty',title:'总笔数',width:132,align:'center'},
								{field:'totalamt ',title:'总金额 (元)',width:133,align:'center',
									formatter:function(value,rec){
										return fenToYuan(rec.totalamt);
									}
								},
								{field:'time',title:'交易时间',width:150,align:'center',
									formatter : function(value, rec) {
										return changeDate(rec.txndate+rec.txntime);
									}	
								},
								{field:'status',title:'状态',width:137,align:'center',
									formatter : function(value, rec) {
										if (rec.status == "00") {
											return "交易完成";
										} 
										if (rec.status == "01") {
											return "批次提交成功";
										} 
										if (rec.status == "02") {
											return "交易中";
										} 
										if (rec.status == "03") {
											return "交易失败";
										} 
										if (rec.status == "04") {
											return "批次失效";
										} 
									}		
								},
								
								/* {field:'SYNCNOTIFY',title:'异步通知结果',width:139,align:'center'}, */
								{field:'id',title:'操作',width:120,align:'center',
									formatter:function(value,rec){
										return '<a href="javascript:queryDetail(\''+rec.batchno+'\')" style="color:blue;margin-left:10px">详细信息</a>';
									}
								}
							] ],
							pagination : true,
							rownumbers : true,
							
							onClickRow: function (index, row) { 
								var batchno= row["batchno"];
								$('#detailInfo').datagrid({
									title:'批量代收明细表',
									
									height:400,
									singleSelect:true,
									nowrap: false,
									striped: true,
									url:'trade/getCollectOrderDetaByBatchNo?batchno='+batchno,	
									remoteSort: false,
									idField:'TID',
									columns:[
									[
										{field:'batchno',title:'批次号',width:180,align:'center'},
										{field:'orderid',title:'订单号',width:144,align:'center'},
										{field:'amt',title:'单笔金额(元)',width:146,align:'center',
											formatter:function(value,rec){
												return fenToYuan(rec.amt);
											}
										},
										{field:'currencycode',title:'交易币种',width:90,align:'center',
											formatter : function(value, rec) {
												if (rec.currencycode == "156") {
													return "人民币";
												} 
											}
										},
										 /* field:'DEBTORCONSIGN',title:'合同号',width:150,align:'center'}, */ 
										{field:'cardno',title:'交易卡号',width:148,align:'center'},
										{field:'customernm',title:'持卡人姓名',width:200,align:'center'},
										{field:'bankcode',title:'卡属银行号',width:100,align:'center'},
										{field:'cardtype',title:'卡属类型',width:152,align:'center',
											formatter : function(value, rec) {
												if (rec.cardtype == "1") {
													return "借记卡";
												} 
												if (rec.cardtype == "2") {
													return "信用卡";
												}
											}	
										},
										{field:'respcode',title:'响应码',width:100,align:'center'},
										{field:'respmsg',title:'应答信息',width:100,align:'center'},
										{field:'relatetradetxn',title:'交易序列号',width:158,align:'center'},
										{field:'status',title:'状态',width:159,align:'center',
											formatter : function(value, rec) {
												if (rec.status == "00") {
													return "交易完成";
												} 
												if (rec.status == "01") {
													return "订单提交成功";
												} 
												if (rec.status == "02") {
													return "交易中";
												} 
												if (rec.status == "03") {
													return "交易失败";
												} 
												if (rec.status == "04") {
													return "批次失效";
												} 
											}		
										},
									]],
									pagination:true,
									rownumbers:true,
								});
							}

						});

	});

	function search() {
		var data = {
				"batchno" : $('#batchnos').val(),
				"merid" : $('#merids').val(),
				"tn" : $('#tns').val(),
				"stime" : $('#stime').datebox('getValue'),
				"etime" : $('#etime').datebox('getValue')
		};
		/* alert( $('#stime').datebox('getValue')); */
		$('#test').datagrid('load', data);
	}
	
	function resize(){
		$('#theForm :input').val('');
	}
	
	function queryDetail(batchNo){
		$("#tid").html("");
		$("#accesstype").html("");
		$("#coopinstiid").html("");
		$("#merid").html("");
		$("#version").html("");
		$("#encoding").html("");
		$("#txntype").html("");
		$("#txnsubtype").html("");
		$("#biztype").html("");
		$("#backurl").html("");
		$("#batchno").html("");
		$("#txntime").html("");
		$("#totalqty").html("");
		$("#totalamt ").html("");
		$("#reserved").html("");
		$("#respcode").html("");
		$("#respmsg").html("");
		$("#status").html("");
		$("#ordercommitime").html("");
		$("#syncnotify").html("");
		$("#notes").html("");
		$("#remarks").html("");
		   
		$('#w').window({
			title: '代收批次详细信息',
			top:90,
			left:100,
			width:900,
			modal: true,
			minimizable:false,
			collapsible:false,
			maximizable:false,
			shadow: false,
			closed: false,
			height: 420
		});
		function getStatus(value){
			if (value == "00") {
				return "交易完成";
			} 
			if (value == "01") {
				return "订单提交成功";
			} 
			if (value == "02") {
				return "交易中";
			} 
			if (value == "03") {
				return "交易失败";
			} 
			if (value == "04") {
				return "批次失效";
			} 
		}
		var rows = $('#test').datagrid('getSelected');
		$("#tid").html(rows["tid"]);
		$("#accesstype").html(rows["accesstype"]);
		$("#coopinstiid").html(rows["coopinstiid"]);
		$("#merid").html(rows["merid"]);
		$("#version").html(rows["version"]);
		if (rows["encoding"] == "1") {
			$("#encoding").html("UTF-8");
		}
		$("#txntype").html(rows["txntype"]);
		$("#txnsubtype").html(rows["txnsubtype"]);
		$("#biztype").html(rows["biztype"]);
		$("#backurl").html(rows["backurl"]);
		$("#batchno").html(rows["batchno"]);
		$("#txntime").html(changeDate(rows["txndate"]+rows["txntime"]));
		$("#totalqty").html(rows["totalqty"]);
		$("#totalamt ").html(fenToYuan(rows["totalamt"]));
		$("#reserved").html(rows["reserved"]);
		$("#respcode").html(rows["respcode"]);
		$("#respmsg").html(rows["respmsg"]);
		$("#status").html(getStatus(rows["status"]));
		$("#ordercommitime").html(changeDate(rows["ordercommitime"]));
		$("#syncnotify").html(rows["syncnotify"]);
		$("#notes").html(rows["notes"]);
		$("#remarks").html(rows["remarks"]);
		$("#mername").html(rows["mername"]);
	}
	function fenToYuan(value){
		var str = (value/100).toFixed(2) + '';
		var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
		var dot = str.substring(str.length,str.indexOf("."));
		var ret = intSum + dot;
		return ret;
	}
	function closeAdd(){
		$('#w').window('close');
	}	
</script>
</html>
