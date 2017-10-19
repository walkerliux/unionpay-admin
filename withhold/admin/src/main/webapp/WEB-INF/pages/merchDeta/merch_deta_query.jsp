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
						<td class="add" align="right">状态</td>
						<td class="add" align="left" style="padding-left: 5px">
						<select id="s_status" name="status"/>
								<option value=''>全部</option>
								<option value='00'>在用</option>
								<option value='10'>注册待审</option>
								<option value='11'>注册被拒</option>
								<option value='20'>变更待审</option>
								<option value='21'>变更被拒</option>
								<option value='30'>注销待审</option>
								<option value='99'>已注销</option>
								</select></td>
						<td class="add" align="right" colspan="4">
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
							<a href="javascript:resize()" class="easyui-linkbutton"iconCls="icon-redo">清空</a></td>
						<td class="add" align="right"></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="merchDetaList">
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
							<td class="update" width="15%">商户号</td>
							<td class="update" id="memberId" name="memberId" align="left"></td>
							<td class="update" width="15%">商户名称 </td>
							<td class="update" id="memberName" name="memberName" align="left"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update" width="15%">营业地址</td>
							<td class="update" id="address" name="address" align="left"></td>
							<td class="update" width="15%">邮编 </td>
							<td class="update" id="postCode" name="postCode" align="left"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>	
						
						
						<tr style="height: 25px">
							<td class="update" width="15%">联系人</td>
							<td class="update" id="contact" name="contact" align="left"></td>
							<td class="update" width="15%">联系人电话 </td>
							<td class="update" id="contPhone" name="contPhone" align="left"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update" width="15%">联系人地址</td>
							<td class="update" id="contAddress" name="contAddress" align="left"></td>
							<td class="update" width="15%">联系人邮编 </td>
							<td class="update" id="contPost" name="contPost" align="left"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update" width="15%">联系人邮箱</td>
							<td class="update" id="contEmail" name="contEmail" align="left" colspan="3"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						
						
						<tr style="height: 25px">
							<td class="update" width="15%">渠道</td>
							<td class="update" id="caname" name="caname" align="left"></td>							
							<td class="update" width="15%">交易要素</td>
							<td class="update" id="transfactorsName" name="transfactorsName" align="left"></td>
							
						</tr>
						<tr style="height: 25px">
							<td class="update" width="15%">所属行业</td>
							<td class="update" id="mcc" name="mcc" align="left" colspan="3"></td>
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
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeDetail()">返回</a>
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
				url:'merchDeta/queryAll',
				remoteSort: false,
				columns:[[
					{field:'memberId',title:'商户号',align:'center',width:120},
					{field:'memberName',title:'商户名称',width:150,align:'center'},
					{field:'address',title:'营业地址',align:'center',width:200},
					{field:'contact',title:'联系人',align:'center',width:80},
					{field:'contPhone',title:'联系电话',align:'center',width:100},
					{field:'contAddress',title:'联系人地址',align:'center',width:200},
					{field:'contPost',title:'联系人邮箱',align:'center',width:120},
					{field:'caname',title:'渠道',align:'center',width:150},
					{field:'notes',title:'备注',align:'center',width:120},
					{field:'status',title:'状态',width:100,align:'center',
						formatter:function(value,rec){
							if (value=="00") {
								return "在用";
							}else if (value=="10") {
								return "注册待审";
							}else if (value=="11") {
								return "注册被拒";
							}else if (value=="20") {
								return "变更待审";
							}else if (value=="21") {
								return "变更被拒";
							}else if (value=="30") {
								return "注销待审";
							}else if (value=="99") {
								return "已注销";
							}
						}
					},
					{field:'selfId',title:'操作',align:'center',width:120,rowspan:2,
						formatter:function(value,rec){
						return '<a href="javascript:showDetail(\''+value+'\')" style="color:blue;margin-left:10px">详情</a>';
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
				'memberId':$('#s_memberId').val(),
				'memberName':$("#s_memberName").val(),
				'cacode':$("#s_cacode").val(),
				'status':$("#s_status").val()
			};
			$('#merchDetaList').datagrid('load',data);
		}
				
		function showDetail(selfId){
			$.ajax({
			   type: "POST",
			   url: "merchDeta/queryDetailById",
			   data: "selfId="+selfId,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   if (json == null) {
						$.messager.alert('提示', '该商户信息不存在，或已被变更，请刷新一下数据再试试！');
					} else {
					    $("#memberId").html(json.memberId);
						$("#memberName").html(json.memberName);
						$("#address").html(json.address);
						$("#postCode").html(json.postCode);
						$("#contact").html(json.contact);
						$("#contPhone").html(json.contPhone);
						$("#contAddress").html(json.contAddress);
						$("#contPost").html(json.contPost);
						$("#contEmail").html(json.contEmail);
						$("#caname").html(json.caname);
						$("#transfactorsName").html(json.transfactorsName);
						$("#mcc").html("MCC大类：" + json.mccName + "，  MCC小类：" + json.mccListName);
						$("#notes").val(json.notes);
						
						$('#w').window({
							title: '审核商户信息',
							top:100,
							left:400,
							width: 800,
							modal: true,
							minimizable:false,
							collapsible:false,
							maximizable:false,
							shadow: false,
							closed: false,
							height: 409
						});
					}
			    },
				error : function(){
					$.messager.alert('提示', '服务异常！');
				}
			});
			
		}
		
		function showAllCacode(){
			$.ajax({
				type : "POST",
				url: "coopAgency/queryAllSuperCode",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择渠道--</option>";
					$.each(json,function(key, value) {
							html += '<option value="' + value.cacode + '">' + value.caname + '</option>';
					});
					$("#s_cacode").html(html);
				}
			});
		}
		
		
		function closeDetail(){
			$('#w').window('close');
		}	
		
	</script>
</html>
