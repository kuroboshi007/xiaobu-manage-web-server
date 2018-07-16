$(function(){
	// validate验证
	$('#sysRoleForm').validate();
});

// 保存
function save(){
	var nodes = $.fn.zTree.getZTreeObj("menuTree").getCheckedNodes(true);
	var menuIds = '';
	for(var i = 0; i < nodes.length; i++){
		menuIds += nodes[i].id + ',';
	}
	$('#menuIds').val(menuIds);
	
	saveByAjax('sysRoleForm','/sysRole/save','/sysRole/init');
}