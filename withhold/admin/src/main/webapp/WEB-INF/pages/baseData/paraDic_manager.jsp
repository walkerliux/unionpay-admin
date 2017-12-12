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
						<td align="right">参数代码</td>
						<td align="left" style="padding-left: 5px">
						<input id="paraCode" name="paraCode" /></td>
						<td align="right">参数名称</td>
						<td align="left" style="padding-left: 5px">
						<input id="paraName" name="paraName" /></td>
						<td align="right"></td>
					<!-- </tr>
				 	<tr>
						<td align="right">所属机构</td>
						<td align="left" style="padding-left: 5px"><select
							id="paraOrganId" name="para.organId" onchange="showDept(1)">
								<option value=''>--请选择所属机构--</option>
						</select></td>
						<td align="right">所属部门</td>
						<td align="left" style="padding-left: 5px">
						<select id="paraDeptId" name="para.deptId" onchange="showRole(1)">
								<option value=''>--请选择所属部门--</option></select></td>
					</tr> 
					<tr> -->
						<td align="right">父级名称</td>
						<td align="left" style="padding-left: 5px">
						<select id="parentId" name="parentId" onchange="showRole(1)">
								<option value=''>-请选择父级名称-</option>
						</select></td>
					
						<td align="right" colspan="3">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="paraList">
			</table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="saveForm" action="para/save"
					method="post">
					<input type="hidden" id="para_id" name="tid" /> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td>参数代码</td>
							<td align="left"><input type="text" id="para_Code"
								name="paraCode" class="easyui-validatebox" required="true"
								maxlength="7" missingMessage="请输入参数代码" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
							<td>参数名称</td>
							<td align="left"><input type="text" id="para_Name"
								name="paraName" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入参数名称" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
						</tr>
						<tr style="height: 25px">
							
							<td>父级参数</td>
							<td align="left"><select id="parent_Id"
								class="easyui-validatebox" required="true" name="parentId"
								missingMessage="请选择父级参数">
									<option value=''>--请选择父级参数--</option>
									<option value='0'>--无父级--</option>
							</select></td>
							<td>是否可改</td>
							<td align="left"><select id="has_Sub"
								class="easyui-validatebox" required="true" name="hasSub"
								missingMessage="请选择是否可改">
									<option value=''>--请选择是否可改--</option>
									<option value='1'>是</option>
									<option value='0'>否</option></select></td>
							<%-- <td>参数类型</td>
							<td align="left"><input type="text" id="para_Type"
								name="paraType" class="easyui-validatebox" required="true"
								maxlength="7" missingMessage="请输入参数类型" onkeyup="value=value.replace(/<[^<]+>/g,'')"/>
								<select id="para_Type"
								class="easyui-validatebox" required="true" name="paraType"
								missingMessage="请选择参数类型">
									<option value=''>--请选择参数类型--</option>
									<option value='0'>--无父级--</option>
							</select>
								</td> --%>
						</tr>
						<tr style="height: 25px">
							<td>附加</td>
							<td align="left"><input type="text" id="para_added"
								name="added" class="easyui-validatebox" 
								maxlength="20"  /><span id="ADDVALUE"></span></td>
						</tr>
						<tr style="height: 25px">
							<td>备注</td>
							<td colspan="3" align="left"><textarea rows="3" cols="81" id="para_remarks"
									maxlength="64" name="remarks" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>

						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:savepara()" id="btn_submit" onclick="">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>


	
	<div id="paraRoleW3" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<div region="center" title="权限栏" id="authMenu" closed="true">
					<input id="paraId" name="paraId" type="hidden" />
					<div style="margin: 5px" id="menu_div">
						<ul id="tt2" ></ul>
						<a href="javascript:submitparaAuth()" class="easyui-linkbutton" iconCls="icon-ok">提交</a>
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
			$('#paraList').datagrid({
				title:'参数列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'para/query',
				remoteSort: false,
				columns:[[
					{field:'paraCode',title:'参数代码',align:'center',width:150},
					{field:'paraName',title:'参数名称',width:180,align:'center'},
					{field:'parentName',title:'父级名称',align:'center',width:150},
					{field:'paraType',title:'参数类型',width:180,align:'center'},
					{field:'hasSub',title:'是否可改',width:100,align:'center',
						formatter:function(value,rec){
							if(value==1){
								return "是";
							}else{
								return "否";
							}
						}
					},
					{field:'status',title:'状态',width:160,align:'center',
						formatter:function(value,rec){
							if(value==1){
								return "已使用";
							}else{
								return "已停用";
							}
						}
					},
					{field:'added',title:'附加',width:100,align:'center'},
					{field:'remarks',title:'备注',width:200,align:'center'},
					{field:'tid',title:'操作',align:'center',width:250,rowspan:2,
						formatter:function(value,rec){
							if(rec.status=="1"&&rec.hasSub==1){
								return '<a href="javascript:showPara('+value+')" style="color:blue;margin-left:10px">修改</a>'+
							
								'<a href="javascript:deletePara('+value+')" style="color:blue;margin-left:10px">注销</a>'
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
					text:'新增参数',
					iconCls:'icon-add',
					handler:function(){
						$("#para_Code").removeAttr('readonly');
						showAdd(0);
						$("#saveForm").attr("action","para/save");
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
		
		// 充值金额校验
		function money() {
			var money = $("#para_added").val();
			var masg;
			var isok = true;
			if (money != null && !isNaN(money)) {

				//masg = toChineseCash(money);
				//$("#ADDVALUE").css("color", "black");
				$("#ADDVALUE").html("");
			} else {
				masg = "请输入正确的数值";
				$("#ADDVALUE").css("color", "red");

				isok = false;
				$("#ADDVALUE").html(masg);
			}
			
			return isok;

		}
		function showOrgan(){		
			$.ajax({
			   type: "POST",
			   url: "para/showParents",
			   dataType:"json",
			   success: function(json){
			   		var html ="<option value=''>--请选择父级参数--</option>";
			   		html +="<option value='0'>无父级参数</option>";
			   		$.each(json, function(key,value){
			   			html += '<option value="'+value.tid+'">'+value.paraName+'</option>';
					})
					$("#parentId,#parent_Id").html(html);
			   }
			});
		} 
		
		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			$("#saveForm").attr("action","para/save");
			$('#saveForm :input').val('');
			$('#w').window({
				title: '新增系统参数',
				top:100,
				width: 700,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 260
			});
			$('#btn_submit').linkbutton('enable');	
		}
		function closeAdd(){
			$('#w').window('close');
			
		}		
		function search(){
			var data={'paraCode':$('#paraCode').val(),'paraName':$('#paraName').val(),'parentId':$("#parentId").val()};
			$('#paraList').datagrid('load',data);
		}
		function savepara(){
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
					if(data!=null){
			    	var json = eval('(' + data + ')')
			    	 //alert(json)
			    	$.each(json, function(key,value){
			    		$.messager.alert('提示',value);   
			    		search();
			    		closeAdd();
			    		$('#btn_submit').linkbutton('enable');	
					}) 
			    }  } 
			});  
		}
		
		function showPara(tid){
			$('#w').window({
				title: '修改参数信息',
				top:100,
				width: 700,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 260
			});
			$.ajax({
			   type: "POST",
			   url: "para/getSingleById",
			   data: "tid="+tid,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   if(json!=null){
						$("#para_Code").val(json.paraCode);
						/* $("#para_Code").attr('readonly','readonly');
						$("#para_Code").css('background-color','#D2D2D2'); */
						$("#para_Name").val(json.paraName);
						$("#para_Type").val(json.paraType);
						$("#para_added").val(json.added);						
						
						$("#para_id").val(json.tid);
						$("#para_remarks").val(json.remarks);
						 //读取父级信息
						var html = '<option value="">--请选择所属父类参数--</option>';
						html +="<option value='0'>无父级参数</option>";
						$.ajax({
							type: "GET",
						  	url: "para/showParents",
						  	//data: "rand="+new Date().getTime()+"&organId="+json.organId,
						 	dataType: "json",
						 	async: false,
						 	success:function(json){
						 		if(json!=null){
								$.each(json, function(key,value){
									
										html += '<option value="'+value.tid+'">'+value.paraName+'</option>';
									
								})
								$("#parent_Id").html(html);
						 		}
						 	}
						});
						setTimeout(function(){ 
							$("#parent_Id").val(json.deptId);
						},1); 
				   }	
			   }
			});
			
			$("#saveForm").attr("action","para/update");
			$('#btn_submit').linkbutton('enable');	
		}

		function deletePara(tid){
			$.messager.confirm('提示','您是否想要注销此数据?',function(r){   
			   if (r){  
				$.ajax({
				   type: "POST",
				   url: "para/delete",
				   data: "tid="+tid,
				   dataType:"json",
				   success:function(data){
				   	if(data!=null){   
				    		$('#w').window('close');
				    		 search();
				    		$('#btn_submit').linkbutton('enable');
				    		if(data=='true'){
								$.messager.alert('提示',"注销成功");  
							}else if(data=="false"){
								$.messager.alert('提示',"注销失败");  
							} 
					    } }
				});
			    }   
			});  
		}
	
		
		
	     
	    
		
		function invokeFunction(){
			showParaFunction($('#paraId').val())
		}

		
		
	</script>
	

</html>
