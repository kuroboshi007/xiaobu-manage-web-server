$(function(){
	var dataTable = $("#sysUserDataTable").DataTable({
		"ajax": {
			"url": '/sysUser/list',
			"data": function(data){
				data.username = $("#username").val();
				data.name = $("#name").val();
				data.phone = $("#phone").val();
			}
		},
		"ordering": false,
		"columns": [
			{
				"data": "id",
				"className": "text-center sign-col",
				"render": function(data, type, row, meta){
					
					return '<input type="checkbox" name="pk" value="' + data + '" onclick="checkOne()"/>';
				}
			},
			{"data": "username"},
			{"data": "name"},
			{"data": "orgName"},
			{"data": "phone"},
			{"data": "email"},
			{
				"data": "id",
				"className": "operate-col",
				"render": function(data, type, row, meta){
					
					var html = '<button type="button" onclick="edit(\''+ data +'\')" class="btn btn-sm btn-warning right-5">'
						+ '<em class="fa fa-edit"></em>'
						+ '</button>'
						+ '<button type="button" onclick="view(\''+ data +'\')" class="btn btn-sm btn-info">'
                    	+ '<em class="fa fa-search"></em>'
                    	+ '</button>';
					return html;
				}
			}
		]
	});
	
	$('#searchBtn').click(function(){
		
		dataTable.ajax.reload();
	});
	
	$('#resetBtn').click(function(){
		
		$('#sysUserSearchForm')[0].reset();
		dataTable.ajax.reload();
	});
	
	$('#addBtn').click(function(){
		
		forwardPage('/sysUser/sysUser');
	});
	
	$('#resetPwdBtn').click(function(){
		
		ajaxBySelecteRows(dataTable,'/sysUser/resetPwd','确定要重置密码？');
	});
	
	$('#delBtn').click(function(){
		
		ajaxBySelecteRows(dataTable,'/sysUser/delete','确定要删除？');
	});
});

function edit(id){
	
	forwardPage('/sysUser/sysUser?id='+id);
}

function view(id){
	
	forwardPage('/sysUser/view?id='+id);
}