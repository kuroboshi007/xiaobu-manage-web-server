$(function(){
	var dataTable = $("#sysDictionaryDataTable").DataTable({
		"ajax": {
			"url": '/sysDictionary/list',
			"data": function(data){
				data.code = $("#code").val();
				data.name = $("#name").val();
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
			{"data": "code"},
			{"data": "name"},
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
		
		$('#sysDictionarySearchForm')[0].reset();
		dataTable.ajax.reload();
	});
	
	$('#addBtn').click(function(){
		
		forwardPage('/sysDictionary/sysDictionary');
	});
	
	$('#delBtn').click(function(){
		
		ajaxBySelecteRows(dataTable,'/sysDictionary/delete','确定要删除？');
	});
});

function edit(id){
	
	forwardPage('/sysDictionary/sysDictionary?id='+id);
}

function view(id){
	
	forwardPage('/sysDictionary/view?id='+id);
}