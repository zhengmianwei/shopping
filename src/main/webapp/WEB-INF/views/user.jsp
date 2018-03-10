<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<script type="text/javascript" src="/js/user.js"></script>
<script type="text/javascript">
	$(function() {
		initUser(); // 初始化数据
		btnUserRole(); //分配用户角色权限
		userRoleOpen(); //分配用户角色权限对话框
	});
</script>
</head>
<body class="easyui-layout">
	<!-- 按钮 -->
	<div id="toolbar" style="height:auto">
		<div>
			<label>用户名</label>
			<input class="easyui-textbox" name="username" id="username" />
			<a href="javascript:void(0);" class="easyui-linkbutton" 
				iconCls="icon-search" plain="false" id="btnQuery">查询</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" 
				iconCls="icon-remove" plain="false" id="clearQuery">重置</a>
		</div>
		<div>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" id="btnAdd">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" plain="true" id="btnEnable">启用</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" plain="true" id="btnDisable">禁用</a>
			<a href="javasciprt:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" id="btnRemove">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" 
				iconCls="icon-edit" plain="true" id="btnEdit">修改</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" plain="true" id="btnUserRole" onclick="givePower()">分配权限</a>
		</div>
	</div>
	<table id="userGrid" style="width:100%; height:650px;">
	</table>
	<!-- 保存用户信息 -->
	<div id="userOpen" class="easyui-dialog" closed="true"
		style="width:400px; height: 280px; padding:10px 20px">
		<form id="userForm" method="post">
			<div class="fitem">
				<label>用户名:</label>
				<input class="easyui-textbox" name="username" required="true" 
					missingMessage="请输入用户名" validType="length[1,16]" 
					invalidMessage="用户名必须为1到16位" />
			</div>
			<div class="fitem">
				<label>密码:&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input class="easyui-textbox" name="password" required="true"
					missingMessager="请输入密码" validType="length[1,16]"
					invalidMessager="密码必须为1到16位" />
			</div>
		</form>
	</div>
	<!-- 分配用户角色权限对话框 -->
	<div id="userRoleOpen" class="easyui-dialog" closed="true"
		style="width:400px; height:300; padding:10px 20px">
		<form id="userRoleForm" method="post">
			<table>
				<ul id="mytree"></ul>
			</table>
		</form>
	</div>
</body>
</html>




























