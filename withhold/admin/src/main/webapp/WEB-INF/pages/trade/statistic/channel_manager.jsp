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
						<td align="right" width="10%">通道号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input name="payinst" id="payinst" /></td>
						
					
					
						<td align="right" width="10%">交易状态</td>
						<td align="left" style="padding-left: 5px" width="15%">
						<select name="retcode"
							id="retcode" style="width: 150px">
								<option value="">--请选择订单状态--</option>
								<option value="0000">成功</option>
								<option value="01">失败</option>
						</select></td>
						
					</tr>
				
					<tr> 
						 <td align="right" width="15%">开始时间</td>
						<td align="left" style="padding-left: 5px" width="25%">
							<input id="stime" name="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox" data-options="showSeconds:true" ></input> 
						</td> 
						 <td align="right" width="15%">截止时间</td>
						 <td align="left" style="padding-left: 5px" width="25%">
						 	<input id="etime" name="etime" type="text"
							style="width: 120PX" class="easyui-datetimebox" data-options="showSeconds:true" ></input> 
						<td></td>
						<td align="right" width="10%"></td>
						<!-- <td align="left" style="padding-left: 5px" width="15%"></td> -->
						<!-- <td align="left">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td> -->
						<td align="right">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
						
						
						</td>
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
	
</body>

<script>
	var width = $("#continer").width();
	$(function() {
		$('#test')
				.datagrid(
						{
							title : '通道统计列表',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'statistic/getChnlByPage',
							remoteSort : false,
							idField : 'ORGAN_ID',
							columns : [ [
								
									{
										field : 'payinst',
										title : '通道号',
										width : 120,
										align : 'center'
									},
									{
										field : 'chnlname',
										title : '通道名称',
										width : 110,
										align : 'center'
									},
									{
										field : 'total',
										title : '交易笔数',
										width : 90,
										align : 'center'
									}, 
									{
										field : 'amount',
										title : '交易金额',
										width : 80,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.amount);
										}
									},
									{
										field : 'txnfee',
										title : '商户手续费 ',
										width : 90,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.txnfee);
										}
									},
									{
										field : 'TRANSTIME',
										title : '渠道收益',
										width : 90,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.txnfee-rec.coopfee);
										}
									},
									{
										field : 'chnlfee',
										title : '通道收益',
										width : 90,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.chnlfee);
										}
									},
									{
										field : 'DEBTORACCOUNTNO',
										title : '银联收益',
										width : 90,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.coopfee-rec.chnlfee);
										}
									} ,
								
									{
										field : 'id',
										title : '操作',
										width : 100,
										align : 'center',
										formatter: function (value, rec,index) { //参数row表示当前行, 参数index表示当前行的索引值  
						                        //row.Id表示这个button按钮所在的那一行的Id这个字段的值  
						                        //var btn = '<input type="button" id='+index+' value="查询详情"  onclick="return LoadUserInfo('+rec.accsecmerno+')"/>';  
						                        return "点击查询详情";  
						                    } 
									} ] ],
							pagination : true,
							rownumbers : true,
							onClickRow: function (index, row) { 
								var payinst= row["payinst"];
								var retcode = $('#retcode').val();
								var stime = $('#stime').datebox('getValue');
								var etime = $('#etime').datebox('getValue');
								$('#detailInfo').datagrid({
									title:'商户统计列表详情',
									
									height:400,
									singleSelect:true,
									nowrap: false,
									striped: true,
									url:"statistic/getTnxLogInfoByPayinst?payinst="
										+ payinst + "&retcode=" + retcode + "&stime="
										+ stime + "&etime=" + etime,
									remoteSort: false,
									idField:'TID',
									columns:[
									[
										{field:'accsecmerno',title:'系统商户',width:180,align:'center'},
										{field:'memberName',title:'商户名称',width:144,align:'center'},
										{field:'accordno',title:'商户订单',width:144,align:'center'},
										{field:'paysecmerno',title:'外部商户号',width:146,align:'center'},
										{field:'payinst',title:'通道号',width:90,align:'center',},
										{field:'chnlname',title:'通道名称',width:148,align:'center'},
										{field:'payordno',title:'通道订单',width:200,align:'center'},
										{field:'accfirmerno',title:'渠道号',width:100,align:'center'},
										{field:'caname',title:'渠道名称',width:152,align:'center',},
										{field:'retdatetime',title:'交易时间',width:100,align:'center'},
										{field:'retcode',title:'交易状态码',width:100,align:'center'},
										{field:'tradeelement',title:'交易要素 ',width:158,align:'center'},
										{
											field : 'amount',
											title : '交易金额',
											width : 80,
											align : 'center',
											formatter : function(value, rec) {
												return fenToYuan(rec.amount);
											}
										},
										{
											field : 'txnfee',
											title : '商户手续费 ',
											width : 90,
											align : 'center',
											formatter : function(value, rec) {
												return fenToYuan(rec.txnfee);
											}
										},
										{
											field : 'TRANSTIME',
											title : '渠道收益',
											width : 90,
											align : 'center',
											formatter : function(value, rec) {
												return fenToYuan(rec.txnfee-rec.coopfee);
											}
										},
										{
											field : 'chnlfee',
											title : '通道收益',
											width : 90,
											align : 'center',
											formatter : function(value, rec) {
												return fenToYuan(rec.chnlfee);
											}
										},
										{
											field : 'DEBTORACCOUNTNO',
											title : '银联收益',
											width : 90,
											align : 'center',
											formatter : function(value, rec) {
												return fenToYuan(rec.coopfee-rec.chnlfee);
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
			"payinst" : $('#payinst').val(),
			"retcode" : $('#retcode').val(),
			
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}

	function resize() {
		$('#theForm :input').val('');
	}

	function queryDetail(txnseqno) {
		$("#msgid").html("");
		$("#txid").html("");
		$("#transmitleg").html("");
		$("#receiver").html("");
		$("#transdate").html("");
		$("#transtime").html("");
		$("#debtorname").html("");
		$("#debtoraccountno").html("");
		$("#debtorbranchcode").html("");
		$("#creditorbranchcode").html("");
		$("#creditorname").html("");
		$("#creditoraccountno").html("");
		$("#amount").html("");
		$("#purposeproprietary").html("");
		$("#endtoendidentification").html("");
		$("#summary").html("");
		$("#billnumber").html("");
		$("#rspmsgid").html("");
		$("#rspstatus").html("");
		$("#rsprejectcode").html("");
		$("#rsprejectinformation").html("");
		$("#rspdate").html("");
		$("#nettingdate").html("");
		$("#commsgid").html("");
		$("#comstatus").html("");
		$("#comrejectcode").html("");
		$("#comrejectinformation").html("");
		$("#comdate").html("");
		$("#txnseqno").html("");
		$("#notes").html("");
		$("#remarks").html("");
		
		$.ajax({
			   type: "POST",
			   url: "statistic/getSingleById",
			   data: "txnseqno="+txnseqno,
			   async: false,
			   dataType:"json",
			   success: function(json){
				   if(json!=null){
						$("#user_code").val(json.userCode);
						$("#user_code").attr('readonly','readonly');
						$("#user_code").css('background-color','#D2D2D2');
						$("#user_name").val(json.userName);
						$("#user_loginName").val(json.loginName);
						$("#user_organId").val(json.organId);
						$("#user_status").val(json.status);
						$("#user_isadmin").val(json.isadmin);
						$("#user_id").val(json.userId);
						$("#user_notes").val(json.notes);
			   		}
			   },
			   error : function(){
					$.messager.alert('提示', '服务异常！');
				}
			});
	/* 	$('#w').window({
			title : '商户统计详细信息',
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
		}); */
		/* var rows = $('#test').datagrid('getSelected');
		$("#msgid").html(rows["MSGID"]);
		$("#txid").html(rows["TXID"]);
		$("#transmitleg").html(rows["TRANSMITLEG"]);
		$("#receiver").html(rows["RECEIVER"]);
		$("#tradetype").html(rows["TRADETYPE"]);
		$("#transdate").html(changeDate(rows["TRANSDATE"]));
		$("#transtime").html(changeTime(rows["TRANSTIME"]));
		$("#debtorname").html(rows["DEBTORNAME"]);
		$("#debtoraccountno").html(rows["DEBTORACCOUNTNO"]);
		$("#debtorbranchcode").html(rows["DEBTORBRANCHCODE"]);
		$("#creditorbranchcode").html(rows["CREDITORBRANCHCODE"]);
		$("#creditorname").html(rows["CREDITORNAME"]);
		$("#creditoraccountno").html(rows["CREDITORACCOUNTNO"]);
		$("#amount").html(fenToYuan(rows["AMOUNT"]));
		$("#purposeproprietary").html(rows["PURPOSEPROPRIETARY"]);
		$("#endtoendidentification").html(rows["ENDTOENDIDENTIFICATION"]);
		$("#summary").html(rows["SUMMARY"]);
		$("#billnumber").html(rows["BILLNUMBER"]);
		$("#rspmsgid").html(rows["RSPMSGID"]);
		$("#rspstatus").html(analysisStatus(rows["RSPSTATUS"]));
		$("#rsprejectcode").html(rows["RSPREJECTCODE"]);
		$("#rsprejectinformation").html(rows["RSPREJECTINFORMATION"]);
		$("#rspdate").html(changeDateTime(rows["RSPDATE"]));
		$("#nettingdate").html(changeDate(rows["NETTINGDATE"]));
		$("#commsgid").html(rows["COMMSGID"]);
		$("#comstatus").html(analysisStatus(rows["COMSTATUS"]));
		$("#comrejectcode").html(rows["COMREJECTCODE"]);
		$("#comrejectinformation").html(rows["COMREJECTINFORMATION"]);
		$("#comdate").html(changeDateTime(rows["COMDATE"]));
		$("#txnseqno").html(rows["TXNSEQNO"]);
		$("#notes").html(rows["NOTES"]);
		$("#remarks").html(rows["REMARKS"]); */
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
	function fenToYuan(value){
			var str = (value/100).toFixed(2) + '';
			var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
			var dot = str.substring(str.length,str.indexOf("."))
			var ret = intSum + dot;
			return ret;
		}
	function closeAdd(){
		$('#w').window('close');
	}
</script>
</html>
