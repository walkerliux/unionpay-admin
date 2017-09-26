<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style type="text/css">
.left, .mid, .right {
	width: auto;
	float: left;
}

.form-control {
	border: 2px solid #A9C9E2;
}

.mid {
	padding-top: 45px;
	padding-left: 12px;
	padding-right: 12px;
}
</style>
<body>
	<style type="text/css">
table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
	padding-left: 10px;
}
table tr td.update {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
table tr td.add {
	height: 25px;
}

table tr td input {
	height: 15px
}

table tr td select {
	height: 20px
}
</style>
	<div style="padding-top: 5px; margin-left: 5px; margin-right: 5px" id="continer">
		<div id="p" class="easyui-panel" title="查询条件" style="height: 130px;background: #fafafa;" iconCls="icon-save" collapsible="true">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td class="add" align="right" width="18%">委托机构号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_merchNo" name="merchNo" /></td>
						<td class="add" align="right" width="18%">合同编号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_contractNum" name="contractNum" /></td>
					</tr>
					<tr>
						<td class="add" align="right">付款人名称</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_debName" name="debName" /></td>
						<td class="add" align="right">付款人账号</td>
						<td class="add" align="left" style="padding-left: 5px">
							<input id="a_debAccNo" name="debAccNo" /></td>
					</tr>
					<tr>
						<td class="add" align="right">收款人名称</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_credName" name="credName" /></td>
						<td class="add" align="right">收款人账号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_credAccNo" name="credAccNo" /></td>
						<td class="add" align="right" colspan="3"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a> <a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a></td>
							<td class="add" align="right"></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="bankList">
			</table>
		</div>
	</div>
	<div id="w2" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 10px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<form id="saveForm" action="paytongContract/auditContract" method="post">
					<input type="hidden" id="b_tId" name="tid"/> 
					<input type="hidden" id="isagree" name="isagree"/> 
					
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title">一、委托机构基本信息</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="18%">委托机构号</td>
							<td class="update" align="left" width="30%">
								<span id="b_merchNo"></span>
							</td>
							<td class="update" width="18%">委托机构名称 </td>
							<td class="update" align="left" width="30%">
								<span id="b_merchName"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="18%">合同编号 </td>
							<td class="update" align="left">
								<span id="b_contractNum"></span>
							</td>
							<td class="update">合同类型</td>
							<td class="update" align="left">
								<span id="b_contractType"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="18%">业务联系人</td>
							<td class="update" align="left">
								<span id="contacts_people"></span>
							</td>
							<td class="update" width="18%">联系电话 </td>
							<td class="update" align="left">
								<span id="contacts_tel_no"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">合同开始日期</td>
							<td class="update" align="left">
								<span id="signdate"></span>
							</td>
							<td class="update">合同终止日期</td>
							<td class="update" align="left">
								<span id="expirydate"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="18%">第三方合同编号 </td>
							<td class="update" align="left">
								<span id="thirdcontractnum"></span>
							</td>
							<td class="update"></td>
							<td class="update" align="left">
								
							</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">二、付款账户信息</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">开户银行</td>
							<td class="update" align="left" colspan="3">
								
								<span id="banknode_debtor_value"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款人名称</td>
							<td align="left" class="update"><span id="b_debName"></span></td>
							<td class="update">付款人账号 </td>
							<td align="left" class="update"><span id="b_debAccNo"></span></td>
						</tr>
						
						<tbody id="cred_tbody">
							<tr>
								<td colspan="4" class="head-title">三、收款账户信息</td>
							</tr>
							<tr style="height: 30px">
								<td class="update">开户银行</td>
								<td class="update" align="left" colspan="3">
									<span id="banknode_cred_value"></span>
								</td>
							</tr>
							<tr style="height: 30px">
								<td class="update">银行账号 </td>
								<td class="update" align="left">
									<span id="creditoraccountno" ></span>
								</td>
								<td class="update">账户名称</td>
								<td class="update" align="left">
									<span id="creditorname"></span>
								</td>
								
							</tr>
						</tbody>
						<tr>
							<td colspan="4" class="head-title">风控规则</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款金额限制类型</td>
							<td class="update" align="left">
								<span id="debTranLimitType"></span>
							</td>
							<td class="update">累计付款金额上限(元)</td>
							<td class="update" align="left">
								<span id="debAccyAmoLimit"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款次数限制类型</td>
							<td class="update" align="left">
								<span id="debTransLimitType"></span>
							</td>
							<td class="update">付款次数限制</td>
							<td class="update" align="left">
								<span id="debTransLimit"></span>
							</td>
						</tr>
						<tr style="height:30px">
							<td class="update">单笔付款金额上限 (元) </td>
							<td class="update" align="left" colspan="3">
								<span id="debAmoLimit"></span>
							</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						
						<tr style="height: 30px">
							<td class="update">收款金额限制类型</td>
							<td class="update" align="left">
								<span id="credTranLimitType"></span>
							</td>
							<td class="update">累计收款金额上限 (元)</td>
							<td class="update" align="left">
								<span id="credAccuAmoLimit"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款次数限制类型</td>
							<td class="update" align="left">
								<span id="credTransLimitType"></span>
							</td>
							<td class="update">收款次数限制</td>
							<td class="update" align="left">
								<span id="credTransLimit"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">单笔收款金额上限 (元)</td>
							<td class="update" align="left" colspan="3">
								<span id="credAmoLimit"></span>
							</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">人行渠道数据</td>
						</tr>
						
						<tr style="height: 30px">
							<td class="update">发送方代码</td>
							<td class="update" align="left">
								<input type="text" id="senderCode" name="sendercode" class="easyui-validatebox" maxlength="32" missingMessage="请输入发送方代码"/>
							</td>
							<td class="update">业务种类</td>
							<td class="update" align="left">
								<input type="text" id="proprietary" name="proprietary" class="easyui-validatebox" maxlength="10" missingMessage="请输入业务种类"/>
							</td>
						</tr>
						<tbody id="colletcion">
							<tr style="height: 30px">
								<td class="update">渠道合同号</td>
								<td class="update" align="left">
									<input type="text" id="chargeConntract" name="chargecontract" class="easyui-validatebox" maxlength="60" missingMessage="请输入渠道合同号"/>
								</td>
								<td class="update" id="batch_td1">收费代码</td>
								<td class="update" align="left" id="batch_td2">
									<input type="text" id="chargeno" name="chargeno" class="easyui-validatebox" maxlength="20" missingMessage="请输入收费代码"/>
								</td>
							</tr>
						</tbody>
						<tbody id="payment">
							<tr style="height: 30px">
								<td class="update">渠道合同号</td>
								<td class="update" align="left">
									<input type="text" id="payContract" name="paycontract" class="easyui-validatebox" maxlength="60" missingMessage="请输入付费协议号"/></td>
								<td class="update"></td>
								<td class="update" align="left">
								</td>
							</tr>
						</tbody>
						
						
						
						
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						
						<tr style="height: 30px">
							<td class="update">备注</td>
							<td align="left" colspan="3" class="update"><span id="b_notes" rows="3" cols="81" style="resize: none;"></span></td>
						</tr>
						<tr>
							<td class="update" >审核意见</td>
							<td class="update" colspan="3" >
							<textarea rows="5" cols="100" style="margin: 5px" maxlength="256" id="b_cvlexaOpt" name="cvlexaopt"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a href="javascript:merchAudit('0');" id="button_ins1" class="easyui-linkbutton" iconCls="icon-ok">通过</a>
				<a href="javascript:merchAudit('1');" id="button_ins3" class="easyui-linkbutton" iconCls="icon-no">不通过</a>
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
</body>
</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			$('#bankList').datagrid({
				title:'合同列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'paytongContract/queryContractAudit',
				remoteSort: false,
				columns:[[
					{field:'MERCHNO',title:'委托机构号',align:'center',width:130},
					{field:'CONTRACTNUM',title:'合同编号',width:220,align:'center'},
					{field:'DEBTORNAME',title:'付款人名称',align:'center',width:200},
					{field:'CREDITORNAME',title:'收款人名称',width:200,align:'center'},
					{field:'CONTRACTTYPE',title:'合同类型',width:100,align:'center',
						formatter:function(value,rec){
							if(value=="CT00"){
								return "批量代收协议";
							}else if(value=="CT01"){
								return "批量代付协议";
							}else if(value=="CT02"){
								return "实时代收协议";
							}else if(value=="CT03"){
								return "实时代付协议";
							}
						}
					},
					{field:'STATUS',title:'状态',width:60,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "有效";
							}else if(value=="02"){
								return "待生效";
							}else if(value=="10" || value=="20"){
								return "待审";
							}else if(value=="19" || value=="29"){
								return "审核未通过";
							}else if(value=="89"){
								return "过期失效";
							}else if(value=="99"){
								return "撤销";
							}
						}
					},
					{field:'TID',title:'操作',align:'center',width:160,
						formatter:function(value,rec){
							if(rec.STATUS=="00"){
								return '<a href="javascript:deleteUser('+value+')" style="color:blue;margin-left:10px">注销</a>'+
								'<a href="javascript:findById('+value+')" style="color:blue;margin-left:10px">详情</a>'
							}else if(rec.STATUS=="10" || rec.STATUS=='20'){
								return '<a href="javascript:findById('+value+')" style="color:blue;margin-left:10px">审核</a>';
							}
						}}
					]],
				pagination:true,
				rownumbers:true
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function closeAdd(){
			$('#w').window('close');
			$('#w2').window('close');
			$('#w3').window('close');
			
		}		
		function search(){
			var data={'merchNo':$('#a_merchNo').val(),'contractNum':$('#a_contractNum').val(),
					'debName':$("#a_debName").val(),'credName':$("#a_credName").val(),
					'debAccNo':$("#a_debAccNo").val(),'credAccNo':$("#a_credAccNo").val()};
			$('#bankList').datagrid('load',data);
		}
		function findById(tId){
			 $("#b_cvlexaOpt").val('');
			$.ajax({
			   type: "POST",
			   url: "paytongContract/getContract",
			   data: "tid="+tId,
			   dataType:"json",
			   success: function(json){
				   var tId = json.tId;
				   $("#b_tId").val(json.TID);
				   $("#b_merchNo").html(json.MERCHNO);
				   $("#b_merchName").html(json.ENTERPRISE_NAME);
				   $("#b_contractNum").html(json.CONTRACTNUM);
				   
				   $("#contacts_people").html(json.CONTACT);
				   $("#contacts_tel_no").html(json.CONT_PHONE);
				   $("#signdate").html(json.SIGNDATE);
				   $("#expirydate").html(json.EXPIRYDATE);
				   $("#thirdcontractnum").html(json.THIRDCONTRACTNUM);
				   $("#banknode_debtor_value").html(json.DEBTORBRANCHNAME);
				   $("#b_debName").html(json.DEBTORNAME);
				   $("#b_debAccNo").html(json.DEBTORACCOUNTNO);
				   var contractType;
				   if(json.CONTRACTTYPE == 'CT00'){
					   contractType = '批量代收协议';
					   $("#cred_tbody").show();
					   $("#colletcion").show();
					   $("#batch_td1,#batch_td2").show();
					   $("#payment").hide();
				   }else if(json.CONTRACTTYPE == 'CT01'){
					   contractType = '批量代付协议';
					   $("#cred_tbody").hide();
					   $("#colletcion").hide();
					   $("#batch_td1,#batch_td2").hide();
					   $("#payment").show();
					   
				   }else if(json.CONTRACTTYPE == 'CT02'){
					   contractType = '实时代收协议';
					   $("#cred_tbody").show();
					   $("#colletcion").show();
					   $("#batch_td1,#batch_td2").hide();
					   $("#payment").hide();
				   }else if(json.CONTRACTTYPE == 'CT03'){
					   contractType = '实时代付协议';
					   $("#cred_tbody").hide();
					   $("#colletcion").hide();
					   $("#batch_td1,#batch_td2").hide();
					   $("#payment").show();
				   }
				   $("#b_contractType").html(contractType);
				   $("#b_contractType").val(json.CONTRACTTYPE);
				   
				   $("#creditorname").html(json.CREDITORNAME);
				   $("#creditoraccountno").html(json.CREDITORACCOUNTNO);
				   $("#banknode_cred_value").html(json.CREDITORBRANCHNAME);
				   
				   
				   
				   

				  // 
				  // debTransLimitType
				  // debTransLimit
				   $("#debAmoLimit").html(fenToYuan(json.DEBTORAMOUNTLIMIT));
 				   var debTranLimitType;
				   if(json.CREDITORTRANSAMTLIMITTYPE == '00'){
					   debTranLimitType = '--不限--';
				   }else if(json.CREDITORTRANSAMTLIMITTYPE == '01'){
					   debTranLimitType = '按年限额';
				   }else if(json.CREDITORTRANSAMTLIMITTYPE == '02'){
					   debTranLimitType = '按月限额';
				   }else if(json.CREDITORTRANSAMTLIMITTYPE == '03'){
					   debTranLimitType = '总计限额';
				   }else if(json.CREDITORTRANSAMTLIMITTYPE == '04'){
					   debTranLimitType = '总计限额';
				   }
				   $("#debTranLimitType").html(debTranLimitType);
				   $("#debAccyAmoLimit").html(json.DEBTORACCUAMOUNTLIMIT);
				   var debTransLimitType;
				   if(json.DEBTORTRANSNUMLIMITTYPE == '00'){
					   debTransLimitType = '--不限--';
				   }else if(json.DEBTORTRANSNUMLIMITTYPE == '01'){
					   debTransLimitType = '按年限次';
				   }else if(json.DEBTORTRANSNUMLIMITTYPE == '02'){
					   debTransLimitType = '按月限次';
				   }else if(json.DEBTORTRANSNUMLIMITTYPE == '03'){
					   debTransLimitType = '总计限次';
				   }
				   $("#debTransLimitType").html(debTransLimitType);
				   $("#debAccyAmoLimit").html(fenToYuan(json.DEBTORACCUAMOUNTLIMIT));
				   $('#debTransLimit').html(json.DEBTORTRANSLIMIT)
				   
				   
				   
				  //$("#credTranLimitType").html(fenToYuan(json.CREDITORAMOUNTLIMIT));
				   var credTranLimitType;
				   if(json.CREDITORTRANSAMTLIMITTYPE == '00'){
					   credTranLimitType = '--不限--';
				   }else if(json.CREDITORTRANSAMTLIMITTYPE == '01'){
					   credTranLimitType = '按年限次';
				   }else if(json.CREDITORTRANSAMTLIMITTYPE == '02'){
					   credTranLimitType = '按月限次';
				   }else if(json.CREDITORTRANSAMTLIMITTYPE == '03'){
					   credTranLimitType = '总计限次';
				   }else if(json.CREDITORTRANSAMTLIMITTYPE == '04'){
					   credTranLimitType = '总计限额';
				   }
				   $("#credTranLimitType").html(credTranLimitType);
				   $("#credAccuAmoLimit").html(fenToYuan(json.CREDITORACCUAMOUNTLIMIT));
				   var credTransLimitType;
				   if(json.CREDITORTRANSNUMLIMITTYPE == '00'){
					   credTransLimitType = '--不限--';
				   }else if(json.CREDITORTRANSNUMLIMITTYPE == '01'){
					   credTransLimitType = '按年限次';
				   }else if(json.CREDITORTRANSNUMLIMITTYPE == '02'){
					   credTransLimitType = '按月限次';
				   }else if(json.CREDITORTRANSNUMLIMITTYPE == '03'){
					   credTransLimitType = '总计限次';
				   }
				   $("#credTransLimitType").html(credTransLimitType);
				   $("#credTransLimit").html(json.CREDITORTRANSLIMIT);
				   $("#credAmoLimit").html(fenToYuan(json.CREDITORAMOUNTLIMIT));
				   $("#b_notes").html(json.notes);
				  
				  
				  
			   }
			});
			$('#w2').window({
				title: '宜赋通合同详情',
				left:200,
				top:30,
				width: 960,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 790
			});
		}

		
		
		function merchAudit(result) {
			
			$("#isagree").val(result);
			$('#saveForm').form('submit', {  
			    onSubmit: function(){  
			    	if($('#saveForm').form('validate')){
			    		$("#button_ins1").linkbutton('disable');
						$("#button_ins3").linkbutton('disable');
			    		return true;   
				    }
			    	
			        return false;   
			    }, 
			    success:function(json){
			    	
			    	$("#button_ins1").linkbutton('enable');
					$("#button_ins3").linkbutton('enable');
			    	json = eval('(' + json + ')');
					if(json.RET == "succ"){
						 $.messager.alert('提示', json.INFO);
						 search();
						 closeAdd();
					}else{
						 $.messager.alert("提示",json.INFO);
					}
			    }
			});  
			
			
			/* var tId = $("#b_tId").val();
			var stexaOpt = $("#b_cvlexaOpt").val();
			$.ajax({
				type: "POST",
				url: "contract/auditContract?isagree=" + result + "&tid=" + tId,
				data: "stexaOpt=" + encodeURI(stexaOpt),
				dataType: "json",
				success: function(json) {
			    	$.each(json, function(key,value){
			    		if(value.RET == "succ"){
		    				$.messager.alert('提示',"操作成功!");
			    			search();
				    		closeAdd();
				    	}else{
				    		$.messager.alert('提示',value.INFO); 
				    		search();
				    		closeAdd();
				    	}
			    		$("#button_ins1").linkbutton('enable');
						$("#button_ins3").linkbutton('enable');		
					}) 
				}
			}); */
		}
		
		function fenToYuan(value){
			if(value == null){
				return "0.00";
			}
			var str = (value/100).toFixed(2) + '';
			var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
			var dot = str.substring(str.length,str.indexOf("."))
			var ret = intSum + dot;
			return ret;
		}
	</script>
</html>
