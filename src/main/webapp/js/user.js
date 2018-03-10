/**
 * 初始化数据
 */
function initUser() {
	datagridUser(); // 用户列表数据加载
	saveUser(); // 添加用户信息
	userOpen(); // 用户对话框
	userEnable(); // 启用用户权限
	userDisable(); // 禁用用户权限
	deleteUser(); // 删除用户信息
	updateUser(); // 修改用户信息
	findUser(); // 用户查询
}
/**
 * 分配用户权限
 */
function givePower() {
	var selected = $("#userGrid").datagrid("getSelected");
	//权限树
	$("#mytree").tree({
		checkbox : 'true',
		url : '/app/mgr/findUserRole?userId='+selected.id,
		onSelect : function(node) {
			alert(node.text);
			id : node.id;
			checked : node.checked;
			roleId : node.roleId
		}
	});
}
// 分配角色权限
function btnUserRole() {
	$("#btnUserRole").bind("click", function(){
		var selectedRow = $("#userGrid").datagrid("getSelections");
		if(selectedRow.lenght <= 0) {
			$.messager.alert("提示", "请选择需要分配角色权限的用户", "error");
		}else{
			$("#userRoleForm").form("clear");
			$("#userRoleOpen").dialog("open").dialog("setTitle", "分配用户角色权限");
		}
	});
}

//构造绑定用户角色权限对话框
function userRoleOpen() {
	$("#userRoleOpen").dialog({
		width : "400",
		height : "300",
		top : "60",
		buttons : [{
			text : "保存",
			iconCls: "icon-save",
			handler : function() {
				var selected = $("#userGrid").datagrid("getSelected");
				var userId = selected.id;
				var children = $("#mytree").tree("getChildren");
				var roleId = "";
				for(var i =0; i <children.length; i++) {
					if(children[i].checked) {
						roleId = roleId + children[i].id + ","
					}
				}
				$("#userRoleForm").form("submit",{
					url : "/app/mgr/bindingUserRole?userId="+userId+"&roleId="+roleId+"",
					onSubmit : function() {
						return $(this).form("validate");
					},
					success : function(result) {
						if(result == "succ") {
							$.messager.alert("提示", "保存成功!", "info");
							$("#userGrid").datagrid("reload");
							$("#userRoleOpen").dialog("close");
						}else {
							$.messager.alert("提示", "保存失败!", "error");
						}
					}
				});
			}	
		},{
			text : "取消",
			iconCls : "icon-cancel",
			handler : function() {
				$("#userRoleOpen").dialog('close');
			}
		}]
	});
}
/**
 * 用户查询
 */
function findUser() {
	// 用户查询连接
	$("#btnQuery").bind("click", function() {
		var username = $("#username").val();
		$("#userGrid").datagrid("load", {
			"username" : username 
		});
	});
	
	//清除查询
	$("#clearQuery").bind("click", function() {
		$("input").val("");
	});
}
/**
 * 修改用户信息
 */
function updateUser() {
	$("#btnEdit").bind("click", function() {
		var selectedRow = $("#userGrid").datagrid("getSelections");
		var row = $("#userGrid").datagrid("getSelected");
		if (selectedRow.length <=0) {
			$.messager.alert("提示", "请选择需要修改的用户", "error");
		}else {
			var userJsonData = selectedRow[0];
			$("#userForm").form("clear");
			$("#userForm").form('load',{
				username : userJsonData.username,
				password : userJsonData.password
			});
			$("#userOpen").dialog("open").dialog("setTitle", "编辑用户信息");
			url = "/app/mgr/user/update?id="+row.id;
		}
	});
}
/**
 * 删除用户信息
 */
function deleteUser() {
	$("#btnRemove").bind("click", function() {
		var selectedRow = $("#userGrid").datagrid("getSelections");
		var id = "";
		if(selectedRow.length <= 0) {
			$.messager.alert("提示", "请选择需要删除的用户", "error");
		}else {
			for(var i=0; i<selectedRow.length; i++) {
				if(i !=selectedRow.length-1) {
					id = id + selectedRow[i].id + ",";
				}else {
					id = id + selectedRow[i].id;
				}
			}
			$.messager.confirm("提示", "确认需要删除选择的用户信息", function(r) {
				if(r) {
					$.post("/app/mgr/user/delete", {"id":id},function(data) {
						if (data == "succ") {
							$.messager.alert("提示", "删除成功!", "info");
							$("#userGrid").datagrid("reload");
							$("#userGrid").datagird("clearSelections");
						} else {
							$.messager.alert("提示", "删除失败", "error");
						}
					},"text");
				}
			});
		}
	});
}
/**
 * 启用用户权限
 */
function userEnable() {
	$("#btnEnable").bind("click", function() {
		var selectedRow = $("#userGrid").datagrid("getSelections");
		var id = "";
		if(selectedRow.length <=0) {
			$.messager.alert("提示", "请选择需要启用的用户", "info");
		}else{
			for(var i=0; i < selectedRow.length; i++) {
				if (i != selectedRow.length-1) {
					id = id + selectedRow[i].id + ",";
				}else{
					id = id + selectedRow[i].id;
				}
			}
			$.messager.confirm("提示", "确认需要启用用户权限?", function(r) {
				if(r) {
					$.post("/app/mgr/user/enable",{"id":id},function(data) {	
						if(data) {
							if(data == "succ") {
								$.messager.alert("提示", "启用用户权限成功", "info");
								$("#userGrid").datagrid("reload");
								$("#userGrid").datagrid("clearSelections");
							}else {
								$.messager.alert("提示", "启用用户权限失败", "error");
							}
						}
					},"text");
				}
			});
		}
	});
}
/**
 * 取消用户权限
 */
function userDisable() {
	$("#btnDisable").bind("click", function() {
		var selectedRow = $("#userGrid").datagrid("getSelections");
		var id = "";
		if (selectedRow.length <= 0) {
			$.messager.alert("提示", "请选择需要取消权限的用户", "error");
		} else {
			for (var i = 0; i<selectedRow.length; i++) {
				if (i != selectedRow.length - 1) {
					id = id + selectedRow[i].id + ",";
				} else {
					id = id + selectedRow[i].id;
				}
			}
			$.messager.confirm("提示", "确认禁止用户权限", function(r) {
				if (r) {
					$.post("/app/mgr/user/close",{"id" : id}, function(data) {
						if(data) {
							if (data == "succ") {
								$.messager.alert("提示", "禁用用户权限成功!", "info");
								$("#userGrid").datagrid("reload");
								$("#userGrid").datagrid("clearSelections");
							} else {
								$.messager.alert("提示", "禁用用户权限失败!", "error");
							}
						}
					}, "text");
				}
			});
		}
	});
}
/**
 * 添加用户信息
 */
function saveUser() {
	$("#btnAdd").bind("click", function() {
		$("#userForm").form("clear");
		$("#userOpen").dialog("open").dialog("setTitle", "添加用户信息");
		url = "/app/mgr/user/add";
	});
}
/**
 * 用户对话框
 */
function userOpen() {
	$("#userOpen").dialog({
		width : "400",
		height : "300",
		top : "60",
		buttons : [{
			text : "保存",
			iconCls : "icon-save",
			handler : function() {
				$("#userForm").form("submit", {
					url : url,
					onSubmit : function() {
						return $(this).form("validate");
					},
					success : function(result) {
						if (result == "succ") {
							$.messager.alert("提示", "保存成功", "info");
							$('#userGrid').datagrid("reload");
							$("#userOpen").dialog("close");
						} else {
							$.messager.alert("提示", "保存失败", "error");
						}
			 		}
				});
			}
		},{
			text : "取消",
			iconCls : "icon-cancel",
			handler : function() {
				$("#userOpen").dialog("close");
			}
		}]
		
	});
}
/**
 * 用户列表数据表格管理
 */
function datagridUser() {
	$("#userGrid").datagrid({
		url : '/app/mgr/user/list',
		method : 'post',
		width : '100%',
		height : $(this).height(),
		rownumbers : true,
		columns : [[
		          {field: 'id'},
		          {field: 'ck', checkbox:'true'},
		          {field: 'username', title:'用户名', width:100},
		          {field: 'password', title:'密码', width:100},
		          {field: 'enbale', title:'状态', width:100},
		          {field: 'createTime', title:'创建日期', width:100}
		]],
		singleSelect: false,
		fitColumns: true,
		pagination: true,
		pageList:[20,50,100,200],
		toolbar: "#toolbar"
	});
	$('#userGrid').datagrid('hideColumn', 'id'); // 隐藏id值
}
