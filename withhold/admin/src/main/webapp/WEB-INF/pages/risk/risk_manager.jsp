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
		<div id="p" class="easyui-panel" title="风控版本查询"
			style="height: 72px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="dedurateForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">风控版本代码</td>
						<td align="left" style="padding-left: 5px"><input
							name="riskver" id="riskver_qid" maxlength="8" /></td>
						<td align="right">风控版本名称</td>
						<td align="left" style="padding-left: 5px"><input
							name="riskname" id="riskname_qid" maxlength="128" /></td>
						<td align="right" colspan=2><a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="riskList"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theForm" method="post" action="">
					<input name="riskid" id="riskid" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr  style="height: 25px">
							<td class="update">风控版本代码</td>
							<td class="update" align="left">
							<input type="text" name="riskver" id="riskver" validType="minLength[8,8]" maxlength="8" 
							class="easyui-validatebox" required="required" missingMessage="请输入风控版本代码"/></td>
							<td class="update" width="15%">风控版本名称</td>
							<td align="left" class="update">
							<input name="riskname" id="riskname" required="required" maxlength="64"
								class="easyui-validatebox" missingMessage="请输入风控版本名称"/></td>
						</tr>
						<tr>
							<td class="update">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="81" id="notes" maxlength="128" name="notes" style="resize: none;" onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:saveRisk()" id="btn_submit" onclick="">保存</a> <a
					class="easyui-linkbutton" iconCls="icon-cancel"
					href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
</body>

<script>
		var width = $("#continer").width();
		var gridHeight = 600;
		var panelWidth = 700;
		var panelHeight = 230;
		var panelHoriFloat = (width - panelWidth) / 2;
		var panelVertFloat = 150;
		$.extend($.fn.validatebox.defaults.rules, {
			minLength: {
				validator: function(value, param) {
					var re = /^\d+$/;
					if (!re.test(value)) {
						return false;
					}
					return value.length >= param[0];
				},
				message: '请输入8位数字的风控版本代码'
			}
	
		});
		$(function() {
			$('#riskList').datagrid({
				title: '风控版本列表',
				singleSelect: true,
				iconCls: 'icon-save',
				height: gridHeight,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url: 'risk/queryRisk',
				remoteSort: false,
				columns: [[{
					field: 'riskver',
					title: '风控版本代码',
					width: 150,
					align: 'center'
				},
				{
					field: 'riskname',
					title: '风控版本名称',
					width: 220,
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
							return "失效";
						}
					}
				},
				{
					field: 'riskid',
					title: '操作',
					width: 150,
					align: 'center',
					formatter: function(value, rec) {
						return '<a href="javascript:showRisk(' + value + ')" style="color:blue;margin-left:10px">配置</a>&nbsp;&nbsp;<a href="javascript:toSetCase(' + '\'' + rec.RISKVER + '\'' + ')" style="color:blue;margin-left:10px">配置</a>';
	
					}
				}]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增风控版本',
					iconCls: 'icon-add',
					handler: function() {
						showAdd();
					}
				}]
			});
			var p = $('#riskList').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh: function() {}
			});
		});
	
		function search() {
			var data = {
				'riskver': $('#riskver_qid').val(),
				'riskname': $("#riskname_qid").val()
			};
			$('#riskList').datagrid('load', data);
		}
	
		function showAdd() {
// 			$('#theForm').clearForm();
			$('#accumulateRateForm :input').val('');
			$('#Notes').val('');
			$('#w').window({
				title: '风控版本信息',
				top: panelVertFloat,
		  		left: panelHoriFloat,
		  		width: panelWidth,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false,
			});
			$("#theForm").attr("action", "risk/saveRisk");
			$('#btn_submit').linkbutton('enable');
			$('#riskver').attr("readonly", false);
			$("#prdtver").removeAttr("disabled"); 
			showProduct();
		}
	
		function resize() {
			$(':input').val("");
		}
	
		function saveRisk() {
			$('#theForm').form('submit', {
				onSubmit: function() {
					if ($('#theForm').form('validate')) {
						$('#btn_submit').linkbutton('disable');
						$("#prdtver").removeAttr("disabled"); 
						return true;
					}
					return false;
				},
				success: function(data) {
					data=JSON.parse(data);
					if (data == '添加成功!' || data == '修改成功!') {
						$.messager.alert('提示', data);
						closeAdd();
						$('#btn_submit').linkbutton('enable');
						search();
					} else {
						$.messager.alert('提示', data);
						$('#btn_submit').linkbutton('enable');
					}
				}
			});
		}
		
		function showProduct() {
			$.ajax({
				type: "POST",
				url: "product/queryProductAll",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择产品--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.PRDTVER + '">' + value.PRDTNAME + '</option>';
					});
					$("#prdtver").html(html);
				}
			});
		}
		
		function showRisk(riskid) {
			$.ajax({
				type: "POST",
				url: "risk/queryOneRisk",
				data: "riskId=" + riskid,
				dataType: "json",
				success: function(json) {
	
					$("#riskid").val(riskid);
					$("#riskver").val(json.RISKVER);
					$("#riskname").val(json.RISKNAME);
					$("#Notes").val(json.NOTES);
					showProduct();
					setTimeout(function() {
						$("#prdtver").val(json.PRDTVER);
					},500);
				}
			});
			$('#w').window({
				title: '修改风控版本',
				top: panelVertFloat,
		  		left: panelHoriFloat,
		  		width: panelWidth,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false
			});
			$("#theForm").attr("action", "risk/updateOneRisk");
			$('#btn_submit').linkbutton('enable');
			$('#riskver').attr("readonly", true);
			$("#prdtver").attr("disabled","disabled"); 
		}
		
		function toSetCase(riskver) {
			var form = document.forms['theForm'];
			form.action = "<%=basePath%>risk/toMakeRiskCase?riskverMake=" + riskver;
			form.submit();
		}
		function closeAdd() {
			$('#w').window('close');
		}
</script>
</html>

