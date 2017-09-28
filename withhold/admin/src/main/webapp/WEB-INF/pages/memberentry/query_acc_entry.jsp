<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
</style>


</head>
<body>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 120px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>					
						<td align="center">凭证号</td>
								<td><input name="voucherCode"  type="text" id="voucherCode" maxlength="32"  onkeyup="value=value.replace(/[^\d]/g,'')"/>
						</td>
						
						<td align="center">科目号</td>
						<td><input name="acctCode"  type="text" id="acctCode" maxlength="22" onkeyup="value=value.replace(/[^\d]/g,'')"/>
						</td>
						
						<td align="center">交易类型</td>
						<td colspan="1">
							<select name="busiCode"
								class="easyui-validatebox validatebox-text" id="busiCode" style="width:130px">
									<option value="">请选择</option>
									<option value="10000001">消费</option>
									<option value="10000002">消费-账户</option>
									<option value="11000001">消费-产品</option>
									<option value="11000003">消费-产品</option>
									<option value="11000004">授信消费</option>
									<option value="20000001">充值</option>
									<option value="20000002">保证金充值</option>
									<option value="30000001">提现</option>
									<option value="40000001">退款</option>
									<option value="50000001">转账</option>
									<option value="50000002">保证金提取</option>
									<option value="70000001">代付</option>
									<option value="80000001">实名认证</option>
									<option value="90000001">手工充值</option>
							</select>
						</td>
						
						<td align="center">分录时间</td>
						<td><input id="startTime" type="text" class="easyui-datetimebox"
							data-options="showSeconds:false" name="startTime"></input> 至<input id="endTime" type="text"
							class="easyui-datetimebox" data-options="showSeconds:false" name="endTime" ></input>
						</td>	
					</tr>
					<tr>
						<td align="center">交易流水号</td>
						<td><input name="txnseqno" maxlength="32" type="text" id="txnseqno" maxlength="32" onkeyup="value=value.replace(/[^\d]/g,'')"/>
						</td>
						
						<td align="center">订单号</td>
						<td><input name="payordno" type="text" id="payordno" maxlength="32"/>
						</td>
						
						<td align="center">记账状态</td>
						<td colspan="1">
							<select name="status"
								class="easyui-validatebox validatebox-text" id="status" style="width:130px">
									<option value="">请选择</option>
									<option value="ACCOUNTED">已记账</option>
									<option value="NOT_ACCOUNTED">未记账</option>
									<option value="WAIT_ACCOUNTED">待记账</option>
							</select>
						</td>
						
<!-- 						<td align="center">记账方向</td> -->
<!-- 						<td colspan="1"> -->
<!-- 							<select name="crdr" class="easyui-validatebox validatebox-text" id="crdr" style="width:130px"> -->
<!-- 									<option value="">请选择</option> -->
<!-- 									<option value="00">借</option> -->
<!-- 									<option value="01">贷</option>									 -->
<!-- 							</select> -->
<!-- 						</td> -->
						<td></td>
                        <td align="right">
                        	<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a href="javascript:resize()" class="easyui-linkbutton"iconCls="icon-redo">清空</a>
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
  $(function() {
	    $('#endTime,#startTime').datebox({});
	});

	var width = $("#continer").width();
	$(function() {
	    $('#test').datagrid({
	        title: '收支明细',
	        iconCls: 'icon-save',
	        height: 400,
	        singleSelect: true,
	        nowrap: false,
	        striped: true,
	        url: 'entry/queryTradeDetail',
	        remoteSort: false,
	        columns: [[
	        {
	            field: 'voucherCode',
	            title: '凭证号',
	            width: 150,
	            align: 'center'
	        },
	        {
	            field: 'memberid',
	            title: '委托机构号',
	            width: 150,
	            align: 'center'
	        },
	        {
	            field: 'acctCode',
	            title: '科目号',
	            width: 150,
	            align: 'center'
	        },
	        {
	            field: 'acctCodeName',
	            title: '账户名',
	            width: 150,
	            align: 'center'
	        },
	        {
	            field: 'usage',
	            title: '用途',
	            width: 80,
	            align: 'center',
	            formatter: function(value, rec) {
	            	switch (value) {
	            	case 'BASICPAY':
	            	    return '现金账户';
	            	case 'BANKDEPOSIT':
	            		return '银行存款';
	            	case 'RECEIVABLEBANK':
	            		return '应收银行';
	            	case 'ZLREVTRANDEPOSIT':
	            		return '证联收转存款';
	            	case 'BANKPAYABLE':
	            		return '应付银行';
	            	case 'CHANNELFEECOST':
	            		return '通道手续费支出';
	            	case 'WAITSETTLE':
	            		return '待结算';
	            	case 'PROFITSPAYABLE':
	            		return '应付待分润';
	            	case 'BAIL':
	            		return '保证金';
	            	case 'FEEINCOME':
	            		return '手续费收入';
	            	default :
	            		return '授信';
	            	}
	            }
	        },
	        {
	            field: 'busiCode',
	            title: '交易类型',
	            width: 80,
	            align: 'center',
				formatter:function(value,rec){
					if(value=="10000001"){
						return "消费";
					}else if(value=="10000002"){
						return "消费-账户";
					}else if(value=="11000001"){
						return "消费-产品";
					}else if(value=="11000004"){
						return "授信消费";
					}else if(value=="20000001"){
						return "充值";
					}else if(value=="20000002"){
						return "保证金充值";
					}else if(value=="30000001"){
						return "提现";
					}else if(value=="40000001"){
						return "退款";
					}else if(value=="50000001"){
						return "转账";
					}else if(value=="50000002"){
						return "保证金提取";
					}else if(value=="70000001"){
						return "代付";
					}else if(value=="80000001"){
						return "实名认证";
					}else if(value=="90000001"){
						return "手工充值";
					}else{
						return "";  
					}
				}
	        },
	        {
	            field: 'crdr',
	            title: '记账方向',
	            width: 80,
	            align: 'center',
	            formatter: function(value, rec) {
	                if (value == "C") {
	                    return "借";
	                } else if (value == "D") {
	                    return "贷";
	                } 
	            }
	        },
	        {
	            field: 'payordno',
	            title: '支付订单号',
	            width: 150,
	            align: 'center'
	        },
	        {
	            field: 'txnseqno',
	            title: '交易流水号',
	            width: 150,
	            align: 'center'
	        },
	        {
	            field: 'inTime',
	            title: '分录时间',
	            width: 150,
	            align: 'center'
	        },
	        {field: 'amount',title: '交易金额(元)',width: 110,align: 'center'},
	        {
	            field: 'status',
	            title: '记账状态',
	            width: 80,
	            align: 'center',
	            formatter: function(value, rec) {
	                if (value == "00") {
	                    return "已记账";
	                } else if (value == "01") {
	                    return "未记账";
	                } else if (value == "02") {
	                    return "待记账";
	                }
	            }
	        }
	        ]],
	        pagination: true,
	        rownumbers: true

	    });
	});

	function search() {
		
		if($("#endTime").datebox('getValue') != null && $("#startTime").datebox('getValue') == null ){
			compareTime();
		}
	    
	    var data = {
	    	'voucherCode': $('#voucherCode').val(),
	    	'acctCode': $("#acctCode").val(),
	        'busiCode': $('#busiCode').val(),	        
	        'endTimen': $("#endTime").datebox('getValue'),
	        'startTimen': $("#startTime").datebox('getValue'),	        
	        'txnseqno': $("#txnseqno").val(),
	        'payordno': $("#payordno").val(),
	        'status': $("#status").val()
	    };			    
	    $('#test').datagrid('load', data);
	}	
	
	function resize(){
		$('#theForm :input').val('');
	}
	
 	function compareTime(){
		var startTime = $("#startTime").datebox('getValue');
		var endTime = $("#endTime").datebox('getValue');
		if(startTime >= endTime){
			alert("分录开始时间不能大于等于结束时间");
		}
		
	} 
	
	function fenToYuan(value){
		var str = (value/100).toFixed(2) + '';
		var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
		var dot = str.substring(str.length,str.indexOf("."))
		var ret = intSum + dot;
		return ret;
	}
	</script>
</html>
