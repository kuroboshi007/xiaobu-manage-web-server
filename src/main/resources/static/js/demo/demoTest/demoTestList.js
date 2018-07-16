$(function(){
	var dataTable = $("#demoTestDataTable").DataTable({
		"ajax": {
			"url": '/demoTest/list',
			"data": function(data){
				data.name = $("#name").val();
				data.age = $("#age").val();
				data.birthdayStart = $("#birthdayStart").val();
				data.birthdayEnd = $("#birthdayEnd").val();
			}
		},
		"ordering": false,
		"columns": [
			{
				"data": "demoId",
				"className": "text-center sign-col",
				"render": function(data, type, row, meta){
					
					return '<input type="checkbox" name="pk" value="' + data + '" onclick="checkOne()"/>';
				}
			},
			{"data": "name"},
			{"data": "age"},
			{
				"data": function(obj){
					
					return new Date(obj.birthday).Format("yyyy-MM-dd");
				} 
			},
			{"data": "deptId"},
			{"data": "sex"},
			{
				"data": "demoId",
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
		
		$('#demoTestSearchForm')[0].reset();
		dataTable.ajax.reload();
	});
	
	$('#addBtn').click(function(){
		
		forwardPage('/demoTest/demoTest');
	});
	
	$('#delBtn').click(function(){
		
		ajaxBySelecteRows(dataTable,'/demoTest/delete','确定要删除？');
	});
	
	// 日期
	$('.datepicker').datetimepicker({
		language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayBtn: true,
		clearBtn:true,
		minView: 2
	});
});

function edit(demoId){
	
	forwardPage('/demoTest/demoTest?demoId='+demoId);
}

function view(demoId){
	
	forwardPage('/demoTest/view?demoId='+demoId);
}