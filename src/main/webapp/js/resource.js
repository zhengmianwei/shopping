/**
 * 初始化数据
 */
function initResource() {
	onLoadSuccess();
}

function onLoadSuccess() { // 节点默认折叠
	$("#resourceList").treegrid('collapseAll');
}