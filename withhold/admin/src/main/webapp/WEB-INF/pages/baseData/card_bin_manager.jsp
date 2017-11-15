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
						<input type="hidden" id="oldcardbin" name="oldcardbin">
						<input type="hidden" id="oldcardlen" name="oldcardlen">
						<tr style="height: 25px">
							<td>卡bin</td>
							<td align="left"><input type="text" id="cardbin"
								name="cardbin" class="easyui-validatebox" required="true"
								maxlength="12" missingMessage="卡bin" onkeyup="money()"/><span id="ADDVALUE"></span></td>
							<td>卡名</td>
							<td align="left"><input type="text" id="cardname"
								name="cardname" class="easyui-validatebox" required="true"
								maxlength="12" missingMessage="卡名" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
						</tr>
						<tr style="height: 25px">
							
							<td>主账号卡长</td>
							<td align="left"><input type="text" id="cardlen"
								name="cardlen" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="主账号卡长" onkeyup="moneylen()"/><span id="LENADDVALUE"></span></td>
							<td>卡类型</td>
							<td align="left" style="padding-left: 5px">
								<select id="type" name="type" onchange="yanzhentype()"  >
									<option value=''>--请选择卡类型--</option>
									<option value=1>借记卡</option>
									<option value=2>贷记卡</option>
									<option value=3>准贷记卡</option>
									<option value=4>预付费卡</option>
								</select><span id="yantype"></span></td>
						</tr>
						<tr style="height: 25px">
							<td>发卡行</td>
							<td align="left"><input type="text" id="bankcode"
								name="bankcode" class="easyui-validatebox" 
								maxlength="20" /></td>
							
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
							if(value==1){
								return "借记卡";
							}else if(value==2){
								return "贷记卡";
							}else if(value==3){
								return "准贷记卡";
							}else if(value==4){
								return "预付费卡";
							}
						}
					}, 
					{field:'card',title:'操作',align:'center',width:250,rowspan:2,
						formatter:function(value,rec){
							if(true){
								return '<a href="javascript:showbin(\''+rec.cardbin+'\')" style="color:blue;margin-left:10px">修改</a>'
								
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
	
		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			$("#saveForm").attr("action","bin/save");
			$('#saveForm :input').val('');
			$('#w').window({
				title: '新增卡bin信息',
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
			var type=$("#type").val();
			if(type!=""){
				$("#yantype").html("");
			}else{
				masg = "请选择卡类型";
				$("#yantype").css("color", "red");
				
				$("#yantype").html(masg);
			}
			
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
			    } }  
			});  
		}
		
		function showbin(cardbin){
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
			$.ajax({
			   type: "POST",
			   url: "bin/getSingleById",
			   data: "cardbin="+cardbin,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   if(json!=null){
						$("#cardbin").val(json.cardbin);
						$("#oldcardbin").val(json.cardbin);
						$("#oldcardlen").val(json.cardlen);
						$("#cardname").val(json.cardname);
						$("#cardlen").val(json.cardlen);
						//$("#bankcode").val(json.bankname);
						$('#bankcode').combobox('select',json.bankname);
						$("#type").val(json.type);
				   }		
			   }
			});
			
			$("#saveForm").attr("action","bin/update");
			$('#btn_submit').linkbutton('enable');	
		}
		// 验证cardbin
		function money() {
			var cardbin = $("#cardbin").val();
			
			var masg;
			var isok = true;
			if (cardbin != null && !isNaN(cardbin)) {

				$("#ADDVALUE").html("");
			} else {
				masg = "请输入正确的数值";
				$("#ADDVALUE").css("color", "red");

				isok = false;
				$("#ADDVALUE").html(masg);
				
			}
			return isok;
		}
		// 验证cardlen
		function moneylen() {
			
			var len = $("#cardlen").val();
			var masg;
			var isok = true;
			if (len!=null&& !isNaN(len)) {

				$("#LENADDVALUE").html("");
			} else {
				masg = "请输入正确的数值";
				$("#LENADDVALUE").css("color", "red");

				isok = false;
				
				$("#LENADDVALUE").html(masg);
			}
			return isok;
		}
		//yanzhentype(1)
		function yanzhentype(){
			var type=$("#type").val();
			if(type!=""){
				$("#yantype").html("");
			}else{
				masg = "请选择卡类型";
				$("#yantype").css("color", "red");
				
				$("#yantype").html(masg);
			}
		}
		
	$(function() {

	$('#bankcode').combobox({
		 required:true, 
		width:260,
		 missingMessage:"请输入开户行", 
		valueField:'text',
		textField:'text',
	    mode:'remote',
	    editable:true,
		onChange: function(newValue,oldValue){
			if(newValue==null||newValue==""){
				return;
			}
			if(newValue==oldValue){
				return;
			}
			var url = 'bin/selectTbankInsti?bankname='+ encodeURI(newValue);
            $('#bankcode').combobox('reload', url);
            
		}
	});
	
});
	function selectTbankInsti(jp) {
		$.ajax({
			type: "POST",
			url: "bin/selectTbankInsti",
			data: "bankname=" +jp,
			/* dataType: "json", */
			success: function(json) {
				if(json!=null){
				var html;
				$.each(json,function(key, value) {
					//alert(value.id);
					var codenode = value.id;
					$("#bankcode").val(codenode);
				});
			}}
		});
	}
	function invokeFunction() {
		showbinFunction($('#userId').val())
	}
</script>

</html>
