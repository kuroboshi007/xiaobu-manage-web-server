$(function(){
	// 初始跳转到首页
	forwardPage('/home');
});

/**
 * 菜单跳转页面
 * @param obj
 * @param url
 * @returns
 */
function menuToPage(obj,url){
	
	$.ajax({
		type: 'get',
		url: url,
		dataType: 'html',
		success: function(data){
			$('.content-wrapper').html(data);
			$('.sidebar').find('li').removeClass('active');
			$(obj).parents('li').addClass('active');
		}
	});
}

/**
 * 全选
 * @param _this
 * @returns
 */
function checkAll(_this){
	
	if($(_this).is(':checked')){
		
		$('input[name=pk]').prop('checked',true);
	} else {
		
		$('input[name=pk]').prop('checked',false);
	}
}

/**
 * 全选-选中一个
 * @returns
 */
function checkOne(){
	
	var checked = true;
	
	$('input[name=pk]').each(function(i,obj){
		
		if(!$(obj).is(':checked')){
			
			checked = false;
		}
	});
	
	$('.checkAll').prop('checked',checked);
}

/**
 * 跳转页面
 * @param url
 * @returns
 */
function forwardPage(url){
	
	$.ajax({
		type: 'get',
		url: url,
		dataType: 'html',
		success: function(response){
			$('.content-wrapper').html(response);
		}
	});
}

/**
 * Datatables中根据选中的行，进行ajax操作
 * @param dataTable
 * @param url
 * @param message
 * @returns
 */
function ajaxBySelecteRows(dataTable,url,message){
	
	var selectRows = $(dataTable.table().body()).find('input[name=pk]:checked');
	
	if(selectRows && selectRows.length > 0){
		
		var ids = '';
		
		$.each(selectRows,function(i,obj){
			
			ids += ',' + $(obj).val();
		});
		layer.confirm((message), function(index){
			  //do something
			$.ajax({
				type: 'post',
				url: url,
				data: {ids:ids.substring(1)},
				dataType: 'json',
				success: function(response){
					layer.alert(response.message);
					//modalAlert(response.message);
					dataTable.ajax.reload();
					$('.checkAll').prop('checked',false);
				}
			});
		  layer.close(index);
		});
		/*if(message){
			
			modalConfirm(message).on(function(result){
				
				if(result){
				
					$.ajax({
						type: 'post',
						url: url,
						data: {ids:ids.substring(1)},
						dataType: 'json',
						success: function(response){
							
							modalAlert(response.message);
							dataTable.ajax.reload();
							$('.checkAll').prop('checked',false);
						}
					});
				}
			});
		} else {
			
			$.ajax({
				type: 'post',
				url: url,
				data: {ids:ids.substring(1)},
				dataType: 'json',
				success: function(response){
					
					modalAlert(response.message);
					dataTable.ajax.reload();
					$('.checkAll').prop('checked',false);
				}
			});
		}*/
	} else {
		
		layer.alert('请至少选择一条数据');
	}
}

/**
 * Datatables中根据选中的行，跳页操作
 * @param dataTable
 * @param url
 * @param message
 * @returns
 */
function forwardPageBySelecteRows(dataTable,url,message){
	
	var selectRows = $(dataTable.table().body()).find('input[name=pk]:checked');
	
	if(selectRows && selectRows.length > 0){
		
		var ids = '';
		
		$.each(selectRows,function(i,obj){
			
			ids += ',' + $(obj).val();
		});
		layer.confirm((message), function(index){
			  //do something
			$.ajax({
				type: 'post',
				url: url,
				data: {ids:ids.substring(1)},
				dataType: 'json',
				success: function(response){
					$('.content-wrapper').html(response);
				}
			});
		  layer.close(index);
		});
		/*if(message){
			
			modalConfirm(message).on(function(result){
				
				if(result){
				
					$.ajax({
						type: 'post',
						url: url,
						data: {ids:ids.substring(1)},
						dataType: 'html',
						success: function(response){
							
							$('.content-wrapper').html(response);
						}
					});
				}
			});
		} else {
			
			$.ajax({
				type: 'post',
				url: url,
				data: {ids:ids.substring(1)},
				dataType: 'html',
				success: function(response){
					
					$('.content-wrapper').html(response);
				}
			});
		}*/
	} else {
		
		layer.alert('请至少选择一条数据');
	}
}

/**
 * 通过ajax方式保存数据
 * @param formId form表单id
 * @param saveUrl 保存url 
 * @param backUrl 保存成功后返回url
 * @returns
 */
function saveByAjax(formId,saveUrl,backUrl){
	
	if($('#'+formId).valid()){
		$.ajax({
			type: 'post',
			url: saveUrl,
			data: $('#'+formId).serialize(),
			dataType: 'json',
			success: function(response){
				
				forwardPage(backUrl);
				layer.alert(response.message);
			}
		});
	}
}

/**
 * 重设table的order
 * @param tableId
 */
function resetTrNum(tableId) {
	
	$("#" + tableId + " tbody tr").each(function(i) {
		
		$(':input, select,a', this).each(function() {
			
			var $this = $(this), name = $this.attr('name'), val = $this.val();
			
			if (name && name.indexOf("#index#") >= 0) {
						
				$this.attr("name", name.replace('#index#', i));
			} 
			else if (name && name.indexOf("_index") >= 0) {
				
				$this.attr("name", name.replace('_index', i));
			}
			else if (name) {
				
				var s = name.indexOf("[");
				var e = name.indexOf("]");
				
				if(s >= 0 && e >= 0){
					
					$this.attr("name", name.replace(name.substring(s + 1, e), i));
				}
			}
		});
	});
}