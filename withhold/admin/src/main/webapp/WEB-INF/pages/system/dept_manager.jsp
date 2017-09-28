<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<body>
	<style type="text/css">
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
				<table width="100%">
					<tr>
						<td class="add" align="right" width="15%">部门代码</td>
						<td class="add" align="left" style="padding-left: 5px" width="25%"><input
							name="deptCode" id="deptCode" maxlength="4" /></td>
						<td class="add" align="right" width="15%">部门名称</td>
						<td class="add" align="left" style="padding-left: 5px" width="25%"><input
							name="deptName" id="deptName" /></td>
						<td class="add" align="right">
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
	<div id="w" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="deptForm" action="dept/save" method="post">
					<input type="hidden" id="dept_id" name="deptId" /> 
					<input type="hidden" id="dept_status" name="status" />
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left" id="inputForm">
						<tr>
							<td class="add" width="15%">部门代码</td>
							<td class="add" width="30%"><input id="dept_code" name="deptCode" required="true" type="text" maxlength="4"
								class="easyui-validatebox" validType="minLength[4,4]" missingMessage="请输入部门代码"/><font color="red">*</font></td>
							<td class="add" width="15%">部门名称</td>
							<td class="add"><input id="dept_name" name="deptName" required="true" missingMessage="请输入部门名称" type="text"
								class="easyui-validatebox" maxlength="20"/><font color="red">*</font></td>
						</tr>
						<tr>
							<td class="add">所属机构</td>
							<td class="add"><select id="dept_organId" class="easyui-validatebox" missingMessage="请选择所属机构" required="true" name="organId"
								class="easyui-validatebox"><option value="">--请选择所属机构--</option>
							</select></td>
							<td class="add"></td>
							<td class="add"></td>
						</tr>
						<tr>
							<td class="add">备注</td>
							<td class="add" colspan="3"><textarea rows="3" cols="60" id="dept_notes" maxlength="64" name="notes" 
								style="resize: none;" onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveDept()" id="btn_submit" onclick="">保存</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
	<div id="w2" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="b_deptForm" action="" method="post">
					<input type="hidden" id="b_dept_id" name="deptId" /> 
					<input type="hidden" id="b_dept_status" name="status" />
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
						<tr>
							<td class="update" width="15%">部门代码</td>
							<td class="update" cwidth="30%"><span id="b_dept_code"></span></td>
							<td class="update" width="15%">部门名称</td>
							<td class="update"><span id="b_dept_name"></span></td>
						</tr>
						<tr>
							<td class="update">所属机构</td>
							<td class="update"><span id="b_dept_organId"></span></td>
							<td class="update"></td>
							<td class="update"></td>
						</tr>
						<tr>
							<td class="update">备注</td>
							<td class="update" colspan="3"><span id="b_dept_notes"></span></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" id="b_btn_submit" onclick="deletDept()">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			showOgan();
			$('#test').datagrid({
				title:'职能部门列表',
				iconCls:'icon-save',
				height:600,
				singleSelect:true,
				nowrap: false,
				striped: true,
				url:'dept/query',
				remoteSort: false,
				idField:'ORGAN_ID',
				columns:[
				[
					{field:'DEPT_CODE',title:'部门代码',width:120,align:'center'},
					{field:'DEPT_NAME',title:'部门名称',width:150,align:'center'},
					{field:'ORGAN_ID',title:'所属机构',width:100,align:'center'},
					{field:'CREATOR',title:'创建者',width:100,align:'center'},
					{field:'STATUS',title:'状态',width:100,align:'center',
						formatter:function(value,rec){
						if(value=="00"){
							return "使用";
						}else{
							return "失效";
						}
					}
						},	
					{field:'DEPT_ID',title:'操作',width:100,align:'center',
					formatter:function(value,rec){
						if(rec.STATUS=="00"){
							return '<a href="javascript:showDept('+value+')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:deletDept('+value+')" style="color:blue;margin-left:10px">注销</a>';
						}else{
							return "";
						}
						
					}
									}
					
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增部门',
					iconCls:'icon-add',
					handler:function(){
						showAdd();
						$('#inputForm :input').val('');
						$('#dept_code').removeAttr('disabled')
					}
				}]
			});
			var p = $('#test').datagrid('getPager');
			$.extend($.fn.validatebox.defaults.rules, {   
			    minLength: {   
			        validator: function(value, param){ 
						var re =  /^\d+$/; 
		        		if(!re.test(value)){
							return false;
			        	}  
			            return value.length >= param[0];   
			        },   
			        message: '请输入4位数字的部门代码'  
			    }
			   
			});  
		});
		
		function showAdd(){	
			showOgan();
			$('#w').window({				
				title: '新增部门',
				top:100,
				width: 650,
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal: true,
				shadow: false,
				closed: false,
				height: 220
			});
			$("#deptForm").attr("action","dept/save");
			$('#btn_submit').linkbutton('enable');		
		}
		function closeAdd(){
			$('#w').window('close');
			$('#w2').window('close');
			
		}		
		function search(){
			var data={deptName:$('#deptName').val(),"deptCode":$("#deptCode").val()};
			$('#test').datagrid('load',data);
		}
		
		function resize(){
			$('#theForm :input').val('');
		}
		function saveDept(){
			
			$('#deptForm').form('submit', {  
			    onSubmit: function(){  
			    if($('#deptForm').form('validate')){
			    	$('#btn_submit').linkbutton('disable');
			    	return true;   
				}
			        return false;   
			    },   
			    success:function(data){  
			    	var json = eval('(' + data + ')')
			    	$.each(json, function(key,value){
			    		$.messager.alert('提示',value.INFO);   
			    		if(value.RET=='succ'){
			    			search();
				    		closeAdd();
				    	}
			    		$('#btn_submit').linkbutton('enable');		
					}) 
			    }   
			});  
			
		}
		function showOgan(){		
			$.ajax({
			   type: "POST",
			   url: "dept/showOrgan",
			   dataType:"json",
			   success: function(json){
				    var organId = $("#b_dept_organId").val();
			   		var html ="<option value=''>--请选择所属机构--</option>";
			   		$.each(json, function(key,value){
			   			if(value.organId == organId){
			   				$("#b_dept_organId").html(value.organName);
			   			}
			   			html += '<option value="'+value.organId+'">'+value.organName+'</option>';
					})
					$("#dept_organId").html(html);
			   }
			});
		}

		
		function deletDept(deptId){
// 			var deptId = $("#b_dept_id").val();
			$.messager.confirm('提示','您是否想要注销此部门?',function(r){   
			   if (r){  
				$.ajax({
				   type: "POST",
				   url: "dept/delete",
				   data: "deptId="+deptId,
				   dataType:"json",
				   success:function(json){
						$.each(json, function(key,value){
				    		$.messager.alert('提示',value.INFO);   
				    		search();
				    		closeAdd();
						}) 
				 	}
				});
			    }   
			});  
		}
		function showDept(deptId){	
			
			$("#dept_code").attr('class','easyui-validatebox');
			$.ajax({
			   type: "POST",
			   url: "dept/getSingleById",
			   data: "deptId="+deptId,
			   dataType:"json",
			   success: function(json){
			   				
		   		    //alert(json.creator);
					$("#dept_code").val(json.deptCode);
					$('#dept_code').attr('readonly',true);
					$("#dept_name").val(json.deptName);					
					$("#dept_organId").val(json.organId);						
					$("#dept_notes").val(json.notes);
					$("#dept_id").val(json.deptId);
					$("#dept_status").val(json.status);
			   }
		   });
			$('#dept_code').removeAttr('class');
			$('#w').window({
				title: '修改部门',
				top:100,
				width: 650,
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal: true,
				shadow: false,
				closed: false,
				height: 220
			});
			$("#deptForm").attr("action","dept/update");
			$('#btn_submit').linkbutton('enable');		
		}
		//注销部门 
		function deleteDept(deptId){
			$("#b_deptForm").attr("action","dept/delete");
			$("#b_dept_code").attr('class','easyui-validatebox');
			$.ajax({
				   type: "POST",
				   url: "dept/getSingleById",
				   data: "deptId="+deptId,
				   dataType:"json",
				   success: function(json){
					$("#b_dept_code").html(json.deptCode);
					$('#b_dept_code').attr('disabled','disabled');
					$("#b_dept_name").html(json.deptName);		
					$("#b_dept_organId").val(json.organId);					
					$("#b_dept_notes").html(json.notes);
					$("#b_dept_id").html(json.deptId);
					$("#b_dept_id").val(json.deptId);
					$("#b_dept_status").html(json.status);
					showOgan();
				   }
			});
				$('#b_dept_code').removeAttr('class');
				$('#w2').window({
					title: '注销部门', 
					top:100,
					width: 500,
					collapsible:false,
					minimizable:false,
					maximizable:false,
					modal: true,
					shadow: false,
					closed: false,
					height: 220
				});				
				
				$('#b_btn_submit').linkbutton('enable');
				
		}			
	</script>
</html>
