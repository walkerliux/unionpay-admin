<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<style type="text/css">
table tr td input {
	height: 15px
}

table tr td select {
	height: 20px
}
table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
table tr td.add {
	height: 25px;
}
table tr td.update {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
</style>
<script type="text/javascript" src="js/extendsValidator_1.0_20151215.js"></script>

<div id="win_common_rate" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
	<div class="easyui-layout" fit="true">
		<div region="center" border="false" style="border: 1px solid #ccc; background: #fff; border: 1px solid #ccc; text-align: center">
			<form id="theForm" action="agency/upload" method="post">
				<table id="charge_mode_common_grid"></table>
			</form>
		</div>
		<div region="south" border="false" style="text-align: center; padding: 5px 0;">
			<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveCommonRate()" id="btn_upload">确定</a> 
			<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:closeCommonRateWindow()">取消</a>
		</div>
	</div>
</div>
<div id="win_common_rate_add" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="txnNumRateForm"
					action="fee/saveTxnRate" method="post">
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left">
						<tr>
							<td class="update" width="15%">扣率代码</td>
							<td class="update" width="30%"><input id="rateId-form"  name="rateId" maxlength="10"/></td>
							<td class="update" width="15%">扣率描述</td>
							<td class="update"><input id="rateDes-form" name="rateDes" maxlength="64" /></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update">计费方式</td>
							<td class="update"><select id="n_rateType" class="easyui-validatebox" required="true" name="rateType"
								onchange="showNumRateDetail()" missingMessage="请选择计费方式">
							</select></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="n_feeRate" name="feeRate" validType="percent" required="true" type="text"
								class="easyui-validatebox" maxlength="5" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="n_minFee" name="minFee" maxlength="12" validType="amount" required="true"
							 type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="n_maxFee" name="maxFee" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
						<tr>
							<td class="update">备注</td>
							<td class="update" colspan="3"><textarea id="notes" rows="3" cols="75" name="notes" maxlength="32"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" id="n_save_button" iconCls="icon-ok"
					href="javascript:saveNumTxnRate()" onclick="">保存</a> <a
					class="easyui-linkbutton" id="n_cancel_button" iconCls="icon-cancel"
					href="javascript:void(0)" onclick="closeNumRate()">取消</a>
			</div>
		</div>
	</div>
<script>
	  var width = $("#continer").width();
	  var gridHeight = 600;
	  var panelWidth = 800;
	  var panelHeight = 260;
	  var panelHoriFloat = (width-panelWidth)/2;
	  var panelVertFloat = 150;
	  function showCommonChargeMode(type){
			$('#win_common_rate').window({
				top:100,
				left:280,
				title: "配置计费方式",
				width: 650,
				modal: true,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				shadow: false,
				closed: false,
				height: 500
			});
			
			$('#charge_mode_common_grid').datagrid({
				height: 400,
				singleSelect: true,
				nowrap: false,
				striped: true,
				url: 'fee/queryCommonRate',
				queryParams:{"rateType":"01"},
				remoteSort: false,
				columns: [[
				{
					align: 'center',
					checkbox:true
				},
				{
					field: 'RATE_ID',
					title: '扣率代码',
					width: 150,
					align: 'center'
				},
				{
					field: 'RATE_DESC',
					title: '扣率描述',
					width: 120,
					align: 'center'
				},
				{
					field: 'RATE_TYPE_NAME',
					title: '计费方式',
					width: 150,
					align: 'center'
				},
				/* {
					field: 'FEE_RATE',
					title: '扣率(百分比)',
					width: 100,
					align: 'center'
				}, */
				{
					field: 'MIN_FEE',
					title: '金额(元)',
					width: 100,
					align: 'center'
				}
				/* {
					field: 'MAX_FEE',
					title: '最高额(元)',
					width: 100,
					align: 'center'
				}, */
				
				]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增按笔收费扣率',
					iconCls: 'icon-add',
					handler: function() {
						show_number_rate();
					}
				}]
			});
			var p = $('#test').datagrid('getPager');
			$(".datagrid-header-check input").hide();
		}
	  $(function(){
		  $.ajax({
				type: "POST",
				url: "fee/queryRateType",
				dataType: "json",
				success: function(json) {
					var html = "<option selected = 'selected'  value=''>--请选择计费方式--</option>";
					var i = 0;
					$.each(json, function(key, value) {
						if(i==0){
							html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
						};
						i++;
					});
					$("#n_rateType").html(html);
				}
			});
	  })
		
		function show_number_rate() {
			$("#n_save_button").show();
			$("#n_cancel_button").show();
			
			
			$("#n_save_button").linkbutton('enable');
			$('#txnNumRateForm :input').val('');
			$('#n_notes').val('');
// 			$('#txnRateForm').clearForm();
			$("#txnNumRateForm").attr("action", "fee/saveCommonRate");
			$('#win_common_rate_add').window({
				title: '按笔收费扣率',
				top: 150,
		  		left: 150,
		  		width: panelWidth,
		  		height: 270,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: true,
				closed: false
			});
			//showFee();
		}
		function saveNumTxnRate() {
			if ($('#txnNumRateForm').form("validate")) {
				$("#n_save_button").linkbutton('disable');
				$('#txnNumRateForm').form('submit', {
					onSubmit: function() {
						return $('#txnNumRateForm').form('validate');
					},
					success: function(data) {
						if(data.split("validateUserLoginAction").length>1){
							window.parent.location.replace("<%=basePath%>"+"pages/logoutAction.action?relogin=relogin");
							return ;
						}
						if (data == '添加成功!') {
							closeNumRate();
							searchNumRate();
						} else {
							$.messager.alert('提示',data);
							$("#save_button").linkbutton('enable');
							closeNumRate();
						}
					}
				});
			}
		}
		
		function closeNumRate() {
			$('#win_common_rate_add').window('close');
		}
		function searchNumRate() {
			var data = {
				'rateId': $('#rateId').val(),
				'rateDes':$('#rateDes').val(),
				"rateType":"01"
			};
			$('#charge_mode_common_grid').datagrid('load', data);
		}
		
		function showNumRateDetail() {
			var ratatype = $("#n_rateType").val();
			if (ratatype == '01') {
				$("#n_feeRate").attr("readonly", "readonly");
				$("#n_feeRate").val("0");
				$("#n_maxFee").attr("readonly", "readonly");
				$("#n_maxFee").val("0");
				$("#n_minFee").removeAttr("readonly");
				$("#n_minFee").val("");
			} else if (ratatype == '02') {
				$("#n_feeRate").removeAttr("readonly");
				$("#n_feeRate").val("");
				$("#n_maxFee").attr("readonly", "readonly");
				$("#n_maxFee").val("0");
				$("#n_minFee").attr("readonly", "readonly");
				$("#n_minFee").val("0");
			} else if (ratatype == '03') {
				$("#n_feeRate").removeAttr("readonly");
				$("#n_feeRate").val("");
				$("#n_maxFee").removeAttr("readonly");
				$("#n_maxFee").val("");
				$("#n_minFee").removeAttr("readonly");
				$("#n_minFee").val("");
			}
		}
		function resize(){
			$('#theForm :input').val('');
		}
		
		function closeCommonRateWindow(){
			$('#win_common_rate').window('close');
		}
	</script>
</html>
