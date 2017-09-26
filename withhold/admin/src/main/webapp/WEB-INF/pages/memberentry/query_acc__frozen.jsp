<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="../../top.jsp"></jsp:include>

<head>

<!-- 收支明细查询 -->
<style type="text/css">
table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
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


</head>
<body>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 120px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
<!-- 					    <td align="center">账户ID号</td> -->
<!-- 						<td colspan="1"> -->
<!-- 							<input name="sccId"  type="text" id="sccId" maxlength="15" onkeyup="value=value.replace(/[^\d]/g,'')"/> -->
<!-- 						</td> -->
							
						<td class="add" align="center">科目号</td>
						<td colspan="1"><input name="acctCode" type="text" id="acctCode" maxlength="22" onkeyup="value=value.replace(/[^\d]/g,'')">
						
						<td class="add" align="right">
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
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="saveForm" action="" method="post">
					<input type="hidden" id="acc_id" name="accId" />
					<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td width="18%" class="update">账户号 </td>
							<td width="28%" align="left" class="update"><span id="b_acctCode"></span></td>
							<td width="18%" class="update">目标状态</td>
							<td width="28%" align="left" class="update"><span id="memberId"></span></td>
						</tr>
						<tr>
							<td class="update" align="center">审核意见</td>
							<td class="update" colspan="3" align="center"><textarea rows="3"
									cols="80" style="margin: 5px" maxlength="60" id="STOPINION" name="cvlexaOpt"></textarea>
							</td>
						</tr>
						<tr> 
							<td class="update">备注</td>
							<td class="update" colspan="3" align="center"><textarea rows="3"
									cols="80" style="margin: 5px" maxlength="60" id="notes" name="notes"></textarea>
							</td>
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

<script>
	$(function(){
	  	  $('#frozenSTimeFrom,#frozenStimeTo,#frozenTimeFrom,#frozentimeTo').datebox({}); 
	}); 	
  	var width = $("#continer").width();
		$(function(){
			$('#test').datagrid({
				title:'账户操作记录表查询',
				iconCls:'icon-save',
				height:520,
				singleSelect:true,
				nowrap: false,
				striped: true,
				url:'accFrozenAccount/freezeAmount',
				remoteSort: false,
				idField:'ORGAN_ID',
				columns:[[
                    {field:'BUSINESS_ACTOR_ID',title:'业务参与号',width:130,align:'center'},
                    {field:'ACCT_CODE_NAME',title:'账户名称',width:180,align:'center'},
                    {field:'ACCT_CODE',title:'账户号',width:180,align:'center'},
                    {field:'CURRENT_STATUS',title:'当前状态',width:110,align:'center',
                    	formatter: function(value, rec) {
        	                if (value == "00") {
        	                    return "正常";
        	                } else if (value == "11") {
        	                    return "冻结";
        	                }else if (value == "-0") {
        	                    return "解止出";
        	                } else if (value == "0-") {
        	                    return "解止入";
        	                }else if (value == "10") {
        	                    return "止入";
        	                } else if (value == "01") {
        	                    return "止出";
        	                } else if (value == "99") {
        	                    return "注销";
        	                }
        	            }
        	        },
                    {field:'TARGET_STATUS',title:'目标状态',width:110,align:'center',
        	        	formatter: function(value, rec) {
        	        		 if (value == "00") {
         	                    return "正常";
         	                } else if (value == "11") {
         	                    return "冻结";
         	                }else if (value == "-0") {
         	                    return "解止出";
         	                } else if (value == "0-") {
         	                    return "解止入";
         	                }else if (value == "1-") {
         	                    return "止入";
         	                } else if (value == "-1") {
         	                    return "止出";
         	                } else if (value == "99") {
         	                    return "注销";
         	                }
        	            }
        	        },
                    {field:'STATUS',title:'记录状态',width:110,align:'center',
        	        	formatter: function(value, rec) {
       	        		 if (value == "20") {
        	                    return "待审核";
        	                } else if (value == "10") {
        	                    return "待审核";
        	                }else if (value == "00") {
        	                    return "已成功";
        	                } 
	       	            }
	       	        },
					{field:'TID',title:'操作',width:200,align:'center',
						formatter:function(value,rec){
							if(rec.STATUS=="10" || rec.STATUS=="20" ){
								return '<a href="javascript:showUpdate(\''+rec.TID+'\')" style="color:blue;margin-left:10px">审核</a>';
							}else{
					          return '';
							}
						}
					}
				]],
				pagination:true,
				rownumbers:true
			});
		});
	
		function search(){
			var data={ 'acctCode':$("#acctCode").val()};
			$('#test').datagrid('load',data);
		}
		
		function resize(){
			$('#theForm :input').val('');
		}
		
		function closeAdd() {
		    $('#w').window('close');
		}
		
		function showUpdate(value) {
		    $.ajax({
	            type: "POST",
	            url: "accFrozenAccount/findFrozeById?id="+value,
	            dataType: "json",
	            success: function(json) {
			    	$.each(json, function(key,value){
			    		$("#acc_id").val(value.TID);
			    		var status = value.TARGET_STATUS;
			    		var statusValue;
			    		if (status == "00") {
     	                    statusValue ="正常";
     	                } else if (status == "11") {
     	                    statusValue ="冻结";
     	                }else if (status == "-0") {
     	                    statusValue ="解止出";
     	                } else if (status == "0-") {
     	                    statusValue ="解止入";
     	                }else if (status == "1-") {
     	                    statusValue ="止入";
     	                } else if (status == "-1") {
     	                    statusValue ="止出";
     	                } else if (status == "99") {
     	                    statusValue ="注销";
     	                }
		       		 	$("#memberId").html(statusValue);    		 
		    		 	$("#b_acctCode").html(value.ACCT_CODE);	
					}) 
	            }
	        }); 
		    $('#w').window({
		        title: '操作审核',
		        top: 90,
		        left: 100,
		        width: 740,
		        modal: true,
		        minimizable: false,
		        collapsible: false,
		        maximizable: false,
		        shadow: false,
		        closed: false,
		        height: 320
		    });
		    $("#saveForm").attr("action", "accFrozenAccount/auditAccFrozen");
		}
			
		function merchAudit(result) {
// 			$("#button_ins1").linkbutton('disable');
// 			$("#button_ins3").linkbutton('disable');
			var tId = $("#acc_id").val();
			var stexaOpt = $("#STOPINION").val();
			$.ajax({
				type: "POST",
				url: "accFrozenAccount/auditAccFrozen",
				data: {"cvlexaOpt":stexaOpt,"isagree":result,"tId":tId},
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
// 			    		$("#button_ins1").linkbutton('enable');
// 						$("#button_ins3").linkbutton('enable');		
					}) 
				}
			});
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
