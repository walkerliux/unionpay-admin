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
						<td align="right">银行代码</td>
						<td align="left" style="padding-left: 5px">
						<input id="bank_code" name="bankcode" /></td>
						<td align="right">银行名称</td>
						<td align="left" style="padding-left: 5px">
						<input id="bank_name" name="bankname" /></td>
						<td align="right"></td>
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
				<form id="saveForm" action="bank/save"
					method="post">
					 <input type="hidden" id="tid" name="tid" /> 
					 <input type="hidden" id="oldbankcode" name="oldbankcode" /> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td>银行代码</td>
							<td align="left"><input type="text" id="tbankcode"
								name="bankcode" class="easyui-validatebox" required="true"
								maxlength="4" missingMessage="银行代码" onkeyup="value=value.replace(/<[^<]+>/g,'')"/><span></span></td>
							
						</tr>
						<tr style="height: 25px">
						<td>银行名称</td>
							<td align="left"><input type="text" id="bankname"
								name="bankname" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="银行名称" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
						</tr>
						<tr style="height: 25px">
							<td>人总行代码</td>
							<td align="left"><input type="text" id="pbcBankcode"
								name="pbcBankcode" class="easyui-validatebox" required="true"
								maxlength="12" missingMessage="人总行代码" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
							<td></td>
							<td></td>
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
				title:'银行列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'bank/query',
				remoteSort: false,
				columns:[[
					{field:'bankcode',title:'银行代码',align:'center',width:150},
					{field:'bankname',title:'银行名称',align:'center',width:150},
					{field:'pbcBankcode',title:'人总行代码',align:'center',width:150},
					
					{field:'tid',title:'操作',align:'center',width:250,rowspan:2,
						formatter:function(value,rec){
							if(true){
								return '<a href="javascript:showBank('+value+')" style="color:blue;margin-left:10px">修改</a>'
								
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
					text:'新增银行信息',
					iconCls:'icon-add',
					handler:function(){
						$("#tbankcode").removeAttr('readonly');
						showAdd(0);
						$("#saveForm").attr("action","bank/save");
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
		
		
		
		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			$("#saveForm").attr("action","bank/save");
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
			var data={'bankcode':$('#bank_code').val(),'bankname':$('#bank_name').val()};
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
		
		function showBank(tid){
			$.ajax({
			   type: "POST",
			   url: "bank/getSingleById",
			   data: "tid="+tid,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   //alert(json.apicode);
						$("#tbankcode").val(json.bankcode);
						$("#oldbankcode").val(json.bankcode);
						$("#apicode").css('background-color','#D2D2D2');
						$("#bankname").val(json.bankname);
						$("#pbcBankcode").val(json.pbcBankcode);
						$("#tid").val(json.tid);
						
			   }
			});
			$('#w').window({
				title: '修改银行信息',
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
			$("#saveForm").attr("action","bank/update");
			$('#btn_submit').linkbutton('enable');	
		}

		/*  $("#tbankcode").blur(function(){
			var bankcode=$("#tbankcode").val();
			$.ajax({
				   type: "POST",
				   url: "bank/getSingleBycode",
				   data: "bankcode="+bankcode,
				   async: false,
				   dataType:"json",
				   success: function(json){	
					   
						if(json.bankcode!=null){
							$.messager.alert('提示',"已存在相同银行代码"); 
							}	
						}
							
				 
			
		});
		})  */
		
	   
	 	function invokeFunction(){
			showBankFunction($('#userId').val());
		}   
	</script>
</html>
