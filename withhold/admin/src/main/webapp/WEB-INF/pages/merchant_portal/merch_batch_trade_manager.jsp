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
		<div id="p" class="easyui-panel" title="上传Excel文件" style="height: 130px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="uploadForm"  enctype="multipart/form-data">
				<table width="100%" >
					<tr style="height: 25px">
							<td>交易要素</td>
							<td align="left"><input type="text" id="user_loginName"
								name="loginName" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入登录账号" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
						</tr>
					<!--<tr> 
						<td align="right"></td>
						<td  align="left" style="padding-left: 5px">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">解析</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
					</tr>  -->
					
					
   					 <td><input  type="file" name="excelFile">
   					 <input type="button" id="btn" value="解析"></td>
   					 
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="excelDetail">
				<thead>
					<tr>
						<th data-options="field:'orderId'" align="center" width="150">商户订单号</th>
						<th data-options="field:'cardNo'" align="center" width="150">银行卡号</th>
						<th data-options="field:'customerNm'" align="center" width="150">持卡人姓名</th>
						<th data-options="field:'phoneNo'" align="center" width="150">手机号</th>
						<th data-options="field:'certifId'" align="center" width="150">身份证号</th>
						<th data-options="field:'amt'" align="center" width="150">交易金额(元)</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<!-- <div id="w3" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 300px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<input id="userId_addrole" name="userId" type="hidden" />
				<form action="" id="passwordRestForm" name="PasswordForm">
				<table width="100%" id="excelDetail">
					
				</table>
			</form>
				
			</div>
		</div>
	</div> -->
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="saveForm" action="portalManager/save"
					method="post">
					<input type="hidden" id="user_id" name="userId" /> <input
						type="hidden" id="user_status" name="status" />
					<table width="100%" cellpadding="2" cellspacing="2">
						 <tr style="height: 25px">
						<td>交易批次号</td>
						<td align="left"><input type="text" id="batchNo"
							name="batchNo" class="easyui-validatebox" required="true"
							maxlength="20" missingMessage="请输入交易批次号" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
						</tr>
						<tr style="height: 25px">
							<td>交易要素</td>
							<td align="left"><input type="text" id="user_loginName"
								name="loginName" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入登录账号" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
						</tr>
						
						
					</table>
				</form>
				<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveUser()" id="btn_submit" onclick="">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
		</div>
			</div>
	
	

	
	
	
	
</body>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyuiExtension.js"></script> 
<script>
  	var width = $("#continer").width();
		$(function(){
			$('#excelDetail').datagrid({
				title:'文件内容详情',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				remoteSort: false,
				
				toolbar:[{
					id:'btnadd',
					text:'发起批量交易',
					iconCls:'icon-add',
					handler:function(){
						$("#user_code").attr('readonly','readonly');
						showAdd(0);
						$("#saveForm").attr("action","portalManager/save");
					},   
				    
				}]
			}); 
			
		});
	
		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			var rows = $("#excelDetail").datagrid("getRows"); 
			alert(rows[0].orderId);
			$("#saveForm").attr("action","portalManager/save");
			$('#saveForm :input').val('');
			$('#w').window({
				title: '发起批量交易',
				top:100,
				width: 350,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 160
			});
			$('#btn_submit').linkbutton('enable');	
		}
		function closeAdd(){
			$('#w').window('close');
			
		}		
		function search(){
			 //document.getElementById("uploadForm").submit();
		
			 var data=new FormData($('#uploadForm')[0]);
			 $('#test').datagrid('load', data);
				
			
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
			   url: "bin/getSingleById1",
			   data: "cardbin="+cardbin,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   //alert(json.bankname);
						$("#cardbin").val(json.cardbin);
						$("#oldcardbin").val(json.cardbin);
						$("#oldcardlen").val(json.cardlen);
						$("#cardname").val(json.cardname);
						$("#cardlen").val(json.cardlen);
						//$("#bankcode").val(json.bankname);
						$('#bankcode').combobox('select',json.bankname);
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


	
});
	function selectTbankInsti(jp) {
		$.ajax({
			type: "POST",
			url: "bin/selectTbankInsti",
			data: "bankname=" +jp,
			/* dataType: "json", */
			success: function(json) {
				var html;
				$.each(json,function(key, value) {
					alert(value.id);
					var codenode = value.id;
					$("#bankcode").val(codenode);
				});
			}
		});
	}
	function invokeFunction() {
		showbinFunction($('#userId').val())
	}
	
	$('#btn').click(function () {
	    $.ajax(
	        {
	        	 url: 'portalManager/showDetails',
	        	    type: 'POST',
	        	    cache: false,
	        	    data: new FormData($('#uploadForm')[0]),
	        	    processData: false,
	        	    contentType: false,
	            	success: function (json) {
	            	 //alert(str);
	            	 $('#excelDetail').datagrid('loadData', json);
	            }
	        }
	    );
	  
	});
	
</script>

</html>
