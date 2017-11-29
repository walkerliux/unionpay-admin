<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript"
	src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>
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
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 130px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="searchForm" method="post">
				<form action="" id="searchForm">
					<table width="100%">
					<tr>
						<td align="right">商户号</td>
						<td align="left" style="padding-left: 5px"><input
							name="memberId" id="s_memberId" maxlength="15" /></td>
						<td align="right">商户名称</td>
						<td align="left" style="padding-left: 5px"><input
							name="memberName" id="s_memberName" maxlength="64" /></td>
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
					<input type="hidden" id="safeseq" name="safeseq" />
					<input type="hidden" id="memberid" name="memberid" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="update" width="15%">商户号</td>
							<td class="update" align="left" id="memberId" name="memberId"></td>
							<td class="update" width="15%">商户名称 </td>
							<td class="update" align="left"  id="memberName" name="memberName"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">安全序列号</td>
							<td class="update" align="left" id="safeseq_show">
							
							<td class="update">安全类型</td>
							<td class="update" align="left">
							<select id="safetype" name="safetype" class="easyui-validatebox" required="true" missingMessage="请选择安全类型"/>
							<option value=''>--请选择安全类型--</option>
							</select><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
						<td class="update">证书ID</td>
							<td class="update" align="left">
							<input type="text" id="certid" name="certid" maxlength="32"/></td>
							<td class="update">存储方式</td>
							<td class="update" align="left">
							<select id="storgetype" name="storgetype" class="easyui-validatebox" required="true" missingMessage="请选择存储方式"/>
							<!-- <option value=''>--请选择存储方式--</option> -->
							</select><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">商户公钥证书</td>
							<td class="update" align="left" colspan="3">
								<input type="text" id="memberpubkey" name="memberpubkey" maxlength="128" class="easyui-validatebox" required="true" missingMessage="请输入商户公钥证书 " validType="url" />
								<%-- <textarea class="easyui-validatebox" required="true" missingMessage="请输入商户公钥证书 " rows="3" cols="81" id="memberpubkey" maxlength="2048" name="memberpubkey" style="resize: none;"
										onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea> --%>
								<font color="red">*</font>
							</td>
						</tr>
						<tr style="height: 25px">
							<td class="update">平台公钥证书</td>
							<td class="update" align="left" colspan="3">
								<input type="text" id="localpubkey" name="localpubkey" maxlength="128" class="easyui-validatebox" required="true" missingMessage="请输入平台公钥证书 " validType="url" />
								<%-- <textarea class="easyui-validatebox" required="true" missingMessage="请输入平台公钥 证书" rows="3" cols="81" id="localpubkey" maxlength="2048" name="localpubkey" style="resize: none;"
										onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea> --%>
								<font color="red">*</font>
							</td>
						</tr>
						<tr style="height: 25px">
							<td class="update">平台私钥证书</td>
							<td class="update" align="left" colspan="3">
								<input type="text" id="localprikey" name="localprikey" maxlength="128" class="easyui-validatebox" required="true" missingMessage="请输入平台私钥证书 " validType="url" />
								<%-- <textarea class="easyui-validatebox" required="true" missingMessage="请输入平台私钥 证书" rows="3" cols="81" id="localprikey" maxlength="2048" name="localprikey" style="resize: none;"
										onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea> --%>
								<font color="red">*</font>
							</td>
						</tr>
						<tr style="height: 25px">
							<td class="update">平台私钥证书密码</td>
							<td class="update" align="left" colspan="3">
								<input type="text" id="platformpfxpwd" name="platformpfxpwd" maxlength="32" class="easyui-validatebox" required="true" missingMessage="请输入平台私钥证书 " onkeyup="value=value.replace(/<[^<]+>/g,'')"/>
								<%-- <textarea class="easyui-validatebox" required="true" missingMessage="请输入平台私钥 证书" rows="3" cols="81" id="localprikey" maxlength="2048" name="localprikey" style="resize: none;"
										onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea> --%>
								<font color="red">*</font>
							</td>
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
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeMK()">返回</a>
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:submitMK()" id="btn_submit">提交</a>
			</div>
		</div>
	</div>

</body>
<script>
	var width = $("#continer").width();
	$(function() {
		// 显示搜索条件中的渠道
		showAllCacode("serch");

		$('#merchDetaList').datagrid({
			title:'商户信息列表',
			iconCls:'icon-save',
			height:600,
			nowrap: false,
			striped: true,
			singleSelect:true,
			url : 'merchDeta/queryModify',
			remoteSort : false,
				columns : [ [
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
						formatter : function(value, rec) {
							if (value == "00") {
								return "有效";
							}
						}
					},
					{field:'safeseq',title:'操作',align:'center',width:120,rowspan:2,
						formatter : function(value, rec) {
							if (rec.status == "00") {
								return '<a href="javascript:showMK(\''
										+ rec.memberId
										+ '\',\'' 
										+ rec.memberName
										+ '\')" style="color:blue;margin-left:10px">密钥管理</a>';
							} else {
								return '';
							}
						}
					} 
				] ],
				pagination : true,
				rownumbers : true
		});
	});

	function resize() {
		$('#searchForm :input').val('');
	}

	function search() {
		var data = {
			'memberId':$('#s_memberId').val(),
			'memberName':$("#s_memberName").val(),
			'cacode':$("#s_cacode").val()
		};
		$('#merchDetaList').datagrid('load', data);
	}


	function showMK(memberid,memberName) {
		$('#saveForm :input').val('');
		$("#saveForm").attr("action","merchMK/submitMK");
		$("#memberId").html(memberid);
		$("#memberName").html(memberName);
		$("#safeseq_show").html('');
		$("#memberid").val(memberid);
		//showAllSafeType();
		//showAllStorgeType();
		$.ajax({
			type : "POST",
			url : "merchMK/queryMKById",
			data : "memberid=" + memberid,
			async : false,
			dataType : "json",
			success : function(json) {
				if (json != null) {
					$("#safeseq_show").html(json.safeseq);
					$("#safeseq").val(json.safeseq);
					//$("#safetype").val(json.safetype);
					showAllSafeType(json.safetype);
					$("#certid").val(json.certid);
					//$("#storgetype").val(json.storgetype);
					showAllStorgeType(json.storgetype);
					
					$("#memberpubkey").val(json.memberpubkey);
					$("#localpubkey").val(json.localpubkey);
					$("#localprikey").val(json.localprikey);
					$("#platformpfxpwd").val(json.platformpfxpwd);
					
					$("#notes").val(json.notes);
					
				} else {
					showAllSafeType();
					showAllStorgeType();
				}
				$('#w').window({
					title : '管理商户密钥',
					top : 100,
					left : 400,
					width : 850,
					modal : true,
					minimizable : false,
					collapsible : false,
					maximizable : false,
					shadow : false,
					closed : false,
					height : 415
				});
			},
			error : function(){
				$.messager.alert('提示', '服务异常！');
			}
		});
	}

	function showAllCacode(type){
		$.ajax({
			type : "POST",
			url: "coopAgency/queryAllSuperCode",
			dataType: "json",
			success: function(json) {
				var html = "<option value=''>--请选择渠道--</option>";
				html += "<option value='0'></option>";
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
	
	function showAllSafeType(safetype){
		$.ajax({
			type : "POST",
			url: "merchMK/showAllSafeType",
			dataType: "json",
			success: function(json) {
				var html = "<option value=''>--请选择安全类型--</option>";
				
				$.each(json,function(key, value) {
					if (value.paraCode == safetype) {
						html += '<option value="' + value.paraCode + '" selected="selected">' + value.paraName + '</option>';
					} else {
						html += '<option value="' + value.paraCode + '">' + value.paraName + '</option>';
					}
				});
				$("#safetype").html(html);
			}
		});
	}
	function showAllStorgeType(storgetype){
		$.ajax({
			type : "POST",
			url: "merchMK/showAllStorgeType",
			dataType: "json",
			success: function(json) {
				//var html = "<option value=''>--请选择存储方式--</option>";
				var html = "";
				$.each(json,function(key, value) {
					if (value.paraCode == storgetype) {
						html += '<option value="' + value.paraCode + '" selected="selected">' + value.paraName + '</option>';
					} else {
						html += '<option value="' + value.paraCode + '">' + value.paraName + '</option>';
					}
				});
				$("#storgetype").html(html);
			}
		});
	}
	
	function submitMK(){
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
					 $.messager.alert('提示',"提交成功！");
					 $('#w').window('close');
					 search();
				}else{
					 $.messager.alert('提示',json.errMsg);
				}
			}
		}); 
	}
	
	function closeMK(){
		$('#w').window('close');
	}	

</script>
</html>
