<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
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
		<div id="p" class="easyui-panel" title="路由查询"
			style="height: 72px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="serchForm" method="post">
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
		<div style="margin-top: 5px">
			<table id="routeConfig"></table>
		</div>
	</div>
	<div id="w_route" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theRouteForm" method="post" action="">
					<input name="routid" id="routid" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2" id="inputForm">
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
				<a class="easyui-linkbutton" iconCls="icon-back"
					href="javascript:void(0)" onclick="closeAddRoute()">返回</a>
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:saveRoute()" id="btn_route_submit" onclick="">保存</a> 
			</div>
		</div>
	</div>
	
	
	<div id="w_routeConfig_save" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theRouteConfigForm" method="post" action="">
					<input name="rid" id="rid" type="hidden" /> 
					<input name="routver" id="routver_hidden" type="hidden" /> 
					<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%">路由版本</td>
							<td class="update" align="left" id="routver_c"></td>
							<td class="update" width="15%">路由名称</td>
							<td class="update" align="left" id="routname_c" ></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">提示：开始时间、结束时间请按照HHmmss格式输入</td>
						</tr>
						<tr>
							<td class="update" width="15%">开始时间</td>
							<td class="update" align="left"><input
								name="stime" id="stime_c"
								onkeyup="value=value.replace(/[^0-9]/g,'')" required="true"
								missingMessage="请填写开始时间,只能为数字" maxlength="6" validType="minLength[6,6]"
								class="easyui-validatebox" /> <font color="red">*</font>
							</td>

							<td class="update" width="15%">结束时间</td>
							<td class="update" align="left"><input
								name="etime" id="etime_c" required="true"
								missingMessage="请填写结束时间,只能为数字"
								onkeyup="value=value.replace(/[^0-9]/g,'')" maxlength="6" validType="minLength[6,6]"
								class="easyui-validatebox" /> <font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="20%">单笔最小交易额（元）</td>
							<td class="update" align="left">
							<input name="minamt" id="minamt_c" validType="amount" maxlength="9" 
								class="easyui-validatebox" required="true" missingMessage="请输入单笔最小交易额" /></td>
							<td class="update" width="20%">单笔最大交易额（元）</td>
							<td class="update" align="left">
							<input name="maxamt" id="maxamt_c" validType="amount" maxlength="9" 
								class="easyui-validatebox" required="true" missingMessage="请输入单笔最大交易额" /></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%" height="100px">交易卡所属银行</td>
							<td class="update" align="left" id="bankcodes_c" colspan="3"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%" height="100px">交易类型</td>
							<td class="update" align="left" id="busicodes_c" colspan="3"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%" height="100px">卡类型</td>
							<td class="update" align="left" id="cardtypes_c" colspan="3"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">交易要素</td>
							<td class="update" align="left">
							<select id="tradeele_c" class="easyui-validatebox" required="true" missingMessage="请选择交易要素" name="tradeele"/>
								<option value=''>--请选择交易要素--</option>
							</select><font color="red">*</font></td>
							<td class="update">通道</td>
							<td class="update" align="left">
							<select id="chnlcode_c" name="chnlcode" class="easyui-validatebox" required="true" missingMessage="请选择通道"/>
								<option value=''>--请选择通道--</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">提示：优先级为正整数</td>
						</tr>
						<tr>
							<td class="update">是否默认路由</td>
							<td class="update" align="left">
								<select name="isdef" id="isdef_c" class="easyui-validatebox" required="true"
								missingMessage="请选择是否为默认路由" />
									<option value="0">默认路由</option>
									<option value="1">非默认路由</option> 
								</select>
							</td>
								<!-- <input type="radio" value="0" name="isdef" checked="checked"/>是
								&nbsp;&nbsp;
								<input type="radio" value="1" name="isdef"/>否 -->
							<td class="update">优先级</td>
							<td class="update" align="left"><input
								name="orders" id="orders_c" required="true"
								missingMessage="请填写优先级" maxlength="12"
								class="easyui-validatebox" /> <font color="red">*</font></td>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls=icon-back
					href="javascript:void(0)" onclick="closeSaveRouteConfig()">返回</a>
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:saveRouteConfig()" id="btn_route_config_submit" onclick="">保存</a>
			</div>
		</div>
		

	<div id="w_routeConfig_detail" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theConfigDetailForm" method="post" action="">
					<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%">路由版本</td>
							<td class="update" align="left" id="routver_d"></td>
							<td class="update" width="15%">路由名称</td>
							<td class="update" align="left" id="routname_d" ></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%">开始时间</td>
							<td class="update" align="left" id="stime_d"></td>
							<td class="update" width="15%">结束时间</td>
							<td class="update" align="left" id="etime_d" ></td>
						</tr>
						<tr>
							<td class="update" width="20%">单笔最小交易额（元）</td>
							<td class="update" align="left" id="minamt_d"></td>
							<td class="update" width="20%">单笔最大交易额（元）</td>
							<td class="update" align="left" id="maxamt_d"></td>
						</tr>
						<tr>
							<td class="update" width="15%">交易卡所属银行</td>
							<td class="update" align="left" id="bankcodes_d" colspan="3"></td>
						</tr>
						<tr>
							<td class="update" width="15%">交易类型</td>
							<td class="update" align="left" id="busicodes_d" colspan="3"></td>
						</tr>
						<tr>
							<td class="update" width="15%">卡类型</td>
							<td class="update" align="left" id="cardtypes_d" colspan="3"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update" width="15%">交易要素</td>
							<td class="update" align="left" id="tradeele_d"></td>
							<td class="update" width="15%">通道</td>
							<td class="update" align="left" id="chnlcode_d"></td>
						</tr>
						<tr>
							<td class="update" width="15%">是否默认路由</td>
							<td class="update" align="left" id="isdef_d"></td>
							<td class="update" width="15%">优先级</td>
							<td class="update" align="left" id="orders_d"></td>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls=icon-back
					href="javascript:void(0)" onclick="closeConfigDetail()">返回</a>
			</div>
		</div>
	</div>		
	</div>
</body>

<script>
	
		var width = $("#continer").width();
	  	var gridHeight = 450;
		var panelWidth = 700;
		var panelHeight = 235;
		var panelHoriFloat = (width-panelWidth)/2;
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
				message: '时间为6位数字'
			}
	
		});
		
		$(function() {
			$('#route').datagrid({
				title: '路由版本列表', 
				singleSelect: true,
				iconCls: 'icon-save',
				height: gridHeight,
				nowrap: false,
				striped: true,
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
								return '<a href="javascript:showRoute(\'' + value + '\')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:showRouteConfig(\''+ rec.routver + '\',\'' + rec.routname + '\')" style="color:blue;margin-left:10px">路由配置</a>';
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
						showAddRoute();
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
		function showAddRoute() {
			//$('#theRouteForm').clearForm();
			$('#theRouteForm :input').val('');
			$('#routver').attr("readonly", false);
			$('#w_route').window({
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
			$("#theRouteForm").attr("action", "route/addRoute");
			$('#btn_route_submit').linkbutton('enable');
		}
		
		//保存 
		function saveRoute(){
			$('#theRouteForm').form('submit', {
				onSubmit : function() {
					if ($('#theRouteForm').form('validate')) {
						$('#btn_route_submit').linkbutton('disable');
						return true;
					}
					return false;
				},
				success : function(json) {
					$('#btn_route_submit').linkbutton('enable');
		    		json = JSON.parse(json);
		    		if(json.resultBool==true){
						 $.messager.alert('提示',"操作成功！");
						 closeAddRoute();
						 search();
					}else{
						 $.messager.alert('提示',json.errMsg);
					}
				}
			});
		}

		//取消
		function closeAddRoute() {
			$('#w_route').window('close');
		}

		//修改
		function showRoute(routid){
			$('#theRouteForm :input').val('');
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
			$('#w_route').window({
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
			$("#theRouteForm").attr("action", "route/updateRoute");
			$('#btn_route_submit').linkbutton('enable');
		}
	
		function resize(){
			$('#serchForm :input').val('');
		}
		
		function showRouteConfig(routver,routname){
			$('#routeConfig').datagrid({
				title: '路由版本配置列表',  
				singleSelect: true,
				iconCls: 'icon-save',
				height: gridHeight + 55,
				nowrap: false,
				striped: true,
				url: 'route/queryRouteConfig?routver=' + routver,
				remoteSort: false,
				columns: [[				    
					{field: 'routver',title: '路由版本',width: 80,align: 'center'},
					{field: 'routname',title: '路由名称',width: 120,align: 'center'},
				    {field: 'stime',title: '开始时间',width: 70,align: 'center',
						formatter: function(value, rec){
				    		return changeTime(value);
				    	}	
				    },
				    {field: 'etime',title: '结束时间',width: 70,align: 'center',
				    	formatter: function(value, rec){
				    		return changeTime(value);
				    	}
				    },
				    {field: 'minamt',title: '最小交易额（元）',width: 105,align: 'center',
				    	formatter: function(value, rec){
				    		return value/100;
				    	}	
				    },
				    {field: 'maxamt',title: '最大交易额（元）',width: 105,align: 'center',
				    	formatter: function(value, rec){
				    		return value/100;
				    	}		
				    },
				    {field: 'banknames',title: '所属银行',width: 200,align: 'center'},
				    {field: 'businames',title: '交易类型',width: 100,align: 'center'},
				    {field: 'cardtypenames',title: '卡类型',width: 100,align: 'center'},
				    {field: 'tradeeleName',title: '交易要素',width: 150,align: 'center'},
				    {field: 'chnlname',title: '通道名称',width: 100,align: 'center'},
				    {field: 'isdef',title: '是否为默认路由',width: 110,align: 'center',
				    	formatter: function(value, rec){
				    		if(value == 0){
				    			return "默认路由";
				    		}else if(value == 1){
				    			return "非默认路由";
				    		}
				    	}
				    }, 	
				    {field: 'orders',title: '优先级',width: 50,align: 'center'},
				    {field: 'status',title: '状态',width: 40,align: 'center',
				    	formatter: function(value, rec){
				    		if(value == 00){
				    			return "在用";
				    		}else{
				    			return "停用";
				    		}
				    	}
				    },				
				    {field: 'rid',title: '操作',width: 100,align: 'center', 
						formatter: function(value, rec) {
							if(rec.status ==00){                                                                                                   
								return '<a href="javascript:showRouteConfigDetail(' + value + ')" style="color:blue;margin-left:10px">详情</a>&nbsp;&nbsp;<a href="javascript:showChangeConfig('+ value + ')" style="color:blue;margin-left:10px">修改</a>';
							}else if(rec.STATUS ==01){
								return '<a href="javascript:showRouteConfigDetail(' + value + ')" style="color:blue;margin-left:10px">详情</a>';
							}
							
					}
				}]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增路由配置', 
					iconCls: 'icon-add',
					handler: function() {
						showAddConfig(routver,routname);
					}
				}]
			});
			var p = $('#routeConfig').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh: function() {}
			});
		}
		
		//新增路由配置 
		function showAddConfig(routver,routname) {
			$('#theRouteConfigForm :input').val('');
			$('#routver_c').html(routver);
			$('#routver_hidden').val(routver);
			$('#routname_c').html(routname);
			$('#w_routeConfig_save').window({
				title: '新增路由配置',
				top: panelVertFloat,
		  		left: panelHoriFloat,
		  		width: panelWidth + 100,
		  		height: panelHeight + 340,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false
			});
			$("#theRouteConfigForm").attr("action", "route/addRouteConfig");
			$('#btn_route_config_submit').linkbutton('enable');
			showAllCheckbox();
			showAllTransfactors();
			showAllChannl();
		}
		
		function showAllCheckbox(rid) {
			 $.ajax({
	            type: "GET",
	            url: "route/queryAllConfigCheckbox",
	            dataType: "json",
	            data : {
					"rid" : rid
				},
	            success: function(json) {
	            	var mark = 0;
	    			var html = '';
	    			
	            	// 发卡行
	            	$.each(json.bankList,function(key, value) {
						if (value.checked) {
							html += '<input type="checkbox" id="bankcodes" name="bankcodes" checked="checked"   style="width:9px" value="' + value.bankcode + '" /><label class="activeflag_label" style="width:150px">'
									+ value.bankname + '</label>';
						} else {
							html += '<input type="checkbox" id="bankcodes" name="bankcodes" style="width:9px" value="' + value.bankcode + '" /><label class="activeflag_label" style="width:150px" >'
									+ value.bankname + '</label>';
						}
						if (mark % 3 == 2) {
							html += '</br>'
						}
						mark = mark + 1;
					});
	            	$("#bankcodes_c").html(html);
	    			$('#bankcodes_c').hcheckbox();
	    			$('#bankcodes_c').children('#bankcodes').each(function() {
	    				if ($(this).attr("checked") == "checked") {
	    				} else {
	    					$(this).removeAttr("disabled");
	    				}
	    			});
	    			
	            	// 交易类型
	            	mark = 0;
	    			html = '';
	            	$.each(json.businessList,function(key, value) {
						if (value.checked) {
							html += '<input type="checkbox" id="busicodes" name="busicodes" checked="checked"   style="width:9px" value="' + value.busicode + '" /><label class="activeflag_label" style="width:150px">'
									+ value.businame + '</label>';
						} else {
							html += '<input type="checkbox" id="busicodes" name="busicodes" style="width:9px" value="' + value.busicode + '" /><label class="activeflag_label" style="width:150px" >'
									+ value.businame + '</label>';
						}
						if (mark % 3 == 2) {
							html += '</br>'
						}
						mark = mark + 1;
					});
	            	$("#busicodes_c").html(html);
	    			$('#busicodes_c').hcheckbox();
	    			$('#busicodes_c').children('#busicodes').each(function() {
	    				if ($(this).attr("checked") == "checked") {
	    				} else {
	    					$(this).removeAttr("disabled");
	    				}
	    			});
	    			
	            	// 卡类型
	    			mark = 0;
	    			html = '';
	            	$.each(json.paraDicList,function(key, value) {
						if (value.checked) {
							html += '<input type="checkbox" id="cardtypes" name="cardtypes" checked="checked"   style="width:9px" value="' + value.paraCode + '" /><label class="activeflag_label" style="width:150px">'
									+ value.paraName + '</label>';
						} else {
							html += '<input type="checkbox" id="cardtypes" name="cardtypes" style="width:9px" value="' + value.paraCode + '" /><label class="activeflag_label" style="width:150px" >'
									+ value.paraName + '</label>';
						}
						if (mark % 3 == 2) {
							html += '</br>'
						}
						mark = mark + 1;
					});
	            	$("#cardtypes_c").html(html);
	    			$('#cardtypes_c').hcheckbox();
	    			$('#cardtypes_c').children('#cardtypes').each(function() {
	    				if ($(this).attr("checked") == "checked") {
	    				} else {
	    					$(this).removeAttr("disabled");
	    				}
	    			});
	            }
	        });
		}
		
		function closeSaveRouteConfig() {
			$('#w_routeConfig_save').window('close');
		}
		
		function showAllTransfactors(tradeele){
			$.ajax({
				type : "POST",
				url: "merchDeta/showAllTransfactors",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择交易要素--</option>";
					
					$.each(json,function(key, value) {
						if (value.paraCode == tradeele) {
							html += '<option value="' + value.paraCode + '" selected="selected">' + value.paraName + '</option>';
						} else {
							html += '<option value="' + value.paraCode + '">' + value.paraName + '</option>';
						}
					});
					$("#tradeele_c").html(html);
				}
			});
		}
		
	 	function showAllChannl(chnlcode){
			$.ajax({
			 type : "POST",
				url: "channel/queryChannelAll",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择通道--</option>";
					
					$.each(json,function(key, value) {
						if (value.chnlcode == chnlcode) {
							html += '<option value="' + value.chnlcode + '" selected="selected">' + value.chnlname + '</option>';
						} else {
							html += '<option value="' + value.chnlcode + '">' + value.chnlname + '</option>';
						}
					}); 
					$("#chnlcode_c").html(html);
				}
			});
		}  
	 	

	function saveRouteConfig() {
		var stime = parseInt($("#stime_c").val());
		var etime = parseInt($("#etime_c").val());
		var max = parseInt($("#maxamt_c").val());
		var min = parseInt($("#minamt_c").val());
		
		$('#theRouteConfigForm').form('submit', {
			onSubmit : function() {
				if ($('#theRouteConfigForm').form('validate')) {
					if (etime <= stime) {
						$.messager.alert('提示',"结束时间应当晚于开始时间");
					}
					if (max <= min) {
						$.messager.alert('提示',"最大限额应当大于最小限额");
					}
					$('#btn_route_config_submit').linkbutton('disable');
					return true;
				}
				return false;
			},
			success : function(json) {
				$('#btn_route_config_submit').linkbutton('enable');
	    		json = JSON.parse(json);
	    		if(json.resultBool==true){
					 $.messager.alert('提示',"操作成功！");
					 closeSaveRouteConfig();
					 // 刷新路由配置列表
					 var routver = $('#routver_hidden').val();
					 var routname = $('#routname_c').html(routname);
					 showRouteConfig(routver,routname);
				}else{
					 $.messager.alert('提示',json.errMsg);
				}
			}
		});
	}
	
	function showRouteConfigDetail(rid){
		$.ajax({
		   type: "POST",
		   url: "route/queryConfigDetail",
		   data: "rid="+rid,
		   dataType:"json",
		   success: function(json){	
			   if (json == null) {
					$.messager.alert('提示', '该路由配置信息不存在，或已被变更，请刷新一下数据再试试！');
				} else {
				    $("#routver_d").html(json.routver);
					$("#routname_d").html(json.routname);
					$("#stime_d").html(changeTime(json.stime));
					$("#etime_d").html(changeTime(json.etime));
					$("#minamt_d").html(json.minamt/100);
					$("#maxamt_d").html(json.maxamt/100);
					$("#bankcodes_d").html(json.banknames);
					$("#busicodes_d").html(json.businames);
					$("#cardtypes_d").html(json.cardtypenames);
					$("#tradeele_d").html(json.tradeeleName);
					$("#chnlcode_d").html(json.chnlname);
					$("#isdef_d").html(json.isdef=='0'?'默认路由':'非默认路由');
					$("#orders_d").html(json.orders);
					
					$('#w_routeConfig_detail').window({
						title: '路由配置详情',
						top: panelVertFloat,
				  		left: panelHoriFloat,
				  		width: panelWidth + 100,
				  		height: panelHeight + 130,
						collapsible: false,
						minimizable: false,
						maximizable: false,
						modal: true,
						shadow: false,
						closed: false
					});
				}
		    },
			error : function(){
				$.messager.alert('提示', '服务异常！');
			}
		});
	}
	
	function closeConfigDetail() {
		$('#w_routeConfig_detail').window('close');
	}
	
	function showChangeConfig(rid){
		$('#theRouteConfigForm :input').val('');
		$("#theRouteConfigForm").attr("action", "route/updateRouteConfig");
		
		$.ajax({
		   type: "POST",
		   url: "route/queryConfigDetail",
		   data: "rid="+rid,
		   dataType:"json",
		   success: function(json){	
			   if (json == null) {
					$.messager.alert('提示', '该路由配置信息不存在，或已被变更，请刷新一下数据再试试！');
				} else {
				    $("#rid").val(json.rid);
				    $("#routver_hidden").val(json.routver);
				    $("#routver_c").html(json.routver);
				    $('#routname_c').html(json.routname);
					$("#stime_c").val(json.stime);
					$("#etime_c").val(json.etime);
					$("#minamt_c").val(json.minamt/100);
					$("#maxamt_c").val(json.maxamt/100);
					showAllCheckbox(rid);
					showAllTransfactors(json.tradeele);
					showAllChannl(json.chnlcode);
					$("#isdef_c").val(json.isdef);
					$("#orders_c").val(json.orders);
					
					$('#w_routeConfig_save').window({
						title: '修改路由配置',
						top: panelVertFloat,
				  		left: panelHoriFloat,
				  		width: panelWidth + 100,
				  		height: panelHeight + 340,
						collapsible: false,
						minimizable: false,
						maximizable: false,
						modal: true,
						shadow: false,
						closed: false
					});
				}
		    },
			error : function(){
				$.messager.alert('提示', '服务异常！');
			}
		});
	}
	
	// 格式化时间
	function changeTime(value) {
		var dateString = value;
		if (dateString == null) {
			return "";
		} else {
			hour = dateString.substring(0, 2);
			minte = dateString.substring(2, 4);
			s = dateString.substring(4, 6);
			return hour + ":" + minte + ":" + s;
		}
	}
</script>
</html>

