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
					<tr height="26" id="fileadd1">
						<td align="center">对账机构</td>
						<td colspan="1"><select id="instiid_ins"
							class="easyui-validatebox" name="instiid">
						</select></td>
						<td align="center" colspan="2" id="uploadbutton"><a
							class="easyui-linkbutton" iconCls="icon-ok"
							href="javascript:saveProcess()">生成任务</a></td>
					</tr>
					<tr>

						<td align="center">开始日期</td>
						<td><input name="agreemtStart" maxlength="12" type="text"
							id="startDate" /></td>
						<td align="center">终止日期</td>
						<td><input class="easyui-validatebox" maxlength="12"
							name="agreemtEnd" id="endDate" /></td>
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
	  	  $('#startDate,#endDate').datebox({   
	      }); 
	  	queryChannel();
	}); 	
	function queryChannel() {
		$.ajax({
			type : "POST",
			url : "checkbill/queryChannel",
			data : "",
			dataType : "json",
			success : function(json) {
				var html = "<option  Seleted ='Seleted' value=''>--请选择--</option>";
				$.each(json,
				function(key, value) {
					html += '<option value="' + value.chnlcode + '">' + value.chnlname + '</option>';
				});
				$("#instiid_ins").html(html);
			}
		});
	}
	
	$(function(){
		$('#test').datagrid({
			title:'任务列表',
			iconCls:'icon-save',
			height:400,
			singleSelect:true,
			nowrap: false,
			striped: true,
			url:'checkbill/queryProcess',
			remoteSort: false,
			idField:'tid',
			columns:[
			[
				{field:'tid',title:'任务代码',width:120,align:'center'},
				{field:'starttime',title:'任务开始时间',width:160,align:'center'},
				{field:'status',title:'状态',width:120,align:'center',
					formatter:function(value,rec){
					if(value=="00"){
						return "初始";
					}else if(value=="01"){
						return "进行中";
					}else if(value=="02"){
						return "失败终止";
					}else if(value=="99"){
						return "成功结束";
					}
				}
					},	
				{field:'1',title:'操作',width:260,align:'center',
				formatter:function(value,rec){
					if(rec.status=="00"){
						return '<a id="sp'+rec.tid+'" href="javascript:startProcess('+rec.tid+')" style="color:blue;margin-left:10px">开始任务</a>';
					}else{
						return '<a href="javascript:showCheckSuccess(\'' + rec.tid + '\')" style="color:blue;margin-left:10px">查看对账表</a>' + 
						       '<a href="javascript:showCheckFail(\'' + rec.tid + '\')" style="color:blue;margin-left:10px">查看差错表</a>' +
						       '<a href="javascript:showSumInfo(\'' + rec.tid + '\')" style="color:blue;margin-left:10px">查看汇总信息</a>' ;
					}
				}
				}
			]],
			pagination:true,
			rownumbers:true
		});
	});
	
	
	function saveProcess() {
		if($("#instiid_ins").val()==""){
			alert("请选择对账机构");
		}else{
			$('#theForm').form('submit', {
				onSubmit : function() {
					return $('#theForm').form('validate');
				},
				success : function(json) { 
					json =eval('('+json+')');
					if (json.INFO == "执行成功!") {				
						$.messager.alert('提示', json.INFO);
					} else {
						$("#uploadbutton").show();
						$.messager.alert('提示', json.INFO);
						$("#uploadbutton").show();
						$("#uploadhint").hide();
					}
					search();
				}
			});
		}		
	}
	function search(){
		var data={"startDate":$('#startDate').datebox('getValue'),"endDate":$("#endDate").datebox('getValue'),instiid:$("#instiid_ins").val()};
		$('#test').datagrid('load',data);
	}
	function startProcess(tId) {
		 document.getElementById("sp"+tId).href = "javascript:void(0)"; 
		 document.getElementById("sp"+tId).innerHTML = "任务正在执行...";
		 document.getElementById("sp"+tId).style.color="#708090";
		 $.ajax({
			   type: "POST",
			   url: "checkbill/startCheckFile",
			   data: "filestartid="+tId,
			   dataType:"json",
			   success:function(json){
					if(json.resultBool==false){
						$.messager.alert('提示',json.errMsg);   
					}else{
						$.messager.alert('提示',json.resultObj); 
					}
		    		search();
			 	}
			}); 
	}
    
	function showCheckSuccess(proid){				
		$('#success').datagrid({
			title:'对账信息表',
			iconCls:'icon-save',
			height:400,
			singleSelect:true,
			nowrap: false,
			striped: true,
			url:'checkbill/querySuccess',			
			remoteSort: false,
			idField:'tid',
			queryParams:{
				"proid": proid
				},
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
			rownumbers:true,
		});
	}
	function exportSuccess(proid){
		$('#check').attr("action","checkinfo/exportCheckSuccess");
		$("#check").submit();
	}
	function showCheckFail(proid){	
		$("#hidproid").val(proid);
		$('#success').datagrid({
			title:'差错信息表',
			iconCls:'icon-save',
			height:400,
			singleSelect:true,
			nowrap: false,
			striped: true,
			url:'checkbill/queryFail',			
			remoteSort: false,
			queryParams:{
				"proid": proid
				},
			idField:'iid',
			columns:[
			[
				{field:'txnseqno',title:'交易流水号',width:140,align:'center'},
				{field:'payordno',title:'支付订单号',width:140,align:'center'},
				{field:'txndatetime',title:'交易时间',width:140,align:'center'},
				{field:'busicode',title:'交易类型',width:140,align:'center'},
				{field:'amount',title:'交易金额(元)',width:140,align:'center'},
				{field:'mistakedesc',title:'差错原因',width:240,align:'center'},
				{field:'1',title:'操作状态',width:260,align:'center',
					formatter:function(value,rec){
						if(rec.mistatus=="01"){
							return '<a id="sp'+rec.tid+'" href="javascript:refuse('+rec.iid+')" style="color:blue;margin-left:10px">拒绝</a>'
							+'<a id="sp'+rec.tid+'" href="javascript:unrefuse('+rec.iid+')" style="color:blue;margin-left:10px">处理</a>';
						}
						if(rec.mistatus=="19"){
							return '拒绝处理';
						}
						if(rec.mistatus=="10"){
							return '已处理';
						}
						
					}
				}
			]],
			pagination:true,
			rownumbers:true
		});
			
	}
	
	function refuse(iid){
		$.messager.prompt('拒绝处理', '请输入处理意见:', function(r){
			if (r){
				$.ajax({
					   type: "POST",
					   url: "checkbill/dealmistake",
					   data: {
						   "result":r,
						   "status":"19",
						   "iid":iid
					   },
					   dataType:"json",
					   success:function(json){
							if(json.resultBool==false){
								$.messager.alert('提示',json.errMsg);   
							}else{
								$.messager.alert('提示',json.resultObj); 
							}
							showCheckFail($("#hidproid").val());
					 	}
					}); 
			}
		});
	}
	function unrefuse(iid){
		$.messager.prompt('拒绝处理', '请输入处理意见:', function(r){
			if (r){
				$.ajax({
					   type: "POST",
					   url: "checkbill/dealmistake",
					   data: {
						   "result":r,
						   "status":"10",
						   "iid":iid
					   },
					   dataType:"json",
					   success:function(json){
							if(json.resultBool==false){
								$.messager.alert('提示',json.errMsg);   
							}else{
								$.messager.alert('提示',json.resultObj); 
							}
							showCheckFail($("#hidproid").val());
					 	}
					}); 
			}
		});
	}
	function showSumInfo(proid){
		$('#success').datagrid({
			title:'对账信息汇总表',
			iconCls:'icon-save',
			height:400,
			singleSelect:true,
			nowrap: false,
			striped: true,
			url:'checkbill/dealReasult',			
			remoteSort: false,
			queryParams:{
				"proid": proid
				},
			idField:'iid',
			columns:[
			[
				{field:'succSum',title:'成功金额',width:140,align:'center'},
				{field:'succNumber',title:'成功笔数',width:140,align:'center'},
				{field:'failLocalSum',title:'平台失败金额',width:140,align:'center'},
				{field:'failLocalNumber',title:'平台失败笔数',width:140,align:'center'},
				{field:'failMerchSum',title:'商户失败金额',width:140,align:'center'},
				{field:'failMerchNumber',title:'商户失败笔数',width:240,align:'center'},
			]],
			pagination:true,
			rownumbers:true
		});
	}
	function exportFail(proid){
		$.messager.alert('提示',"敬请期待......");   
	}
	function resize(){
		$('#theForm :input').val('');
	}
</script>
</html>
