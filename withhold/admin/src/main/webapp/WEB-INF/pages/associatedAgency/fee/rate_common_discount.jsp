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

<div id="win_common_rate_discount" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
	<div class="easyui-layout" fit="true">
		<div region="center" border="false" style="border: 1px solid #ccc; background: #fff; border: 1px solid #ccc; text-align: center">
			<form id="theForm_discount" action="agency/upload" method="post" enctype="multipart/form-data">
				<table id="charge_mode_common_discount_grid"></table>
			</form>
		</div>
		<div region="south" border="false" style="text-align: center; padding: 5px 0;">
			<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveDiscountRate()">确定</a> 
			<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:closeDiscountWindow()">取消</a>
		</div>
	</div>
</div>
<div id="win_discount" class="easyui-window" closed="true" title="My Window"
	iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
	<div class="easyui-layout" fit="true">
		<div region="center" border="false"
			style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
			<form id="txnRateForm_discount" action="fee/saveTxnRate" method="post">
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
							<td class="update"><select id="d_rateType" class="easyui-validatebox" required="true" name="rateType"
								onchange="showDisRateDetail()" missingMessage="请选择计费方式">
							</select></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="d_feeRate" name="feeRate" validType="percent" required="true" type="text"
								class="easyui-validatebox" maxlength="5" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="d_minFee" name="minFee" maxlength="12" validType="amount" required="true"
							 type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="d_maxFee" name="maxFee" required="true" maxlength="12" validType="amount" 
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
			<a class="easyui-linkbutton" id="d_save_button" iconCls="icon-ok"
				href="javascript:saveDisTxnRate()" onclick="">保存</a> <a
				class="easyui-linkbutton" id="d_cancel_button" iconCls="icon-cancel"
				href="javascript:void(0)" onclick="closeAdd()">取消</a>
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
	 
	   $(function() {
			$.ajax({
				type: "POST",
				url: "fee/queryRateType",
				dataType: "json",
				success: function(json) {
					var html = "<option selected = 'selected'  value=''>--请选择计费方式--</option>";
					var i = 0;
					$.each(json,
					function(key, value) {
						if(i>0){
							html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
						}
						i++;
					});
					$("#d_rateType").html(html);
				}
			});
		}); 
	  function showDiscountChargeMode(){
			$('#win_common_rate_discount').window({
				top:100,
				left:280,
				title: "配置计费方式",
				width: 830,
				modal: true,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				shadow: false,
				closed: false,
				height: 500
			});
			
			
			$('#charge_mode_common_discount_grid').datagrid({
				height: 400,
				singleSelect: true,
				nowrap: false,
				striped: true,
				url: 'fee/queryCommonRate',
				queryParams:{"rateType":"99"},
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
				 {
					field: 'FEE_RATE',
					title: '扣率(百分比)',
					width: 100,
					align: 'center'
				}, 
				{
					field: 'MIN_FEE',
					title: '最低额(元)',
					width: 100,
					align: 'center'
				},
				 {
					field: 'MAX_FEE',
					title: '最高额(元)',
					width: 100,
					align: 'center'
				}
				
				]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增按扣率收费',
					iconCls: 'icon-add',
					handler: function() {
						showDisRateAdd(false);
					}
				}]
			});
			var p = $('#charge_mode_common_discount_grid').datagrid('getPager');
			//$(".datagrid-header-check input").hide();
		}
	  
		
		function showDisRateAdd(isToModify) {
			$("#d_save_button").show();
			$("#d_cancel_button").show();
			
			$("#d_save_button").linkbutton('enable');
			$('#txnRateForm_discount :input').val('');
			$('#notes').val('');
// 			$('#txnRateForm').clearForm();
			$("#txnRateForm_discount").attr("action", "fee/saveCommonRate");
			$('#win_discount').window({
				title: '按扣率收费',
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
		function saveDisTxnRate() {
			if ($('#txnRateForm_discount').form("validate")) {
				$("#d_save_button").linkbutton('disable');
				$('#txnRateForm_discount').form('submit', {
					onSubmit: function() {
						
						return $('#txnRateForm_discount').form('validate');
					},
					success: function(data) {
						if(data.split("validateUserLoginAction").length>1){
							window.parent.location.replace("<%=basePath%>"+"pages/logoutAction.action?relogin=relogin");
							return ;
						}
						if (data == '添加成功!') {
							closeDisRate();
							searchDisRate();
						}  else {
							$.messager.alert('提示', data);
							$("#d_save_button").linkbutton('enable');
						}
					}
				});
			}
		}
		
		function closeDisRate() {
			$('#win_discount').window('close');
		}
		function searchDisRate() {
			var data = {
				'rateId': $('#rateId').val(),
				'rateDes': $("#rateDes").val(),
				"rateType":"99"
			};
			$('#charge_mode_common_discount_grid').datagrid('load', data);
		}
		function showTxnRateDetail(tid) {
			showAdd();
			$.ajax({
				type: "POST",
				url: "fee/queryOneCommonRate?caseid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#feeRate").val(json.FEE_RATE);
					$("#rateId-form").val(json.RATE_ID);
					$("#rateDes-form").val(json.RATE_DESC);
					$("#rateType").val(json.RATE_TYPE);
					$("#minFee").val(json.MIN_FEE);
					$("#maxFee").val(json.MAX_FEE);
					$("#notes").val(json.NOTES);
					setTimeout(function() {
						$("#busicase").val(json.BUSICODE);
						$("#busipack").val(json.FEEVER);
					},
					500);
				}
			});
			$("#txnRateForm_discount").attr("action", "fee/updateBusiRate");
			$("#save_button").hide();
			$("#cancel_button").hide();
		}
	
		function showDisRateDetail() {
			var ratatype = $("#rateType").val();
			if (ratatype == '01') {
				$("#d_feeRate").attr("readonly", "readonly");
				$("#d_feeRate").val("0");
				$("#d_maxFee").attr("readonly", "readonly");
				$("#d_maxFee").val("0");
				$("#d_minFee").removeAttr("readonly");
				$("#d_minFee").val("");
			} else if (ratatype == '02') {
				$("#d_feeRate").removeAttr("readonly");
				$("#d_feeRate").val("");
				$("#d_maxFee").attr("readonly", "readonly");
				$("#d_maxFee").val("0");
				$("#d_minFee").removeAttr("readonly");
				$("#d_minFee").val("");
			} else if (ratatype == '03') {
				$("#d_feeRate").removeAttr("readonly");
				$("#d_feeRate").val("");
				$("#d_maxFee").removeAttr("readonly");
				$("#d_maxFee").val("");
				$("#d_minFee").removeAttr("readonly");
				$("#d_minFee").val("");
			}
		}
		function resize(){
			$('#theForm_discount :input').val('');
		}
		
		function closeDiscountWindow(){
			$('#win_common_rate_discount').window('close');
		}
	</script>
</html>
