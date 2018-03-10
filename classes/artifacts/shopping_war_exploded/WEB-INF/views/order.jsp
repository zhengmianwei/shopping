<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单页面</title>
<script type="text/javascript" src="/js/order.js"></script>
<script type="text/javascript">
	$(function() {
		initOrder();
	});
</script>
</head>
<body class="easyui-layout">
	<!--  -->
	<div id="toolbar" style="hegiht:auto">
		<div>
			<label>订单号</label>
			<input class="easyui-textbox" id="orderNo" name="orderNo" />
			<a href="javascript:void(0);" class="easyui-linkbutton" 
				iconCls="icon-search" plain="false" id="btnQuery">查询</a>
		
			<a href="javascript:void(0);" class="easyui-linkbutton" 
				iconCls="icon-remove" plain="false" id="btnClean">重置</a>
		</div>
		<div>
			<a href="javascript:void(0);" class="easyui-linkbutton" 
				iconCls="icon-save" plain="true" id="btnSave">添加</a>
			
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" id="btnRemove">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" id="btnEdit">编辑</a>
		</div>
	</div>
	<table id="orderGrid" style="width:100%; height:650px;">
	</table>
	
	<div id="orderOpen" class="easyui-dialog" closed="true"
		style="width:600px; height:400px; padding:10px 20px" >
		<form id="orderForm" method="post">
			<div class="fitem">
				<label>订单号&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input class="easyui-textbox" name="orderNo" id="orderNo" />
			</div>
			<div>
				<label>商品号&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input class="easyui-textbox" name="goodsNo" id="goodsNo" />
			</div>
			<div>
				<label>商品价格</label>
				<input class="easyui-textbox" name="goodsPrice" id="goodsPrice" />
			</div>
			<div>
				<label>订单数量</label>
				<input class="easyui-textbox" name="goodsNumber" id="goodsNumber" />
			</div>
		</form>
	</div>
</body>
</html>