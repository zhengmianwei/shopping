<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源文件</title>
<script type="text/javascript" src="/js/resource.js"></script>
<script type="text/javascript">
	$(function() {
		initResource(); // 初始化数据
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true, border:false">
	<div>
		<table id="resourceList" class="easyui-treegrid"
			data-options="
			url: '/app/mgr/getResourceAll',
			idField : 'id',
			treeField : 'resourceName',
			onLoadSuccess : onLoadSuccess,
			border : false">
			<thead>
				<tr>
					<th data-options="field: 'id', width:40">编号</th>
					<th data-options="field: 'resourceName', width:150">资源名称</th>
					<th data-options="field: 'resourceUrl', width:200">资源路径</th>
					<th data-options="field: 'resourceOrder', width:50">排序</th>
					<th data-options="field: 'icon', width:80">图标</th>
					<th data-options="field: 'resourceType', width:80">资源类型</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>



















