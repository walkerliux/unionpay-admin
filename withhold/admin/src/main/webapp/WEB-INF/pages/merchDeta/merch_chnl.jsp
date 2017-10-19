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
					<input type="hidden" id="selfId" name="selfId" />
					<input type="hidden" id="status" name="status" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="update">商户号</td>
							<td class="update" align="left">
							<input type="text" id="memberId" name="memberId" class="easyui-validatebox" required="true"
								maxlength="15" missingMessage="请输入商户号"/><font color="red">*</font></td>
							<td class="update" width="15%">商户名 </td>
							<td class="update" align="left">
							<input type="text" id="memberName" name="memberName" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入商户名称 " /><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">商户公钥</td>
							<td class="update" align="left">
							<input type="text" id="pubkey" name="pubkey" class="easyui-validatebox" required="true"
								maxlength="15" missingMessage="请输入商户公钥"/><font color="red">*</font></td>
							<td class="update" width="15%">商户私钥 </td>
							<td class="update" align="left">
							<input type="text" id="prikey" name="prikey" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入商户私钥 " /><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">通道1</td>
						</tr>
						<tr style="height: 25px">
							<td class="update">通道名称</td>
							<td class="update" align="left"  >
							<select id="caname" class="easyui-validatebox" required="true" missingMessage="请选择渠道" name="transfactors" />
								<option value='' >-----------------------</option></select>
							</select><font color="red">*</font></td>
							<td class="update">通道商户号</td>
							<td class="update" align="left">
							<input type="text" id="chnlmercno" name="chnlmercno" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入通道商户号"/><font color="red">*</font></td>
						</tr>
						<tr>
							<td class="update">商户公钥</td>
							<td class="update" align="left">
							<input type="text" id="chnlpubkey" name="chnlpubkey" class="easyui-validatebox" required="true"
								maxlength="15" missingMessage="请输入商户公钥"/><font color="red">*</font></td>
						</tr>		
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">取消</a>
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:addchnl()" id="btn_submit">增加通道</a>
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveCoopAgencyApply()" id="btn_submit">保存</a>
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
				title:'',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'merchDeta/queryMerchChnl',
				remoteSort: false,
				columns:[[
					{field:'merchno',title:'商户号',align:'center',width:120},
					{field:'memberName',title:'商户名称',width:150,align:'center'},
					{field:'chnlcode',title:'通道编号',align:'center',width:200},
					{field:'chnlname',title:'通道名称',align:'center',width:100},
					{field:'chnlmercno',title:'通道商户号',align:'center',width:100},
					{field:'transfactors',title:'交易要素',align:'center',width:200},
					{field:'status',title:'状态',width:100,align:'center',
						formatter : function(value, rec) {
							if (value == "00") {
								return "有效";
							}
						}
					},
					{field:'merchId',title:'操作',align:'center',width:120,rowspan:2,
						formatter : function(value, rec) {
							if (rec.status == "00") {
								return '<a href="javascript:showChange(\''
										+ value
										+ '\')" style="color:blue;margin-left:10px">修改</a>';
							} else {
								return '';
						}
					}
				}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增',
					iconCls:'icon-add',
					handler:function(){
						showAdd();
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
				'cacode':$("#s_cacode").val()
			};
			$('#merchDetaList').datagrid('load',data);
		}
		
		function showAdd(){
			$('#memberId').removeAttr("readonly");//取消只读的设置
			
			$("#saveForm").attr("action","merchDeta/addMerchDetaChnl");
			$('#saveForm :input').val('');
			
			$.ajax({
				   type: "POST",
				   url: "merchDeta/addMerchChnl",
				   data: "selfId="+selfId,
				   async: false,
				   dataType:"json",
				   success: function(json){	
					   if (json == null) {
							$.messager.alert('提示', '该商户信息不存在，或已被变更，请刷新一下数据再试试！');
						} else {
							$("#memberId").val(json.memberId);
							$("#memberName").val(json.memberName);
							$("#pubkey").val(json.pubkey);
							$("#prikey").val(json.prikey);
							$("#caname").val(json.caname);
							$("#chnlmercno").val(json.chnlmercno);
							$("#chnlpubkey").val(json.chnlpubkey);
							
			$('#w').window({
				title: '商户通道维护',
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
		
		function showChange(selfId){
			$('#saveForm :input').val('');
			$('#cacode').attr("readonly","readonly");//设为只读
			$("#saveForm").attr("action","coopAgency/updateApply");
			$.ajax({
			   type: "POST",
			   url: "merchDeta/queryMerchChnlById",
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
		
		
		function showCacode(supercode){
			$.ajax({
				type : "POST",
				url: "coopAgency/queryAllSuperCode",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择渠道--</option>";
					
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
					var html = "<option value=''>--请选择渠道--</option>";
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
		
		function showMCC(mcc){
			$.ajax({
				type : "POST",
				url: "mcc/getAllMCC",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择MCC大类--</option>";
					
					$.each(json,function(key, value) {
						if (value.mcc == mcc) {
							html += '<option value="' + value.mcc + '" selected="selected">' + value.mccname + '</option>';
						} else {
							html += '<option value="' + value.mcc + '">' + value.mccname + '</option>';
						}
					});
					$("#mcc").html(html);
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
		function addchnl(){
			
		}
		function closeAdd(){
			$('#w').window('close');
		}
				 
	</script>
</html>
