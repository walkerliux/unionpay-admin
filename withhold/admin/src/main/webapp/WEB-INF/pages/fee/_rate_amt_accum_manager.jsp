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
						<td class="add" align="right"><a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> <a href="javascript:clear()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
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
					<table id="tableadd" width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" id="add_button_a" iconCls="icon-add" href="javascript:addSegment()" onclick="">添加分段</a> 
				<a class="easyui-linkbutton" id="remove_button_a" iconCls="icon-remove" href="javascript:subtractSegment()" onclick="">删除分段</a> 
				<a class="easyui-linkbutton" id="save_button_a" iconCls="icon-ok" href="javascript:addAmtAccumRate()" onclick="">保存</a> 
				<a class="easyui-linkbutton" id="cancel_button_a" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>

	<!-- 详情页面 -->
	<div id="wdetail" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 500px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="detailForm" action="" method="post">
					<table id="tabledetail" width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
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
	var panelHeight = 230;
	var panelHoriFloat = (width - panelWidth) / 2;
	var panelVertFloat = 150;
	var width = $("#continer").width();
	 
	$(function() {
		$('#test')
				.datagrid(
						{
							title : '交易金额累计分段扣率列表',
							iconCls : 'icon-save',
							height : gridHeight,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'fee/queryAmtAccumRate',
							remoteSort : false,
							columns : [ [
									{
										field : 'rateId',
										title : '扣率代码',
										width : 120,
										align : 'center',
										rowspan : 1
									},
									{
										field : 'rateDesc',
										title : '扣率描述',
										width : 120,
										align : 'center',
										rowspan : 1
									},
									{
										field : 'notes',
										title : '备注',
										width : 120,
										align : 'center',
										rowspan : 1
									},
									/* {
										field : 'intime',
										title : '创建时间',
										width : 200,
										align : 'center',
										rowspan : 1
									}, */
									/* {
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
									}, */
									{
										field : 'TID',
										title : '操作',
										width : 120,
										align : 'center',
										formatter : function(value, rec) {
											return '<a href="javascript:showModify(\''
													+ rec.rateId
													+ '\', \''
													+ rec.rateDesc
													+ '\', \''
													+ rec.ACCMODE
													+ '\', \''
													+ rec.notes
													+ '\')" style="color:blue;margin-left:10px">修改</a>'
													+ '&nbsp;&nbsp<a href="javascript:showDetail(\''
													+ rec.rateId
													+ '\', \''
													+ rec.rateDesc
													+ '\', \''
													+ rec.ACCMODE
													+ '\', \''
													+ rec.notes
													+ '\')" style="color:blue;margin-left:10px">详情</a>';
										}
									} ] ],
							pagination : true,
							rownumbers : true,
							toolbar : [ {
								id : 'btnadd',
								text : '新增交易金额累计分段扣率',
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
		var output='';	// 拼接显示的内容
		
		// 拼接交易金额累计分段扣率
		output += '<tr>';
		output += 	'<td colspan="4" class="head-title update">';
		output += 		'交易金额累计分段扣率<input type="hidden" id="tid" name="tid"/>';
		output += 	'</td>';
		output += '</tr>';
		
		// 拼接扣率代码
		/* output += '<tr>';
		output += 	'<td class="update" width="15%">扣率代码</td>';
		output += 	'<td class="update" colspan="3">';
		output += 		'<input id="rateId_a" name="rateId" maxlength="10" class="easyui-validatebox" required="true" missingMessage="请输入扣率代码" />';
		output += 	'</td>';
		
		output += '</tr>'; */
		
		// 拼接扣率描述+累计方式
		output += '<tr>';
		output += 	'<td class="update" width="15%">扣率描述</td>';
		output += 	'<td class="update" colspan="3">';
		output += 		'<input id="rateDes_a" name="rateDesc" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入扣率描述" />';
		output += 	'</td>';
		/* output += 	'<td class="update" width="15%">累计方式</td>';
		output += 	'<td class="update">';
		output += 		'<select id="accMode_a" name="accMode" class="easyui-validatebox" required="true" missingMessage="请选择累计方式">';
		output += 			'<option value="" selected="selected">--请选择累计方式--</option>';
		output += 			'<option value="0">日</option>';
		output += 			'<option value="1">月</option>';
		output += 			'<option value="2">年</option>';
		output += 		'</select>';
		output += 	'</td>'; */
		output += '</tr>';
		
		// 拼接段1
		output += '<tr class="segment seg1">';
		output += 	'<td colspan="4" class="head-title update">段1</td>';
		output += '</tr>';
		
		// 拼接段1--（计费方式+费率）
		output += '<tr class="seg1" id="trRate1">';
		output += 	'<td class="update" width="15%">计费方式</td>';
		output += 	'<td class="update" width="30%" id="tdRate1">';
		output += 		'<select id="rateType_a1" name="ardList[0].rateType" class="easyui-validatebox" required="true" onchange="changeRateType(1)" missingMessage="请选择计费方式">';
		output += 			'<option value="" selected="selected">--请选择计费方式--</option>';
		output += 			'<option value="1">固定金额</option>';
		output += 			'<option value="2">固定比例</option>';
		output += 			'<option value="3">固定比例+限额</option>';
		output += 		'</select>';
		output += 	'</td>';
		output += 	'<td class="update rateChanged1" width="15%">费率（%）</td>';
		output += 	'<td class="update rateChanged1">';
		output += 		'<input id="feeRate_a1" name="ardList[0].feeRate" validType="amount" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" />';
		output += 	'</td>';
		output += '</tr>';
		
		// 拼接段1--（最低收费额+最高收费额）
		output += '<tr class="rateChanged1 seg1">';
		output += 	'<td class="update" width="15%">最低收费额(元)</td>';
		output += 	'<td class="update" width="30%">';
		output += 		'<input id="minFee_a1" name="ardList[0].minFee" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额" />';
		output += 	'</td>';
		output += 	'<td class="update" width="15%">最高收费额(元)</td>';
		output += 	'<td class="update">';
		output += 		'<input id="maxFee_a1" name="ardList[0].maxFee" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额" />';
		output += 	'</td>';
		output += '</tr>';
		
		// 拼接备注
		output += '<tr id="notes">';
		output += 	'<td class="update">备注</td>';
		output += 	'<td class="update" colspan="3">';
		output += 		'<textarea id="notes_a" rows="3" cols="75" name="notes" maxlength="32"></textarea>';
		output += 	'</td>';
		output += '</tr>';
		
		$('#tableadd').html(output);
		
		$.parser.parse('#tableadd');
		
		$("#addForm").attr("action", "fee/saveAmtAccumRate");
		$('#wadd').window({
			title : '新增交易金额累计分段扣率',
			top : panelVertFloat,
			left : panelHoriFloat,
			width : panelWidth,
			height : panelHeight + 26*3,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : true,
			shadow : true,
			closed : false
		});
	}
	
	/* 保存 */ 
	function addAmtAccumRate() {
		var segmentIndex = $('.segment').length;//每一段有个class="segment"的标记，故统计出段数
		for (var i = 1; i <= segmentIndex; i++) {
			var rateType = $("#rateType_a" + i).val();
			// 计费方式为“固定比例+限额”时，最低收费额不能大于最高收费额
			if(rateType==3){
				var minFee = parseFloat($("#minFee_a" + i).val());
				var maxFee = parseFloat($("#maxFee_a" + i).val());
				if (minFee > maxFee) {
					$.messager.alert("","段" + i + "的最低收费额不能大于最高收费额","warning");
					return false;
				}
			}
			
			// 分界线递增
			if (i > 1) {
				var preRange = 0;
				var thisRange = parseFloat($("#startRange_a" + i).val());
				if (i > 2) {
					preRange = parseFloat($("#startRange_a" + (i - 1)).val());
				}
				if(preRange >= thisRange){
					$.messager.alert("","段" + i + "的分界线金额要大于段" + (i-1) + "的分界线金额","warning");
					return false;
				}
			}
		}
		
		$('#addForm').form('submit', {
			onSubmit : function() {
				$('#save_button_a').linkbutton('disable');	
				return $('#addForm').form('validate');
			},
			success : function(data) {
				$('#save_button_a').linkbutton('enable');
				data=JSON.parse(data);
				if (typeof(data.RET) == "undefined")
				{
					$.messager.alert("","服务异常！","info");
				} else if (data.RET == 'succ') {
					$.messager.alert("",data.INFO,"info");
					closeAdd();
					search();
				} else {
					$.messager.alert("",data.INFO,"info");
				}
			}
		});
	}

	/* 显示修改页面 */
	function showModify(rateId, rateDesc, accMode, notes) {
		var output='';	// 拼接显示的内容
		$("#addForm").attr("action", "fee/updateAmtAccumRate");
		
		$('#wadd').window({
			title : '修改交易金额累计分段扣率',
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
				
				// 拼接交易金额累计分段扣率
				output += '<tr>';
				output += 	'<td colspan="4" class="head-title update">';
				output += 		'交易金额累计分段扣率';
				output += 	'</td>';
				output += '</tr>';
				
				// 拼接扣率代码
				output += '<tr>';
				output += 	'<td class="update" width="15%">扣率代码</td>';
				output += 	'<td class="update" colspan="3">';
				output += 		'<input id="rateId_a" name="rateId" class="easyui-validatebox" readonly="readonly" value="' + rateId + '"/>';
				output += 	'</td>';
				output += '</tr>';
				
				// 拼接扣率描述+累计方式
				output += '<tr>';
				output += 	'<td class="update" width="15%">扣率描述</td>';
				output += 	'<td class="update" width="30%">';
				output += 		'<input id="rateDes_a" name="rateDesc" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入扣率描述" value="' + rateDesc + '"/>';
				output += 	'</td>';
				/* output += 	'<td class="update" width="15%">累计方式</td>';
				output += 	'<td class="update">';
				output += 		'<select id="accMode_a" name="accMode" class="easyui-validatebox" required="true" missingMessage="请选择累计方式">';
				output += 			'<option value="" selected="selected">--请选择累计方式--</option>';
				output += 			'<option value="0" ' + (accMode == 0 ? 'selected="selected"' : '') + '>日</option>';
				output += 			'<option value="1" ' + (accMode == 1 ? 'selected="selected"' : '') + '>月</option>';
				output += 			'<option value="2" ' + (accMode == 2 ? 'selected="selected"' : '') + '>年</option>';
				output += 		'</select>';
				output += 	'</td>'; */
				output += '</tr>';
				
				var rows = json.rows;
				for (var i = 0; i < rows.length; i++) {
					//var row = rows[i - 1];
					// 拼接段
					output += '<tr class="segment seg' + (i + 1) + '">';
					output += 	'<td colspan="4" class="head-title update">';
					output += 		'段' + (i + 1);
					output +=	'</td>';
					output += '</tr>';
					
					if (i != 0) { 
						// 拼接分界线
						output += '<tr class="seg' + (i+1)  + '">';
						output += 	'<td class="update" width="15%">';
						output += 		'分界线' + i + '(元)';
						output += 	'</td>';
						output += 	'<td class="update" colspan="3">';
						output += 		'<input id="startRange_a' + (i + 1) + '" name="ardList[' + i + '].startRange" value="' + rows[i].startrange/100 + '" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入分界线金额" />';
						output +=	'</td>';
						output += '</tr>';
					 } 
					
					// 拼接计费方式
					output += '<tr class="seg' + (i + 1) + '"  id="trRate' + (i + 1) + '">';
					output += 	'<td class="update" width="15%">计费方式</td>';
					output += 	'<td class="update" id="tdRate' + (i + 1) + '" width="30%">';
					output += 		'<select id="rateType_a' + (i + 1) + '" name="ardList[' + i + '].rateType" class="easyui-validatebox" required="true" onchange="changeRateType(' + (i + 1) + ')" missingMessage="请选择计费方式">';
					output += 			'<option value="">--请选择计费方式--</option>';
					output += 			'<option value="1" ' + (rows[i].rateType == 1 ? 'selected="selected"' : '') + '>固定金额</option>';
					output += 			'<option value="2" ' + (rows[i].rateType == 2 ? 'selected="selected"' : '') + '>固定比例</option>';
					output += 			'<option value="3" ' + (rows[i].rateType == 3 ? 'selected="selected"' : '') + '>固定比例+限额</option>';
					output += 		'</select>'
					output += 	'</td>';
					if (rows[i].rateType == 1) {
						// 添加固定金额要显示的部
						output += '<td class="update rateChanged' + (i + 1) + '" width="15%">收费额(元)</td>';
						output += '<td class="update rateChanged' + (i + 1) + '" width="30%">';
						output += 	'<input id="minFee_a' + (i + 1) + '" name="ardList[' + i + '].minFee" maxlength="12" value="' + fenToYuan(rows[i].minFee) + '" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入收费金额" />';
						output += '</td>';
					}else if (rows[i].rateType >1) {
						// 添加 固定比例 或 固定比例+限额  要显示的费率部分
						output += '<td class="update rateChanged' + (i + 1) + '" width="15%">费率（%）</td>';
						output += '<td class="update rateChanged' + (i + 1) + '" width="30%">';
						output += 	'<input id="feeRate_a' + (i + 1) + '" name="ardList[' + i + '].feeRate" validType="amount" value="' + fenToYuan(rows[i].feeRate) + '" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" />';
						output += '</td>';
					}
					output += '</tr>'
					// 添加固定比例+限额要显示的收费额部分
					if (rows[i].rateType == 3) {
						output += '<tr class="rateChanged' + (i + 1) + ' seg' + (i + 1) + '">';
						output += 	'<td class="update" width="15%">最低收费额(元)</td>';
						output += 	'<td class="update" width="30%">';
						output += 		'<input id="minFee_a' + (i + 1) + '" name="ardList[' + i + '].minFee" maxlength="12" value="' + fenToYuan(rows[i].minFee) + '" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额" />';
						output += 	'</td>';
						output += 	'<td class="update" width="15%">最高收费额(元)</td>';
						output += 	'<td class="update">';
						output += 		'<input id="maxFee_a' + (i + 1) + '" name="ardList[' + i + '].maxFee" maxlength="12" value="' + fenToYuan(rows[i].maxFee) + '" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额" />';
						output += 	'</td>';
						output += '</tr>';
					}
				} 
				
				// 拼接备注
				output += '<tr id="notes">';
				output += 	'<td class="update">备注</td>';
				output += 	'<td class="update" colspan="3">';
				output += 		'<textarea id="notes_a" rows="3" cols="75" name="notes" maxlength="32">' + (notes == "null" ? '' : notes) + '</textarea>';
				output += 	'</td>';
				output += '</tr>';
				
				$('#tableadd').html(output);
				resize("wadd");
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
			'rateDesc' : $('#rateDes').val()
		};
		$('#test').datagrid('load', data);
	}
	
	/* 显示详情 */
	function showDetail(rateId, rateDesc, accMode, notes) {
		var heightAdd=0;// 累计显示的高度
		var output='';	// 拼接显示的内容

		$.ajax({
			type : "POST",
			url : "fee/queryAccumRateDeta?rateId=" + rateId,
			dataType : "json",
			success : function(json) {
				if(json!=null){
				output += '<tr><td colspan="4" class="head-title update">交易金额累计分段扣率</td></tr>';
				output += '<tr><td class="update" width="15%">扣率代码</td><td class="update" colspan="3">' + rateId + '</td></tr>';
				output += '<tr><td class="update" width="15%">扣率描述</td><td class="update" width="30%">' + rateDesc + '</td>';		
				//output += '<td class="update" width="15%">累计方式</td><td class="update">' + (accMode == 0 ? '日' : (accMode == 1 ? '月' : (accMode == 2 ? '年' : ''))) + '</td></tr>';		
				heightAdd += panelHeight;	
				var rows = json.rows;
				for (var i = 1; i <= rows.length; i++) {
					var row = rows[i - 1];
					if (row.rateType == 1) {// 固定金额
						output += '<tr><td colspan="4" class="head-title update">段' + i +'</td></tr>';
						heightAdd += 26;
						if (i != 1) {
							output += '<tr><td class="update" width="15%">分界线' + (i-1) + '(元)</td><td class="update" colspan="3">' + row.STARTRANGE/100 + '</td></tr>';
							heightAdd += 26;
						}
						output += '<tr><td class="update" width="15%">计费方式</td><td class="update" width="30%">固定金额</td>';
						output += '<td class="update" width="15%">收费额(元)</td><td class="update">' + fenToYuan(row.minFee) + '</td></tr>';
						heightAdd += 26;
					} else if (row.rateType == 2) {// 固定比例
						output += '<tr><td colspan="4" class="head-title update">段' + i +'</td></tr>';
						heightAdd += 26;
						if (i != 1) {
							output += '<tr><td class="update" width="15%">分界线' + (i-1) + '(元)</td><td class="update" colspan="3">' + row.startrange/100 + '</td></tr>';
							heightAdd += 26;
						}
						output += '<tr><td class="update" width="15%">计费方式</td><td class="update" width="30%">固定比例</td>';
						output += '<td class="update" width="15%">费率（%）</td><td class="update">' + fenToYuan(row.feeRate) + '</td></tr>';
						heightAdd += 26;
					}else if (row.rateType == 3) {// 固定比例+限额
						output += '<tr><td colspan="4" class="head-title update">段' + i +'</td></tr>';
						heightAdd += 26;
						if (i != 1) {
							output += '<tr><td class="update" width="15%">分界线' + (i-1) + '(元)</td><td class="update" colspan="3">' + row.startrange/100 + '</td></tr>';
							heightAdd += 26;
						}
						output += '<tr><td class="update" width="15%">计费方式</td><td class="update" width="30%">固定比例+限额</td>';
						output += '<td class="update" width="15%">费率（%）</td><td class="update">' + fenToYuan(row.feeRate) + '</td></tr>';
						heightAdd += 26;
						output += '<tr><td class="update" width="15%">最低收费额(元)</td><td class="update" width="30%">' + fenToYuan(row.minFee) + '</td>';
						output += '<td class="update" width="15%">最高收费额(元)</td><td class="update">' +fenToYuan(row.maxFee) + '</td></tr>';
						heightAdd += 26;
					}
				}
				output += '<tr height="50px"><td class="update">备注</td><td class="update" colspan="3" id="notes_d">' + (notes=="null"?"":notes) + '</td></tr>';
				$('#tabledetail').html(output);
				
				$('#wdetail').window({
					title : '交易金额累计分段扣率详情',
					top : panelVertFloat,
					left : panelHoriFloat,
					width : panelWidth,
					height : heightAdd,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					modal : true,
					shadow : true,
					closed : false,
				});
			}
			}
		});
		
	}
	
	// 清空查询
	function clear() {
		$('#theForm :input').val('');
	}
	
	// 修改计费方式，显示的内容也跟着：固定金额，只显示收费额；固定比较，只显示费率；固定比例+限额，显示费率、最低及最高收费额
	function changeRateType(index){
		var rateType = $("#rateType_a"+index).val();
		var output = '';
		
		// 删除变化的部分
		$('#wadd .rateChanged' + index).remove();
		
		if (rateType == 1) {// 固定金额
			// 添加固定金额要显示的部
			output += '<td class="update rateChanged' + index + '" width="15%">收费额(元)</td>';
			output += '<td class="update rateChanged' + index + '" width="30%">';
			output += 	'<input id="minFee_a' + index + '" name="ardList[' + (index - 1) + '].minFee" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入收费金额" />';
			output += '</td>';
			
			$('#tdRate'+index).after(output);
		} else if (rateType == 2) {// 固定比例
			// 添加固定比例要显示的部分
			output += '<td class="update rateChanged' + index + '" width="15%">费率（%）</td>';
			output += '<td class="update rateChanged' + index + '" width="30%">';
			output += 	'<input id="feeRate_a' + index + '" name="ardList[' + (index - 1) + '].feeRate" validType="amount" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" />';
			output += '</td>';
			
			$('#tdRate'+index).after(output);
		} else if (rateType == 3) {// 固定比例+限额
			// 添加固定比例+限额要显示的部分
			output += '<td class="update rateChanged' + index + '" width="15%">费率（%）</td>';
			output += '<td class="update rateChanged' + index + '" width="30%">';
			output += 	'<input id="feeRate_a' + index + '" name="ardList[' + (index - 1) + '].feeRate" validType="amount" required="true" type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入费率" />';
			output += '</td>';
			
			$('#tdRate'+index).after(output);
			
			output = '';
			output += '<tr class="rateChanged' + index + ' seg' + index + '">';
			output += 	'<td class="update" width="15%">最低收费额(元)</td>';
			output += 	'<td class="update" width="30%">';
			output += 		'<input id="minFee_a' + index + '" name="ardList[' + (index - 1) + '].minFee" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额" />';
			output += 	'</td>';
			output += 	'<td class="update" width="15%">最高收费额(元)</td>';
			output += 	'<td class="update">';
			output += 		'<input id="maxFee_a' + index + '" name="ardList[' + (index - 1) + '].maxFee" maxlength="12" required="true" validType="amount" type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额" />';
			output += 	'</td>';
			output += '</tr>';
			
			$('#trRate'+index).after(output);
		}
		
		$.parser.parse('#tableadd');
		resize("wadd");
	}
	
	
	// 添加分段
	function addSegment(){
		var segmentIndex = $('.segment').length;//每一段有个class="segment"的标记，故统计出段数
		var output='';	// 拼接显示的内容
		
		// 拼接段
		output += '<tr class="segment seg' + (segmentIndex + 1) + '">';
		output += 	'<td colspan="4" class="head-title update">';
		output += 		'段' + (segmentIndex + 1);
		output +=	'</td>';
		output += '</tr>';
		// 拼接分界线
		output += '<tr class="seg' + (segmentIndex + 1) + '">';
		output += 	'<td class="update" width="15%">';
		output += 		'分界线' + segmentIndex + '(元)';
		output += 	'</td>';
		output += 	'<td class="update" colspan="3">';
		output += 		'<input id="startRange_a' + (segmentIndex + 1) + '" name="ardList[' + segmentIndex + '].startRange" required="true" validType="amount" maxlength="12" type="text" class="easyui-validatebox" missingMessage="请输入分界线金额" />';
		output +=	'</td>';
		output += '</tr>';
		// 拼接计费方式
		output += '<tr class="seg' + (segmentIndex + 1) + '"  id="trRate' + (segmentIndex + 1) + '">';
		output += 	'<td class="update" width="15%">计费方式</td>';
		output += 	'<td class="update" id="tdRate' + (segmentIndex + 1) + '" width="30%">';
		output += 		'<select id="rateType_a' + (segmentIndex + 1) + '" name="ardList[' + segmentIndex + '].rateType" class="easyui-validatebox" required="true" onchange="changeRateType(' + (segmentIndex + 1) + ')" missingMessage="请选择计费方式">';
		output += 			'<option value="" selected="selected">--请选择计费方式--</option>';
		output += 			'<option value="1">固定金额</option>';
		output += 			'<option value="2">固定比例</option>';
		output += 			'<option value="3">固定比例+限额</option>';
		output += 		'</select>'
		output += 	'</td>';
		output += '</tr>'
		
		$('#notes').before(output);
		
		resize("wadd");
		$.parser.parse('#tableadd');
	}
	
	// 减去分段
	function subtractSegment(){
		var segmentIndex = $('.segment').length;
		if (segmentIndex > 1) {
			$('#addForm .seg' + segmentIndex).remove();
			resize("wadd");
		}
	}
	// 转换金额格式：分-->元
	function fenToYuan(value) {
		var str = (value / 100).toFixed(2) + '';
		var intSum = str.substring(0, str.indexOf(".")).replace(
				/\B(?=(?:\d{3})+$)/g, ',');
		var dot = str.substring(str.length, str.indexOf("."))
		var ret = intSum + dot;
		return ret;
	}
	// 重置面板高度
	function resize(winid){
		var trNum = $('#addForm tr').length;
		$('#' + winid).window('resize',{
			height: panelHeight + (trNum - 4) * 25.556
		});
	}
</script>
</html>
