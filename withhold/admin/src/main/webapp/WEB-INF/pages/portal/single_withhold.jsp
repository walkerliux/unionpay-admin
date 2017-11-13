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
		<div id="p" class="easyui-panel" title="实时交易" style="height: 1000px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="searchForm" method="post" action="portalManager/startRealTimeTrade">
			
				<table width="100%" style="border-collapse:separate; border-spacing:0px 40px;">
					<tr>
						<td align="right">商户订单号</td>
						<td align="left" style="padding-left: 5px"><input
							name="orderId" id="0" maxlength="64" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入商户订单号" onkeyup="isordernum()"/><span id="order_id"></span></td>
						<td align="right">交易要素</td>
							<td class="right" align="left">
							<select id="transfactors" class="easyui-validatebox" required="true" missingMessage="请选择交易要素" name="factorId"/>
							
							</select><font color="red">*</font></td>
					</tr>			
					<tr >
						<td align="right" class="6">银行卡号</td>
						<td align="left" style="padding-left: 5px"><input
							class="6" name="priAcctId" id="6" maxlength="64" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入银行卡号" onkeyup="ispan()"/><span id="pan_id"></span></td>
					</tr>			
					<tr >	
						<td align="right" class="2">姓名</td>
						<td align="left" style="padding-left: 5px"><input
							class="2" name="name" id="2" maxlength="64" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入持卡人姓名" onkeyup="value=value.replace(/<[^<]+>/g,'')"/></td>
					</tr>	
					<tr>
						<td align="right"  class='3'>手机号</td>
						<td align="left" style="padding-left: 5px"><input
							class="3" name="phone" id="3" maxlength="64" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入手机号" onkeyup="isphone()"/><span id="phone_num"></span></td>
					</tr>			
					<tr >		
						<td align="right" class="4">身份证号</td>
						<td align="left" style="padding-left: 5px"><input
							class='4' name="idCard" id="4" maxlength="64" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入身份证号" onkeyup="isId()"/><span id="id_card"></span></td>
					</tr>
					<tr >
						<td align="right" name="5">交易金额(元)</td>
						<td align="left" style="padding-left: 5px"><input
							 name="transAt" id="5" maxlength="64" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入交易金额" onkeyup="money()"/><span id="amount"></span></td>

					</tr>		
					</table>
				</form>
				<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveUser()" id="btn_submit" onclick="">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:resize()">清空</a>
			</div>
		</div>
		</div>
		
</body>
<script>

	function saveUser() {
		$('#searchForm').form('submit', {
			onSubmit : function() {
				if ($('#searchForm').form('validate')) {
					$('#btn_submit').linkbutton('disable');
					return true;
				}
				return false;
			},
			success : function(data) {
				var json = eval('(' + data + ')')
	    		$('#w').window('close');	
	    		$('#btn_submit').linkbutton('enable'); 
	    		if(json.resultBool==true){
					$.messager.alert('提示',"发起实时交易成功");  
				}else if(json.resultBool==false){
					$.messager.alert('提示',"发起实时交易失败");  
				} 
			/* 	$.each(json, function(key, value) {
					$.messager.alert('提示', value);
					search();
					closeAdd();
					$('#btn_submit').linkbutton('enable');
				}) */
			}
		});
	}
	function resize() {
		$('#searchForm :input').val('');
	}

	$(function() {
		$.ajax({
				type : "POST",
				url : "portalManager/getTransfactors",
				dataType : "json",
				success : function(json) {
					var html = '<option value="' + json.paraCode + '" selected="selected">'
							+ json.paraName + '</option>';
					$("#transfactors").html(html);
					if (json.paraCode.charAt(0) == '0') {
						$(".4").hide();
					}
					if (json.paraCode.charAt(1) == '0') {
						$(".6").hide();
					}
					if (json.paraCode.charAt(2) == '0') {
						$(".3").hide();
					}
					if (json.paraCode.charAt(3) == '0') {
						$(".2").hide();
					}
				}

			});
	});
	//验证
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
	function ispan() {
		var cardbin = $("#6").val();
		
		var masg;
		var isok = true;
		if (cardbin != null && !isNaN(cardbin)) {

			$("#pan_id").html("");
		} else {
			masg = "请输入正确的数值";
			$("#pan_id").css("color", "red");

			isok = false;
			$("#pan_id").html(masg);
			//$("#order_id,#pan_id,#phone_num,#id_card,#amount").html(masg);
		}
		return isok;
	}
	function isphone() {
		var cardbin = $("#3").val();
		
		var masg;
		var isok = true;
		if (cardbin != null && !isNaN(cardbin)) {

			$("#phone_num").html("");
		} else {
			masg = "请输入正确的数值";
			$("#phone_num").css("color", "red");

			isok = false;
			$("#phone_num").html(masg);
			//$("#order_id,#pan_id,#phone_num,#id_card,#amount").html(masg);
		}
		return isok;
	}
	function isId() {
		var cardbin = $("#4").val();
	
		var masg;
		var isok = true;
		if (cardbin != null && !isNaN(cardbin)) {

			$("#id_card").html("");
		} else {
			masg = "请输入正确的数值";
			$("#id_card").css("color", "red");

			isok = false;
			$("#id_card").html(masg);
			//$("#order_id,#pan_id,#phone_num,#id_card,#amount").html(masg);
		}
		return isok;
	}
	function money() {
		var cardbin = $("#5").val();
		
		var masg;
		var isok = true;
		if (cardbin != null && !isNaN(cardbin)) {

			$("#amount").html("");
		} else {
			masg = "请输入正确的数值";
			$("#amount").css("color", "red");

			isok = false;
			$("#amount").html(masg);
			//$("#order_id,#pan_id,#phone_num,#id_card,#amount").html(masg);
		}
		return isok;
	}
</script>
</html>