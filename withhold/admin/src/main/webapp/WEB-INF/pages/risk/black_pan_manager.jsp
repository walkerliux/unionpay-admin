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
		<div id="p" class="easyui-panel" title="银行卡黑名单查询"
			style="height: 72px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="dedurateForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">银行卡号</td>
						<td align="left" style="padding-left: 5px"><input id="pan_qid" maxlength="19" /></td>
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
				<form id="theForm" method="post"
					action="pages/fee/saveFeeFeeAction.action">
					<input name="TId" id="TId" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left" id="inputForm">
						<tr>
							<td align="right" width="15%" height="50px">银行卡号</td>
							<td align="left" style="padding-left: 5px" width="25%"><input
								name="pan" id="pan" validType="minLength[16,16]"
								maxlength="19" class="easyui-validatebox" /></td>
							<td align="right" width="15%">风险等级</td>
							<td align="left" style="padding-left: 5px" width="25%"><select
								id="risklevel" class="easyui-validatebox"
								missingMessage="请选选择风险等级" required="true"
								name="risklevel" class="easyui-validatebox">
									<option value="">--请选择风险等级--</option>
									<option value="5">拒绝</option>
							</select></td>
						</tr>
						<tr>
							<td align="center" width="15%">备注</td>
							<td align="left" colspan="3">
							<textarea rows="3" cols="81" id="Notes" maxlength="64" name="notes" style="resize: none;"></textarea></td>
<!-- 							<td align="left" style="padding-left: 5px" width="25%"><input name="notes" id="Notes" maxlength="32" /></td> -->
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveBlackPan()" id="btn_submit" onclick="">保存</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
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
		var panelWidth = 640;
		var panelHeight = 230;
		var panelHoriFloat = (width - panelWidth) / 2;
		var panelVertFloat = 150;
	
		$(function() {
			$('#test').datagrid({
				title: '银行卡黑名单列表',
				singleSelect: true,
				iconCls: 'icon-save',
				height: gridHeight,
				nowrap: false,
				striped: true,
				sortName: 'FEEVER',
				url: 'risk/queryBlackPanByPage',
				remoteSort: false,
				columns: [[{
					field: 'PAN',
					title: '银行卡号',
					width: 150,
					align: 'center'
				},
				{
					field: 'RISKLEVELNAME',
					title: '银行卡风险等级',
					width: 220,
					align: 'center'
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
							return '<a href="javascript:showBlackPan(' + value + ')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:deleteblack(' + value + ')" style="color:blue;margin-left:10px">注销</a>';
						} else {
							return '<a href="javascript:startblack(' + value + ')" style="color:blue;margin-left:10px">启用</a>';
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
			var p = $('#test').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh: function() {}
			});
		});
	
		function search() {
			var data = {
				'pan': $('#pan_qid').val()
			};
			$('#test').datagrid('load', data);
		}
	
		function showAdd() {
// 			$('#theForm').clearForm();
			$('#accumulateRateForm :input').val('');
			$('#Notes').val('');
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
			$("#theForm").attr("action", "risk/saveBlackPan");
			$('#btn_submit').linkbutton('enable');
			//showRiskLevel();
		}
	
		function resize() {
			$(':input').val("");
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
		
		function showBlackPan(tid) {
			$.ajax({
				type: "POST",
				url: "risk/queryOneBlackPan",
				data: "riskId=" + tid,
				dataType: "json",
				success: function(json) {
					$("#pan").val(json.PAN);
					$("#TId").val(json.T_ID);
					$("#Notes").val(json.NOTES);
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
		  		left:panelHoriFloat,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false 
			});
			$("#theForm").attr("action", "risk/updateBlackPan");
			$('#btn_submit').linkbutton('enable');
			
		}
		
		function deleteblack(tid) {
			$.messager.confirm('提示', '您是否想要注销此银行卡黑名单?',
			function(r) {
				if (r) {
					$.ajax({
						type: "GET",
						url: "risk/deleteBlackPan",
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
		
		function startblack(tid) {
			$.messager.confirm('提示', '您是否想要启用此银行卡黑名单?',
			function(r) {
				if (r) {
					$.ajax({
						type: "GET",
						url: "risk/startBlackPan",
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

