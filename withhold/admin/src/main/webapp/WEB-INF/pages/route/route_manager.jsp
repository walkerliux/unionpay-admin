<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
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
		<div id="p" class="easyui-panel" title="路由查询"
			style="height: 72px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="dedurateForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">路由版本</td>
						<td align="left" style="padding-left: 5px"><input
							name="routver" id="routver_s" maxlength="10" /></td>
						<td align="right">路由名称</td>
						<td align="left" style="padding-left: 5px"><input
							name="routname" id="routname_s" maxlength="64" />
						</td>
						<td align="right" colspan=2><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a>
							</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="route"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theForm" method="post" action="">
					<input name="routid" id="routid" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left" id="inputForm">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%">路由版本</td>
							<td class="update" align="left">
							<input name="routver" id="routver" required="true" validType="minLength[8,8]" maxlength="8"
								class="easyui-validatebox" missingMessage="请输入路由版本"/> <font color="red">*</font></td>
							</td>
							<td class="update" width="15%">路由名称</td>
							<td class="update" align="left"><input
								name="routname" id="routname" required="true"
								missingMessage="请输入路由名称" maxlength="64"
								class="easyui-validatebox"
								onblur="value=value.replace( /\s+/g,'')" /> <font color="red">*</font></td>
							</td>
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
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:saveRoute()" id="btn_submit" onclick="">保存</a> <a
					class="easyui-linkbutton" iconCls="icon-cancel"
					href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
</body>

<script>
	
		var width = $("#continer").width();
	  	var gridHeight = 540;
		var panelWidth = 700;
		var panelHeight = 235;
		var panelHoriFloat = (width-panelWidth)/2;
		var panelVertFloat = 150;
	
		$(function() {
			$('#route').datagrid({
				title: '路由版本列表', 
				singleSelect: true,
				iconCls: 'icon-save',
				height: gridHeight,
				nowrap: false,
				striped: true,
				sortName: 'ROUTVER',
				url: 'route/queryRoute',
				remoteSort: false,
				columns: [[				    
					{field: 'routver',title: '路由版本代码',width: 100,align: 'center'},
				    {field: 'routname',title: '路由版本名称',width: 200,align: 'center'},
				    {field: 'inUserName',title: '创建者',width: 100,align: 'center'},
				    {field: 'intime',title: '创建时间',width: 150,align: 'center'},
				    {field: 'notes',title: '备注',width: 200,align: 'center'},				
				    {field: 'status',title: '状态',width: 100,align: 'center',
				    	formatter: function(value, rec){
				    		if(value == 1){
				    			return "有效";
				    		}else {
				    			return "无效";
				    		}
				    	}
				    },
				    {field: 'routid',title: '操作',width: 150,align: 'center', 
						formatter: function(value, rec) {
							if(rec.status ==1){
								return '<a href="javascript:showRoute(\'' + value + '\')" style="color:blue;margin-left:10px">修改</a>';
							}
					}
				}]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增路由版本',
					iconCls: 'icon-add',
					handler: function() {
						showAdd();
					}
				}]
			});
			var p = $('#route').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh: function() {
	
		}
			});
		});
	
		function search() {
			var data = {
				'routver': $('#routver_s').val(),
				'routname': $("#routname_s").val()
			};
			$('#route').datagrid('load', data);
		}
	
		//新增路由版本 
		function showAdd() {
			//$('#theForm').clearForm();
			$('#theForm :input').val('');
			$('#routver').attr("readonly", false);
			$('#w').window({
				title: '路由版本信息',
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
			$("#theForm").attr("action", "route/addRoute");
			$('#btn_submit').linkbutton('enable');
		}
		
		//保存 
		function saveRoute(){
			$('#theForm').form('submit', {
				onSubmit : function() {
					if ($('#theForm').form('validate')) {
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

		//取消
		function closeAdd() {
			$('#w').window('close');
		}

		//修改
		function showRoute(routid){
			$('#theForm :input').val('');
			$.ajax({
				type: "POST",
				url: "route/queryRouteById",
				data: "routid=" + routid,
				dataType: "json",
				success: function(json) {
					$("#routid").val(routid);
					$("#routver").val(json.routver);
					$('#routver').attr("readonly", true);
					$("#routname").val(json.routname);
					$("#notes").val(json.notes);										
				}	
			});
			$('#w').window({
				title: '修改路由版本',
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
			$("#theForm").attr("action", "route/updateRoute");
			$('#btn_submit').linkbutton('enable');
		}
	
		function resize(){
			$('#dedurateForm :input').val('');
		}
</script>
</html>

