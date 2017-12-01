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

}
</style>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="上传Excel文件" style="height: 130px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="uploadForm"  enctype="multipart/form-data">
				<table width="100%" >
					<!--  <tr style="height: 25px">
							<td>交易要素</td>
							<td align="left"><select id="transfactors" class="easyui-validatebox" required="true" missingMessage="请选择交易要素" name="transfactors"/>
							
							</select></td>
						</tr> -->
					<div>
    					<input type="file" name="excelFile">
    					<input type="button" id="btn" value="解析" >
					</div>
					
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
	
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="saveForm" action="portalManager/startBatchTrade"
					method="post">
					<input type="hidden" id="json_Str" name="jsonStr" /> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td>交易要素</td>
							<td align="left"><select id="Ttransfactors" class="easyui-validatebox" required="true" missingMessage="请选择交易要素" name="transfactors"/>
							
							</select><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
						<td>交易批次号</td>
						<td align="left"><input type="text" id="batchNo"
							name="batchNo" class="easyui-validatebox" required="true"
							maxlength="20" missingMessage="请输入交易批次号" onkeyup="value=value.replace(/<[^<]+>/g,'')"/><font color="red">*</font></span></td>
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
						showAdd(0);
						$("#saveForm").attr("action","portalManager/startBatchTrade");
					},   
				    
				}]
			}); 
			
		});
	
		function resize(){
			$('#searchForm :input').val('');
		}
		
	
	function showAdd(num) {

		var rows = $("#excelDetail").datagrid("getRows");
		$("#saveForm").attr("action", "portalManager/startBatchTrade");
		//$('#saveForm :input').val('');
		var jstr = $("#json_Str").val();
		if (jstr == "") {
			$.messager.alert('提示', "请优先上传批量文件");
		} else {
			$('#w').window({
				title : '发起批量交易',
				top : 100,
				width : 350,
				modal : true,
				minimizable : false,
				collapsible : false,
				maximizable : false,
				shadow : false,
				closed : false,
				height : 160
			});
			$('#btn_submit').linkbutton('enable');
		}
	}
	function closeAdd() {
		$('#w').window('close');

	}
	/* function search(){
		 //document.getElementById("uploadForm").submit();
	
		 var data=new FormData($('#uploadForm')[0]);
		 $('#test').datagrid('load', data);
			
		
	} */
	function saveUser() {
		$('#saveForm').form('submit', {
			onSubmit : function() {

				if ($('#saveForm').form('validate')) {
					$('#btn_submit').linkbutton('disable');
					return true;
				}
				return false;
			},
			success : function(data) {
				if(data!=null){
				var json = eval('(' + data + ')')
				$('#w').window('close');
				$('#btn_submit').linkbutton('enable');
				if (json.resultBool == true) {
					$.messager.alert('提示', "发起批量交易成功");
				} else if (json.resultBool == false) {
					$.messager.alert('提示', "发起批量交易失败");
				}
				}
			},
			error : function(){
				$.messager.alert('提示', '服务异常！');
			}
		});
	}

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
		if (len != null && !isNaN(len)) {

			$("#LENADDVALUE").html("");
		} else {
			masg = "请输入正确的数值";
			$("#LENADDVALUE").css("color", "red");

			isok = false;

			$("#LENADDVALUE").html(masg);
		}
		return isok;
	}

	function invokeFunction() {
		showbinFunction($('#userId').val())
	}
	//页面加载完成 获取交易要素
	$(document)
			.ready(
					function() {
						$
								.ajax({
									type : "POST",
									url : "portalManager/getTransfactors",
									dataType : "json",
									success : function(json) {

										var html = '<option value="' + json.added + '" selected="selected">'
												+ json.paraName + '</option>';
										$("#transfactors,#Ttransfactors").html(
												html);
										//alert(html);
									},
								
								});
					})
	//ajax上传Excel文件
	$('#btn').click(function() {
		//$('#btn').linkbutton('disable');	
		$.ajax({
			url : 'portalManager/showDetails',
			type : 'POST',
			cache : false,
			data : new FormData($('#uploadForm')[0]),
			processData : false,
			contentType : false,
			success : function(json) {
				//$('#btn').linkbutton('enable');	
				$('#excelDetail').datagrid('loadData', json);
				var jsonStr = JSON.stringify(json);
				//alert(jsonStr)
				$('#json_Str').val(jsonStr);

			},
			error : function(){
				$.messager.alert('提示', '服务异常！');
			}
		});

	});
	function isordernum() {
		var cardbin = $("#0").val();
		
		var masg;
		var isok = true;
		if (cardbin != null && !isNaN(cardbin)) {

			$("#order_id").html("");
		} else {
			masg = "请输入正确的数值";
			$("#order_id").css("color", "red");

			isok = false;
			$("#order_id").html(masg);
			//$("#order_id,#pan_id,#phone_num,#id_card,#amount").html(masg);
		}
		return isok;
	}
</script>

</html>
