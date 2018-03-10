/**
 * 初始化数据
 */
function initRole() {
	addRole(); // 添加角色信息
	removeRole(); // 删除角色信息
	findRole(); // 查询角色信息
	roleEnable(); // 启用角色功能
	roleDisable(); // 禁用角色功能
	roleOpen(); // 角色对话框
	datagridRole(); // 权限列表数据加载
	updateRole(); // 修改角色信息
	bindingOpen(); // 分配权限对话框
	binding(); // 绑定权限
}

/**
 * 分配权限
 */
function bindingOpen() {
	$("#btnRole").bind("click", function() {
		var selectedRow = $("#roleGrid").datagrid("getSelections");
		if(selectedRow.length <= 0) {
			$.messager.alert("提示", "请选需要分配权限的角色", "error");
		}else {
			var roleJsonData = selectedRow[0];
			$("#bindingForm").form("clear");
			$("#bindingForm").form("load",{
				roleId : roleJsonData.id
			});
			$("#binding").dialog("open").dialog("setTitle", "分配角色权限");
		}
	});
}

/**
 * 绑定角色对话框
 */
function binding() {
	 $("#binding").dialog({
		width : "400",
		height : "300",
		top : "60",
		buttons : [{
			text : "保存",
			iconCls : "icon-save",
			handler : function() {
				var selected = $("#roleGrid").datagrid('getSelected');
				var roleId = selected.id;
				var children = $('#mytree').tree('getChecked');
				var id = "";
				for(var i = 0; i <children.length; i++) {
					id = id + children[i].id + ",";
				}
				$("#bindingForm").form("submit", {
					url : "/app/mgr/bindingMenu?menuId="+id+"&roleId="+roleId+"",
					onSubmit : function() {
						return $(this).form("validate");
					},
					success : function(result) {
						if(result == "succ") {
							$.messager.alert("提示", "保存成功", "info");
							$("#binding").dialog("close");
						}else {
							$.messager.alert("提示", "保存失败", "error");
						}
					}
				});
			}
		},{
			text : "取消",
			iconCls : "icon-cancel",
			handler : function() {
				$("#binding").dialog("close");
			}
		}]
	 });
}
/**
 * 分配权限
 */
function givePower() {
	var selected = $("#roleGrid").datagrid("getSelected");
	//权限模块树
	$("#mytree").tree({
		checkbox : 'true',
		animate : 'true',
		url : '/app/mgr/findRoleMenu?roleId='+selected.id,
		onLoadSucess:function(node, data) {
			allOpen(); // 展开所有树
		},
		onSelect : function(node) {
			alert(node.text);
			id : node.id;
			checked : node.checked;
			roleId: selected.id
		}
	});
}
/**
 * 展开所有树
 */
function allOpen() {
	$("#mytree").tree('expandAll');
}
/**
 * 添加角色信息
 */
 function addRole() {
	 $("#btnAdd").bind("click", function() {
		$("#roleForm").form("clear");
		$("#roleOpen").dialog("open").dialog("setTitle", "添加角色信息");
		url = "/app/mgr/role/add";
	 });
 }
 /**
  * 删除角色信息
  */
 function removeRole() {
	 $("#btnRemove").bind("click", function() {
		var selectedRow = $("#roleGrid").datagrid("getSelections");
		var id = "";
		if (selectedRow.length <= 0) {
			$.messager.alert("提示", "请选择需要删除的角色", "error");
		} else {
			for(var i = 0; i < selectedRow.length; i ++) {
				if (i != selectedRow.length-1) {
					id = id + selectedRow[i].id + ",";
				} else {
					id = id + selectedRow[i].id;
				}
			}
			$.messager.confirm("提示", "确实需要删除选择的用户信息", function(r) {
				if(r) {
					$.post("/app/mgr/role/remove", {"id":id},function(data) {
						if (data == "succ") {
							$.messager.alert("提示", "删除成功!", "info");
							$("#roleGrid").datagrid("reload");
							$("#roleGrid").datagrid("clearSelections");
						} else {
							$.messager.alert("提示", "删除失败", "error");
						}
					}, "text");
				}
			});
		}
	 });
 }

 /**
  * 修改角色信息
  */
 function updateRole() {
	 $("#btnEdit").bind("click", function() {
		 var selectedRow = $("#roleGrid").datagrid("getSelections");
		 var row = $("#roleGrid").datagrid("getSelected");
		 if (selectedRow.length <= 0) {
			 $.messager.alert("提示", "请选择需要修改的角色信息", "error");
		 }else if(selectedRow.length > 1) {
			 $.messager.alert("提示", "一次只能修改一条角色信息", "error");
		 }else {
			var roleJsonData = selectedRow[0];
			$("#roleForm").form("clear");
			$("#roleForm").form('load',{
				roleName : roleJsonData.roleName,
				description : roleJsonData.description
			});
			$("#roleOpen").dialog("open").dialog("setTitle", "编辑角色信息");
			url = "/app/mgr/role/update?id="+row.id;
		 }
	 });
 }
 /**
  * 查询角色信息
  */
 function findRole() {
	 // 角色信息查询
	 $("#btnQuery").bind("click", function() {
		 var roleName = $("#roleName").val();
		 $("#roleGrid").datagrid("load", {
			 "roleName" : roleName
		 });
	 });
	 //清除查询
	 $("#clearQuery").bind("click", function() {
		$("input").val(""); 
	 });
 }
 /**
  * 启用角色权限
  */
 function roleEnable() {
	 $("#btnEnable").bind("click", function() {
		var selectedRow = $("#roleGrid").datagrid("getSelections");
		var id = "";
		if (selectedRow.length <= 0) {
			$.messager.alert("提示", "请选择需要启用的角色", "error");
		} else {
			for (var i = 0; i < selectedRow.length; i ++) {
				if (i != selectedRow.length-1) {
					id = id + selectedRow[i].id + ",";
				} else {
					id = id + selectedRow[i].id;
				}
			}
			$.messager.confirm("提示", "确认需要启用角色权限", function(r) {
				if(r) {
					$.post("/app/mgr/role/enable", {"id" : id}, function(data) {
						if (data == "succ") {
							$.messager.alert("提示", "启用角色权限成功!", "info");
							$("#roleGrid").datagrid("reload");
							$("#roleGrid").datagrid("clearSelections");
						} else {
							$.messager.alert("提示", "启用角色权限失败!", "error");
						}
					},"text");
				}
			});
		}
	 });
 }
 /**
  * 禁用角色权限
  */
 function roleDisable() {
	 $("#btnDisable").bind("click", function() {
		var selectedRow = $("#roleGrid").datagrid("getSelections");
		var id = "";
		if (selectedRow.length <= 0) {
			$.messager.alert("提示", "请选择需要禁用的角色", "error");
		} else {
			for (var i = 0; i < selectedRow.length; i ++) {
				if (i != selectedRow.length - 1) {
					id = id + selectedRow[i].id + ",";
				} else {
					id = id + selectedRow[i].id;
				}
			}
			$.messager.confirm("提示", "确认禁用角色权限", function(r) {
				if (r) {
					$.post("/app/mgr/role/disable", {"id":id}, function(data) {
						if (data == "succ") {
							$.messager.alert("提示", "禁用角色权限成功!", "info");
							$("#roleGrid").datagrid("reload");
							$("#roleGrid").datagrid("clearSelections");
						} else {
							$.messagr.alert("提示", "禁用角色权限失败!", "error");
						}
					}, "text");
				}
			});
		}
	 });
 }
 /**
  * 角色对话框
  */
 function roleOpen() {
	 $("#roleOpen").dialog({
		 width : "400",
		 height : "300",
		 top : "60",
		 buttons : [{
			 text : "保存",
			 iconCls : "icon-save",
			 handler : function() {
				 $("#roleForm").form("submit", {
					 url : url,
					 onSubmit : function() {
						 return $(this).form("validate");
					 },
					 success : function(result) {
						 if (result == "succ") {
							 $.messager.alert("提示", "操作成功", "info");
							 $("#roleGrid").datagrid("reload");
							 $("#roleOpen").dialog("close");
						 } else {
							 $.messager.alert("提示", "操作失败", "error");
						 }
					 }
				 });
			 }
		 },{
			 text : "取消",
			 iconCls : "icon-cancel",
			 handler : function() {
				 $("#roleOpen").dialog("close");
			 }
		 }]
	 });
 }
 
 /**
  * 角色列表数据表格管理
  */
 function datagridRole() {
	 $("#roleGrid").datagrid({
		url : "/app/mgr/role/list",
		method : 'post',
		width : '100%',
		height : $(this).height(),
		rownumbers : true,
		columns : [[
		            {field : 'id'},
		            {field : 'ck', checkbox : 'trie'},
		            {field : 'roleName', title : '角色名称', width:100},
		            {field : 'description', title : '角色描述', width:100},
		            {field : 'enbale', title : '状态', width:100},
		            {field : 'createTime', title : '创建时间', width:100}
		]],
		singleSelect : false,
		fitColumns : true,
		pagination : true,
		pageList : [20,50,100,200],
		toolbar : "#toolbar"
	 });
	 $('#roleGrid').datagrid('hideColumn', 'id'); //隐藏id值
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 