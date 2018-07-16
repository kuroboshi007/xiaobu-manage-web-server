$(function(){
	$('#sysOrgForm').validate();
});

//显示弹窗
function showOrg(){
	
	var setting = {
		view: {
			showIcon: false,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};
	
	// 加载组织的树状结构
	$.ajax({
		type: 'post',
		url: '/sysOrg/getOrgForTree',
		data: {currentId:$('#id').val()},
		dataType: 'json',
		success: function(response){
			$.fn.zTree.init($("#orgTree"), setting, response.data);
		}
	});
	$('#orgModal').modal('show');
}

// 保存上级组织
function saveParentOrg(){
	var nodes = $.fn.zTree.getZTreeObj("orgTree").getSelectedNodes();
	
	if(nodes.length > 0){
		
		if(nodes[0].id != $('#id').val()){
			$('#parentId').val(nodes[0].id);
			$('#parentName').val(nodes[0].name);
			// 隐藏弹窗
			$('#orgModal').modal('hide');
		}
		else{
			modalAlert('不能选择当前组织');
		}
	}
	else{
		
		modalAlert('请选择组织');
	}
}

// 清空上级组织
function clearParentOrg(){
	$('#parentId').val('');
	$('#parentName').val('');
}

// 保存
function save(){
	
	saveByAjax('sysOrgForm','/sysOrg/save','/sysOrg/init');
}