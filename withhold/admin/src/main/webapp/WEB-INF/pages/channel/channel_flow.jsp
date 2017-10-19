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
						<td align="right">控制目标</td>
						<td align="left" style="padding-left: 5px">
							<select id="s_target" name="target"/>
								<option value=''>----全部----</option>
								<option value='0'>渠道</option>
								<option value='1'>商户</option>
								</select>
						</td>
						<td align="right">通道名称</td>
						<td id ="channelName" align="left" style="padding-left: 5px">
							<select id="schannelName" name="target"/>
								
							</select>
						</td>
						<td align="right">商户号</td>
						<td  align="left" style="padding-left: 5px">
							<input name="merchNo" id="s_merchNo" maxlength="8" />
						</td>
					<tr>
					</tr>
						<td class="add" align="right" colspan="4"></td>
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
					<input type="hidden" id="chnlid" name="chnlid" />
					<input type="hidden" id="status" name="status" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="update">通道代码</td>
							<td class="update" align="left">
							<input type="text" id="chnlcode" name="chnlcode" class="easyui-validatebox" required="true"
								maxlength="11" missingMessage="请输入通道代码"/><font color="red">*</font></td>
							<td class="update" width="15%">通道名称 </td>
							<td class="update" align="left">
							<input type="text" id="chnlname" name="chnlname" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入通道名称 " /><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">地址</td>
							<td class="update" align="left">
							<input type="text" id="address" name="address" class="easyui-validatebox" required="true"
								maxlength="255" missingMessage="请输入地址" /><font color="red">*</font></td>
							<td id="ratesntd" class="update">收费代码</td>
							<td id="ratestd" class="update" align="left">
							<select id="rates" name="rates" class="easyui-validatebox"  name="supercode"/>
								<option value=''>--请选择收费代码--</option>
							</select></td>
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
				<a class="easyui-linkbutton" id="submitok" iconCls="icon-ok" href="javascript:saveChannel()" id="btn_submit">提交</a>
			</div>
		</div>
	</div>

</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			showAllChannl();
			$('#channelList').datagrid({
				title:'渠道信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'channel/queryChannelFlow',
				remoteSort: false,
				columns:[[
					{field:'target',title:'控制目标',align:'center',width:120},
					{field:'chnlcode',title:'通道代码',width:150,align:'center'},
					{field:'merchno',title:'商户号',align:'center',width:200},
					{field:'controltype',title:'控制类型',align:'center',width:80},
					{field:'seconds',title:'秒数',align:'center',width:100},
					{field:'flows',title:'限制笔数',align:'center',width:100},
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
					{field:'tid',title:'操作',align:'center',width:120,rowspan:2,
						formatter:function(value,rec){
							return '<a href="javascript:showChange(\''+value+'\')" style="color:blue;margin-left:10px">修改</a><a href="javascript:showDetail(\''+value+'\')" style="color:blue;margin-left:10px">注销</a>';
						}
					}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增通道信息',
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
				'target':$('#s_target').val(),
				'chnlcode':$("#schannelName").val(),
				'merchno':$("#s_merchNo").val()
			};
			$('#channelList').datagrid('load',data);
		}
		
		function showAdd(){
			$('#chnlcode').removeAttr("readonly");//取消只读的设置
			$("#ratestd").show();
			$("#ratesntd").show();
			$("#submitok").show();
			showAllRate();//获取收费代码
			$("#saveForm").attr("action","channel/addChannel");
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
			$('#chnlcode').attr("readonly","readonly");//设为只读
			$("#saveForm").attr("action","channel/updateChannel");
			$("#ratestd").hide();
			$("#ratesntd").hide();
			$("#submitok").show();
			getinfo(selfId);
		}
		
		function showDetail(selfId){
			$('#saveForm :input').val('');
			$('#chnlcode').attr("readonly","readonly");//设为只读
			$("#ratestd").hide();
			$("#ratesntd").hide();
			$("#submitok").hide();
			getinfo(selfId);
		}
		function getinfo(selfId){
			$.ajax({
				   type: "POST",
				   url: "channel/queryChannelById",
				   data: "selfId="+selfId,
				   async: false,
				   dataType:"json",
				   success: function(json){	
					   if (json == null) {
							$.messager.alert('提示', '该通道信息不存在，或已被变更，请刷新一下数据再试试！');
						} else {
						    $("#chnlcode").val(json.chnlcode);
							$("#chnlname").val(json.chnlname);
							$("#address").val(json.address);
							$("#contact").val(json.contact);
							$("#contPhone").val(json.contPhone);
							$("#notes").val(json.notes);
							$("#chnlid").val(json.chnlid);
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
		
		function showAllChannl(caprovince) {
			var em="";
			$.ajax({
				type: "POST",
				url: "channel/queryChannelAll",
				dataType: "json",
				success: function(json) {
					var html = html += '<option value="' + em + '">--全部--</option>';
					$.each(json,function(key, value) {
							html += '<option value="' + value.chnlcode + '">' + value.chnlname + '</option>';
					}) ;
					$("#schannelName").html(html);
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
