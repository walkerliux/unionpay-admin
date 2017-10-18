<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>
<script type="text/javascript" src="js/checkboxbeautify/jquery-hcheckbox.js"></script>
<link href='js/checkboxbeautify/css.css' rel="stylesheet" type="text/css" />
<style type="text/css">
.left, .mid, .right {
	width: auto;
	float: left;
}

.form-control {
	border: 2px solid #A9C9E2;
}
.activeflag_label {
	width: 90px
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
						<td align="right">通道名称</td>
						<td align="left" style="padding-left: 5px"><input
							name="chnlname" id="s_chnlname" maxlength="8" /></td>
						<td align="right">通道代码</td>
						<td align="left" style="padding-left: 5px"><input
							name="chnlcode" id="s_chnlcode" maxlength="8" /></td>
					<tr>
					</tr>
						<td class="add" align="right">生效状态</td>
						<td class="add" align="left" style="padding-left: 5px">
						<select id="s_status" name="status"/>
								<option value=''>全部</option>
								<option value='00'>启用</option>
								<option value='01'>禁用</option>
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
			<table id="channelList">
			</table>
		</div>
	</div>
	
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="saveForm" action="" method="post">
					<input type="hidden" id="debitdata" name="debitdata" />
					<input type="hidden" id="creditdata" name="creditdata" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="update">通道代码</td>
							<td class="update" align="left">
							<input type="text" id="chnlcode" name="chnlcode" class="easyui-validatebox" required="true"
								maxlength="11" /></td>
							<td class="update" width="15%">通道名称 </td>
							<td class="update" align="left">
							<input type="text" id="chnlname" name="chnlname" class="easyui-validatebox" required="true"
								maxlength="64"  /></td>
						</tr>
						<tr style="height: 25px">
							<td colspan="4" class="head-title">
								借记卡
							</td>
						</tr>
						<tr>
							<td id="debit" colspan="4" ></td>
						</tr>
						<tr style="height: 25px">
							<td colspan="4" class="head-title">
								贷记卡
							</td>
						</tr>
						<tr>
							<td id="credit" colspan="4" ></td>
						</tr>
						<tr style="height: 25px">
						
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
				<a class="easyui-linkbutton" id="submitok" iconCls="icon-ok" href="javascript:saveChannel()" id="btn_submit">提交</a>
			</div>
		</div>
	</div>

</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			$('#channelList').datagrid({
				title:'渠道信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'channel/queryChannel',
				remoteSort: false,
				columns:[[
					{field:'chnlcode',title:'通道代码',align:'center',width:120},
					{field:'chnlname',title:'通道名称',width:150,align:'center'},
					{field:'address',title:'地址',align:'center',width:200},
					{field:'contact',title:'联系人',align:'center',width:80},
					{field:'contPhone',title:'联系电话',align:'center',width:100},
					{field:'notes',title:'备注',align:'center',width:120},
					{field:'status',title:'状态',width:100,align:'center',
						formatter:function(value,rec){
							if (value=="00") {
								return "启用";
							}else  {
								return "禁用";
							}
						}
					},
					{field:'chnlid',title:'操作',align:'center',width:120,rowspan:2,
						formatter:function(value,rec){
							return '<a href="javascript:showChange(\''+rec.chnlcode+'\')" style="color:blue;margin-left:10px">银行权限</a>';
						}
					}
				]],
				pagination:true,
				rownumbers:true,
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}

		function search(){
			var data={
				'chnlcode':$('#s_chnlcode').val(),
				'chnlname':$("#s_chnlname").val(),
				'inuser':$("#s_inuser").val(),
				'status':$("#s_status").val()
			};
			$('#channelList').datagrid('load',data);
		}
		function showChange(selfId){
			$('#saveForm :input').val('');
			$('#chnlcode').attr("readonly","readonly");//设为只读
			$('#chnlname').attr("readonly","readonly");//设为只读
			$("#saveForm").attr("action","channel/changeChannelBank");
			$("#ratestd").hide();
			$("#ratesntd").hide();
			$("#submitok").show();
			getinfo(selfId);
		}
		function getinfo(selfId){
			var rows = $('#channelList').datagrid('getSelected');
			var chnlname =rows["chnlname"];
			var chnlcode =rows["chnlcode"];
			
			$.ajax({
				   type: "POST",
				   url: "channel/queryChannelBankById",
				   data: "selfId="+selfId,
				   async: false,
				   dataType:"json",
				   success: function(json){	
					   if (json == null) {
							$.messager.alert('提示', '该通道信息不存在，或已被变更，请刷新一下数据再试试！');
						} else {
							var debitdata="";
							var creditdata="";
							var debithtml="";
							var credithtml="";
							var mark=1;
							var mark1=1;
						    $("#chnlcode").val(chnlcode);
							$("#chnlname").val(chnlname);
							$.each(json.debit,
									function(key, value) {
									   if(value.CHNLCODE !== null && value.CHNLCODE !== undefined){
											if(debitdata==""){
												debitdata+=value.bankCode;
											}else{
												debitdata=debitdata +"|" + value.bankCode;
											}
											debithtml += '<input type="checkbox"  checked="checked id="debitcheckboxList" name="debitcheckboxList" style="align:left" value="' + value.bankCode + '" /><label class="activeflag_label">' + value.bankName + '</label>';
										}
										else{ 
											debithtml += '<input type="checkbox"  name="debitcheckboxList" id="debitcheckboxList" style="align:left" value="' + value.bankCode + '" /><label class="activeflag_label">' + value.bankName + '</label>';
										}
										
										if (mark%4==0) {
											debithtml += '<br/>';
								  		}
								  		mark = mark + 1;
									});
							$.each(json.credit,
									function(key, value) {
									   if(value.CHNLCODE !== null && value.CHNLCODE !== undefined){
												if(creditdata==""){
													creditdata+=value.bankCode;
												}else{
													creditdata=creditdata +"|" + value.bankCode;
												}
												credithtml += '<input type="checkbox"  checked="checked id="creditcheckboxList" name="creditcheckboxList" style="align:left" value="' + value.bankCode + '" /><label class="activeflag_label">' + value.bankName + '</label>';
										}
										else{ 
											credithtml += '<input type="checkbox"   name="creditcheckboxList" id="creditcheckboxList" style="align:left" value="' + value.bankCode + '" /><label class="activeflag_label">' + value.bankName + '</label>';
										}
										
										if (mark1%4==0) {
											credithtml += '<br/>';
								  		}
										mark1 = mark1 + 1;
									});
							$("#debit").html(debithtml);
							$("#credit").html(credithtml);
							$('#debit').hcheckbox();
							$('#credit').hcheckbox();
							$("#debitdata").val(debitdata);
							$("#creditdata").val(creditdata);
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
		
		function showAllRate(caprovince) {
			$.ajax({
				type: "POST",
				url: "rateAccum/getAllRateList",
				dataType: "json",
				success: function(json) {
					var html = "";
					$.each(json,function(key, value) {
						if(value.rateId==caprovince){
							html += '<option value="' + value.rateId + '" selected="selected">' + value.rateDesc + '</option>';
						}else{
							html += '<option value="' + value.rateId + '">' + value.rateDesc + '</option>';
						}
					}) ;
					$("#rates").html(html);
				}
			});
		}
		
		function saveChannel(){
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
