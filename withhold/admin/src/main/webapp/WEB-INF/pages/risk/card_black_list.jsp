<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
</head>
<style type="text/css">
	.left, .mid, .right {
		width: auto;
		float: left;
	}
	
	.form-control {
		border: 2px solid #A9C9E2;
	}
	
	.mid {
		padding-top: 45px;
		padding-left: 12px;
		padding-right: 12px;
	}
</style>
<body>
	<style type="text/css">
		table tr td.head-title {
			height: 25px;
			background-color: #F0F8FF;
			font-weight: bold;
			border-width: 1px 1px 1px 1px;
			border-style: groove;
		}
		
		table tr td.update {
			height: 25px;
			padding-left: 10px;
			border-width: 1px 1px 1px 1px;
			border-style: groove;
		}
		
		table tr td.add {
			height: 25px;
		}
		
		table tr td input {
			height: 15px;
		}
		
		table tr td select {
			height: 20px
		}
	</style>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="银行卡黑名单查询"
			style="height: 72px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="searchForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">银行卡号</td>
						<td align="left" style="padding-left: 5px"><input id="pan_s" maxlength="19" /></td>
						<td align="right" colspan=2>
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a>
						</td>
					</tr>


				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="cardBlackList"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theForm" method="post" action="">
					<input name="tid" id="tid" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%">银行卡号</td>
							<td class="update" align="left">
								<input name="pan" id="pan" validType="minLength[16,16]"
								maxlength="19" class="easyui-validatebox" required="required" missingMessage="请输入银行卡号"/></td>
							<td class="update" width="15%">风险等级</td>
							<td class="update" align="left">
								<select id="risklevel" class="easyui-validatebox"
									missingMessage="请选择风险等级" required="true"
									name="risklevel" class="easyui-validatebox">
									<option value="">--请选择风险等级--</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="90" id="notes" maxlength="128" name="notes" style="resize: none;"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveBlackPan()" id="btn_submit" onclick="">保存</a>
			</div>
		</div>
	</div>
</body>

<script>
		$.extend($.fn.validatebox.defaults.rules, {
			minLength: {
				validator: function(value, param) {
					var re = /^\d+$/;
					if (!re.test(value)) {
						return false;
					}
					return value.length >= param[0];
				},
				message: '请输入16-19位数字的银行号'
			}
		});
		
		var width = $("#continer").width();
		var gridHeight = 600;
		var panelWidth = 750;
		var panelHeight = 235;
		var panelHoriFloat = (width - panelWidth) / 2;
		var panelVertFloat = 150;
	
		$(function() {
			$('#cardBlackList').datagrid({
				title: '银行卡黑名单列表',
				singleSelect: true,
				iconCls: 'icon-save',
				height: gridHeight,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url: 'risk/queryCardBlackList',
				remoteSort: false,
				columns: [[{
					field: 'pan',
					title: '银行卡号',
					width: 200,
					align: 'center'
				},
				{
					field: 'riskLevelName',
					title: '银行卡风险等级',
					width: 100,
					align: 'center'
				},
				{
					field: 'status',
					title: '状态',
					width: 100,
					align: 'center',
					formatter: function(value, rec) {
						if (value == "00") {
							return "使用";
						} else {
							return "注销";
						}
					}
				},
				{
					field: 'tid',
					title: '操作',
					width: 150,
					align: 'center',
					formatter: function(value, rec) {
						if (rec.status == "00") {
							return '<a href="javascript:showBlackPan(' + value + ')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:logoutCardBlackList(' + value + ')" style="color:blue;margin-left:10px">注销</a>';
						} else {
							return '<a href="javascript:startCardBlackList(' + value + ')" style="color:blue;margin-left:10px">启用</a>';
						}
					}
				}]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增银行卡黑名单',
					iconCls: 'icon-add',
					handler: function() {
						showAdd();
					}
				}]
			});
			var p = $('#cardBlackList').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh: function() {}
			});
		});
	
		function search() {
			var data = {
				'pan': $('#pan_s').val()
			};
			$('#cardBlackList').datagrid('load', data);
		}
	
		function showAdd() {
			$('#riskver').attr("readonly", false);
			$('#theForm :input').val('');
			$("#theForm").attr("action", "risk/addCardBlackList");
			$('#btn_submit').linkbutton('enable');
			showRiskLevel();
			$('#w').window({
				title: '银行卡黑名单信息',
				top: panelVertFloat, 
		  		width: panelWidth,
		  		height: panelHeight,
		  		left:panelHoriFloat,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false
			});
		}
	
		function resize() {
			$('searchForm :input').val("");
		}
	
		function saveBlackPan() {
			$('#theForm').form('submit', {
				onSubmit: function() {
					if ($('#theForm').form('validate')) {
						$('#btn_submit').linkbutton('disable');
						return true;
					}
					return false;
				},
				success: function(data) {
					$('#btn_submit').linkbutton('enable');
					json=JSON.parse(data);
					if(json.resultBool==true){
						 $.messager.alert('提示',"保存成功！");
						 closeAdd();
						 search();
					}else{
						 $.messager.alert('提示',json.errMsg);
					}
				}
			});
		}
		
		function showRiskLevel(risklevel) {
			$.ajax({
				type: "POST",
				url: "risk/showAllRisklevel",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择风险等级--</option>";
					$.each(json, function(key, value) {
						if (value.paraCode == risklevel) {
							html += '<option value="' + value.paraCode + '" selected="selected">' + value.paraName + '</option>';
						} else {
							html += '<option value="' + value.paraCode + '">' + value.paraName + '</option>';
						}
					});
					$("#risklevel").html(html);
				}
			});
		}
		
		function showBlackPan(tid) {
			$('#pan').attr("readonly", true);
			$('#theForm :input').val('');
			$("#theForm").attr("action", "risk/updateCardBlackList");
			$('#btn_submit').linkbutton('enable');
			$.ajax({
				type: "POST",
				url: "risk/queryCardBlackListByTid",
				data: "tid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#pan").val(json.pan);
					$("#tid").val(json.tid);
					$("#notes").val(json.notes);
					showRiskLevel(json.risklevel)
				}
	
			});
			$('#w').window({
				title: '修改银行卡黑名单',
				top: panelVertFloat, 
		  		width: panelWidth,
		  		left:panelHoriFloat,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false 
			});
		}
		
		function logoutCardBlackList(tid) {
			$.messager.confirm('提示', '您是否想要注销此银行卡黑名单?',
			function(r) {
				if (r) {
					$.ajax({
						type : "POST",
						url : "risk/logoutCardBlackList",
						dataType : "json",
						data : {
							"tid" : tid
						},
						success : function(json) {
							if (json.resultBool == true) {
								$.messager.alert('提示', "注销成功！");
								$('#w').window('close');
								search();
							} else {
								$.messager.alert('提示', json.errMsg);
							}
						},
						error : function() {
							$.messager.alert('提示', '服务异常！');
						}
					});
				}
			});
		}
		
		function startCardBlackList(tid) {
			$.messager.confirm('提示', '您是否想要启用此银行卡黑名单?',
			function(r) {
				if (r) {
					$.ajax({
						type : "POST",
						url : "risk/startCardBlackList",
						dataType : "json",
						data : {
							"tid" : tid
						},
						success : function(json) {
							if (json.resultBool == true) {
								$.messager.alert('提示', "启用成功！");
								$('#w').window('close');
								search();
							} else {
								$.messager.alert('提示', json.errMsg);
							}
						},
						error : function() {
							$.messager.alert('提示', '服务异常！');
						}
					});
				}
			});
		}
		
		function closeAdd() {
			$('#w').window('close');
		}
</script>
</html>

