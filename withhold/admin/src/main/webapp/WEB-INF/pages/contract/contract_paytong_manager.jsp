<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript"
	src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>
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
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 130px; padding-top: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
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
	<div id="w" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 600px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding:10px 5px; background: #fff; border: 1px solid #ccc;">
				<form id="saveForm" action="paytongContract/saveContract" method="post">
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title">一、委托机构基本信息</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="15%">委托机构号</td>
							<td class="update" align="left" width="35%">
								<input type="text" id="merchNo" name="merchno" class="easyui-validatebox" required="true" maxlength="15" missingMessage="请输入委托机构号" validType="merchno" onblur="showMerch()"/>
							</td>
							<td class="update" width="15%">委托机构名称 </td>
							<td class="update" align="left" width="35%">
								<input type="text" id="merchName" readonly="readonly"/>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="18%">合同编号 </td>
							<td class="update" align="left">
								<input type="text" id="contractNum" name="contractnum" readonly="readonly" style="width:220px"/>
							</td>
							<td class="update">合同类型</td>
							<td class="update" align="left">
								<select id="contractType" class="easyui-validatebox" missingMessage="请选择合同类型"
									required="true" name="contracttype" onchange="changeContractType()">
										<option value=''>--请选择合同类型--</option>
										<option value='CT00'>批量代收协议</option>
										<option value='CT01'>批量代付协议</option>
										<option value='CT02'>实时代收协议</option>
										<option value='CT03'>实时代付协议</option>
								</select>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="18%">业务联系人</td>
							<td class="update" align="left">
								<input type="text" id="contacts_people" readonly="readonly"/>
							</td>
							<td class="update" width="18%">联系电话 </td>
							<td class="update" align="left">
								<input type="text" id="contacts_tel_no" readonly="readonly"/>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">合同开始日期</td>
							<td class="update" align="left">
								<input type="text" class="easyui-datebox" name="signdate" id="signdate" required="true" missingMessage="请输入合同开始日期"/>
							</td>
							<td class="update">合同终止日期</td>
							<td class="update" align="left">
								<input type="text" class="easyui-datebox" name="expirydate"  id="expirydate" required="true" missingMessage="请输入合同终止日期"/>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="18%">第三方合同编号 </td>
							<td class="update" align="left">
								<input type="text" id="thirdcontractnum" name="thirdcontractnum" class="easyui-validatebox" maxlength="60" missingMessage="请输入第三方合同编号" style="width:220px" required="true"/>
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
								<input class="easyui-combobox" id="banknode_ins" />
								<input type="hidden" name="debtorbranchcode" id="banknode_debtor_value"/>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">银行账号 </td>
							<td class="update" align="left">
								<input type="text" id="debtoraccountno" name="debtoraccountno" class="easyui-validatebox" required="true" maxlength="20" missingMessage="请输入付款人账号" validType="bankcard"/>
							</td>
							<td class="update">账户名称</td>
							<td class="update" align="left">
								<input type="text" name="debtorname" required="true" maxlength="15"  missingMessage="请输入付款人名称" class="easyui-validatebox" validType="debName"/>
							</td>
							
						</tr>
						<tbody id="cred_tbody">
							<tr>
								<td colspan="4" class="head-title">三、收款账户信息</td>
							</tr>
							<tr style="height: 30px">
								<td class="update">开户银行</td>
								<td class="update" align="left" colspan="3">
									<input class="easyui-combobox" id="banknode_cred" name="" />
									<input type="hidden" name="creditorbranchcode" id="banknode_cred_value"/>
								</td>
							</tr>
							<tr style="height: 30px">
								<td class="update">银行账号 </td>
								<td class="update" align="left">
									<input type="text" id="credAccNo" name="creditoraccountno" class="easyui-validatebox" required="true" maxlength="20" missingMessage="请输入收款人账号" validType="bankcard"/>
								</td>
								<td class="update">账户名称</td>
								<td class="update" align="left">
									<input type="text" id="credName" name="creditorname" class="easyui-validatebox" required="true" maxlength="12" missingMessage="请输入收款人名称" class="easyui-validatebox" validType="debName"/>
								</td>
								
							</tr>
						</tbody>
						<tr>
							<td colspan="4" class="head-title">风控规则</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款金额限制类型</td>
							<td class="update" align="left">
							<select id="debTranLimitType" class="easyui-validatebox" missingMessage="请选择类型"
								 name="debtortransamtlimittype">
									<option value='00'>--不限--</option>
									<option value='01'>按年限额</option>
									<option value='02'>按月限额</option>
									<option value='04' selected>按日限额</option>
									<option value='03'>总计限额</option>
							</select></td>
							<td class="update">累计付款金额上限</td>
							<td class="update" align="left">
							<input type="text" id="debAccyAmoLimit" name="debtoraccuamountlimit" class="easyui-validatebox"
								maxlength="10" missingMessage="请输入累计上限金额(元)" validType="amount"/>(元)
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款次数限制类型</td>
							<td class="update" align="left">
							<select id="debTransLimitType" class="easyui-validatebox" missingMessage="请选择类型" name="debtortransnumlimittype">
									<option value='00'>--不限--</option>
									<option value='01'>按年限次</option>
									<option value='02'>按月限次</option>
									<option value='03'>总计限次</option>
							</select></td>
							<td class="update">付款次数限制</td>
							<td class="update" align="left">
							<input type="text" id="debTransLimit" name="debtortranslimit" class="easyui-validatebox" 
								maxlength="10" missingMessage="请输入限制次数" /></td>
						</tr>
						<tr style="height:30px">
							<td class="update">单笔付款金额上限 </td>
							<td class="update" align="left"  colspan="3">
							<input type="text" id="debAmoLimit" name="debtoramountlimit" class="easyui-validatebox"
								maxlength="10" missingMessage="请输入单笔上限金额(元)" validType="amount"/>(元)</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						
						<tr style="height: 30px">
							<td class="update">收款金额限制类型</td>
							<td class="update" align="left">
								<select id="credTranLimitType" class="easyui-validatebox" missingMessage="请选择类型"
									name="creditortransamtlimittype">
										<option value='00'>--不限--</option>
										<option value='01'>按年限额</option>
										<option value='02'>按月限额</option>
										<option value='04' selected>按日限额</option>
										<option value='03'>总计限额</option>
								</select>
							</td>
							<td class="update">累计收款金额上限</td>
							<td class="update" align="left">
								<input type="text" id="credAccuAmoLimit" name="creditoraccuamountlimit" class="easyui-validatebox" maxlength="10" missingMessage="请输入累计上限金额(元)" validType="amount" />(元)
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款次数限制类型</td>
							<td class="update" align="left">
							<select id="credTransLimitType" class="easyui-validatebox" missingMessage="请选择类型" name="creditortransnumlimittype">
									<option value='00'>--不限--</option>
									<option value='01'>按年限次</option>
									<option value='02'>按月限次</option>
									<option value='03'>总计限次</option>
							</select></td>
							<td class="update">收款次数限制</td>
							<td class="update" align="left">
								<input type="text" id="credTransLimit" name="creditortranslimit"  
								class="easyui-validatebox" maxlength="10" missingMessage="请输入限制次数"/>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">单笔收款金额上限 </td>
							<td class="update" align="left" colspan="3">
							<input type="text" id="credAmoLimit" name="creditoramountlimit" class="easyui-validatebox"
								maxlength="10" missingMessage="请输入单笔上限金额(元)" validType="amount"/>(元)</td>
						</tr>
						
						<tr style="height: 30px">
							<td class="update">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="115" id="notes" maxlength="64" name="notes" style="margin:5px"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveContract()" id="btn_submit">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
	
	<div id="w2" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 10px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<form id="saveForm" action="paytongContract/auditContract" method="post">
					
					
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title">一、委托机构基本信息</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="15%">委托机构号</td>
							<td class="update" align="left" width="35%">
								<span id="b_merchNo"></span>
							</td>
							<td class="update" width="15%">委托机构名称 </td>
							<td class="update" align="left" width="35%">
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
								<span id="b_contacts_people"></span>
							</td>
							<td class="update" width="18%">联系电话 </td>
							<td class="update" align="left">
								<span id="b_contacts_tel_no"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">合同开始日期</td>
							<td class="update" align="left">
								<span id="b_signdate"></span>
							</td>
							<td class="update">合同终止日期</td>
							<td class="update" align="left">
								<span id="b_expirydate"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="18%">第三方合同编号 </td>
							<td class="update" align="left">
								<span id="b_thirdcontractnum"></span>
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
								
								<span id="b_banknode_debtor_value"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款人名称</td>
							<td align="left" class="update"><span id="b_debName"></span></td>
							<td class="update">付款人账号 </td>
							<td align="left" class="update"><span id="b_debAccNo"></span></td>
						</tr>
						
						<tbody id="cred_tbody_info">
							<tr>
								<td colspan="4" class="head-title">三、收款账户信息</td>
							</tr>
							<tr style="height: 30px">
								<td class="update">开户银行</td>
								<td class="update" align="left" colspan="3">
									<span id="b_banknode_cred_value"></span>
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
							<td colspan="4" class="head-title">风控规则-付款方</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款金额限制类型</td>
							<td class="update" align="left">
								<span id="b_debTranLimitType"></span>
							</td>
							<td class="update">累计付款金额上限 (元)</td>
							<td class="update" align="left">
								<span id="b_debAccyAmoLimit"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款次数限制类型</td>
							<td class="update" align="left">
								<span id="b_debTransLimitType"></span>
							</td>
							<td class="update">付款次数限制</td>
							<td class="update" align="left">
								<span id="b_debTransLimit"></span>
							</td>
						</tr>
						<tr style="height:30px">
							<td class="update">单笔付款金额上限 (元) </td>
							<td class="update" align="left" colspan="3">
								<span id="b_debAmoLimit"></span>
							</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">风控规则-收款方</td>
						</tr>
						
						<tr style="height: 30px">
							<td class="update">收款金额限制类型</td>
							<td class="update" align="left">
								<span id="b_credTranLimitType"></span>
							</td>
							<td class="update">累计收款金额上限 (元)</td>
							<td class="update" align="left">
								<span id="b_credAccuAmoLimit"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款次数限制类型</td>
							<td class="update" align="left">
								<span id="b_credTransLimitType"></span>
							</td>
							<td class="update">收款次数限制</td>
							<td class="update" align="left">
								<span id="b_credTransLimit"></span>
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update">单笔收款金额上限 (元) </td>
							<td class="update" align="left" colspan="3">
								<span id="b_credAmoLimit"></span>
							</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">人行渠道数据</td>
						</tr>
						
						<tr style="height: 30px">
							<td class="update">发送方代码</td>
							<td class="update" align="left">
								<span id="b_senderCode"></span>
								
							</td>
							<td class="update">业务种类</td>
							<td class="update" align="left">
								<span id="b_proprietary" ></span>
							</td>
						</tr>
						<tbody id="colletcion">
							<tr style="height: 30px">
								<td class="update">渠道合同号</td>
								<td class="update" align="left">
									<span id="b_chargeConntract"></span>
								</td>
								<td class="update" id="batch_td1">收费代码</td>
								<td class="update" align="left" id="batch_td2">
									<span id="b_chargeNo"></span>
								</td>
							</tr>
						</tbody>
						<tbody id="payment">
							<tr style="height: 30px">
								<td class="update">渠道合同号</td>
								<td class="update" align="left">
									<span id="b_payContract"></span>
								</td>
								<td class="update"></td>
								<td class="update" align="left">
								</td>
							</tr>
						</tbody>
						<tr style="height: 30px">
							<td class="update">备注</td>
							<td align="left" colspan="3" class="update"><span id="b_notes" rows="3" cols="81" style="resize: none;"></span></td>
						</tr>
						<tr>
							<td class="update" >审核意见</td>
							<td class="update" colspan="3">
								<span id="b_cvlexaOpt" rows="3" cols="81" style="resize: none;"></span>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	
	<div id="w3" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 10px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<form id="cancelForm" action="paytongContract/cancelContract" method="post">
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 30px">
							<td class="update">注销生效日期</td>
							<td class="update" align="left">
								<input type="text" class="easyui-datebox" name="revocationdate"  id="revocationdate" required="true" missingMessage="请输入注销生效日期"/>
							</td>
							<td class="update"></td>
							<td class="update" align="left">
							</td>
						</tr>
						<tr>
							<td class="update" >备注</td>
							<td class="update" colspan="3">
								<textarea rows="3" cols="115" id="notes" maxlength="64" name="notes" style="margin:5px"></textarea>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:cancelContract()" id="btn_submit_cancel">确定</a>
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			$('#banknode_ins').combobox({
				editable:true,
				required:true,
				width:260,
				missingMessage:"请输入开户行",
				valueField:'text',
				textField:'text',
				mode:'remote',
				onSelect:function(record){
					$("#banknode_debtor_value").val(record.id);
				},
				onChange: function(newValue,oldValue){
					if(newValue==null||newValue==""){
						return;
					}
					if(newValue==oldValue){
						return;
					}
					if(!isChinese(newValue)){
						return;
					}
					if(newValue.length<2){
						//$('#banknode_ins').combobox('setText',null);
						return;
					}
					var url = 'paytongContract/queryBankNode?bankName='+encodeURI(newValue);
		            $('#banknode_ins').combobox('reload', url);
		            
				}
			});
			
			$('#banknode_cred').combobox({
				editable:true,
				required:true,
				width:260,
				missingMessage:"请输入开户行",
				valueField:'text',
				textField:'text',
				mode:'remote',
				onSelect:function(record){
					$("#banknode_cred_value").val(record.id);
				},
				onChange: function(newValue,oldValue){
					if(newValue==null||newValue==""){
						return;
					}
					if(newValue==oldValue){
						return;
					}
					if(!isChinese(newValue)){
						return;
					}
					if(newValue.length<2){
						//$('#banknode_cred').combobox('setText',null);
						return;
					}
					var url = 'paytongContract/queryBankNode?bankName='+encodeURI(newValue);
		            $('#banknode_cred').combobox('reload', url);
		            
				}
			});
			
			$('#bankList').datagrid({
				title:'宜赋通合同列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'paytongContract/queryContract',
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
					{field:'SIGNDATE',title:'签约日期',width:100,align:'center'},
					{field:'EXPIRYDATE',title:'失效日期',width:100,align:'center'},
					{field:'STATUS',title:'状态',width:100,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "有效";
							}else if(value=="10" || value=="20"){
								return "待审";
							}else if(value=="19" || value=="29"){
								return "审核未通过";
							}else if(value=="89"){
								return "过期失效";
							}else if(value=="99"){
								return "已注销";
							}
						}
					},
					{field:'TID',title:'操作',align:'center',width:160,rowspan:2,
						formatter:function(value,rec){
							if(rec.STATUS=="00"){
								return '<a href="javascript:delFindById('+value+')" style="color:blue;margin-left:10px">注销</a>'+
								'<a href="javascript:findById('+value+')" style="color:blue;margin-left:10px">详情</a>'
							}
						}}
					]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增合同',
					iconCls:'icon-add',
					handler:function(){
						showAdd(0);
					}
				}]
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			$('#saveForm :input').val('');
			$('#w').window({
				title: '新增合同信息',
				top:30,
				left:150,
				width: 900,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 750
			});
			$('#btn_submit').linkbutton('enable');
// 			$("#debAccyAmoLimit,#credAccuAmoLimit").val('200000');
			$("#debAmoLimit,#credAmoLimit").val('50000');
// 			$("#debTransLimit,#credTransLimit").val('0');
		}
		
		function showMerch(){
			var merchNo = $("#merchNo").val();
			$.ajax({
				type: "POST",
				url: "paytongContract/queryMerch",
				data: "merchNo=" + merchNo,
				dataType: "json",
				success: function(json) {
					$("#merchName").val(json.enterpriseName);
					$("#contacts_people").val(json.contact);
					$("#contacts_tel_no").val(json.contPhone);
					//自动生成合同号
					$.ajax({
						type: "POST",
						url: "paytongContract/generateContractNm",
						data: "merchNo=" + merchNo,
						dataType: "text",
						success: function(json) {
							$("#contractNum").val(json);
						}
					});
				}
			});
		}
		
		function changeContractType(){
			var contractType = $("#contractType").val();
			if(contractType=='CT00'||contractType=='CT02'){
				$('#cred_tbody').show();
				$('#banknode_cred').combobox({
					required:true,
					width:260,
					missingMessage:"请输入开户行",
					valueField:'text',
					textField:'text',
					mode:'remote',
					onSelect:function(record){
						$("#banknode_cred_value").val(record.id);
					},
					onChange: function(newValue,oldValue){
						if(newValue==null||newValue==""){
							return;
						}
						if(newValue==oldValue){
							return;
						}
						var url = 'paytongContract/queryBankNode?bankName='+encodeURI(newValue);
// 						var url = 'paytongContract/queryBankNode?bankName='+newValue;
			            $('#banknode_cred').combobox('reload', url);
			            
					}
				});
				
				$('#credAccNo').validatebox({
					missingMessage:"请输入收款人名称",
				    required: false
				});
				$('#credName').validatebox({
					missingMessage:"请输入收款人账号",
				    required: false
				});
			}else{
				$('#cred_tbody').hide();
				$('#banknode_cred').combobox({
					required:false,
					width:260,
					missingMessage:"请输入开户行",
					valueField:'text',
					textField:'text',
					mode:'remote',
					onSelect:function(record){
						$("#banknode_cred_value").val(record.id);
					},
					onChange: function(newValue,oldValue){
						if(newValue==null||newValue==""){
							return;
						}
						if(newValue==oldValue){
							return;
						}
						var url = 'paytongContract/queryBankNode?bankName='+encodeURI(newValue);
// 						var url = 'paytongContract/queryBankNode?bankName='+newValue;
			            $('#banknode_cred').combobox('reload', url);
			            
					}
				});
				
				$('#credAccNo').validatebox({
				    required: false
				});
				$('#credName').validatebox({
				    required: false
				});
				
				
				
				
			}
		}
		
		function closeAdd(){
			$('#w').window('close');
			$('#w2').window('close');
			$('#w3').window('close');
			$('#w4').window('close');
			$('#w5').window('close');
			
		}		
		function search(){
			var data={'merchNo':$('#a_merchNo').val(),'contractNum':$('#a_contractNum').val(),
					'debName':$("#a_debName").val(),'credName':$("#a_credName").val(),
					'debAccNo':$("#a_debAccNo").val(),'credAccNo':$("#a_credAccNo").val()};
			$('#bankList').datagrid('load',data);
		}
		function saveContract(){
			if($('#debTranLimitType').val() != "00" && ($('#debAccyAmoLimit').val() <=0 || $('#debAccyAmoLimit').val() == null)){
				$.messager.alert('提示', '请输入累计付款金额上限！');
				return false;
			}
			if($('#debTransLimitType').val() != "00" && ($('#debTransLimit').val() <=0 || $('#debTransLimit').val() == null)){
				$.messager.alert('提示', '请输入付款次数限制！');
				return false;
			}
			if($('#credTranLimitType').val() != "00" && ($('#credAccuAmoLimit').val() <=0 || $('#credAccuAmoLimit').val() == null)){
				$.messager.alert('提示', '请输入累计收款金额上限！');
				return false;
			}
			if($('#credTransLimitType').val() != "00" && ($('#credTransLimit').val() <=0 || $('#credTransLimit').val() == null)){
				$.messager.alert('提示', '请输入收款次数限制！！');
				return false;
			}
			$('#saveForm').form('submit', {  
			    onSubmit: function(){  
			    	if($('#saveForm').form('validate')){
			    		$('#btn_submit').linkbutton('disable');	
			    		return true;   
				    }
			        return false;   
			    }, 
			    success:function(json){
			    	$('#btn_submit').linkbutton('enable');	
			    	json = eval('(' + json + ')');
					if(json.RET == "succ"){
						 $.messager.alert('提示', '操作成功');
						 search();
						 closeAdd();
					}else{
						 $.messager.alert("提示",json.INFO);
					}
			    }
			});  
		}
		
		
		
		
		
		
		
		function delFindById(tId){
			$.messager.confirm('提示', '您是否想要注销此合同', function(msg){
				if(msg){
					$.ajax({
						type: "POST",
						url: "paytongContract/cancelContract",
						data: {'withdrawopt':msg,'tid':tId},
						dataType: "json",
						success: function(json) {
							if(json.RET == "succ"){
			    				$.messager.alert('提示',"操作成功!");
				    			search();
					    		closeAdd();
					    	}else{
					    		$.messager.alert('提示',json.INFO); 
					    		search();
					    		closeAdd();
					    	}
						}
					});
				}
				
            });
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
				   $("#b_contacts_people").html(json.CONTACT);
				   $("#b_contacts_tel_no").html(json.CONT_PHONE);
				   $("#b_signdate").html(json.SIGNDATE);
				   $("#b_expirydate").html(json.EXPIRYDATE);
				   $("#b_thirdcontractnum").html(json.THIRDCONTRACTNUM);
				   var contractType;
				   if(json.CONTRACTTYPE == 'CT00'){
					   contractType = '批量代收协议';
					   $("#cred_tbody_info").show();
					   $("#colletcion").show();
					   $("#batch_td1").html("收费代码");
					   $("#batch_td2").html('<span id="b_chargeNo"></span>');
					   
					   $("#payment").hide();
				   }else if(json.CONTRACTTYPE == 'CT01'){
					   contractType = '批量代付协议';
					   $("#cred_tbody_info").hide();
					   $("#colletcion").hide();
					   $("#batch_td1,#batch_td2").html("");
					   $("#payment").show();
					   
				   }else if(json.CONTRACTTYPE == 'CT02'){
					   contractType = '实时代收协议';
					   $("#cred_tbody_info").show();
					   $("#colletcion").show();
					   $("#batch_td1,#batch_td2").html("");
					   $("#payment").hide();
				   }else if(json.CONTRACTTYPE == 'CT03'){
					   contractType = '实时代付协议';
					   $("#cred_tbody_info").hide();
					   $("#colletcion").hide();
					   $("#batch_td1,#batch_td2").html("");
					   $("#payment").show();
				   }
				   $("#b_contractType").html(contractType);
				   $("#b_contractType").val(json.CONTRACTTYPE);
				   
				   
				   //付款方
				   $("#b_banknode_debtor_value").html(json.DEBTORBRANCHNAME);
				   $("#b_debName").html(json.DEBTORNAME);
				   $("#b_debAccNo").html(json.DEBTORACCOUNTNO);
				   
				 	//收款方
				   $("#creditorname").html(json.CREDITORNAME);
				   $("#creditoraccountno").html(json.CREDITORACCOUNTNO);
				   $("#b_banknode_cred_value").html(json.CREDITORBRANCHNAME);
				   
				   
				   
				   

				  
				   $("#b_debAmoLimit").html(fenToYuan(json.DEBTORAMOUNTLIMIT));
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
				   $("#b_debTranLimitType").html(debTranLimitType);
				   $("#b_debAccyAmoLimit").html(json.DEBTORACCUAMOUNTLIMIT);
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
				   $("#b_debTransLimitType").html(debTransLimitType);
				   $("#b_debAccyAmoLimit").html(fenToYuan(json.DEBTORACCUAMOUNTLIMIT));
				   $('#b_debTransLimit').html(json.DEBTORTRANSLIMIT)
				   
				   
				   
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
				   $("#b_credTranLimitType").html(credTranLimitType);
				   $("#b_credAccuAmoLimit").html(fenToYuan(json.CREDITORACCUAMOUNTLIMIT));
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
				   $("#b_credTransLimitType").html(credTransLimitType);
				   $("#b_credTransLimit").html(json.CREDITORTRANSLIMIT);
				   $("#b_credAmoLimit").html(fenToYuan(json.CREDITORAMOUNTLIMIT));
				   $("#b_notes").html(json.NOTES);
				   $("#b_senderCode").html(json.SENDERCODE);
				   var proprietary;
				   if(json.PROPRIETARY == 'CT00'){
					   proprietary = '批量代收协议';
				   }else if(json.PROPRIETARY == 'CT01'){
					   proprietary = '批量代付协议';
					   
				   }else if(json.PROPRIETARY == 'CT02'){
					   proprietary = '实时代收协议';
				   }else if(json.PROPRIETARY == 'CT03'){
					   proprietary = '实时代付协议';
				   }else{
					   proprietary = json.PROPRIETARY;
				   }
				   $("#b_proprietary").html(proprietary);
				   $("#b_chargeConntract").html(json.CHARGECONTRACT);
				   $("#b_chargeNo").html(json.CHARGENO);
				   $("#b_payContract").html(json.PAYCONTRACT);
				   $("#b_cvlexaOpt").html(json.CVLEXAOPT);
				   
			   }
			});
			$('#w2').window({
				title: '宜赋通合同详情',
				left:200,
				top:30,
				width: 900,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 760
			});
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
		function isChinese(temp)  
		{  
		 var re = /[^\u4e00-\u9fa5]/;  
		 if(re.test(temp)) return false;  
		 return true;  
		}  
		
		function cancelContract(){
			$('#cancelForm').form('submit', {  
			    onSubmit: function(){  
			    	if($('#cancelForm').form('validate')){
			    		$('#btn_submit_cancel').linkbutton('disable');	
			    		return true;   
				    }
			        return false;   
			    }, 
			    success:function(json){
			    	$('#btn_submit_cancel').linkbutton('enable');	
			    	json = eval('(' + json + ')');
					if(json.RET == "succ"){
						 $.messager.alert('提示', '操作成功');
						 search();
						 closeAdd();
					}else{
						 $.messager.alert("提示",json.INFO);
					}
			    }
			});  
		}
	</script>
</html>
