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
						<td align="right" width="10%">商户号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="transmitleg" id="transmitlegs"  /></td>
						<td align="right" width="10%">批次号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="batchno" id="batchnos"  /></td>
						<td align="left" style="padding-left: 5px" width="15%"></td>
					</tr>
					<tr>
						<td align="right">受理批次号</td>
						<td align="left" style="padding-left: 5px"><input
							id="tns" /></td>
							
						<td align="right" width="10%">起止时间</td>
						<td colspan="2" style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:true" name="stime"></input> 至<input
							id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:true"
							name="etime"></input></td>
						<td align="right" width="10%"></td>
						<td  style="padding-left: 5px" ></td>
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
		 style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" id="continer"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo"
					border="1">
					<tr>
						<td colspan="4" class="head-title">详细信息</td>
					</tr>
					<tr>
						<td width="15%">受理批次号</td><td width="35%" id="tn"></td>					
						<td width="15%">批次号</td><td width="35%" id="batchno"></td>
					</tr>
					<tr>						
						<td>总笔数</td><td id="totalnum"></td>
						<td>总金额</td><td id="totalamt"></td>
					</tr>
					<tr>
						<td>成功笔数</td><td id="succnum"></td>
						<td>成功金额</td><td id="succamt"></td>
					</tr>
					<tr>						
						<td>失败笔数</td><td id="failnum"></td>
						<td>失败金额</td><td id="failamt"></td>
					</tr>
					<!-- <tr>
						<td colspan="4" class="head-title">批次信息</td>
					</tr> -->
					<tr>
						<td>插入时间</td><td id="intime"></td>
						<td>上传应答时间</td><td id="uploadresptime"></td>
					</tr>
					<tr>						
						<td>回盘通知时间</td><td id="noticetime"></td>
						<td>交易完成时间</td><td id="finishtime"></td>
						
					</tr>
					<tr>
						<td>上传文件错误码</td><td id="uploadrespcode"></td>					
						<td>上传文件错误信息</td><td id="uploadrespmessage"></td>
					</tr>
					<tr>
						<td>回盘文件错误码</td><td id="hprespcode"></td>					
						<td>回盘文件错误信息</td><td id="hprespmessage"></td>
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
			<div region="center" border="false" id="continer"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="detailinfo"
					border="1">
					<tr>
						<td colspan="4" class="head-title">详细信息</td>
					</tr>
					<tr>
						<td width="15%">批次号</td><td width="35%"><span id="tbatchno"></span></td>					
						<td width="15%">订单号</td><td width="35%"><span id="orderno"></span></td>
					</tr>
					<tr>						
						<td>开户行号</td><td><span id="openbankid"></span></td>
						<td>卡折标志</td><td><span id="cardtype"></span></td>
					</tr>
					
					<tr>
						<td>卡号/折号</td><td><span id="cardno"></span></td>
						<td>持卡人姓名</td><td><span id="usrname"></span></td>
					</tr>
					<tr>						
						<td>证件类型</td><td><span id="certtype"></span></td>
						<td>证件号</td><td><span id="certid"></span></td>
					</tr>
					<tr>
						<td>币种</td><td><span id="curyid"></span></td>
						<td>金额</td><td><span id="transamt"></span></td>
					</tr>
					<tr>
						<td>用途</td><td><span id="purpose"></span></td>	
						<td>应答信息</td><td><span id="responsecode"></span></td>
					</tr>
					<tr>						
						<td>私有域</td><td><span id="priv1"></span></td>
						<td>额外域</td><td><span id="extfield"></span></td>
						
					</tr>
					<!-- <tr>
						<td>附言</td><td colspan="3"><span id="POSTSCRIPT"></span></td>
					</tr> -->
					<tr>
						<td>描述</td><td><span id="message"></span></td>				
						
					</tr>
					<tr>
						<td>更新时间</td><td><span id="uptime"></span></td>					
						<td>插入时间</td><td><span id="intimes"></span></td>
					</tr>
					
					<!-- <tr>
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
					</tr> -->
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
							title : '批量代收渠道批次列表',
							height : 400,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getChnCollectBatchLogByPage_bak',
							remoteSort : false,
							idField : 'MSGID',
							columns : [ [
								{field:'tn',title:'受理批次号',width:130,align:'center'},
								{field:'merid',title:'商户号',width:90,align:'center'},
								{field:'filename',title:'文件名',width:90,align:'center'},
								{field:'hpfilename',title:'回盘文件名',width:90,align:'center'},
								{field:'batchno',title:'批次号',width:130,align:'center'},
								{field:'totalnum',title:'总笔数',width:120,align:'center'},
								{field:'totalamt',title:'总金额（元）',width:120,align:'center',
									formatter : function(value, rec) {
										return fenToYuan(rec.totalamt);
									}
								},
								{field:'succnum',title:'成功笔数',width:120,align:'center'},
								{field:'succamt',title:'成功金额（元）',width:120,align:'center',
									formatter : function(value, rec) {
										return fenToYuan(rec.succamt);
									}
								},
								{field:'failnum',title:'失败笔数',width:120,align:'center'},
								{field:'failamt',title:'失败金额（元）',width:120,align:'center',
									formatter : function(value, rec) {
										return fenToYuan(rec.failamt);
									}
								},
								{field:'intime',title:'交易时间',width:120,align:'center'
									/* formatter : function(value, rec) {
										return changeDateTime(rec.finishtime);
									}
									 */
								},
								{field:'ID',title:'操作',width:120,align:'center',
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
									title:'批量代收渠道批次明细列表',
									height:400,
									singleSelect:true,
									nowrap: false,
									striped: true,
									url:'trade/getChnCollectDetaByBatchNo_bak?batchno='+batchno,	
									remoteSort: false,
									idField:'TID',
									columns:[
									[
										{field:'batchno',title:'批次号',width:130,align:'center'},
										{field:'txnseqno',title:'交易流水号',width:90,align:'center'},
										{field:'orderno',title:'订单号',width:90,align:'center'},
										{field:'transdate',title:'提交日期',width:90,align:'center',
											formatter : function(value, rec) {
												return changeDate(rec.transdate);
											}	
										},
										{field:'cardno',title:'付款账号',width:140,align:'center'},
										{field:'usrname',title:'付款账户名称',width:120,align:'center'},
										{field:'certid',title:'证件号',width:140,align:'center'},
										{field:'transamt',title:'金额（元）',width:120,align:'center',
											formatter : function(value, rec) {
												return fenToYuan(rec.transamt);
											}
										},
										/* {field:'intime',title:'插入时间',width:125,align:'center'
											
										},
										{field:'uptime',title:'更新时间',width:120,align:'center'
												
											
										},
										{field:'priv1',title:'私有域',width:130,align:'center'},
										{field:'extfield',title:'额外域',width:130,align:'center'},
										{field:'responsecode',title:'应答信息',width:130,align:'center'}, */
										{field:'ID',title:'操作',width:120,align:'center',
											formatter:function(value,rec){
												return '<a href="javascript:showBatchDetail(\''+rec.batchno+'\')" style="color:blue;margin-left:10px">详细信息</a>';
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
		//alert( $('#stime').datebox('getValue'));
		$('#test').datagrid('load', data);
	}
	
	function resize(){
		$('#theForm :input').val('');
	}
	
	function queryDetail(batchNo){
		$("#tn").html("");
		$("#filename").html("");
		$("#hpfilename").html("");
		$("#merid").html("");
		$("#batchno").html("");
		$("#totalnum").html("");
		$("#totalamt").html("");
		$("#succnum").html("");
		$("#failnum").html("");
		$("#succamt").html("");
		$("#failamt").html("");
		$("#intime").html("");
		$("#uploadresptime").html("");
		$("#noticetime").html("");
		$("#finishtime").html("");
		$("#uploadrespcode").html("");
		$("#uploadresptime").html("");
		$("#uploadrespmessage").html("");
		$("#hprespcode").html("");
		$("#hprespmessage").html("");  
		$('#w').window({
			title: '批次详细信息',
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
		$("#tid").html(rows["tid"]);
		$("#tn").html(rows["tn"]);
		$("#filename").html(rows["filename"]);
		$("#hpfilename").html(rows["hpfilename"]);
		$("#merid").html(rows["merid"]);
		$("#batchno").html(rows["batchno"]);
		$("#totalnum").html(rows["totalnum"]);
		$("#totalamt").html(fenToYuan(rows["totalamt"]));
		$("#succnum").html(rows["succnum"]);
		$("#failnum").html(rows["failnum"]);
		$("#succamt").html(fenToYuan(rows["succamt"]));
		$("#failamt").html(fenToYuan(rows["failamt"]));
		$("#intime").html(rows["intime"]);
		$("#uploadresptime").html(rows["uploadresptime"]);
		$("#noticetime").html(rows["noticetime"]);
		$("#finishtime").html(rows["finishtime"]);
		$("#uploadrespcode").html(rows["intime"]);
		$("#uploadrespmessage").html(rows["uploadresptime"]);
		$("#hprespcode").html(rows["noticetime"]);
		$("#hprespmessage").html(rows["finishtime"]);
	
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
		$("#tbatchno").html(rows["batchno"]);	
		$("#txnseqno").html(rows["txnseqno"]);	
		$("#transdate").html(changeDate(rows["transdate"]));	
		$("#orderno").html(rows["orderno"]);	
		$("#openbankid").html(rows["openbankid"]);	
		$("#cardtype").html(cardType(rows["cardtype"]));	
		$("#cardno").html(rows["cardno"]);	
		$("#usrname").html(rows["usrname"]);	
		$("#certtype").html(certType(rows["certtype"]));	
		if (rows["curyid"] == "156") {
			$("#curyid").html("人民币");
		};
		$("#certid").html(rows["certid"]);	
		/* $("#curyid").html(rows["curyid"]); */	
		$("#transamt").html(fenToYuan(rows["transamt"]));	
		$("#purpose").html(rows["purpose"]);	
			
		$("#priv1").html(rows["priv1"]);
		
		$("#responsecode").html(rows["responsecode"]);	
		$("#message").html(rows["message"]);	
		$("#intimes").html(rows["intime"]);	
		$("#uptime").html(rows["uptime"]);	
		$("#extfield").html(rows["extfield"]);	
		
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
</script>
</html>
