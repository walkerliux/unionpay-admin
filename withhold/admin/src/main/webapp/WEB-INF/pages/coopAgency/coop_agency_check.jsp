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
							name="caname" id="s_caname" maxlength="8" /></td>
						<td align="right">渠道代码</td>
						<td align="left" style="padding-left: 5px"><input
							name="cacode" id="s_cacode" maxlength="8" /></td>
						<td class="add" align="right">上级代理</td>
						<td class="add" align="left" style="padding-left: 5px">
						<select id="s_supercode" name="supercode">
							<option value=''>--请选择上级代理--</option>
							<option value='0'></option>
						</select></td>
					<tr>
					</tr>
						<td align="right">创建人</td>
						<td align="left" style="padding-left: 5px"><input
							name="inuser" id="s_inuser" maxlength="8" /></td>
						<td class="add" align="right">生效状态</td>
						<td class="add" align="left" style="padding-left: 5px">
						<select id="s_status" name="status"/>
								<option value=''>--请选择生效状态--</option>
								<option value='10'>注册待审</option>
								<option value='20'>变更待审</option>
								<option value='30'>注销待审</option>
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
					<input type="hidden" id="selfId" name="selfId" />
					<input type="hidden" id="status" name="status" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="update" width="15%">渠道代码</td>
							<td class="update" id="cacode" name="cacode" align="left"></td>
							<td class="update" width="15%">渠道名称 </td>
							<td class="update" id="caname" name="caname" align="left"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">所在省</td>
							<td class="update" id="caprovince" align="left">
							<td class="update">所在市</td>
							<td class="update" id="cacity" align="left">
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">地址</td>
							<td class="update" id="address" align="left">
							<td class="update">上级渠道</td>
							<td class="update" id="supercode" align="left">
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">联系人</td>
							<td class="update" id="contact" align="left">
							<td class="update">联系电话</td>
							<td class="update" id="contPhone" align="left">
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="81" id="notes" maxlength="128" style="resize: none;"
									readonly="readonly"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeCheck()">返回</a>
				&nbsp;&nbsp;
				<a class="easyui-linkbutton checkca" iconCls="icon-cancel" href="javascript:refuseCheck()" id="btn_refuse">驳回</a>
				&nbsp;&nbsp;
				<a class="easyui-linkbutton checkca" iconCls="icon-ok" href="javascript:passCheck()" id="btn_pass">通过</a>
			</div>
		</div>
	</div>

</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			// 显示搜索条件中的上级渠道
			showAllSuperCode();
			$('#coopAgencyList').datagrid({
				title:'渠道信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'coopAgency/queryCheck',
				remoteSort: false,
				columns:[[
					{field:'cacode',title:'渠道代码',align:'center',width:120},
					{field:'caname',title:'渠道名称',width:150,align:'center'},
					{field:'provinceName',title:'所在省',align:'center',width:80},
					{field:'cityName',title:'所在市',width:80,align:'center'},
					{field:'address',title:'地址',align:'center',width:200},
					{field:'contact',title:'联系人',align:'center',width:80},
					{field:'contPhone',title:'联系电话',align:'center',width:100},
					{field:'calevel',title:'渠道级别',align:'center',width:60},
					{field:'superName',title:'上级渠道',align:'center',width:150},
					{field:'notes',title:'备注',align:'center',width:120},
					{field:'status',title:'状态',width:100,align:'center',
						formatter:function(value,rec){
							if (value=="10") {
								return "注册待审";
							}else if (value=="20") {
								return "变更待审";
							}else if (value=="30") {
								return "注销待审";
							}
						}
					},
					{field:'selfId',title:'操作',align:'center',width:120,rowspan:2,
						formatter:function(value,rec){
						if(rec.status=="10" || rec.status=="20" || rec.status=="30"){
							return '<a href="javascript:showCheck(\''+value+'\')" style="color:blue;margin-left:10px">审核</a>';
						}else{
							return '';
						}
					}}
				]],
				pagination:true,
				rownumbers:true
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}

		function search(){
			var data={
				'cacode':$('#s_cacode').val(),
				'caname':$("#s_caname").val(),
				'supercode':$("#s_supercode").val(),
				'inuser':$("#s_inuser").val(),
				'status':$("#s_status").val()
			};
			$('#coopAgencyList').datagrid('load',data);
		}
				
		function showCheck(selfId){
			$('#saveForm :input').val('');
			$('#cacode').attr("readonly","readonly");//设为只读
			//$("#saveForm").attr("action","coopAgency/updateApply");
			$.ajax({
			   type: "POST",
			   url: "coopAgency/queryCheckById",
			   data: "selfId="+selfId,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				    $("#cacode").html(json.cacode);
					$("#caname").html(json.caname);
					$("#caprovince").html(json.provinceName);
					$("#cacity").html(json.cityName);
					$("#address").html(json.address);
					$("#cityName").html(json.cityName);
					$("#contact").html(json.contact);
					$("#contPhone").html(json.contPhone);
					$("#notes").val(json.notes);
					$("#selfId").val(json.selfId);
					$("#status").val(json.status);
			    }
			});
			
			$('#w').window({
				title: '审核渠道信息',
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
		
		function showAllSuperCode(){
			$.ajax({
				type : "POST",
				url: "coopAgency/queryAllSuperCode",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择上级代理--</option>";
					html += "<option value='0'></option>";
					$.each(json,function(key, value) {
							html += '<option value="' + value.cacode + '">' + value.caname + '</option>';
					});
					$("#s_supercode").html(html);
				}
			});
		}
		
		function refuseCheck(){
			$('.checkca').linkbutton('disable');
			var selfId = $("#selfId").val();
			var status = $("#status").val();
			$.ajax({
				type : "POST",
				url: "coopAgency/refuseCheck",
				dataType: "json",
				data:{
					selfId:selfId,
					status:status
				},
				success: function(json) {
					$('.checkca').linkbutton('enable');
					//json = JSON.parse(json);
		    		if(json.resultBool==true){
						 $.messager.alert('提示',"已成功驳回！");
						 $('#w').window('close');
						 search();
					}else{
						 $.messager.alert('提示',json.errMsg);
					}
				},
				error:function(){
					$.messager.alert('提示','服务异常！');
				}
			});
		}
		
		function passCheck(){
			$('.checkca').linkbutton('disable');
			var selfId = $("#selfId").val();
			var status = $("#status").val();
			$.ajax({
				type : "POST",
				url: "coopAgency/passCheck",
				dataType: "json",
				data:{
					selfId:selfId,
					status:status
				},
				success: function(json) {
					$('.checkca').linkbutton('enable');
					//json = JSON.parse(json);
		    		if(json.resultBool==true){
						 $.messager.alert('提示',"已审核通过！");
						 $('#w').window('close');
						 search();
					}else{
						 $.messager.alert('提示',json.errMsg);
					}
				},
				error:function(){
					$.messager.alert('提示','服务异常！');
				}
			});
		}
		
		function closeCheck(){
			$('#w').window('close');
		}	
	</script>
</html>
