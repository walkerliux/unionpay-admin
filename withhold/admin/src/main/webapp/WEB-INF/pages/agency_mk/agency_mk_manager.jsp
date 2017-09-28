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
	<div style="padding-top: 5px; margin-left: 5px; margin-right: 5px"
		id="continer">
		<div id="p" class="easyui-panel" title="查询条件" style="height: 80px; padding-top: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td class="add" align="right">委托机构号</td>
						<td class="add" align="left" style="padding-left: 5px"><input id="a_memberId" name="memberId" /></td>
						<td class="add" align="right" colspan="3">
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
							<a href="javascript:resize()" class="easyui-linkbutton"iconCls="icon-redo">清空</a></td>
						<td class="add" align="right"></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="bankList">
			</table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="saveForm" action="agencyMK/updateMerchMk" method="post">
					<input type="hidden" id="b_memberId" name="memberId"/>
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="update">委托机构号</td>
							<td class="update" align="left"><span id="memberId"></span></td>
						</tr>
						<tr style="height: 35px">
							<td class="update">委托机构公钥</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="4" cols="120" id="memberPubKey" maxlength="2048" name="memberPubKey" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="120" id="b_notes" maxlength="2048" name="notes" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveUser()" id="btn_submit" onclick="">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			$('#bankList').datagrid({
				title:'委托机构秘钥信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'agencyMK/query',
				remoteSort: false,
				columns:[[
					{field:'MEMBERID',title:'委托机构号',align:'center',width:130},
					{field:'SAFESEQ',title:'安全序列号',width:130,align:'center'},
					{field:'SAFETYPE',title:'安全类型',width:120,align:'center',
						formatter:function(value,rec){
							if(value=="01"){
								return "RSA";
							}else{
								return "其他";
							}
						}
					},
					{field:'STORGETYPE',title:'存储方式 ',width:130,align:'center',
						formatter:function(value,rec){
							if(value=="01"){
								return "字符串";
							}else if(value=="02"){
								return "文件";
							}
						}
					},
					{field:'STATUS',title:'状态',width:120,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "正常";
							}else{
								return "注销";
							}
						}
					},
					{field:'TID',title:'操作',align:'center',width:120,rowspan:2,
						formatter:function(value,rec){
							if(rec.STATUS=="00"){
								return '<a href="javascript:showUser('+rec.MEMBERID+')" style="color:blue;margin-left:10px">更新</a>';
							}
					}}
				]],
				pagination:true,
				rownumbers:true,
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function closeAdd(){
			$('#w').window('close');
		}
		
		function search(){
			var data={'memberId':$('#a_memberId').val()};
			$('#bankList').datagrid('load',data);
		}
		
		function saveUser(){
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
			    	json = eval('(' + json + ')');
		    		if(json.RET=='succ'){
						 $.messager.confirm('提示', json.INFO);
						 search();
						 closeAdd();
					 }else{
						 $.messager.alert("提示",json.INFO);
					 }
				}
			});  
		}
		
		function showUser(value){
			$('#saveForm :input').val('');
			$.ajax({
			   type: "POST",
			   url: "agencyMK/findById",
			   data: "memberId="+value,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				    $("#memberId").html(json.memberId);
				    $("#b_memberId").val(json.memberId);
					$("#memberPubKey").val(json.memberPubKey);
					$("#memberPrikey").val(json.memberPrikey);
					$("#localPubKey").val(json.localPubKey);
					$("#localPriKey").val(json.localPriKey);
					$("#b_notes").val(json.notes);
			   }
			});
			$('#w').window({
				title: '更新委托机构秘钥',
				top:100,
				left:400,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 250
			});
		}

	</script>
</html>
