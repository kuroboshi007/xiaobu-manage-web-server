$(function(){
	$('#userOneselfForm').validate();
	$('#userPasswordForm').validate();
	
	// 日期
	$('#userOneselfForm .datepicker').datetimepicker({
		language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayBtn: true,
		clearBtn:true,
		minView: 2
	}).on('changeDate', function(event){
		
		$('#userOneselfForm').validate().element($(this));
	});
});

function showUserOneselfModal(){
	
	$('#userOneselfForm').validateReset();
	$('#userOneselfModal').modal('show');
}

function saveUserOneself(){
	
	if($('#userOneselfForm').valid()){
		
		$.ajax({
			type: 'post',
			url: '/sysUser/updateByOneself',
			data: $('#userOneselfForm').serialize(),
			dataType: 'json',
			success: function(response){
				
				$('#userOneselfModal').modal('hide');
				modalAlert(response.message);
			}
		});
	}
	
}

function showUserPasswordModal(){
	
	$('#userPasswordForm').validateReset();
	$('#userPasswordModal').modal('show');
}

function saveUserPassword(){
	
	if($('#userPasswordForm').valid()){
		
		$.ajax({
			type: 'post',
			url: '/sysUser/updatePassword',
			data: $('#userPasswordForm').serialize(),
			dataType: 'json',
			success: function(response){
				
				$('#userPasswordModal').modal('hide');
				modalAlert(response.message + ',3秒后自动登出。');
				setTimeout(function(){
					window.location.href = '/login/logout';
				},3000);
			}
		});
	}
}