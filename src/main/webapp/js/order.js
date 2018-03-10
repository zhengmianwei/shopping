function initOrder() {
	datagridOrder();
	btnQuery();
	btnRemove();
	btnSave();
	btnEdit();
	orderOpen();
	btnClean();
}

/**
 * 保存订单信息
 */
function btnSave() {
	$("#btnSave").bind("click", function() {
		$("#orderForm").form("clear");
		$("#orderOpen").dialog("open").dialog("setTitle", "添加订单信息");
		url = "/order/save";
	});
}
/**
 * 删除订单数据
 */
function btnRemove() {
	$("#btnRemove").bind("click", function() {
		var selectedRow = $("#orderGrid").datagrid("getSelections");
		var id = "";
		if(selectedRow.length < 1) {
			$.messager.alert("提示", "请选择需要删除的订单", "error");
		} else {
			for(var i = 0; i < selectedRow.length; i++) {
				if(i != selectedRow.length-1) {
					id = id + selectedRow[i].id + ","
				} else {
					id = id + selectedRow[i].id;
				}
			}
			$.messager.confirm("提示", "确认需要删除选择的订单", function(r) {
				if(r) {
					$.post("/order/remove", {"id" : id}, function(data){
						if(data == "true") {
							$.messager.alert("提示", "数据删除成功", "info");
							$("#orderGrid").datagrid("reload");
							$("#orderGrid").datagrid("clearSelections");
						}else{
							$.messager.alert("提示", "数据删除失败", "error");
						}
					},"text");
				}
			})
		}
	});
}

/**
 * 编辑
 */
function btnEdit() {
	$("#btnEdit").bind("click", function() {
		var selectedRow = $("#orderGrid").datagrid("getSelections");
		if(selectedRow.length < 1) {
			$.messager.alert("提示", "请选择需要编辑的订单", "error");
		} else if(selectedRow.length >1) {
			$.messager.alert("提示", "每次只能编辑一条数据", "error");
		} else {
			var orderJsonData = selectedRow[0];
			$("#orderForm").form("clear");
			$("#orderForm").form('load', {
				orderNo : orderJsonData.orderNo,
				goodsNo : orderJsonData.goodsNo,
				goodsPrice : orderJsonData.goodsPrice,
				goodsNumber : orderJsonData.goodsNumber
			});
			$("#orderOpen").dialog("open").dialog("setTitle", "编辑订单信息");
			url = "/order/modify?id="+orderJsonData.id;
		}
	});
}
/**
 * 订单对话框
 */
function orderOpen() {
	$("#orderOpen").dialog({
		width : "400",
		height : "300",
		top : "60",
		buttons : [{
			text : "保存",
			iconCls : "icon-save",
			handler : function() {
				$("#orderForm").form("submit", {
					url : url,
					onSubmit : function() {
						return $(this).form("validate");
					},
					success : function(result) {
						if(result == 1) {
							$.messager.alert("提示", "保存成功", "info");
							$("#orderGrid").datagrid("reload");
							$("#orderOpen").dialog("close");
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
				$("orderOpen").dialog("close");
			}
		}]
	});
}
/**
 * 查询订单
 */
function btnQuery() {
	$("#btnQuery").bind("click", function(){
		var orderNo = $("#orderNo").val();
		var goodsNo = $("#goodsNo").val();
		$("#orderGrid").datagrid("load", {
			"orderNo" : orderNo
		});
	});
}

/**
 * 重置查询
 */
function btnClean() {
	$("#btnClean").bind("click", function() {
		$("#orderNo").textbox("setValue", "");
		$("#goodsNo").textbox("setValue", "");
	});
}

function datagridOrder() {
	$("#orderGrid").datagrid({
		url : '/order/queryList',
		method : 'post',
		width : '100%',
		height : $(this).height(),
		rownumbers : true,
		columns : [[
		            {field : 'id'},
		            {field : 'ck', checkbox : 'true'},
		            {field : 'orderNo', title : '订单号', width : 100},
		            {field : 'goodsNo', title : '商品号', width : 100},
		            {field : 'goodsPrice', title : '商品价格', width : 100},
		            {field : 'goodsNumber', title : '商品数量', width : 100}
		]],
		singleSelect : false,
		fitColumns : true,
		pagination : true,
		pageList : [2, 20, 50, 100],
		toolbar : "#toolbar"
	});
	$("#orderGrid").datagrid('hideColumn', 'id'); // 隐藏id
}