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
<div id="multilevel_charge_mode_num_win" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
	<div class="easyui-layout" fit="true">
		<div region="center" border="false" style="border: 1px solid #ccc; background: #fff; border: 1px solid #ccc; text-align: center">
			<form id="theForm" action="agency/upload" method="post" enctype="multipart/form-data">
				<table id="multilevel_charge_mode_num_grid"></table>
			</form>
		</div>
		<div region="south" border="false" style="text-align: center; padding: 5px 0;">
			<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveMultilevelNumRate()" id="btn_upload">确定</a> 
			<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:closeMultilevelNumRateWindow()">取消</a>
		</div>
	</div>
</div>
<div id="multilevel_charge_mode_num_bdd_win" class="easyui-window" closed="true" title="My Window"
	iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
	<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="addNumForm" action="" method="post">
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
						<tr>
							<td colspan="4" class="head-title update">交易笔数累计分段扣率<input type="hidden" id="tid" name="tid"/></td>
						</tr>
						<tr>
							<td class="update" width="15%">扣率代码</td>
							<td class="update" colspan="3"><input id="rateId_b" name="rateId" maxlength="10" class="easyui-validatebox" required="true" missingMessage="请输入扣率代码" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">扣率描述</td>
							<td class="update" width="30%"><input id="rateDes_b" name="rateDes" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入扣率描述" /></td>
							<td class="update" width="15%">累计方式</td>
							<td class="update"><select id="accMode_b" name="accMode" class="easyui-validatebox" required="true" missingMessage="请选择累计方式" />
								<option value="" selected="selected">--请选择累计方式--</option>
								<option value="0">日</option>
								<option value="1">月</option>
								<option value="2">年</option> </select></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title update">段1<input type="hidden" id="tid_b1" name="tid1"/></td>
						</tr>
						<tr>
							<td class="update" width="15%">笔数范围</td>
							<td class="update" colspan="3">
								<input id="startRange_b1" name="startRange1" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入起始笔数" /> 
								~ 
								<input id="endRange_b1" name="endRange1" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入截止笔数" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">计费方式</td>
							<td class="update" width="30%"><select id="rateType_b1" name="rateType1" class="easyui-validatebox" required="true" onchange="changeNumRateType(1)" missingMessage="请选择计费方式">
									<option value="" selected="selected">--请选择计费方式--</option>
									<option value="1">固定金额</option>
									<option value="2">固定比例</option>
									<option value="3">固定比例+限额</option>
							</select></td>
							<td class="update" width="15%">费率（百分比）</td>
							<td class="update"><input id="feeRate_b1" name="feeRate1" validType="percent" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">最低收费额(元)</td>
							<td class="update" width="30%"><input id="minFee_b1" name="minFee1" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额" /></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFee_b1" name="maxFee1" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额" /></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title update">段2<input type="hidden" id="tid_b2" name="tid2"/></td>
						</tr>
						<tr>
							<td class="update" width="15%">笔数范围</td>
							<td class="update" colspan="3">
								<input id="startRange_b2" name="startRange2" readOnly="true" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="自动与段1的截止笔数同步" />
								 ~ 
								<input id="endRange_b2" name="endRange2" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入截止笔数" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">计费方式</td>
							<td class="update" width="30%"><select id="rateType_b2" name="rateType2" class="easyui-validatebox" required="true" onchange="changeNumRateType(2)" missingMessage="请选择计费方式">
									<option value="" selected="selected">--请选择计费方式--</option>
									<option value="1">固定金额</option>
									<option value="2">固定比例</option>
									<option value="3">固定比例+限额</option>
							</select></td>
							<td class="update" width="15%">费率（百分比）</td>
							<td class="update"><input id="feeRate_b2" name="feeRate2" validType="percent" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">最低收费额(元)</td>
							<td class="update" width="30%"><input id="minFee_b2" name="minFee2" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额" /></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update" width="30%"><input id="maxFee_b2" name="maxFee2" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额" /></td>
						</tr>
						<tr>
							<td colspan="6" class="head-title update">段3<input type="hidden" id="tid_b3" name="tid3"/></td>
						</tr>
						<tr>
							<td class="update" width="15%">笔数范围</td>
							<td class="update" colspan="3">
								<input id="startRange_b3" name="startRange3" readOnly="true" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="自动与段2的截止笔数同步" />
								 ~ 
								<input id="endRange_b3" name="endRange3" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入截止笔数" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">计费方式</td>
							<td class="update" width="30%"><select id="rateType_b3" name="rateType3" class="easyui-validatebox" required="true" onchange="changeNumRateType(3)" missingMessage="请选择计费方式">
									<option value="" selected="selected">--请选择计费方式--</option>
									<option value="1">固定金额</option>
									<option value="2">固定比例</option>
									<option value="3">固定比例+限额</option>
							</select></td>
							<td class="update" width="15%">费率（百分比）</td>
							<td class="update"><input id="feeRate_b3" name="feeRate3" validType="percent" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" /></td>
						</tr>
						<tr>
							<td class="update" width="15%">最低收费额(元)</td>
							<td class="update" width="30%"><input id="minFee_b3" name="minFee3" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额" /></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFee_b3" name="maxFee3" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额" /></td>
						</tr>
						<tr>
							<td class="update">备注</td>
							<td class="update" colspan="3"><textarea id="notes_b" rows="3" cols="75"
									name="notes" maxlength="32"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" id="save_button_b" iconCls="icon-ok" href="javascript:addNumAccumRate()" onclick="">保存</a> <a class="easyui-linkbutton" id="cancel_button_b" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
</div>
<!-- 详情页面 -->
	<div id="wdetail" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 500px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="detailForm" action="" method="post">
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
						<tr>
							<td colspan="4" class="head-title update">交易笔数累计分段扣率</td>
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
							<td class="update" width="15%">笔数范围</td>
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
							<td class="update" width="15%">笔数范围</td>
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
							<td class="update" width="15%">笔数范围</td>
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

<script>
	  var width = $("#continer").width();
	  var gridHeight = 600;
	  var panelWidth = 800;
	  var panelHeight = 470;
	  var panelHoriFloat = (width-panelWidth)/2;
	  var panelVertFloat = 150;
	  var width = $("#continer").width();
		
	  $(function(){
			$("#endRange_b1").attrchange({
			    trackValues: !0, 
			    callback: function() {
			    	$("#startRange_b2").val($("#endRange_b1").val());
			    }
			});
			$("#endRange_b2").attrchange({
			    trackValues: !0, 
			    callback: function() {
			    	$("#startRange_b3").val($("#endRange_b2").val());
			    }
			});
		});
	  function closeDetail() {
			$('#wdetail').window('close');
		}
		function showMultilevelChargeNumMode() {
			$('#multilevel_charge_mode_num_win').window({
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
			$('#multilevel_charge_mode_num_grid').datagrid({
				height: 400,
				singleSelect: true,
				nowrap: false,
				striped: true,
				url: 'fee/queryMultilevelRate?accobj=num',
				data:[{accobj:"num"}],
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
						return '<a href="javascript:showNumDetail(\''
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
					text: '新增分段累计扣率（笔数）',
					iconCls: 'icon-add',
					handler: function() {
						//searchAccNum();
						showAdd(false);
					}
				}]
			});
			var p = $('#multilevel_charge_mode_num_win').datagrid('getPager');
		}
		
		
		function closeMultilevelNumRateWindow(){
			$('#multilevel_charge_mode_num_win').window("close");
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
		
		
		function showAdd(isToModify) {
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
			$('#accumulateRateForm :input').val('');
			$('#notes').val('');
			$("#addNumForm").attr("action", "fee/saveNumAccumRate");
			$('#multilevel_charge_mode_num_bdd_win').window({
				title: '分段累计扣率（笔数）',
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
									
									closeAdd();
									searchAccNum();
								} else if (data == '修改成功!') {
									alert(data);
									closeAdd();
									searchAccNum();
								} else {
									
									$("#save_button").linkbutton('enable');
								}
			
							}
						});
					}  
		       }
		}
		
		function closeAdd() {
			$('#multilevel_charge_mode_num_bdd_win').window("close");
		}
		function searchAccNum() {
			var data = {
				'rateId': $('#rateId').val(),
				'rateDes':$('#rateDes').val()
				
			};
			$('#multilevel_charge_mode_num_grid').datagrid('load', data);
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
		/* 详情 */
		function showAccumulateRateDetail(tid) {
			showAdd(true);
			$.ajax({
				type: "POST",
				url: "fee/queryOneAccumulateRate?caseid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#rateId_form").val(json.RATE_ID);
					$("#rateDes_form").val(json.RATE_DESC);
					$("#rateType").val(json.RATE_TYPE);
					$("#accmode").val(json.ACCMODE);
					$("#feerate").val(json.FEE_RATE);	
					
					$("#minfee").val(json.MIN_FEE);
					$("#maxfee").val(json.MAX_FEE);
					
					$("#limit1").val(fenToYuan(json.LIMIT1));
					$("#feerate2").val(json.FEE_RATE2);
					$("#minfee2").val(json.MIN_FEE2);
					$("#maxfee2").val(json.MAX_FEE2);
					
					$("#limit2").val(fenToYuan(json.LIMIT2fenToYuan));
					$("#feerate3").val(json.FEE_RATE3);
					$("#minfee3").val(json.MIN_FEE3);
					$("#maxfee3").val(json.MAX_FEE3);					
					$("#notes").val(json.NOTES);
				}
			});
			$("#save_button").hide();
			$("#cancel_button").hide();
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
		/* 显示详情 */
		function showNumDetail(rateId, rateDesc, accMode, notes) {
			$('#wdetail').window({
				title : '交易笔数累计分段扣率详情',
				top : panelVertFloat,
				left : panelHoriFloat,
				width : panelWidth,
				height : panelHeight,
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
								row.STARTRANGE + "~" + row.ENDRANGE);
						$("#feeRate_d" + i).html(row.FEE_RATE);
						$("#minFee_d" + i).html(row.MIN_FEE);
						$("#maxFee_d" + i).html(row.MAX_FEE);
					}
				}
			});
		}
		function changeNumRateType(index){
			var rateType = $("#rateType_b"+index).val();
			
			if (rateType == 1) {
				// 固定金额，此时费率及最高收费额置为0
				//alert(index+"-1");
				$("#feeRate_b" + index).val("0");
				$("#feeRate_b" + index).attr("readonly", true);
				$("#minFee_b" + index).val("");
				$("#minFee_b" + index).attr("readonly", false);
				$("#maxFee_b" + index).val("0");
				$("#maxFee_b" + index).attr("readonly", true);
			} else if (rateType == 2) {
				// 固定比例，此时最低收费额及最高收费额置为0
				//alert(index+"-2");
				$("#feeRate_b" + index).val("");
				$("#feeRate_b" + index).attr("readonly", false);
				$("#minFee_b" + index).val("0");
				$("#minFee_b" + index).attr("readonly", true);
				$("#maxFee_b" + index).val("0");
				$("#maxFee_b" + index).attr("readonly", true);
			} else if (rateType == 3) {
				// 固定比例+限额
				//alert(index+"-3");
				$("#feeRate_b" + index).val("");
				$("#feeRate_b" + index).attr("readonly", false);
				$("#minFee_b" + index).val("");
				$("#minFee_b" + index).attr("readonly", false);
				$("#maxFee_b" + index).val("");
				$("#maxFee_b" + index).attr("readonly", false);
			}
		}
		
		function toDefault(){
			for (var i = 1; i <=3; i++) {
				$("#feeRate_b" + i).attr("readonly", false);
				$("#minFee_b" + i).attr("readonly", false);
				$("#maxFee_b" + i).attr("readonly", false);
			}
		}
		function addNumAccumRate() {
			for (var i = 1; i <= 3; i++) {
				var rateType = $("#rateType_b" + i).val();
				var startRange = parseFloat($("#startRange_b" + i).val());
				var endRange = parseFloat($("#endRange_b" + i).val());
				var minFee = parseFloat($("#minFee_b" + i).val());
				var maxFee = parseFloat($("#maxFee_b" + i).val());
				if(startRange >= endRange){
					$.messager.alert("","段" + i + "的截止笔数要大于起始笔数","warning");
					return false;
				}
				if(rateType==3 && (minFee > maxFee)){
					$.messager.alert("","段" + i + "的最低收费额不能大于最高收费额","warning");
					return false;
				}
			}
			
			$('#addNumForm').form('submit', {
				onSubmit : function() {
					return $('#addNumForm').form('validate');
				},
				success : function(data) {
					data=JSON.parse(data);
					if (typeof(data.RET) == "undefined")
					{
						$.messager.alert("","服务异常！","info");
						if (!isAdd) {
							var rateId = $("#rateId_b").val();
							$.ajax({
								type : "POST",
								url : "fee/queryAccumRateDeta?rateId=" + rateId,
								async : false,
								dataType : "json",
								success : function(json) {
									var rows = json.rows;
									for (var i = 1; i <= rows.length; i++) {
										var row = rows[i - 1];
										$("#tid_b" + i).val(row.TID);
									}
								}
							});
						}
					} else if (data.RET == 'succ') {
						$.messager.alert("",data.INFO,"info");
						closeAdd();
						searchAccNum();
					} else {
						$.messager.alert("",data.INFO,"info");
						if (!isAdd) {
							var rateId = $("#rateId_b").val();
							$.ajax({
								type : "POST",
								url : "fee/queryAccumRateDeta?rateId=" + rateId,
								async : false,
								dataType : "json",
								success : function(json) {
									var rows = json.rows;
									for (var i = 1; i <= rows.length; i++) {
										var row = rows[i - 1];
										$("#tid_b" + i).val(row.TID);
									}
								}
							});
						}
					}
				}
			});
		}
	</script>
</html>
