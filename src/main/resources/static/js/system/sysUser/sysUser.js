$(function(){
	// validate验证
	$('#sysUserForm').validate({
		rules: {
			phone: {
				phone: true
			},
			email: {
				email: true
			}
		}
	});
	
	// 角色
	$('#roleId').select2({
		allowClear:true
	}).change(function(){
		
		$('#sysUserForm').validate().element($('#roleId'));
	});
	
	// 日期
	$('#sysUserForm .datepicker').datetimepicker({
		language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayBtn: true,
		clearBtn:true,
		minView: 2
	}).on('changeDate', function(event){
		
		$('#sysUserForm').validate().element($(this));
	});
});

var setting = {
	view: {
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable: true
		}
	}
};

// 显示弹窗
function showOrg(){
	// 加载组织的树状结构
	$.ajax({
		type: 'post',
		url: '/sysOrg/getOrgForTree',
		dataType: 'json',
		success: function(response){
			$.fn.zTree.init($("#orgTree"), setting, response.data);
		}
	});
	$('#orgModal').modal('show');
}
// 保存组织
function saveParentOrg(){
	var nodes = $.fn.zTree.getZTreeObj("orgTree").getSelectedNodes();
	
	if(nodes && nodes.length > 0){
		
		$('#orgId').val(nodes[0].id);
		$('#orgName').val(nodes[0].name);
		// 重新验证
		$('#sysUserForm').validate().element($('#orgName'));
		// 隐藏弹窗
		$('#orgModal').modal('hide');
	} else {
		
		modalAlert('请选择组织');
	}
}
// 保存
function save(){
	
	if($('#sysUserForm').valid()){
		
		var roleIds = '';
		$('#roleId option:selected').each(function(i){
			roleIds += $(this).val() + ',';
		});
		$('#roleIds').val(roleIds);
		
		var formData = new FormData($('#sysUserForm')[0]);
		$.ajax({
			type: 'post',
			url: '/sysUser/save',
			data: formData,
			async: false,  
			cache: false,  
			contentType: false,  
			processData: false, 
			dataType: 'json',
			success: function(response){
				
				forwardPage('/sysUser/init');
				modalAlert(response.message);
			}
		});
	}
}