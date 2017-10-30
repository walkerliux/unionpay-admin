<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:include page="../../../top.jsp"></jsp:include>
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
						<td align="right">用户名称</td>
						<td align="left" style="padding-left: 5px">
						<input id="userName" name="userModel.userName" /></td>
						<td align="right">用户代码</td>
						<td align="left" style="padding-left: 5px">
						<input id="userCode" name="userModel.loginName" /></td>
						<td align="right"></td>
					<!-- </tr>
				 	<tr>
						<td align="right">所属机构</td>
						<td align="left" style="padding-left: 5px"><select
							id="userOrganId" name="user.organId" onchange="showDept(1)">
								<option value=''>--请选择所属机构--</option>
						</select></td>
						<td align="right">所属部门</td>
						<td align="left" style="padding-left: 5px">
						<select id="userDeptId" name="user.deptId" onchange="showRole(1)">
								<option value=''>--请选择所属部门--</option></select></td>
					</tr> 
					<tr> -->
						<td align="right">用户角色</td>
						<td align="left" style="padding-left: 5px">
						<select id="userRoleId" name="roleId" onchange="showRole(1)">
								<option value=''>--请选择用户角色--</option>
						</select></td>
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
				<form id="saveForm" action="user/save"
					method="post">
					<input type="hidden" id="user_id" name="userId" /> <input
						type="hidden" id="user_status" name="status" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<!-- <td>用户代码</td>
							<td align="left"><input type="text" id="user_code"
								name="userCode" value="自动生成"/></td> -->
							<td>用户名称</td>
							<td align="left"><input type="text" id="user_name"
								name="userName" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入用户名称" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
						</tr>
						<tr style="height: 25px">
							<td>登录账号</td>
							<td align="left"><input type="text" id="user_loginName"
								name="loginName" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入登录账号" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
							<td>用户类型</td>
							<td align="left"><select id="user_isadmin"
								class="easyui-validatebox" required="true" name="isadmin"
								missingMessage="请选择用户类型">
									<option value=''>--请选择用户类型--</option>
									<option value='1'>管理员</option>
									<option value='0'>普通用户</option>
							</select></td>
							
						</tr>
						<!-- <tr style="height: 25px">
							<td>所属部门</td>
							<td align="left"><select id="user_deptId"
								class="easyui-validatebox" missingMessage="请选择所属部门"
								required="true" name="deptId" onchange="showRole()">
									<option value=''>--请选择所属部门--</option>
							</select></td> 
							<td>所属机构</td>
							<td align="left"><select id="user_organId"
								class="easyui-validatebox" missingMessage="请选择所属机构"
								required="true" name="organId" onchange="showDept()">
									<option value=''>--请选择所属机构--</option>
							</select></td> 
						</tr> -->
						<tr style="height: 25px">
							<td>备注</td>
							<td colspan="3" align="left"><textarea rows="3" cols="81" id="user_notes"
									maxlength="64" name="notes" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>

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

	<div id="w2" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<input id="userId_addrole" name="userId" type="hidden" />
				<form id="AddUserRoleForm" name="myForm" action="user/SaveUser" method="post">
					<div>
						<div class="left">
							<p class="text">待选:</p>
							<select class="form-control" id="scope" name="scope" size="25"
								multiple="multiple" style="width: 120px">
							</select>
						</div>
						<div class="mid">
							<a href="javascript:addToSelect()" class="easyui-linkbutton"
								iconCls="icon-add">增加</a> <a href="javascript:delSelect2()"
								class="easyui-linkbutton" iconCls="icon-redo">删除</a>
						</div>
						<div class="right">
							<p class="text">已选:</p>
							<select class="form-control" id="selectScopes"
								name="UserRoleList" size="25" multiple="multiple"
								style="width: 120px">
							</select>
						</div>
					</div>
					<a href="javascript:AddUserRoleForm()" class="easyui-linkbutton"
						iconCls="icon-ok">提交</a>
			</div>
		</div>
	</div>
	
	<div id="w3" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 300px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<input id="userId_addrole" name="userId" type="hidden" />
				<form action="" id="passwordRestForm" name="PasswordForm">
				<table width="100%">
					<tr height="4"></tr>
					<tr>
						<td align="right">新密码</td>
						<td align="left" style="padding-left: 5px">
						<input id="passwordone" name="passwordone" type="password"/></td>
					</tr>
					<tr height="4"></tr>
					<tr>
						<td align="right">确认密码</td>
						<td align="left" style="padding-left: 5px">
						<input id="passwordtwo" type="password" />
					</tr>
					<tr height="4"></tr>
					<tr>
						<td align="right"></td>
						<td align="left" style="padding-left: 5px">
						<a href="javascript:updatePassword()" class="easyui-linkbutton" iconCls="icon-search">确定</a></td>
					</tr>
					<tr height="4"></tr>
					<tr align="right">
						<td align="right"></td>
						<td style="color: red" align="left" id="tishi"></td>
						<td align="left" style="padding-left: 5px"></td>
					</tr>
				</table>
			</form>
				
			</div>
		</div>
	</div>
	
	<div id="userRoleW3" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<div region="center" title="权限栏" id="authMenu" closed="true">
					<input id="userId" name="userId" type="hidden" />
					<div style="margin: 5px" id="menu_div">
						<ul id="tt2" ></ul>
						<a href="javascript:submitUserAuth()" class="easyui-linkbutton" iconCls="icon-ok">提交</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyuiExtension.js"></script> 
<script>
  	var width = $("#continer").width();
  
		$(function(){
			showOrgan();
			$('#userList').datagrid({
				title:'用户列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'user/query',
				remoteSort: false,
				columns:[[
					{field:'isadmin',title:'用户类型',align:'center',width:150,
						formatter:function(value, row) { 
							if(value=="1"){
								return "管理员";
							}
							if(value=="0"){
								return "普通用户";
							}
						}
					},
					{field:'userName',title:'用户名称',align:'center',width:150},
					{field:'userCode',title:'用户代码',width:100,align:'center'},
					{field:'loginName',title:'登陆账号',width:180,align:'center'},
					/* 
					{field:'DEPT_NAME',title:'所属部门',width:100,align:'center'}, */
					{field:'creator',title:'创建者',width:180,align:'center'},
					{field:'createDate',title:'创建时间',width:200,align:'center',
						formatter:function(value, row) { 
						if(value!=null){
							  var date = new Date(value); 
							  return formatDate(date,"yyyy-mm-dd hh:nn:ss");
							}else{ 
							  return ""; 
							} 
						} 
					}, 
					{field:'status',title:'状态',width:160,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "已使用";
							}else{
								return "已停用";
							}
						}
					},
					{field:'userId',title:'操作',align:'center',width:250,rowspan:2,
						formatter:function(value,rec){
							if(rec.status=="00"){
								return '<a href="javascript:showUser('+value+')" style="color:blue;margin-left:10px">修改</a>'+
								/* '<a href="javascript:ToUserAuthority('+value+')" style="color:blue;margin-left:10px">赋权</a>'+ */					
								'<a href="javascript:ToSelectRole('+value+')" style="color:blue;margin-left:10px">绑定角色</a>'+
								'<a href="javascript:deleteUser('+value+')" style="color:blue;margin-left:10px">注销</a>'
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
					text:'新增用户',
					iconCls:'icon-add',
					handler:function(){
						$("#user_code").attr('readonly','readonly');
						showAdd(0);
						$("#saveForm").attr("action","user/save");
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
		
		function showOrgan(){		
			$.ajax({
			   type: "POST",
			   url: "user/showRoles",
			   dataType:"json",
			   success: function(json){
			   		var html ="<option value=''>--请选择用户角色--</option>";
			   		$.each(json, function(key,value){
			   			html += '<option value="'+value.roleId+'">'+value.roleName+'</option>';
					})
					$("#userRoleId,#user_roleId").html(html);
			   }
			});
		} 
		
		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			$("#saveForm").attr("action","user/save");
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
			var data={'userName':$('#userName').val(),'userCode':$('#userCode').val(),'deptId':$("#userDeptId").val(),'roleId':$("#userRoleId").val(),'organId':$("#userOrganId").val()};
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
		
		function showUser(userId){
			$.ajax({
			   type: "POST",
			   url: "user/getSingleById",
			   data: "userId="+userId,
			   async: false,
			   dataType:"json",
			   success: function(json){					
						$("#user_code").val(json.userCode);
						$("#user_code").attr('readonly','readonly');
						$("#user_code").css('background-color','#D2D2D2');
						$("#user_name").val(json.userName);
						$("#user_loginName").val(json.loginName);
						$("#user_organId").val(json.organId);
						$("#user_status").val(json.status);
						$("#user_isadmin").val(json.isadmin);
						$("#user_id").val(json.userId);
						$("#user_notes").val(json.notes);
						/* //读取职能部门信息
						var html = '<option value="">--请选择所属部门--</option>';
						$.ajax({
							type: "GET",
						  	url: "user/showDept",
						  	data: "rand="+new Date().getTime()+"&organId="+json.organId,
						 	dataType: "json",
						 	async: false,
						 	success:function(json){
								$.each(json, function(key,value){
									html += '<option value="'+value.deptId+'">'+value.deptName+'</option>';
								})
								$("#user_deptId").html(html);
								
						 	}
						});
						setTimeout(function(){ 
							$("#user_deptId").val(json.deptId);
						},1); */
					
			   }
			});
			$('#w').window({
				title: '修改用户信息',
				top:100,
				width: 650,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 220
			});
			$("#saveForm").attr("action","user/update");
			$('#btn_submit').linkbutton('enable');	
		}

		function deleteUser(userId){
			$.messager.confirm('提示','账户注销后无法恢复，确定需要注销？',function(r){   
			   if (r){  
				$.ajax({
				   type: "POST",
				   url: "user/delete",
				   data: "userId="+userId,
				   dataType:"json",
				   success:function(data){
// 					   success:function(data){   
				    		$('#w').window('close');
				    		 search();
				    		$('#btn_submit').linkbutton('enable');
				    		if(data=='true'){
								$.messager.alert('提示',"注销成功");  
							}else if(data=="false"){
								$.messager.alert('提示',"注销失败");  
							} 
					    } 
				});
			    }   
			});  
		}
		function UserPasswordReset(userId){
			$.messager.confirm('提示','您是否想要重置此用户密码?',function(r){   
			    if (r){  
			    	$.ajax({
						type: "GET",
					  	url: "user/resetPwd",
					  	data: "rand="+new Date().getTime()+"&userId="+userId,
					 	dataType: "text",
					 	success:function(data){
					 		if(data=='true'){
								$.messager.alert('提示',"保存成功");  
							}else if(data=="false"){
								$.messager.alert('提示',"保存失败");  
							}
					 	}
					});
			    }   
			}); 
		}
		/* 用户配置角色 */		
		function ToSelectRole(userId){ 
			$("#userId_addrole").val(userId);
			var html="";
			$('#w2').window({
				title: '用户配置角色',
				top:10,
				width: 500,
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal: true,
				shadow: false,
				closed: false,
				height: 510
			});
			$.ajax({
				type: "GET",
			  	url: "user/queryRoleAllList",
			  	data: "rand="+new Date().getTime()+"&userId="+userId,
			 	dataType: "json",
			 	success:function(json){
					$.each(json, function(key,value){
						html += '<option value="'+value.roleId+'">'+value.roleName+'</option>';
					})
					$("#scope").html(html);
			 	}
			});
			var htmlscope="";
			$.ajax({
				type: "GET",
			  	url: "user/queryRoleListhave",
			  	data: "rand="+new Date().getTime()+"&userId="+userId,
			 	dataType: "json",
			 	success:function(json){
					$.each(json, function(key,value){
						htmlscope += '<option value="'+value.roleId+'">'+value.roleName+'</option>';
					})
				$("#selectScopes").html(htmlscope);
			 	}
			});
			
		}
		function addToSelect(){ 
	    	var selectScopes = document.myForm.selectScopes;
	    	var str = "";
	    	for(var k = 0; k < selectScopes.options.length; k++){
	    		if(k==0){
	    			str = selectScopes.options[k].value;
	    		}
	    		else{
	    			str = str + selectScopes.options[k].value + ",";
	    		}
	    	}
	    	var scopes = document.myForm.scope;
	    	var scopenum = scopes.options.length;
	    	var selectIndexs = scopes.selectedIndex;
	    	for(var j = 0; j < scopenum; j ++){
	    		var scope = scopes.options[j];
	    		if(scope.selected == true){
	    			if(str.indexOf(scope.value) == -1){ 
	    				var scopeHtml = scope.innerHTML;
	    				selectScopes.options.add(new Option(scopeHtml , scope.value));
	    			}else{
					    alert("请不要重复选择！");
					}		
	    		}    
	    	}
	    }
	     
	    function delSelect2(){
	    	var selectScopes = document.myForm.selectScopes;
	    	for(var i = 0; i < selectScopes.options.length; i ++){
	    		if(i >= 0 && i <= selectScopes.options.length-1 && selectScopes.options[i].selected){     
	    			selectScopes.options[i] = null;
	    			i --;
	    		}  
	    	}
	    } 
	   function AddUserRoleForm(){//保存用户角色
		   var userFunc = '';//定义数组
		    $(document).ready(function(){
		        $("#selectScopes option").each(function(){ //遍历全部option
		            var txt = $(this).val(); //获取option的内容		          
		            	userFunc+=txt+",";; //添加到数组中
		        });
		    });
		   /* if(userFunc == ""){
			   $('#w2').window('close');
			   $.messager.alert('提示',"用户为配置角色！");
			   return false;
		   } */
		    $.ajax({
				type: "POST",
			    url: "user/SaveUserRole",
			    data: "userId="+$('#userId_addrole').val()+"&userFunc="+userFunc,
			    dataType: "text",
			    success: function(data){
					$('#w2').window('close');
					if(data=='true'){
						$.messager.alert('提示',"保存成功");  
					}else if(data=="false"){
						$.messager.alert('提示',"保存失败");  
					}
			    }
			});
		}
	    
		/*用户权限  */	    
	    var roleFunction = null;
		function ToUserAuthority(userId){
			$("#userId").val(userId);
			$('#userRoleW3').window({
				title: '用户配置权限',
				top:10,
				width: 300,
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal: true,
				shadow: false,
				closed: false,
				height: 510
			});
			var flag = true;
			$('#tt2').tree({
				checkbox: true,
				animate:true,
				url: 'user/queryFunction?userId='+userId,
				onCheck:function(node, checked){
					for(var i=0;i<roleFunction.length;i++){
						if(node.id==roleFunction[i].functId){
							if(checked==false){
								$('#tt2').tree('check',node.target);
							}else{
								
							}
						}
						
						
					}
					
					node.text = '<span style="color:blue">'+node.text+'</span>';
				},
				onBeforeExpand:function(node){
					var child = $('#tt2').tree('getChildren', node.target);
					if(child==""){
						return false;
					}
				},
				loadFilter: function(data){   
					
					if(flag){
						roleFunction = data.roleFunction;
						flag = false;
					}
			        return data.result;
			    },   
				onContextMenu: function(e, node){
					e.preventDefault();
					$('#tt2').tree('select', node.target);
					$('#mm').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				}
			});
// 			var w =$("#authMenu").width();
// 			$("#menu_div").css("margin-left",w/2.5+"px");
		}
		function invokeFunction(){
			showUserFunction($('#userId').val())
		}

		function submitUserAuth(){
			var fid = getChecked();
			$.ajax({
				type: "POST",
			    url: "user/saveAuth",
			    data: "userId="+$('#userId').val()+"&userFunc="+fid,
			    dataType: "text",
			    success: function(data){
					if(data=='true'){
						$('#userRoleW3').window('close');
						$.messager.alert('提示',"保存成功");  
					}else if(data=='false'){
						$.messager.alert('提示',"保存失败");  
					}
			    }
			});
		}
		
		function getChecked(){
			var nodes = $('#tt2').tree('getChecked');
			var s = '';
			var p = '';
			for(var i=0; i<nodes.length; i++){
				if (s != '') s += '|';
				s += nodes[i].id;
				var parent = $('#tt2').tree('getParent',nodes[i].target);
				if(parent!=null){//有父节点的
					if(!parent.checked){//判断是否已被勾选
						if(p.indexOf(parent.id)<0){
							p+=parent.id+"|";
						}
					}
				}
			}
			var idArray = (p+s).split('|');
			var flag = false;
			var userFunction = "";
			for(var i=0;i<idArray.length;i++){
				for(var j=0;j<roleFunction.length;j++){
					if(idArray[i]==roleFunction[j].functId){
						flag = true;
					}
				}
				if(flag){//角色权限的Func_id
					flag = false;
				}else{//用户的权限
					if (userFunction != '') userFunction += ',';
					userFunction+=idArray[i];
				}
			}
			return userFunction;
		}
	</script>
	
<!--

//-->
</script>
</html>
