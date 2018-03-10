<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色信息管理</title>
<script type="text/javascript" src="/js/role.js"></script>
<script type="text/javascript">
	$(function() {
		initRole(); // 初始化数据
	});
</script>
</head>
<body class="easyui-layout">
	<div id="toolbar" style="height:auto">
		<div>
			<label>角色名称</label>
			<input class="easyui-textbox" id="roleName" name="roleName" />
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" plain="false" id="btnQuery">查询</a>
			<a href="javacript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="false" id="clearQuery">重置</a>
		</div>
		<div>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" id="btnAdd">添加</a>
			<a href="javacript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" id="btnEdit">修改</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" 
				iconCls="icon-remove" plain="true" id="btnRemove">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" 
				iconCls="icon-ok" plain="true" id="btnEnable">启用</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" plain="true" id="btnDisable">禁用</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-back" plain="true"  id="btnRole" onclick="givePower();">分配权限</a>
		</div>
	</div>
	<table id="roleGrid" style="width:100%; height:650px;">
	</table>
	<!-- 保存角色信息 -->
	<div id="roleOpen" class="easyui-dialog" closed="true"
		style="width:1080px; height:1280; padding:20px 30px">
		<form id="roleForm" method="post">
			<div class="fitem">
				<label>角色名称:</label>
				<input class="easyui-textbox" id="roleName" name="roleName" 
					required="true" missingMessage="请输入角色名称" validType="length[1,16]"
					invalidMessage="角色名称必须为1到16位" />
			</div>
			<div class="fitem">
				<label>角色描述:</label>
				<input class="easyui-textbox" id="description" name="description"
					required="true" missingMessage="请输入角色描述" validType="length[1,16]"
					invalidMessager="角色描述必须位1到16位" />
			</div>
		</form>
	</div>
	<!-- 分配权限对话框 -->
	<div id="binding" class="easyui-dialog" closed="true" 
		style="width:400px; height:280px; padding:10px 20px">
		<form id="bindingForm" method="post">
			<ul class="easyui-tree" id="mytree"></ul>
		</form>
	</div>
</body>
</html>





















