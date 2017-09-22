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
		<div id="p" class="easyui-panel" title="查询条件" style="height: 130px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="searchForm" method="post">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td align="right">渠道名称</td>
						<td align="left" style="padding-left: 5px"><input
							name="" id="" maxlength="8" /></td>
						<td align="right">渠道代码</td>
						<td align="left" style="padding-left: 5px"><input
							name="" id="" maxlength="8" /></td>
						<td class="add" align="right">上级代理</td>
						<td class="add" align="left" style="padding-left: 5px">
						<select id="" name="">
							<option value=''>--请选择上级代理--</option>
						</select></td>
					<tr>
					</tr>
						<td align="right">创建人</td>
						<td align="left" style="padding-left: 5px"><input
							name="" id="" maxlength="8" /></td>
						<td class="add" align="right">生效状态</td>
						<td class="add" align="left" style="padding-left: 5px">
						<select id="" name=""/>
								<option value=''>--请选择生效状态--</option>
								<option value='00'>--在用--</option>
								<option value='99'>--停用--</option>
								</select></td>
						<td class="add" align="right" colspan="3">
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
							missingMessage="请选择所在省" onchange="showCity('province_ins')" /></select> <font color="red">*</font></td>
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
							<td class="update">上级代理</td>
							<td class="update" align="left">
							<select id="supercode" class="easyui-validatebox" required="true" missingMessage="请选择上级代理" name="supercode"/>
								<option value=''>--请选择上级代理--</option>
								<option value='0'></option></select>
							</select><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">联系人</td>
							<td class="update" align="left">
							<input type="text" id="contact" name="contact"
							 maxlength="32" missingMessage="请输入联系人" required="true" /><font color="red">*</font></td>
							<td class="update">联系电话</td>
							<td class="update" align="left">
							<input type="text" id="contPhone" name="contPhone"
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
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveCoopAgencyApply()" id="btn_submit">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>

</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			$('#coopAgencyList').datagrid({
				title:'渠道信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'coopAgency/queryApply',
				remoteSort: false,
				columns:[[
					{field:'cacode',title:'渠道代码',align:'center',width:130},
					{field:'caname',title:'渠道名称',width:130,align:'center'},
					{field:'caprovince',title:'所在省',align:'center',width:120},
					{field:'cacity',title:'所在市',width:130,align:'center'},
					{field:'address',title:'地址',align:'center',width:250},
					{field:'contact',title:'联系人',align:'center',width:120},
					{field:'contPhone',title:'联系电话',align:'center',width:120},
					{field:'calevel',title:'代理商级别',align:'center',width:120},
					{field:'supercode',title:'上级代理商',align:'center',width:120},
					{field:'notes',title:'备注',align:'center',width:120},
					{field:'status',title:'状态',width:60,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "正常";
							}else{
								return "停用";
							}
						}
					},
					{field:'selfId',title:'操作',align:'center',width:120,rowspan:2,
						formatter:function(value,rec){
						if(rec.STATUS=="00"){
							return '<a href="javascript:showChange('+value+')" style="color:blue;margin-left:10px">变更</a>'
						}else{
							return '';
						}
					}}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增代理商信息',
					iconCls:'icon-add',
					handler:function(){
						$("#cacode").removeAttr('readonly');
						showAdd();
						$("#saveForm").attr("action","coopAgency/save");
					}
				}]
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}

		function search(){
			var data={'caCode':$('#a_caCode').val(),'status':$("#a_status").val()};
			$('#bankList').datagrid('load',data);
		}
		
		function showAdd(){
			showProvince();
			//showProfitType();
			$("#saveForm").attr("action","coopAgency/save");
			$('#saveForm :input').val('');
			//$('#bnkProvince_ins').html('');
			//$('#b_profitType').val('');
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
		function showProvince() {
			$.ajax({
				type: "POST",
				url: "province/getAll",
				dataType: "json",
				success: function(json) {
					//var province = $("#bnkProvince_ins").val();
					var html = "<option value=''>--请选择所在省--</option>";
					$.each(json,function(key, value) {
// 						if(value.P_ID==province){
// 							html += '<option value="' + value.P_ID + '" selected="selected">' + value.P_NAME + '</option>';
// 						}else{
							html += '<option value="' + value.pId + '">' + value.pName + '</option>';
// 						}
					}) ;
					$("#caprovince").html(html);
				}
			});
		}
		
		function showCity(type) {
			var pid;
			if (type == 'province_ins') {
				pid = $("#province_ins").val();
			} else {
				pid = $("#bnkProvince_ins").val();
			}
			$.ajax({
				/* type: "POST",
				url: "agency/queryCity",
				data: "pid=" + pid,
				dataType: "json",
				success: function(json) {
					var province = $("#bnkCity_ins").val();
					var html = "<option value=''>--请选择所在市--</option>";
					$.each(json,function(key, value) {
						if(value.C_ID == province){
							html += '<option value="' + value.C_ID + '" selected="selected">' + value.C_NAME + '</option>';
						}else{
							html += '<option value="' + value.C_ID + '">' + value.C_NAME + '</option>';
						}
					});
					if (type == 'province_ins') {
						$("#city_ins").html(html);
					} else {
						$("#bnkCity_ins").html(html);
					}
				}*/
			}); 
		}
			
	</script>
</html>
