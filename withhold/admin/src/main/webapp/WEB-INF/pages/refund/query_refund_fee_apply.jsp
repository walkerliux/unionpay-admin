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

						<td align="right" width="8%">审核状态:</td>
						<td colspan="1"><select name="status" class="easyui-validatebox validatebox-text" id="status">
								<option value="">--请选择审核状态--</option>
								<option value="01">待审核</option>
								<option value="19">审核未过</option>
								<option value="00">撤销成功</option>
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

</body>

<script>
	var width = $("#continer").width();


	// 信息表
	$(function() {
		$('#test').datagrid({
			title : '信息表',
			iconCls : 'icon-save',
			height : 500,
			singleSelect : true,
			nowrap : false,
			striped : true,
			url : 'refund/queryRefundFeeApply',
			remoteSort : false,
			idField : 'TID',
			columns : [ [ {
				field : 'TXNSEQNO',
				title : '交易序列号',
				width : 160,
				align : 'center'
			}, {
				field : 'MEMBERID',
				title : '会员号',
				width : 160,
				align : 'center'
			},{
				field : 'BUSITYPE',
				title : '业务类型',
				width : 100,
				align : 'center'
			}, {
				field : 'AMOUNT',
				title : '金额(元)',
				width : 100,
				align : 'center',
				formatter : function(value, rec) {
					return value / 100;
				}
			}, {
				field : 'FEE',
				title : '手续费金额(元)',
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
						return '审核成功';
					} else if (value == '39') {
						return '自行终止';
					} else {
						return '';
					}
				}
			}, {
				field : 'TRANSRESULT',
				title : '交易结果',
				width : 100,
				align : 'center',
				formatter : function(value, rec) {
					if (value == '00') {
						return '成功';
					} else {
						return '失败';
					}
				}
			}, {
				field : 'REINFO',
				title : '应答信息',
				width : 160,
				align : 'center'
			}, {
				field : 'INTIME',
				title : '写入时间',
				width : 120,
				align : 'center'
			} ] ],
			pagination : true,
			rownumbers : true
		});
	});

	// 查询
	function search() {
		var data = {
			"memberId" : $('#memberId').val(),
			"status" : $('#status').val()
		}
		$('#test').datagrid('load', data);
	}

	// 清空
	function resize() {
		$('#theForm :input').val('');
	}
	
</script>
</html>
