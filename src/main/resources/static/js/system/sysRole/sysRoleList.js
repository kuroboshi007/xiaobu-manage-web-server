$(function(){
	var dataTable = $("#sysRoleDataTable").DataTable({
		"ajax": {
			"url": '/sysRole/list',
			"data": function(data){
				data.roleName = $("#roleName").val();
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
			{"data": "roleCode"},
			{"data": "roleName"},
			{"data": "description"},
			{
				"data": "id",
				"className": "operate-col",
				"render": function(data, type, row, meta){
					
					var html = '<button type="button" onclick="edit(\''+ data +'\')" class="btn btn-sm btn-warning right-5">'
						+ '<em class="fa fa-edit"></em>'
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
		
		$('#sysRoleSearchForm')[0].reset();
		dataTable.ajax.reload();
	});
	
	$('#addBtn').click(function(){
		
		forwardPage('/sysRole/sysRole');
	});
	
	$('#delBtn').click(function(){
		
		ajaxBySelecteRows(dataTable,'/sysRole/delete','确定要删除？');
	});
});

function edit(id){
	
	forwardPage('/sysRole/sysRole?id='+id);
}