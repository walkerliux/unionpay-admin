<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<jsp:include page="../../top.jsp"></jsp:include>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 120px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post"
				action="checkbill/saveProcess">
				<input type="hidden" id="hidproid" name="hidproid">
				<table width="100%">
					<tr>

						<td align="center">日期</td>
						<td><input name="agreemtStart" maxlength="12" type="text"
							id="startDate" /></td>
						<td>
							<div region="south" border="false"
								style="text-align: center; padding: 5px 0;">
								<a class="easyui-linkbutton" iconCls="icon-ok"
									href="javascript:search()" id="btn_submit" onclick="">查询</a>
								<a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a>
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
		<div>
			<form id="check" method="post" action="">
				<table id="success"></table>
			</form>
		</div>

	</div>
</body>
<script>
	$(function(){
	  	  $('#startDate').datebox({   
	      }); 
	}); 	
	$(function(){
		$('#test').datagrid({
			title:'任务列表',
			iconCls:'icon-save',
			height:400,
			singleSelect:true,
			nowrap: false,
			striped: true,
			url:'checkbill/querySuccessBymerch',
			remoteSort: false,
			idField:'tid',
			columns:[
			[
				{field:'txnseqno',title:'交易流水号',width:140,align:'center'},
				{field:'payordno',title:'支付订单号',width:140,align:'center'},
				{field:'txndatetime',title:'交易时间',width:140,align:'center'},
				{field:'busicode',title:'交易类型',width:140,align:'center'},
				{field:'amount',title:'交易金额(元)',width:140,align:'center'},
				{field:'instiid',title:'收费单位代码',width:140,align:'center'},
			]],
			pagination:true,
			rownumbers:true
		});
	});
	function search(){
		var data={"date":$('#startDate').datebox('getValue')};
		$('#test').datagrid('load',data);
	}
	function exportSuccess(proid){
		$('#check').attr("action","checkinfo/exportCheckSuccess");
		$("#check").submit();
	}
	
	function exportFail(proid){
		$.messager.alert('提示',"敬请期待......");   
	}
	function resize(){
		$('#theForm :input').val('');
	}
</script>
</html>
