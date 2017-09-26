<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<jsp:include page="../../top.jsp"></jsp:include>
<body>
	<style type="text/css">
table tr td {
	height: 25px
}

table tr td input {
	height: 15px
}

table tr td select {
	height: 20px
}
</style>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="查询条件" style="height: 140px; padding: 10px; background: #fafafa;" iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">会员号:</td>
						<td align="left" style="padding-left: 5px" width="10%"><input name="memberId" id="memberId" maxlength="32" /></td>
						<td align="right" rowspan="6"><a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> <a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
						</td>
					</tr>


				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>

	</div>

	<div id="w" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 800px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo" border="solid">
					<tr>
						<td whdth="40px" align="center">交易序列号</td>
						<td whdth="40px" align="center" id="txnSeqNo"></td>
						<td whdth="40px" align="center">会员号</td>
						<td whdth="40px" align="center" id="tmemberId"></td>
					</tr>
					<tr>
						<td whdth="40px" align="center">写入时间</td>
						<td whdth="40px" align="center" id="tinTime"></td>
						<td whdth="40px" align="center">应答信息</td>
						<td whdth="40px" align="center" id="reInfo"></td>
					</tr>
					<tr>
						<td whdth="40px" align="center">金额</td>
						<td whdth="40px" align="center" id="tamount"></td>
						<td whdth="40px" align="center">手续费金额</td>
						<td whdth="40px" align="center" id="fee"></td>
					</tr>
				</table>
				<br>
				<form id="firstTrial" method="post">
					<input id="tid" type="hidden" name="tid"> <input id="falg" type="hidden" name="falg"> <input id="txnSeqNo_submit" type="hidden" name="txnSeqNo">
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left" id="inputForm">
						<tr>
							<td align="center">审核意见:</td>
							<td><textarea rows="5" cols="80" name="stexaOpt"></textarea></td>
						</tr>
					</table>
				</form>

			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:firstTrial(true)" id="btn_submit" onclick="">通过</a> <a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" id="btn_submit" onclick="firstTrial(false)">拒绝</a>
			</div>
		</div>
	</div>

</body>

<script>
	var width = $("#continer").width();
	$(function() {
		$("#withdraworcheckbox").unbind();
		$('#test')
				.datagrid(
						{
							title : '审核信息表',
							iconCls : 'icon-save',
							height : 600,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'refund/queryRefundCheck',
							remoteSort : false,
							idField : 'TID',
							columns : [ [

									{
										field : 'TXNSEQNO',
										title : '交易序列号',
										width : 160,
										align : 'center'
									},
									{
										field : 'MEMBERID',
										title : '会员号',
										width : 160,
										align : 'center'
									},
									{
										field : 'BUSITYPE',
										title : '业务类型',
										width : 100,
										align : 'center'
									},
									{
										field : 'AMOUNT',
										title : '金额(元)',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {
											return value / 100;
										}
									},
									{
										field : 'FEE',
										title : '手续费金额(元)',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {
											return value / 100;
										}
									},

									{
										field : 'STATUS',
										title : '状态',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {

											if (value == '01') {
												return '待审核';
											} else if (value == '09') {
												return '初审未过';
											} else if (value == '11') {
												return '待复审';
											} else if (value == '19') {
												return '审核未过';
											} else if (value == '21') {
												return '等待批处理';
											} else if (value == '29') {
												return '批处理失败';
											} else if (value == '00') {
												return '审核成功';
											} else if (value == '39') {
												return '自行终止';
											} else {
												return '';
											}
										}
									},
									{
										field : 'TRANSRESULT',
										title : '交易结果',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {
											if (value == '00') {
												return '成功';
											} else {
												return '失败';
											}
										}
									},
									{
										field : 'REINFO',
										title : '应答信息',
										width : 160,
										align : 'center'
									},
									{
										field : 'INTIME',
										title : '写入时间',
										width : 120,
										align : 'center'
									},

									{
										field : 'TID',
										title : '操作',
										width : 160,
										align : 'center',
										formatter : function(value, rec) {
											if (rec.TXNSEQNO != null) {
												return '<a href="javascript:getCheck(\''
														+ rec.TID
														+ '\')" style="color:blue;margin-left:10px">审核</a>';
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
			"memberId" : $('#memberId').val(),
		}
		$('#test').datagrid('load', data);
	}

	// 清空
	function resize() {
		$('#theForm :input').val('');
	}

	function closeAdd() {

		$('#w').window('close');
	}

	function firstTrial(falg) {
		$("#firstTrial").attr("action", "refund/checkRefund");
		if (falg == true) {
			$("#falg").val(true);
		} else {
			$("#falg").val(false);
		}

		$('#firstTrial').form('submit', {
			onSubmit : function() {
				if ($('#tamount').val().length > 10) {
					$.messager.alert('提示', '超过最大金额');
				}
				if ($('#firstTrial').form('validate')) {
					$('#btn_submit').linkbutton('disable');
					return true;
				}
				return false;
			},
			success : function(data) {
				data = JSON.parse(data);
				if (typeof (data.RET) == "undefined") {
					$.messager.alert("", "系统服务异常，无法完成审核！", "error");
				} else if (data.RET == 'succ') {
					$.messager.alert("", data.INFO, "info");
					closeAdd();
					search();
				} else {
					$.messager.alert("", data.INFO, "error");
					$("#btn_submit").linkbutton('enable');
				}
			}
		});
	}

	function showAdds() {

		$('#w').window({
			title : '单笔审核',
			top : 100,
			width : 800,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : true,
			shadow : false,
			closed : false,
			height : 275
		});

		$("#firstTrial")[0].reset();
		$("#btn_submit").linkbutton('enable');
	}

	// 获取审核详情
	function getCheck(tid) {
		var isok = false;
		$.ajax({
			type : "POST",
			url : "refund/queryRefundCheckDetail?falg=first",
			data : {
				"tid" : tid
			},
			dataType : "json",
			async : false,
			success : function(json) {
				if (json == '' || json == undefined || json == null) {
					$.messager.alert('提示', "数据不正确，请刷新后重试");
				} else {

					$("#txnSeqNo").html(json.TXNSEQNO);
					$("#tmemberId").html(json.MEMBERID);
					$("#tinTime").html(json.INTIME);
					$("#reInfo").html(json.REINFO);
					$("#tamount").html(json.AMOUNT / 100 + "(元)");
					$("#fee").html(json.FEE / 100 + "(元)");
					$("#tid").val(json.TID);
					$("#txnSeqNo_submit").val(json.TXNSEQNO);

					isok = true;

				}
			}
		});
		if (isok == true) {
			showAdds();
		} else {
			$.messager.alert('提示', "数据不存在或者内部错误");
		}

	}
</script>
</html>
