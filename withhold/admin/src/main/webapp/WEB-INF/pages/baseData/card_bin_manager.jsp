<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:include page="../../top.jsp"></jsp:include>
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
		<div id="p" class="easyui-panel" title="查询条件" style="height: 130px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="searchForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">卡bin号码</td>
						<td align="left" style="padding-left: 5px">
						<input id="card_bin" name="cardbin" /></td>
			
						<td align="right" colspan="3">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="userList">
			</table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="saveForm" action="bin/save"
					method="post">
					 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td>卡bin</td>
							<td align="left"><input type="text" id="cardbin"
								name="cardbin" class="easyui-validatebox" required="true"
								maxlength="10" missingMessage="卡bin" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
							<td>卡名</td>
							<td align="left"><input type="text" id="cardname"
								name="cardname" class="easyui-validatebox" required="true"
								maxlength="12" missingMessage="卡名" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
						</tr>
						<tr style="height: 25px">
							
							<td>主账号卡长</td>
							<td align="left"><input type="text" id="cardlen"
								name="cardlen" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="主账号卡长" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
							<td>卡类型</td>
							<td align="left" style="padding-left: 5px">
								<select id="type" name="type" onchange="showRole(1)">
									<option value=''>--请选择卡类型--</option>
									<option value=1>借记卡</option>
									<option value=2>贷记卡</option>
									<option value=3>准贷记卡</option>
									<option value=4>预付费卡</option>
								</select></td>
						</tr>
						<tr style="height: 25px">
							<td>发卡行</td>
							<td align="left"><input type="text" id="bankcode"
								name="bankcode" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="发卡行code" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
							
						</tr>
						
						
						
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveUser()" id="btn_submit" onclick="">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>

	
	
	
	
</body>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyuiExtension.js"></script> 
<script>
  	var width = $("#continer").width();
  
		$(function(){
			//showOrgan();
			$('#userList').datagrid({
				title:'卡bin列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'bin/query',
				remoteSort: false,
				columns:[[
					{field:'cardbin',title:'卡bin',align:'center',width:150},
					{field:'binlen',title:'卡bin长度',align:'center',width:150},
					{field:'cardlen',title:'主账号卡长',align:'center',width:150},
					{field:'cardname',title:'卡名',align:'center',width:150},
					{field:'bankname',title:'发卡行',width:100,align:'center'},
					{field:'type',title:'卡类型',width:100,align:'center',
						formatter:function(value,rec){
							if(value=1){
								return "借记卡";
							}else if(value=2){
								return "贷记卡";
							}else if(value=3){
								return "准贷记卡";
							}else if(value=4){
								return "预付费卡";
							}
						}
					}, 
					{field:'card',title:'操作',align:'center',width:250,rowspan:2,
						formatter:function(value,rec){
							if(true){
								return '<a href="javascript:showbin('+rec.cardbin+')" style="color:blue;margin-left:10px">修改</a>'
								
								;
							}else{
								return '';
							}
							
					}}
				]],
				
				
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增卡bin',
					iconCls:'icon-add',
					handler:function(){
						$("#cardbin").removeAttr('readonly');
						showAdd(0);
						$("#saveForm").attr("action","bin/save");
					},   
				    
				}]
			});
			$.extend($.fn.validatebox.defaults.rules, {   
			    minLength: {   
			        validator: function(value, param){ 
						var re =  /^\d+$/; 
		        		if(!re.test(value)){
							return false;
			        	}  
			            return value.length >= param[0];   
			        },   
			        message: '请输入4位数字的用户代码'  
			    }
			   
			});  
		});
		
		/* function showOrgan(){		
			$.ajax({
			   type: "POST",
			   url: "bin/showTypes",
			   dataType:"json",
			   success: function(json){
			   		var html ="<option value=''>--请选择渠道类型--</option>";
			   		$.each(json, function(key,value){
			   			html += '<option value="'+value.code+'">'+value.name+'</option>';
					})
					$("#chnl_type,#chnltype").html(html);
			   }
			});
		}  */
	
		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			$("#saveForm").attr("action","bin/save");
			$('#saveForm :input').val('');
			$('#w').window({
				title: '新增用户信息',
				top:100,
				width: 650,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 240
			});
			$('#btn_submit').linkbutton('enable');	
		}
		function closeAdd(){
			$('#w').window('close');
			
		}		
		function search(){
			var data={'cardbin':$('#card_bin').val()};
			$('#userList').datagrid('load',data);
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
			    success:function(data){ 
			    	//alert(data)
		    		/* $('#w').window('close');
		    		 search();
		    		$('#btn_submit').linkbutton('enable');
		    		if(data=='true'){
						$.messager.alert('提示',"保存成功");  
					}else if(data=="false"){
						$.messager.alert('提示',"保存失败");  
					} */ 
			    	var json = eval('(' + data + ')')
			    	 //alert(json)
			    	$.each(json, function(key,value){
			    		$.messager.alert('提示',value);   
			    		search();
			    		closeAdd();
			    		$('#btn_submit').linkbutton('enable');	
					}) 
			    }   
			});  
		}
		
		function showbin(cardbin){
			$.ajax({
			   type: "POST",
			   url: "bin/getSingleById",
			   data: "cardbin="+cardbin,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   //alert(json.apicode);
						$("#cardbin").val(json.cardbin);
						$("#cardbin").attr('readonly','readonly');
						$("#cardbin").css('background-color','#D2D2D2');
						$("#cardname").val(json.cardname);
						$("#cardlen").val(json.cardlen);
						$("#bankcode").val(json.bankcode);
						$("#type").val(json.type);
						
			   }
			});
			$('#w').window({
				title: '修改卡bin信息',
				top:200,
				width: 650,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 220
			});
			$("#saveForm").attr("action","bin/update");
			$('#btn_submit').linkbutton('enable');	
		}

		
		
		
	
	     
	   
	  
	
		
		 function invokeFunction(){
			showbinFunction($('#userId').val())
		} 

		
	</script>

</html>
