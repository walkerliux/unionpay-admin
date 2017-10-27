<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<script type="text/javascript" src="js/extendsValidator_1.0_20151215.js"></script>
</head>
<body>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="商户单日累计限次查询"
			style="height: 72px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="dedurateForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">风控版本</td>
						<td align="left" style="padding-left: 5px">							
						<select id="s_caseid" name="caseid" >
						<option value=''></option>
						</select></td>
						<td align="right" colspan=2>
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a>
						</td>
					</tr>
				</table>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theForm" method="post" action="">
					<input name="tid" id="tid" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left" id="inputForm">
						<tr>							
						<td align="right" width="15%" height="30px">风控版本</td>
						<td align="left" style="padding-left: 5px">							
						<select id="caseid" name="caseid" class="easyui-validatebox" missingMessage="请选选择风控版本" required="true">
						<option value=''></option>
						</select></td>						
							<td align="right" width="15%">交易次数限制</td>
							<td align="left" style="padding-left: 5px" width="25%">
							<input name="limitCount" id="limitCount" maxlength="8" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " /></td>
						</tr>
						<tr>
							<td align="right" width="15%" height="30px">风险等级</td>
							<td align="left" style="padding-left: 5px" width="25%">
							<select id="risklevel" class="easyui-validatebox" missingMessage="请选选择风险等级" required="true"
								name="risklevel">
									<option value="">--请选择风险等级--</option>
							</select></td>
						</tr>
						<tr>
							<td align="center" width="15%">备注</td>
							<td align="left" colspan="3">
							<textarea rows="3" cols="81" id="notes" maxlength="64" name="notes" style="resize: none;"></textarea></td>							
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveWhitePan()" id="btn_submit" onclick="">保存</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
</body>

<script>
  
		var width = $("#continer").width();
		var gridHeight = 600;
		var panelWidth = 640;
		var panelHeight = 230;
		var panelHoriFloat = (width - panelWidth) / 2;
		var panelVertFloat = 150;
  	
		 $(function(){
			
			showAllriskid("serch");
			$('#test').datagrid({
				title:'',
				singleSelect:true,
				iconCls:'icon-save',
				height:gridHeight,
				nowrap: false,
				striped: true,
				url:'riskLimit/queryLimitMemNumsDay',
				remoteSort: false,
				columns:[
				[
					{field:'riskname',title:'风控版本',width:150,align:'center'},	
					{field:'limitCount',title:'累计限次',width:100,align:'center'},
					{field:'risklevel',title:'风险等级',width:100,align:'center',
						formatter:function(value,rec){
							if(value=="1"){
								return '<span style="color:green;">'+'提示'+'</span>';
							}else if(value=="2"){
								return '<span style="color:blue;">'+'关注'+'</span>';
							}else if(value=="3"){
								return '<span style="color:#B8860B;">'+'预警'+'</span>';
							}else if(value=="4"){
								return '<span style="color:#CD3700;">'+'警告'+'</span>';
							}else if(value=="5"){
								return '<span style="color:red;">'+'拒绝'+'</span>';
							}
						}	
					},
					{field:'notes',title:'备注',width:100,align:'center'},
					{field:'status',title:'状态',width:100,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "使用";
							}else{
								return "注销";
							}
						}					
					},
					{field:'tid',title:'操作',width:150,align:'center', 			
					  formatter:function(value,rec){	
						    if(rec.status=="00"){
						    	return '<a href="javascript:showLimitMem('+value+')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:deleteLimitMem('+value+')" style="color:blue;margin-left:10px">注销</a>';
							}else{
								return '<a href="javascript:startLimitMem('+value+')" style="color:blue;margin-left:10px">启用</a>';
								
					 		}
					  }
				    }
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增商户日累计限次',
					iconCls:'icon-add',
					handler:function(){
						showAdd();
					}
				}]
			}); 
			var p = $('#test').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh:function(){
					
				}
			});
		});
			
		function search(){
			var data={'caseid':$('#s_caseid').val()};
			$('#test').datagrid('load',data);
		}
		
		function showAdd(){	
//			$('#accumulateRateForm :input').val('');
//			$('#Notes').val('');
			showAllriskid();
			showRiskLevel();
			$('#theForm :input').val('');
			$("#theForm").attr("action","riskLimit/saveLimitMemNumDay");
			$('#w').window({
				title: '商户累计限次信息',
				top: panelVertFloat, 
		  		width: panelWidth,
		  		height: panelHeight,
		  		left:panelHoriFloat,
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal: true,
				shadow: false,
				closed: false
			});
			$('#btn_submit').linkbutton('enable');	
		}
		


	function resize() {
		$(':input').val("");
	}
	
	function saveWhitePan(){
		$('#theForm').form('submit', {  
		    onSubmit: function(){  
		    if($('#theForm').form('validate')){
		    	$('#btn_submit').linkbutton('disable');
		    	return true;   
			}
		        return false;   
		    },   
		    success:function(json){
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
	function showRiskLevel(){		
		$.ajax({
		   type: "POST",
		   url: "risk/showAllRisklevel",
		   dataType:"json",
		   success: function(json){
		   		var html ="<option value=''>--请选择风险等级--</option>";
		   		$.each(json, function(key,value){
		   			html += '<option value="'+value.paraCode+'">'+value.paraName+'</option>';	   			
		   		})
				$("#risklevel").html(html);
		   }
		});
	}
	function showuRiskLevel(paraCode){		
		$.ajax({
		   type: "POST",
		   url: "risk/showAllRisklevel",
		   dataType:"json",
		   success: function(json){
		   		var html ="<option value=''>--请选择风险等级--</option>";
		   		$.each(json, function(key,value){
		   			if (value.paraCode == paraCode) {
						html += '<option value="' + value.paraCode + '" selected="selected">' + value.paraName + '</option>';
					} else {
						html += '<option value="' + value.paraCode + '">' + value.paraName + '</option>';
					}   			
		   		});
				$("#risklevel").html(html);
		   }
		});
	}
	function showLimitMem(tid){		
		$.ajax({
		   type: "POST",
		   url: "riskLimit/queryLimitMumDaybytid",
		   data: "tid="+tid,
		   dataType:"json",
		   success: function(json){
			 showriskid(json.riskname);
			$("#notes").val(json.notes);
			$("#limitCount").val(json.limitCount);
			showuRiskLevel(json.risklevel);
			$("#tid").val(json.tid);  
		    }
		
		});
		$('#w').window({
			title: '修改商户日累计限次',
			top: panelVertFloat, 
	  		width: panelWidth,
	  		height: panelHeight,
	  		left:panelHoriFloat,
			collapsible:false,
			minimizable:false,
			maximizable:false,
			modal: true,
			shadow: false,
			closed: false
		});
		$("#theForm").attr("action","riskLimit/updateLimitMemMNumDay");
		$('#btn_submit').linkbutton('enable'); 
	}
	function deleteLimitMem(tid){
		$.messager.confirm('提示','您是否想要注销此商户累计限次?',function(r){   
		    if (r){  
		    	$.ajax({
					type: "GET",
				  	url: "riskLimit/deleteLimitMemNumDay",
				  	data: "&tid="+tid,
				 	dataType: "text",
				 	success:function(text){		
				 		text=JSON.parse(text);
		    			$.messager.alert('提示',text);   
		    			search();
						
				 	}
				});
		    }   
		});  
	}
	function startLimitMem(tid){
		$.messager.confirm('提示','您是否想要启用此委托机构日累计限次限额?',function(r){   
		    if (r){  
		    	$.ajax({
					type: "GET",
				  	url: "riskLimit/startLimitMemDay",
				  	data: "tid="+tid,
				 	dataType: "text",
				 	success:function(text){
				 		text=JSON.parse(text);
		    			$.messager.alert('提示',text);   
		    			search();
				 	}
				});
		    }   
		});  
	}
	function closeAdd(){ 
		$('#w').window('close');			
	}
	
	function showAllriskid(type){
		$.ajax({
			type : "POST",
			url: "riskLimit/getAllLimitRiskList",
			dataType: "json",
			success: function(json) {
				var html = "<option value=''>--请选择风控版本--</option>";
				$.each(json,function(key, value) {
						html += '<option value="' + value.caseid + '">' + value.riskname + '</option>';
				});
				if (type == "serch") {
					$("#s_caseid").html(html);
				} else {
					$("#caseid").html(html);
				}
			}
		});
	}
	function showriskid(riskname){
		$.ajax({
			type : "POST",
			url: "riskLimit/getAllLimitRiskList",
			dataType: "json",
			success: function(json) {
				var html ="<option value=''>--请选择风控版本--</option>";
				$.each(json,function(key, value) {
					if (value.riskname == riskname) {
						html += '<option value="' + value.caseid + '" selected="selected">' + value.riskname + '</option>';
					} else {
						html += '<option value="' + value.caseid + '">' + value.riskname + '</option>';
					}
				});
				$("#caseid").html(html);
			}
		});
	}
</script>
</html>

