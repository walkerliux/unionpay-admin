<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../../top.jsp"></jsp:include>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<script type="text/javascript" src="js/extendsValidator_1.0_20151215.js"></script>
<style type="text/css">
table {
	
}
#continer table tr td {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}

#continer table tr td input {
	width:250px;
	height: 15px;
	
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
</head>
<body>
	<div style="margin: 5px;" id="continer">
		<div id="title" name="title" class="easyui-panel" title="委托机构开通"
			style="background: #fafafa;" iconCls="icon-save" collapsible="false">
			<div style="padding-left: 5px; padding-right: 5px">
				<form id="merchDetaForm" action="" method="post">
					<input type="hidden" id="flag_ins" value="${flag}" />
					<table width="100%">
						<tr>
							<td colspan="4" class="head-guide">
								第一步:委托机构信息录入<img src="<%=basePath%>pictuer/tag.jpg" style="height: 10px"/><font class="current-step">第二步:配置计费方式</font><img src="<%=basePath%>pictuer/tag.jpg" style="height: 10px"/>第三步:上传证件照片</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">四、计费标准</td>
						</tr>
						<tr>
							<td align="center">借贷方式</td>
							<td colspan="3">
								<input type="radio" name="CDType" style="width:20px;vertical-align: middle;" checked="checked" value="1" onclick="hideCWin()"/>借贷合并
								<input type="radio" name="CDType" style="width:20px;vertical-align: middle;" id="c_radio" value="2" onclick="showCWin()"/>借贷分离
							</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title">借记卡</td>
						</tr>
						<tr>
							<td align="center">实时代收</td>
							<td align="center" width="10%">
								<select id="rateMethod_01" name="rateMethod">
									<option value="">--请选择计费方式--</option>
									<option value="01">按笔收费</option>
									<option value="02">按扣率收费</option>
									<option value="03">累计金额分段计费</option>
									<option value="04">累计笔数分段计费</option>
								</select>
							</td>
							<td colspan="2">
								<a href="javascript: openChargeWindow('01');" class="easyui-linkbutton" style="color:blue" data-options="toggle:true,group:'g2',plain:true">配置计费方式</a>
								<input type="hidden" id="rateBusiCode_01" value="11000001"/>
								<div id="rateMethodDetail_01" style="margin-right:  5px;margin-bottom: 5px">
								</div>
							</td>
						</tr>
						<tr>
							<td align="center">实时代付</td>
							<td align="center" width="10%">
								<select id="rateMethod_02" name="rateMethod" required="true">
									<option value="">--请选择计费方式--</option>
									<option value="01">按笔收费</option>
									<option value="02">按扣率收费</option>
									<option value="03">累计金额分段计费</option>
									<option value="04">累计笔数分段计费</option>
								</select>
							</td>
							<td colspan="2">
								<a href="javascript:openChargeWindow('02');" class="easyui-linkbutton" style="color:blue" data-options="toggle:true,group:'g2',plain:true">配置计费方式</a>
								<input type="hidden" id="rateBusiCode_02" value="11000002"/>
								<div id="rateMethodDetail_02" style="margin-right:  5px;margin-bottom: 5px">
									
								</div>
							</td>
						</tr>
						<tr>
							<td align="center">批量代收</td>
							<td align="center" width="10%">
								<select id="rateMethod_03" name="rateMethod" required="true">
									<option value="">--请选择计费方式--</option>
									<option value="01">按笔收费</option>
									<option value="02">按扣率收费</option>
									<option value="03">累计金额分段计费</option>
									<option value="04">累计笔数分段计费</option>
								</select>
							</td>
							<td colspan="2">
								<a href="javascript:openChargeWindow('03');" class="easyui-linkbutton" style="color:blue" data-options="toggle:true,group:'g2',plain:true">配置计费方式</a>
								<input type="hidden" id="rateBusiCode_03" value="11000003"/>
								<div id="rateMethodDetail_03" style="margin-right:  5px;margin-bottom: 5px">
									
								</div>
							</td>
						</tr>
						<tr>
							<td align="center">批量代付</td>
							<td align="center" width="10%">
								<select id="rateMethod_04" name="rateMethod" required="true">
									<option value="">--请选择计费方式--</option>
									<option value="01">按笔收费</option>
									<option value="02">按扣率收费</option>
									<option value="03">累计金额分段计费</option>
									<option value="04">累计笔数分段计费</option>
								</select>
							</td>
							<td colspan="2">
								<a href="javascript:openChargeWindow('04');" class="easyui-linkbutton" style="color:blue" data-options="toggle:true,group:'g2',plain:true">配置计费方式</a>
								<input type="hidden" id="rateBusiCode_04" value="11000004"/>
								<div id="rateMethodDetail_04" style="margin-right:  5px;margin-bottom: 5px">
								</div>
							</td>
						</tr>
						<tbody style="display: none" id="CWindow">
							<tr>
								<td colspan="4" class="head-title">贷记卡</td>
							</tr>
							<tr>
								<td align="center">实时代收</td>
								<td align="center" width="10%">
									<select id="rateMethod_05" name="rateMethod" required="true">
										<option value="">--请选择计费方式--</option>
										<option value="01">按笔收费</option>
										<option value="02">按扣率收费</option>
										<option value="03">累计金额分段计费</option>
										<option value="04">累计笔数分段计费</option>
									</select>
								</td>
								<td colspan="2">
									<a href="javascript:openChargeWindow('05');" class="easyui-linkbutton" style="color:blue" data-options="toggle:true,group:'g2',plain:true">配置计费方式</a>
									<input type="hidden" id="rateBusiCode_05" value="11000001"/>
									<div id="rateMethodDetail_05" style="margin-right:  5px;margin-bottom: 5px">
										
									</div>
								</td>
							</tr>
							<tr>
								<td align="center">实时代付</td>
								<td align="center" width="10%">
									<select id="rateMethod_06" name="rateMethod" required="true">
										<option value="">--请选择计费方式--</option>
										<option value="01">按笔收费</option>
										<option value="02">按扣率收费</option>
										<option value="03">累计金额分段计费</option>
										<option value="04">累计笔数分段计费</option>
									</select>
								</td>
								<td colspan="2">
									<a href="javascript:openChargeWindow('06');" class="easyui-linkbutton" style="color:blue" data-options="toggle:true,group:'g2',plain:true">配置计费方式</a>
									<input type="hidden" id="rateBusiCode_06" value="11000002"/>
									<div id="rateMethodDetail_06" style="margin-right:  5px;margin-bottom: 5px">
									</div>
								</td>
							</tr>
							<tr>
								<td align="center">批量代收</td>
								<td align="center" width="10%">
									<select id="rateMethod_07" name="rateMethod" required="true">
										<option value="">--请选择计费方式--</option>
										<option value="01">按笔收费</option>
										<option value="02">按扣率收费</option>
										<option value="03">累计金额分段计费</option>
										<option value="04">累计笔数分段计费</option>
									</select>
								</td>
								<td colspan="2">
									<a href="javascript:openChargeWindow('07');" class="easyui-linkbutton" style="color:blue" data-options="toggle:true,group:'g2',plain:true">配置计费方式</a>
									<input type="hidden" id="rateBusiCode_07" value="11000003"/>
									<div id="rateMethodDetail_07" style="margin-right:  5px;margin-bottom: 5px">
									</div>
								</td>
							</tr>
							<tr>
								<td align="center">批量代付</td>
								<td align="center" width="10%">
									<select id="rateMethod_08" name="rateMethod" required="true">
										<option value="">--请选择计费方式--</option>
										<option value="01">按笔收费</option>
										<option value="02">按扣率收费</option>
										<option value="03">累计金额分段计费</option>
										<option value="04">累计笔数分段计费</option>
									</select>
								</td>
								<td colspan="2">
									<a href="javascript:openChargeWindow('08');" class="easyui-linkbutton" style="color:blue" data-options="toggle:true,group:'g2',plain:true">配置计费方式</a>
									<input type="hidden" id="rateBusiCode_08" value="11000004"/>
									<div id="rateMethodDetail_08" style="margin-right:  5px;margin-bottom: 5px">
										
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a href="javascript:toFirstStep();" class="easyui-linkbutton" iconCls="icon-back">上一步</a>
				<a class="easyui-linkbutton" iconCls="icon-ok" id="button_id" href="javascript:saveChargeMode()" onclick="">下一步</a> 
				<a href="javascript:backToAgencyIndex()" class="easyui-linkbutton" iconCls="icon-back">返回</a>
			</div>
		</div>
	</div>
	<form action="associatedagency/saveAgencyRateConfig" method="post" id="agencyRateForm">
		<!-- 此处别忘记修改委托机构号 -->
		<input type="hidden" name="merchApplyId" id="rc_merchApplyId" value="${merchApplyId}" /> 
		<input type="hidden" name="memberId" id="rc_memberId" value="${memberId}" /> 
		<input type="hidden" name="status" id="rc_status" value="${status}" /> 
		<input type="hidden" name="rateCode" id="rc_rateCode"/>
		<input type="hidden" name="cardType" id="rc_cardType"/> 
		<input type="hidden" name="busiCode" id="rc_busiCode"/>
		<input type="hidden" name="rateMethod" id="rc_rateMethod"/>
	</form>
	<jsp:include page="../fee/rate_common_number.jsp"/>
	<jsp:include page="../fee/rate_common_discount.jsp"/>
	<jsp:include page="../fee/rate_accumulate_amt.jsp"/>
	<jsp:include page="../fee/rate_accumulate_num.jsp"/>
	
</body>
<script>
	  $(function() {
		  initAgencyRate();
		});
	  var rootMethod;
	  var rootIndex;
		function openChargeWindow(index){
			
			if($("#rateMethod_"+index).val()==null||$("#rateMethod_"+index).val()==''){
				$.messager.alert('提示', "请选择计费方式");
			}else{
				rootMethod = $("#rateMethod_"+index).val();
				rootIndex = index;
				if(index<5){
					$("#rc_cardType").val(1);
				}else{
					$("#rc_cardType").val(2);
					//alert($("#rc_cardType").val());
				}
				if($("#rateMethod_"+index).val()=="01"){
					showCommonChargeMode();
				}else if($("#rateMethod_"+index).val()=="02"){
					showDiscountChargeMode();
				}else if($("#rateMethod_"+index).val()=="03"){
					showMultilevelChargeMode();
				}else if($("#rateMethod_"+index).val()=="04"){
					showMultilevelChargeNumMode()
				}
			}
		}
		
		function closeChargeWindow() {
			$('#w').window('close');
		}
		
		function backToAgencyIndex(){
			var flag = $("#flag_ins").val();
			if(flag == "1"){
				window.location.href= "<%=basePath%>" +'associatedagency/showManager';
			}else if(flag == "4"){
				window.location.href= "<%=basePath%>" +'associatedagency/showMerchModify';
			}
		}
		function fenToYuan(value){
			var str = (value).toFixed(2) + '';
			var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
			var dot = str.substring(str.length,str.indexOf("."))
			var ret = intSum + dot;
			return ret;
		}
		function toFirstStep(){
			var flag = $("#flag_ins").val();
			if(flag == "1"){
				window.location.href= "<%=basePath%>" +'associatedagency/toMerchChange?merchApplyId=' + $('#rc_merchApplyId').val();
			}else if(flag == "4"){
				window.location.href= "<%=basePath%>" +'associatedagency/toMerchModifyEdit?merchApplyId='+$('#rc_merchApplyId').val();
			}
		}
		function saveChargeMode(){
			var memberId = $("#rc_memberId").val();
			var cardType = $("input[name='CDType']:checked").val();
			$.ajax({
				type: "POST",
				url: "associatedagency/queryAgencyRateConfig?memberId=" + memberId,
				dataType: "json",
				success: function(json) {
					if(json.length  == 0){
						$.messager.alert('提示', '请添加计费方式配置');
						return false;
					}
					$.each(json, function(key, val) {
						if(cardType == "1"){
							if(json.length  == 4){
								commitMerch();
								return false;
							}else{
								$.messager.alert('提示',"计费方式配置未完成！");
								return false;
							}
						}else if(cardType == "2"){
							if(json.length  == 8){
								commitMerch();
								return false;
							}else{
								$.messager.alert('提示',"计费方式配置未完成！");
								return false;
							}
						}
					});
				}
			});
		}
		function commitMerch(){
			var flag = $("#flag_ins").val();
			var merchApplyId = $("#rc_merchApplyId").val();
			var status = $("#rc_status").val();
			if(status == "12" || status == "32"){
				if(flag == "1"){
					window.location.href= "<%=basePath%>" +'associatedagency/toUpload?merchApplyId='+merchApplyId;
					return false;
				}else if(flag == "4"){
					window.location.href= "<%=basePath%>" + 'associatedagency/toUploadModifyInfo?merchApplyId='+merchApplyId;
					return false;
				}
			}
			$.ajax({
				type: "POST",
				url: "associatedagency/commitMerch",
				data: "rand=" + new Date().getTime()+"&merchApplyId="+merchApplyId,
				dataType: "json",
				success: function(json) {
					$.each(json,function(key, value) {
						if (value.RET == "succ") {
							$.messager.alert('提示','计费方式配置成功','info',function(){
								if(flag == "1"){
									window.location.href= "<%=basePath%>" +'associatedagency/toUpload?merchApplyId='+merchApplyId;
								}else if(flag == "4"){
									window.location.href= "<%=basePath%>" +'associatedagency/toUploadModifyInfo?merchApplyId='+merchApplyId;
								}
							});
						} else {
							$.messager.alert('提示', value.INFO);
						}
					});
				}
			});
		}
		
		function saveRate(){
			$("#segmented").show();
			$('#w').window('close');
		}
		
		function hideCWin(){
			$("#CWindow").hide();
		}
		
		function showCWin(){
			$("#CWindow").show();
		}
		
		function saveAgencyRateConfig(){
			$('#agencyRateForm').form('submit', {
				success: function(data) {
				}
			});
		}
		
		function saveCommonRate(){
			var row = $('#charge_mode_common_grid').datagrid('getSelected');
			if(row){
				 closeCommonRateWindow();
				 var html='<table width="100%" >'+
				          '<tr><td class="head-title">扣率代码</td><td class="head-title">扣率描述</td><td class="head-title">计费方式</td><td class="head-title">金额</td></tr>'+
				          '<tr><td>'+row.RATE_ID+'</td><td>'+row.RATE_DESC+'</td><td>'+row.RATE_TYPE_NAME+'</td><td>'+row.MIN_FEE+'</td></tr>'+
				          '</table>';
				 $("#rateMethodDetail_"+rootIndex).html(html);
				 $("#rc_rateCode").val(row.RATE_ID);
				 $("#rc_busiCode").val($("#rateBusiCode_"+rootIndex).val());
				 $("#rc_rateMethod").val($("#rateMethod_"+rootIndex).val());
				saveAgencyRateConfig();
			}else{
				$.messager.alert('提示', "请选择扣率");
			}
		}
		function saveDiscountRate(){
			var row = $('#charge_mode_common_discount_grid').datagrid('getSelected');
			if(row){
				 var html='<table width="100%" >'+
		          '<tr><td class="head-title">扣率代码</td><td class="head-title">扣率描述</td><td class="head-title">计费方式</td><td class="head-title">扣率(百分比)</td><td class="head-title">最低额(元) </td><td class="head-title">最高额(元) </td></tr>'+
		          '<tr><td>'+row.RATE_ID+'</td><td>'+row.RATE_DESC+'</td><td>'+row.RATE_TYPE_NAME+'</td><td>'+row.FEE_RATE+'</td><td>'+row.MIN_FEE+'</td><td>'+row.MAX_FEE+'</td></tr>'+
		          '</table>';
				 $("#rateMethodDetail_"+rootIndex).html(html);
				 $("#rc_rateCode").val(row.RATE_ID);
				 $("#rc_busiCode").val($("#rateBusiCode_"+rootIndex).val());
				 $("#rc_rateMethod").val($("#rateMethod_"+rootIndex).val());
				 closeDiscountWindow();
				 saveAgencyRateConfig();
				          
			}else{
				$.messager.alert('提示', "请选择扣率");
			}
		}
		function saveMultilevelAmtRate(){
			var row = $('#multilevel_charge_mode_grid').datagrid('getSelected');
			if(row){
				 closeMultilevelAmtRateWindow();
				 $("#rc_rateCode").val(row.RATE_ID);
				 $("#rc_busiCode").val($("#rateBusiCode_"+rootIndex).val());
				 $("#rc_rateMethod").val($("#rateMethod_"+rootIndex).val());
				 $.ajax({
					type: "POST",
					url: "fee/queryMultilevelRateDeta?tid=" + row.RATE_ID,
					dataType: "json",
					success: function(json) {
						
						var html = '<table width="100%" ><tr>';
						var i = 1;
						$.each(json, function(key, val) {
							if(i==1){
								html+='<tr><td class="head-title">扣率代码</td><td colspan="8" class="head-title">'+val.RATE_ID+'</td></tr>'
							}
							var RATE_TYPE;
							if(val.RATE_TYPE==1){
								RATE_TYPE = '固定金额';
							}else if(val.RATE_TYPE==2){
								RATE_TYPE = '固定比例';
							}else if(val.RATE_TYPE==3){
								RATE_TYPE = '固定比例+限额';
							}
							html+='<td colspan="3" class="head-title">阶段'+i+'（'+fenToYuan(val.STARTRANGE/100)+'元~'+fenToYuan(val.ENDRANGE/100)+'元）'+RATE_TYPE+'</td>';
							i++;
						});
						html+='<tr><td class="head-title">扣率（百分比）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td><td class="head-title">扣率（百分比	）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td><td class="head-title">扣率（百分比）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td></tr><tr>';
						
						$.each(json, function(key, val) {
							html+='<td>'+val.FEE_RATE+'</td><td>'+val.MIN_FEE+'</td><td>'+val.MAX_FEE+'</td>';
						});
						html+='</tr>';
				 		$("#rateMethodDetail_"+rootIndex).html(html);
				 		saveAgencyRateConfig();
					}
				});
			}else{
				$.messager.alert('提示', "请选择扣率");
			}
		}
		
		function saveMultilevelNumRate(){
			var row = $('#multilevel_charge_mode_num_grid').datagrid('getSelected');
			if(row){
				closeMultilevelNumRateWindow();
				$("#rc_rateCode").val(row.RATE_ID);
				$("#rc_busiCode").val($("#rateBusiCode_"+rootIndex).val());
				 $("#rc_rateMethod").val($("#rateMethod_"+rootIndex).val());
				 $.ajax({
					type: "POST",
					url: "fee/queryMultilevelRateDeta?tid=" + row.RATE_ID,
					dataType: "json",
					success: function(json) {
						var html = '<table width="100%" ><tr>';
						var i = 1;
						$.each(json, function(key, val) {
							if(i==1){
								html+='<tr><td class="head-title">扣率代码</td><td colspan="8" class="head-title">'+val.RATE_ID+'</td></tr>'
							}
							var RATE_TYPE;
							if(val.RATE_TYPE==1){
								RATE_TYPE = '固定金额';
							}else if(val.RATE_TYPE==2){
								RATE_TYPE = '固定比例';
							}else if(val.RATE_TYPE==3){
								RATE_TYPE = '固定比例+限额';
							}
							html+='<td colspan="3" class="head-title">阶段'+i+'（'+val.STARTRANGE+'笔~'+val.ENDRANGE+'笔）'+RATE_TYPE+'</td>';
							i++;
						});
						html+='<tr><td class="head-title">扣率（百分比）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td><td class="head-title">扣率（百分比	）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td><td class="head-title">扣率（百分比）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td></tr><tr>';
						$.each(json, function(key, val) {
							html+='<td>'+val.FEE_RATE+'</td><td>'+val.MIN_FEE+'</td><td>'+val.MAX_FEE+'</td>';
						});
						html+='</tr>';
				 		$("#rateMethodDetail_"+rootIndex).html(html);
				 		saveAgencyRateConfig();
					}
				});
			}else{
				$.messager.alert('提示', "请选择扣率");
			}
		}
		
		//初始化委托机构所有扣率信息
		function initAgencyRate(){
			var memberId = $("#rc_memberId").val();
			$.ajax({
				type: "POST",
				url: "associatedagency/queryAgencyRateConfig?memberId=" + memberId,
				dataType: "json",
				success: function(json) {
					$.each(json, function(key, val) {
						if(val.cardType=="1"){
							init_d_rate_config(val);
						}else if(val.cardType=="2"){
							showCWin();//显示贷记卡内容
							$("#c_radio").attr("checked","checked");
							init_c_rate_config(val);
						}else{
							resize();
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
				
			}else if(val.busiCode=="11000002"){
				index = "02";
				
			}else if(val.busiCode=="11000003"){
				index = "03";
				
			}else if(val.busiCode=="11000004"){
				index = "04";
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
				index = "05";
			}else if(val.busiCode=="11000002"){
				index = "06";
			}else if(val.busiCode=="11000003"){
				index = "07";
			}else if(val.busiCode=="11000004"){
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
			 			$("#rateMethod_"+index).val("01");
			 			var html='<table width="100%" >'+
				          '<tr><td class="head-title">扣率代码</td><td class="head-title">扣率描述</td><td class="head-title">计费方式</td><td class="head-title">金额</td></tr>'+
				          '<tr><td>'+json.RATE_ID+'</td><td>'+json.RATE_DESC+'</td><td>单笔固定金额</td><td>'+fenToYuan(json.MIN_FEE/100)+'</td></tr>'+
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
				          '<tr><td class="head-title">扣率代码</td><td class="head-title">扣率描述</td><td class="head-title">计费方式</td><td class="head-title">扣率(百分比)</td><td class="head-title">最低额(元) </td><td class="head-title">最高额(元) </td></tr>'+
				          '<tr><td>'+json.RATE_ID+'</td><td>'+json.RATE_DESC+'</td><td>'+rate_type_name+'</td><td>'+fenToYuan(json.FEE_RATE/100)+'</td><td>'+fenToYuan(json.MIN_FEE/100)+'</td><td>'+fenToYuan(json.MAX_FEE/100)+'</td></tr>'+
				          '</table>';
						 $("#rateMethodDetail_"+rootIndex).html(html);
				 		$("#rateMethodDetail_"+index).html(html);
			 			$("#rateMethod_"+index).val("02");
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
						if(i==1){
							html+='<tr><td class="head-title">扣率代码</td><td colspan="8" class="head-title">'+val.RATE_ID+'</td></tr>'
						}
						var RATE_TYPE;
						if(val.RATE_TYPE==1){
							RATE_TYPE = '固定金额';
						}else if(val.RATE_TYPE==2){
							RATE_TYPE = '固定比例';
						}else if(val.RATE_TYPE==3){
							RATE_TYPE = '固定比例+限额';
						}
						html+='<td colspan="3" class="head-title">阶段'+i+'（'+fenToYuan(val.STARTRANGE/100)+'元~'+fenToYuan(val.ENDRANGE/100)+'元）'+RATE_TYPE+'</td>';
						i++;
					});
					html+='<tr><td class="head-title">扣率（百分比）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td><td class="head-title">扣率（百分比	）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td><td class="head-title">扣率（百分比）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td></tr><tr>';
					
					$.each(json, function(key, val) {
						html+='<td>'+val.FEE_RATE+'</td><td>'+val.MIN_FEE+'</td><td>'+val.MAX_FEE+'</td>';
					});
					html+='</tr>';
			 		$("#rateMethodDetail_"+index).html(html);
			 		$("#rateMethod_"+index).val("03");
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
						if(i==1){
							html+='<tr><td class="head-title">扣率代码</td><td colspan="8" class="head-title">'+val.RATE_ID+'</td></tr>'
						}
						var RATE_TYPE;
						if(val.RATE_TYPE==1){
							RATE_TYPE = '固定金额';
						}else if(val.RATE_TYPE==2){
							RATE_TYPE = '固定比例';
						}else if(val.RATE_TYPE==3){
							RATE_TYPE = '固定比例+限额';
						}
						html+='<td colspan="3" class="head-title">阶段'+i+'（'+val.STARTRANGE+'笔~'+val.ENDRANGE+'笔）'+RATE_TYPE+'</td>';
						i++;
					});
					html+='<tr><td class="head-title">扣率（百分比）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td><td class="head-title">扣率（百分比	）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td><td class="head-title">扣率（百分比）</td><td class="head-title">最低收费金额（元）</td><td class="head-title">最高收费金额（元）</td></tr><tr>';
					
					$.each(json, function(key, val) {
						html+='<td>'+val.FEE_RATE+'</td><td>'+val.MIN_FEE+'</td><td>'+val.MAX_FEE+'</td>';
					});
					html+='</tr>';
			 		$("#rateMethodDetail_"+index).html(html);
			 		$("#rateMethod_"+index).val("04");
				}
			});
		}
	</script>
</html>

