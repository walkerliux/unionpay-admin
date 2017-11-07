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
			<form id="searchForm" method="post">
			<form action="" id="searchForm">
				<table width="100%" style="border-collapse:separate; border-spacing:0px 40px;">
					<tr>
						<td align="right">商户订单号</td>
						<td align="left" style="padding-left: 5px"><input
							name="memberId" id="0" maxlength="64" /></td>
						<td align="right">交易要素</td>
							<td class="right" align="left">
							<select id="transfactors" class="easyui-validatebox" required="true" missingMessage="请选择交易要素" name="transfactors"/>
							
							</select><font color="red">*</font></td>
					</tr>			
					<tr >
						<td align="right" class="6">银行卡号</td>
						<td align="left" style="padding-left: 5px"><input
							class="6" name="6" id="6" maxlength="64" /></td>
					</tr>			
					<tr >	
						<td align="right" class="2">姓名</td>
						<td align="left" style="padding-left: 5px"><input
							class="2" name="2" id="2" maxlength="64" /></td>
					</tr>	
					<tr>
						<td align="right"  class='3'>手机号</td>
						<td align="left" style="padding-left: 5px"><input
							class="3" name="3" id="3" maxlength="64" /></td>
					</tr>			
					<tr >		
						<td align="right" class="4">身份证号</td>
						<td align="left" style="padding-left: 5px"><input
							class='4' name="4" id="4" maxlength="64" /></td>
					</tr>
					<tr >
						<td align="right" name="5">交易金额</td>
						<td align="left" style="padding-left: 5px"><input
							 name="" id="5" maxlength="64" /></td>

					</tr>		
						
					</table>
					<table width="100%" align="center"  middle="center">
						<tr >						
							<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">清空</a>
							<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveMerchDetaApply()" id="btn_submit">提交</a>
						</tr>
						</table>
				</form>
		</div>
		</div>
		
</body>
<script>
$(function(){
	$.ajax({
		   type: "POST",
		   url: "portalManager/getTransfactors",	 
		   dataType:"json",
		   success: function(json) {
	
		var	html = '<option value="' + json.paraCode + '" selected="selected">' + json.paraName + '</option>';
			$("#transfactors").html(html);
			if(json.paraCode.charAt(0)=='0'){
				$(".4").hide();	
			}
			if(json.paraCode.charAt(1)=='0'){
				$(".6").hide();	
			}
			if(json.paraCode.charAt(2)=='0'){
				$(".3").hide();	
			}
			if(json.paraCode.charAt(3)=='0'){
				$(".2").hide();	
			}
			}
		
		});
	
	
});	
	
</script>
</html>