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
<script type="text/javascript" src="js/extendsValidator_1.0_20151215.js"></script>
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
			/* font-weight: bold; */
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
		<div id="p" class="easyui-panel" title="单笔限额查询"
			style="height: 72px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="dedurateForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">风控版本</td>
						<td align="left" style="padding-left: 5px">
							<select id="riskver_s" class="easyui-validatebox"></select></td>
						<td align="right" colspan=2>
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="singleLimit"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 600px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theForm" method="post" action="">
					<input name="tid" id="tid" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left" id="inputForm">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="20%">风控版本</td>
							<td class="update" align="left">
							<select id="riskver" name="caseid" class="easyui-validatebox" required="true" missingMessage="请选择风控版本">
							</select></td>
							<td class="update" width="20%">风险等级</td>
							<td class="update" align="left">
							<select id="risklevel" name="risklevel" class="easyui-validatebox" missingMessage="请选选择风险等级" required="true"
								class="easyui-validatebox">
									<option value="">--请选择风险等级--</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">提示：小于最小，大于最大金额的交易触发风控</td>
						</tr>
						<tr>
							<td class="update" width="20%">单笔最小限额（元）</td>
							<td class="update" align="left">
							<input name="minAmount" id="minAmount" validType="amount" maxlength="9" 
								class="easyui-validatebox" required="true" missingMessage="请输入单笔最小金额"/></td>
							<td class="update" width="20%">单笔最大限额（元）</td>
							<td class="update" align="left">
							<input name="maxAmount" id="maxAmount" validType="amount" maxlength="9" 
								class="easyui-validatebox" required="true" missingMessage="请输入单笔最大金额"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="81" id="notes" maxlength="128" name="notes" style="resize: none;"></textarea></td>
<!-- 							<td align="left" style="padding-left: 5px" width="25%"><input name="notes" id="Notes" maxlength="32" /></td> -->
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:saveLimitSingle()" id="btn_submit" onclick="">保存</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel"
					href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
</body>

<script>
		$(function() {
			showRiskInSerch();
		});
		 
		var width = $("#continer").width();
		var gridHeight = 600;
		var panelWidth = 755;
		var panelHeight = 286;
		var panelHoriFloat = (width - panelWidth) / 2;
		var panelVertFloat = 150;
	
		$(function() {
			$('#singleLimit').datagrid({
				title: '单笔限额列表',
				singleSelect: true,
				iconCls: 'icon-save',
				height: gridHeight,
				nowrap: false,
				striped: true,
				url: 'risk/queryLimitSingle',
				remoteSort: false,
				columns: [[{
					field: 'riskname',
					title: '风控版本',
					width: 150,
					align: 'center'
				},
				{
					field: 'minAmount',
					title: '最小限额(元)',
					width: 100,
					align: 'center',
					formatter: function(value, rec){
			    		return value/100;
			    	}	
				},
				{
					field: 'maxAmount',
					title: '最大限额(元)',
					width: 150,
					align: 'center',
					formatter: function(value, rec){
			    		return value/100;
			    	}	
				},
				{
					field: 'risklevel',
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
							return '<a href="javascript:showChange(' + value + ')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:logoutLimitSingle(' + value + ')" style="color:blue;margin-left:10px">注销</a>';
						} else {
							return '<a href="javascript:startLimitSingle(' + value + ')" style="color:blue;margin-left:10px">启用</a>';
	
						}
					}
				}]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增单笔限额',
					iconCls: 'icon-add',
					handler: function() {
						showAdd();
					}
				}]
			});
			var p = $('#singleLimit').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh: function() {}
			});
		});
	
		function search() {
			var data = {
				'riskver': $('#riskver_s').val()
			};
			$('#singleLimit').datagrid('load', data);
		}
	
		function showAdd() {
			$('#theForm :input').val('');
			$("#riskver").attr("disabled", false);
			showRisk();
			showRiskLevel();
			$('#w').window({
				title: '单笔限额信息',
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
			$("#theForm").attr("action", "risk/addLimitSingle");
			$('#btn_submit').linkbutton('enable');
		}
	
		function resize() {
			$(':input').val("");
		}
	
		function saveLimitSingle() {
			var max = parseInt($("#maxAmount").val());
			var min = parseInt($("#minAmount").val());
			
			$('#theForm').form('submit', {
				onSubmit: function() {
					if ($('#theForm').form('validate')) {
						if (max <= min) {
							$.messager.alert('提示',"最大限额应当大于最小限额");
						}
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
		
		function showChange(tid) {
			$.ajax({
				type: "POST",
				url: "risk/queryLimitSingleById",
				data: "tid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#tid").val(json.tid);
					$("#notes").val(json.notes);
					$("#maxAmount").val(json.maxAmount/100);
					$("#minAmount").val(json.minAmount/100);
					$("#riskver").attr("disabled", "disabled");
					showRisk(json.caseid);
					showRiskLevel(json.risklevel);
				}
			});
			$('#w').window({
				title: '修改单笔限额',
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
			$("#theForm").attr("action", "risk/updateLimitSingle");
			$('#btn_submit').linkbutton('enable');
		}
		
		function logoutLimitSingle(tid) {
			$.messager.confirm('提示', '您是否想要注销此单笔限额规则?',
					function(r) {
						if (r) {
							$.ajax({
								type : "POST",
								url : "risk/logoutLimitSingle",
								dataType : "json",
								data : {
									"tid" : tid
								},
								success : function(json) {
									if (json.resultBool == true) {
										$.messager.alert('提示', "注销成功！");
										//$('#w').window('close');
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
		
		function startLimitSingle(tid) {
			$.messager.confirm('提示', '您是否想要启用此单笔限额规则?',
					function(r) {
						if (r) {
							$.ajax({
								type : "POST",
								url : "risk/startLimitSingle",
								dataType : "json",
								data : {
									"tid" : tid
								},
								success : function(json) {
									if (json.resultBool == true) {
										$.messager.alert('提示', "启用成功！");
										//$('#w').window('close');
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
		
		function showRiskInSerch() {
			$.ajax({
				type: "POST",
				url: "risk/getAllRiskList",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择风控版本--</option>";
					$.each(json,function(key, value) {
						html += '<option value="' + value.riskver + '">' + value.riskname + '</option>';
					}) ;
					$("#riskver_s").html(html);
				}
			});
		}
		
		function showRisk(caseid) {
			$.ajax({
				type: "POST",
				url: "risk/getAllRiskWithCase",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择风控版本--</option>";
					$.each(json,function(key, value) {
						if(value.caseid==caseid){
							html += '<option value="' + value.caseid + '" selected="selected">' + value.riskname + '</option>';
						}else{
							html += '<option value="' + value.caseid + '">' + value.riskname + '</option>';
						}
					}) ;
					$("#riskver").html(html);
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
</script>
</html>

