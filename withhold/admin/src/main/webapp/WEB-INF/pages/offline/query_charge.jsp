<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<jsp:include page="../../top.jsp"></jsp:include>
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
		<div id="p" class="easyui-panel" title="查询条件" style="height: 140px; padding: 10px; background: #fafafa;" iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="8%">会员号:</td>
						<td align="left" style="padding-left: 5px" width="8%"><input name="memberId" id="memberId" maxlength="32" /></td>

						<td align="right" width="10%">充值订单号:</td>
						<td align="left" style="padding-left: 5px" width="8%"><input name="orderNo" id="orderNo" maxlength="32" /></td>

						<!-- <td align="right" width="8%">充值类型:</td>
						<td colspan="1"><select name="memberType" class="easyui-validatebox validatebox-text" id="memberType">
								<option value="">--请选择充值类型--</option>
								<option value="01">个人</option>
								<option value="02">商户</option>

						</select></td> -->

						<td align="right" width="8%">充值状态:</td>
						<td colspan="1"><select name="status" class="easyui-validatebox validatebox-text" id="status">
								<option value="">--请选择充值状态--</option>
								<option value="01">待审核</option>
								<option value="19">审核未过</option>
								<option value="00">充值成功</option>
						</select></td>

						<td align="right">
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
						</td>

					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>

	</div>

	<div id="w" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 800px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="firstTrial" method="post">
					<table width="100%" cellpadding="4" cellspacing="4" style="text-align: left" id="inputForm">
						<tr align="center" style="height:40px;">
							<td align="right" width="50%">会员号:</td>
							<td align="left" width="50%"><input name="memberId" id="memberids" type="text" class="easyui-textbox easyui-validatebox" maxlength="32" required="true" /></td>
						</tr>
						<tr align="center" style="height:40px;">
							<td align="right" width="50%">充值码:</td>
							<td align="left"><input placeholder="请输入充值码" name="chargeCode" required="true" type="text" class="easyui-textbox easyui-validatebox" maxlength="20" required="true" /></td>
						</tr>

						<tr align="center" style="height:40px;">
							<td align="right" width="50%">充值金额:</td>
							<td align="left"><input id="amount" placeholder="请输入充值金额" name="amount" required="true" type="text" class="easyui-textbox easyui-validatebox" maxlength="20" onkeyup="money()" required="true" />元 <span id="moneys"></span></td>
						</tr>
						<!-- <tr align="center">style="width:45%;height:50px;"
							<td align="right" width="45%">充值渠道:</td>
							<td align="left"><select name="channelInsTid" class="easyui-validatebox validatebox-text" id="channelInsTid" style="width: 150px">
							</select></td>
						</tr> -->
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:firstTrial()" id="btn_submit" onclick="">提交</a> 
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" id="btn_submit" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>

</body>

<script>
	var width = $("#continer").width();

	// 充值渠道信息
	/* $(function() {
		$.ajax({
			type : "POST",
			url : "offline/queryOfflineChannel",
			dataType : "json",
			success : function(json) {
				var html = '<option value="">--请选择充值渠道--</option>';
				$.each(json.rows, function(key, value) {
					html += '<option value="' + value.CHNLCODE + '">'
							+ value.CHNLNAME + '</option>';
				});
				$("#channelInsTid").html(html);
			}
		});
	}); */

	// 充值信息表
	$(function() {
		$('#test').datagrid({
			title : '充值信息表',
			iconCls : 'icon-save',
			height : 500,
			singleSelect : true,
			nowrap : false,
			striped : true,
			url : 'offline/queryCharge',
			remoteSort : false,
			idField : 'TID',
			columns : [ [ {
				field : 'ORDERNO',
				title : '充值订单号',
				width : 160,
				align : 'center'
			}, {
				field : 'MEMBERID',
				title : '会员号',
				width : 160,
				align : 'center'
			}, {
				field : 'MEMBERTYPE',
				title : '充值类型',
				width : 100,
				align : 'center',
				formatter : function(value, rec) {
					if (value == '02') {
						return '商户';
					} else if (value == '01') {
						return '个人';
					} else {
						return '';
					}
				}
			}, {
				field : 'CHARGECODE',
				title : '充值码',
				width : 160,
				align : 'center'
			}, {
				field : 'AMOUNT',
				title : '充值金额(元)',
				width : 100,
				align : 'center',
				formatter : function(value, rec) {
					return value / 100;
				}
			}, {
				field : 'STATUS',
				title : '状态',
				width : 100,
				align : 'center',
				formatter : function(value, rec) {
					if (value == '01') {
						return '待审核';
					} else if (value == '09') {
						return '初审未过';
					} else if (value == '11') {
						return '待复审';
					} else if (value == '19') {
						return '审核未过';
					} else if (value == '21') {
						return '等待批处理';
					} else if (value == '29') {
						return '批处理失败';
					} else if (value == '00') {
						return '充值成功';
					} else if (value == '39') {
						return '自行终止';
					} else {
						return '';
					}
				}
			}, {
				field : 'INTIME',
				title : '写入时间',
				width : 120,
				align : 'center'
			} ] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ {
				id : 'btnadd',
				text : '手工充值',
				iconCls : 'icon-add',
				handler : function() {
					$("#firstTrial")[0].reset();
					$("#btn_submit").linkbutton('enable');
					$("#moneys").html("");
					showAdd();
				}
			} ]
		});
	});

	// 查询
	function search() {
		var data = {
			"memberId" : $('#memberId').val(),
			"orderNo" : $('#orderNo').val(),
			"status" : $('#status').val()
		}
		$('#test').datagrid('load', data);
	}

	// 清空
	function resize() {
		$('#theForm :input').val('');
	}
	
	// 弹出充值框
	function showAdd() {
		$('#w').window({
			title : '充值',
			top : 100,
			width : 500,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : true,
			shadow : false,
			closed : false,
			height : 240
		});
	}

	// 关闭充值界面
	function closeAdd() {
		$('#w').window('close');
	}

	// 充值金额校验
	function money() {
		var money = $("#amount").val();
		var masg;
		var isok = true;
		if (money != null && isMoney(money)) {

			masg = toChineseCash(money);
			$("#moneys").css("color", "black");
		} else {
			masg = "请输入合法的金额";
			$("#moneys").css("color", "red");

			isok = false;
		}
		$("#moneys").html(masg);
		return isok;

	}

	// 提交充值信息
	function firstTrial() {
		$("#firstTrial").attr("action", "offline/charge");

		$('#firstTrial').form(
				'submit',
				{
					onSubmit : function() {
						if ($('#firstTrial').form('validate')
								&& isMoney($("#amount").val())) {
							$('#btn_submit').linkbutton('disable');
							return true;
						}
						return false;
					},
					success : function(data) {
						data = JSON.parse(data);
						if (typeof (data.RET) == "undefined") {
							$.messager.alert("", "充值服务异常！", "error");
						} else if (data.RET == 'succ') {
							$.messager.alert("", data.INFO, "info");
							closeAdd();
							search();
						} else {
							$.messager.alert("", data.INFO, "error");
							$("#btn_submit").linkbutton('enable');
						}
					}
				});
	}
</script>
</html>
