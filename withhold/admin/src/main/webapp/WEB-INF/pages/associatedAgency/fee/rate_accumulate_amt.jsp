<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>




<style type="text/css">
#w1 table tr td {
	height: 25px
}

#w1 table tr td input {
	height: 15px
}

#w1 table tr td select {
	height: 20px
}
#w1 table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
#w1 table tr td.add {
	height: 25px;
}
#w1 table tr td.update {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
</style>
<script type="text/javascript" src="js/extendsValidator_1.0_20151215.js"></script>
<div id="multilevel_charge_mode_win" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
	<div class="easyui-layout" fit="true">
		<div region="center" border="false" style="border: 1px solid #ccc; background: #fff; border: 1px solid #ccc; text-align: center">
			<form id="theForm" action="agency/upload" method="post" enctype="multipart/form-data">
				<table id="multilevel_charge_mode_grid"></table>
			</form>
		</div>
		<div region="south" border="false" style="text-align: center; padding: 5px 0;">
			<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveMultilevelAmtRate()" id="btn_upload">确定</a> 
			<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:closeMultilevelAmtRateWindow()">取消</a>
		</div>
	</div>
</div>
<div id="multilevel_charge_mode_add_win" class="easyui-window" closed="true" title="My Window"
	iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
	<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="addAmtForm" action="" method="post">
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
						<tr>
							<td colspan="4" class="head-title update">交易金额累计分段扣率<input type="hidden" id="tid" name="tid"/></td>
						</tr>
						<tr>
							<td class="update" width="15%">扣率代码</td>
							<td class="update" colspan="3"><input id="rateId_a" name="rateId" maxlength="10" class="easyui-validatebox" required="true" missingMessage="请输入扣率代码" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">扣率描述</td>
							<td class="update" width="30%"><input id="rateDes_a" name="rateDes" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入扣率描述" /></td>
							<td class="update" width="15%">累计方式</td>
							<td class="update"><select id="accMode_a" name="accMode" class="easyui-validatebox" required="true" missingMessage="请选择累计方式" />
								<option value="" selected="selected">--请选择累计方式--</option>
								<option value="0">日</option>
								<option value="1">月</option>
								<option value="2">年</option> </select></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title update">段1<input type="hidden" id="tid_a1" name="tid1"/></td>
						</tr>
						<tr>
							<td class="update" width="15%">金额范围(元)</td>
							<td class="update" colspan="3">
								<input id="startRange_a1" name="startRange1" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入起始金额" /> 
								~ 
								<input id="endRange_a1" name="endRange1" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入截止金额" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">计费方式</td>
							<td class="update" width="30%"><select id="rateType_a1" name="rateType1" class="easyui-validatebox" required="true" onchange="changeRateType(1)" missingMessage="请选择计费方式">
									<option value="" selected="selected">--请选择计费方式--</option>
									<option value="1">固定金额</option>
									<option value="2">固定比例</option>
									<option value="3">固定比例+限额</option>
							</select></td>
							<td class="update" width="15%">费率（百分比）</td>
							<td class="update"><input id="feeRate_a1" name="feeRate1" validType="percent" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">最低收费额(元)</td>
							<td class="update" width="30%"><input id="minFee_a1" name="minFee1" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额" /></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFee_a1" name="maxFee1" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额" /></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title update">段2<input type="hidden" id="tid_a2" name="tid2"/></td>
						</tr>
						<tr>
							<td class="update" width="15%">金额范围(元)</td>
							<td class="update" colspan="3">
								<input id="startRange_a2" name="startRange2" readOnly="true" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="自动与段1的截止金额同步" />
								 ~ 
								<input id="endRange_a2" name="endRange2" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入截止金额" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">计费方式</td>
							<td class="update" width="30%"><select id="rateType_a2" name="rateType2" class="easyui-validatebox" required="true" onchange="changeRateType(2)" missingMessage="请选择计费方式">
									<option value="" selected="selected">--请选择计费方式--</option>
									<option value="1">固定金额</option>
									<option value="2">固定比例</option>
									<option value="3">固定比例+限额</option>
							</select></td>
							<td class="update" width="15%">费率（百分比）</td>
							<td class="update"><input id="feeRate_a2" name="feeRate2" validType="percent" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">最低收费额(元)</td>
							<td class="update" width="30%"><input id="minFee_a2" name="minFee2" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额" /></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update" width="30%"><input id="maxFee_a2" name="maxFee2" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额" /></td>
						</tr>
						<tr>
							<td colspan="6" class="head-title update">段3<input type="hidden" id="tid_a3" name="tid3"/></td>
						</tr>
						<tr>
							<td class="update" width="15%">金额范围(元)</td>
							<td class="update" colspan="3">
								<input id="startRange_a3" name="startRange3" readOnly="true" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="自动与段2的截止金额同步" />
								 ~ 
								<input id="endRange_a3" name="endRange3" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入截止金额" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">计费方式</td>
							<td class="update" width="30%"><select id="rateType_a3" name="rateType3" class="easyui-validatebox" required="true" onchange="changeRateType(3)" missingMessage="请选择计费方式">
									<option value="" selected="selected">--请选择计费方式--</option>
									<option value="1">固定金额</option>
									<option value="2">固定比例</option>
									<option value="3">固定比例+限额</option>
							</select></td>
							<td class="update" width="15%">费率（百分比）</td>
							<td class="update"><input id="feeRate_a3" name="feeRate3" validType="percent" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">最低收费额(元)</td>
							<td class="update" width="30%"><input id="minFee_a3" name="minFee3" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额" /></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFee_a3" name="maxFee3" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额" /></td>
						</tr>
						<tr>
							<td class="update">备注</td>
							<td class="update" colspan="3"><textarea id="notes_a" rows="3" cols="75"
									name="notes" maxlength="32"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" id="save_button_a" iconCls="icon-ok" href="javascript:addAmtAccumRate()" onclick="">保存</a> 
				<a class="easyui-linkbutton" id="cancel_button_a" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAmtAdd()">取消</a>
			</div>
		</div>
		<!-- 详情页面 -->
	<div id="wdetail" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 500px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="detailForm" action="" method="post">
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
						<tr>
							<td colspan="4" class="head-title update">交易金额累计分段扣率</td>
						</tr>
						<tr>
							<td class="update" width="15%">扣率代码</td>
							<td class="update" id="rateId_d" colspan="3"></td>
						</tr>
						<tr>
							<td class="update" width="15%">扣率描述</td>
							<td class="update" width="30%" id="rateDes_d"></td>
							<td class="update" width="15%">累计方式</td>
							<td class="update" id="accMode_d"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title update">段1</td>
						</tr>
						<tr>
							<td class="update" width="15%">金额范围(元)</td>
							<td class="update" id="range_d1" colspan="3"></td>
						</tr>
						<tr>
							<td class="update" width="15%">计费方式</td>
							<td class="update" width="30%" id="rateType_d1"></td>
							<td class="update" width="15%">费率（百分比）</td>
							<td class="update" id="feeRate_d1"></td>
						</tr>
						<tr>
							<td class="update" width="15%">最低收费额(元)</td>
							<td class="update" width="30%" id="minFee_d1"></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update" id="maxFee_d1"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title update">段2</td>
						</tr>
						<tr>
							<td class="update" width="15%">金额范围(元)</td>
							<td class="update" id="range_d2" colspan="3"></td>
						</tr>
						<tr>
							<td class="update" width="15%">计费方式</td>
							<td class="update" width="30%" id="rateType_d2"></td>
							<td class="update" width="15%">费率（百分比）</td>
							<td class="update" id="feeRate_d2"></td>
						</tr>
						<tr>
							<td class="update" width="15%">最低收费额(元)</td>
							<td class="update" width="30%" id="minFee_d2"></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update" id="maxFee_d2"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title update">段3</td>
						</tr>
						<tr>
							<td class="update" width="15%">金额范围(元)</td>
							<td class="update" id="range_d3" colspan="3"></td>
						</tr>
						<tr>
							<td class="update" width="15%">计费方式</td>
							<td class="update" width="30%" id="rateType_d3"></td>
							<td class="update" width="15%">费率（百分比）</td>
							<td class="update" id="feeRate_d3"></td>
						</tr>
						<tr>
							<td class="update" width="15%">最低收费额(元)</td>
							<td class="update" width="30%" id="minFee_d3"></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update" id="maxFee_d3"></td>
						</tr>
						<tr height="50px">
							<td class="update">备注</td>
							<td class="update" colspan="3" id="notes_d"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				 <a class="easyui-linkbutton" iconCls="icon-back"
					href="javascript:void(0)" onclick="closeDetail()">返回</a>
			</div>
		</div>
	</div>
		
</div>

<script>
	  var width = $("#continer").width();
	  var gridHeight = 600;
	  var panelWidth = 800;
	  var panelHeight = 470;
	  var panelHoriFloat = (width-panelWidth)/2;
	  var panelVertFloat = 150;
	  var width = $("#continer").width();
	  
	  
	  $(function(){
			$("#endRange_a1").attrchange({
			    trackValues: !0, 
			    callback: function() {
			    	$("#startRange_a2").val($("#endRange_a1").val());
			    }
			});
			$("#endRange_a2").attrchange({
			    trackValues: !0, 
			    callback: function() {
			    	$("#startRange_a3").val($("#endRange_a2").val());
			    }
			});
		});
	  function closeDetail() {
			$('#wdetail').window('close');
		}
		$(function() {
			$.ajax({
				type: "POST",
				url: "fee/queryRateType",
				dataType: "json",
				success: function(json) {
					var html = "<option  Seleted ='Seleted' value=''>--请选择扣计费类型--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
					});
					$("#rateType").html(html);
				}
			});
		});
		
		function showMultilevelChargeMode() {
			$('#multilevel_charge_mode_win').window({
				top:100,
				left:100,
				title: "配置计费方式",
				width: 700,
				modal: true,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				shadow: false,
				closed: false,
				height: 500
			});
			$('#multilevel_charge_mode_grid').datagrid({
				height: 400,
				singleSelect: true,
				nowrap: false,
				striped: true,
				url: 'fee/queryMultilevelRate?accobj=amt',
				remoteSort: false,
				columns:          
					[[{
						
						align: 'center',
						checkbox:true
					},
				{
					field: 'RATE_ID',
					title: '扣率代码',
					width: 80,
					align: 'center'
				},
				{
					field: 'RATE_DESC',
					title: '扣率描述',
					width: 120,
					align: 'center'
				},
				{
					field: 'ACCMODE',title: '累计方式', width: 100,align: 'center',
						formatter : function(value, rec) {
							if (value == 0) {
								return '日';
							} else if (value == 1) {
								return '月';
							} else if(value == 2){
								return '年';
							}
						}
				},
				{
					field: 'ACCOBJ',
					title: '累计对象',
					width: 150,
					align: 'center',
					formatter : function(value, rec) {
						if (value == "amt") {
							return '交易金额';
						} else if (value == "num") {
							return '交易笔数';
						} 
					}
				},
				{
					field: 'TID',
					title: '操作',
					width: 100,
					align: 'center',
					formatter: function(value, rec) {
						return '<a href="javascript:showDetail(\''
						+ rec.RATE_ID
						+ '\', \''
						+ rec.RATE_DESC
						+ '\', \''
						+ rec.ACCMODE
						+ '\', \''
						+ rec.NOTES
						+ '\')" style="color:blue;margin-left:10px">详情</a>';
					}
				}
				
				
				
			]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增分段累计扣率（金额）',
					iconCls: 'icon-add',
					handler: function() {
						//searchAccAmt();
						showAmtAdd(false);
					}
				}]
			});
			var p = $('#multilevel_charge_mode_win').datagrid('getPager');
		}
		
		
		function closeMultilevelAmtRateWindow(){
			$('#multilevel_charge_mode_win').window("close");
		}
		
		function getMultilevelAmtRateDeta(tid){
			$.ajax({
				type: "POST",
				url: "fee/queryMultilevelRateDeta?tid=" + tid,
				dataType: "json",
				success: function(json) {
					
				}
			});
		}
		
		
		function showAmtAdd(isToModify) {
			$("#save_button").show();
			$("#cancel_button").show();
			if(!isToModify){
				$("#busipack").removeAttr("disabled");
				$("#busicase").removeAttr("disabled");
			}else{
				$("#busipack").attr("disabled","disabled");
				$("#busicase").attr("disabled","disabled");
			}
			$("#save_button").linkbutton('enable');
			$("#cancel_button").linkbutton('enable');
			$('#addAmtForm :input').val('');
			$('#notes').val('');
			$("#addAmtForm").attr("action", "fee/saveAmtAccumRate");
			$('#multilevel_charge_mode_add_win').window({
				title: '分段累计扣率（金额）',
				top: 150,
		  		left: 150,
		  		width: panelWidth,
		  		height: 550,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: true,
				closed: false,
			});
		}
		//保存 
		function saveAccumulateRate() {
			   var ratatype = $("#rateType").val();
		       var minfee =$("#minfee").val();
		       var maxfee = $("#maxfee").val();
		       var minfee2 = $("#minfee2").val();
		       var maxfee2 = $("#maxfee2").val();
		       var minfee3 = $("#minfee3").val();
		       var maxfee3 = $("#maxfee3").val();
		       var minfee_min = parseFloat(minfee);
		       var maxfee_max = parseFloat(maxfee);
		       var minfee2_min = parseFloat(minfee2);
		       var maxfee2_max = parseFloat(maxfee2);
		       var minfee3_min = parseFloat(minfee3);
		       var maxfee3_max = parseFloat(maxfee3);
		       if(ratatype=="03" && ((minfee_min >maxfee_max) || (minfee2_min >maxfee2_max) || (minfee3_min>maxfee3_max))){
		    	   alert("最低收费额不能大于最高收费额");
		       }else if($("#rateType").val() == null || $("#rateType").val() == ""){
		    	   alert("请选择计费方式");
		       } else{
					if ($('#accumulateRateForm').form("validate")) {
						$("#save_button").linkbutton('disable');
						$('#accumulateRateForm').form('submit', {
							onSubmit: function() {
								$("#busipack").removeAttr("disabled");
								$("#busicase").removeAttr("disabled");
								return $('#accumulateRateForm').form('validate');
							},
							success: function(data) {
								if (data == '添加成功!') {
									
									closeAmtAdd();
									searchAccAmt();
								} else if (data == '修改成功!') {
									alert(data);
									closeAmtAdd();
									searchAccAmt();
								} else {
									
									$("#save_button").linkbutton('enable');
								}
			
							}
						});
					}  
		       }
		}
		
		function closeAmtAdd() {
			$('#multilevel_charge_mode_add_win').window("close");
		}
		function searchAccAmt() {
			var data = {
				'rateId': $('#rateId').val(),
				'rateDes':$('#rateDes').val()
			};
			$('#multilevel_charge_mode_grid').datagrid('load', data);
		}
		function showRateDetail() {
			var ratatype = $("#rateType").val();
			if (ratatype == '01') {
				$("#feerate").attr("readonly", "readonly");
				$("#feerate").val("0");
				$("#maxfee").attr("readonly", "readonly");
				$("#maxfee").val("0");
				$("#minfee").removeAttr("readonly");
				$("#minfee").val("");
				
				$("#feerate2").attr("readonly", "readonly");
				$("#feerate2").val("0");
				$("#maxfee2").attr("readonly", "readonly");
				$("#maxfee2").val("0");
				$("#minfee2").removeAttr("readonly");
				$("#minfee2").val("");
				
				$("#feerate3").attr("readonly", "readonly");
				$("#feerate3").val("0");
				$("#maxfee3").attr("readonly", "readonly");
				$("#maxfee3").val("0");
				$("#minfee3").removeAttr("readonly");
				$("#minfee3").val("");
			} else if (ratatype == '02') {
				$("#feerate").removeAttr("readonly");
				$("#feerate").val("");
				$("#maxfee").attr("readonly", "readonly");
				$("#maxfee").val("0");
				$("#minfee").attr("readonly", "readonly");
				$("#minfee").val("0");
				
				$("#feerate2").removeAttr("readonly");
				$("#feerate2").val("");
				$("#maxfee2").attr("readonly", "readonly");
				$("#maxfee2").val("0");
				$("#minfee2").attr("readonly", "readonly");
				$("#minfee2").val("0");
				
				$("#feerate3").removeAttr("readonly");
				$("#feerate3").val("");
				$("#maxfee3").attr("readonly", "readonly");
				$("#maxfee3").val("0");
				$("#minfee3").attr("readonly", "readonly");
				$("#minfee3").val("0");
			} else if (ratatype == '03') {
				$("#feerate").removeAttr("readonly");
				$("#feerate").val("");
				$("#maxfee").removeAttr("readonly");
				$("#maxfee").val("");
				$("#minfee").removeAttr("readonly");
				$("#minfee").val("");
				
				$("#feerate2").removeAttr("readonly");
				$("#feerate2").val("");
				$("#maxfee2").removeAttr("readonly");
				$("#maxfee2").val("");
				$("#minfee2").removeAttr("readonly");
				$("#minfee2").val("");
				
				$("#feerate3").removeAttr("readonly");
				$("#feerate3").val("");
				$("#maxfee3").removeAttr("readonly");
				$("#maxfee3").val("");
				$("#minfee3").removeAttr("readonly");
				$("#minfee3").val("");
			}
	
		}
		/* 保存 */ 
		function addAmtAccumRate() {
			for (var i = 1; i <= 3; i++) {
				var rateType = $("#rateType_a" + i).val();
				var startRange = parseFloat($("#startRange_a" + i).val());
				var endRange = parseFloat($("#endRange_a" + i).val());
				var minFee = parseFloat($("#minFee_a" + i).val());
				var maxFee = parseFloat($("#maxFee_a" + i).val());
				if(startRange >= endRange){
					$.messager.alert("","段" + i + "的截止金额要大于起始金额","warning");
					return false;
				}
				if(rateType==3 && (minFee > maxFee)){
					$.messager.alert("","段" + i + "的最低收费额不能大于最高收费额","warning");
					return false;
				}
			}
			
			$('#addAmtForm').form('submit', {
				onSubmit : function() {
					return $('#addAmtForm').form('validate');
				},
				success : function(data) {
					data=JSON.parse(data);
					if (typeof(data.RET) == "undefined")
					{
						$.messager.alert("","服务异常！","info");
						if (!isAdd) {
							var rateId = $("#rateId_a").val();
							$.ajax({
								type : "POST",
								url : "fee/queryAccumRateDeta?rateId=" + rateId,
								async : false,
								dataType : "json",
								success : function(json) {
									var rows = json.rows;
									for (var i = 1; i <= rows.length; i++) {
										var row = rows[i - 1];
										$("#tid_a" + i).val(row.TID);
									}
								}
							});
						}
					} else if (data.RET == 'succ') {
						$.messager.alert("",data.INFO,"info");
						closeAmtAdd();
						searchAccAmt();
					} else {
						$.messager.alert("",data.INFO,"info");
						if (!isAdd) {
							var rateId = $("#rateId_a").val();
							$.ajax({
								type : "POST",
								url : "fee/queryAccumRateDeta?rateId=" + rateId,
								async : false,
								dataType : "json",
								success : function(json) {
									var rows = json.rows;
									for (var i = 1; i <= rows.length; i++) {
										var row = rows[i - 1];
										$("#tid_a" + i).val(row.TID);
									}
								}
							});
						}
					}
				}
			});
		}
		/* 显示详情 */
	function showDetail(rateId, rateDesc, accMode, notes) {
		$('#wdetail').window({
			title : '交易金额累计分段扣率详情',
			top : 150,
			left : 150,
			width : panelWidth,
			height : 550,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : true,
			shadow : true,
			closed : false,
		});

		$.ajax({
			type : "POST",
			url : "fee/queryAccumRateDeta?rateId=" + rateId,
			dataType : "json",
			success : function(json) {
				$("#rateId_d").html(rateId);
				$("#rateDes_d").html(rateDesc);
				$("#accMode_d").html(
						accMode == 0 ? '日' : (accMode == 1 ? '月'
								: (accMode == 2 ? '年' : '')));
				notes=="null"?$("#notes_d").html(""):$("#notes_d").html(notes);
				var rows = json.rows;
				for (var i = 1; i <= rows.length; i++) {
					var row = rows[i - 1];
					$("#rateType_d" + i)
							.html(
									row.RATE_TYPE == 1 ? '固定金额'
											: (row.RATE_TYPE == 2 ? '固定比例'
													: (row.RATE_TYPE == 3 ? '固定比例+限额'
															: '')));
					$("#range_d" + i).html(
							row.STARTRANGE/100 + "~" + row.ENDRANGE/100);
					$("#feeRate_d" + i).html(row.FEE_RATE);
					$("#minFee_d" + i).html(row.MIN_FEE);
					$("#maxFee_d" + i).html(row.MAX_FEE);
				}
			}
		});
	}
		function resize(){
			$('#theForm :input').val('');
		}
		function fenToYuan(value){
			var str = (value).toFixed(2) + '';
			var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
			var dot = str.substring(str.length,str.indexOf("."))
			var ret = intSum + dot;
			return ret;
		}
		function changeRateType(index){
			var rateType = $("#rateType_a"+index).val();
			if (rateType == 1) {
				// 固定金额，此时费率及最高收费额置为0
				//alert(index+"-1");
				$("#feeRate_a" + index).val("0");
				$("#feeRate_a" + index).attr("readonly", true);
				$("#minFee_a" + index).val("");
				$("#minFee_a" + index).attr("readonly", false);
				$("#maxFee_a" + index).val("0");
				$("#maxFee_a" + index).attr("readonly", true);
			} else if (rateType == 2) {
				// 固定比例，此时最低收费额及最高收费额置为0
				//alert(index+"-2");
				$("#feeRate_a" + index).val("");
				$("#feeRate_a" + index).attr("readonly", false);
				$("#minFee_a" + index).val("0");
				$("#minFee_a" + index).attr("readonly", true);
				$("#maxFee_a" + index).val("0");
				$("#maxFee_a" + index).attr("readonly", true);
			} else if (rateType == 3) {
				// 固定比例+限额
				//alert(index+"-3");
				$("#feeRate_a" + index).val("");
				$("#feeRate_a" + index).attr("readonly", false);
				$("#minFee_a" + index).val("");
				$("#minFee_a" + index).attr("readonly", false);
				$("#maxFee_a" + index).val("");
				$("#maxFee_a" + index).attr("readonly", false);
			}
		}
		
		function toDefault(){
			for (var i = 1; i <=3; i++) {
				$("#feeRate_a" + i).attr("readonly", false);
				$("#minFee_a" + i).attr("readonly", false);
				$("#maxFee_a" + i).attr("readonly", false);
			}
		}
	</script>
</html>
