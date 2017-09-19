<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<body>
	<style type="text/css">
table tr td {
	height: 25px
}

table tr td input {
	height: 15px
}

table tr td select {
	height: 20px
}
</style>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 100px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<input type="hidden" id="flag_ins" value="${flag}" />
				<table width="100%">
					<tr>
						<td align="right" width="10%">委托机构编号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							id="merchId_ins" maxlength="15" /></td>
						<td align="right" width="10%">委托机构名称</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							id="memberName_ins" maxlength="50" /></td>
						<td align="right">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
					</tr>

				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>

	</div>
	
</body>

<script>
  	
		$(function(){
			
			$('#test').datagrid({
				title:'委托机构信息列表',
				iconCls:'icon-save',
				height:600,
				singleSelect:true,
				nowrap: false,
				striped: true,
				url:'emailNotify/queryEmailNotiy',
				remoteSort: false,
				columns:[
				[
					{field:'MEMBER_ID',title:'委托机构编号',align:'center',width:120},
					{field:'MEMBER_NAME',title:'委托机构名称',width:150,align:'center'},
					{field:'EMAIL',title:'电子邮箱',width:120,align:'center'},
					{field:'SEND_TIMES',title:'发送次数',width:100,align:'center'}, 
					{field:'MAX_SEND_TIMES',title:'最大发送次数',width:100,align:'center'},
					{field:'FLAG',title:'发送状态',width:100,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "已发送";
							}else{
								return "未发送";
							}
						}
					},
					
					{field:'DEPT_ID',title:'操作',width:100,align:'center',
							formatter:function(value,rec){
								if(Number(rec.SEND_TIMES)<Number(rec.MAX_SEND_TIMES)){
									return '<a href="javascript:sendeMail('+rec.MEMBER_ID+','+rec.ID+')" style="color:blue;margin-left:10px">发送邮件</a>';
								}
								
							}
						}
						
					]],
					pagination:true,
					rownumbers:true
			});
			
			
			
		});
		function search(){
			//var url="agency/queryMerch?flag="+$("#flag").val();
			var data={
					'memberId':$('#merchId_ins').val(),
					'memberName':$('#memberName_ins').val()
					};
			$('#test').datagrid('load',data);
		}
		function resize(){
			$('#theForm :input').val('');
		}
		
		function sendeMail(memberId,tid){
			$.ajax({
				type: "POST",
				url: "emailNotify/sendEmailNotify",
				data:{'memberId':memberId,'tid':tid},
				dataType: "json",
				success: function(json) {
					$.messager.alert('提示',json.INFO);
					search();
				}
			});
		}
		
	</script>
</html>
