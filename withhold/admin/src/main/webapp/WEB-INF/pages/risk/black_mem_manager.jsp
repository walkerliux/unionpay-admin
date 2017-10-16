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
<body>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="委托机构黑名单查询"
			style="height: 72px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="dedurateForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">委托机构号</td>
						<td align="left" style="padding-left: 5px"><input
							id="merber_qid" maxlength="15" /></td>
						<td align="right">委托机构名称</td>
						<td align="left" style="padding-left: 5px"><input
							id="merbername_qid" maxlength="20" /></td>
						<td align="right" colspan=2>
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a>
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
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theForm" method="post" action="">
					<input name="TId" id="TId" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left" id="inputForm">
						<tr>
							<td align="right" width="15%" height="30px">委托机构号</td>
							<td align="left" style="padding-left: 5px" width="25%"><input
								name="memberid" id="memberid"
								validType="amount[]" maxlength="15" class="easyui-validatebox" />
							</td>
							<td align="right" width="15%" height="30px">风险等级</td>
							<td align="left" width="25%">
							<select id="risklevel" class="easyui-validatebox" missingMessage="请选选择风险等级" 
							required="true" name="risklevel"><option value="">--请选择风险等级--</option>
									<option value="5">拒绝</option>
							</select></td>
						</tr>
						<tr>
							<td align="center">备注</td>
							<td align="left" colspan="3">
							<textarea rows="3" cols="81" id="Notes" maxlength="64" name="notes" style="resize: none;"></textarea></td>
<!-- 							<td align="left" style="padding-left: 5px" width="25%"><input name="notes" id="Notes" maxlength="32" /></td> -->
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:saveWhitePan()" id="btn_submit" onclick="">保存</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel"
					href="javascript:void(0)" onclick="closeAdd()">取消</a>
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
				message: '请输入15位的委托机构号'
			}
		});
		var width = $("#continer").width();
		var gridHeight = 600;
		var panelWidth = 640;
		var panelHeight = 190;
		var panelHoriFloat = (width - panelWidth) / 2;
		var panelVertFloat = 150;
	
		$(function() {
			$('#test').datagrid({
				title: '委托机构黑名单列表',
				singleSelect: true,
				iconCls: 'icon-save',
				height: gridHeight,
				nowrap: false,
				striped: true,
				sortName: 'FEEVER',
				url: 'risk/queryBlacklistMemberByPage',
				remoteSort: false,
				columns: [[{
					field: 'MEMBERID',
					title: '委托机构号',
					width: 150,
					align: 'center'
				},
				{
					field: 'MEMBERNAME',
					title: '委托机构名称',
					width: 150,
					align: 'center'
				},
				{
					field: 'RISKLEVEL',
					title: '风险等级',
					width: 100,
					align: 'center',
					formatter: function(value, rec) {
						if (value == "1") {
							return '<span style="color:green;">' + '提示' + '</span>';
						} else if (value == "2") {
							return '<span style="color:blue;">' + '关注' + '</span>';
						} else if (value == "3") {
							return '<span style="color:#B8860B;">' + '预警' + '</span>';
						} else if (value == "4") {
							return '<span style="color:#CD3700;">' + '警告' + '</span>';
						} else if (value == "5") {
							return '<span style="color:red;">' + '拒绝' + '</span>';
						}
					}
				},
				{
					field: 'STATUS',
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
					field: 'T_ID',
					title: '操作',
					width: 150,
					align: 'center',
					formatter: function(value, rec) {
						if (rec.STATUS == "00") {
							return '<a href="javascript:showLimitMem(' + value + ')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:deleteLimitMem(' + value + ')" style="color:blue;margin-left:10px">注销</a>';
						} else {
							return '<a href="javascript:startLimitMem(' + value + ')" style="color:blue;margin-left:10px">启用</a>';
	
						}
					}
				}]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增委托机构黑名单',
					iconCls: 'icon-add',
					handler: function() {
						showAdd();
					}
				}]
			});
			var p = $('#test').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh: function() {
	
		}
			});
		});
	
		function search() {
			var data = {
				'memberid': $('#merber_qid').val(),
				'merchName': $('#merbername_qid').val()
			};
			$('#test').datagrid('load', data);
		}
	
		function showAdd() {
// 			$('#theForm').clearForm();
			$('#accumulateRateForm :input').val('');
			$('#Notes').val('');
			$("#memberid").attr("disabled", false);
			$('#w').window({
				title: '委托机构黑名单信息',
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
			$("#theForm").attr("action", "risk/saveBlacklistMember");
			$('#btn_submit').linkbutton('enable');
			//showRiskLevel();
		}
	
		function resize() {
			$(':input').val("");
		}
	
		function saveWhitePan() {
			$('#theForm').form('submit', {
				onSubmit: function() {
					if ($('#theForm').form('validate')) {
						$('#btn_submit').linkbutton('disable');
						return true;
					}
					return false;
				},
				success: function(data) {
					data=JSON.parse(data);
					var a= data.split("validateUserLoginAction");
					if(data.split("validateUserLoginAction").length>1){
						window.parent.location.replace("<%=basePath%>"+"logout?relogin=relogin");
						return ;
					}
					if (data == '添加成功!' || data == '修改成功!') {
						$.messager.alert('提示',data);
						closeAdd();
						search();
					} else {
						$.messager.alert('提示',data);
						$('#btn_submit').linkbutton('enable');
					}
				}
			});
		}
		function showRiskLevel() {
			$.ajax({
				type: "POST",
				url: "risk/queryRiskLevel",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择风险等级--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
					});
					$("#risklevel").html(html);
				}
			});
		}
		function showLimitMem(tid) {
			$.ajax({
				type: "POST",
				url: "risk/queryOneBlacklistMember",
				data: "riskId=" + tid,
				dataType: "json",
				success: function(json) {
					$("#TId").val(json.T_ID);
					$("#memberid").val(json.MEMBERID);
					$("#memberid").attr("readonly", "readnoly");
					//showRiskLevel();
					setTimeout(function() {
						$("#risklevel").val(json.RISKLEVEL);
					},
					500);
				}
			});
			$('#w').window({
				title: '修改银行卡黑名单',
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
			$("#theForm").attr("action", "risk/updateBlacklistMember");
			$('#btn_submit').linkbutton('enable');
		}
		function deleteLimitMem(tid) {
			$.messager.confirm('提示', '您是否想要注销委托机构黑名单?',
			function(r) {
				if (r) {
					$.ajax({
						type: "GET",
						url: "risk/deleteBlacklistMember",
						data: "rand=" + new Date().getTime() + "&riskId=" + tid,
						dataType: "text",
						success: function(text) {
							text=JSON.parse(text);
							$.messager.alert('提示', text);
							search();
						}
					});
				}
			});
		}
		function startLimitMem(tid) {
			$.messager.confirm('提示', '您是否想要启用委托机构黑名单?',
			function(r) {
				if (r) {
					$.ajax({
						type: "GET",
						url: "risk/startBlacklistMember",
						data: "rand=" + new Date().getTime() + "&riskId=" + tid,
						dataType: "text",
						success: function(text) {
							text=JSON.parse(text);
							$.messager.alert('提示', text);
							search();
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

