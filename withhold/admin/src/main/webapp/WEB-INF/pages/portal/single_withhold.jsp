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
								maxlength="20" missingMessage="请输入商户订单号" onkeyup="value=value.replace(/<[^<]+>/g,'')"/><font color="red">*</font></td>
						<td align="right">交易要素</td>
							<td class="right" align="left" >
							<select id="transfactors" class="easyui-validatebox" required="true" missingMessage="请选择交易要素" name="factorId"/>
							
							</select><font color="red">*</font></td>
					</tr>			
					<tr >
						<td align="right" class="6">银行卡号</td>
						<td align="left" style="padding-left: 5px"><input
							class="6" name="priAcctId" id="6"  class="easyui-validatebox" required="true"
							type="text"	maxlength="20" missingMessage="请输入银行卡号" validtype="number"/><font color="red">*</font></td>
					</tr>			
					<tr >	
						<td align="right" class="2">姓名</td>
						<td align="left" style="padding-left: 5px"><input
							class="2" name="name" id="2"  class="easyui-validatebox" required="true"
							type="text"	maxlength="10" missingMessage="请输入持卡人姓名" onkeyup="value=value.replace(/<[^<]+>/g,'')"/><font color="red">*</font></td>
					</tr>	
					<tr>
						<td align="right"  class='3'>手机号</td>
						<td align="left" style="padding-left: 5px"><input
							type="text" class="3" name="phone" id="3"  class="easyui-validatebox" required="true"
								maxlength="11" missingMessage="请输入手机号" validtype="mobile"/><font color="red">*</font></td>
					</tr>			
					<tr >		
						<td align="right" class="4">身份证号</td>
						<td align="left" style="padding-left: 5px"><input
							type="text" class='4' name="idCard" id="4" class="easyui-validatebox" required="true"
								maxlength="18" missingMessage="请输入身份证号" validtype="idcard"/><font color="red">*</font></td>
					</tr>
					<tr >
						<td align="right" name="5">交易金额(元)</td>
						<td align="left" style="padding-left: 5px"><input
							 name="transAt" id="5"  class="easyui-validatebox" required="true"
							type="text"	maxlength="20" missingMessage="请输入交易金额" validtype="money"/><font color="red">*</font></td>

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
				if(data!=null){
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
					var html = '<option value="' + json.added + '" selected="selected">'
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
	
	function ismoney() {
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
	
	 $(function() {
		//设置text需要验证
		$('input[type=text]').validatebox();
		//18.验证数字
		$.extend($.fn.validatebox.defaults.rules, {
			//验证数字
			number : {
				validator : function(value, param) {
					return /^[0-9]+.?[0-9]*$/.test(value);
				},
				message : '请输入数字卡号'
			},
			//.移动手机号码验证
			mobile : {
				//value值为文本框中的值
				validator : function(value) {
					var reg = /^1[0|1|2|3|4|5|6|7|8|9]\d{9}$/;
					return reg.test(value);
					//return /^[0-9]+.?[0-9]*$/.test(value);
				},
				message : '输入11位手机号码'
			},
			//验证身份证
			idcard : {// 验证身份证
				validator : function(value) {
					return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
				},
				message : '身份证号码格式不正确'
			},
			name: {
				validator: function (value) {
				return /^[\Α-\￥]+$/i.test(value) | /^\w+[\w\s]+\w+$/i.test(value);
				},
				message: '请输入中文/英文姓名'
				},
			money:{//
				validator: function (value) {
					/* var reg =/^(([1-9]\d*)|([0-9]\d*\.\d?[1-9]{1}))$/;
					return reg.test(value); */
					return /^(([1-9][0-9]*)|(([0]\.\d{0,2}|[1-9][0-9]*\.\d{0,2})))$/.test(value);
				},
				message: '请输入正确格式的金额(小数位最多两位)'
				},
			pan:{
				validator: function (value) {
					return /^(\d{16}|\d{19})$/;
				},
				message: '请输入银行卡号'
				},
		});
	}) 
</script>
</html>