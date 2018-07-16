$(function(){
	$('#sysMenuForm').validate({
		rules: {
			sort: {
				number: true
			}
		}
	});
});

//显示弹窗
function showMenu(){
	
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
	
	// 加载菜单的树状结构
	$.ajax({
		type: 'post',
		url: '/sysMenu/getMenuForTree',
		data: {currentId:$('#id').val()},
		dataType: 'json',
		success: function(response){
			$.fn.zTree.init($("#menuTree"), setting, response.data);
		}
	});
	$('#menuModal').modal('show');
}

// 保存上级菜单
function saveParentMenu(){
	var nodes = $.fn.zTree.getZTreeObj("menuTree").getSelectedNodes();
	
	if(nodes.length > 0){
		
		if(nodes[0].id != $('#id').val()){
			$('#parentId').val(nodes[0].id);
			$('#parentName').val(nodes[0].name);
			// 隐藏弹窗
			$('#menuModal').modal('hide');
		}
		else{
			modalAlert('不能选择当前菜单');
		}
	}
	else{
		
		modalAlert('请选择菜单');
	}
}

// 清空上级菜单
function clearParentMenu(){
	$('#parentId').val('');
	$('#parentName').val('');
}

// 保存
function save(){
	
	saveByAjax('sysMenuForm','/sysMenu/save','/sysMenu/init');
}