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
	<script type="text/javascript"
		src="js/checkboxbeautify/jquery-hcheckbox.js"></script>
	<link href='js/checkboxbeautify/css.css' rel="stylesheet"
		type="text/css" />
	
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
			<form id="searchForm" method="post">
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
				<form id="saveForm" method="post" action="">
					<input name="riskid" id="riskid" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr  style="height: 25px">
							<td class="update" width="15%">风控版本代码</td>
							<td class="update" align="left">
							<input type="text" name="riskver" id="riskver" validType="minLength[8,8]" maxlength="8" 
							class="easyui-validatebox" required="required" missingMessage="请输入风控版本代码"/></td>
							<td class="update" width="15%">风控版本名称</td>
							<td align="left" class="update">
							<input name="riskname" id="riskname" required="required" maxlength="64"
								class="easyui-validatebox" missingMessage="请输入风控版本名称"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
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
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveRisk()" id="btn_submit" onclick="">提交</a> 
			</div>
		</div>
	</div>

	<div id="w_case" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 900px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="setCaseForm" action="risk/updateRiskCase" method="post">
					<input type="hidden" id="caseid" name="caseid">
					<input type="hidden" id="riskver_case" name="riskver">
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr  style="height: 25px">
							<td class="update" width="15%">风控版本代码</td>
							<td class="update" align="left" id="riskver_case_show"></td>
							<td class="update" width="15%">风控版本名称</td>
							<td class="update" align="left" id="riskname_case_show"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%" height="100px">选择风控策略</td>
							<td class="update" align="left" id="riskCase" colspan="3"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="81" id="notes_case" maxlength="128" name="notes" style="resize: none;"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeSetCase()">返回</a>
				<a class="easyui-linkbutton" id="btn_case_submit" iconCls="icon-ok" onclick="saveRiskCase()">提交</a> 
			</div>
		</div>
	</div>
</body>

<script>
		var width = $("#continer").width();
		var gridHeight = 600;
		var panelWidth = 720;
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
							return "有效";
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
						return '<a href="javascript:showChange('
						+ value
						+ ')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:showSetCase('
						+ '\''
						+ rec.riskver + '\',\'' + rec.riskname
						+ '\''
						+ ')" style="color:blue;margin-left:10px">配置</a>';
					}
				} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ {
				id : 'btnadd',
				text : '新增风控版本',
				iconCls : 'icon-add',
				handler : function() {
					showAdd();
				}
			} ]
		});
		var p = $('#riskList').datagrid('getPager');
		$(p).pagination({
			onBeforeRefresh : function() {
			}
		});
	});

	function search() {
		var data = {
			'riskver' : $('#riskver_qid').val(),
			'riskname' : $("#riskname_qid").val()
		};
		$('#riskList').datagrid('load', data);
	}

	function resize() {
		$('#searchForm :input').val("");
	}
	
	function showAdd() {
		$('#saveForm :input').val('');
		//$('#notes').val('');
		$('#w').window({
			title : '风控版本信息',
			top : panelVertFloat,
			left : panelHoriFloat,
			width : panelWidth,
			height : panelHeight,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : true,
			shadow : false,
			closed : false,
		});
		$("#saveForm").attr("action", "risk/addRisk");
		$('#btn_submit').linkbutton('enable');
		$('#riskver').attr("readonly", false);
	}
	function closeAdd(){
		$('#w').window('close');
	}	
	
	function showChange(riskid) {
		$.ajax({
			type : "POST",
			url : "risk/queryRiskByRiskid",
			data : "riskid=" + riskid,
			dataType : "json",
			success : function(json) {
				$("#riskid").val(riskid);
				$("#riskver").val(json.riskver);
				$("#riskname").val(json.riskname);
				$("#notes").val(json.notes);
			}
		});
		$('#w').window({
			title : '修改风控版本',
			top : panelVertFloat,
			left : panelHoriFloat,
			width : panelWidth,
			height : panelHeight,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : true,
			shadow : false,
			closed : false
		});
		$("#saveForm").attr("action", "risk/updateRisk");
		$('#btn_submit').linkbutton('enable');
		$('#riskver').attr("readonly", true);
	}
	
	function saveRisk() {
		$('#saveForm').form('submit', {
			onSubmit : function() {
				if ($('#saveForm').form('validate')) {
					$('#btn_submit').linkbutton('disable');
					return true;
				}
				return false;
			},
			success : function(json) {
				$('#btn_submit').linkbutton('enable');
	    		json = JSON.parse(json);
	    		if(json.resultBool==true){
					 $.messager.alert('提示',"操作成功！");
					 $('#w').window('close');
					 search();
				}else{
					 $.messager.alert('提示',json.errMsg);
				}
			}
		});
	}

	function showSetCase(riskver,riskname) {
		$('#setCaseForm :input').val('');
		
		$("#riskver_case").val(riskver);
		$("#riskver_case_show").html(riskver);
		$("#riskname_case_show").html(riskname);
		
		$('#btn_case_submit').linkbutton('enable');
		$('#riskver').attr("readonly", false);	
		$("#setCaseForm").attr("action", "risk/updateRiskCase");
		
		$.ajax({
			 type: "POST",
			 url: "risk/queryRiskCaseByRiskver",
			 data: "riskver="+riskver,
			 dataType:"json",
			 success: function(json){	
		  		 if (json == null) {
					$.messager.alert('提示', '该风控版本的信息存在异常！');
				 } else {
					showStrategy(json.strategyList);
					if (json.isExist) {
						$("#caseid").val(json.caseid);
						$("#notes_case").val(json.notes);
						$("#setCaseForm").attr("action", "risk/updateRiskCase");
					}
// 					else {
// 						$("#setCaseForm").attr("action", "risk/addRiskCase");
// 					}
					$('#w_case').window({
						title : '配置风控策略信息',
						top : panelVertFloat,
						left : panelHoriFloat,
						width : panelWidth,
						height : panelHeight + 90,
						collapsible : false,
						minimizable : false,
						maximizable : false,
						modal : true,
						shadow : false,
						closed : false,
					});
				 }
		    },
			error : function(){
				$.messager.alert('提示', '服务异常！');
			}
		});
	}
	
	function closeSetCase(){
		$('#w_case').window('close');
	}	

	function showStrategy(strategyList) {
		var mark = 0;
		var html = '';
		$.each(strategyList,function(key, value) {
			if (value.checked) {
				html += '<input type="checkbox" id="checkboxList" name="checkboxList" checked="checked"   style="width:9px" value="' + value.orders + '" /><label class="activeflag_label" style="width:150px">'
						+ value.strategy + '</label>';
			} else {
				html += '<input type="checkbox" id="checkboxList" name="checkboxList" style="width:9px" value="' + value.orders + '" /><label class="activeflag_label" style="width:150px" >'
						+ value.strategy + '</label>';
			}
			if (mark % 3 == 2) {
				html += '</br>'
			}
			mark = mark + 1;
		});
		$("#riskCase").html(html);
		$('#riskCase').hcheckbox();
		$('#riskCase').children('#checkboxList').each(function() {
			if ($(this).attr("checked") == "checked") {
			} else {
				$(this).removeAttr("disabled");
			}
		});
	}
	
	function saveRiskCase() {
		$('#setCaseForm').form('submit', {
			onSubmit : function() {
				if ($('#setCaseForm').form('validate')) {
					$('#btn_case_submit').linkbutton('disable');
					return true;
				}
				return false;
			},
			success : function(json) {
				$('#btn_case_submit').linkbutton('enable');
	    		json = JSON.parse(json);
	    		if(json.resultBool==true){
					 $.messager.alert('提示',"配置成功！");
					 $('#w_case').window('close');
					 search();
				}else{
					 $.messager.alert('提示',json.errMsg);
				}
			}
		});
	}
</script>
</html>

