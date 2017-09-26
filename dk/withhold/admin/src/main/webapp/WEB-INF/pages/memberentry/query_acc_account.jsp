<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>

<!-- 收支明细查询 -->
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
			style="height: 90px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
				<tr>
				    <td align="center">委托机构号</td>
					<td><input name="memberId"  type="text" id="memberId" maxlength="15" onkeyup="value=value.replace(/[^\d]/g,'')" /></td>
					
<!-- 					<td align="center">账户名</td> -->
<!-- 					<td><input name="acctCodeName"  type="text" id="acctCodeName" maxlength="128"/></td> -->
					
						
<!-- 					<td></td>				 -->
<!-- 				</tr> -->
<!-- 				<tr> -->
					<td align="center">账户号</td>
					<td><input name="acctCode"  type="text" id="acctCode" maxlength="22" onkeyup="value=value.replace(/[^\d]/g,'')"/></td>
					
<!-- 					<td align="center">业务账户号</td> -->
<!-- 					<td><input name="busiCode" maxlength="32" type="text"id="busiCode" maxlength="32"/></td> -->
					
<!-- 					<td align="center">状态</td> -->
<!-- 					<td colspan="1"> -->
<!-- 						<select name="accStatus" class="easyui-validatebox validatebox-text" id="accStatus" style="width:130px"> -->
<!-- 								<option value="">请选择</option> -->
<!-- 								<option value="NORMAL">正常</option> -->
<!-- 								<option value="FREEZE">冻结</option> -->
<!-- 								<option value="STOP_IN">止入</option> -->
<!-- 								<option value="STOP_OUT">止出</option> -->
<!-- 								<option value="LOGOUT">注销</option> -->
<!-- 						</select> -->
<!-- 					</td> -->
					<td></td>
					<td></td>
					<td align="right">
					<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
					<a href="javascript:resize()" class="easyui-linkbutton"iconCls="icon-redo">清空</a></td>
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
					<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo">
						<tr style="height: 25px">
							<td align="center" width="100px">冻结账号:</td>
							<td align="left"><span id="acccode"></span> <input
								id="accId" type="hidden" name="accId"></input></td>
						</tr>

						<tr style="height: 25px">
							<td align="center" width="74px">冻结额度:</td>
							<td align="left">
							<input type="text" id="moneys" onblur="check()" name="frozenBalance"
								class="easyui-validatebox" required="true" maxlength="32" />
								<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可用额度为:&nbsp;&nbsp;<font
									id="money"></font>&nbsp;&nbsp;元 </span></td>
						</tr>
						<tr style="height: 60px">
							<td>冻结开始时间:</td>
							<td align="left" id="intime"><input id="startTime"
								type="text" name="startTime" style="width: 120PX"
								class="easyui-datetimebox" data-options="showSeconds:false"></input>
								&nbsp;&nbsp;&nbsp;&nbsp;冻结结束时间 :&nbsp;&nbsp;<input id="endTime" type="text" name="endTime"
								style="width: 120PX" class="easyui-datetimebox"
								data-options="showSeconds:false"></input></td>

						</tr>
						<tr>
							<td>备注</td>
							<td align="left" colspan="3"><textarea id="group_notes_ins"
									rows="2" cols="75" name="notes" maxlength="64"></textarea>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="div_id" region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" id="button_id" iconCls="icon-ok"
					href="javascript:saveParaDic()" onClick="">提交</a> <a
					class="easyui-linkbutton" iconCls="icon-cancel"
					href="javascript:void(0)" onClick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
	
	<div id="wt" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo"
					border="1">
					<tr>						
						<td>委托机构号</td>
						<td id="memberid"></td>
					</tr>
					<tr>
						<td>科目号</td>
						<td id="acctcode"></td>
					</tr>
					<tr>		
						<td>账户名</td>
						<td id="acctcodename"></td>
					</tr>
					<tr>
						<td>用途</td>
						<td id="usage3"></td>
					</tr>
					<tr>
						<td>账户总金额</td>
						<td id="totalbalance"></td>
					</tr>
					<tr>
						<td>可用金额</td>
						<td id="balance"></td>
					</tr>
					<tr>
						<td>冻结金额</td>
						<td id="frozenbalance"></td>
					</tr>
					<tr>
						<td>账户状态</td>
						<td id="status"></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
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
	        title: '账户信息',
	        iconCls: 'icon-save',
	        height: 520,
	        singleSelect: true,
	        nowrap: false,
	        striped: true,
	        url: 'memberAccount/queryMember',
	        remoteSort: false,
	        idField: 'ORGAN_ID',
	        columns: [[	
            {field: 'BUSINESS_ACTOR_ID',title: '委托机构号',width: 180,align: 'center'},
	        {field: 'ACCT_CODE',title: '账户号',width: 220,align: 'center'},
	        {field: 'BUSIACCT_NAME',title: '账户名',width: 180,align: 'center'},
	        {field: 'USAGE',title: '用途',width: 120,align: 'center',
	        	formatter:function(value,rec){
					if(value=="101"){
						return "现金账户";
					}else if(value=="102"){
						return "银行存款";
					}else if(value=="103"){
						return "应收银行";
					}else if(value=="104"){
						return "证联收转存款";
					}else if(value=="105"){
						return "应付银行";
					}else if(value=="106"){
						return "通道手续费支出";
					}else if(value=="107"){
						return "企业待结算";
					}else if(value=="108"){
						return "应付待分润";
					}else if(value=="109"){
						return "保证金";
					}else if(value=="110"){
						return "手续费收入";
					}else if(value=="112"){
						return "手续费账户";
					}else{
						return "";  
					}
				}
	        },
	        	
	        {field: 'TOTAL_BALANCE',title: '账户总余额(元)',width: 130,align: 'center',
				formatter:function(value,rec){
					return fenToYuan(rec.TOTAL_BALANCE);
				}
			},
	        {field: 'BALANCE',title: '可用余额(元)',width: 130,align: 'center',
				formatter:function(value,rec){
					return fenToYuan(rec.BALANCE);
				}
			},
	        {field: 'FROZEN_BALANCE',title: '冻结余额(元)',width: 130,align: 'center',
				formatter:function(value,rec){
					return fenToYuan(rec.FROZEN_BALANCE);
				}
			},
	        {field: 'STATUS',title: '账户状态',width: 100,align: 'center',
	            formatter: function(value, rec) {
	                if (value == "00") {
	                    return "正常";
	                } else if (value == "11") {
	                    return "冻结";
	                } else if (value == "10") {
	                    return "止入";
	                } else if (value == "01") {
	                    return "止出";
	                } else if (value == "99") {
	                    return "注销";
	                }
	            }
	        },
	        {field: 'ID',title: '操作',width: 250,align: 'center',
	            formatter: function(value, rec) {
// 	            	if(rec.usage == '110'){//保证金账户 BAIL：只提供冻结金额操作 
// 	            	if(rec.status == "00"){
// 	            		return '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.status + '\',2)" style="color:blue;margin-left:10px">冻结账户</a>'+'<a href="javascript:detail('+value+')" style="color:blue;margin-left:10px">详情</a>';
// 	            	}else if(rec.usage == 'BASICPAY'){
		                if (rec.STATUS == "00") {//正常
// 		                    return '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.status + '\',2)" style="color:blue;margin-left:10px">冻结</a>&nbsp;&nbsp;<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.status + '\',3)" style="color:blue;margin-left:10px">止入</a>' + '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.status + '\',5)" style="color:blue;margin-left:10px">止出</a>&nbsp;&nbsp;<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.status + '\',7)" style="color:blue;margin-left:10px">注销</a>' + '<a href="javascript:showUpdate(\'' + value + '\',\'' + rec.balance + '\',\'' + rec.acctCode + '\',\'' + rec.acctId + '\')" style="color:blue;margin-left:10px">冻结金额</a>'+'<a href="javascript:detail('+value+')" style="color:blue;margin-left:10px">详情</a>';
		                    return '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',1)" style="color:blue;margin-left:10px">冻结</a>&nbsp;&nbsp;'+
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',3)" style="color:blue;margin-left:10px">止入</a>' + 
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',5)" style="color:blue;margin-left:10px">止出</a>&nbsp;&nbsp;'+
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',7)" style="color:blue;margin-left:10px">注销</a>' + 
		                    '<a href="javascript:detail('+value+')" style="color:blue;margin-left:10px">详情</a>';
		                } else if (rec.STATUS == "11") {//冻结
		                    return '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',2)" style="color:blue;margin-left:10px">解冻</a>' + 
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',4)" style="color:blue;margin-left:10px">解止入</a>&nbsp;&nbsp;'+
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',6)" style="color:blue;margin-left:10px">解止出</a>'+
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',7)" style="color:blue;margin-left:10px">注销</a>' +
		                    '<a href="javascript:detail('+value+')" style="color:blue;margin-left:10px">详情</a>';
		                } else if (rec.STATUS == "10") {//止入
		                    return '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',4)" style="color:blue;margin-left:10px">解止入</a>&nbsp;&nbsp;'+
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',1)" style="color:blue;margin-left:10px">冻结</a>&nbsp;&nbsp;'+
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',7)" style="color:blue;margin-left:10px">注销</a>'+
		                    '<a href="javascript:detail('+value+')" style="color:blue;margin-left:10px">详情</a>' ;
		                } else if (rec.STATUS == "01") {//止出
		                    return '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',6)" style="color:blue;margin-left:10px">解止出</a>&nbsp;&nbsp;'+
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',1)" style="color:blue;margin-left:10px">冻结</a>'+
		                    '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.ACCT_CODE + '\',\'' + rec.STATUS + '\',7)" style="color:blue;margin-left:10px">注销</a>'+
		                    '<a href="javascript:detail('+value+')" style="color:blue;margin-left:10px">详情</a>'; 
		                } else {//注销状态
		                    return '<a href="javascript:detail('+value+')" style="color:blue;margin-left:10px">详情</a>';
		                }
// 	            	}else if(rec.status == "11"){
// 	            		return '<a href="javascript:deleteOrgan(\'' + value + '\',\'' + rec.status + '\',1)" style="color:blue;margin-left:10px">解冻账户</a>'+'<a href="javascript:detail('+value+')" style="color:blue;margin-left:10px">详情</a>';
// 	            	}else{
// 	            		return '<a href="javascript:detail('+value+')" style="color:blue;margin-left:10px">详情</a>';
// 	            	}
	            }
	        }
	        ]],
	        pagination: true,
	        rownumbers: true
	    });
	});

	function search() {
	    var data = {
	    	'memberId': $('#memberId').val(),
	    	'acctCodeName':$("#acctCodeName").val(),
	        'usage': $('#usage').val(),
	        'accCode': $("#acctCode").val(),
	        'busiCode': $("#busiCode").val(),  
	        'accStatus': $("#accStatus").val()	            
	    };
	    $('#test').datagrid('load', data);
	}

	function resize(){
		$('#theForm :input').val('');
	}
	
	function deleteOrgan(organId, acctCode,status, type) {
	    if (type == 1) {
	        message = '您是否想解冻此账户?';
	    } else if (type == 2) {
	        message = '您是否想冻结此账户?';
	    } else if (type == 3) {
	        message = '您是否想止入此账户?';
	    } else if (type == 4) {
	        message = '您是否想解止入此账户?';
	    } else if (type == 5) {
	        message = '您是否想止 出此账户?';
	    } else if (type == 6) {
	        message = '您是否想解止 出此账户?';
	    } else if (type == 7) {
	        message = '您是否想注销此账户?';
	    }
	    $.messager.confirm('提示', message,
	    function(r) {
	        if (r) {
	            $.ajax({
	                type: "POST",
	                url: "memberAccount/operation",
	                data: {"accId":organId,"acctCode":acctCode,"currentStatus":status,"type":type},
	                dataType: "json",
	                success: function(json) {
	                    $.messager.alert('提示',json.INFO);
	                    search();
	                    closeAdd();
	                }
	            });
	        }
	    });
	}
	
	function check() {
	    var money = $("#money").html();
	    var moneys = $("#moneys").val();
	    if (moneys - money > 0) {
	        $("#moneys").val($("#money").html())
	    }
	}

	function showUpdate(pid, money, acccode, accId) {
	    $("#saveForm").clearForm();
	    $("#money").html(money);
	    $("#acccode").html(acccode);
	    $("#accId").val(accId);
	    $('#w').window({
	        title: '冻结金额',
	        top: 90,
	        left: 100,
	        width: 640,
	        modal: true,
	        minimizable: false,
	        collapsible: false,
	        maximizable: false,
	        shadow: false,
	        closed: false,
	        height: 260
	    });
	    $("#saveForm").attr("action", "memberAccount/freezeAmount");
	}

	function saveParaDic() {
	    var date = $("#startTime").datebox('getValue');
	    var date1 = $("#endTime").datebox('getValue');
	    if (date1 < date) {
	        return alert("结束日期不能小于开始日期");
	    }
	    if ($('#saveForm').form("validate")) {
	        $("#button_id").linkbutton('disable');
	        $('#saveForm').form('submit', {
	            onSubmit: function() {
	                return $('#saveForm').form('validate');
	            },
	            success: function(messg) {
	                $.messager.alert('提示', messg);
	                search();
	                closeAdd();
	                $("#button_id").linkbutton('enable');
	            }
	        });
	    }
	}

	function closeAdd() {
	    $('#w').window('close');
	    $('#wt').window('close');
	}
	
	function detail(id){
			$('#wt').window({
				title: '详细信息',
				top:90,
				left:200,
				width:900,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 400
			});
		
       $.ajax({
            type: "POST",
            url: "memberAccount/detail?id="+id,
            dataType: "json",
            success: function(json) {
       		 $("#memberid").html(json.BUSINESS_ACTOR_ID);    		 
    		 $("#acctcode").html(json.ACCT_CODE);
    		 $("#acctcodename").html(json.ACCT_CODE_NAME);
    		 $("#totalbalance").html(fenToYuan(json.TOTALBALANCE));
    		 $("#balance").html(fenToYuan(json.BALANCE));
    		 $("#frozenbalance").html(fenToYuan(json.FROZENBALANCE));
    		 var status =json.STATUS;
    		 if(status =="00" ){
    			 $("#status").html("正常");
    		 }else if(status =="11"){
    			 $("#status").html("冻结");
    		 }else if(status =="10"){
    			 $("#status").html("止入");
    		 }else if(status =="01"){
    			 $("#status").html("止出");
    		 }else if(status =="99"){
    			 $("#status").html("注销"); 
    		 }else{
    			 $("#status").html("未知"); 
    		 }
    		 var usage1 =json.USAGE;
    		 if(usage1=="101"){
    			 $("#usage3").html("现金账户");
    		 }else if(usage1=="102"){
    			 $("#usage3").html("银行存款");
    		 }else if(usage1=="103"){
    			 $("#usage3").html("应收银行");
    		 }else if(usage1=="104"){
    			 $("#usage3").html("证联收转存款");
    		 }else if(usage1=="105"){
    			 $("#usage3").html("应付银行");
    		 }else if(usage1=="106"){
    			 $("#usage3").html("通道手续费支出");
    		 }else if(usage1=="107"){
    			 $("#usage3").html("待结算"); 
    		 }else if(usage1=="108"){
    			 $("#usage3").html("应付待分润");
    		 }else if(usage1=="109"){
    			 $("#usage3").html("保证金");
    		 }else if(usage1=="110"){
    			 $("#usage3").html("手续费收入"); 
    		 }else if(usage1=="111"){
    			 $("#usage3").html("授信"); 
    		 }else if(usage1=="111"){
    			 $("#usage3").html("手续费用户"); 
    		 }
    		 
    		 $("#groupname").html(json.GROUP_NAME);
            }
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
	</script>
</html>
