<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<style type="text/css">
table {
	
}

table tr td {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}

table tr td input {
	width:250px;
	height: 15px;
}

table tr td.head-title {
	background-color: #F0F8FF;
	font-weight: bold;
}

table tr td.head-guide {
	background-color: #F0FFFF;
	font-weight: bold;
}

table tr td font.current-step {
	color: #EE4000;
}
</style>
<script type="text/javascript"
	src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>
</head>
<body>
	<div style="margin: 5px;" id="continer">
		<div id="title" name="title" class="easyui-panel" title="委托机构开通修改"
			style="background: #fafafa;" iconCls="icon-save" collapsible="false">
			<div style="padding-left: 5px; padding-right: 5px">
				<form id="merchDetaForm" action="associatedagency/saveChangeMerchDeta" method="post">
					<input type="hidden" id="merchApplyId" name="merchApplyId" value="${merchApplyId}" /> 
					<input type="hidden" id="memId" name="memId" value="${member.memId}" /> 
					<input type="hidden" id="merchId" name="merchId" value="${merchDeta.merchId}" /> 
					<input type="hidden" id="enterpriseMemberId" name="enterpriseMemberId" value="${member.enterpriseMemberId}" /> 
					<input type="hidden" id="coopInstiId_old" value="${member.coopInstiId}" /> 
					<input type="hidden" id="enterpriseInsti" value="${member.enterpriseInsti}" /> 
					<input type="hidden" id="province_old" value="${member.province}" /> 
					<input type="hidden" id="county_old" value="${member.street}" />
					<input type="hidden" id="setltype_old" value="${merchDeta.setlType}" /> 
					<input type="hidden" id="banknode_old" value="${merchDeta.bankNode}" /> 
					<input type="hidden" id="prdtver_old" name="prdtVer" value="${merchDeta.prdtVer}" /> 
					<input type="hidden" id="spiltver_old" value="${merchDeta.spiltVer}" />
					<input type="hidden" id="riskver_old" name="riskVer" value="${merchDeta.riskVer}" />
					<input type="hidden" id="routver_old" value="${merchDeta.routVer}" />
					<input type="hidden" id="agreemtStart_old" value="${merchDeta.agreemtStart}" /> 
					<input type="hidden" id="agreemtEnd_old" value="${merchDeta.agreemtEnd}" /> 
					<input type="hidden" id="caCode_old" value="${merchDeta.caCode}" /> 
					<input type="hidden" id="isDelegation_old" value="${member.isDelegation}" /> 
					<input type="hidden" id="bankname_old" name="bankName" value="${oldBankName}" />
					
					<table width="100%">
						<tr>
							<td colspan="4"><font class="current-step">第一步:委托机构信息修改</font><img src="<%=basePath%>pictuer/tag.jpg" style="height: 10px"/>第二步:配置计费方式<img src="<%=basePath%>pictuer/tag.jpg" style="height: 10px"/>第三步:上传证件照片</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">一、委托机构基本信息</td>
						</tr>
						<tr>
							<td align="center" width="15%"><font color="red">*委托机构名称</font></td>
							<td width="35%">
								<input id="merName" name="enterpriseName" value="${member.enterpriseName}" required="true" maxlength="30" style="width: 250px" 
								missingMessage="请输入机构名称" class="easyui-validatebox" validType="MerchLength[60]" />
							</td>
							<td align="center" width="15%"><font color="red">*委托机构编号</font></td>
							<td width="35%">${member.enterpriseMemberId}</td>
						</tr>
						<tr>
							<td align="center"><font color="red">*经营地址</font></td>
							<td colspan="3">
								<input class="easyui-validatebox" maxlength="128" name="address" value="${member.address}" style="width: 250px"
								missingMessage="请输入经营地址" type="text" required="true" />
							</td>
						</tr>
						<tr>
							<td align="center" width="15%"><font color="red">*委托机构邮箱</font></td>
							<td>
								<input name="email" maxlength="32" validType="email" missingMessage="请输入委托机构邮箱" type="text" style="width: 250px"
								value="${member.email}" required="true" class="easyui-validatebox" />
							</td>
							<td align="center"><font color="red">*邮编编码</font></td>
							<td>
								<input required="true" class="easyui-validatebox" validType="postcode[6]" maxlength="6" style="width: 250px"
								name="postCode" value="${member.postCode}" missingMessage="请输入邮编编码" />
							</td>
						</tr>
						<tr>
							<td align="center"><font color="red">*业务联系人</font></td>
							<td>
								<input name="contact" value="${member.contact}" maxlength="16" type="text" style="width: 250px"
								class="easyui-validatebox" required="true" missingMessage="请输入业务联系人"/>
							</td>
							<td align="center">
								<font color="red">*业务联系人电话</font>
							</td>
							<td>
								<input class="easyui-validatebox" maxlength="11" validType="chinesetest" style="width: 250px"
								name="contPhone" value="${member.contPhone}" required="true" missingMessage="请输入业务联系人"/>
							</td>
						</tr>
						<tr>
							<td align="center">
								<font color="red">*业务联系人职位</font>
							</td>
							<td>
								<input name="contTitle" value="${member.contTitle}" maxlength="16" type="text" style="width: 250px"
								 required="true" class="easyui-validatebox" missingMessage="请输入业务联系人职位"/>
							</td>
							<td align="center">
								<font color="red">*业务联系人邮箱</font>
							</td>
							<td>
								<input class="easyui-validatebox" maxlength="32" validType="email" name="contEmail" style="width: 250px"
								 value="${member.contEmail}" required="true" missingMessage="请输入业务联系人邮箱"/>
							</td>
						</tr>
						<tr>
							<td align="center">委托机构类型</td>
							<td>
								<input name="agencyType" value="${merchDeta.agencyType}" maxlength="32" type="text" style="width: 250px"
								 missingMessage="请输入委托机构类型"/>
							</td>
							<td align="center">
								<font color="red">*代理商</font>
							</td>
							<td>
								<select id="caCode" class="easyui-validatebox" maxlength="15" missingMessage="请选择代理商" style="width: 250px"
								required="true" name="caCode" style="width:250px">
									<option value=''>--请选择代理商--</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="center">保证金（元）</td>
							<td>
								
								<input class="easyui-validatebox" maxlength="8" validType="amount" style="width: 250px"
								 name="deposit" value="<fmt:formatNumber value="${deposit/100}" pattern="##################0.00"/>">
									 
								 </input>
							</td>
							<td align="center">服务费（元）</td>
							<td>
								<input name="charge" maxlength="8" validType="amount" style="width: 250px" class="easyui-validatebox" type="text" value="<fmt:formatNumber value="${deposit/100}" pattern="##############0.00"/>">
								</input>
							</td>
						</tr>
						<tr>
							<td align="center">
								<font color="red">*合约开始日期</font>
							</td>
							<td>
								<input name="agreemtStart" value="${merchDeta.agreemtStart}" maxlength="12" style="width: 250px"
								type="date" id="startDate" />
							</td>
							<td align="center">
								<font color="red">*合约终止日期</font>
							</td>
							<td>
								<input class="easyui-validatebox" value="${merchDeta.agreemtEnd}" maxlength="32" style="width: 250px"
								type="date" name="agreemtEnd" id="endDate" />
							</td>
						</tr>
						
						<tr>
							<td colspan="4" class="head-title">二、委托机构入网信息</td>
						</tr>
						<tr>
							<td align="center">
								<font color="red">*营业执照号</font>
							</td>
							<td>
								<input name="licenceNo" value="${member.licenceNo}" maxlength="18" type="text" missingMessage="请输入营业执照号" validType="licencenoNewLength[15,18]" id="add_licenceNo"
								onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')" required="true" class="easyui-validatebox" style="width: 250px"/>
							</td>
							<td align="center">
								<font color="red">*业务范围</font>
							</td>
							<td>
								<input name="businessArea" value="${merchDeta.businessArea}" maxlength="128" type="text" style="width: 250px"
								missingMessage="请输入业务范围"  id="business_range" required="true" class="easyui-validatebox" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<font color="red">*法人姓名</font>
							</td>
							<td>
								<input name="corporation" value="${member.corporation}" maxlength="16" type="text" style="width: 250px"
								 missingMessage="请输入法人姓名" required="true" class="easyui-validatebox" /> 
							</td>
							<td align="center">
								<font color="red">*法人身份证号</font>
							</td>
							<td>
								<input class="easyui-validatebox" value="${member.corpNo}" required="true" style="width: 250px"
								missingMessage="请输入法人身份证号" validType="cardNo[18]" maxlength="18" name="corpNo" /> 
							</td>
						</tr>
						<tr>
							<td align="center">税务登记号</td>
							<td>
								<input name="taxno" value="${member.taxno}" maxlength="20" type="text" style="width: 250px"
								missingMessage="请输入税务登记号" validType="merLength[15]" 
								onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')" id="add_taxno" class="easyui-validatebox" />
							</td>

							<td align="center">组织机构代码号</td>
							<td>
								<input name="orgCode" value="${member.orgCode}" maxlength="18" type="text" style="width: 250px"
								missingMessage="请输入组织机构代码号" validType="orgNewLength[8,9,10,18]" id="add_orgCode"
								onkeyup="value=value.replace(/[^\d\-]/g,'')" class="easyui-validatebox" />
							</td>
						</tr>
						
						<tr>
							<td align="center">委托机构网站地址</td>
							<td>
								<input name="website" value="${member.website}" maxlength="256" type="text" style="width: 250px"
								missingMessage="请输入委托机构网站地址" validType="url" />
							</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">三、结算账户信息</td>
						</tr>
						<tr>
							<td align="center"><font color="red">*开户银行</font></td>
							<td colspan="3">
<!-- 								<select id="banknode_ins" missingMessage="请输入开户行" class="easyui-combobox" required="true" name="bankName" style="width: 350px"> -->
<!-- 									<option value=''>--请选择开户行--</option> -->
<!-- 								</select> -->
								<input class="easyui-combobox" id="banknode_ins" missingMessage="请输入开户行" required="true" style="width: 250px"/>
								
							</td>
						</tr>
						<tr style="height: 30px">
							<td align="center">
								<font color="red">*银行账号</font>
							</td>
							<td>
								<input name="accNum" value="${merchDeta.accNum}" maxlength="32" required="true" style="width: 250px"
								missingMessage="请输入开户账号" type="text" validType="settleAccount" class="easyui-validatebox" />
							</td>
							<td align="center">
								<font color="red">*开户名</font>
							</td>
							<td>
								<input class="easyui-validatebox" value="${merchDeta.accName}" maxlength="30" style="width: 250px"
								missingMessage="请输入开户名" validType="accName" required="true" name="accName" />
							</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">四、计费标准</td>
						</tr>
						<tr>
							<td align="center" width="15%">
								<font color="red">*交易手续费结算方式</font>
							</td>
							<td>
								<input type="radio" name="setlCycle" style="width: 20px;vertical-align: middle; display: none" value="01"/><span style=" display: none">预付</span>
								<input type="radio" name="setlCycle" style="width: 20px;vertical-align: middle; display: none" value="W"/><span style=" display: none">周结</span>
								<input type="radio" name="setlCycle" style="width: 20px;vertical-align: middle;" checked="checked" value="M"/><span>月结</span>
							</td>
							<td>
								<font color="red">*交易手续费付款方式</font>
							</td>
							<td>
								<input type="radio" name="payModel" style="width: 20px;vertical-align: middle;display: none" value="01"/><span style=" display: none">代扣</span>
								<input type="radio" name="payModel" style="width: 20px;vertical-align: middle;" checked="checked" value="02"/><span>主动付款</span>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" id="button_id" href="javascript:savemerchDate()" onclick="">下一步</a> 
				<a href="javascript:backToAgencyIndex()" class="easyui-linkbutton" iconCls="icon-back">返回</a>
			</div>
		</div>
	</div>
</body>
<script>
	  $(function() {
		  	init();
			showCaCode();
			$('#startDate').datebox({
				width:250,
				missingMessage:"请选择合约开始时间",
				required:true,
				editable:false
				});
			$('#endDate').datebox({
				width:250,
				missingMessage:"请选择合约结束时间",
				required:true,
				editable:false
				});
			
			$('#banknode_ins').combobox({
				required:true,
				width:260,
				missingMessage:"请输入开户行",
				valueField:'text',
				textField:'text',
			    mode:'remote',
			    editable:true,
				onChange: function(newValue,oldValue){
					if(newValue==null||newValue==""){
						return;
					}
					if(newValue==oldValue){
						return;
					}
					var url = 'associatedagency/queryBankNode?bankName='+ encodeURI(newValue);
		            $('#banknode_ins').combobox('reload', url);
		            
				}
			});
			
			$("#charge_mode").change(function(){
				var charge_mode = $("#charge_mode").val();
				if(charge_mode==1){
				}else{
					$("#segmented").hide();
				}
			
			})
		});
	  function init(){
			var oldbankname = $("#bankname_old").val();
			$("#banknode_ins").combobox('setValue',oldbankname);
			showCaCode();
		}
		function savemerchDate() {
			var flag = 1;
			var jp = $('#banknode_ins').combobox('getText')
			$("#bankname_old").val(jp);
			var add_licenceNo = $("#add_licenceNo").val();
			var add_orgCode = $("#add_orgCode").val();
			var add_taxno = $("#add_taxno").val();
			if(add_licenceNo.length == 18){
				if(add_licenceNo != add_orgCode && add_licenceNo != add_taxno ){
					$.messager.alert('提示',"税务登记号、营业执照号、组织机构代码输入不一致！");
					return false;
				}
			}
			
			$('#merchDetaForm').form('submit', {
				cache:false,
				onSubmit: function() {
					return $('#merchDetaForm').form('validate');
				},
				dataType:"json",
				success: function(json) {
					$("#button_id").linkbutton('enable');
					json = eval('(' + json + ')');
					$.each(json,function(key, value) {
						if (value.RET == "succ") {
							window.location.href="<%=basePath%>" + 'associatedagency/showAgencyAddSecond?merchApplyId='+value.INFO + '&flag=' + flag;
						} else {
							$.messager.alert('提示', value.INFO);
						}
					});
				}
			});
		}
		
		function resize() {
			$(':input').val("");
		}
		
		function showCaCode() {
			$.ajax({
				type: "POST",
				url: "coopAgency/query",
				data: {"status":"00","page":1,"rows":10},
				dataType: "json",
				success: function(json) {
					var code = $('#caCode_old').val();
					var html = "<option value=''>--请选择代理商--</option>";
					$.each(json.rows,function(key, value) {
						if(value.CACODE == code){
							html += '<option value="' + value.CACODE + '" selected="selected">' + value.CANAME + '</option>';
						}else{
							html += '<option value="' + value.CACODE + '">' + value.CANAME + '</option>';
						}
					});
					$("#caCode").html(html);
				}
			});
		}
		
		function backToAgencyIndex(){
			window.location.href= "<%=basePath%>" +'associatedagency/showManager';
		}
		
	</script>
</html>

