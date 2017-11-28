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
						<td align="right" width="10%">月/日报表</td>
						<td align="left" style="padding-left: 5px" width="15%">
						<select name="dayormonth"
							id="dayormonth" style="width: 150px">
								<option value="00">日报</option>
								<option value="01">月报</option>
						</select></td>
					</tr>
				
					<tr> 
						 <td align="right" width="15%">开始时间</td>
						<td align="left" style="padding-left: 5px" width="25%">
							<input id="stime" name="stime" type="text"
							style="width: 120PX" class="easyui-datebox" data-options="showSeconds:true" ></input> 
						</td> 
						 <td align="right" width="15%">截止时间</td>
						 <td align="left" style="padding-left: 5px" width="25%">
						 	<input id="etime" name="etime" type="text"
							style="width: 120PX" class="easyui-datebox" data-options="showSeconds:true" ></input> 
						<td></td>
						<td align="right" width="10%"></td>
						
						<td align="right">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
						
						
						
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
	var sid=
	$(function() {
		$('#test')
				.datagrid(
						{//
							title : '<a href="" id="down1" onclick="downExcel()">下载excel</a>',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'report/getMerchDayCountByPage',
							remoteSort : false,
							idField : 'ORGAN_ID',
							columns : [ [
								
									{
										field : 'txndate',
										title : '交易日期',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {
											return subString(rec.txndate);
										}
									},
									{
										field : 'accsecmerno',
										title : '商户编号',
										width : 110,
										align : 'center'
									},
									{
										field : 'memberName',
										title : '商户名称',
										width : 110,
										align : 'center'
									},
									{
										field : 'chnlname',
										title : '通道',
										width : 160,
										align : 'center'
									},
									{
										field : 'payinst',
										title : '通道编号',
										width : 90,
										align : 'center'
									},
									{
										field : 'total',
										title : '总交易笔数',
										width : 90,
										align : 'center'
									},
									{
										field : 'amount',
										title : '总交易金额',
										width : 80,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.amount);
										}
									},
									{
										field : 'txnfee',
										title : '总交易手续费 ',
										width : 90,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.txnfee);
										}
									},
									{
										field : 'TRANSTIME',
										title : '实际结算金额',
										width : 90,
										align : 'center',
										formatter : function(value, rec) {
											return fenToYuan(rec.amount-rec.txnfee);
										}
									},
									{
										field : 'id',
										title : '操作',
										width : 100,
										align : 'center',
										formatter: function (value, rec,index) { //参数row表示当前行, 参数index表示当前行的索引值  
						                        //row.Id表示这个button按钮所在的那一行的Id这个字段的值  
						                        //var btn = '<input type="button" id='+index+' value="查询详情"  onclick="return LoadUserInfo('+rec.accsecmerno+')"/>';  
						                        return "点击查询详情";  
						                    } 
									}] ],
							pagination : true,
							rownumbers : true,
							
							onClickRow: function (index, row) { 
								var accsecmer= row["accsecmerno"];
								var txndate= subString(row["txndate"]);
								var dayormonth = $('#dayormonth').val();
								var stime = $('#stime').datebox('getValue');
								var etime = $('#etime').datebox('getValue');
								//;
								$('#detailInfo').datagrid({
									//title : '<a href="" id="down2" onclick="downInfo()">明细下载</a>',
									
									title : '<a href="report/downloadmerchExcelInfo?accsecmerno='+accsecmer+'&txndate='+txndate+'">明细下载</a>',
									height:400,
									singleSelect:true,
									nowrap: false,
									striped: true,
									url:"report/getMerDayCountInfo?accsecmerno="
										+ accsecmer + "&txndate="
										+ txndate,
									remoteSort: false,
									idField:'TID',
									columns:[
									[
										{field:'txnseqno',title:'交易序列号',width:160,align:'center'},
										{field:'caname',title:'渠道',width:120,align:'center'},
										{field:'chnlname',title:'通道',width:120,align:'center'},
										{field:'accsecmerno',title:'商户号',width:120,align:'center'},
										{field:'memberName',title:'商户名称',width:120,align:'center'},
										{field:'pan',title:'交易卡号',width:140,align:'center',},
										{field:'panName',title:'姓名',width:90,align:'center'},
										{field:'amount',title:'交易金额',width:90,align:'center',
											formatter : function(value, rec) {
												return fenToYuan(rec.amount);
											}
										},
										{field:'txnfee',title:'交易手续费',width:100,align:'center',
											formatter : function(value, rec) {
												return fenToYuan(rec.txnfee);
											}
										},
										{field:'id',title:'结算金额',width:90,align:'center',
											formatter : function(value, rec) {
												return fenToYuan(rec.amount-rec.txnfee);
											}
										},
										{field:'txndate',title:'交易时间',width:100,align:'center'}
										
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
			"dayormonth" : $('#dayormonth').val(),
			
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
		
	}

	function resize() {
		$('#theForm :input').val('');
	}


	function LoadUserInfo(accsecmerno) {

		var dayormonth = $('#dayormonth').val();
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
		$.ajax({
			type : "POST",
			url : "statistic/getSingleById",
			data : "txnseqno=" + txnseqno,
			async : false,
			dataType : "json",
			success : function(json) {
				 if(json!=null){
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
			},
			error : function(){
				$.messager.alert('提示', '服务异常！');
			}
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
	//月报截取日期前六位dayormonth
	function subString(value){
		var dayormonth = $('#dayormonth').val();
		//alert(dayormonth);
		 if(dayormonth==""){
			return value;
		} 
		if(dayormonth=="00"){
			return value;
		}
		if(dayormonth=="01"){
			return value.substring(0,6);
		}
	}
	
	function closeAdd() {
		$('#dlg').window('close');
	}
	function downExcel(){
		var accsecmerno= $('#accsecmerno').val();
		var dayormonth=$('#dayormonth').val();
		var stime=$('#stime').datebox('getValue');
		var etime= $('#etime').datebox('getValue');
		
		document.getElementById("down1").href="report/downloadmerchExcel?accsecmerno="+accsecmerno+"&dayormonth="+dayormonth+"&stime="+stime+"&etime="+etime;
	
		
	}
	/* function downInfo(){
		var accsecmer= rows["accsecmerno"];
		alert(accsecmer);
		var txndate= subString(rows["txndate"]);
		document.getElementById("down2").href="report/downloadmerchExcelInfo?accsecmerno="+accsecmer+"&txndate="+txndate;
	} */
</script>
</html>
