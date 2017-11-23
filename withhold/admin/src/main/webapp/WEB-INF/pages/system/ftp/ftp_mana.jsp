<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../../top.jsp"></jsp:include>
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
	
		<div style="margin-top: 5px">
			<table id="bankList">
			<input type="hidden" id="folder_"/>
			<input type="hidden" id="file_"/>
			</table>
		</div>
	</div>
	
	
	<div id="w2" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 10px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<form id="saveForm" action="paytongContract/auditContract" method="post">
					<TABLE id=FILETABLE style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px;  BORDER-BOTTOM-WIDTH: 0px;  WIDTH: 100%;  FONT-STYLE: normal;  BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none">
							<TBODY>
									<TR style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
										<TD >文件名称</TD>
										<TD>操作</TD>
									</TR>
							</TBODY>
					</TABLE>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeW2()">返回</a>
			</div>
		</div>
	</div>
	<div id="w3" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 10px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<form id="saveForm" action="paytongContract/auditContract" method="post">
					<TABLE id=w3table style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px;  BORDER-BOTTOM-WIDTH: 0px;  WIDTH: 100%;  FONT-STYLE: normal;  BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none">
							<TBODY>
									<TR style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
										<TD >文件名称</TD>
										<TD>操作</TD>
									</TR>
							</TBODY>
					</TABLE>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeW3()">返回</a>
			</div>
		</div>
	</div>
	
</body>
<script>
  
		$(function(){
		
			
			$('#bankList').datagrid({
				title:'文件夹列表',
				iconCls:'icon-save',
				height:800,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'ftp/query',
				remoteSort: false,
				columns:[[
					{field:'folder',title:'文件夹名称',align:'center',width:200},
					{field:'status',title:'操作',align:'center',width:260,rowspan:2,
						formatter:function(value,rec){
							if(rec.status="00"){
								return '<a href="javascript:findByNow(\''+rec.folder+'\')" style="color:blue;margin-left:10px">下载实时日志</a>'+
								'<a href="javascript:findByHistory(\''+rec.folder+'\')" style="color:blue;margin-left:10px">下载历史日志</a>'
								;
							}else{
								return "";
							}
						}}
					]],
			
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function closeW2(){
			$('#w2').window('close');
		}	
		function closeW3(){
			$('#w3').window('close');
	
		}
		
		function downfile(){
			var foldername=$("#folder_").val();
			var filen=$("#file_").val();
			alert(filen);
			alert(foldername);
			$.messager.confirm('提示', '您是否想要下载此文件', function(msg){
				if(msg){
					document.getElementById("realfile").href="ftp/downloadFile?fileName="+foldername+"/"+filen;
				/* 	$.ajax({
						type: "POST",
						url: "ftp/downloadFile",
						data: {'withdrawopt':msg,'fileName':fileName},
						dataType: "json",
						success: function(json) {
							if(json.RET == "succ"){
			    				$.messager.alert('提示',"下载成功!");
					    		//close();
					    	}else{
					    		$.messager.alert('提示',"下载失败"); 
					    		//closeAdd();
					    	}
						}
					}); */
				}
            });
		}
		function downhisfile(fileName){
			$.messager.confirm('提示', '您是否想要下载此文件', function(msg){
				if(msg){
					document.getElementById("historyfile").href="ftp/downloadFile?fileName="+fileName;
				}
            });
		}	
		function findByNow(folder){
			$("#folder_").val(folder);
			$("#FILETABLE").html("");
			$.ajax({
			   type: "POST",
			   url: "ftp/getFilesNow",
			   data: "folder="+folder,
			   dataType:"json",
			   success: function(data){
				   var $tr = '';
				   $.each(data,function(i,n){
						if(n.fileName.indexOf(".log") > 0){
							$tr+= "<tr>"+"<td>"+n.fileName+"</td>"+"<td><a id='realfile' href='ftp/downloadFile?fileName="+folder+"/"+n.fileName+"'  style=color:blue;margin-left:10px"+">点击下载</a>"+"</td>"+"</tr>";
							$("#file_").val(n.fileName);
		              		 //$tr+= "<tr>"+"<td>"+n.fileName+"</td>"+"<td><a id='realfile' href=javascript:downfile('"+folder+"/"+n.fileName+"') style=color:blue;margin-left:10px"+">点击下载</a>"+"</td>"+"</tr>";
						}/* else{
							 $tr+= "<tr>"+"<td>"+n.fileName+"</td>"+"<td><a href=javascript:showAllfiles(\'"+folder+"/"+n.fileName+"\') style=color:blue;margin-left:10px"+">查看</a>"+"</td>"+"</tr>";
						}
 */				   })
				   
				   $("#FILETABLE").html($tr);
				}
			});
			$('#w2').window({
				title: '文件详情',
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
		function findByHistory(folder){
			$("#w3table").html("");
			$.ajax({
				   type: "POST",
				   url: "ftp/getFilesHistory",
				   data: "folder="+folder,
				   dataType:"json",
				   success: function(data){
					   var $tr = '';
					   $.each(data,function(i,n){
						   $tr+= "<tr>"+"<td>"+n.fileName+"</td>"+"<td><a id='historyfile' href='ftp/downloadFile?fileName="+folder+"/"+n.fileName+"' style=color:blue;margin-left:10px"+">点击下载</a>"+"</td>"+"</tr>";
					   })
					   $("#w3table").html($tr);
					   }
				   });
			$('#w3').window({
				title: '文件详情',
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
	
	</script>
</html>
