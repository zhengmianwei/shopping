<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色模块</title>
<link rel="stylesheet" type="text/css" href="/jquery_easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/jquery_easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/jquery_easyui/demo.css">
<script type="text/javascript" src="/jquery_easyui/jquery.min.js"></script>
<script type="text/javascript" src="/jquery_easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">

	$(function(){	
		//添加权限
		$("#btnSave").bind("click", function(){
			$("#roleInfoForm").form("clear");
			$("#roleInfoOpen").dialog("open").dialog("setTitle","新增角色信息");
			url = "../saveRole.do";
		});
		//构造保存对话框
		$("#roleInfoOpen").dialog({
			width : "400",
			height: "300",
			top : "60",
			buttons : [{
				text : "保存",
				iconCls : "icon-save",
				handler : function(){
					$("#roleInfoForm").form("submit",{
						url : "../",
						onSubmit : function() {
							return $(this).form("validate");
						},
						success : function(result) {
							if(result == "succ") {
								$.messager.alert("提示", "保存成功", "info");
								$("#roleGrid").datagrid("reload");
								$("#roleInfoOpen").dialog("close");
							}else {
								$.messager.alert("提示", "保存失败", "error");
							}
						}
					});
				}
			},{
				text : "取消",
				iconCls : "icon-cancal",
				handler : function() {
					$("#roleInfoOpen").dialog("close");
				}
			}]
		});
		//删除操作
		$("#btnRemove").bind("click",function() {
			var selectedRow = $("#roleGrid").datagrid("getSelections");
			var id = "";
			if(selectedRow.length<=0) {
				$.messager.alert("提示", "请选择需要删除的角色", "error");
			}else {
				for (var i=0; i<selectedRow.length; i++){ //组成一个字符串，id用逗号隔开
					if(i!=selectedRow.length-1){
						id = id + selectedRow[i].roleId+","
					}else {
						id = id + selectedRow[i].roleId;
					}
				}
				$.messager.confirm("提示", "确认要删除选择的数据?", function(r){
					if(r) {
						$.post("../deleteRole.do", {"roleId":id},function(data){
							if(data) {
								if(data == "succ") {
									$.messager.alert("提示", "删除成功", "info");
									$("#roleGrid").datagrid("reload");
									$("#roleGrid").datagrid("clearSelections");
								}else {
									$.messager.alert("提示", "删除失败", "error");
								}
							}
						},"text");
					}
				});
			}
		});
		//修改角色信息
		$("#btnEdit").bind("click", function() {
			var selectedRow = $("#roleGrid").datagrid("getSelections");
			var row = $("#roleGrid").datagrid("getSelected");
			if(selectedRow.length<=0) {
				$.messager.alert("提示", "请选择需要修改的角色信息", "error");
			}else{
				var roleJsonData = selectedRow[0];
				$("#roleInfoForm").form("clear");
				$("#roleInfoForm").form('load',{
					roleName : roleJsonData.roleName
				});
				$("#roleInfoOpen").dialog("open").dialog("setTitle","修改角色信息");
				url = "../updateRole.do?roleId="+row.roleId;
			}
		});
		//分配权限
		$("#btnRole").bind("click", function() {
			var selectedRow = $("#roleGrid").datagrid("getSelections");
			var row = $("#roleGrid").datagrid("getSelected");
			if(selectedRow.length<=0) {
				$.messager.alert("提示", "请选择需要分配权限的角色", "error");
			}else {
				var roleJsonData = selectedRow[0];
				$("#roleForm").form("clear");
				$("#roleForm").form('load',{
					roleId : roleJsonData.roleId
				});
				$("#roleOpen").dialog("open").dialog("setTitle", "分配角色权限");
				url = "getRole.do";
			}
		});
		//构造绑定角色对话框
		$("#roleOpen").dialog({
			width : "400",
			height: "300",
			top : "60",
			buttons : [{
				text : "保存",
				iconCls : "icon-save",
				handler : function(){
					var selected = $("#roleGrid").datagrid('getSelected');
					var roleId = selected.roleId;
					var children = $('#mytree').tree('getChecked',['checked','indeterminate']);  
					var id = "";
					for(var i = 0; i<children.length;i++) {
						id = id + children[i].id + ",";
					}
					$("#roleForm").form("submit",{
						url : "../rightLimite/binding.do?modelId="+id+"&roleId="+roleId+"",
						onSubmit : function() {
							return $(this).form("validate");
						},
						success : function(result) {
							if(result == "succ") {
								$.messager.alert("提示", "保存成功", "info");
								/*$("#roleGrid").datagrid("reload");*/
								 $("#roleOpen").dialog("close"); 
							}else {
								$.messager.alert("提示", "保存失败", "error");
							}
						}
					});
				}
			},{
				text : "取消",
				iconCls : "icon-cancal",
				handler : function() {
					$("#roleOpen").dialog("close");
				}
			}]
		}); 
		
	});
	function givePower(){
		var selected = $("#roleGrid").datagrid("getSelected");
		//权限模块树
		$("#mytree").tree({
			checkbox : 'true',
			animate: 'true',
			url : '../getRole.do?roleId='+selected.roleId,
			onLoadSuccess:function(node, data){
				allOpen(); // 展开所有树
            },
			onSelect : function(node) {
				alert(node.text);
				id : node.id;
				checked : node.checked;
				roleId : selected.roleId
			}
		});
	}
	
	//展开所有树
	function allOpen() {
		$('#mytree').tree('expandAll');
	}
</script>
</head>
<body>
	<table id="roleGrid" toolbar="#toolbar" class="easyui-datagrid" title="角色信息"
		style="width:800px; height:500px"
		data-options="rownumber:true,singleSelect:true,pagination:true,
		url:'../findRole.do', method:'post'">
		<thead>
			<tr>
				<th data-options="field: 'ck', checkbox:true"></th>
				<th data-options="field: 'roleId', width:80">角色id</th>
				<th data-options="field: 'roleName', width:80">角色名称</th>
			</tr>	
		</thead>
	</table>
	<div id="toolbar" style="height:auto">
		<div>
			<a href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" id="btnSave">添加</a>
			<a href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" id="btnEdit">修改</a>
			<a href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" id="btnRemove">删除</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" 
			iconCls="icon-back" plain="true" id="btnRole" onclick="givePower();">权限分配</a>
		</div>
	</div>
	<!-- 分配权限对话框 -->
	<div id="roleOpen" class="easyui-dialog" closed="true" style="width:400px; height:280px; padding:10px 20px">
		<form id="roleForm" method="post">
			<ul class="easyui-tree" id="mytree"></ul>
		</form>
	</div>
	<!-- 保存用户对话框 -->
	<div id="roleInfoOpen" class="easyui-dialog" closed="true"
		style="width:400px; height:280px;padding:10px 20px">
		<form id="roleInfoForm" method="post">
			<table>
				<div class="fitem">
					<label>角色名称</label>
					<input name="roleName" class="easyui-textbox" required="true"
						missingMessage="请出入角色名称">
				</div>
			</table>
		</form>	
	</div>
</body>
</html>