<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<jsp:include page="../../../top.jsp"></jsp:include>
<body>
	<style type="text/css">
table tr td {
	height: 25px
}


table tr td select {
	height: 20px
}

#continer table tr td {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}

#continer table tr td input {
	width:250px;
}

#continer table tr td.head-title {
	background-color: #F0F8FF;
	font-weight: bold;
}

#continer table tr td.head-guide {
	background-color: #F0FFFF;
	font-weight: bold;
}

#continer table tr td font.current-step {
	color: #EE4000;
}
</style>
	<div style="margin: 5px; border:" >
		<div id="p" class="easyui-panel" title="查询条件" style="height: 148px; padding: 10px; background: #fafafa;" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">商户号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input name="accsecmerno" id="accsecmerno" /></td>
						
					
					
						<td align="right" width="10%">交易状态</td>
						<td align="left" style="padding-left: 5px" width="15%">
						<select name="retcode"
							id="retcode" style="width: 150px">
								<option value="">--请选择订单状态--</option>
								<option value="0000">成功</option>
								<option value="01">失败</option>
						</select></td>
					</tr>
				
					<tr> 
						 <td align="right" width="15%">开始时间</td>
						<td align="left" style="padding-left: 5px" width="25%">
							<input id="stime" name="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox" data-options="showSeconds:true" ></input> 
						</td> 
						 <td align="right" width="15%">截止时间</td>
						 <td align="left" style="padding-left: 5px" width="25%">
						 	<input id="etime" name="etime" type="text"
							style="width: 120PX" class="easyui-datetimebox" data-options="showSeconds:true" ></input> 
						<td></td>
						<td align="right" width="10%"></td>
						<!-- <td align="left" style="padding-left: 5px" width="15%"></td> -->
						<!-- <td align="left">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td> -->
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
		
		<div style="margin-top: 5px">
			<table id="detailInfo"></table>
		</div>
	</div>
	
	
	<div id="w" class="easyui-window" closed="true" title="My Window"  style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center" id="continer">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo" border="1">
					<tr>
						<td colspan="4" class="head-title">报文头信息</td>
					</tr>
					<tr>					
						<td width="15%">报文标识号</td><td width="35%" id="msgid"></td>
						<td width="15%">交易类型 </td><td width="35%" id="tradetype"></td>
						
					</tr>
					<tr>	
						<td>发起方代码</td><td id="transmitleg"></td>
						<td>接收方代码</td><td id="receiver"></td>
					</tr>
					<tr>
						<td>本地日期 </td><td id="transdate"></td>
						<td>本地时间</td><td id="transtime"></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">业务报文信息</td>
					</tr>
					<tr>
						<td>明细标识号</td><td id="txid"></td>
						<td>金额（元）</td><td id="amount"></td>
					</tr>
					<tr>
						<td>合同（协议）号</td><td id="endtoendidentification" colspan="3"></td>
					</tr>
					<tr>
						<td>付款账号</td><td id="debtoraccountno"></td>
						<td>收款账号</td><td id="creditoraccountno"></td>
					</tr>
					<tr>
						
						<td>付款账户名称</td><td id="debtorname"></td>
						<td>收款账户名称</td><td id="creditorname"></td>
					</tr>
					<tr>
						<td>付款行行号</td><td id="debtorbranchcode"></td>
						<td>收款行行号</td><td id="creditorbranchcode"></td>
					</tr>
					<tr>
						<td>业务种类编码</td><td id="purposeproprietary"></td>
						<td>票据号码</td><td id="billnumber"></td>
					</tr>
					<tr>
						<td>摘要</td><td id="summary" colspan="3"></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">通用处理信息</td>
					</tr>
					<tr>
						<td>通用处理报文标识号</td><td id="commsgid"></td>
						<td>通用处理应答状态</td><td id="comstatus"></td>
					</tr>
					<tr>
						<td>通用处理应答码</td><td id="comrejectcode"></td>
						<td>通用处理拒绝信息</td><td id="comrejectinformation"></td>
					</tr>
					<tr>
						<td>通用处理应答时间</td><td id="comdate"></td>
						<td></td><td></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">业务应答信息</td>
					</tr>
					<tr>
						<td>应答报文标识号</td><td id="rspmsgid"></td>
						<td>应答状态</td><td id="rspstatus"></td>
					</tr>
					<tr>
						<td>应答码</td><td id="rsprejectcode"></td>
						<td>业务拒绝信息</td><td id="rsprejectinformation"></td>
					</tr>
					<tr>
						<td>业务应答时间</td><td id="rspdate"></td>
						<td>轧差日期</td><td id="nettingdate"></td>
					</tr>
					<tr>
						<td>交易流水号</td><td id="txnseqno"></td>
						<td></td><td></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	
    <!--这是一个弹出窗口easyui-dialog，我在它里面放了一个datagrid-->  
    <div id="dlg" class="easyui-dialog" style="width: 1000px; height: auto; padding: 10px 20px"  
         data-options="closed:true,buttons:'#dlg-buttons'">  
        <table id="datagrid" class="easyui-datagrid" style="width:1600px;height:360px">  
            <thead>  
                <tr>  
                    <th field="accsecmerno" align="center" width="120" sortable="true">  
                        系统商户  
                    </th>  
                    <th field="payinst" align="center" width="120" sortable="true">  
                        通道号 
                    </th>  
                    <th field="chnlname" align="center" width="120" sortable="true">  
                        通道名称 
                    </th>  
                    <th field="payordno" align="center" width="80" sortable="true">  
                        通道订单号
                    </th>  
                    <th field="accfirmerno" align="center" width="80" sortable="true">  
                        渠道号  
                    </th> 
                     
  	             <th field="caname" align="center" width="120" sortable="true">  
                        渠道名称
                    </th>  
                    <th field="accordno" align="center" width="120" sortable="true">  
                        商户订单
                    </th>  
                    <th field="paysecmerno" align="center" width="120" sortable="true">  
                        外部商户号
                    </th>  
                    <th field="memberName" align="center" width="120" sortable="true">  
                        商户名称
                    </th>
                    <th field="retdatetime" align="center" width="120" sortable="true">  
                        交易时间
                    </th>  
                    <th field="retcode" align="center" width="80" sortable="true">  
                        交易状态 
                    </th>  
                    <th field="tradeelement" align="center" width="80" sortable="true">  
                        要素名称
                    </th>  
                    <th field="amount" align="center" width="60" sortable="true" >          
                        交易金额  
                    </th>
                    
                   <th field="txnfee" align="center" width="60" sortable="true">  
                        商户手续费
                    </th>  
                    <th field="txnfee-coopfee" align="center" width="60" sortable="true">  
                        渠道收益
                    </th>  
                    <th field="chnlfee" align="center" width="60" sortable="true">  
                        通道收益
                    </th>  
                    <th field="coopfee-chnlfee" align="center" width="60" sortable="true"
                      
                    >  
                        银联收益
                    </th>
                </tr>  
            </thead>  
        </table>  
    </div>  
    <div id="dlg-buttons">  
    	<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
    </div>  
    
	
</body>

<script>
	var width = $("#continer").width();
	$(function() {
		$('#test')
				.datagrid(
						{
							title : '商户统计列表',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'statistic/getMerchantByPage',
							remoteSort : false,
							idField : 'ORGAN_ID',
							columns : [ [
								
									{
										field : 'accsecmerno',
										title : '商户号',
										width : 120,
										align : 'center'
									},
									{
										field : 'memberName',
										title : '商户名称',
										width : 110,
										align : 'center'
									},
									{
										field : 'total',
										title : '交易笔数',
										width : 120,
										align : 'center'
									}, 
									{
										field : 'amount',
										title : '交易金额',
										width : 80,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.amount);
										}
									},
									{
										field : 'txnfee',
										title : '商户手续费 ',
										width : 90,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.txnfee);
										}
									},
									{
										field : 'TRANSTIME',
										title : '渠道收益',
										width : 90,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.txnfee-rec.coopfee);
										}
									},
									{
										field : 'chnlfee',
										title : '通道收益',
										width : 200,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.chnlfee);
										}
									},
									{
										field : 'DEBTORACCOUNTNO',
										title : '银联收益',
										width : 140,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.coopfee-rec.chnlfee);
										}
									},
								
									{
										field : 'id',
										title : '操作',
										width : 100,
										align : 'center',
									
										  formatter: function (value, rec,index) { //参数row表示当前行, 参数index表示当前行的索引值  
						                        //row.Id表示这个button按钮所在的那一行的Id这个字段的值  
						                        var btn = '<input type="button" id='+index+' value="查询详情"  onclick="return LoadUserInfo('+rec.accsecmerno+')"/>';  
						                        return btn;  
						                    } 
									} ] ],
							pagination : true,
							rownumbers : true,
							
							onClickRow: function (index, row) { 
								var accsecmerno= row["accsecmerno"];
								$('#detailInfo').datagrid({
									title:'批量代收明细表',
									
									height:400,
									singleSelect:true,
									nowrap: false,
									striped: true,
									url:'trade/getCollectOrderDetaByBatchNo?accsecmerno='+accsecmerno,	
									remoteSort: false,
									idField:'TID',
									columns:[
									[
										{field:'batchno',title:'批次号',width:180,align:'center'},
										{field:'orderid',title:'订单号',width:144,align:'center'},
										{field:'amt',title:'单笔金额(元)',width:146,align:'center',
											formatter:function(value,rec){
												return fenToYuan(rec.amt);
											}
										},
										{field:'currencycode',title:'交易币种',width:90,align:'center',
											formatter : function(value, rec) {
												if (rec.currencycode == "156") {
													return "人民币";
												} 
											}
										},
										 /* field:'DEBTORCONSIGN',title:'合同号',width:150,align:'center'}, */ 
										{field:'cardno',title:'交易卡号',width:148,align:'center'},
										{field:'customernm',title:'持卡人姓名',width:200,align:'center'},
										{field:'bankcode',title:'卡属银行号',width:100,align:'center'},
										{field:'cardtype',title:'卡属类型',width:152,align:'center',
											formatter : function(value, rec) {
												if (rec.cardtype == "1") {
													return "借记卡";
												} 
												if (rec.cardtype == "2") {
													return "信用卡";
												}
											}	
										},
										{field:'respcode',title:'响应码',width:100,align:'center'},
										{field:'respmsg',title:'应答信息',width:100,align:'center'},
										{field:'relatetradetxn',title:'交易序列号',width:158,align:'center'},
										{field:'status',title:'状态',width:159,align:'center',
											formatter : function(value, rec) {
												if (rec.status == "00") {
													return "交易完成";
												} 
												if (rec.status == "01") {
													return "订单提交成功";
												} 
												if (rec.status == "02") {
													return "交易中";
												} 
												if (rec.status == "03") {
													return "交易失败";
												} 
												if (rec.status == "04") {
													return "批次失效";
												} 
											}		
										},
									]],
									pagination:true,
									rownumbers:true,
								});
						}
						});

	});

	function search() {
		var data = {
			"accsecmerno" : $('#accsecmerno').val(),
			"retcode" : $('#retcode').val(),
			
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
		
	}

	function resize() {
		$('#theForm :input').val('');
	}


	function LoadUserInfo(accsecmerno) {

		var retcode = $('#retcode').val();
		var stime = $('#stime').datebox('getValue');
		var etime = $('#etime').datebox('getValue');

		/*获取选中行*/
		//var row = $('#Cse_Bespeak_Log').datagrid('getSelected'); //获取选中行    
		$("#datagrid").datagrid(
				{
					url : "statistic/getTnxLogInfoByMerno?accsecmerno="
							+ accsecmerno + "&retcode=" + retcode + "&stime="
							+ stime + "&etime=" + etime,
					iconCls : "icon-add",
					fitColumns : false,
					loadMsg : "数据加载中......",
					pagination : true,
					rownumbers : true,
					nowrap : false,
					showFooter : true,
					singleSelect : true,
					pageList : [ 100, 50, 20, 10 ],
				})

		$('#dlg').window('open'); //弹出这个dialog框  
	};
	function queryDetail(txnseqno) {
		$("#msgid").html("");
		$("#txid").html("");
		$("#transmitleg").html("");
		$("#receiver").html("");
		$("#transdate").html("");
		$("#transtime").html("");
		$("#debtorname").html("");
		$("#debtoraccountno").html("");
		$("#debtorbranchcode").html("");
		$("#creditorbranchcode").html("");
		$("#creditorname").html("");
		$("#creditoraccountno").html("");
		$("#amount").html("");
		$("#purposeproprietary").html("");
		$("#endtoendidentification").html("");
		$("#summary").html("");
		$("#billnumber").html("");
		$("#rspmsgid").html("");
		$("#rspstatus").html("");
		$("#rsprejectcode").html("");
		$("#rsprejectinformation").html("");
		$("#rspdate").html("");
		$("#nettingdate").html("");
		$("#commsgid").html("");
		$("#comstatus").html("");
		$("#comrejectcode").html("");
		$("#comrejectinformation").html("");
		$("#comdate").html("");
		$("#txnseqno").html("");
		$("#notes").html("");
		$("#remarks").html("");

		$.ajax({
			type : "POST",
			url : "statistic/getSingleById",
			data : "txnseqno=" + txnseqno,
			async : false,
			dataType : "json",
			success : function(json) {
				$("#user_code").val(json.userCode);
				$("#user_code").attr('readonly', 'readonly');
				$("#user_code").css('background-color', '#D2D2D2');
				$("#user_name").val(json.userName);
				$("#user_loginName").val(json.loginName);
				$("#user_organId").val(json.organId);
				$("#user_status").val(json.status);
				$("#user_isadmin").val(json.isadmin);
				$("#user_id").val(json.userId);
				$("#user_notes").val(json.notes);

			}
		});
		$('#w').window({
			title : '商户统计详细信息',
			top : 90,
			left : 100,
			width : 900,
			modal : true,
			minimizable : false,
			collapsible : false,
			maximizable : false,
			shadow : false,
			closed : false,
			height : 660
		});
		/* var rows = $('#test').datagrid('getSelected');
		$("#msgid").html(rows["MSGID"]);
		$("#txid").html(rows["TXID"]);
		$("#transmitleg").html(rows["TRANSMITLEG"]);
		$("#receiver").html(rows["RECEIVER"]);
		$("#tradetype").html(rows["TRADETYPE"]);
		$("#transdate").html(changeDate(rows["TRANSDATE"]));
		$("#transtime").html(changeTime(rows["TRANSTIME"]));
		$("#debtorname").html(rows["DEBTORNAME"]);
		$("#debtoraccountno").html(rows["DEBTORACCOUNTNO"]);
		$("#debtorbranchcode").html(rows["DEBTORBRANCHCODE"]);
		$("#creditorbranchcode").html(rows["CREDITORBRANCHCODE"]);
		$("#creditorname").html(rows["CREDITORNAME"]);
		$("#creditoraccountno").html(rows["CREDITORACCOUNTNO"]);
		$("#amount").html(fenToYuan(rows["AMOUNT"]));
		$("#purposeproprietary").html(rows["PURPOSEPROPRIETARY"]);
		$("#endtoendidentification").html(rows["ENDTOENDIDENTIFICATION"]);
		$("#summary").html(rows["SUMMARY"]);
		$("#billnumber").html(rows["BILLNUMBER"]);
		$("#rspmsgid").html(rows["RSPMSGID"]);
		$("#rspstatus").html(analysisStatus(rows["RSPSTATUS"]));
		$("#rsprejectcode").html(rows["RSPREJECTCODE"]);
		$("#rsprejectinformation").html(rows["RSPREJECTINFORMATION"]);
		$("#rspdate").html(changeDateTime(rows["RSPDATE"]));
		$("#nettingdate").html(changeDate(rows["NETTINGDATE"]));
		$("#commsgid").html(rows["COMMSGID"]);
		$("#comstatus").html(analysisStatus(rows["COMSTATUS"]));
		$("#comrejectcode").html(rows["COMREJECTCODE"]);
		$("#comrejectinformation").html(rows["COMREJECTINFORMATION"]);
		$("#comdate").html(changeDateTime(rows["COMDATE"]));
		$("#txnseqno").html(rows["TXNSEQNO"]);
		$("#notes").html(rows["NOTES"]);
		$("#remarks").html(rows["REMARKS"]); */
	}

	// 格式化日期时间
	function changeDateTime(value) {
		var dateString = value;
		if (dateString == null) {
			return "";
		} else {
			year = dateString.substring(0, 4);//0123
			month = dateString.substring(4, 6);//45
			day = dateString.substring(6, 8);//67
			hour = dateString.substring(8, 10);//89
			minte = dateString.substring(10, 12);//10 11
			s = dateString.substring(12, 14);// 11 12
			return year + "-" + month + "-" + day + " " + hour + ":" + minte
					+ ":" + s;
		}
	}
	// 格式化日期
	function changeDate(value) {
		var dateString = value;
		if (dateString == null) {
			return "";
		} else {
			year = dateString.substring(0, 4);//0123
			month = dateString.substring(4, 6);//45
			day = dateString.substring(6, 8);//67
			return year + "-" + month + "-" + day;
		}
	}
	// 格式化时间
	function changeTime(value) {
		var dateString = value;
		if (dateString == null) {
			return "";
		} else {
			hour = dateString.substring(0, 2);
			minte = dateString.substring(2, 4);
			s = dateString.substring(4, 6);
			return hour + ":" + minte + ":" + s;
		}
	}
	// 解析状态
	function analysisStatus(value) {
		if (value == "PR05") {
			return "已成功";
		}
		if (value == "PR09") {
			return "已拒绝";
		}
		if (value == "PR32") {
			return "逾期退回";
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
	function closeAdd() {
		$('#dlg').window('close');
	}
</script>
</html>
