<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>
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
		<div id="p" class="easyui-panel" title="查询条件" style="height: 100px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="searchForm" method="post">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td align="right">商户号</td>
						<td align="left" style="padding-left: 5px"><input
							name="memberId" id="s_memberId" maxlength="8" /></td>
						<td align="right">商户名称</td>
						<td align="left" style="padding-left: 5px"><input
							name="memberName" id="s_memberName" maxlength="8" /></td>
						<td class="add" align="right">渠道</td>
						<td class="add" align="left" style="padding-left: 5px">
						<select id="s_cacode" name="cacode">
							<option value=''>--请选择渠道--</option>
						</select></td>
					<tr>
					</tr>
						<td class="add" align="right" colspan="6">
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
							<a href="javascript:resize()" class="easyui-linkbutton"iconCls="icon-redo">清空</a></td>
						<td class="add" align="right"></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="coopAgencyList">
			</table>
		</div>
	</div>
	
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="saveForm" action="" method="post">
					<input type="hidden" id="selfId" name="selfId" />
					<input type="hidden" id="status" name="status" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="update">渠道代码</td>
							<td class="update" align="left">
							<input type="text" id="cacode" name="cacode" class="easyui-validatebox" required="true"
								maxlength="11" missingMessage="请输入渠道代码"/><font color="red">*</font></td>
							<td class="update" width="15%">渠道名称 </td>
							<td class="update" align="left">
							<input type="text" id="caname" name="caname" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入渠道名称 " /><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">所在省</td>
							<td class="update" align="left">
							<select id="caprovince" class="easyui-validatebox" required="true" name="caprovince" 
							missingMessage="请选择所在省" onchange="showCity()" /></select> <font color="red">*</font></td>
							<td class="update">所在市</td>
							<td class="update" align="left">
							<select id="cacity" class="easyui-validatebox" required="true" missingMessage="请选择所在市" name="cacity"/>
							<option value=''>--请选择所在市--</option></select><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">地址</td>
							<td class="update" align="left">
							<input type="text" id="address" name="address" class="easyui-validatebox" required="true"
								maxlength="255" missingMessage="请输入地址" /><font color="red">*</font></td>
							<td class="update">上级渠道</td>
							<td class="update" align="left">
							<select id="supercode" class="easyui-validatebox" required="true" missingMessage="请选择上级代理" name="supercode"/>
								<option value=''>--请选择上级渠道--</option>
								<option value='0'></option></select>
							</select><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">联系人</td>
							<td class="update" align="left">
							<input type="text" id="contact" name="contact" class="easyui-validatebox" 
							 maxlength="32" missingMessage="请输入联系人" required="true" /><font color="red">*</font></td>
							<td class="update">联系电话</td>
							<td class="update" align="left">
							<input type="text" id="contPhone" name="contPhone" class="easyui-validatebox" 
							 maxlength="11" missingMessage="请输入联系电话" required="true" /><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="81" id="notes" maxlength="128" name="notes" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveCoopAgencyApply()" id="btn_submit">提交</a>
			</div>
		</div>
	</div>

</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			// 显示搜索条件中的渠道
			showAllCacode("serch");
			
			$('#merchDetaList').datagrid({
				title:'商户信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'merchDeta/queryApply',
				remoteSort: false,
				columns:[[
					{field:'memberId',title:'商户号',align:'center',width:120},
					{field:'memberName',title:'商户名称',width:150,align:'center'},
					{field:'address',title:'营业地址',align:'center',width:200},
					{field:'contact',title:'联系人',align:'center',width:80},
					{field:'contPhone',title:'联系电话',align:'center',width:100},
					{field:'contAddress',title:'联系人地址',align:'center',width:200},
					{field:'contPost',title:'联系人邮箱',align:'center',width:120},
					{field:'caname',title:'代理商',align:'center',width:150},
					{field:'notes',title:'备注',align:'center',width:120},
					{field:'status',title:'状态',width:100,align:'center',
						formatter:function(value,rec){
							if (value=="09" || value=="10") {
								return "注册待审";
							}else if (value=="11") {
								return "注册被拒";
							}else if (value=="21") {
								return "变更被拒";
							}else if (value=="31") {
								return "注销被拒";
							}
						}
					},
					{field:'selfId',title:'操作',align:'center',width:120,rowspan:2,
						formatter:function(value,rec){
						if(rec.status=="10" || rec.status=="11" || rec.status=="21" || rec.status=="31"){
							return '<a href="javascript:showChange(\''+value+'\')" style="color:blue;margin-left:10px">变更</a>';
						}else{
							return '';
						}
					}}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增商户信息',
					iconCls:'icon-add',
					handler:function(){
						$("#cacode").removeAttr('readonly');
						showAdd();
						$("#saveForm").attr("action","merchDeta/addApply");
					}
				}]
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}

		function search(){
			var data={
				'memberId':$('#s_memberId').val(),
				'memberName':$("#s_memberName").val(),
				'supercode':$("#s_cacode").val(),
			};
			$('#merchDetaList').datagrid('load',data);
		}
		
		function showAdd(){
			$('#cacode').removeAttr("readonly");//取消只读的设置
			showAllProvince();
			//// 显示搜索条件中的上级渠道
			showAllSuperCode("add");
			$("#saveForm").attr("action","coopAgency/addApply");
			$('#saveForm :input').val('');
			$('#w').window({
				title: '新增渠道信息',
				top:100,
				left:400,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 360
			});
			$('#btn_submit').linkbutton('enable');	
		}
		
		function showChange(selfId){
			$('#saveForm :input').val('');
			$('#cacode').attr("readonly","readonly");//设为只读
			$("#saveForm").attr("action","coopAgency/updateApply");
			$.ajax({
			   type: "POST",
			   url: "coopAgency/queryApplyById",
			   data: "selfId="+selfId,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   if (json == null) {
						$.messager.alert('提示', '该渠道信息不存在，或已被变更，请刷新一下数据再试试！');
					} else {
					    $("#cacode").val(json.cacode);
						$("#caname").val(json.caname);
						showProvince(json.caprovince);
						showCityWithCid(json.caprovince,json.cacity);
						showSuperCode(json.supercode);
						$("#address").val(json.address);
						$("#contact").val(json.contact);
						$("#contPhone").val(json.contPhone);
						$("#notes").val(json.notes);
						$("#selfId").val(json.selfId);
						$("#status").val(json.status);
						
						$('#w').window({
							title: '变更渠道信息',
							top:100,
							left:400,
							width: 800,
							modal: true,
							minimizable:false,
							collapsible:false,
							maximizable:false,
							shadow: false,
							closed: false,
							height: 360
						});
					}
			    },
				error : function(){
					$.messager.alert('提示', '服务异常！');
				}
			});
		}
		
		
		function showcCaCode(supercode){
			$.ajax({
				type : "POST",
				url: "coopAgency/queryAllSuperCode",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择上级代理--</option>";
					
					$.each(json,function(key, value) {
						if (value.cacode == supercode) {
							html += '<option value="' + value.cacode + '" selected="selected">' + value.caname + '</option>';
						} else {
							html += '<option value="' + value.cacode + '">' + value.caname + '</option>';
						}
					});
					$("#cacode").html(html);
				}
			});
		}
		
		function showAllCacode(type){
			$.ajax({
				type : "POST",
				url: "coopAgency/queryAllSuperCode",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择上级代理--</option>";
					$.each(json,function(key, value) {
							html += '<option value="' + value.cacode + '">' + value.caname + '</option>';
					});
					if (type == "serch") {
						$("#s_cacode").html(html);
					} else {
						$("#cacode").html(html);
					}
				}
			});
		}
		
		function saveCoopAgencyApply(){
			$('#saveForm').form('submit', {  
			    onSubmit: function(){  
			    	if($('#saveForm').form('validate')){
			    		$('#btn_submit').linkbutton('disable');	
			    		return true;   
				    }
			        return false;   
			    }, 
			    success: function(json) {
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
		
		function closeAdd(){
			$('#w').window('close');
		}	
	</script>
</html>
