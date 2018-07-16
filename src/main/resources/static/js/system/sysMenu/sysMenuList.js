$(function(){
	$('#treetable').treeTable({
		theme: 'default',
		beforeExpand: function($treeTable, id){
			
			//判断id是否已经有了孩子节点，如果有了就不再加载，这样就可以起到缓存的作用
			if ($('.' + id, $treeTable).length) { return; }
			$.ajax({
				type: 'post',
				url: '/sysMenu/treeTable',
				data: {parentId:id},
				dataType: 'json',
				success: function(response){
					var data = response.data;
					var rows = '';
					for(var i = 0; i < data.length; i++){
						var hasChild = '';
						if(data[i].childNum > 0){
							hasChild = 'hasChild="true"';
						}
						rows += '<tr id="'+data[i].id+'" pId="'+data[i].parentId+'" '+hasChild+'>\n'
							+ '<td><span controller="true">'+data[i].menuName+'</span></td>\n'
							+	'<td>'+data[i].menuUrl+'</td>\n'
							+	'<td>\n'
							+	'<button type="button" onclick="edit(\''+data[i].id+'\')" class="btn btn-sm btn-warning right-5">\n'
							+	'<em class="fa fa-edit"></em>\n</button>\n'
							+	'<button type="button" onclick="remove(\''+data[i].id+'\')" class="btn btn-sm btn-danger">\n'
							+	'<em class="fa fa-trash-o"></em>\n</button>\n'
							+	'</td>\n'
							+	'</tr>\n';
					}
					
					$treeTable.addChilds(rows);
				}
			});
		}
	});
	
	$('#addBtn').click(function(){
		
		forwardPage('/sysMenu/sysMenu');
	});
});

function edit(id){
	
	forwardPage('/sysMenu/sysMenu?id='+id);
}

function remove(id){
	
	modalConfirm("确定要删除？").on(function(result){
		
		if(result){
		
			$.ajax({
				type: 'post',
				url: '/sysMenu/delete',
				data: {id:id},
				dataType: 'json',
				success: function(response){
					
					forwardPage('/sysMenu/init');
					modalAlert(response.message);
				}
			});
		}
	});
}