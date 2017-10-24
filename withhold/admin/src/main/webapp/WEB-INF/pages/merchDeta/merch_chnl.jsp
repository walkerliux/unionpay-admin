<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<html>
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

table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}

table tr td.add {
	height: 25px;
}

table tr td.update {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
</style>
<script type="text/javascript" src="js/extendsValidator_1.0_20151215.js"></script>
</head>
<body>

	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="查询条件" style="height: 100px; padding: 10px; background: #fafafa;" iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">商户号</td>
						<td align="left" style="padding-left: 5px"><input
							name="memberId" id="s_memberId" maxlength="25" /></td>
						<td align="right">商户名称</td>
						<td align="left" style="padding-left: 5px"><input
							name="memberName" id="s_memberName" maxlength="25" /></td>
						<td align="right">通道名称</td>
						<td  align="left" style="padding-left: 5px">
							<select id="schannelName" name="target"/>
													
							</select>
						</td>
											
						<td class="add" align="right"><a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
						 <a href="javascript:clear()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>

	</div>

	<!-- 添加页面 -->
	<div id="wadd" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 500px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="addForm" action="" method="post">
					<table id="tableadd" width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" id="add_button_a" iconCls="icon-add" href="javascript:addSegment()" onclick="">添加通道</a>  
				<a class="easyui-linkbutton" id="save_button_a" iconCls="icon-ok" href="javascript:addAmtAccumRate()" onclick="">保存</a> 
				<a class="easyui-linkbutton" id="cancel_button_a" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>

	<!-- 修改页面 -->
	<div id="wupdate" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 500px; padding: 5px;">
			
			<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="updateForm" action="" method="post">
				<input type="hidden" id="tid" name="tid" />
					<input type="hidden" id="status" name="status" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<<tr style="height: 25px">
							<td class="update">商户号</td>
							<td class="update" align="left">
							<input type="text" id="umerchno" name="merchno" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入商户号"/><font color="red">*</font></td>
							<td class="update" width="15%">商户名称 </td>
							<td class="update" align="left">
							<input type="text" id="umemberName" name="memberName" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入商户名称 " /><font color="red">*</font></td>
						</tr>
						
						<tr style="height: 25px">
							<td class="update">通道名称</td>
							<td class="update" align="left">
							<select id="uschannelName" name="target"/>
							
							</select>
							<td class="update" width="15%">通道商户号 </td>
							<td class="update" align="left">
							<input type="text" id="uchnlmercno" name="chnlmercno" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入通道商户号 " /><font color="red">*</font></td>
						</tr>
					</table>
				</form>
			</div>
			
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeupdate()">返回</a>
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:updateMerchDChnl()" id="btn_submit">提交</a>
			</div>
		</div>
	</div>

</body>

<script>
	var width = $("#continer").width();
	var gridHeight = 600;
	var panelWidth = 800;
	var panelHeight = 230;
	var panelHoriFloat = (width - panelWidth) / 2;
	var panelVertFloat = 150;
	var width = $("#continer").width();
	 
	$(function() {
		showAllChannl("serch");
		$('#test')
				.datagrid(
						{
							title : '',
							iconCls : 'icon-save',
							height : gridHeight,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'merchDeta/queryMerchChnl',
							remoteSort : false,
							columns:[[	
										{field:'merchno',title:'商户号',align:'center',width:120},
										{field:'memberName',title:'商户名称',width:150,align:'center'},
										{field:'chnlcode',title:'通道编号',align:'center',width:200},
										{field:'chnlname',title:'通道名称',align:'center',width:100},
										{field:'chnlmercno',title:'通道商户号',align:'center',width:100},
										{field:'transfactors',title:'交易要素',align:'center',width:200},
										{field:'status',title:'状态',width:100,align:'center',
											formatter : function(value, rec) {
												if (value == "00") {
													return "有效";
												}
											}
										},
										{field:'tid',title:'操作',align:'center',width:120,rowspan:2,
											formatter:function(value,rec){
												if(rec.status=="00"){
													return '<a href="javascript:showChange(\''+value+'\')" style="color:blue;margin-left:10px">修改</a>';
												}else{
													return '';
												}
											}
										}
									]],
							pagination : true,
							rownumbers : true,
							toolbar : [ {
								id : 'btnadd',
								text : '新增',
								iconCls : 'icon-add',
								handler : function() {
									showAdd(false);
								}
							} ]
						});
		var p = $('#test').datagrid('getPager');
	});
	
	/* 弹出添加窗口 */
	function showAdd() {
		var output='';	// 拼接显示的内容
		
		
		// 拼接扣率描述+累计方式
		output += '<tr>';
		output += 	'<td class="update" width="15%">商户号</td>';
		output += 	'<td class="update" width="30%">';
		output += 	'<input id="a_merchno" name="merchno" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入商户号" />';
		output += 	'</td>';
		output += 	'<td class="update" width="15%">商户名</td>';
		output += 	'<td class="update" width="30%">';
		output += 	'<input id="memberName" name="memberName" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入商户名称" />';
		output += 	'</td>';
		output += '</tr>';
		output +='<tr>';
		output +='<td class="update">商户公钥</td>';
		output +='<td class="update" align="left">';
		output +='<input type="text" id="pubkey" name="pubkey" class="easyui-validatebox" required="true"';
		output +='maxlength="15" missingMessage="请输入商户公钥"/><font color="red">*</font></td>';
		output +='<td class="update" width="15%">商户私钥 </td>';
		output +='<td class="update" align="left">';
		output +='<input type="text" id="prikey" name="prikey" class="easyui-validatebox" required="true"';
		output +='maxlength="64" missingMessage="请输入商户私钥 " /><font color="red">*</font></td>';
		output +='</tr>';
		/*  <c:forEach var="每个变量名字"   items="要迭代的list"   varStatus="每个对象的状态"

             begin="循环从哪儿开始"    end="循环到哪儿结束"    step="循环的步长">

                循环要输出的东西
    </c:forEach> */
		output += '<tr class="segment seg1">';
		output += 	'<td colspan="4" class="head-title update">通道1</td>';
		output += '</tr>'
		output += '<tr>'		
			output += '<tr>';
		output += 	'<td class="update" width="15%">通道名称</td>';
		output += 	'<td class="update" width="30%">';
		output += 	'<input id="chnlname" name="chnlname" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入通道名称" />';
		output += 	'</td>';
		output += 	'<td class="update" width="15%">通道商户号</td>';
		output += 	'<td class="update" width="30%">';
		output += 	'<input id="chnlmercno" name="chnlmercno" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入商户名称" />';
		output += 	'</td>';
		output += '</tr>';
		output +='<tr>';
		output +='<td class="update">通道公钥</td>';
		output +='<td class="update" align="left">';
		output +='<input type="text" id="chnlpubkey" name="chnlpubkey" class="easyui-validatebox" required="true"';
		output +='maxlength="15" missingMessage="请输入通道公钥"/><font color="red">*</font></td>';
		output += '</tr>';		
		output += '<tr id="notes" display="none"></tr>';		
		output += '</tr>';
		$('#tableadd').html(output);
		
		$.parser.parse('#tableadd');
		
//		$("#addForm").attr("action", "fee/saveAmtAccumRate");
		$('#wadd').window({
			title : '商户通道维护',
			top : panelVertFloat,
			left : panelHoriFloat,
			width : panelWidth,
			height : panelHeight + 26*3,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : true,
			shadow : true,
			closed : false
		});
		//失去焦点
		$("#a_merchno").blur(
				function (){
				 var merchno =$("#a_merchno").val;
				showMerchChnl(merchno);	
				
			});
	}
	
	function closeAdd() {
		$('#wadd').window('close');
	}
	function closeupdate() {
		$('#wupdate').window('close');
	}
	function closeDetail() {
		$('#wdetail').window('close');
	}
	function search() {
		var data = {
			'memberId':$('#s_memberId').val(),
			'memberName':$("#s_memberName").val(),
			'cacode':$("#schannelName").val(),
		};
		$('#test').datagrid('load', data);
	}
	
		
	// 清空查询
	function clear() {
		$('#theForm :input').val('');
	}
	
	//修改页面保存
	function updateMerchDChnl(){
		$('#updateForm').form('submit', {  
		    onSubmit: function(){  
		    	if($('#updateForm').form('validate')){
		    		$('#btn_submit').linkbutton('disable');	
		    		return true;   
			    }
		        return false;   
		    }, 
		    success: function(json) {
	    		$('#btn_submit').linkbutton('enable');
	    		json = JSON.parse(json);
	    		if(json.resultBool==true){
					 $.messager.alert('提示',"操作成功！");
					 $('#wupdate').window('close');
					 search();
				}else{
					 $.messager.alert('提示',json.errMsg);
				}
			}
		}); 
	}
	
	function addAmtAccumRate(){
		$('#addForm').form('submit', {  
		    onSubmit: function(){  
		    	if($('#addForm').form('validate')){
		    		$('#btn_submit').linkbutton('disable');	
		    		return true;   
			    }
		        return false;   
		    }, 
		    success: function(json) {
	    		$('#btn_submit').linkbutton('enable');
	    		json = JSON.parse(json);
	    		if(json.resultBool==true){
					 $.messager.alert('提示',"操作成功！");
					 $('#wadd').window('close');
					 search();
				}else{
					 $.messager.alert('提示',json.errMsg);
				}
			}
		}); 
	}
	// 添加通道
	function addSegment(){
		var segmentIndex = $('.segment').length;//每一段有个class="segment"的标记，故统计出段数
		var output='';	// 拼接显示的内容
		
		output += '<tr class="segment seg' + (segmentIndex + 1) + '">';
		output += 	'<td colspan="4" class="head-title update">';
		output += 		'通道' + (segmentIndex + 1);
		output +=	'</td>';
		output += '</tr>';
		
		output += '<tr>';
		output += 	'<td class="update" width="15%">通道名称</td>';
		output += 	'<td class="update" width="30%">';
		output += 	'<input id="chnlname' + (segmentIndex + 1) + '" name="chnlname' + (segmentIndex + 1) + '" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入商户号" />';
		output += 	'</td>';
		output += 	'<td class="update" width="15%">通道商户号</td>';
		output += 	'<td class="update" width="30%">';
		output += 	'<input id="chnlmercno' + (segmentIndex + 1) + '" name="chnlmercno' + (segmentIndex + 1) + '" maxlength="64" class="easyui-validatebox" required="true" missingMessage="请输入商户名称" />';
		output += 	'</td>';
		output += '</tr>';
		output +='<tr>';
		output +='<td class="update">通道公钥</td>';
		output +='<td class="update" align="left">';
		output +='<input type="text" id="chnlpubkey' + (segmentIndex + 1) + '" name="chnlpubkey' + (segmentIndex + 1) + '" class="easyui-validatebox" required="true"';
		output +='maxlength="15" missingMessage="请输入通道公钥"/><font color="red">*</font></td>';
		output += '</tr>';
		
		
		
		$('#notes').before(output);
		
		resize("wadd");
		$.parser.parse('#tableadd');
		
		
	}
	
	function showAllChnlcode(type){
		$.ajax({
			type : "POST",
			url: "/channel/queryChannelAll",
			dataType: "json",
			success: function(json) {
				var html = "<option value=''>--请选择通道--</option>";
				$.each(json,function(key, value) {
						html += '<option value="' + value.cacode + '">' + value.caname + '</option>';
				});
				$("#schannelName").html(html);
			}
		});		
	}
	
	// 重置面板高度
	function resize(winid){
		var trNum = $('#addForm tr').length;
		$('#' + winid).window('resize',{
			height: panelHeight + (trNum - 4) * 25.556
		});
	}
	

	function showChannl(chnlcode){
		$.ajax({
			type : "POST",
			url: "channel/queryChannelAll",
			dataType: "json",
			success: function(json) {
				var html = "<option value=''>--请选择通道--</option>";
				
				$.each(json,function(key, value) {
					if (value.chnlcode == chnlcode) {
						html += '<option value="' + value.chnlcode + '" selected="selected">' + value.chnlname + '</option>';
					} else {
						html += '<option value="' + value.chnlcode + '">' + value.chnlname + '</option>';
					}
				});
				$("#uschannelName").html(html);
			}
		});
	}
	
	function showAllChannl(caprovince) {
		var em="";
		$.ajax({
			type: "POST",
			url: "channel/queryChannelAll",
			dataType: "json",
			success: function(json) {
				var html = html += '<option value="' + em + '">--全部--</option>';
				$.each(json,function(key, value) {
						html += '<option value="' + value.chnlcode + '">' + value.chnlname + '</option>';
				}) ;
				
				$("#schannelName").html(html);
			}
		});
	}
	
	

	
	function showChange(tid){
		$('#updateForm :input').val('');
		$('#umerchno').attr("readonly","readonly");//设为只读
		$('#umemberName').attr("readonly","readonly");//设为只读
		$("#updateForm").attr("action","merchDeta/updateMerchDChnl");
		
		$.ajax({
			   type: "POST",
			   url: "merchDeta/querydateMerchChnlById",
			   data: "tid="+tid,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   if (json == null) {
						$.messager.alert('提示', '该商户通道信息不存在，或已被变更，请刷新一下数据再试试！');
					} else {
					    $("#umerchno").val(json.merchno);
						$("#umemberName").val(json.memberName);
						$("#uchnlmercno").val(json.chnlmercno);
						showChannl(json.chnlcode);
						
						$('#wupdate').window({
							title: '变更商户通道信息',
							top:100,
							left:400,
							width: 800,
							modal: true,
							minimizable:false,
							collapsible:false,
							maximizable:false,
							shadow: false,
							closed: false,
							height: 409
						});
					}
			    },
				error : function(){
					$.messager.alert('提示', '服务异常！');
				}
			});
	}
	

	//失去焦点
	
	function showMerchChnl(merchno){
		var output='';	// 拼接显示的内容
//		$("#addForm").attr("action", "merchDeta/addMerchChnl");
		
		$('#wadd').window({
			title : '商户通道维护',
			top : panelVertFloat,
			left : panelHoriFloat,
			width : panelWidth,
			height : panelHeight,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : true,
			shadow : true,
			closed : false,
		});
		var data={'memberId':merchno};
		$.ajax({
			type : "POST",
			url : "merchDeta/queryMerchChnl",
			async : false,
			dataType : "json",
			success : function(json) {
				var output='';	// 拼接显示的内容
		 		 var rows = json.rows;
				output += '<tr>';
				output += 	'<td class="update" width="15%">商户号</td>';
				output += 	'<td class="update" width="30%">';
				output += 	'<input id="a_merchno" name="merchno" maxlength="64" class="easyui-validatebox" required="true" value="' + rows[0].merchno + '" />';
				output += 	'</td>';
				output += 	'<td class="update" width="15%">商户名</td>';
				output += 	'<td class="update" width="30%">';
				output += 	'<input id="memberName" name="memberName" maxlength="64" class="easyui-validatebox" required="true" value="' +rows[0].memberName + '"/>';
				output += 	'</td>';
				output += '</tr>';
				output +='<tr>';
				output +='<td class="update">商户公钥</td>';
				output +='<td class="update" align="left">';
				output +='<input type="text" id="pubkey" name="pubkey" class="easyui-validatebox" required="true"';
				output +='maxlength="15" value="' + rows[0].pubkey + '"/><font color="red">*</font></td>';
				output +='<td class="update" width="15%">商户私钥 </td>';
				output +='<td class="update" align="left">';
				output +='<input type="text" id="prikey" name="prikey" class="easyui-validatebox" required="true"';
				output +='maxlength="64" value="' + rows[0].prikey + '" /><font color="red">*</font></td>';
				output +='</tr>';
				
		     // 循环要输出的东西
		   
		   
			for (var i = 0; i < rows.length; i++) {
				output += '<tr class="segment seg1">';
				output += 	'<td colspan="4" class="head-title update">通道'+(i+1)+'</td>';
				output += '</tr>'
				output += '<tr>'		
				output += '<tr>';
				output += 	'<td class="update" width="15%">通道名称</td>';
				output += 	'<td class="update" width="30%">';
				output += 	'<input id="chnlname' + (i + 1) + '" name="chnlname" maxlength="64" class="easyui-validatebox" required="true" value="' + rows[i].chnlname + '"/>';
				output += 	'</td>';
				output += 	'<td class="update" width="15%">通道商户号</td>';
				output += 	'<td class="update" width="30%">';
				output += 	'<input id="chnlmercno' + (i + 1) + '" name="chnlmercno" maxlength="64" class="easyui-validatebox" required="true" value="' + rows[i].chnlmercno + '" />';
				output += 	'</td>';
				output += '</tr>';
				output +='<tr>';
				output +='<td class="update">通道公钥</td>';
				output +='<td class="update" align="left">';
				output +='<input type="text" id="chnlpubkey' + (i + 1) + '" name="chnlpubkey" class="easyui-validatebox" required="true"';
				output +='maxlength="15" value="' + rows[i].chnlpubkey + '"/><font color="red">*</font></td>';
				output += '</tr>';		
				
			}
				output += '<tr id="notes" display="none"></tr>';		
				output += '</tr>';
				
		
				$('#tableadd').html(output);
				
				$.parser.parse('#tableadd');
			
			
			}
		});
		
	}
</script>
</html>
