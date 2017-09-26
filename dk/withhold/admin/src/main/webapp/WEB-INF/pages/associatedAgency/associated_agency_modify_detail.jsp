<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style type="text/css">
table {
	
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

table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
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

<body>
	<div style="margin: 5px;" id="continer">
		<div id="title" name="title" class="easyui-panel" title="委托机构信息"
			style="background: #fafafa;" iconCls="icon-save"
			data-options="fit:true,border:false" collapsible="false">
			<div style="padding-left: 5px; padding-right: 5px">
				<form id="merchDetaForm" action="associatedagency/saveMerchDeta"bmethod="post">
					<input type="hidden" id="isDelegation"bvalue="${merchMap.IS_DELEGATION}" /> 
					<input type="hidden" id="merchId" name="merchId" value="${merchMap.MERCHID}" />
					<input type="hidden" id="merchApplyId" value="${merchMap.SELF_ID}" />
					<input type="hidden" id="rc_memberId" value="${merchMap.MEMBER_ID}" />
					<input type="hidden" id="prdtVer" value="${merchMap.PRDT_VER}" />
					<input type="hidden" id="a_riskVer" value="${merchMap.RISK_VER}" />
					<input type="hidden" id="CACODE" value="${merchMap.CACODE}" />
					<input type="hidden" id="num_merchNo" value="${merchMap.MEMBER_ID}" />
					<input type="hidden" id="flag_ins" value="${flag}" />
					<input type="hidden" id="payModel_old" value="${merchMap.PAYMODEL}" />
					<input type="hidden" id="deposit_old" value="${merchMap.DEPOSIT}" />
					<input type="hidden" id="charge_old" value="${merchMap.CHARGE}" />
					<table width="100%">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">一、委托机构基本信息</td>
						</tr>
						<tr>
							<td class="update" align="center" width="15%">委托机构名称</td>
							<td class="update" align="left" width="35%">${merchMap.ENTERPRISE_NAME}</td>
							<td class="update" align="center" width="15%">委托机构编号</td>
							<td class="update" align="left" width="35%">${merchMap.MEMBER_ID}</td>
						</tr>
						<tr>
							<td class="update" align="center" width="15%">委托机构邮箱</td>
							<td class="update" align="left">${merchMap.EMAIL}</td>
							<td class="update" align="center">邮编编码</td>
							<td class="update" align="left">${merchMap.POST_CODE}</td>
						</tr>
						<tr>
							<td class="update" align="center">经营地址</td>
							<td class="update" align="left" colspan="3">${merchMap.ADDRESS}</td>
							
						</tr>
						<tr>
							<td class="update" align="center">业务联系人</td>
							<td class="update" align="left">${merchMap.CONTACT}</td>
							<td class="update" align="center">业务联系人电话</td>
							<td class="update" align="left">${merchMap.CONT_PHONE}</td>
						</tr>
						<tr>
							<td class="update" align="center">业务联系人职位</td>
							<td class="update" align="left">${merchMap.CONT_TITLE}</td>
							<td class="update" align="center">业务联系人邮箱</td>
							<td class="update" align="left">${merchMap.CONT_EMAIL}</td>
						</tr>
						<tr>
							<td class="update" align="center">委托机构类型</td>
							<td class="update" align="left">${merchMap.AGENCYTYPE}</td>
							<td class="update" align="center">代理商</td>
							<td class="update" align="left"><span id="b_caCode"></span></td>
						</tr>
						<tr>
							<td class="update" align="center">保证金（元）</td>
							<td class="update" align="left"><span id="deposit"></span></td>
							<td class="update" align="center">服务费（元）</td>
							<td class="update" align="left"><span id="charge"></span></td>
						</tr>
						<tr>
							<td class="update" align="center">合约开始日期</td>
							<td class="update" align="left">${merchMap.AGREEMT_START}</td>
							<td class="update" align="center">合约终止日期</td>
							<td class="update" align="left">${merchMap.AGREEMT_END}</td>
						</tr>
						
						<tr>
							<td colspan="4" class="head-title">二、委托机构入网信息</td>
						</tr>
						<tr>
							<td class="update" align="center">营业执照号</td>
							<td class="update" align="left">${merchMap.LICENCE_NO}</td>
							<td class="update" align="center">业务范围</td>
							<td class="update" align="left">${merchMap.BUSINESSAREA}</td>
						</tr>
						<tr>
							<td class="update" align="center">法人姓名</td>
							<td class="update" align="left">${merchMap.CORPORATION}</td>
							<td class="update" align="center">法人身份证号</td>
							<td class="update" align="left">${merchMap.CORP_NO}</td>
						</tr>
						<tr>
							<td class="update" align="center">税务登记号</td>
							<td class="update" align="left">${merchMap.TAX_NO}</td>
							<td class="update" align="center">组织机构代码号</td>
							<td class="update" align="left">${merchMap.ORG_CODE}</td>
						</tr>
						
						<tr>
							<td class="update" align="center">委托机构网站地址</td>
							<td class="update" align="left">${merchMap.WEBSITE}</td>
							<td class="update" align="left"></td>
							<td class="update" align="left"></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">三、结算账户信息</td>
						</tr>
						<tr>
							<td class="update" align="center">开户银行</td>
							<td class="update" colspan="3">${merchMap.BANKNAME}</td>
						</tr>
						<tr>
							<td class="update" align="center">银行账号</td>
							<td class="update" align="left">${merchMap.ACC_NUM}</td>
							<td class="update" align="center">开户名</td>
							<td class="update" align="left">${merchMap.ACC_NAME}</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">四、计费标准</td>
						</tr>
						<tr>
							<td class="update" align="center">交易手续费结算方式</td>
							<td class="update" align="left">${merchMap.SETLNAME}</td>
							<td class="update" align="center">交易手续费付款方式</td>
							<td class="update" align="left"><span id="payModel" ></span></td>
						</tr>
						<tr>
							<td align="center" class="update">借贷方式</td>
							<td colspan="3" class="update"><span id="c_radio"></span></td>
						</tr>
						</table>
						<table width="100%" scroll="no">
							<tr>
								<td colspan="4" class="head-title" align="left">借记卡</td>
							</tr>
							<tr>
								<td align="center" class="update" width="12%">实时代收</td>
								<td class="update" align="left" width="12%"><span id="rateMethod_01"></span></td>
								<td colspan="2"><span id="rateMethodDetail_01"></span></td>
							</tr>
							<tr>
								<td align="center" class="update">实时代付</td>
								<td class="update" align="left"><span id="rateMethod_02"></span></td>
								<td colspan="2"><span id="rateMethodDetail_02"></span></td>
							</tr>
							<tr>
								<td align="center" class="update">批量代收</td>
								<td class="update" align="left"><span id="rateMethod_03"></span></td>
								<td colspan="2"><span id="rateMethodDetail_03"></span></td>
							</tr>
							<tr>
								<td align="center" class="update">批量代付</td>
								<td class="update" align="left"><span id="rateMethod_04"></span></td>
								<td colspan="2"><span id="rateMethodDetail_04"></span></td>
							</tr>
							<tbody style="display: none" id="CWindow">
							<tr>
								<td colspan="4" class="head-title" align="left">贷记卡</td>
							</tr>
							<tr>
								<td align="center" class="update" width="15%">实时代收</td>
								<td class="update" align="left" width="15%"><span id="rateMethod_05"></span></td>
								<td colspan="2"><span id="rateMethodDetail_05"></span></td>
							</tr>
							<tr>
								<td align="center" class="update">实时代付</td>
								<td class="update" align="left"><span id="rateMethod_06"></span></td>
								<td colspan="2"><span id="rateMethodDetail_06"></span></td>
							</tr>
							<tr>
								<td align="center" class="update">批量代收</td>
								<td class="update" align="left"><span id="rateMethod_07"></span></td>
								<td colspan="2"><span id="rateMethodDetail_07"></span></td>
							</tr>
							<tr>
								<td align="center" class="update">批量代付</td>
								<td class="update" align="left"><span id="rateMethod_08"></span></td>
								<td colspan="2"><span id="rateMethodDetail_08"></span></td>
							</tr>
							</tbody>
						</table>
						<table width="100%" >
						<tr>
							<td colspan="4" class="head-title">五、风控标准</td>
						</tr>
						<tr>
							<td align="center" class="update">风控版本</td>
							<td colspan="3" class="update"><span id="b_riskVer"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">六、证件附件</td>
						</tr>
						<tr>
							<td class="update" align="center" width="15%">委托机构法人营业执照</td>
							<td class="update" width="35%"><span id="busilice_cert_img"></span></td>
							<td class="update" align="center" width="15%">组织机构代码证</td>
							<td class="update" width="35%"><span id="orgCert_cert_img"></span></td>
						</tr>
						<tr>
							<td class="update" align="center">法人身份证正面照</td>
							<td class="update" ><span id="corpfileFace_cert_img"></span></td>
							<td class="update" align="center" id="psamORpass">法人身份证背面照</td>
							<td class="update" ><span id="corpfileOpp_cert_img"></span></td>
						</tr>
						<tr id="delegation_pic">
							<td class="update" align="center">人身份证正面照</td>
							<td class="update" ><span id="signfileFace_cert_img"></span></td>
							<td class="update" align="center" id="psamORpass">人身份证背面照</td>
							<td class="update" ><span id="signfileOpp_cert_img"></span></td>
						</tr>
<%-- 						<c:if test="${member.isDelegation==1}"> --%>
							<tr>
								<td class="update" align="center" id="psamORpass">委托人身份证正面照</td>
								<td class="update" ><span id="signfileFace_cert_img"></span></td>
								<td class="update" align="center" id="psamORpass">委托人身份证背面照</td>
								<td class="update" ><span id="signfileFace_cert_img"></span></td>
							</tr>
<%-- 						</c:if> --%>
						<tr>
							<td class="update" align="center">税务登记证文件目录</td>
							<td class="update" ><span id="taxRegCert_cert_img"></span></td>
							<td class="update"></td>
							<td class="update"></td>
						</tr>

						<c:if test="${flag==5}">
							<tr>
								<td class="update" align="center">初核意见</td>
								<td class="update" colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" maxlength="60" id="STOPINION"></textarea>
								</td>
							</tr>
						</c:if>
						<c:if test="${flag==6}">
							<tr>
								<td class="update" align="center">初审人</td>
								<td class="update" >${merchMap.STEXANAME}</td>
								<td class="update" align="center">初审意见</td>
								<td class="update" >${merchMap.STEXA_OPT}</td>
							</tr>
							<tr>
								<td class="update" align="center">复核意见</td>
								<td class="update" colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" maxlength="60" id="STOPINION"></textarea>
								</td>
							</tr>
						</c:if>
						<c:if test="${flag==10}">
							<tr style="height: 55px">
								<td class="update" align="center">初核意见</td>
								<td class="update" colspan="3" align="left">${merchMap.STEXA_OPT}</td>
							</tr>
							<tr style="height: 55px">
								<td class="update" align="center">复核意见</td>
								<td class="update" colspan="3" align="left">${merchMap.CVLEXA_OPT}</td>
							</tr>
						</c:if>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div region="south" border="false" style="text-align: center; padding: 5px 0;">
		<c:if test="${flag==5}">
			<a href="javascript:showUser('3');" id="button_ins1"
				class="easyui-linkbutton" iconCls="icon-ok">下一步</a>
			<a href="javascript:merchAudit('9');" id="button_ins2"
				class="easyui-linkbutton" iconCls="icon-cancel">否决</a>
			<a href="javascript:merchAudit('1');" id="button_ins3"
				class="easyui-linkbutton" iconCls="icon-no">驳回</a>
		</c:if>
		<c:if test="${flag==6}">
			<a href="javascript:merchAudit('0');" id="button_ins4"
				class="easyui-linkbutton" iconCls="icon-ok">下一步</a>
			<a href="javascript:merchAudit('9');" id="button_ins5"
				class="easyui-linkbutton" iconCls="icon-cancel">否决</a>
			<a href="javascript:merchAudit('1');" id="button_ins6"
				class="easyui-linkbutton" iconCls="icon-no">驳回</a>
		</c:if>
		<a href="javascript:history.back(-1);" class="easyui-linkbutton"
			iconCls="icon-back">返回</a>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px; top: 50%; left: 50%;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="deptForm" action="" method="post">
					<table cellpadding="2" cellspacing="2" style="text-align: left" id="inputForm">
						<tr>
							<td class="add" align="center" width="30%">委托机构名称</td>
							<td class="add" width="30%"><input id="b_merName" name="enterpriseName" readonly="true"/></td>
						</tr>
						<tr>
							<td class="add" align="center">风控版本</td>
							<td class="add"><select name="riskVer" maxlength="8" required="true" id="riskver" /></select> <font color="red">*</font></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:updateMerch()" id="btn_submit">保存</a> 
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	
<script>
var memberId = $("#merchApplyId").val();
var flag = $("#flag_ins").val();
var pid = $("#prdtVer").val();
  $(function() {
	  	showCaCode();
		checkIsDelegation();
		initCertUrl(); 
		queryRiskType(pid)
		initAgencyRate();
		paymodel();
	});
  function outerHeight(type){
		if(type == "1"){
			if(flag==5){
				$("#title").css("height",1080);
			}else if(flag==6){
				$("#title").css("height",1150);
			}else if(flag==10){
				$("#title").css("height",1120);
			}
		}else if(type == "2"){
			if(flag==5){
				$("#title").css("height",1380);
			}else if(flag==6){
				$("#title").css("height",1420);
			}else if(flag==10){
				$("#title").css("height",1420);
			}
		}
		
	}
	function checkIsDelegation(){
		var isDelegation = $('#isDelegation').val();
		if(isDelegation=='1'){
			$('#delegation').show();
			$('#delegation_pic').show();
		}else{
			$('#delegation').hide();
			$('#delegation_pic').hide();
		}
	}
	
	function initCertUrl(){
		$("span[id*='_cert_img']").each(function(){
			var _this = $(this);
			var id = _this.attr('id');
			var certType = id.substring(0,id.indexOf('_cert_img'));
			$.ajax({
				type: "POST",
				url: "associatedagency/downloadImgUrl",
				data: "merchApplyId=" + $('#merchApplyId').val()+"&certTypeCode="+certType,
				dataType: "json",
				success: function(json) {
					 if(json.status=='OK'){
						 var URL = json.url;
						 _this.html('<a target="view_window" style="font-size: 12px;color:blue" onclick="showDownLoadFile('+'\''+URL+'\''+')">点击查看</a>');
					 }else if(json.status=='notExist'){
						 $(this).html('暂无可查看文件');
					 } else{
						 _this.html('查询失败');
					 }
				}
			}); 
		});
		
	}
	function showDownLoadFile(value){
		$.ajax({
		   type: "POST",
		   url: "associatedagency/showDownLoadFil",
		   data: {"filePath":value,"merchApplyId":$('#rc_memberId').val()},
		   async: true,
		   dataType:"json",
		   success: function(data){
				 if(data.status=='OK'){
					 var URL = "<%=basePath%>" + data.url;
					 window.open(URL); 
				 }
		    }
		});
	}
	function merchAudit(result) {
		$("#button_ins1").linkbutton('disable');
		$("#button_ins2").linkbutton('disable');
		$("#button_ins3").linkbutton('disable');
		$("#btn_submit7").linkbutton('disable');
		var merchApplyId = $("#merchApplyId").val();
		var stexaOpt = $("#STOPINION").val();
		if (result == 9) {
	        message = '您是否想终结此委托机构?';
	    } else if (result == 1) {
	        message = '您是否想驳回此委托机构?';
	    } else if (result == 0) {
	        message = '您是否想通过此委托机构?';
	    } 
	    $.messager.confirm('提示', message,
	    function(r) {
	        if (r) {
				$.ajax({
					type: "POST",
					url: "associatedagency/audit?isAgree=" + result + "&merchApplyId=" + merchApplyId + "&flag=" + flag,
					data: "stexaOpt=" + encodeURI(stexaOpt),
					dataType: "json",
					success: function(json) {
						$.each(json,function(key, value) {
							$.messager.defaults = { ok: "确定"};
							if (value.INFO == "操作成功!") {
								$.messager.alert('提示', '操作成功!','info',function(){
									if(flag == 5){
										window.location.href="<%=basePath%>" +'associatedagency/merchModifyFirstCheck';
									}else if(flag == 6){
										window.location.href="<%=basePath%>" +'associatedagency/merchModifySecondCheck';
									}
								});
							}else{
								 $.messager.alert('提示',"操作失败!");
							}
						})
					}
				});
	        }
	    });
	}
	function closeAdd(){
		$('#w').window('close');
	}
	function search(){
		$('#test').datagrid('load',null);
	}
 function showUser(){
		$.ajax({
		   type: "POST",
		   url: "associatedagency/findEnterById",
		   data: "memberId="+memberId,
		   async: false,
		   dataType:"json",
		   success: function(json){	
				$("#b_merName").val(json.enterpriseName);
				$("#b_merchId").val(json.enterpriseMemberId);
				queryRiskType(pid);
		   }
		});
		
		$('#w').window({
			title: '添加风控信息',
			top:200,
			left: 350,
			width: 400,
			modal: true,
			minimizable:false,
			collapsible:false,
			maximizable:false,
			shadow: false,
			closed: false,
			height: 180
		});
	}
 
	 function queryRiskType(pid) {
		$.ajax({
			type: "POST",
			url: "associatedagency/queryRiskType?vid=" + pid,
			data: "rand=" + new Date().getTime(),
			dataType: "json",
			success: function(json) {
				var html = "<option value=''>--请选择风控版本--</option>";
				var riskVal = $("#a_riskVer").val();
				var risk = "未选择风控版本";
				$.each(json,
				function(key, value) {
					if(value.RISKVER==riskVal){
						risk = value.RISKNAME;
					}
					html += '<option value="' + value.RISKVER + '">' + value.RISKNAME + '</option>';
				});
				$("#riskver").html(html);
				$("#b_riskVer").html(risk);
			}
		});
	}
	 function paymodel(){
		var deposit_val = $("#deposit_old").val();
		var charge_val = $("#charge_old").val();
		$('#deposit').html(fenToYuan(deposit_val/100));
		$('#charge').html(fenToYuan(charge_val/100));
		var value =  $('#payModel_old').val();
		if(value == "01"){
			$("#payModel").html("代扣");
		}else if(value == "02"){
			$("#payModel").html("主动付款");
		}
	}
	 function updateMerch(){
		 var memberId = $("#merchApplyId").val();
		 var riskVer = $("#riskver").val();
		$.ajax({
		   type: "POST",
		   url: "associatedagency/updateMerch",
		   data: {"memberId":memberId,"riskVer":riskVer},
		   async: false,
		   dataType:"json",
		   success: function(data){
				 if(data.status=='OK'){
					 closeAdd();
					 merchAudit('0');
				 }else{
					 $.messager.alert('提示',"提交失败");  
				 }
		    }
		});
	}
		function showCaCode() {
			$.ajax({
				type: "POST",
				url: "coopAgency/query",
				data: {"page":1,"rows":10},
				dataType: "json",
				success: function(json) {
					var code = $("#CACODE").val();
					var html;
					$.each(json.rows,function(key, value) {
						if(value.CACODE==code){
							html = '<option value="" selected="selected">' + value.CANAME + '</option>';
// 						}else{
// 							html += '<option value="">' + value.CANAME + '</option>';
						}
					});
					$("#b_caCode").html(html);
		
				}
			});
		}

		//初始化委托机构所有扣率信息
		function initAgencyRate(){
			var memberIdValue = $("#rc_memberId").val();
			$.ajax({
				type: "POST",
				url: "associatedagency/queryAgencyRateConfig?memberId=" + memberIdValue,
				dataType: "json",
				success: function(json) {
					if(json.length > 4){
						$('#c_radio').html("借贷分离");
						showCWin();
					}else{
						$('#c_radio').html("借贷合并");
						hideCWin();
					}
					$.each(json, function(key, val) {
						if(val.cardType=="1"){
							init_d_rate_config(val);
						}else if(val.cardType=="2"){
							//显示贷记卡内容
							$("#c_radio").attr("checked","checked");
							init_c_rate_config(val);
						}
					});
				}
			});
		}
		
		//借记卡扣率配置内容 
		function init_d_rate_config(val){
			
			var index;
			var rate_code = val.rateId;
			var rate_method = val.rateMethod;
			//alert(rate_code);
			//判断业务类型
			if(val.busiCode=="11000001"){
				index = "01";
				$('#rateMethod_01').html("按笔收费");
			}else if(val.busiCode=="11000002"){
				index = "02";
				$('#rateMethod_02').html("按扣率收费");
			}else if(val.busiCode=="11000003"){
				index = "03";
				$('#rateMethod_03').html("累计金额分段计费");
			}else if(val.busiCode=="11000004"){
				index = "04";
				$('#rateMethod_04').html("累计笔数分段计费");
			}
			
			if(rate_method=="1"){//业务类型扣率
				configCommonRate(index,rate_code);
			}else if(rate_method=="5"){
				configMultilevelAmtRate(index,rate_code);
			}else if(rate_method=="6"){
				configMultilevelNumRate(index,rate_code);
			}
		}
		
		//贷记卡扣率配置内容
		function init_c_rate_config(val){
			var index;
			var rate_code = val.rateId;
			var rate_method = val.rateMethod;
			if(val.busiCode=="11000001"){
				$('#rateMethod_05').html("按笔收费");
				index = "05";
			}else if(val.busiCode=="11000002"){
				$('#rateMethod_06').html("按扣率收费");
				index = "06";
			}else if(val.busiCode=="11000003"){
				$('#rateMethod_07').html("累计金额分段计费");
				index = "07";
			}else if(val.busiCode=="11000004"){
				$('#rateMethod_08').html("累计笔数分段计费");
				index = "08";
			}
			
			if(rate_method=="1"){//业务类型扣率
				configCommonRate(index,rate_code);
			}else if(rate_method=="5"){
				configMultilevelAmtRate(index,rate_code);
			}else if(rate_method=="6"){
				configMultilevelNumRate(index,rate_code);
			}
		}
		
		function configCommonRate(index,rate_code){
			$.ajax({
				type: "POST",
				url: "fee/getCommonRate?rateCode=" + rate_code,
				dataType: "json",
				success: function(json) {
					
			 		if(json.RATE_TYPE=='01'){
			 			$("#rateMethod_"+index).html("按笔收费");
			 			var html='<table width="100%" >'+
				          '<tr><td class="head-title" align="center">扣率代码</td><td class="head-title" align="center">扣率描述</td>'+
				          '<td class="head-title" align="center">计费方式</td><td class="head-title"  align="center">金额</td></tr>'+
				          '<tr><td class="update" align="center">'+json.RATE_ID+'</td><td class="update" align="center">'+json.RATE_DESC+'</td>'+
				          '<td class="update" align="center">单笔固定金额</td><td class="update" align="center">'+fenToYuan(json.MIN_FEE/100)+'</td></tr>'+
				          '</table>';
				 		$("#rateMethodDetail_"+index).html(html);
			 		}else{
			 			var rate_type_name;
			 			if(json.RATE_TYPE=="02"){
			 				rate_type_name="单位比例，不封顶保底";
			 			}else if(json.RATE_TYPE=="03"){
			 				rate_type_name="单位比例，封顶保底";
			 			}
				          var html='<table width="100%" >'+
				          '<tr><td class="head-title" align="center">扣率代码</td><td class="head-title" align="center">扣率描述</td>'+
				          '<td class="head-title" align="center">计费方式</td><td class="head-title" align="center">扣率(百分比)</td>'+
				          '<td class="head-title" align="center">最低额(元) </td><td class="head-title" align="center">最高额(元)</td></tr>'+
				          '<tr><td class="update" align="center">'+json.RATE_ID+'</td><td class="update" align="center">'+json.RATE_DESC+'</td>'+
				          '<td class="update" align="center">'+rate_type_name+'</td><td class="update" align="center">'+fenToYuan(json.FEE_RATE/100)+'</td>'+
				          '<td class="update" align="center">'+fenToYuan(json.MIN_FEE/100)+'</td><td class="update" align="center">'+fenToYuan(json.MAX_FEE/100)+'</td></tr>'+
				          '</table>';
				 		$("#rateMethodDetail_"+index).html(html);
			 			$("#rateMethod_"+index).html("按扣率收费");
			 		}
			 		
			 		
				}
			});
		}
		
		function configMultilevelAmtRate(index,rate_code){
			$.ajax({
				type: "POST",
				url: "fee/queryMultilevelRateDeta?tid=" + rate_code,
				dataType: "json",
				success: function(json) {
					
					var html = '<table width="100%" ><tr>';
					var i = 1;
					$.each(json, function(key, val) {
//	 					if(i==1){
//	 						html+='<tr><td class="head-title" align="center">扣率代码</td><td colspan="8" class="head-title" align="center">'+val.RATE_ID+'</td></tr>'
//	 					}
						var RATE_TYPE;
						if(val.RATE_TYPE==1){
							RATE_TYPE = '固定金额';
						}else if(val.RATE_TYPE==2){
							RATE_TYPE = '固定比例';
						}else if(val.RATE_TYPE==3){
							RATE_TYPE = '固定比例+限额';
						}
						html+='<td colspan="3" class="head-title" align="center">阶段'+i+'（'+fenToYuan(val.STARTRANGE/100)+'元~'+fenToYuan(val.ENDRANGE/100)+'元）'+RATE_TYPE+'</td>';
						i++;
					});
					html+='<tr><td class="head-title" align="center">扣率（百分比）</td><td class="head-title" align="center">最低收费金额（元）</td>'+
					'<td class="head-title" align="center">最高收费金额（元）</td><td class="head-title" align="center">扣率（百分比）</td>'+
					'<td class="head-title" align="center">最低收费金额（元）</td><td class="head-title" align="center">最高收费金额（元）</td>'+
					'<td class="head-title" align="center">扣率（百分比）</td><td class="head-title" align="center">最低收费金额（元）</td><td class="head-title"align="center">最高收费金额（元）</td></tr><tr>';
					
					$.each(json, function(key, val) {
						html+='<td class="update" align="center">'+val.FEE_RATE+'</td><td class="update" align="center">'+val.MIN_FEE+'</td><td class="update" align="center">'+val.MAX_FEE+'</td>';
					});
					html+='</tr>';
			 		$("#rateMethodDetail_"+index).html(html);
			 		$("#rateMethod_"+index).html("累计金额分段计费");
				}
			});
		}
		
		function configMultilevelNumRate(index,rate_code){
			$.ajax({
				type: "POST",
				url: "fee/queryMultilevelRateDeta?tid=" + rate_code,
				dataType: "json",
				success: function(json) {
					
					var html = '<table width="100%" ><tr>';
					var i = 1;
					$.each(json, function(key, val) {
//	 					if(i==1){
//	 						html+='<tr><td class="head-title" align="center">扣率代码</td><td colspan="8" class="head-title" align="center">'+val.RATE_ID+'</td></tr>'
//	 					}
						var RATE_TYPE;
						if(val.RATE_TYPE==1){
							RATE_TYPE = '固定金额';
						}else if(val.RATE_TYPE==2){
							RATE_TYPE = '固定比例';
						}else if(val.RATE_TYPE==3){
							RATE_TYPE = '固定比例+限额';
						}
						html+='<td colspan="3" class="head-title" align="center">阶段'+i+'（'+val.STARTRANGE+'笔~'+val.ENDRANGE+'笔）'+RATE_TYPE+'</td>';
						i++;
					});
					html+='<tr><td class="head-title" align="center">扣率（百分比）</td><td class="head-title" align="center">最低收费金额（元）</td>'+
					'<td class="head-title" align="center">最高收费金额（元）</td><td class="head-title" align="center">扣率（百分比）</td>'+
					'<td class="head-title" align="center">最低收费金额（元）</td><td class="head-title" align="center">最高收费金额（元）</td>'+
					'<td class="head-title" align="center">扣率（百分比）</td><td class="head-title" align="center">最低收费金额（元）</td><td class="head-title" align="center">最高收费金额（元）</td></tr><tr>';
					
					$.each(json, function(key, val) {
						html+='<td class="update" align="center">'+val.FEE_RATE+'</td><td class="update" align="center">'+val.MIN_FEE+'</td><td class="update" align="center">'+val.MAX_FEE+'</td>';
					});
					html+='</tr>';
			 		$("#rateMethodDetail_"+index).html(html);
			 		$("#rateMethod_"+index).html("累计笔数分段计费");
				}
			});
		}
		
		function hideCWin(){
			$("#CWindow").hide();
			outerHeight("1");
		}
		
		function showCWin(){
			$("#CWindow").show();
			outerHeight("2");
		}
		function fenToYuan(value){
			var str = (value).toFixed(2) + '';
			var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
			var dot = str.substring(str.length,str.indexOf("."))
			var ret = intSum + dot;
			return ret;
		}
</script>
</body>

</html>
