<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<html>
<head>
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
</head>
<body>

	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="查询条件" style="height: 100px; padding: 10px; background: #fafafa;" iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td class="add" align="right" width="15%">扣率代码</td>
						<td class="add" align="left" style="padding-left: 5px" width="25%"><input id="rateId" name="rateId" maxlength="10" /></td>
						<td class="add" align="right" width="15%">扣率描述</td>
						<td class="add" align="left" style="padding-left: 5px" width="25%"><input id="rateDes" name="rateDes" maxlength="64" /></td>
						<td class="add" align="right"><a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> <a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>

	</div>

	<!-- 添加及修改页面 -->
	<div id="wadd" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 500px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="addForm" action="" method="post">
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
						<tr>
							<td colspan="4" class="head-title update">交易笔数累计分段扣率<input type="hidden" id="tid" name="tid"/></td>
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
							<td class="update" width="15%">笔数范围</td>
							<td class="update" colspan="3">
								<input id="startRange_a1" name="startRange1" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入起始笔数" /> 
								~ 
								<input id="endRange_a1" name="endRange1" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入截止笔数" /></td>
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
							<td class="update" width="15%">笔数范围</td>
							<td class="update" colspan="3">
								<input id="startRange_a2" name="startRange2" readOnly="true" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="自动与段1的截止笔数同步" />
								 ~ 
								<input id="endRange_a2" name="endRange2" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入截止笔数" /></td>
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
							<td class="update" width="15%">笔数范围</td>
							<td class="update" colspan="3">
								<input id="startRange_a3" name="startRange3" readOnly="true" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="自动与段2的截止笔数同步" />
								 ~ 
								<input id="endRange_a3" name="endRange3" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入截止笔数" /></td>
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
				<a class="easyui-linkbutton" id="save_button_a" iconCls="icon-ok" href="javascript:addNumAccumRate()" onclick="">保存</a> <a class="easyui-linkbutton" id="cancel_button_a" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
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


</body>

<script>
	var width = $("#continer").width();
	var gridHeight = 600;
	var panelWidth = 800;
	var panelHeight = 542;
	var panelHoriFloat = (width - panelWidth) / 2;
	var panelVertFloat = 150;
	var width = $("#continer").width();
	var isAdd = false;

	/* 段2的起始金额与段1的截止金额保持同步，段3的超始金额与段2的截止金额保持同步 */
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
	 
	$(function() {
		$('#test')
				.datagrid(
						{
							title : '交易笔数累计分段扣率列表',
							iconCls : 'icon-save',
							height : gridHeight,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'fee/queryNumAccumRate',
							remoteSort : false,
							columns : [ [
									{
										field : 'RATE_ID',
										title : '扣率代码',
										width : 160,
										align : 'center',
										rowspan : 1
									},
									{
										field : 'RATE_DESC',
										title : '扣率描述',
										width : 240,
										align : 'center',
										rowspan : 1
									},
									{
										field : 'ACCMODE',
										title : '累计方式',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {
											if (value == 0) {
												return '日';
											} else if (value == 1) {
												return '月';
											} else if (value == 2) {
												return '年';
											}
										}
									},
									{
										field : 'TID',
										title : '操作',
										width : 150,
										align : 'center',
										formatter : function(value, rec) {
											return '<a href="javascript:showModify(\''
													+ rec.RATE_ID
													+ '\', \''
													+ rec.RATE_DESC
													+ '\', \''
													+ rec.ACCMODE
													+ '\', \''
													+ rec.NOTES
													+ '\')" style="color:blue;margin-left:10px">修改</a>'
													+ '&nbsp;&nbsp<a href="javascript:showDetail(\''
													+ rec.RATE_ID
													+ '\', \''
													+ rec.RATE_DESC
													+ '\', \''
													+ rec.ACCMODE
													+ '\', \''
													+ rec.NOTES
													+ '\')" style="color:blue;margin-left:10px">详情</a>';
										}
									} ] ],
							pagination : true,
							rownumbers : true,
							toolbar : [ {
								id : 'btnadd',
								text : '新增交易笔数累计分段扣率',
								iconCls : 'icon-add',
								handler : function() {
									showAdd(false);
								}
							} ]
						});
		var p = $('#test').datagrid('getPager');
	});
	
	/* 弹出添加窗口 */
	function showAdd() {
		isAdd = true;
		$('#addForm :input').val('');
		$("#addForm").attr("action", "fee/saveNumAccumRate");
		$("#rateId_a").attr("readonly", false);
		toDefault();
		$('#wadd').window({
			title : '新增交易笔数累计分段扣率',
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
	}
	
	/* 保存 */ 
	function addNumAccumRate() {
		for (var i = 1; i <= 3; i++) {
			var rateType = $("#rateType_a" + i).val();
			var startRange = parseFloat($("#startRange_a" + i).val());
			var endRange = parseFloat($("#endRange_a" + i).val());
			var minFee = parseFloat($("#minFee_a" + i).val());
			var maxFee = parseFloat($("#maxFee_a" + i).val());
			if(startRange >= endRange){
				$.messager.alert("","段" + i + "的截止笔数要大于起始笔数","warning");
				return false;
			}
			if(rateType==3 && (minFee > maxFee)){
				$.messager.alert("","段" + i + "的最低收费额不能大于最高收费额","warning");
				return false;
			}
		}
		
		$('#addForm').form('submit', {
			onSubmit : function() {
				return $('#addForm').form('validate');
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
					closeAdd();
					search();
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

	/* 显示修改页面 */
	function showModify(rateId, rateDesc, accMode, notes) {
		isAdd = false;
		$('#addForm :input').val('');
		$("#addForm").attr("action", "fee/updateNumAccumRate");
		$("#rateId_a").attr("readonly", true);
		toDefault();
		$('#wadd').window({
			title : '修改交易笔数累计分段扣率',
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
			async : false,
			dataType : "json",
			success : function(json) {
				$("#rateId_a").val(rateId);
				$("#rateDes_a").val(rateDesc);
				$("#accMode_a").val(accMode);
				notes=="null"?$("#notes_a").val(""):$("#notes_a").val(notes);
				var rows = json.rows;
				for (var i = 1; i <= rows.length; i++) {
					var row = rows[i - 1];
					$("#tid_a" + i).val(row.TID);
					$("#rateType_a" + i).val(row.RATE_TYPE);
					$("#startRange_a" + i).val(row.STARTRANGE);
					$("#endRange_a" + i).val(row.ENDRANGE);
					$("#feeRate_a" + i).val(row.FEE_RATE);
					$("#minFee_a" + i).val(row.MIN_FEE);
					$("#maxFee_a" + i).val(row.MAX_FEE);
				}
			}
		});
	}
	
	function closeAdd() {
		$('#wadd').window('close');
	}
	function closeDetail() {
		$('#wdetail').window('close');
	}
	function search() {
		var data = {
			'rateId' : $('#rateId').val(),
			'rateDes' : $('#rateDes').val()
		};
		$('#test').datagrid('load', data);
	}
	
	/* 显示详情 */
	function showDetail(rateId, rateDesc, accMode, notes) {
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
	function resize() {
		$('#theForm :input').val('');
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
